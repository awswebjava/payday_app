package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculowwgetfilterdata extends GXProcedure
{
   public calculowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculowwgetfilterdata.class ), "" );
   }

   public calculowwgetfilterdata( int remoteHandle ,
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
      calculowwgetfilterdata.this.aP5 = new String[] {""};
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
      calculowwgetfilterdata.this.AV33DDOName = aP0;
      calculowwgetfilterdata.this.AV31SearchTxt = aP1;
      calculowwgetfilterdata.this.AV32SearchTxtTo = aP2;
      calculowwgetfilterdata.this.aP3 = aP3;
      calculowwgetfilterdata.this.aP4 = aP4;
      calculowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV50EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      calculowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV50EmpCod = GXt_int1 ;
      GXt_int3 = AV51CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      calculowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV51CliCod = GXt_int3 ;
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando", GXv_boolean6) ;
      calculowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_OPECODFORMULA") == 0 )
         {
            /* Execute user subroutine: 'LOADOPECODFORMULAOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_OPEDESCRIPCION") == 0 )
         {
            /* Execute user subroutine: 'LOADOPEDESCRIPCIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV37OptionsJson = AV36Options.toJSonString(false) ;
      AV40OptionsDescJson = AV39OptionsDesc.toJSonString(false) ;
      AV42OptionIndexesJson = AV41OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV44Session.getValue("CalculoWWGridState"), "") == 0 )
      {
         AV46GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CalculoWWGridState"), null, null);
      }
      else
      {
         AV46GridState.fromxml(AV44Session.getValue("CalculoWWGridState"), null, null);
      }
      AV60GXV1 = 1 ;
      while ( AV60GXV1 <= AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV47GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV60GXV1));
         if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECODFORMULA") == 0 )
         {
            AV16TFOpeCodFormula = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPECODFORMULA_SEL") == 0 )
         {
            AV15TFOpeCodFormula_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFOpeCodFormula_Sels.fromJSonString(AV15TFOpeCodFormula_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEDESCRIPCION") == 0 )
         {
            AV19TFOpeDescripcion = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEDESCRIPCION_SEL") == 0 )
         {
            AV18TFOpeDescripcion_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFOpeDescripcion_Sels.fromJSonString(AV18TFOpeDescripcion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEESCANT_SEL") == 0 )
         {
            AV52TFOpeEsCant_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOPEALIES_SEL") == 0 )
         {
            AV53TFOpeAliEs_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV57MenuOpcCod = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV60GXV1 = (int)(AV60GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADOPECODFORMULAOPTIONS' Routine */
      returnInSub = false ;
      AV16TFOpeCodFormula = AV31SearchTxt ;
      AV17TFOpeCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Calculowwds_1_tfopecodformula = AV16TFOpeCodFormula ;
      AV63Calculowwds_2_tfopecodformula_sels = AV17TFOpeCodFormula_Sels ;
      AV64Calculowwds_3_tfopedescripcion = AV19TFOpeDescripcion ;
      AV65Calculowwds_4_tfopedescripcion_sels = AV20TFOpeDescripcion_Sels ;
      AV66Calculowwds_5_tfopeescant_sel = AV52TFOpeEsCant_Sel ;
      AV67Calculowwds_6_tfopealies_sel = AV53TFOpeAliEs_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A473OpeCodFormula ,
                                           AV63Calculowwds_2_tfopecodformula_sels ,
                                           A474OpeDescripcion ,
                                           AV65Calculowwds_4_tfopedescripcion_sels ,
                                           Integer.valueOf(AV63Calculowwds_2_tfopecodformula_sels.size()) ,
                                           AV62Calculowwds_1_tfopecodformula ,
                                           Integer.valueOf(AV65Calculowwds_4_tfopedescripcion_sels.size()) ,
                                           AV64Calculowwds_3_tfopedescripcion ,
                                           Byte.valueOf(AV66Calculowwds_5_tfopeescant_sel) ,
                                           Byte.valueOf(AV67Calculowwds_6_tfopealies_sel) ,
                                           Boolean.valueOf(A932OpeEsCant) ,
                                           Boolean.valueOf(A1032OpeAliEs) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      lV62Calculowwds_1_tfopecodformula = GXutil.padr( GXutil.rtrim( AV62Calculowwds_1_tfopecodformula), 40, "%") ;
      lV64Calculowwds_3_tfopedescripcion = GXutil.concat( GXutil.rtrim( AV64Calculowwds_3_tfopedescripcion), "%", "") ;
      /* Using cursor P00UU2 */
      pr_default.execute(0, new Object[] {lV62Calculowwds_1_tfopecodformula, lV64Calculowwds_3_tfopedescripcion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkUU2 = false ;
         A473OpeCodFormula = P00UU2_A473OpeCodFormula[0] ;
         A1032OpeAliEs = P00UU2_A1032OpeAliEs[0] ;
         A932OpeEsCant = P00UU2_A932OpeEsCant[0] ;
         A474OpeDescripcion = P00UU2_A474OpeDescripcion[0] ;
         A46PaiCod = P00UU2_A46PaiCod[0] ;
         A74idOperando = P00UU2_A74idOperando[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00UU2_A473OpeCodFormula[0], A473OpeCodFormula) == 0 ) )
         {
            brkUU2 = false ;
            A46PaiCod = P00UU2_A46PaiCod[0] ;
            A74idOperando = P00UU2_A74idOperando[0] ;
            AV43count = (long)(AV43count+1) ;
            brkUU2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A473OpeCodFormula)==0) )
         {
            AV35Option = A473OpeCodFormula ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkUU2 )
         {
            brkUU2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADOPEDESCRIPCIONOPTIONS' Routine */
      returnInSub = false ;
      AV19TFOpeDescripcion = AV31SearchTxt ;
      AV20TFOpeDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62Calculowwds_1_tfopecodformula = AV16TFOpeCodFormula ;
      AV63Calculowwds_2_tfopecodformula_sels = AV17TFOpeCodFormula_Sels ;
      AV64Calculowwds_3_tfopedescripcion = AV19TFOpeDescripcion ;
      AV65Calculowwds_4_tfopedescripcion_sels = AV20TFOpeDescripcion_Sels ;
      AV66Calculowwds_5_tfopeescant_sel = AV52TFOpeEsCant_Sel ;
      AV67Calculowwds_6_tfopealies_sel = AV53TFOpeAliEs_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A473OpeCodFormula ,
                                           AV63Calculowwds_2_tfopecodformula_sels ,
                                           A474OpeDescripcion ,
                                           AV65Calculowwds_4_tfopedescripcion_sels ,
                                           Integer.valueOf(AV63Calculowwds_2_tfopecodformula_sels.size()) ,
                                           AV62Calculowwds_1_tfopecodformula ,
                                           Integer.valueOf(AV65Calculowwds_4_tfopedescripcion_sels.size()) ,
                                           AV64Calculowwds_3_tfopedescripcion ,
                                           Byte.valueOf(AV66Calculowwds_5_tfopeescant_sel) ,
                                           Byte.valueOf(AV67Calculowwds_6_tfopealies_sel) ,
                                           Boolean.valueOf(A932OpeEsCant) ,
                                           Boolean.valueOf(A1032OpeAliEs) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      lV62Calculowwds_1_tfopecodformula = GXutil.padr( GXutil.rtrim( AV62Calculowwds_1_tfopecodformula), 40, "%") ;
      lV64Calculowwds_3_tfopedescripcion = GXutil.concat( GXutil.rtrim( AV64Calculowwds_3_tfopedescripcion), "%", "") ;
      /* Using cursor P00UU3 */
      pr_default.execute(1, new Object[] {lV62Calculowwds_1_tfopecodformula, lV64Calculowwds_3_tfopedescripcion});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkUU4 = false ;
         A474OpeDescripcion = P00UU3_A474OpeDescripcion[0] ;
         A1032OpeAliEs = P00UU3_A1032OpeAliEs[0] ;
         A932OpeEsCant = P00UU3_A932OpeEsCant[0] ;
         A473OpeCodFormula = P00UU3_A473OpeCodFormula[0] ;
         A46PaiCod = P00UU3_A46PaiCod[0] ;
         A74idOperando = P00UU3_A74idOperando[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00UU3_A474OpeDescripcion[0], A474OpeDescripcion) == 0 ) )
         {
            brkUU4 = false ;
            A46PaiCod = P00UU3_A46PaiCod[0] ;
            A74idOperando = P00UU3_A74idOperando[0] ;
            AV43count = (long)(AV43count+1) ;
            brkUU4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A474OpeDescripcion)==0) )
         {
            AV35Option = A474OpeDescripcion ;
            AV36Options.add(AV35Option, 0);
            AV41OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV36Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkUU4 )
         {
            brkUU4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = calculowwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = calculowwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = calculowwgetfilterdata.this.AV42OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37OptionsJson = "" ;
      AV40OptionsDescJson = "" ;
      AV42OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV36Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV44Session = httpContext.getWebSession();
      AV46GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV47GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFOpeCodFormula = "" ;
      AV15TFOpeCodFormula_SelsJson = "" ;
      AV17TFOpeCodFormula_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFOpeDescripcion = "" ;
      AV18TFOpeDescripcion_SelsJson = "" ;
      AV20TFOpeDescripcion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57MenuOpcCod = "" ;
      A473OpeCodFormula = "" ;
      AV62Calculowwds_1_tfopecodformula = "" ;
      AV63Calculowwds_2_tfopecodformula_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Calculowwds_3_tfopedescripcion = "" ;
      AV65Calculowwds_4_tfopedescripcion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV62Calculowwds_1_tfopecodformula = "" ;
      lV64Calculowwds_3_tfopedescripcion = "" ;
      A474OpeDescripcion = "" ;
      P00UU2_A473OpeCodFormula = new String[] {""} ;
      P00UU2_A1032OpeAliEs = new boolean[] {false} ;
      P00UU2_A932OpeEsCant = new boolean[] {false} ;
      P00UU2_A474OpeDescripcion = new String[] {""} ;
      P00UU2_A46PaiCod = new short[1] ;
      P00UU2_A74idOperando = new String[] {""} ;
      A74idOperando = "" ;
      AV35Option = "" ;
      P00UU3_A474OpeDescripcion = new String[] {""} ;
      P00UU3_A1032OpeAliEs = new boolean[] {false} ;
      P00UU3_A932OpeEsCant = new boolean[] {false} ;
      P00UU3_A473OpeCodFormula = new String[] {""} ;
      P00UU3_A46PaiCod = new short[1] ;
      P00UU3_A74idOperando = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00UU2_A473OpeCodFormula, P00UU2_A1032OpeAliEs, P00UU2_A932OpeEsCant, P00UU2_A474OpeDescripcion, P00UU2_A46PaiCod, P00UU2_A74idOperando
            }
            , new Object[] {
            P00UU3_A474OpeDescripcion, P00UU3_A1032OpeAliEs, P00UU3_A932OpeEsCant, P00UU3_A473OpeCodFormula, P00UU3_A46PaiCod, P00UU3_A74idOperando
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV52TFOpeEsCant_Sel ;
   private byte AV53TFOpeAliEs_Sel ;
   private byte AV66Calculowwds_5_tfopeescant_sel ;
   private byte AV67Calculowwds_6_tfopealies_sel ;
   private short AV50EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV51CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV60GXV1 ;
   private int AV63Calculowwds_2_tfopecodformula_sels_size ;
   private int AV65Calculowwds_4_tfopedescripcion_sels_size ;
   private long AV43count ;
   private String AV16TFOpeCodFormula ;
   private String A473OpeCodFormula ;
   private String AV62Calculowwds_1_tfopecodformula ;
   private String scmdbuf ;
   private String lV62Calculowwds_1_tfopecodformula ;
   private String A74idOperando ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private boolean brkUU2 ;
   private boolean brkUU4 ;
   private String AV37OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV42OptionIndexesJson ;
   private String AV15TFOpeCodFormula_SelsJson ;
   private String AV18TFOpeDescripcion_SelsJson ;
   private String AV33DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV19TFOpeDescripcion ;
   private String AV57MenuOpcCod ;
   private String AV64Calculowwds_3_tfopedescripcion ;
   private String lV64Calculowwds_3_tfopedescripcion ;
   private String A474OpeDescripcion ;
   private String AV35Option ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00UU2_A473OpeCodFormula ;
   private boolean[] P00UU2_A1032OpeAliEs ;
   private boolean[] P00UU2_A932OpeEsCant ;
   private String[] P00UU2_A474OpeDescripcion ;
   private short[] P00UU2_A46PaiCod ;
   private String[] P00UU2_A74idOperando ;
   private String[] P00UU3_A474OpeDescripcion ;
   private boolean[] P00UU3_A1032OpeAliEs ;
   private boolean[] P00UU3_A932OpeEsCant ;
   private String[] P00UU3_A473OpeCodFormula ;
   private short[] P00UU3_A46PaiCod ;
   private String[] P00UU3_A74idOperando ;
   private GXSimpleCollection<String> AV17TFOpeCodFormula_Sels ;
   private GXSimpleCollection<String> AV63Calculowwds_2_tfopecodformula_sels ;
   private GXSimpleCollection<String> AV36Options ;
   private GXSimpleCollection<String> AV39OptionsDesc ;
   private GXSimpleCollection<String> AV41OptionIndexes ;
   private GXSimpleCollection<String> AV20TFOpeDescripcion_Sels ;
   private GXSimpleCollection<String> AV65Calculowwds_4_tfopedescripcion_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV46GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV47GridStateFilterValue ;
}

