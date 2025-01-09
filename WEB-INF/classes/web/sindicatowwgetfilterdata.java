package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sindicatowwgetfilterdata extends GXProcedure
{
   public sindicatowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sindicatowwgetfilterdata.class ), "" );
   }

   public sindicatowwgetfilterdata( int remoteHandle ,
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
      sindicatowwgetfilterdata.this.aP5 = new String[] {""};
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
      sindicatowwgetfilterdata.this.AV17DDOName = aP0;
      sindicatowwgetfilterdata.this.AV15SearchTxt = aP1;
      sindicatowwgetfilterdata.this.AV16SearchTxtTo = aP2;
      sindicatowwgetfilterdata.this.aP3 = aP3;
      sindicatowwgetfilterdata.this.aP4 = aP4;
      sindicatowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV39EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      sindicatowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV39EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      sindicatowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSindicato", GXv_boolean6) ;
      sindicatowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_SINCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADSINCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_SINDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSINDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV21OptionsJson = AV20Options.toJSonString(false) ;
      AV24OptionsDescJson = AV23OptionsDesc.toJSonString(false) ;
      AV26OptionIndexesJson = AV25OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("SindicatoWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SindicatoWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("SindicatoWWGridState"), null, null);
      }
      AV49GXV1 = 1 ;
      while ( AV49GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV49GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCOD") == 0 )
         {
            AV10TFSinCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCOD_SEL") == 0 )
         {
            AV34TFSinCod_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFSinCod_Sels.fromJSonString(AV34TFSinCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDESCRIP") == 0 )
         {
            AV12TFSinDescrip = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDESCRIP_SEL") == 0 )
         {
            AV36TFSinDescrip_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSinDescrip_Sels.fromJSonString(AV36TFSinDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINCUOTAALI") == 0 )
         {
            AV42TFSinCuotaAli = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV43TFSinCuotaAli_To = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSINDEFAULT_SEL") == 0 )
         {
            AV46TFSinDefault_Sel = (byte)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV45MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV49GXV1 = (int)(AV49GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSINCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSinCod = AV15SearchTxt ;
      AV35TFSinCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Sindicatowwds_1_tfsincod = AV10TFSinCod ;
      AV52Sindicatowwds_2_tfsincod_sels = AV35TFSinCod_Sels ;
      AV53Sindicatowwds_3_tfsindescrip = AV12TFSinDescrip ;
      AV54Sindicatowwds_4_tfsindescrip_sels = AV37TFSinDescrip_Sels ;
      AV55Sindicatowwds_5_tfsincuotaali = AV42TFSinCuotaAli ;
      AV56Sindicatowwds_6_tfsincuotaali_to = AV43TFSinCuotaAli_To ;
      AV57Sindicatowwds_7_tfsindefault_sel = AV46TFSinDefault_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A14SinCod ,
                                           AV52Sindicatowwds_2_tfsincod_sels ,
                                           A331SinDescrip ,
                                           AV54Sindicatowwds_4_tfsindescrip_sels ,
                                           Integer.valueOf(AV52Sindicatowwds_2_tfsincod_sels.size()) ,
                                           AV51Sindicatowwds_1_tfsincod ,
                                           Integer.valueOf(AV54Sindicatowwds_4_tfsindescrip_sels.size()) ,
                                           AV53Sindicatowwds_3_tfsindescrip ,
                                           AV55Sindicatowwds_5_tfsincuotaali ,
                                           AV56Sindicatowwds_6_tfsincuotaali_to ,
                                           Byte.valueOf(AV57Sindicatowwds_7_tfsindefault_sel) ,
                                           Short.valueOf(AV44PaiCod) ,
                                           A930SinCuotaAli ,
                                           Boolean.valueOf(A906SinDefault) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                           }
      });
      lV51Sindicatowwds_1_tfsincod = GXutil.padr( GXutil.rtrim( AV51Sindicatowwds_1_tfsincod), 20, "%") ;
      lV53Sindicatowwds_3_tfsindescrip = GXutil.concat( GXutil.rtrim( AV53Sindicatowwds_3_tfsindescrip), "%", "") ;
      /* Using cursor P006H2 */
      pr_default.execute(0, new Object[] {lV51Sindicatowwds_1_tfsincod, lV53Sindicatowwds_3_tfsindescrip, AV55Sindicatowwds_5_tfsincuotaali, AV56Sindicatowwds_6_tfsincuotaali_to, Short.valueOf(AV44PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6H2 = false ;
         A14SinCod = P006H2_A14SinCod[0] ;
         A46PaiCod = P006H2_A46PaiCod[0] ;
         A906SinDefault = P006H2_A906SinDefault[0] ;
         A930SinCuotaAli = P006H2_A930SinCuotaAli[0] ;
         A331SinDescrip = P006H2_A331SinDescrip[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P006H2_A14SinCod[0], A14SinCod) == 0 ) )
         {
            brk6H2 = false ;
            A46PaiCod = P006H2_A46PaiCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk6H2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A14SinCod)==0) )
         {
            AV19Option = A14SinCod ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6H2 )
         {
            brk6H2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSINDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSinDescrip = AV15SearchTxt ;
      AV37TFSinDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Sindicatowwds_1_tfsincod = AV10TFSinCod ;
      AV52Sindicatowwds_2_tfsincod_sels = AV35TFSinCod_Sels ;
      AV53Sindicatowwds_3_tfsindescrip = AV12TFSinDescrip ;
      AV54Sindicatowwds_4_tfsindescrip_sels = AV37TFSinDescrip_Sels ;
      AV55Sindicatowwds_5_tfsincuotaali = AV42TFSinCuotaAli ;
      AV56Sindicatowwds_6_tfsincuotaali_to = AV43TFSinCuotaAli_To ;
      AV57Sindicatowwds_7_tfsindefault_sel = AV46TFSinDefault_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A14SinCod ,
                                           AV52Sindicatowwds_2_tfsincod_sels ,
                                           A331SinDescrip ,
                                           AV54Sindicatowwds_4_tfsindescrip_sels ,
                                           Integer.valueOf(AV52Sindicatowwds_2_tfsincod_sels.size()) ,
                                           AV51Sindicatowwds_1_tfsincod ,
                                           Integer.valueOf(AV54Sindicatowwds_4_tfsindescrip_sels.size()) ,
                                           AV53Sindicatowwds_3_tfsindescrip ,
                                           AV55Sindicatowwds_5_tfsincuotaali ,
                                           AV56Sindicatowwds_6_tfsincuotaali_to ,
                                           Byte.valueOf(AV57Sindicatowwds_7_tfsindefault_sel) ,
                                           Short.valueOf(AV44PaiCod) ,
                                           A930SinCuotaAli ,
                                           Boolean.valueOf(A906SinDefault) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                           }
      });
      lV51Sindicatowwds_1_tfsincod = GXutil.padr( GXutil.rtrim( AV51Sindicatowwds_1_tfsincod), 20, "%") ;
      lV53Sindicatowwds_3_tfsindescrip = GXutil.concat( GXutil.rtrim( AV53Sindicatowwds_3_tfsindescrip), "%", "") ;
      /* Using cursor P006H3 */
      pr_default.execute(1, new Object[] {lV51Sindicatowwds_1_tfsincod, lV53Sindicatowwds_3_tfsindescrip, AV55Sindicatowwds_5_tfsincuotaali, AV56Sindicatowwds_6_tfsincuotaali_to, Short.valueOf(AV44PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6H4 = false ;
         A331SinDescrip = P006H3_A331SinDescrip[0] ;
         A46PaiCod = P006H3_A46PaiCod[0] ;
         A906SinDefault = P006H3_A906SinDefault[0] ;
         A930SinCuotaAli = P006H3_A930SinCuotaAli[0] ;
         A14SinCod = P006H3_A14SinCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P006H3_A331SinDescrip[0], A331SinDescrip) == 0 ) )
         {
            brk6H4 = false ;
            A46PaiCod = P006H3_A46PaiCod[0] ;
            A14SinCod = P006H3_A14SinCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk6H4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A331SinDescrip)==0) )
         {
            AV19Option = A331SinDescrip ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6H4 )
         {
            brk6H4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = sindicatowwgetfilterdata.this.AV21OptionsJson;
      this.aP4[0] = sindicatowwgetfilterdata.this.AV24OptionsDescJson;
      this.aP5[0] = sindicatowwgetfilterdata.this.AV26OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21OptionsJson = "" ;
      AV24OptionsDescJson = "" ;
      AV26OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSinCod = "" ;
      AV34TFSinCod_SelsJson = "" ;
      AV35TFSinCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSinDescrip = "" ;
      AV36TFSinDescrip_SelsJson = "" ;
      AV37TFSinDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42TFSinCuotaAli = DecimalUtil.ZERO ;
      AV43TFSinCuotaAli_To = DecimalUtil.ZERO ;
      AV45MenuOpcCod = "" ;
      A14SinCod = "" ;
      AV51Sindicatowwds_1_tfsincod = "" ;
      AV52Sindicatowwds_2_tfsincod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Sindicatowwds_3_tfsindescrip = "" ;
      AV54Sindicatowwds_4_tfsindescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Sindicatowwds_5_tfsincuotaali = DecimalUtil.ZERO ;
      AV56Sindicatowwds_6_tfsincuotaali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV51Sindicatowwds_1_tfsincod = "" ;
      lV53Sindicatowwds_3_tfsindescrip = "" ;
      A331SinDescrip = "" ;
      A930SinCuotaAli = DecimalUtil.ZERO ;
      P006H2_A14SinCod = new String[] {""} ;
      P006H2_A46PaiCod = new short[1] ;
      P006H2_A906SinDefault = new boolean[] {false} ;
      P006H2_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006H2_A331SinDescrip = new String[] {""} ;
      AV19Option = "" ;
      P006H3_A331SinDescrip = new String[] {""} ;
      P006H3_A46PaiCod = new short[1] ;
      P006H3_A906SinDefault = new boolean[] {false} ;
      P006H3_A930SinCuotaAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006H3_A14SinCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sindicatowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006H2_A14SinCod, P006H2_A46PaiCod, P006H2_A906SinDefault, P006H2_A930SinCuotaAli, P006H2_A331SinDescrip
            }
            , new Object[] {
            P006H3_A331SinDescrip, P006H3_A46PaiCod, P006H3_A906SinDefault, P006H3_A930SinCuotaAli, P006H3_A14SinCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV46TFSinDefault_Sel ;
   private byte AV57Sindicatowwds_7_tfsindefault_sel ;
   private short AV39EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV44PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV49GXV1 ;
   private int AV52Sindicatowwds_2_tfsincod_sels_size ;
   private int AV54Sindicatowwds_4_tfsindescrip_sels_size ;
   private long AV27count ;
   private java.math.BigDecimal AV42TFSinCuotaAli ;
   private java.math.BigDecimal AV43TFSinCuotaAli_To ;
   private java.math.BigDecimal AV55Sindicatowwds_5_tfsincuotaali ;
   private java.math.BigDecimal AV56Sindicatowwds_6_tfsincuotaali_to ;
   private java.math.BigDecimal A930SinCuotaAli ;
   private String AV10TFSinCod ;
   private String A14SinCod ;
   private String AV51Sindicatowwds_1_tfsincod ;
   private String scmdbuf ;
   private String lV51Sindicatowwds_1_tfsincod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A906SinDefault ;
   private boolean brk6H2 ;
   private boolean brk6H4 ;
   private String AV21OptionsJson ;
   private String AV24OptionsDescJson ;
   private String AV26OptionIndexesJson ;
   private String AV34TFSinCod_SelsJson ;
   private String AV36TFSinDescrip_SelsJson ;
   private String AV17DDOName ;
   private String AV15SearchTxt ;
   private String AV16SearchTxtTo ;
   private String AV12TFSinDescrip ;
   private String AV45MenuOpcCod ;
   private String AV53Sindicatowwds_3_tfsindescrip ;
   private String lV53Sindicatowwds_3_tfsindescrip ;
   private String A331SinDescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P006H2_A14SinCod ;
   private short[] P006H2_A46PaiCod ;
   private boolean[] P006H2_A906SinDefault ;
   private java.math.BigDecimal[] P006H2_A930SinCuotaAli ;
   private String[] P006H2_A331SinDescrip ;
   private String[] P006H3_A331SinDescrip ;
   private short[] P006H3_A46PaiCod ;
   private boolean[] P006H3_A906SinDefault ;
   private java.math.BigDecimal[] P006H3_A930SinCuotaAli ;
   private String[] P006H3_A14SinCod ;
   private GXSimpleCollection<String> AV35TFSinCod_Sels ;
   private GXSimpleCollection<String> AV52Sindicatowwds_2_tfsincod_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private GXSimpleCollection<String> AV37TFSinDescrip_Sels ;
   private GXSimpleCollection<String> AV54Sindicatowwds_4_tfsindescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class sindicatowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A14SinCod ,
                                          GXSimpleCollection<String> AV52Sindicatowwds_2_tfsincod_sels ,
                                          String A331SinDescrip ,
                                          GXSimpleCollection<String> AV54Sindicatowwds_4_tfsindescrip_sels ,
                                          int AV52Sindicatowwds_2_tfsincod_sels_size ,
                                          String AV51Sindicatowwds_1_tfsincod ,
                                          int AV54Sindicatowwds_4_tfsindescrip_sels_size ,
                                          String AV53Sindicatowwds_3_tfsindescrip ,
                                          java.math.BigDecimal AV55Sindicatowwds_5_tfsincuotaali ,
                                          java.math.BigDecimal AV56Sindicatowwds_6_tfsincuotaali_to ,
                                          byte AV57Sindicatowwds_7_tfsindefault_sel ,
                                          short AV44PaiCod ,
                                          java.math.BigDecimal A930SinCuotaAli ,
                                          boolean A906SinDefault ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT SinCod, PaiCod, SinDefault, SinCuotaAli, SinDescrip FROM Sindicato" ;
      if ( ( AV52Sindicatowwds_2_tfsincod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Sindicatowwds_1_tfsincod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV52Sindicatowwds_2_tfsincod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Sindicatowwds_2_tfsincod_sels, "SinCod IN (", ")")+")");
      }
      if ( ( AV54Sindicatowwds_4_tfsindescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Sindicatowwds_3_tfsindescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV54Sindicatowwds_4_tfsindescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Sindicatowwds_4_tfsindescrip_sels, "SinDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Sindicatowwds_5_tfsincuotaali)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Sindicatowwds_6_tfsincuotaali_to)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV57Sindicatowwds_7_tfsindefault_sel == 1 )
      {
         addWhere(sWhereString, "(SinDefault = TRUE)");
      }
      if ( AV57Sindicatowwds_7_tfsindefault_sel == 2 )
      {
         addWhere(sWhereString, "(SinDefault = FALSE)");
      }
      if ( ! (0==AV44PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SinCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006H3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A14SinCod ,
                                          GXSimpleCollection<String> AV52Sindicatowwds_2_tfsincod_sels ,
                                          String A331SinDescrip ,
                                          GXSimpleCollection<String> AV54Sindicatowwds_4_tfsindescrip_sels ,
                                          int AV52Sindicatowwds_2_tfsincod_sels_size ,
                                          String AV51Sindicatowwds_1_tfsincod ,
                                          int AV54Sindicatowwds_4_tfsindescrip_sels_size ,
                                          String AV53Sindicatowwds_3_tfsindescrip ,
                                          java.math.BigDecimal AV55Sindicatowwds_5_tfsincuotaali ,
                                          java.math.BigDecimal AV56Sindicatowwds_6_tfsincuotaali_to ,
                                          byte AV57Sindicatowwds_7_tfsindefault_sel ,
                                          short AV44PaiCod ,
                                          java.math.BigDecimal A930SinCuotaAli ,
                                          boolean A906SinDefault ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SinDescrip, PaiCod, SinDefault, SinCuotaAli, SinCod FROM Sindicato" ;
      if ( ( AV52Sindicatowwds_2_tfsincod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Sindicatowwds_1_tfsincod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV52Sindicatowwds_2_tfsincod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Sindicatowwds_2_tfsincod_sels, "SinCod IN (", ")")+")");
      }
      if ( ( AV54Sindicatowwds_4_tfsindescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Sindicatowwds_3_tfsindescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SinDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV54Sindicatowwds_4_tfsindescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Sindicatowwds_4_tfsindescrip_sels, "SinDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Sindicatowwds_5_tfsincuotaali)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Sindicatowwds_6_tfsincuotaali_to)==0) )
      {
         addWhere(sWhereString, "(SinCuotaAli <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV57Sindicatowwds_7_tfsindefault_sel == 1 )
      {
         addWhere(sWhereString, "(SinDefault = TRUE)");
      }
      if ( AV57Sindicatowwds_7_tfsindefault_sel == 2 )
      {
         addWhere(sWhereString, "(SinDefault = FALSE)");
      }
      if ( ! (0==AV44PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SinDescrip" ;
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
                  return conditional_P006H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).shortValue() , (java.math.BigDecimal)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() );
            case 1 :
                  return conditional_P006H3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).shortValue() , (java.math.BigDecimal)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006H3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[7], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[7], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
      }
   }

}

