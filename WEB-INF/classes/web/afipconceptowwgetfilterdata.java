package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class afipconceptowwgetfilterdata extends GXProcedure
{
   public afipconceptowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( afipconceptowwgetfilterdata.class ), "" );
   }

   public afipconceptowwgetfilterdata( int remoteHandle ,
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
      afipconceptowwgetfilterdata.this.aP5 = new String[] {""};
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
      afipconceptowwgetfilterdata.this.AV30DDOName = aP0;
      afipconceptowwgetfilterdata.this.AV31SearchTxt = aP1;
      afipconceptowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      afipconceptowwgetfilterdata.this.aP3 = aP3;
      afipconceptowwgetfilterdata.this.aP4 = aP4;
      afipconceptowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      afipconceptowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      afipconceptowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAFIPConcepto", GXv_boolean6) ;
      afipconceptowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_AFIPCONCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADAFIPCONCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_AFIPCONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADAFIPCONDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("AFIPConceptoWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "AFIPConceptoWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("AFIPConceptoWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAFIPCONCOD") == 0 )
         {
            AV12TFAFIPConCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAFIPCONCOD_SEL") == 0 )
         {
            AV11TFAFIPConCod_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFAFIPConCod_Sels.fromJSonString(AV11TFAFIPConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAFIPCONDESCRIP") == 0 )
         {
            AV15TFAFIPConDescrip = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAFIPCONDESCRIP_SEL") == 0 )
         {
            AV14TFAFIPConDescrip_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFAFIPConDescrip_Sels.fromJSonString(AV14TFAFIPConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAFIPCONLIQAGIL_SEL") == 0 )
         {
            AV17TFAFIPConLiqAgil_Sel = (byte)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADAFIPCONCODOPTIONS' Routine */
      returnInSub = false ;
      AV12TFAFIPConCod = AV31SearchTxt ;
      AV13TFAFIPConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Afipconceptowwds_1_tfafipconcod = AV12TFAFIPConCod ;
      AV45Afipconceptowwds_2_tfafipconcod_sels = AV13TFAFIPConCod_Sels ;
      AV46Afipconceptowwds_3_tfafipcondescrip = AV15TFAFIPConDescrip ;
      AV47Afipconceptowwds_4_tfafipcondescrip_sels = AV16TFAFIPConDescrip_Sels ;
      AV48Afipconceptowwds_5_tfafipconliqagil_sel = AV17TFAFIPConLiqAgil_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A72AFIPConCod ,
                                           AV45Afipconceptowwds_2_tfafipconcod_sels ,
                                           A369AFIPConDescrip ,
                                           AV47Afipconceptowwds_4_tfafipcondescrip_sels ,
                                           Integer.valueOf(AV45Afipconceptowwds_2_tfafipconcod_sels.size()) ,
                                           AV44Afipconceptowwds_1_tfafipconcod ,
                                           Integer.valueOf(AV47Afipconceptowwds_4_tfafipcondescrip_sels.size()) ,
                                           AV46Afipconceptowwds_3_tfafipcondescrip ,
                                           Byte.valueOf(AV48Afipconceptowwds_5_tfafipconliqagil_sel) ,
                                           Boolean.valueOf(A1646AFIPConLiqAgil) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN
                                           }
      });
      lV44Afipconceptowwds_1_tfafipconcod = GXutil.padr( GXutil.rtrim( AV44Afipconceptowwds_1_tfafipconcod), 6, "%") ;
      lV46Afipconceptowwds_3_tfafipcondescrip = GXutil.concat( GXutil.rtrim( AV46Afipconceptowwds_3_tfafipcondescrip), "%", "") ;
      /* Using cursor P01J72 */
      pr_default.execute(0, new Object[] {lV44Afipconceptowwds_1_tfafipconcod, lV46Afipconceptowwds_3_tfafipcondescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1646AFIPConLiqAgil = P01J72_A1646AFIPConLiqAgil[0] ;
         A369AFIPConDescrip = P01J72_A369AFIPConDescrip[0] ;
         A72AFIPConCod = P01J72_A72AFIPConCod[0] ;
         if ( ! (GXutil.strcmp("", A72AFIPConCod)==0) )
         {
            AV19Option = A72AFIPConCod ;
            AV20Options.add(AV19Option, 0);
         }
         if ( AV20Options.size() == 50 )
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
      /* 'LOADAFIPCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFAFIPConDescrip = AV31SearchTxt ;
      AV16TFAFIPConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Afipconceptowwds_1_tfafipconcod = AV12TFAFIPConCod ;
      AV45Afipconceptowwds_2_tfafipconcod_sels = AV13TFAFIPConCod_Sels ;
      AV46Afipconceptowwds_3_tfafipcondescrip = AV15TFAFIPConDescrip ;
      AV47Afipconceptowwds_4_tfafipcondescrip_sels = AV16TFAFIPConDescrip_Sels ;
      AV48Afipconceptowwds_5_tfafipconliqagil_sel = AV17TFAFIPConLiqAgil_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A72AFIPConCod ,
                                           AV45Afipconceptowwds_2_tfafipconcod_sels ,
                                           A369AFIPConDescrip ,
                                           AV47Afipconceptowwds_4_tfafipcondescrip_sels ,
                                           Integer.valueOf(AV45Afipconceptowwds_2_tfafipconcod_sels.size()) ,
                                           AV44Afipconceptowwds_1_tfafipconcod ,
                                           Integer.valueOf(AV47Afipconceptowwds_4_tfafipcondescrip_sels.size()) ,
                                           AV46Afipconceptowwds_3_tfafipcondescrip ,
                                           Byte.valueOf(AV48Afipconceptowwds_5_tfafipconliqagil_sel) ,
                                           Boolean.valueOf(A1646AFIPConLiqAgil) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN
                                           }
      });
      lV44Afipconceptowwds_1_tfafipconcod = GXutil.padr( GXutil.rtrim( AV44Afipconceptowwds_1_tfafipconcod), 6, "%") ;
      lV46Afipconceptowwds_3_tfafipcondescrip = GXutil.concat( GXutil.rtrim( AV46Afipconceptowwds_3_tfafipcondescrip), "%", "") ;
      /* Using cursor P01J73 */
      pr_default.execute(1, new Object[] {lV44Afipconceptowwds_1_tfafipconcod, lV46Afipconceptowwds_3_tfafipcondescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1J73 = false ;
         A369AFIPConDescrip = P01J73_A369AFIPConDescrip[0] ;
         A1646AFIPConLiqAgil = P01J73_A1646AFIPConLiqAgil[0] ;
         A72AFIPConCod = P01J73_A72AFIPConCod[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01J73_A369AFIPConDescrip[0], A369AFIPConDescrip) == 0 ) )
         {
            brk1J73 = false ;
            A72AFIPConCod = P01J73_A72AFIPConCod[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1J73 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A369AFIPConDescrip)==0) )
         {
            AV19Option = A369AFIPConDescrip ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1J73 )
         {
            brk1J73 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = afipconceptowwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = afipconceptowwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = afipconceptowwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFAFIPConCod = "" ;
      AV11TFAFIPConCod_SelsJson = "" ;
      AV13TFAFIPConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFAFIPConDescrip = "" ;
      AV14TFAFIPConDescrip_SelsJson = "" ;
      AV16TFAFIPConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A72AFIPConCod = "" ;
      AV44Afipconceptowwds_1_tfafipconcod = "" ;
      AV45Afipconceptowwds_2_tfafipconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46Afipconceptowwds_3_tfafipcondescrip = "" ;
      AV47Afipconceptowwds_4_tfafipcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Afipconceptowwds_1_tfafipconcod = "" ;
      lV46Afipconceptowwds_3_tfafipcondescrip = "" ;
      A369AFIPConDescrip = "" ;
      P01J72_A1646AFIPConLiqAgil = new boolean[] {false} ;
      P01J72_A369AFIPConDescrip = new String[] {""} ;
      P01J72_A72AFIPConCod = new String[] {""} ;
      AV19Option = "" ;
      P01J73_A369AFIPConDescrip = new String[] {""} ;
      P01J73_A1646AFIPConLiqAgil = new boolean[] {false} ;
      P01J73_A72AFIPConCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.afipconceptowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01J72_A1646AFIPConLiqAgil, P01J72_A369AFIPConDescrip, P01J72_A72AFIPConCod
            }
            , new Object[] {
            P01J73_A369AFIPConDescrip, P01J73_A1646AFIPConLiqAgil, P01J73_A72AFIPConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17TFAFIPConLiqAgil_Sel ;
   private byte AV48Afipconceptowwds_5_tfafipconliqagil_sel ;
   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV42GXV1 ;
   private int AV45Afipconceptowwds_2_tfafipconcod_sels_size ;
   private int AV47Afipconceptowwds_4_tfafipcondescrip_sels_size ;
   private long AV24count ;
   private String AV12TFAFIPConCod ;
   private String A72AFIPConCod ;
   private String AV44Afipconceptowwds_1_tfafipconcod ;
   private String scmdbuf ;
   private String lV44Afipconceptowwds_1_tfafipconcod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1646AFIPConLiqAgil ;
   private boolean brk1J73 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV11TFAFIPConCod_SelsJson ;
   private String AV14TFAFIPConDescrip_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV15TFAFIPConDescrip ;
   private String AV39MenuOpcCod ;
   private String AV46Afipconceptowwds_3_tfafipcondescrip ;
   private String lV46Afipconceptowwds_3_tfafipcondescrip ;
   private String A369AFIPConDescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01J72_A1646AFIPConLiqAgil ;
   private String[] P01J72_A369AFIPConDescrip ;
   private String[] P01J72_A72AFIPConCod ;
   private String[] P01J73_A369AFIPConDescrip ;
   private boolean[] P01J73_A1646AFIPConLiqAgil ;
   private String[] P01J73_A72AFIPConCod ;
   private GXSimpleCollection<String> AV13TFAFIPConCod_Sels ;
   private GXSimpleCollection<String> AV45Afipconceptowwds_2_tfafipconcod_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV16TFAFIPConDescrip_Sels ;
   private GXSimpleCollection<String> AV47Afipconceptowwds_4_tfafipcondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class afipconceptowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01J72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A72AFIPConCod ,
                                          GXSimpleCollection<String> AV45Afipconceptowwds_2_tfafipconcod_sels ,
                                          String A369AFIPConDescrip ,
                                          GXSimpleCollection<String> AV47Afipconceptowwds_4_tfafipcondescrip_sels ,
                                          int AV45Afipconceptowwds_2_tfafipconcod_sels_size ,
                                          String AV44Afipconceptowwds_1_tfafipconcod ,
                                          int AV47Afipconceptowwds_4_tfafipcondescrip_sels_size ,
                                          String AV46Afipconceptowwds_3_tfafipcondescrip ,
                                          byte AV48Afipconceptowwds_5_tfafipconliqagil_sel ,
                                          boolean A1646AFIPConLiqAgil )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS AFIPConLiqAgil, NULL AS AFIPConDescrip, AFIPConCod FROM ( SELECT AFIPConLiqAgil, AFIPConDescrip, AFIPConCod FROM AFIPConcepto" ;
      if ( ( AV45Afipconceptowwds_2_tfafipconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Afipconceptowwds_1_tfafipconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AFIPConCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV45Afipconceptowwds_2_tfafipconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Afipconceptowwds_2_tfafipconcod_sels, "AFIPConCod IN (", ")")+")");
      }
      if ( ( AV47Afipconceptowwds_4_tfafipcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Afipconceptowwds_3_tfafipcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AFIPConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV47Afipconceptowwds_4_tfafipcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Afipconceptowwds_4_tfafipcondescrip_sels, "AFIPConDescrip IN (", ")")+")");
      }
      if ( AV48Afipconceptowwds_5_tfafipconliqagil_sel == 1 )
      {
         addWhere(sWhereString, "(AFIPConLiqAgil = TRUE)");
      }
      if ( AV48Afipconceptowwds_5_tfafipconliqagil_sel == 2 )
      {
         addWhere(sWhereString, "(AFIPConLiqAgil = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AFIPConCod" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY AFIPConCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01J73( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A72AFIPConCod ,
                                          GXSimpleCollection<String> AV45Afipconceptowwds_2_tfafipconcod_sels ,
                                          String A369AFIPConDescrip ,
                                          GXSimpleCollection<String> AV47Afipconceptowwds_4_tfafipcondescrip_sels ,
                                          int AV45Afipconceptowwds_2_tfafipconcod_sels_size ,
                                          String AV44Afipconceptowwds_1_tfafipconcod ,
                                          int AV47Afipconceptowwds_4_tfafipcondescrip_sels_size ,
                                          String AV46Afipconceptowwds_3_tfafipcondescrip ,
                                          byte AV48Afipconceptowwds_5_tfafipconliqagil_sel ,
                                          boolean A1646AFIPConLiqAgil )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT AFIPConDescrip, AFIPConLiqAgil, AFIPConCod FROM AFIPConcepto" ;
      if ( ( AV45Afipconceptowwds_2_tfafipconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Afipconceptowwds_1_tfafipconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AFIPConCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV45Afipconceptowwds_2_tfafipconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Afipconceptowwds_2_tfafipconcod_sels, "AFIPConCod IN (", ")")+")");
      }
      if ( ( AV47Afipconceptowwds_4_tfafipcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Afipconceptowwds_3_tfafipcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AFIPConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV47Afipconceptowwds_4_tfafipcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Afipconceptowwds_4_tfafipcondescrip_sels, "AFIPConDescrip IN (", ")")+")");
      }
      if ( AV48Afipconceptowwds_5_tfafipconliqagil_sel == 1 )
      {
         addWhere(sWhereString, "(AFIPConLiqAgil = TRUE)");
      }
      if ( AV48Afipconceptowwds_5_tfafipconliqagil_sel == 2 )
      {
         addWhere(sWhereString, "(AFIPConLiqAgil = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AFIPConDescrip" ;
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
                  return conditional_P01J72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Boolean) dynConstraints[9]).booleanValue() );
            case 1 :
                  return conditional_P01J73(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Boolean) dynConstraints[9]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01J72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01J73", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
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
                  stmt.setString(sIdx, (String)parms[2], 6);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 6);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

