package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class embargabilidadwwgetfilterdata extends GXProcedure
{
   public embargabilidadwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( embargabilidadwwgetfilterdata.class ), "" );
   }

   public embargabilidadwwgetfilterdata( int remoteHandle ,
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
      embargabilidadwwgetfilterdata.this.aP5 = new String[] {""};
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
      embargabilidadwwgetfilterdata.this.AV26DDOName = aP0;
      embargabilidadwwgetfilterdata.this.AV27SearchTxt = aP1;
      embargabilidadwwgetfilterdata.this.AV28SearchTxtTo = aP2;
      embargabilidadwwgetfilterdata.this.aP3 = aP3;
      embargabilidadwwgetfilterdata.this.aP4 = aP4;
      embargabilidadwwgetfilterdata.this.aP5 = aP5;
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
      embargabilidadwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV33EmpCod = GXt_int1 ;
      GXt_int3 = AV34CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      embargabilidadwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV34CliCod = GXt_int3 ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad", GXv_boolean6) ;
      embargabilidadwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_EMBARGADESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADEMBARGADESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_EMBARGAEXPLICACION") == 0 )
         {
            /* Execute user subroutine: 'LOADEMBARGAEXPLICACIONOPTIONS' */
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
      if ( GXutil.strcmp(AV21Session.getValue("embargabilidadWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "embargabilidadWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("embargabilidadWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP") == 0 )
         {
            AV12TFEmbargaDescrip = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP_SEL") == 0 )
         {
            AV11TFEmbargaDescrip_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFEmbargaDescrip_Sels.fromJSonString(AV11TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION") == 0 )
         {
            AV36TFEmbargaExplicacion = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGAEXPLICACION_SEL") == 0 )
         {
            AV35TFEmbargaExplicacion_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFEmbargaExplicacion_Sels.fromJSonString(AV35TFEmbargaExplicacion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMBARGADESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFEmbargaDescrip = AV27SearchTxt ;
      AV13TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Embargabilidadwwds_1_tfembargadescrip = AV12TFEmbargaDescrip ;
      AV45Embargabilidadwwds_2_tfembargadescrip_sels = AV13TFEmbargaDescrip_Sels ;
      AV46Embargabilidadwwds_3_tfembargaexplicacion = AV36TFEmbargaExplicacion ;
      AV47Embargabilidadwwds_4_tfembargaexplicacion_sels = AV37TFEmbargaExplicacion_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1162EmbargaDescrip ,
                                           AV45Embargabilidadwwds_2_tfembargadescrip_sels ,
                                           A1203EmbargaExplicacion ,
                                           AV47Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                           Integer.valueOf(AV45Embargabilidadwwds_2_tfembargadescrip_sels.size()) ,
                                           AV44Embargabilidadwwds_1_tfembargadescrip ,
                                           Integer.valueOf(AV47Embargabilidadwwds_4_tfembargaexplicacion_sels.size()) ,
                                           AV46Embargabilidadwwds_3_tfembargaexplicacion ,
                                           Short.valueOf(AV38PaiCod) ,
                                           Short.valueOf(A1160EmbarPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV44Embargabilidadwwds_1_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV44Embargabilidadwwds_1_tfembargadescrip), "%", "") ;
      lV46Embargabilidadwwds_3_tfembargaexplicacion = GXutil.concat( GXutil.rtrim( AV46Embargabilidadwwds_3_tfembargaexplicacion), "%", "") ;
      /* Using cursor P019G2 */
      pr_default.execute(0, new Object[] {lV44Embargabilidadwwds_1_tfembargadescrip, lV46Embargabilidadwwds_3_tfembargaexplicacion, Short.valueOf(AV38PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk19G2 = false ;
         A1162EmbargaDescrip = P019G2_A1162EmbargaDescrip[0] ;
         A1160EmbarPaiCod = P019G2_A1160EmbarPaiCod[0] ;
         A1203EmbargaExplicacion = P019G2_A1203EmbargaExplicacion[0] ;
         A1161EmbargaSec = P019G2_A1161EmbargaSec[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P019G2_A1162EmbargaDescrip[0], A1162EmbargaDescrip) == 0 ) )
         {
            brk19G2 = false ;
            A1161EmbargaSec = P019G2_A1161EmbargaSec[0] ;
            AV20count = (long)(AV20count+1) ;
            brk19G2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1162EmbargaDescrip)==0) )
         {
            AV15Option = A1162EmbargaDescrip ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19G2 )
         {
            brk19G2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADEMBARGAEXPLICACIONOPTIONS' Routine */
      returnInSub = false ;
      AV36TFEmbargaExplicacion = AV27SearchTxt ;
      AV37TFEmbargaExplicacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Embargabilidadwwds_1_tfembargadescrip = AV12TFEmbargaDescrip ;
      AV45Embargabilidadwwds_2_tfembargadescrip_sels = AV13TFEmbargaDescrip_Sels ;
      AV46Embargabilidadwwds_3_tfembargaexplicacion = AV36TFEmbargaExplicacion ;
      AV47Embargabilidadwwds_4_tfembargaexplicacion_sels = AV37TFEmbargaExplicacion_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1162EmbargaDescrip ,
                                           AV45Embargabilidadwwds_2_tfembargadescrip_sels ,
                                           A1203EmbargaExplicacion ,
                                           AV47Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                           Integer.valueOf(AV45Embargabilidadwwds_2_tfembargadescrip_sels.size()) ,
                                           AV44Embargabilidadwwds_1_tfembargadescrip ,
                                           Integer.valueOf(AV47Embargabilidadwwds_4_tfembargaexplicacion_sels.size()) ,
                                           AV46Embargabilidadwwds_3_tfembargaexplicacion ,
                                           Short.valueOf(AV38PaiCod) ,
                                           Short.valueOf(A1160EmbarPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV44Embargabilidadwwds_1_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV44Embargabilidadwwds_1_tfembargadescrip), "%", "") ;
      lV46Embargabilidadwwds_3_tfembargaexplicacion = GXutil.concat( GXutil.rtrim( AV46Embargabilidadwwds_3_tfembargaexplicacion), "%", "") ;
      /* Using cursor P019G3 */
      pr_default.execute(1, new Object[] {lV44Embargabilidadwwds_1_tfembargadescrip, lV46Embargabilidadwwds_3_tfembargaexplicacion, Short.valueOf(AV38PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk19G4 = false ;
         A1203EmbargaExplicacion = P019G3_A1203EmbargaExplicacion[0] ;
         A1160EmbarPaiCod = P019G3_A1160EmbarPaiCod[0] ;
         A1162EmbargaDescrip = P019G3_A1162EmbargaDescrip[0] ;
         A1161EmbargaSec = P019G3_A1161EmbargaSec[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P019G3_A1203EmbargaExplicacion[0], A1203EmbargaExplicacion) == 0 ) )
         {
            brk19G4 = false ;
            A1161EmbargaSec = P019G3_A1161EmbargaSec[0] ;
            AV20count = (long)(AV20count+1) ;
            brk19G4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1203EmbargaExplicacion)==0) )
         {
            AV15Option = A1203EmbargaExplicacion ;
            AV16Options.add(AV15Option, 0);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19G4 )
         {
            brk19G4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = embargabilidadwwgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = embargabilidadwwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = embargabilidadwwgetfilterdata.this.AV31OptionIndexesJson;
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
      AV12TFEmbargaDescrip = "" ;
      AV11TFEmbargaDescrip_SelsJson = "" ;
      AV13TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36TFEmbargaExplicacion = "" ;
      AV35TFEmbargaExplicacion_SelsJson = "" ;
      AV37TFEmbargaExplicacion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A1162EmbargaDescrip = "" ;
      AV44Embargabilidadwwds_1_tfembargadescrip = "" ;
      AV45Embargabilidadwwds_2_tfembargadescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      AV47Embargabilidadwwds_4_tfembargaexplicacion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Embargabilidadwwds_1_tfembargadescrip = "" ;
      lV46Embargabilidadwwds_3_tfembargaexplicacion = "" ;
      A1203EmbargaExplicacion = "" ;
      P019G2_A1162EmbargaDescrip = new String[] {""} ;
      P019G2_A1160EmbarPaiCod = new short[1] ;
      P019G2_A1203EmbargaExplicacion = new String[] {""} ;
      P019G2_A1161EmbargaSec = new short[1] ;
      AV15Option = "" ;
      P019G3_A1203EmbargaExplicacion = new String[] {""} ;
      P019G3_A1160EmbarPaiCod = new short[1] ;
      P019G3_A1162EmbargaDescrip = new String[] {""} ;
      P019G3_A1161EmbargaSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.embargabilidadwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P019G2_A1162EmbargaDescrip, P019G2_A1160EmbarPaiCod, P019G2_A1203EmbargaExplicacion, P019G2_A1161EmbargaSec
            }
            , new Object[] {
            P019G3_A1203EmbargaExplicacion, P019G3_A1160EmbarPaiCod, P019G3_A1162EmbargaDescrip, P019G3_A1161EmbargaSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV38PaiCod ;
   private short A1160EmbarPaiCod ;
   private short A1161EmbargaSec ;
   private short Gx_err ;
   private int AV34CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV42GXV1 ;
   private int AV45Embargabilidadwwds_2_tfembargadescrip_sels_size ;
   private int AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size ;
   private long AV20count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk19G2 ;
   private boolean brk19G4 ;
   private String AV29OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV31OptionIndexesJson ;
   private String AV11TFEmbargaDescrip_SelsJson ;
   private String AV35TFEmbargaExplicacion_SelsJson ;
   private String A1203EmbargaExplicacion ;
   private String AV26DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV12TFEmbargaDescrip ;
   private String AV36TFEmbargaExplicacion ;
   private String AV39MenuOpcCod ;
   private String A1162EmbargaDescrip ;
   private String AV44Embargabilidadwwds_1_tfembargadescrip ;
   private String AV46Embargabilidadwwds_3_tfembargaexplicacion ;
   private String lV44Embargabilidadwwds_1_tfembargadescrip ;
   private String lV46Embargabilidadwwds_3_tfembargaexplicacion ;
   private String AV15Option ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P019G2_A1162EmbargaDescrip ;
   private short[] P019G2_A1160EmbarPaiCod ;
   private String[] P019G2_A1203EmbargaExplicacion ;
   private short[] P019G2_A1161EmbargaSec ;
   private String[] P019G3_A1203EmbargaExplicacion ;
   private short[] P019G3_A1160EmbarPaiCod ;
   private String[] P019G3_A1162EmbargaDescrip ;
   private short[] P019G3_A1161EmbargaSec ;
   private GXSimpleCollection<String> AV16Options ;
   private GXSimpleCollection<String> AV18OptionsDesc ;
   private GXSimpleCollection<String> AV19OptionIndexes ;
   private GXSimpleCollection<String> AV13TFEmbargaDescrip_Sels ;
   private GXSimpleCollection<String> AV37TFEmbargaExplicacion_Sels ;
   private GXSimpleCollection<String> AV45Embargabilidadwwds_2_tfembargadescrip_sels ;
   private GXSimpleCollection<String> AV47Embargabilidadwwds_4_tfembargaexplicacion_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
}

final  class embargabilidadwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P019G2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV45Embargabilidadwwds_2_tfembargadescrip_sels ,
                                          String A1203EmbargaExplicacion ,
                                          GXSimpleCollection<String> AV47Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                          int AV45Embargabilidadwwds_2_tfembargadescrip_sels_size ,
                                          String AV44Embargabilidadwwds_1_tfembargadescrip ,
                                          int AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size ,
                                          String AV46Embargabilidadwwds_3_tfembargaexplicacion ,
                                          short AV38PaiCod ,
                                          short A1160EmbarPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT EmbargaDescrip, EmbarPaiCod, EmbargaExplicacion, EmbargaSec FROM embargabilidad" ;
      if ( ( AV45Embargabilidadwwds_2_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Embargabilidadwwds_1_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV45Embargabilidadwwds_2_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Embargabilidadwwds_2_tfembargadescrip_sels, "EmbargaDescrip IN (", ")")+")");
      }
      if ( ( AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Embargabilidadwwds_3_tfembargaexplicacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaExplicacion) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Embargabilidadwwds_4_tfembargaexplicacion_sels, "EmbargaExplicacion IN (", ")")+")");
      }
      if ( ! (0==AV38PaiCod) )
      {
         addWhere(sWhereString, "(EmbarPaiCod = ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmbargaDescrip" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P019G3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV45Embargabilidadwwds_2_tfembargadescrip_sels ,
                                          String A1203EmbargaExplicacion ,
                                          GXSimpleCollection<String> AV47Embargabilidadwwds_4_tfembargaexplicacion_sels ,
                                          int AV45Embargabilidadwwds_2_tfembargadescrip_sels_size ,
                                          String AV44Embargabilidadwwds_1_tfembargadescrip ,
                                          int AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size ,
                                          String AV46Embargabilidadwwds_3_tfembargaexplicacion ,
                                          short AV38PaiCod ,
                                          short A1160EmbarPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT EmbargaExplicacion, EmbarPaiCod, EmbargaDescrip, EmbargaSec FROM embargabilidad" ;
      if ( ( AV45Embargabilidadwwds_2_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Embargabilidadwwds_1_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV45Embargabilidadwwds_2_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Embargabilidadwwds_2_tfembargadescrip_sels, "EmbargaDescrip IN (", ")")+")");
      }
      if ( ( AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Embargabilidadwwds_3_tfembargaexplicacion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmbargaExplicacion) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV47Embargabilidadwwds_4_tfembargaexplicacion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Embargabilidadwwds_4_tfembargaexplicacion_sels, "EmbargaExplicacion IN (", ")")+")");
      }
      if ( ! (0==AV38PaiCod) )
      {
         addWhere(sWhereString, "(EmbarPaiCod = ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmbargaExplicacion" ;
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
                  return conditional_P019G2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() );
            case 1 :
                  return conditional_P019G3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019G2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019G3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 200);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 30);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 200);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

