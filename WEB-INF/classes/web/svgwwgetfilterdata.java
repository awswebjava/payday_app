package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class svgwwgetfilterdata extends GXProcedure
{
   public svgwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( svgwwgetfilterdata.class ), "" );
   }

   public svgwwgetfilterdata( int remoteHandle ,
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
      svgwwgetfilterdata.this.aP5 = new String[] {""};
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
      svgwwgetfilterdata.this.AV29DDOName = aP0;
      svgwwgetfilterdata.this.AV30SearchTxt = aP1;
      svgwwgetfilterdata.this.AV31SearchTxtTo = aP2;
      svgwwgetfilterdata.this.aP3 = aP3;
      svgwwgetfilterdata.this.aP4 = aP4;
      svgwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      svgwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      svgwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSVG", GXv_boolean6) ;
      svgwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_SVGID") == 0 )
         {
            /* Execute user subroutine: 'LOADSVGIDOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_SVGVALOR") == 0 )
         {
            /* Execute user subroutine: 'LOADSVGVALOROPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("SVGWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SVGWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("SVGWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSVGID") == 0 )
         {
            AV12TFSVGId = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSVGID_SEL") == 0 )
         {
            AV11TFSVGId_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFSVGId_Sels.fromJSonString(AV11TFSVGId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSVGVALOR") == 0 )
         {
            AV15TFSVGValor = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSVGVALOR_SEL") == 0 )
         {
            AV14TFSVGValor_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFSVGValor_Sels.fromJSonString(AV14TFSVGValor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSVGIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSVGId = AV30SearchTxt ;
      AV13TFSVGId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Svgwwds_1_tfsvgid = AV12TFSVGId ;
      AV44Svgwwds_2_tfsvgid_sels = AV13TFSVGId_Sels ;
      AV45Svgwwds_3_tfsvgvalor = AV15TFSVGValor ;
      AV46Svgwwds_4_tfsvgvalor_sels = AV16TFSVGValor_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1935SVGId ,
                                           AV44Svgwwds_2_tfsvgid_sels ,
                                           A1936SVGValor ,
                                           AV46Svgwwds_4_tfsvgvalor_sels ,
                                           Integer.valueOf(AV44Svgwwds_2_tfsvgid_sels.size()) ,
                                           AV43Svgwwds_1_tfsvgid ,
                                           Integer.valueOf(AV46Svgwwds_4_tfsvgvalor_sels.size()) ,
                                           AV45Svgwwds_3_tfsvgvalor ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT
                                           }
      });
      lV43Svgwwds_1_tfsvgid = GXutil.padr( GXutil.rtrim( AV43Svgwwds_1_tfsvgid), 20, "%") ;
      lV45Svgwwds_3_tfsvgvalor = GXutil.concat( GXutil.rtrim( AV45Svgwwds_3_tfsvgvalor), "%", "") ;
      /* Using cursor P01UN2 */
      pr_default.execute(0, new Object[] {lV43Svgwwds_1_tfsvgid, lV45Svgwwds_3_tfsvgvalor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1936SVGValor = P01UN2_A1936SVGValor[0] ;
         A1935SVGId = P01UN2_A1935SVGId[0] ;
         if ( ! (GXutil.strcmp("", A1935SVGId)==0) )
         {
            AV18Option = A1935SVGId ;
            AV19Options.add(AV18Option, 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSVGVALOROPTIONS' Routine */
      returnInSub = false ;
      AV15TFSVGValor = AV30SearchTxt ;
      AV16TFSVGValor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Svgwwds_1_tfsvgid = AV12TFSVGId ;
      AV44Svgwwds_2_tfsvgid_sels = AV13TFSVGId_Sels ;
      AV45Svgwwds_3_tfsvgvalor = AV15TFSVGValor ;
      AV46Svgwwds_4_tfsvgvalor_sels = AV16TFSVGValor_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1935SVGId ,
                                           AV44Svgwwds_2_tfsvgid_sels ,
                                           A1936SVGValor ,
                                           AV46Svgwwds_4_tfsvgvalor_sels ,
                                           Integer.valueOf(AV44Svgwwds_2_tfsvgid_sels.size()) ,
                                           AV43Svgwwds_1_tfsvgid ,
                                           Integer.valueOf(AV46Svgwwds_4_tfsvgvalor_sels.size()) ,
                                           AV45Svgwwds_3_tfsvgvalor ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT
                                           }
      });
      lV43Svgwwds_1_tfsvgid = GXutil.padr( GXutil.rtrim( AV43Svgwwds_1_tfsvgid), 20, "%") ;
      lV45Svgwwds_3_tfsvgvalor = GXutil.concat( GXutil.rtrim( AV45Svgwwds_3_tfsvgvalor), "%", "") ;
      /* Using cursor P01UN3 */
      pr_default.execute(1, new Object[] {lV43Svgwwds_1_tfsvgid, lV45Svgwwds_3_tfsvgvalor});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1UN3 = false ;
         A1936SVGValor = P01UN3_A1936SVGValor[0] ;
         A1935SVGId = P01UN3_A1935SVGId[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01UN3_A1936SVGValor[0], A1936SVGValor) == 0 ) )
         {
            brk1UN3 = false ;
            A1935SVGId = P01UN3_A1935SVGId[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1UN3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1936SVGValor)==0) )
         {
            AV18Option = A1936SVGValor ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1UN3 )
         {
            brk1UN3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = svgwwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = svgwwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = svgwwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFSVGId = "" ;
      AV11TFSVGId_SelsJson = "" ;
      AV13TFSVGId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFSVGValor = "" ;
      AV14TFSVGValor_SelsJson = "" ;
      AV16TFSVGValor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A1935SVGId = "" ;
      AV43Svgwwds_1_tfsvgid = "" ;
      AV44Svgwwds_2_tfsvgid_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45Svgwwds_3_tfsvgvalor = "" ;
      AV46Svgwwds_4_tfsvgvalor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV43Svgwwds_1_tfsvgid = "" ;
      lV45Svgwwds_3_tfsvgvalor = "" ;
      A1936SVGValor = "" ;
      P01UN2_A1936SVGValor = new String[] {""} ;
      P01UN2_A1935SVGId = new String[] {""} ;
      AV18Option = "" ;
      P01UN3_A1936SVGValor = new String[] {""} ;
      P01UN3_A1935SVGId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.svgwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01UN2_A1936SVGValor, P01UN2_A1935SVGId
            }
            , new Object[] {
            P01UN3_A1936SVGValor, P01UN3_A1935SVGId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV44Svgwwds_2_tfsvgid_sels_size ;
   private int AV46Svgwwds_4_tfsvgvalor_sels_size ;
   private long AV23count ;
   private String AV12TFSVGId ;
   private String A1935SVGId ;
   private String AV43Svgwwds_1_tfsvgid ;
   private String scmdbuf ;
   private String lV43Svgwwds_1_tfsvgid ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1UN3 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV11TFSVGId_SelsJson ;
   private String AV14TFSVGValor_SelsJson ;
   private String A1936SVGValor ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV15TFSVGValor ;
   private String AV38MenuOpcCod ;
   private String AV45Svgwwds_3_tfsvgvalor ;
   private String lV45Svgwwds_3_tfsvgvalor ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UN2_A1936SVGValor ;
   private String[] P01UN2_A1935SVGId ;
   private String[] P01UN3_A1936SVGValor ;
   private String[] P01UN3_A1935SVGId ;
   private GXSimpleCollection<String> AV13TFSVGId_Sels ;
   private GXSimpleCollection<String> AV44Svgwwds_2_tfsvgid_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV16TFSVGValor_Sels ;
   private GXSimpleCollection<String> AV46Svgwwds_4_tfsvgvalor_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class svgwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1935SVGId ,
                                          GXSimpleCollection<String> AV44Svgwwds_2_tfsvgid_sels ,
                                          String A1936SVGValor ,
                                          GXSimpleCollection<String> AV46Svgwwds_4_tfsvgvalor_sels ,
                                          int AV44Svgwwds_2_tfsvgid_sels_size ,
                                          String AV43Svgwwds_1_tfsvgid ,
                                          int AV46Svgwwds_4_tfsvgvalor_sels_size ,
                                          String AV45Svgwwds_3_tfsvgvalor ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS SVGValor, SVGId FROM ( SELECT SVGValor, SVGId FROM SVG" ;
      if ( ( AV44Svgwwds_2_tfsvgid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Svgwwds_1_tfsvgid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SVGId) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV44Svgwwds_2_tfsvgid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Svgwwds_2_tfsvgid_sels, "SVGId IN (", ")")+")");
      }
      if ( ( AV46Svgwwds_4_tfsvgvalor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Svgwwds_3_tfsvgvalor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SVGValor) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV46Svgwwds_4_tfsvgvalor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Svgwwds_4_tfsvgvalor_sels, "SVGValor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SVGId" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY SVGId" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01UN3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1935SVGId ,
                                          GXSimpleCollection<String> AV44Svgwwds_2_tfsvgid_sels ,
                                          String A1936SVGValor ,
                                          GXSimpleCollection<String> AV46Svgwwds_4_tfsvgvalor_sels ,
                                          int AV44Svgwwds_2_tfsvgid_sels_size ,
                                          String AV43Svgwwds_1_tfsvgid ,
                                          int AV46Svgwwds_4_tfsvgvalor_sels_size ,
                                          String AV45Svgwwds_3_tfsvgvalor ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SVGValor, SVGId FROM SVG" ;
      if ( ( AV44Svgwwds_2_tfsvgid_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43Svgwwds_1_tfsvgid)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SVGId) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV44Svgwwds_2_tfsvgid_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44Svgwwds_2_tfsvgid_sels, "SVGId IN (", ")")+")");
      }
      if ( ( AV46Svgwwds_4_tfsvgvalor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Svgwwds_3_tfsvgvalor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SVGValor) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV46Svgwwds_4_tfsvgvalor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Svgwwds_4_tfsvgvalor_sels, "SVGValor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SVGValor" ;
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
                  return conditional_P01UN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[9]).intValue() );
            case 1 :
                  return conditional_P01UN3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01UN3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 200);
               }
               return;
      }
   }

}

