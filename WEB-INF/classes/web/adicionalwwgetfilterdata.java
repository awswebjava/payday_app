package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class adicionalwwgetfilterdata extends GXProcedure
{
   public adicionalwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( adicionalwwgetfilterdata.class ), "" );
   }

   public adicionalwwgetfilterdata( int remoteHandle ,
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
      adicionalwwgetfilterdata.this.aP5 = new String[] {""};
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
      adicionalwwgetfilterdata.this.AV28DDOName = aP0;
      adicionalwwgetfilterdata.this.AV29SearchTxt = aP1;
      adicionalwwgetfilterdata.this.AV30SearchTxtTo = aP2;
      adicionalwwgetfilterdata.this.aP3 = aP3;
      adicionalwwgetfilterdata.this.aP4 = aP4;
      adicionalwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      adicionalwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      adicionalwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAdicional", GXv_boolean6) ;
      adicionalwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ADICIONALCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADADICIONALCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_ADICIONALDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADADICIONALDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("AdicionalWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "AdicionalWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("AdicionalWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFADICIONALCOD") == 0 )
         {
            AV37TFAdicionalCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFADICIONALCOD_SEL") == 0 )
         {
            AV11TFAdicionalCod_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFAdicionalCod_Sels.fromJSonString(AV11TFAdicionalCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFADICIONALDESCRIP") == 0 )
         {
            AV14TFAdicionalDescrip = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFADICIONALDESCRIP_SEL") == 0 )
         {
            AV13TFAdicionalDescrip_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFAdicionalDescrip_Sels.fromJSonString(AV13TFAdicionalDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFADICIONALRESERVADO_SEL") == 0 )
         {
            AV39TFAdicionalReservado_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFAdicionalReservado_Sels.fromJSonString(AV39TFAdicionalReservado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADADICIONALCODOPTIONS' Routine */
      returnInSub = false ;
      AV37TFAdicionalCod = AV29SearchTxt ;
      AV12TFAdicionalCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Adicionalwwds_1_tfadicionalcod = AV37TFAdicionalCod ;
      AV47Adicionalwwds_2_tfadicionalcod_sels = AV12TFAdicionalCod_Sels ;
      AV48Adicionalwwds_3_tfadicionaldescrip = AV14TFAdicionalDescrip ;
      AV49Adicionalwwds_4_tfadicionaldescrip_sels = AV15TFAdicionalDescrip_Sels ;
      AV50Adicionalwwds_5_tfadicionalreservado_sels = AV40TFAdicionalReservado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A988AdicionalCod ,
                                           AV47Adicionalwwds_2_tfadicionalcod_sels ,
                                           A989AdicionalDescrip ,
                                           AV49Adicionalwwds_4_tfadicionaldescrip_sels ,
                                           A1784AdicionalReservado ,
                                           AV50Adicionalwwds_5_tfadicionalreservado_sels ,
                                           Integer.valueOf(AV47Adicionalwwds_2_tfadicionalcod_sels.size()) ,
                                           AV46Adicionalwwds_1_tfadicionalcod ,
                                           Integer.valueOf(AV49Adicionalwwds_4_tfadicionaldescrip_sels.size()) ,
                                           AV48Adicionalwwds_3_tfadicionaldescrip ,
                                           Integer.valueOf(AV50Adicionalwwds_5_tfadicionalreservado_sels.size()) ,
                                           Short.valueOf(AV38PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV46Adicionalwwds_1_tfadicionalcod = GXutil.padr( GXutil.rtrim( AV46Adicionalwwds_1_tfadicionalcod), 20, "%") ;
      lV48Adicionalwwds_3_tfadicionaldescrip = GXutil.concat( GXutil.rtrim( AV48Adicionalwwds_3_tfadicionaldescrip), "%", "") ;
      /* Using cursor P01382 */
      pr_default.execute(0, new Object[] {lV46Adicionalwwds_1_tfadicionalcod, lV48Adicionalwwds_3_tfadicionaldescrip, Short.valueOf(AV38PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1382 = false ;
         A988AdicionalCod = P01382_A988AdicionalCod[0] ;
         A46PaiCod = P01382_A46PaiCod[0] ;
         A1784AdicionalReservado = P01382_A1784AdicionalReservado[0] ;
         A989AdicionalDescrip = P01382_A989AdicionalDescrip[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01382_A988AdicionalCod[0], A988AdicionalCod) == 0 ) )
         {
            brk1382 = false ;
            A46PaiCod = P01382_A46PaiCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1382 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A988AdicionalCod)==0) )
         {
            AV17Option = A988AdicionalCod ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1382 )
         {
            brk1382 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADADICIONALDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFAdicionalDescrip = AV29SearchTxt ;
      AV15TFAdicionalDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Adicionalwwds_1_tfadicionalcod = AV37TFAdicionalCod ;
      AV47Adicionalwwds_2_tfadicionalcod_sels = AV12TFAdicionalCod_Sels ;
      AV48Adicionalwwds_3_tfadicionaldescrip = AV14TFAdicionalDescrip ;
      AV49Adicionalwwds_4_tfadicionaldescrip_sels = AV15TFAdicionalDescrip_Sels ;
      AV50Adicionalwwds_5_tfadicionalreservado_sels = AV40TFAdicionalReservado_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A988AdicionalCod ,
                                           AV47Adicionalwwds_2_tfadicionalcod_sels ,
                                           A989AdicionalDescrip ,
                                           AV49Adicionalwwds_4_tfadicionaldescrip_sels ,
                                           A1784AdicionalReservado ,
                                           AV50Adicionalwwds_5_tfadicionalreservado_sels ,
                                           Integer.valueOf(AV47Adicionalwwds_2_tfadicionalcod_sels.size()) ,
                                           AV46Adicionalwwds_1_tfadicionalcod ,
                                           Integer.valueOf(AV49Adicionalwwds_4_tfadicionaldescrip_sels.size()) ,
                                           AV48Adicionalwwds_3_tfadicionaldescrip ,
                                           Integer.valueOf(AV50Adicionalwwds_5_tfadicionalreservado_sels.size()) ,
                                           Short.valueOf(AV38PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV46Adicionalwwds_1_tfadicionalcod = GXutil.padr( GXutil.rtrim( AV46Adicionalwwds_1_tfadicionalcod), 20, "%") ;
      lV48Adicionalwwds_3_tfadicionaldescrip = GXutil.concat( GXutil.rtrim( AV48Adicionalwwds_3_tfadicionaldescrip), "%", "") ;
      /* Using cursor P01383 */
      pr_default.execute(1, new Object[] {lV46Adicionalwwds_1_tfadicionalcod, lV48Adicionalwwds_3_tfadicionaldescrip, Short.valueOf(AV38PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1384 = false ;
         A989AdicionalDescrip = P01383_A989AdicionalDescrip[0] ;
         A46PaiCod = P01383_A46PaiCod[0] ;
         A1784AdicionalReservado = P01383_A1784AdicionalReservado[0] ;
         A988AdicionalCod = P01383_A988AdicionalCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01383_A989AdicionalDescrip[0], A989AdicionalDescrip) == 0 ) )
         {
            brk1384 = false ;
            A46PaiCod = P01383_A46PaiCod[0] ;
            A988AdicionalCod = P01383_A988AdicionalCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1384 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A989AdicionalDescrip)==0) )
         {
            AV17Option = A989AdicionalDescrip ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1384 )
         {
            brk1384 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = adicionalwwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = adicionalwwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = adicionalwwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV37TFAdicionalCod = "" ;
      AV11TFAdicionalCod_SelsJson = "" ;
      AV12TFAdicionalCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFAdicionalDescrip = "" ;
      AV13TFAdicionalDescrip_SelsJson = "" ;
      AV15TFAdicionalDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39TFAdicionalReservado_SelsJson = "" ;
      AV40TFAdicionalReservado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A988AdicionalCod = "" ;
      AV46Adicionalwwds_1_tfadicionalcod = "" ;
      AV47Adicionalwwds_2_tfadicionalcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48Adicionalwwds_3_tfadicionaldescrip = "" ;
      AV49Adicionalwwds_4_tfadicionaldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Adicionalwwds_5_tfadicionalreservado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV46Adicionalwwds_1_tfadicionalcod = "" ;
      lV48Adicionalwwds_3_tfadicionaldescrip = "" ;
      A989AdicionalDescrip = "" ;
      A1784AdicionalReservado = "" ;
      P01382_A988AdicionalCod = new String[] {""} ;
      P01382_A46PaiCod = new short[1] ;
      P01382_A1784AdicionalReservado = new String[] {""} ;
      P01382_A989AdicionalDescrip = new String[] {""} ;
      AV17Option = "" ;
      P01383_A989AdicionalDescrip = new String[] {""} ;
      P01383_A46PaiCod = new short[1] ;
      P01383_A1784AdicionalReservado = new String[] {""} ;
      P01383_A988AdicionalCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.adicionalwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01382_A988AdicionalCod, P01382_A46PaiCod, P01382_A1784AdicionalReservado, P01382_A989AdicionalDescrip
            }
            , new Object[] {
            P01383_A989AdicionalDescrip, P01383_A46PaiCod, P01383_A1784AdicionalReservado, P01383_A988AdicionalCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV38PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV44GXV1 ;
   private int AV47Adicionalwwds_2_tfadicionalcod_sels_size ;
   private int AV49Adicionalwwds_4_tfadicionaldescrip_sels_size ;
   private int AV50Adicionalwwds_5_tfadicionalreservado_sels_size ;
   private long AV22count ;
   private String AV37TFAdicionalCod ;
   private String A988AdicionalCod ;
   private String AV46Adicionalwwds_1_tfadicionalcod ;
   private String scmdbuf ;
   private String lV46Adicionalwwds_1_tfadicionalcod ;
   private String A1784AdicionalReservado ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1382 ;
   private boolean brk1384 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV11TFAdicionalCod_SelsJson ;
   private String AV13TFAdicionalDescrip_SelsJson ;
   private String AV39TFAdicionalReservado_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFAdicionalDescrip ;
   private String AV41MenuOpcCod ;
   private String AV48Adicionalwwds_3_tfadicionaldescrip ;
   private String lV48Adicionalwwds_3_tfadicionaldescrip ;
   private String A989AdicionalDescrip ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01382_A988AdicionalCod ;
   private short[] P01382_A46PaiCod ;
   private String[] P01382_A1784AdicionalReservado ;
   private String[] P01382_A989AdicionalDescrip ;
   private String[] P01383_A989AdicionalDescrip ;
   private short[] P01383_A46PaiCod ;
   private String[] P01383_A1784AdicionalReservado ;
   private String[] P01383_A988AdicionalCod ;
   private GXSimpleCollection<String> AV12TFAdicionalCod_Sels ;
   private GXSimpleCollection<String> AV40TFAdicionalReservado_Sels ;
   private GXSimpleCollection<String> AV47Adicionalwwds_2_tfadicionalcod_sels ;
   private GXSimpleCollection<String> AV50Adicionalwwds_5_tfadicionalreservado_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFAdicionalDescrip_Sels ;
   private GXSimpleCollection<String> AV49Adicionalwwds_4_tfadicionaldescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class adicionalwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01382( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A988AdicionalCod ,
                                          GXSimpleCollection<String> AV47Adicionalwwds_2_tfadicionalcod_sels ,
                                          String A989AdicionalDescrip ,
                                          GXSimpleCollection<String> AV49Adicionalwwds_4_tfadicionaldescrip_sels ,
                                          String A1784AdicionalReservado ,
                                          GXSimpleCollection<String> AV50Adicionalwwds_5_tfadicionalreservado_sels ,
                                          int AV47Adicionalwwds_2_tfadicionalcod_sels_size ,
                                          String AV46Adicionalwwds_1_tfadicionalcod ,
                                          int AV49Adicionalwwds_4_tfadicionaldescrip_sels_size ,
                                          String AV48Adicionalwwds_3_tfadicionaldescrip ,
                                          int AV50Adicionalwwds_5_tfadicionalreservado_sels_size ,
                                          short AV38PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT AdicionalCod, PaiCod, AdicionalReservado, AdicionalDescrip FROM Adicional" ;
      if ( ( AV47Adicionalwwds_2_tfadicionalcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Adicionalwwds_1_tfadicionalcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AdicionalCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV47Adicionalwwds_2_tfadicionalcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Adicionalwwds_2_tfadicionalcod_sels, "AdicionalCod IN (", ")")+")");
      }
      if ( ( AV49Adicionalwwds_4_tfadicionaldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Adicionalwwds_3_tfadicionaldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AdicionalDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV49Adicionalwwds_4_tfadicionaldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Adicionalwwds_4_tfadicionaldescrip_sels, "AdicionalDescrip IN (", ")")+")");
      }
      if ( AV50Adicionalwwds_5_tfadicionalreservado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Adicionalwwds_5_tfadicionalreservado_sels, "AdicionalReservado IN (", ")")+")");
      }
      if ( ! (0==AV38PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AdicionalCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01383( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A988AdicionalCod ,
                                          GXSimpleCollection<String> AV47Adicionalwwds_2_tfadicionalcod_sels ,
                                          String A989AdicionalDescrip ,
                                          GXSimpleCollection<String> AV49Adicionalwwds_4_tfadicionaldescrip_sels ,
                                          String A1784AdicionalReservado ,
                                          GXSimpleCollection<String> AV50Adicionalwwds_5_tfadicionalreservado_sels ,
                                          int AV47Adicionalwwds_2_tfadicionalcod_sels_size ,
                                          String AV46Adicionalwwds_1_tfadicionalcod ,
                                          int AV49Adicionalwwds_4_tfadicionaldescrip_sels_size ,
                                          String AV48Adicionalwwds_3_tfadicionaldescrip ,
                                          int AV50Adicionalwwds_5_tfadicionalreservado_sels_size ,
                                          short AV38PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT AdicionalDescrip, PaiCod, AdicionalReservado, AdicionalCod FROM Adicional" ;
      if ( ( AV47Adicionalwwds_2_tfadicionalcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Adicionalwwds_1_tfadicionalcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AdicionalCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV47Adicionalwwds_2_tfadicionalcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Adicionalwwds_2_tfadicionalcod_sels, "AdicionalCod IN (", ")")+")");
      }
      if ( ( AV49Adicionalwwds_4_tfadicionaldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Adicionalwwds_3_tfadicionaldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AdicionalDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV49Adicionalwwds_4_tfadicionaldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Adicionalwwds_4_tfadicionaldescrip_sels, "AdicionalDescrip IN (", ")")+")");
      }
      if ( AV50Adicionalwwds_5_tfadicionalreservado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Adicionalwwds_5_tfadicionalreservado_sels, "AdicionalReservado IN (", ")")+")");
      }
      if ( ! (0==AV38PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AdicionalDescrip" ;
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
                  return conditional_P01382(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() );
            case 1 :
                  return conditional_P01383(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01382", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01383", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 400);
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
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 400);
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

