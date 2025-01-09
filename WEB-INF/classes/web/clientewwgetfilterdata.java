package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientewwgetfilterdata extends GXProcedure
{
   public clientewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientewwgetfilterdata.class ), "" );
   }

   public clientewwgetfilterdata( int remoteHandle ,
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
      clientewwgetfilterdata.this.aP5 = new String[] {""};
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
      clientewwgetfilterdata.this.AV40DDOName = aP0;
      clientewwgetfilterdata.this.AV41SearchTxt = aP1;
      clientewwgetfilterdata.this.AV42SearchTxtTo = aP2;
      clientewwgetfilterdata.this.aP3 = aP3;
      clientewwgetfilterdata.this.aP4 = aP4;
      clientewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV47EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      clientewwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV47EmpCod = GXt_int1 ;
      GXt_int3 = AV48CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      clientewwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV48CliCod = GXt_int3 ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente", GXv_boolean6) ;
      clientewwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_CLINOM") == 0 )
         {
            /* Execute user subroutine: 'LOADCLINOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV43OptionsJson = AV30Options.toJSonString(false) ;
      AV44OptionsDescJson = AV32OptionsDesc.toJSonString(false) ;
      AV45OptionIndexesJson = AV33OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV35Session.getValue("ClienteWWGridState"), "") == 0 )
      {
         AV37GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteWWGridState"), null, null);
      }
      else
      {
         AV37GridState.fromxml(AV35Session.getValue("ClienteWWGridState"), null, null);
      }
      AV54GXV1 = 1 ;
      while ( AV54GXV1 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV54GXV1));
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINOM") == 0 )
         {
            AV14TFCliNom = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINOM_SEL") == 0 )
         {
            AV13TFCliNom_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFCliNom_Sels.fromJSonString(AV13TFCliNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICUIT") == 0 )
         {
            AV17TFCliCUIT = GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV50TFCliCUIT_To = GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIFECALTA") == 0 )
         {
            AV19TFCliFecAlta = localUtil.ctod( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV20TFCliFecAlta_To = localUtil.ctod( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIMULTIEMP_SEL") == 0 )
         {
            AV21TFCliMultiEmp_Sel = (byte)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTEPADRE") == 0 )
         {
            AV22TFClientePadre = GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV23TFClientePadre_To = GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIPAICOD") == 0 )
         {
            AV24TFCliPaiCod = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV25TFCliPaiCod_To = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTESISTEMA_SEL") == 0 )
         {
            AV26TFClienteSistema_Sel = (byte)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIENTECONVENIADOR_SEL") == 0 )
         {
            AV27TFClienteConveniador_Sel = (byte)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV54GXV1 = (int)(AV54GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCLINOMOPTIONS' Routine */
      returnInSub = false ;
      AV14TFCliNom = AV41SearchTxt ;
      AV15TFCliNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56Clientewwds_1_tfclicod = AV11TFCliCod ;
      AV57Clientewwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV58Clientewwds_3_tfclinom = AV14TFCliNom ;
      AV59Clientewwds_4_tfclinom_sels = AV15TFCliNom_Sels ;
      AV60Clientewwds_5_tfclicuit = AV17TFCliCUIT ;
      AV61Clientewwds_6_tfclicuit_to = AV50TFCliCUIT_To ;
      AV62Clientewwds_7_tfclifecalta = AV19TFCliFecAlta ;
      AV63Clientewwds_8_tfclifecalta_to = AV20TFCliFecAlta_To ;
      AV64Clientewwds_9_tfclimultiemp_sel = AV21TFCliMultiEmp_Sel ;
      AV65Clientewwds_10_tfclientepadre = AV22TFClientePadre ;
      AV66Clientewwds_11_tfclientepadre_to = AV23TFClientePadre_To ;
      AV67Clientewwds_12_tfclipaicod = AV24TFCliPaiCod ;
      AV68Clientewwds_13_tfclipaicod_to = AV25TFCliPaiCod_To ;
      AV69Clientewwds_14_tfclientesistema_sel = AV26TFClienteSistema_Sel ;
      AV70Clientewwds_15_tfclienteconveniador_sel = AV27TFClienteConveniador_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A344CliNom ,
                                           AV59Clientewwds_4_tfclinom_sels ,
                                           Integer.valueOf(AV56Clientewwds_1_tfclicod) ,
                                           Integer.valueOf(AV57Clientewwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV59Clientewwds_4_tfclinom_sels.size()) ,
                                           AV58Clientewwds_3_tfclinom ,
                                           Long.valueOf(AV60Clientewwds_5_tfclicuit) ,
                                           Long.valueOf(AV61Clientewwds_6_tfclicuit_to) ,
                                           AV62Clientewwds_7_tfclifecalta ,
                                           AV63Clientewwds_8_tfclifecalta_to ,
                                           Byte.valueOf(AV64Clientewwds_9_tfclimultiemp_sel) ,
                                           Long.valueOf(AV65Clientewwds_10_tfclientepadre) ,
                                           Long.valueOf(AV66Clientewwds_11_tfclientepadre_to) ,
                                           Short.valueOf(AV67Clientewwds_12_tfclipaicod) ,
                                           Short.valueOf(AV68Clientewwds_13_tfclipaicod_to) ,
                                           Byte.valueOf(AV69Clientewwds_14_tfclientesistema_sel) ,
                                           Byte.valueOf(AV70Clientewwds_15_tfclienteconveniador_sel) ,
                                           Short.valueOf(AV49PaiCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A345CliCUIT) ,
                                           A346CliFecAlta ,
                                           Boolean.valueOf(A366CliMultiEmp) ,
                                           Long.valueOf(A546ClientePadre) ,
                                           Short.valueOf(A4CliPaiCod) ,
                                           Boolean.valueOf(A747ClienteSistema) ,
                                           Boolean.valueOf(A1605ClienteConveniador) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BYTE,
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.LONG, TypeConstants.DATE,
                                           TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      lV58Clientewwds_3_tfclinom = GXutil.concat( GXutil.rtrim( AV58Clientewwds_3_tfclinom), "%", "") ;
      /* Using cursor P01I02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56Clientewwds_1_tfclicod), Integer.valueOf(AV57Clientewwds_2_tfclicod_to), lV58Clientewwds_3_tfclinom, Long.valueOf(AV60Clientewwds_5_tfclicuit), Long.valueOf(AV61Clientewwds_6_tfclicuit_to), AV62Clientewwds_7_tfclifecalta, AV63Clientewwds_8_tfclifecalta_to, Long.valueOf(AV65Clientewwds_10_tfclientepadre), Long.valueOf(AV66Clientewwds_11_tfclientepadre_to), Short.valueOf(AV67Clientewwds_12_tfclipaicod), Short.valueOf(AV68Clientewwds_13_tfclipaicod_to), Short.valueOf(AV49PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1I02 = false ;
         A344CliNom = P01I02_A344CliNom[0] ;
         A1605ClienteConveniador = P01I02_A1605ClienteConveniador[0] ;
         A747ClienteSistema = P01I02_A747ClienteSistema[0] ;
         A4CliPaiCod = P01I02_A4CliPaiCod[0] ;
         n4CliPaiCod = P01I02_n4CliPaiCod[0] ;
         A546ClientePadre = P01I02_A546ClientePadre[0] ;
         n546ClientePadre = P01I02_n546ClientePadre[0] ;
         A366CliMultiEmp = P01I02_A366CliMultiEmp[0] ;
         A346CliFecAlta = P01I02_A346CliFecAlta[0] ;
         A345CliCUIT = P01I02_A345CliCUIT[0] ;
         A3CliCod = P01I02_A3CliCod[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01I02_A344CliNom[0], A344CliNom) == 0 ) )
         {
            brk1I02 = false ;
            A3CliCod = P01I02_A3CliCod[0] ;
            AV34count = (long)(AV34count+1) ;
            brk1I02 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A344CliNom)==0) )
         {
            AV29Option = A344CliNom ;
            AV30Options.add(AV29Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1I02 )
         {
            brk1I02 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = clientewwgetfilterdata.this.AV43OptionsJson;
      this.aP4[0] = clientewwgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = clientewwgetfilterdata.this.AV45OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV43OptionsJson = "" ;
      AV44OptionsDescJson = "" ;
      AV45OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV35Session = httpContext.getWebSession();
      AV37GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV38GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFCliNom = "" ;
      AV13TFCliNom_SelsJson = "" ;
      AV15TFCliNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFCliFecAlta = GXutil.nullDate() ;
      AV20TFCliFecAlta_To = GXutil.nullDate() ;
      AV51MenuOpcCod = "" ;
      A344CliNom = "" ;
      AV58Clientewwds_3_tfclinom = "" ;
      AV59Clientewwds_4_tfclinom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Clientewwds_7_tfclifecalta = GXutil.nullDate() ;
      AV63Clientewwds_8_tfclifecalta_to = GXutil.nullDate() ;
      scmdbuf = "" ;
      lV58Clientewwds_3_tfclinom = "" ;
      A346CliFecAlta = GXutil.nullDate() ;
      P01I02_A344CliNom = new String[] {""} ;
      P01I02_A1605ClienteConveniador = new boolean[] {false} ;
      P01I02_A747ClienteSistema = new boolean[] {false} ;
      P01I02_A4CliPaiCod = new short[1] ;
      P01I02_n4CliPaiCod = new boolean[] {false} ;
      P01I02_A546ClientePadre = new long[1] ;
      P01I02_n546ClientePadre = new boolean[] {false} ;
      P01I02_A366CliMultiEmp = new boolean[] {false} ;
      P01I02_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      P01I02_A345CliCUIT = new long[1] ;
      P01I02_A3CliCod = new int[1] ;
      AV29Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01I02_A344CliNom, P01I02_A1605ClienteConveniador, P01I02_A747ClienteSistema, P01I02_A4CliPaiCod, P01I02_n4CliPaiCod, P01I02_A546ClientePadre, P01I02_n546ClientePadre, P01I02_A366CliMultiEmp, P01I02_A346CliFecAlta, P01I02_A345CliCUIT,
            P01I02_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21TFCliMultiEmp_Sel ;
   private byte AV26TFClienteSistema_Sel ;
   private byte AV27TFClienteConveniador_Sel ;
   private byte AV64Clientewwds_9_tfclimultiemp_sel ;
   private byte AV69Clientewwds_14_tfclientesistema_sel ;
   private byte AV70Clientewwds_15_tfclienteconveniador_sel ;
   private short AV47EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV24TFCliPaiCod ;
   private short AV25TFCliPaiCod_To ;
   private short AV67Clientewwds_12_tfclipaicod ;
   private short AV68Clientewwds_13_tfclipaicod_to ;
   private short AV49PaiCod ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV48CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV54GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV56Clientewwds_1_tfclicod ;
   private int AV57Clientewwds_2_tfclicod_to ;
   private int AV59Clientewwds_4_tfclinom_sels_size ;
   private int A3CliCod ;
   private long AV17TFCliCUIT ;
   private long AV50TFCliCUIT_To ;
   private long AV22TFClientePadre ;
   private long AV23TFClientePadre_To ;
   private long AV60Clientewwds_5_tfclicuit ;
   private long AV61Clientewwds_6_tfclicuit_to ;
   private long AV65Clientewwds_10_tfclientepadre ;
   private long AV66Clientewwds_11_tfclientepadre_to ;
   private long A345CliCUIT ;
   private long A546ClientePadre ;
   private long AV34count ;
   private String scmdbuf ;
   private java.util.Date AV19TFCliFecAlta ;
   private java.util.Date AV20TFCliFecAlta_To ;
   private java.util.Date AV62Clientewwds_7_tfclifecalta ;
   private java.util.Date AV63Clientewwds_8_tfclifecalta_to ;
   private java.util.Date A346CliFecAlta ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A366CliMultiEmp ;
   private boolean A747ClienteSistema ;
   private boolean A1605ClienteConveniador ;
   private boolean brk1I02 ;
   private boolean n4CliPaiCod ;
   private boolean n546ClientePadre ;
   private String AV43OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV45OptionIndexesJson ;
   private String AV13TFCliNom_SelsJson ;
   private String AV40DDOName ;
   private String AV41SearchTxt ;
   private String AV42SearchTxtTo ;
   private String AV14TFCliNom ;
   private String AV51MenuOpcCod ;
   private String A344CliNom ;
   private String AV58Clientewwds_3_tfclinom ;
   private String lV58Clientewwds_3_tfclinom ;
   private String AV29Option ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01I02_A344CliNom ;
   private boolean[] P01I02_A1605ClienteConveniador ;
   private boolean[] P01I02_A747ClienteSistema ;
   private short[] P01I02_A4CliPaiCod ;
   private boolean[] P01I02_n4CliPaiCod ;
   private long[] P01I02_A546ClientePadre ;
   private boolean[] P01I02_n546ClientePadre ;
   private boolean[] P01I02_A366CliMultiEmp ;
   private java.util.Date[] P01I02_A346CliFecAlta ;
   private long[] P01I02_A345CliCUIT ;
   private int[] P01I02_A3CliCod ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV32OptionsDesc ;
   private GXSimpleCollection<String> AV33OptionIndexes ;
   private GXSimpleCollection<String> AV15TFCliNom_Sels ;
   private GXSimpleCollection<String> AV59Clientewwds_4_tfclinom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV37GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV38GridStateFilterValue ;
}

final  class clientewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01I02( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A344CliNom ,
                                          GXSimpleCollection<String> AV59Clientewwds_4_tfclinom_sels ,
                                          int AV56Clientewwds_1_tfclicod ,
                                          int AV57Clientewwds_2_tfclicod_to ,
                                          int AV59Clientewwds_4_tfclinom_sels_size ,
                                          String AV58Clientewwds_3_tfclinom ,
                                          long AV60Clientewwds_5_tfclicuit ,
                                          long AV61Clientewwds_6_tfclicuit_to ,
                                          java.util.Date AV62Clientewwds_7_tfclifecalta ,
                                          java.util.Date AV63Clientewwds_8_tfclifecalta_to ,
                                          byte AV64Clientewwds_9_tfclimultiemp_sel ,
                                          long AV65Clientewwds_10_tfclientepadre ,
                                          long AV66Clientewwds_11_tfclientepadre_to ,
                                          short AV67Clientewwds_12_tfclipaicod ,
                                          short AV68Clientewwds_13_tfclipaicod_to ,
                                          byte AV69Clientewwds_14_tfclientesistema_sel ,
                                          byte AV70Clientewwds_15_tfclienteconveniador_sel ,
                                          short AV49PaiCod ,
                                          int A3CliCod ,
                                          long A345CliCUIT ,
                                          java.util.Date A346CliFecAlta ,
                                          boolean A366CliMultiEmp ,
                                          long A546ClientePadre ,
                                          short A4CliPaiCod ,
                                          boolean A747ClienteSistema ,
                                          boolean A1605ClienteConveniador )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliNom, ClienteConveniador, ClienteSistema, CliPaiCod, ClientePadre, CliMultiEmp, CliFecAlta, CliCUIT, CliCod FROM Cliente" ;
      if ( ! (0==AV56Clientewwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV57Clientewwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV59Clientewwds_4_tfclinom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Clientewwds_3_tfclinom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CliNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV59Clientewwds_4_tfclinom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Clientewwds_4_tfclinom_sels, "CliNom IN (", ")")+")");
      }
      if ( ! (0==AV60Clientewwds_5_tfclicuit) )
      {
         addWhere(sWhereString, "(CliCUIT >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV61Clientewwds_6_tfclicuit_to) )
      {
         addWhere(sWhereString, "(CliCUIT <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV62Clientewwds_7_tfclifecalta)) )
      {
         addWhere(sWhereString, "(CliFecAlta >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV63Clientewwds_8_tfclifecalta_to)) )
      {
         addWhere(sWhereString, "(CliFecAlta <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV64Clientewwds_9_tfclimultiemp_sel == 1 )
      {
         addWhere(sWhereString, "(CliMultiEmp = TRUE)");
      }
      if ( AV64Clientewwds_9_tfclimultiemp_sel == 2 )
      {
         addWhere(sWhereString, "(CliMultiEmp = FALSE)");
      }
      if ( ! (0==AV65Clientewwds_10_tfclientepadre) )
      {
         addWhere(sWhereString, "(ClientePadre >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV66Clientewwds_11_tfclientepadre_to) )
      {
         addWhere(sWhereString, "(ClientePadre <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV67Clientewwds_12_tfclipaicod) )
      {
         addWhere(sWhereString, "(CliPaiCod >= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV68Clientewwds_13_tfclipaicod_to) )
      {
         addWhere(sWhereString, "(CliPaiCod <= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV69Clientewwds_14_tfclientesistema_sel == 1 )
      {
         addWhere(sWhereString, "(ClienteSistema = TRUE)");
      }
      if ( AV69Clientewwds_14_tfclientesistema_sel == 2 )
      {
         addWhere(sWhereString, "(ClienteSistema = FALSE)");
      }
      if ( AV70Clientewwds_15_tfclienteconveniador_sel == 1 )
      {
         addWhere(sWhereString, "(ClienteConveniador = TRUE)");
      }
      if ( AV70Clientewwds_15_tfclienteconveniador_sel == 2 )
      {
         addWhere(sWhereString, "(ClienteConveniador = FALSE)");
      }
      if ( ! (0==AV49PaiCod) )
      {
         addWhere(sWhereString, "(CliPaiCod = ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01I02(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).longValue() , (java.util.Date)dynConstraints[20] , ((Boolean) dynConstraints[21]).booleanValue() , ((Number) dynConstraints[22]).longValue() , ((Number) dynConstraints[23]).shortValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01I02", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(7);
               ((long[]) buf[9])[0] = rslt.getLong(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[15]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[16]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[17]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[18]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[20]).longValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               return;
      }
   }

}

