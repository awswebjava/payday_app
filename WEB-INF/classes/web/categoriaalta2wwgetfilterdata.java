package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class categoriaalta2wwgetfilterdata extends GXProcedure
{
   public categoriaalta2wwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriaalta2wwgetfilterdata.class ), "" );
   }

   public categoriaalta2wwgetfilterdata( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      categoriaalta2wwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      categoriaalta2wwgetfilterdata.this.AV26DDOName = aP0;
      categoriaalta2wwgetfilterdata.this.AV27SearchTxt = aP1;
      categoriaalta2wwgetfilterdata.this.AV28SearchTxtTo = aP2;
      categoriaalta2wwgetfilterdata.this.aP3 = aP3;
      categoriaalta2wwgetfilterdata.this.aP4 = aP4;
      categoriaalta2wwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV33EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      categoriaalta2wwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV33EmpCod = GXt_int1 ;
      GXt_int3 = AV34CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      categoriaalta2wwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV34CliCod = GXt_int3 ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoriaAlta2", GXv_boolean6) ;
      categoriaalta2wwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_CATCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCATCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_CATDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCATDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV29OptionsJson = AV16Options.toJSonString(false) ;
      AV30OptionsDescJson = AV18OptionsDesc.toJSonString(false) ;
      AV31OptionIndexesJson = AV19OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("CategoriaAlta2WWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CategoriaAlta2WWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("CategoriaAlta2WWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO") == 0 )
         {
            AV12TFCatCodigo = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO_SEL") == 0 )
         {
            AV11TFCatCodigo_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCatCodigo_Sels.fromJSonString(AV11TFCatCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV38TFCatDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV37TFCatDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFCatDescrip_Sels.fromJSonString(AV37TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV44MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCATCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCatCodigo = AV27SearchTxt ;
      AV13TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV13TFCatCodigo_Sels ,
                                           A123CatDescrip ,
                                           AV39TFCatDescrip_Sels ,
                                           Integer.valueOf(AV13TFCatCodigo_Sels.size()) ,
                                           AV12TFCatCodigo ,
                                           Integer.valueOf(AV39TFCatDescrip_Sels.size()) ,
                                           AV38TFCatDescrip ,
                                           Integer.valueOf(AV34CliCod) ,
                                           Short.valueOf(AV35PaiCod) ,
                                           AV36ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCatCodigo = GXutil.padr( GXutil.rtrim( AV12TFCatCodigo), 40, "%") ;
      lV38TFCatDescrip = GXutil.concat( GXutil.rtrim( AV38TFCatDescrip), "%", "") ;
      /* Using cursor P01HH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV34CliCod), Short.valueOf(AV35PaiCod), AV36ConveCodigo, lV12TFCatCodigo, lV38TFCatDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1HH2 = false ;
         A1565CliConvenio = P01HH2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01HH2_A1564CliPaiConve[0] ;
         A3CliCod = P01HH2_A3CliCod[0] ;
         A8CatCodigo = P01HH2_A8CatCodigo[0] ;
         A123CatDescrip = P01HH2_A123CatDescrip[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01HH2_A3CliCod[0] == A3CliCod ) && ( P01HH2_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01HH2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( GXutil.strcmp(P01HH2_A8CatCodigo[0], A8CatCodigo) == 0 ) )
         {
            brk1HH2 = false ;
            AV20count = (long)(AV20count+1) ;
            brk1HH2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A8CatCodigo)==0) )
         {
            AV15Option = A8CatCodigo ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HH2 )
         {
            brk1HH2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCATDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV38TFCatDescrip = AV27SearchTxt ;
      AV39TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV13TFCatCodigo_Sels ,
                                           A123CatDescrip ,
                                           AV39TFCatDescrip_Sels ,
                                           Integer.valueOf(AV13TFCatCodigo_Sels.size()) ,
                                           AV12TFCatCodigo ,
                                           Integer.valueOf(AV39TFCatDescrip_Sels.size()) ,
                                           AV38TFCatDescrip ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV34CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV35PaiCod) ,
                                           A1565CliConvenio ,
                                           AV36ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV12TFCatCodigo = GXutil.padr( GXutil.rtrim( AV12TFCatCodigo), 40, "%") ;
      lV38TFCatDescrip = GXutil.concat( GXutil.rtrim( AV38TFCatDescrip), "%", "") ;
      /* Using cursor P01HH3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV34CliCod), Short.valueOf(AV35PaiCod), AV36ConveCodigo, lV12TFCatCodigo, lV38TFCatDescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1HH4 = false ;
         A3CliCod = P01HH3_A3CliCod[0] ;
         A1564CliPaiConve = P01HH3_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01HH3_A1565CliConvenio[0] ;
         A123CatDescrip = P01HH3_A123CatDescrip[0] ;
         A8CatCodigo = P01HH3_A8CatCodigo[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01HH3_A123CatDescrip[0], A123CatDescrip) == 0 ) )
         {
            brk1HH4 = false ;
            A3CliCod = P01HH3_A3CliCod[0] ;
            A1564CliPaiConve = P01HH3_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01HH3_A1565CliConvenio[0] ;
            A8CatCodigo = P01HH3_A8CatCodigo[0] ;
            AV20count = (long)(AV20count+1) ;
            brk1HH4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A123CatDescrip)==0) )
         {
            AV15Option = A123CatDescrip ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HH4 )
         {
            brk1HH4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = categoriaalta2wwgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = categoriaalta2wwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = categoriaalta2wwgetfilterdata.this.AV31OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV31OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFCatCodigo = "" ;
      AV11TFCatCodigo_SelsJson = "" ;
      AV13TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFCatDescrip = "" ;
      AV37TFCatDescrip_SelsJson = "" ;
      AV39TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44MenuOpcCod = "" ;
      scmdbuf = "" ;
      lV12TFCatCodigo = "" ;
      lV38TFCatDescrip = "" ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      AV36ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P01HH2_A1565CliConvenio = new String[] {""} ;
      P01HH2_A1564CliPaiConve = new short[1] ;
      P01HH2_A3CliCod = new int[1] ;
      P01HH2_A8CatCodigo = new String[] {""} ;
      P01HH2_A123CatDescrip = new String[] {""} ;
      AV15Option = "" ;
      P01HH3_A3CliCod = new int[1] ;
      P01HH3_A1564CliPaiConve = new short[1] ;
      P01HH3_A1565CliConvenio = new String[] {""} ;
      P01HH3_A123CatDescrip = new String[] {""} ;
      P01HH3_A8CatCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriaalta2wwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HH2_A1565CliConvenio, P01HH2_A1564CliPaiConve, P01HH2_A3CliCod, P01HH2_A8CatCodigo, P01HH2_A123CatDescrip
            }
            , new Object[] {
            P01HH3_A3CliCod, P01HH3_A1564CliPaiConve, P01HH3_A1565CliConvenio, P01HH3_A123CatDescrip, P01HH3_A8CatCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV35PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV34CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV13TFCatCodigo_Sels_size ;
   private int AV39TFCatDescrip_Sels_size ;
   private int A3CliCod ;
   private long AV20count ;
   private String AV12TFCatCodigo ;
   private String scmdbuf ;
   private String lV12TFCatCodigo ;
   private String A8CatCodigo ;
   private String AV36ConveCodigo ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HH2 ;
   private boolean brk1HH4 ;
   private String AV29OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV31OptionIndexesJson ;
   private String AV11TFCatCodigo_SelsJson ;
   private String AV37TFCatDescrip_SelsJson ;
   private String AV26DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV38TFCatDescrip ;
   private String AV44MenuOpcCod ;
   private String lV38TFCatDescrip ;
   private String A123CatDescrip ;
   private String AV15Option ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HH2_A1565CliConvenio ;
   private short[] P01HH2_A1564CliPaiConve ;
   private int[] P01HH2_A3CliCod ;
   private String[] P01HH2_A8CatCodigo ;
   private String[] P01HH2_A123CatDescrip ;
   private int[] P01HH3_A3CliCod ;
   private short[] P01HH3_A1564CliPaiConve ;
   private String[] P01HH3_A1565CliConvenio ;
   private String[] P01HH3_A123CatDescrip ;
   private String[] P01HH3_A8CatCodigo ;
   private GXSimpleCollection<String> AV13TFCatCodigo_Sels ;
   private GXSimpleCollection<String> AV16Options ;
   private GXSimpleCollection<String> AV18OptionsDesc ;
   private GXSimpleCollection<String> AV19OptionIndexes ;
   private GXSimpleCollection<String> AV39TFCatDescrip_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
}

final  class categoriaalta2wwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HH2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV13TFCatCodigo_Sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV39TFCatDescrip_Sels ,
                                          int AV13TFCatCodigo_Sels_size ,
                                          String AV12TFCatCodigo ,
                                          int AV39TFCatDescrip_Sels_size ,
                                          String AV38TFCatDescrip ,
                                          int AV34CliCod ,
                                          short AV35PaiCod ,
                                          String AV36ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, CatCodigo, CatDescrip FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV13TFCatCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCatCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV13TFCatCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCatCodigo_Sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV39TFCatDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV38TFCatDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV39TFCatDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV39TFCatDescrip_Sels, "CatDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01HH3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV13TFCatCodigo_Sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV39TFCatDescrip_Sels ,
                                          int AV13TFCatCodigo_Sels_size ,
                                          String AV12TFCatCodigo ,
                                          int AV39TFCatDescrip_Sels_size ,
                                          String AV38TFCatDescrip ,
                                          int A3CliCod ,
                                          int AV34CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV35PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV36ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, CatDescrip, CatCodigo FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ( AV13TFCatCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCatCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV13TFCatCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCatCodigo_Sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV39TFCatDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV38TFCatDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV39TFCatDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV39TFCatDescrip_Sels, "CatDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CatDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01HH2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] );
            case 1 :
                  return conditional_P01HH3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , (String)dynConstraints[12] , (String)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HH2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HH3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 400);
               }
               return;
      }
   }

}

