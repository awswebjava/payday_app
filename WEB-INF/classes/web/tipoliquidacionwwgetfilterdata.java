package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipoliquidacionwwgetfilterdata extends GXProcedure
{
   public tipoliquidacionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoliquidacionwwgetfilterdata.class ), "" );
   }

   public tipoliquidacionwwgetfilterdata( int remoteHandle ,
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
      tipoliquidacionwwgetfilterdata.this.aP5 = new String[] {""};
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
      tipoliquidacionwwgetfilterdata.this.AV17DDOName = aP0;
      tipoliquidacionwwgetfilterdata.this.AV15SearchTxt = aP1;
      tipoliquidacionwwgetfilterdata.this.AV16SearchTxtTo = aP2;
      tipoliquidacionwwgetfilterdata.this.aP3 = aP3;
      tipoliquidacionwwgetfilterdata.this.aP4 = aP4;
      tipoliquidacionwwgetfilterdata.this.aP5 = aP5;
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
      tipoliquidacionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV39EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipoliquidacionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion", GXv_boolean6) ;
      tipoliquidacionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_TLIQCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_TLIQDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQDESCOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_TLIQCODFOR") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQCODFOROPTIONS' */
            S141 ();
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
      if ( GXutil.strcmp(AV28Session.getValue("TipoLiquidacionWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoLiquidacionWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("TipoLiquidacionWWGridState"), null, null);
      }
      AV49GXV1 = 1 ;
      while ( AV49GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV49GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV10TFTLiqCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV34TFTLiqCod_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFTLiqCod_Sels.fromJSonString(AV34TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC") == 0 )
         {
            AV12TFTliqDesc = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC_SEL") == 0 )
         {
            AV36TFTliqDesc_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFTliqDesc_Sels.fromJSonString(AV36TFTliqDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQACUDIASTRAB_SEL") == 0 )
         {
            AV41TFTLiqAcuDiasTrab_Sel = (byte)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQSAC_SEL") == 0 )
         {
            AV42TFTliqSAC_Sel = (byte)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCODFOR") == 0 )
         {
            AV45TFTLiqCodFor = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCODFOR_SEL") == 0 )
         {
            AV44TFTLiqCodFor_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV46TFTLiqCodFor_Sels.fromJSonString(AV44TFTLiqCodFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV49GXV1 = (int)(AV49GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTLIQCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFTLiqCod = AV15SearchTxt ;
      AV35TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Tipoliquidacionwwds_1_tftliqcod = AV10TFTLiqCod ;
      AV52Tipoliquidacionwwds_2_tftliqcod_sels = AV35TFTLiqCod_Sels ;
      AV53Tipoliquidacionwwds_3_tftliqdesc = AV12TFTliqDesc ;
      AV54Tipoliquidacionwwds_4_tftliqdesc_sels = AV37TFTliqDesc_Sels ;
      AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel = AV41TFTLiqAcuDiasTrab_Sel ;
      AV56Tipoliquidacionwwds_6_tftliqsac_sel = AV42TFTliqSAC_Sel ;
      AV57Tipoliquidacionwwds_7_tftliqcodfor = AV45TFTLiqCodFor ;
      AV58Tipoliquidacionwwds_8_tftliqcodfor_sels = AV46TFTLiqCodFor_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A32TLiqCod ,
                                           AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                           A340TliqDesc ,
                                           AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                           A2091TLiqCodFor ,
                                           AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                           Integer.valueOf(AV52Tipoliquidacionwwds_2_tftliqcod_sels.size()) ,
                                           AV51Tipoliquidacionwwds_1_tftliqcod ,
                                           Integer.valueOf(AV54Tipoliquidacionwwds_4_tftliqdesc_sels.size()) ,
                                           AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                           Byte.valueOf(AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel) ,
                                           Byte.valueOf(AV56Tipoliquidacionwwds_6_tftliqsac_sel) ,
                                           Integer.valueOf(AV58Tipoliquidacionwwds_8_tftliqcodfor_sels.size()) ,
                                           AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                           Boolean.valueOf(A1076TLiqAcuDiasTrab) ,
                                           Boolean.valueOf(A1211TliqSAC) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Tipoliquidacionwwds_1_tftliqcod = GXutil.padr( GXutil.rtrim( AV51Tipoliquidacionwwds_1_tftliqcod), 20, "%") ;
      lV53Tipoliquidacionwwds_3_tftliqdesc = GXutil.concat( GXutil.rtrim( AV53Tipoliquidacionwwds_3_tftliqdesc), "%", "") ;
      lV57Tipoliquidacionwwds_7_tftliqcodfor = GXutil.padr( GXutil.rtrim( AV57Tipoliquidacionwwds_7_tftliqcodfor), 20, "%") ;
      /* Using cursor P008B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), lV51Tipoliquidacionwwds_1_tftliqcod, lV53Tipoliquidacionwwds_3_tftliqdesc, lV57Tipoliquidacionwwds_7_tftliqcodfor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk8B2 = false ;
         A3CliCod = P008B2_A3CliCod[0] ;
         A32TLiqCod = P008B2_A32TLiqCod[0] ;
         A2091TLiqCodFor = P008B2_A2091TLiqCodFor[0] ;
         A1211TliqSAC = P008B2_A1211TliqSAC[0] ;
         A1076TLiqAcuDiasTrab = P008B2_A1076TLiqAcuDiasTrab[0] ;
         A340TliqDesc = P008B2_A340TliqDesc[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P008B2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P008B2_A32TLiqCod[0], A32TLiqCod) == 0 ) )
         {
            brk8B2 = false ;
            AV27count = (long)(AV27count+1) ;
            brk8B2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A32TLiqCod)==0) )
         {
            AV19Option = A32TLiqCod ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk8B2 )
         {
            brk8B2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADTLIQDESCOPTIONS' Routine */
      returnInSub = false ;
      AV12TFTliqDesc = AV15SearchTxt ;
      AV37TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Tipoliquidacionwwds_1_tftliqcod = AV10TFTLiqCod ;
      AV52Tipoliquidacionwwds_2_tftliqcod_sels = AV35TFTLiqCod_Sels ;
      AV53Tipoliquidacionwwds_3_tftliqdesc = AV12TFTliqDesc ;
      AV54Tipoliquidacionwwds_4_tftliqdesc_sels = AV37TFTliqDesc_Sels ;
      AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel = AV41TFTLiqAcuDiasTrab_Sel ;
      AV56Tipoliquidacionwwds_6_tftliqsac_sel = AV42TFTliqSAC_Sel ;
      AV57Tipoliquidacionwwds_7_tftliqcodfor = AV45TFTLiqCodFor ;
      AV58Tipoliquidacionwwds_8_tftliqcodfor_sels = AV46TFTLiqCodFor_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A32TLiqCod ,
                                           AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                           A340TliqDesc ,
                                           AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                           A2091TLiqCodFor ,
                                           AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                           Integer.valueOf(AV52Tipoliquidacionwwds_2_tftliqcod_sels.size()) ,
                                           AV51Tipoliquidacionwwds_1_tftliqcod ,
                                           Integer.valueOf(AV54Tipoliquidacionwwds_4_tftliqdesc_sels.size()) ,
                                           AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                           Byte.valueOf(AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel) ,
                                           Byte.valueOf(AV56Tipoliquidacionwwds_6_tftliqsac_sel) ,
                                           Integer.valueOf(AV58Tipoliquidacionwwds_8_tftliqcodfor_sels.size()) ,
                                           AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                           Boolean.valueOf(A1076TLiqAcuDiasTrab) ,
                                           Boolean.valueOf(A1211TliqSAC) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Tipoliquidacionwwds_1_tftliqcod = GXutil.padr( GXutil.rtrim( AV51Tipoliquidacionwwds_1_tftliqcod), 20, "%") ;
      lV53Tipoliquidacionwwds_3_tftliqdesc = GXutil.concat( GXutil.rtrim( AV53Tipoliquidacionwwds_3_tftliqdesc), "%", "") ;
      lV57Tipoliquidacionwwds_7_tftliqcodfor = GXutil.padr( GXutil.rtrim( AV57Tipoliquidacionwwds_7_tftliqcodfor), 20, "%") ;
      /* Using cursor P008B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV38CliCod), lV51Tipoliquidacionwwds_1_tftliqcod, lV53Tipoliquidacionwwds_3_tftliqdesc, lV57Tipoliquidacionwwds_7_tftliqcodfor});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk8B4 = false ;
         A3CliCod = P008B3_A3CliCod[0] ;
         A340TliqDesc = P008B3_A340TliqDesc[0] ;
         A2091TLiqCodFor = P008B3_A2091TLiqCodFor[0] ;
         A1211TliqSAC = P008B3_A1211TliqSAC[0] ;
         A1076TLiqAcuDiasTrab = P008B3_A1076TLiqAcuDiasTrab[0] ;
         A32TLiqCod = P008B3_A32TLiqCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P008B3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P008B3_A340TliqDesc[0], A340TliqDesc) == 0 ) )
         {
            brk8B4 = false ;
            A32TLiqCod = P008B3_A32TLiqCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk8B4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A340TliqDesc)==0) )
         {
            AV19Option = A340TliqDesc ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk8B4 )
         {
            brk8B4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADTLIQCODFOROPTIONS' Routine */
      returnInSub = false ;
      AV45TFTLiqCodFor = AV15SearchTxt ;
      AV46TFTLiqCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Tipoliquidacionwwds_1_tftliqcod = AV10TFTLiqCod ;
      AV52Tipoliquidacionwwds_2_tftliqcod_sels = AV35TFTLiqCod_Sels ;
      AV53Tipoliquidacionwwds_3_tftliqdesc = AV12TFTliqDesc ;
      AV54Tipoliquidacionwwds_4_tftliqdesc_sels = AV37TFTliqDesc_Sels ;
      AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel = AV41TFTLiqAcuDiasTrab_Sel ;
      AV56Tipoliquidacionwwds_6_tftliqsac_sel = AV42TFTliqSAC_Sel ;
      AV57Tipoliquidacionwwds_7_tftliqcodfor = AV45TFTLiqCodFor ;
      AV58Tipoliquidacionwwds_8_tftliqcodfor_sels = AV46TFTLiqCodFor_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A32TLiqCod ,
                                           AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                           A340TliqDesc ,
                                           AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                           A2091TLiqCodFor ,
                                           AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                           Integer.valueOf(AV52Tipoliquidacionwwds_2_tftliqcod_sels.size()) ,
                                           AV51Tipoliquidacionwwds_1_tftliqcod ,
                                           Integer.valueOf(AV54Tipoliquidacionwwds_4_tftliqdesc_sels.size()) ,
                                           AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                           Byte.valueOf(AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel) ,
                                           Byte.valueOf(AV56Tipoliquidacionwwds_6_tftliqsac_sel) ,
                                           Integer.valueOf(AV58Tipoliquidacionwwds_8_tftliqcodfor_sels.size()) ,
                                           AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                           Boolean.valueOf(A1076TLiqAcuDiasTrab) ,
                                           Boolean.valueOf(A1211TliqSAC) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV51Tipoliquidacionwwds_1_tftliqcod = GXutil.padr( GXutil.rtrim( AV51Tipoliquidacionwwds_1_tftliqcod), 20, "%") ;
      lV53Tipoliquidacionwwds_3_tftliqdesc = GXutil.concat( GXutil.rtrim( AV53Tipoliquidacionwwds_3_tftliqdesc), "%", "") ;
      lV57Tipoliquidacionwwds_7_tftliqcodfor = GXutil.padr( GXutil.rtrim( AV57Tipoliquidacionwwds_7_tftliqcodfor), 20, "%") ;
      /* Using cursor P008B4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV38CliCod), lV51Tipoliquidacionwwds_1_tftliqcod, lV53Tipoliquidacionwwds_3_tftliqdesc, lV57Tipoliquidacionwwds_7_tftliqcodfor});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk8B6 = false ;
         A3CliCod = P008B4_A3CliCod[0] ;
         A2091TLiqCodFor = P008B4_A2091TLiqCodFor[0] ;
         A1211TliqSAC = P008B4_A1211TliqSAC[0] ;
         A1076TLiqAcuDiasTrab = P008B4_A1076TLiqAcuDiasTrab[0] ;
         A340TliqDesc = P008B4_A340TliqDesc[0] ;
         A32TLiqCod = P008B4_A32TLiqCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P008B4_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P008B4_A2091TLiqCodFor[0], A2091TLiqCodFor) == 0 ) )
         {
            brk8B6 = false ;
            A32TLiqCod = P008B4_A32TLiqCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk8B6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2091TLiqCodFor)==0) )
         {
            AV19Option = A2091TLiqCodFor ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk8B6 )
         {
            brk8B6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipoliquidacionwwgetfilterdata.this.AV21OptionsJson;
      this.aP4[0] = tipoliquidacionwwgetfilterdata.this.AV24OptionsDescJson;
      this.aP5[0] = tipoliquidacionwwgetfilterdata.this.AV26OptionIndexesJson;
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
      AV10TFTLiqCod = "" ;
      AV34TFTLiqCod_SelsJson = "" ;
      AV35TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFTliqDesc = "" ;
      AV36TFTliqDesc_SelsJson = "" ;
      AV37TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFTLiqCodFor = "" ;
      AV44TFTLiqCodFor_SelsJson = "" ;
      AV46TFTLiqCodFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43MenuOpcCod = "" ;
      A32TLiqCod = "" ;
      AV51Tipoliquidacionwwds_1_tftliqcod = "" ;
      AV52Tipoliquidacionwwds_2_tftliqcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Tipoliquidacionwwds_3_tftliqdesc = "" ;
      AV54Tipoliquidacionwwds_4_tftliqdesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Tipoliquidacionwwds_7_tftliqcodfor = "" ;
      AV58Tipoliquidacionwwds_8_tftliqcodfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Tipoliquidacionwwds_1_tftliqcod = "" ;
      lV53Tipoliquidacionwwds_3_tftliqdesc = "" ;
      lV57Tipoliquidacionwwds_7_tftliqcodfor = "" ;
      A340TliqDesc = "" ;
      A2091TLiqCodFor = "" ;
      P008B2_A3CliCod = new int[1] ;
      P008B2_A32TLiqCod = new String[] {""} ;
      P008B2_A2091TLiqCodFor = new String[] {""} ;
      P008B2_A1211TliqSAC = new boolean[] {false} ;
      P008B2_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      P008B2_A340TliqDesc = new String[] {""} ;
      AV19Option = "" ;
      P008B3_A3CliCod = new int[1] ;
      P008B3_A340TliqDesc = new String[] {""} ;
      P008B3_A2091TLiqCodFor = new String[] {""} ;
      P008B3_A1211TliqSAC = new boolean[] {false} ;
      P008B3_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      P008B3_A32TLiqCod = new String[] {""} ;
      P008B4_A3CliCod = new int[1] ;
      P008B4_A2091TLiqCodFor = new String[] {""} ;
      P008B4_A1211TliqSAC = new boolean[] {false} ;
      P008B4_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      P008B4_A340TliqDesc = new String[] {""} ;
      P008B4_A32TLiqCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipoliquidacionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P008B2_A3CliCod, P008B2_A32TLiqCod, P008B2_A2091TLiqCodFor, P008B2_A1211TliqSAC, P008B2_A1076TLiqAcuDiasTrab, P008B2_A340TliqDesc
            }
            , new Object[] {
            P008B3_A3CliCod, P008B3_A340TliqDesc, P008B3_A2091TLiqCodFor, P008B3_A1211TliqSAC, P008B3_A1076TLiqAcuDiasTrab, P008B3_A32TLiqCod
            }
            , new Object[] {
            P008B4_A3CliCod, P008B4_A2091TLiqCodFor, P008B4_A1211TliqSAC, P008B4_A1076TLiqAcuDiasTrab, P008B4_A340TliqDesc, P008B4_A32TLiqCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV41TFTLiqAcuDiasTrab_Sel ;
   private byte AV42TFTliqSAC_Sel ;
   private byte AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel ;
   private byte AV56Tipoliquidacionwwds_6_tftliqsac_sel ;
   private short AV39EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV49GXV1 ;
   private int AV52Tipoliquidacionwwds_2_tftliqcod_sels_size ;
   private int AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size ;
   private int AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private String AV10TFTLiqCod ;
   private String AV45TFTLiqCodFor ;
   private String A32TLiqCod ;
   private String AV51Tipoliquidacionwwds_1_tftliqcod ;
   private String AV57Tipoliquidacionwwds_7_tftliqcodfor ;
   private String scmdbuf ;
   private String lV51Tipoliquidacionwwds_1_tftliqcod ;
   private String lV57Tipoliquidacionwwds_7_tftliqcodfor ;
   private String A2091TLiqCodFor ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1076TLiqAcuDiasTrab ;
   private boolean A1211TliqSAC ;
   private boolean brk8B2 ;
   private boolean brk8B4 ;
   private boolean brk8B6 ;
   private String AV21OptionsJson ;
   private String AV24OptionsDescJson ;
   private String AV26OptionIndexesJson ;
   private String AV34TFTLiqCod_SelsJson ;
   private String AV36TFTliqDesc_SelsJson ;
   private String AV44TFTLiqCodFor_SelsJson ;
   private String AV17DDOName ;
   private String AV15SearchTxt ;
   private String AV16SearchTxtTo ;
   private String AV12TFTliqDesc ;
   private String AV43MenuOpcCod ;
   private String AV53Tipoliquidacionwwds_3_tftliqdesc ;
   private String lV53Tipoliquidacionwwds_3_tftliqdesc ;
   private String A340TliqDesc ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P008B2_A3CliCod ;
   private String[] P008B2_A32TLiqCod ;
   private String[] P008B2_A2091TLiqCodFor ;
   private boolean[] P008B2_A1211TliqSAC ;
   private boolean[] P008B2_A1076TLiqAcuDiasTrab ;
   private String[] P008B2_A340TliqDesc ;
   private int[] P008B3_A3CliCod ;
   private String[] P008B3_A340TliqDesc ;
   private String[] P008B3_A2091TLiqCodFor ;
   private boolean[] P008B3_A1211TliqSAC ;
   private boolean[] P008B3_A1076TLiqAcuDiasTrab ;
   private String[] P008B3_A32TLiqCod ;
   private int[] P008B4_A3CliCod ;
   private String[] P008B4_A2091TLiqCodFor ;
   private boolean[] P008B4_A1211TliqSAC ;
   private boolean[] P008B4_A1076TLiqAcuDiasTrab ;
   private String[] P008B4_A340TliqDesc ;
   private String[] P008B4_A32TLiqCod ;
   private GXSimpleCollection<String> AV35TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV46TFTLiqCodFor_Sels ;
   private GXSimpleCollection<String> AV52Tipoliquidacionwwds_2_tftliqcod_sels ;
   private GXSimpleCollection<String> AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private GXSimpleCollection<String> AV37TFTliqDesc_Sels ;
   private GXSimpleCollection<String> AV54Tipoliquidacionwwds_4_tftliqdesc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class tipoliquidacionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P008B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                          String A2091TLiqCodFor ,
                                          GXSimpleCollection<String> AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                          int AV52Tipoliquidacionwwds_2_tftliqcod_sels_size ,
                                          String AV51Tipoliquidacionwwds_1_tftliqcod ,
                                          int AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size ,
                                          String AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                          byte AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel ,
                                          byte AV56Tipoliquidacionwwds_6_tftliqsac_sel ,
                                          int AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size ,
                                          String AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                          boolean A1076TLiqAcuDiasTrab ,
                                          boolean A1211TliqSAC ,
                                          int AV38CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, TLiqCod, TLiqCodFor, TliqSAC, TLiqAcuDiasTrab, TliqDesc FROM TipoLiquidacion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Tipoliquidacionwwds_1_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Tipoliquidacionwwds_2_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Tipoliquidacionwwds_3_tftliqdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Tipoliquidacionwwds_4_tftliqdesc_sels, "TliqDesc IN (", ")")+")");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 1 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = TRUE)");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 2 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = FALSE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 1 )
      {
         addWhere(sWhereString, "(TliqSAC = TRUE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 2 )
      {
         addWhere(sWhereString, "(TliqSAC = FALSE)");
      }
      if ( ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Tipoliquidacionwwds_7_tftliqcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Tipoliquidacionwwds_8_tftliqcodfor_sels, "TLiqCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, TLiqCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P008B3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                          String A2091TLiqCodFor ,
                                          GXSimpleCollection<String> AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                          int AV52Tipoliquidacionwwds_2_tftliqcod_sels_size ,
                                          String AV51Tipoliquidacionwwds_1_tftliqcod ,
                                          int AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size ,
                                          String AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                          byte AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel ,
                                          byte AV56Tipoliquidacionwwds_6_tftliqsac_sel ,
                                          int AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size ,
                                          String AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                          boolean A1076TLiqAcuDiasTrab ,
                                          boolean A1211TliqSAC ,
                                          int AV38CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, TliqDesc, TLiqCodFor, TliqSAC, TLiqAcuDiasTrab, TLiqCod FROM TipoLiquidacion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Tipoliquidacionwwds_1_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Tipoliquidacionwwds_2_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Tipoliquidacionwwds_3_tftliqdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Tipoliquidacionwwds_4_tftliqdesc_sels, "TliqDesc IN (", ")")+")");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 1 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = TRUE)");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 2 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = FALSE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 1 )
      {
         addWhere(sWhereString, "(TliqSAC = TRUE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 2 )
      {
         addWhere(sWhereString, "(TliqSAC = FALSE)");
      }
      if ( ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Tipoliquidacionwwds_7_tftliqcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Tipoliquidacionwwds_8_tftliqcodfor_sels, "TLiqCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, TliqDesc" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P008B4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV52Tipoliquidacionwwds_2_tftliqcod_sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV54Tipoliquidacionwwds_4_tftliqdesc_sels ,
                                          String A2091TLiqCodFor ,
                                          GXSimpleCollection<String> AV58Tipoliquidacionwwds_8_tftliqcodfor_sels ,
                                          int AV52Tipoliquidacionwwds_2_tftliqcod_sels_size ,
                                          String AV51Tipoliquidacionwwds_1_tftliqcod ,
                                          int AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size ,
                                          String AV53Tipoliquidacionwwds_3_tftliqdesc ,
                                          byte AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel ,
                                          byte AV56Tipoliquidacionwwds_6_tftliqsac_sel ,
                                          int AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size ,
                                          String AV57Tipoliquidacionwwds_7_tftliqcodfor ,
                                          boolean A1076TLiqAcuDiasTrab ,
                                          boolean A1211TliqSAC ,
                                          int AV38CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, TLiqCodFor, TliqSAC, TLiqAcuDiasTrab, TliqDesc, TLiqCod FROM TipoLiquidacion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Tipoliquidacionwwds_1_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV52Tipoliquidacionwwds_2_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Tipoliquidacionwwds_2_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Tipoliquidacionwwds_3_tftliqdesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV54Tipoliquidacionwwds_4_tftliqdesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Tipoliquidacionwwds_4_tftliqdesc_sels, "TliqDesc IN (", ")")+")");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 1 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = TRUE)");
      }
      if ( AV55Tipoliquidacionwwds_5_tftliqacudiastrab_sel == 2 )
      {
         addWhere(sWhereString, "(TLiqAcuDiasTrab = FALSE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 1 )
      {
         addWhere(sWhereString, "(TliqSAC = TRUE)");
      }
      if ( AV56Tipoliquidacionwwds_6_tftliqsac_sel == 2 )
      {
         addWhere(sWhereString, "(TliqSAC = FALSE)");
      }
      if ( ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Tipoliquidacionwwds_7_tftliqcodfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCodFor) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV58Tipoliquidacionwwds_8_tftliqcodfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Tipoliquidacionwwds_8_tftliqcodfor_sels, "TLiqCodFor IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, TLiqCodFor" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P008B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 1 :
                  return conditional_P008B3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 2 :
                  return conditional_P008B4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Boolean) dynConstraints[14]).booleanValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008B3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P008B4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