final  class calculowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00UU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A473OpeCodFormula ,
                                          GXSimpleCollection<String> AV63Calculowwds_2_tfopecodformula_sels ,
                                          String A474OpeDescripcion ,
                                          GXSimpleCollection<String> AV65Calculowwds_4_tfopedescripcion_sels ,
                                          int AV63Calculowwds_2_tfopecodformula_sels_size ,
                                          String AV62Calculowwds_1_tfopecodformula ,
                                          int AV65Calculowwds_4_tfopedescripcion_sels_size ,
                                          String AV64Calculowwds_3_tfopedescripcion ,
                                          byte AV66Calculowwds_5_tfopeescant_sel ,
                                          byte AV67Calculowwds_6_tfopealies_sel ,
                                          boolean A932OpeEsCant ,
                                          boolean A1032OpeAliEs )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT OpeCodFormula, OpeAliEs, OpeEsCant, OpeDescripcion, PaiCod, idOperando FROM calculo" ;
      if ( ( AV63Calculowwds_2_tfopecodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Calculowwds_1_tfopecodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV63Calculowwds_2_tfopecodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Calculowwds_2_tfopecodformula_sels, "OpeCodFormula IN (", ")")+")");
      }
      if ( ( AV65Calculowwds_4_tfopedescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Calculowwds_3_tfopedescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV65Calculowwds_4_tfopedescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Calculowwds_4_tfopedescripcion_sels, "OpeDescripcion IN (", ")")+")");
      }
      if ( AV66Calculowwds_5_tfopeescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeEsCant = TRUE)");
      }
      if ( AV66Calculowwds_5_tfopeescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeEsCant = FALSE)");
      }
      if ( AV67Calculowwds_6_tfopealies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeAliEs = TRUE)");
      }
      if ( AV67Calculowwds_6_tfopealies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeAliEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OpeCodFormula" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00UU3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A473OpeCodFormula ,
                                          GXSimpleCollection<String> AV63Calculowwds_2_tfopecodformula_sels ,
                                          String A474OpeDescripcion ,
                                          GXSimpleCollection<String> AV65Calculowwds_4_tfopedescripcion_sels ,
                                          int AV63Calculowwds_2_tfopecodformula_sels_size ,
                                          String AV62Calculowwds_1_tfopecodformula ,
                                          int AV65Calculowwds_4_tfopedescripcion_sels_size ,
                                          String AV64Calculowwds_3_tfopedescripcion ,
                                          byte AV66Calculowwds_5_tfopeescant_sel ,
                                          byte AV67Calculowwds_6_tfopealies_sel ,
                                          boolean A932OpeEsCant ,
                                          boolean A1032OpeAliEs )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT OpeDescripcion, OpeAliEs, OpeEsCant, OpeCodFormula, PaiCod, idOperando FROM calculo" ;
      if ( ( AV63Calculowwds_2_tfopecodformula_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Calculowwds_1_tfopecodformula)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeCodFormula) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV63Calculowwds_2_tfopecodformula_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Calculowwds_2_tfopecodformula_sels, "OpeCodFormula IN (", ")")+")");
      }
      if ( ( AV65Calculowwds_4_tfopedescripcion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV64Calculowwds_3_tfopedescripcion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(OpeDescripcion) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV65Calculowwds_4_tfopedescripcion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Calculowwds_4_tfopedescripcion_sels, "OpeDescripcion IN (", ")")+")");
      }
      if ( AV66Calculowwds_5_tfopeescant_sel == 1 )
      {
         addWhere(sWhereString, "(OpeEsCant = TRUE)");
      }
      if ( AV66Calculowwds_5_tfopeescant_sel == 2 )
      {
         addWhere(sWhereString, "(OpeEsCant = FALSE)");
      }
      if ( AV67Calculowwds_6_tfopealies_sel == 1 )
      {
         addWhere(sWhereString, "(OpeAliEs = TRUE)");
      }
      if ( AV67Calculowwds_6_tfopealies_sel == 2 )
      {
         addWhere(sWhereString, "(OpeAliEs = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY OpeDescripcion" ;
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
                  return conditional_P00UU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Boolean) dynConstraints[10]).booleanValue() , ((Boolean) dynConstraints[11]).booleanValue() );
            case 1 :
                  return conditional_P00UU3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Boolean) dynConstraints[10]).booleanValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00UU3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
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
                  stmt.setString(sIdx, (String)parms[2], 40);
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
                  stmt.setString(sIdx, (String)parms[2], 40);
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

