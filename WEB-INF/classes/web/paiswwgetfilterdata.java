package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paiswwgetfilterdata extends GXProcedure
{
   public paiswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paiswwgetfilterdata.class ), "" );
   }

   public paiswwgetfilterdata( int remoteHandle ,
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
      paiswwgetfilterdata.this.aP5 = new String[] {""};
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
      paiswwgetfilterdata.this.AV28DDOName = aP0;
      paiswwgetfilterdata.this.AV29SearchTxt = aP1;
      paiswwgetfilterdata.this.AV30SearchTxtTo = aP2;
      paiswwgetfilterdata.this.aP3 = aP3;
      paiswwgetfilterdata.this.aP4 = aP4;
      paiswwgetfilterdata.this.aP5 = aP5;
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
      paiswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      paiswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean6) ;
      paiswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PAINOM") == 0 )
         {
            /* Execute user subroutine: 'LOADPAINOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PAIRELIGDEFAULT") == 0 )
         {
            /* Execute user subroutine: 'LOADPAIRELIGDEFAULTOPTIONS' */
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
      if ( GXutil.strcmp(AV23Session.getValue("PaisWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "PaisWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("PaisWWGridState"), null, null);
      }
      AV63GXV1 = 1 ;
      while ( AV63GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAICOD") == 0 )
         {
            AV11TFPaiCod = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFPaiCod_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM") == 0 )
         {
            AV14TFPaiNom = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAINOM_SEL") == 0 )
         {
            AV13TFPaiNom_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFPaiNom_Sels.fromJSonString(AV13TFPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT") == 0 )
         {
            AV38TFPaiReligDefault = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIRELIGDEFAULT_SEL") == 0 )
         {
            AV37TFPaiReligDefault_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFPaiReligDefault_Sels.fromJSonString(AV37TFPaiReligDefault_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMESHSPEXT") == 0 )
         {
            AV40TFPaiMesHsPExt = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV41TFPaiMesHsPExt_To = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIDIAHSPEXT_SEL") == 0 )
         {
            AV42TFPaiDiaHsPExt_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV43TFPaiDiaHsPExt_Sels.fromJSonString(AV42TFPaiDiaHsPExt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFONDOCESE_SEL") == 0 )
         {
            AV44TFPaiFondoCese_Sel = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIMAXHORNOR") == 0 )
         {
            AV45TFPaiMaxHorNor = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV46TFPaiMaxHorNor_To = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACDES_SEL") == 0 )
         {
            AV47TFPaiPerVacDes_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFPaiPerVacDes_Sels.fromJSonString(AV47TFPaiPerVacDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIPERVACHAS_SEL") == 0 )
         {
            AV49TFPaiPerVacHas_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFPaiPerVacHas_Sels.fromJSonString(AV49TFPaiPerVacHas_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIFRACVACANT") == 0 )
         {
            AV58TFPaiFracVacAnt = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV59TFPaiFracVacAnt_To = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMIN") == 0 )
         {
            AV51TFPaiGuarEdadMin = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFPaiGuarEdadMin_To = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIGUAREDADMAX") == 0 )
         {
            AV53TFPaiGuarEdadMax = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV54TFPaiGuarEdadMax_To = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIEXCVIZZOTI_SEL") == 0 )
         {
            AV55TFPaiExcVizzoti_Sel = (byte)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIVIZZOTI") == 0 )
         {
            AV56TFPaiVizzoti = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV57TFPaiVizzoti_To = CommonUtil.decimalVal( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV60MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV63GXV1 = (int)(AV63GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAINOMOPTIONS' Routine */
      returnInSub = false ;
      AV14TFPaiNom = AV29SearchTxt ;
      AV15TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Paiswwds_1_tfpaicod = AV11TFPaiCod ;
      AV66Paiswwds_2_tfpaicod_to = AV12TFPaiCod_To ;
      AV67Paiswwds_3_tfpainom = AV14TFPaiNom ;
      AV68Paiswwds_4_tfpainom_sels = AV15TFPaiNom_Sels ;
      AV69Paiswwds_5_tfpaireligdefault = AV38TFPaiReligDefault ;
      AV70Paiswwds_6_tfpaireligdefault_sels = AV39TFPaiReligDefault_Sels ;
      AV71Paiswwds_7_tfpaimeshspext = AV40TFPaiMesHsPExt ;
      AV72Paiswwds_8_tfpaimeshspext_to = AV41TFPaiMesHsPExt_To ;
      AV73Paiswwds_9_tfpaidiahspext_sels = AV43TFPaiDiaHsPExt_Sels ;
      AV74Paiswwds_10_tfpaifondocese_sel = AV44TFPaiFondoCese_Sel ;
      AV75Paiswwds_11_tfpaimaxhornor = AV45TFPaiMaxHorNor ;
      AV76Paiswwds_12_tfpaimaxhornor_to = AV46TFPaiMaxHorNor_To ;
      AV77Paiswwds_13_tfpaipervacdes_sels = AV48TFPaiPerVacDes_Sels ;
      AV78Paiswwds_14_tfpaipervachas_sels = AV50TFPaiPerVacHas_Sels ;
      AV79Paiswwds_15_tfpaifracvacant = AV58TFPaiFracVacAnt ;
      AV80Paiswwds_16_tfpaifracvacant_to = AV59TFPaiFracVacAnt_To ;
      AV81Paiswwds_17_tfpaiguaredadmin = AV51TFPaiGuarEdadMin ;
      AV82Paiswwds_18_tfpaiguaredadmin_to = AV52TFPaiGuarEdadMin_To ;
      AV83Paiswwds_19_tfpaiguaredadmax = AV53TFPaiGuarEdadMax ;
      AV84Paiswwds_20_tfpaiguaredadmax_to = AV54TFPaiGuarEdadMax_To ;
      AV85Paiswwds_21_tfpaiexcvizzoti_sel = AV55TFPaiExcVizzoti_Sel ;
      AV86Paiswwds_22_tfpaivizzoti = AV56TFPaiVizzoti ;
      AV87Paiswwds_23_tfpaivizzoti_to = AV57TFPaiVizzoti_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV68Paiswwds_4_tfpainom_sels ,
                                           A1252PaiReligDefault ,
                                           AV70Paiswwds_6_tfpaireligdefault_sels ,
                                           A1272PaiDiaHsPExt ,
                                           AV73Paiswwds_9_tfpaidiahspext_sels ,
                                           Byte.valueOf(A1521PaiPerVacDes) ,
                                           AV77Paiswwds_13_tfpaipervacdes_sels ,
                                           Byte.valueOf(A1522PaiPerVacHas) ,
                                           AV78Paiswwds_14_tfpaipervachas_sels ,
                                           Short.valueOf(AV65Paiswwds_1_tfpaicod) ,
                                           Short.valueOf(AV66Paiswwds_2_tfpaicod_to) ,
                                           Integer.valueOf(AV68Paiswwds_4_tfpainom_sels.size()) ,
                                           AV67Paiswwds_3_tfpainom ,
                                           Integer.valueOf(AV70Paiswwds_6_tfpaireligdefault_sels.size()) ,
                                           AV69Paiswwds_5_tfpaireligdefault ,
                                           AV71Paiswwds_7_tfpaimeshspext ,
                                           AV72Paiswwds_8_tfpaimeshspext_to ,
                                           Integer.valueOf(AV73Paiswwds_9_tfpaidiahspext_sels.size()) ,
                                           Byte.valueOf(AV74Paiswwds_10_tfpaifondocese_sel) ,
                                           AV75Paiswwds_11_tfpaimaxhornor ,
                                           AV76Paiswwds_12_tfpaimaxhornor_to ,
                                           Integer.valueOf(AV77Paiswwds_13_tfpaipervacdes_sels.size()) ,
                                           Integer.valueOf(AV78Paiswwds_14_tfpaipervachas_sels.size()) ,
                                           AV79Paiswwds_15_tfpaifracvacant ,
                                           AV80Paiswwds_16_tfpaifracvacant_to ,
                                           Byte.valueOf(AV81Paiswwds_17_tfpaiguaredadmin) ,
                                           Byte.valueOf(AV82Paiswwds_18_tfpaiguaredadmin_to) ,
                                           Byte.valueOf(AV83Paiswwds_19_tfpaiguaredadmax) ,
                                           Byte.valueOf(AV84Paiswwds_20_tfpaiguaredadmax_to) ,
                                           Byte.valueOf(AV85Paiswwds_21_tfpaiexcvizzoti_sel) ,
                                           AV86Paiswwds_22_tfpaivizzoti ,
                                           AV87Paiswwds_23_tfpaivizzoti_to ,
                                           Short.valueOf(A46PaiCod) ,
                                           A1271PaiMesHsPExt ,
                                           Boolean.valueOf(A1402PaiFondoCese) ,
                                           A1405PaiMaxHorNor ,
                                           A1814PaiFracVacAnt ,
                                           Byte.valueOf(A1625PaiGuarEdadMin) ,
                                           Byte.valueOf(A1626PaiGuarEdadMax) ,
                                           Boolean.valueOf(A1736PaiExcVizzoti) ,
                                           A1737PaiVizzoti } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.DECIMAL
                                           }
      });
      lV67Paiswwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV67Paiswwds_3_tfpainom), "%", "") ;
      lV69Paiswwds_5_tfpaireligdefault = GXutil.padr( GXutil.rtrim( AV69Paiswwds_5_tfpaireligdefault), 20, "%") ;
      /* Using cursor P01C42 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV65Paiswwds_1_tfpaicod), Short.valueOf(AV66Paiswwds_2_tfpaicod_to), lV67Paiswwds_3_tfpainom, lV69Paiswwds_5_tfpaireligdefault, AV71Paiswwds_7_tfpaimeshspext, AV72Paiswwds_8_tfpaimeshspext_to, AV75Paiswwds_11_tfpaimaxhornor, AV76Paiswwds_12_tfpaimaxhornor_to, AV79Paiswwds_15_tfpaifracvacant, AV80Paiswwds_16_tfpaifracvacant_to, Byte.valueOf(AV81Paiswwds_17_tfpaiguaredadmin), Byte.valueOf(AV82Paiswwds_18_tfpaiguaredadmin_to), Byte.valueOf(AV83Paiswwds_19_tfpaiguaredadmax), Byte.valueOf(AV84Paiswwds_20_tfpaiguaredadmax_to), AV86Paiswwds_22_tfpaivizzoti, AV87Paiswwds_23_tfpaivizzoti_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1C42 = false ;
         A312PaiNom = P01C42_A312PaiNom[0] ;
         A1737PaiVizzoti = P01C42_A1737PaiVizzoti[0] ;
         A1736PaiExcVizzoti = P01C42_A1736PaiExcVizzoti[0] ;
         A1626PaiGuarEdadMax = P01C42_A1626PaiGuarEdadMax[0] ;
         A1625PaiGuarEdadMin = P01C42_A1625PaiGuarEdadMin[0] ;
         A1814PaiFracVacAnt = P01C42_A1814PaiFracVacAnt[0] ;
         A1522PaiPerVacHas = P01C42_A1522PaiPerVacHas[0] ;
         A1521PaiPerVacDes = P01C42_A1521PaiPerVacDes[0] ;
         A1405PaiMaxHorNor = P01C42_A1405PaiMaxHorNor[0] ;
         A1402PaiFondoCese = P01C42_A1402PaiFondoCese[0] ;
         A1272PaiDiaHsPExt = P01C42_A1272PaiDiaHsPExt[0] ;
         A1271PaiMesHsPExt = P01C42_A1271PaiMesHsPExt[0] ;
         A1252PaiReligDefault = P01C42_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = P01C42_n1252PaiReligDefault[0] ;
         A46PaiCod = P01C42_A46PaiCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01C42_A312PaiNom[0], A312PaiNom) == 0 ) )
         {
            brk1C42 = false ;
            A46PaiCod = P01C42_A46PaiCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1C42 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A312PaiNom)==0) )
         {
            AV17Option = A312PaiNom ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1C42 )
         {
            brk1C42 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPAIRELIGDEFAULTOPTIONS' Routine */
      returnInSub = false ;
      AV38TFPaiReligDefault = AV29SearchTxt ;
      AV39TFPaiReligDefault_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Paiswwds_1_tfpaicod = AV11TFPaiCod ;
      AV66Paiswwds_2_tfpaicod_to = AV12TFPaiCod_To ;
      AV67Paiswwds_3_tfpainom = AV14TFPaiNom ;
      AV68Paiswwds_4_tfpainom_sels = AV15TFPaiNom_Sels ;
      AV69Paiswwds_5_tfpaireligdefault = AV38TFPaiReligDefault ;
      AV70Paiswwds_6_tfpaireligdefault_sels = AV39TFPaiReligDefault_Sels ;
      AV71Paiswwds_7_tfpaimeshspext = AV40TFPaiMesHsPExt ;
      AV72Paiswwds_8_tfpaimeshspext_to = AV41TFPaiMesHsPExt_To ;
      AV73Paiswwds_9_tfpaidiahspext_sels = AV43TFPaiDiaHsPExt_Sels ;
      AV74Paiswwds_10_tfpaifondocese_sel = AV44TFPaiFondoCese_Sel ;
      AV75Paiswwds_11_tfpaimaxhornor = AV45TFPaiMaxHorNor ;
      AV76Paiswwds_12_tfpaimaxhornor_to = AV46TFPaiMaxHorNor_To ;
      AV77Paiswwds_13_tfpaipervacdes_sels = AV48TFPaiPerVacDes_Sels ;
      AV78Paiswwds_14_tfpaipervachas_sels = AV50TFPaiPerVacHas_Sels ;
      AV79Paiswwds_15_tfpaifracvacant = AV58TFPaiFracVacAnt ;
      AV80Paiswwds_16_tfpaifracvacant_to = AV59TFPaiFracVacAnt_To ;
      AV81Paiswwds_17_tfpaiguaredadmin = AV51TFPaiGuarEdadMin ;
      AV82Paiswwds_18_tfpaiguaredadmin_to = AV52TFPaiGuarEdadMin_To ;
      AV83Paiswwds_19_tfpaiguaredadmax = AV53TFPaiGuarEdadMax ;
      AV84Paiswwds_20_tfpaiguaredadmax_to = AV54TFPaiGuarEdadMax_To ;
      AV85Paiswwds_21_tfpaiexcvizzoti_sel = AV55TFPaiExcVizzoti_Sel ;
      AV86Paiswwds_22_tfpaivizzoti = AV56TFPaiVizzoti ;
      AV87Paiswwds_23_tfpaivizzoti_to = AV57TFPaiVizzoti_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A312PaiNom ,
                                           AV68Paiswwds_4_tfpainom_sels ,
                                           A1252PaiReligDefault ,
                                           AV70Paiswwds_6_tfpaireligdefault_sels ,
                                           A1272PaiDiaHsPExt ,
                                           AV73Paiswwds_9_tfpaidiahspext_sels ,
                                           Byte.valueOf(A1521PaiPerVacDes) ,
                                           AV77Paiswwds_13_tfpaipervacdes_sels ,
                                           Byte.valueOf(A1522PaiPerVacHas) ,
                                           AV78Paiswwds_14_tfpaipervachas_sels ,
                                           Short.valueOf(AV65Paiswwds_1_tfpaicod) ,
                                           Short.valueOf(AV66Paiswwds_2_tfpaicod_to) ,
                                           Integer.valueOf(AV68Paiswwds_4_tfpainom_sels.size()) ,
                                           AV67Paiswwds_3_tfpainom ,
                                           Integer.valueOf(AV70Paiswwds_6_tfpaireligdefault_sels.size()) ,
                                           AV69Paiswwds_5_tfpaireligdefault ,
                                           AV71Paiswwds_7_tfpaimeshspext ,
                                           AV72Paiswwds_8_tfpaimeshspext_to ,
                                           Integer.valueOf(AV73Paiswwds_9_tfpaidiahspext_sels.size()) ,
                                           Byte.valueOf(AV74Paiswwds_10_tfpaifondocese_sel) ,
                                           AV75Paiswwds_11_tfpaimaxhornor ,
                                           AV76Paiswwds_12_tfpaimaxhornor_to ,
                                           Integer.valueOf(AV77Paiswwds_13_tfpaipervacdes_sels.size()) ,
                                           Integer.valueOf(AV78Paiswwds_14_tfpaipervachas_sels.size()) ,
                                           AV79Paiswwds_15_tfpaifracvacant ,
                                           AV80Paiswwds_16_tfpaifracvacant_to ,
                                           Byte.valueOf(AV81Paiswwds_17_tfpaiguaredadmin) ,
                                           Byte.valueOf(AV82Paiswwds_18_tfpaiguaredadmin_to) ,
                                           Byte.valueOf(AV83Paiswwds_19_tfpaiguaredadmax) ,
                                           Byte.valueOf(AV84Paiswwds_20_tfpaiguaredadmax_to) ,
                                           Byte.valueOf(AV85Paiswwds_21_tfpaiexcvizzoti_sel) ,
                                           AV86Paiswwds_22_tfpaivizzoti ,
                                           AV87Paiswwds_23_tfpaivizzoti_to ,
                                           Short.valueOf(A46PaiCod) ,
                                           A1271PaiMesHsPExt ,
                                           Boolean.valueOf(A1402PaiFondoCese) ,
                                           A1405PaiMaxHorNor ,
                                           A1814PaiFracVacAnt ,
                                           Byte.valueOf(A1625PaiGuarEdadMin) ,
                                           Byte.valueOf(A1626PaiGuarEdadMax) ,
                                           Boolean.valueOf(A1736PaiExcVizzoti) ,
                                           A1737PaiVizzoti } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.DECIMAL
                                           }
      });
      lV67Paiswwds_3_tfpainom = GXutil.concat( GXutil.rtrim( AV67Paiswwds_3_tfpainom), "%", "") ;
      lV69Paiswwds_5_tfpaireligdefault = GXutil.padr( GXutil.rtrim( AV69Paiswwds_5_tfpaireligdefault), 20, "%") ;
      /* Using cursor P01C43 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV65Paiswwds_1_tfpaicod), Short.valueOf(AV66Paiswwds_2_tfpaicod_to), lV67Paiswwds_3_tfpainom, lV69Paiswwds_5_tfpaireligdefault, AV71Paiswwds_7_tfpaimeshspext, AV72Paiswwds_8_tfpaimeshspext_to, AV75Paiswwds_11_tfpaimaxhornor, AV76Paiswwds_12_tfpaimaxhornor_to, AV79Paiswwds_15_tfpaifracvacant, AV80Paiswwds_16_tfpaifracvacant_to, Byte.valueOf(AV81Paiswwds_17_tfpaiguaredadmin), Byte.valueOf(AV82Paiswwds_18_tfpaiguaredadmin_to), Byte.valueOf(AV83Paiswwds_19_tfpaiguaredadmax), Byte.valueOf(AV84Paiswwds_20_tfpaiguaredadmax_to), AV86Paiswwds_22_tfpaivizzoti, AV87Paiswwds_23_tfpaivizzoti_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1C44 = false ;
         A1252PaiReligDefault = P01C43_A1252PaiReligDefault[0] ;
         n1252PaiReligDefault = P01C43_n1252PaiReligDefault[0] ;
         A1737PaiVizzoti = P01C43_A1737PaiVizzoti[0] ;
         A1736PaiExcVizzoti = P01C43_A1736PaiExcVizzoti[0] ;
         A1626PaiGuarEdadMax = P01C43_A1626PaiGuarEdadMax[0] ;
         A1625PaiGuarEdadMin = P01C43_A1625PaiGuarEdadMin[0] ;
         A1814PaiFracVacAnt = P01C43_A1814PaiFracVacAnt[0] ;
         A1522PaiPerVacHas = P01C43_A1522PaiPerVacHas[0] ;
         A1521PaiPerVacDes = P01C43_A1521PaiPerVacDes[0] ;
         A1405PaiMaxHorNor = P01C43_A1405PaiMaxHorNor[0] ;
         A1402PaiFondoCese = P01C43_A1402PaiFondoCese[0] ;
         A1272PaiDiaHsPExt = P01C43_A1272PaiDiaHsPExt[0] ;
         A1271PaiMesHsPExt = P01C43_A1271PaiMesHsPExt[0] ;
         A312PaiNom = P01C43_A312PaiNom[0] ;
         A46PaiCod = P01C43_A46PaiCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01C43_A1252PaiReligDefault[0], A1252PaiReligDefault) == 0 ) )
         {
            brk1C44 = false ;
            A46PaiCod = P01C43_A46PaiCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1C44 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1252PaiReligDefault)==0) )
         {
            AV17Option = A1252PaiReligDefault ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1C44 )
         {
            brk1C44 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paiswwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = paiswwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = paiswwgetfilterdata.this.AV33OptionIndexesJson;
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
      AV14TFPaiNom = "" ;
      AV13TFPaiNom_SelsJson = "" ;
      AV15TFPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFPaiReligDefault = "" ;
      AV37TFPaiReligDefault_SelsJson = "" ;
      AV39TFPaiReligDefault_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFPaiMesHsPExt = DecimalUtil.ZERO ;
      AV41TFPaiMesHsPExt_To = DecimalUtil.ZERO ;
      AV42TFPaiDiaHsPExt_SelsJson = "" ;
      AV43TFPaiDiaHsPExt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45TFPaiMaxHorNor = DecimalUtil.ZERO ;
      AV46TFPaiMaxHorNor_To = DecimalUtil.ZERO ;
      AV47TFPaiPerVacDes_SelsJson = "" ;
      AV48TFPaiPerVacDes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV49TFPaiPerVacHas_SelsJson = "" ;
      AV50TFPaiPerVacHas_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV58TFPaiFracVacAnt = DecimalUtil.ZERO ;
      AV59TFPaiFracVacAnt_To = DecimalUtil.ZERO ;
      AV56TFPaiVizzoti = DecimalUtil.ZERO ;
      AV57TFPaiVizzoti_To = DecimalUtil.ZERO ;
      AV60MenuOpcCod = "" ;
      A312PaiNom = "" ;
      AV67Paiswwds_3_tfpainom = "" ;
      AV68Paiswwds_4_tfpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Paiswwds_5_tfpaireligdefault = "" ;
      AV70Paiswwds_6_tfpaireligdefault_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Paiswwds_7_tfpaimeshspext = DecimalUtil.ZERO ;
      AV72Paiswwds_8_tfpaimeshspext_to = DecimalUtil.ZERO ;
      AV73Paiswwds_9_tfpaidiahspext_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Paiswwds_11_tfpaimaxhornor = DecimalUtil.ZERO ;
      AV76Paiswwds_12_tfpaimaxhornor_to = DecimalUtil.ZERO ;
      AV77Paiswwds_13_tfpaipervacdes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV78Paiswwds_14_tfpaipervachas_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV79Paiswwds_15_tfpaifracvacant = DecimalUtil.ZERO ;
      AV80Paiswwds_16_tfpaifracvacant_to = DecimalUtil.ZERO ;
      AV86Paiswwds_22_tfpaivizzoti = DecimalUtil.ZERO ;
      AV87Paiswwds_23_tfpaivizzoti_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV67Paiswwds_3_tfpainom = "" ;
      lV69Paiswwds_5_tfpaireligdefault = "" ;
      A1252PaiReligDefault = "" ;
      A1272PaiDiaHsPExt = "" ;
      A1271PaiMesHsPExt = DecimalUtil.ZERO ;
      A1405PaiMaxHorNor = DecimalUtil.ZERO ;
      A1814PaiFracVacAnt = DecimalUtil.ZERO ;
      A1737PaiVizzoti = DecimalUtil.ZERO ;
      P01C42_A312PaiNom = new String[] {""} ;
      P01C42_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C42_A1736PaiExcVizzoti = new boolean[] {false} ;
      P01C42_A1626PaiGuarEdadMax = new byte[1] ;
      P01C42_A1625PaiGuarEdadMin = new byte[1] ;
      P01C42_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C42_A1522PaiPerVacHas = new byte[1] ;
      P01C42_A1521PaiPerVacDes = new byte[1] ;
      P01C42_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C42_A1402PaiFondoCese = new boolean[] {false} ;
      P01C42_A1272PaiDiaHsPExt = new String[] {""} ;
      P01C42_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C42_A1252PaiReligDefault = new String[] {""} ;
      P01C42_n1252PaiReligDefault = new boolean[] {false} ;
      P01C42_A46PaiCod = new short[1] ;
      AV17Option = "" ;
      P01C43_A1252PaiReligDefault = new String[] {""} ;
      P01C43_n1252PaiReligDefault = new boolean[] {false} ;
      P01C43_A1737PaiVizzoti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C43_A1736PaiExcVizzoti = new boolean[] {false} ;
      P01C43_A1626PaiGuarEdadMax = new byte[1] ;
      P01C43_A1625PaiGuarEdadMin = new byte[1] ;
      P01C43_A1814PaiFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C43_A1522PaiPerVacHas = new byte[1] ;
      P01C43_A1521PaiPerVacDes = new byte[1] ;
      P01C43_A1405PaiMaxHorNor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C43_A1402PaiFondoCese = new boolean[] {false} ;
      P01C43_A1272PaiDiaHsPExt = new String[] {""} ;
      P01C43_A1271PaiMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01C43_A312PaiNom = new String[] {""} ;
      P01C43_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paiswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01C42_A312PaiNom, P01C42_A1737PaiVizzoti, P01C42_A1736PaiExcVizzoti, P01C42_A1626PaiGuarEdadMax, P01C42_A1625PaiGuarEdadMin, P01C42_A1814PaiFracVacAnt, P01C42_A1522PaiPerVacHas, P01C42_A1521PaiPerVacDes, P01C42_A1405PaiMaxHorNor, P01C42_A1402PaiFondoCese,
            P01C42_A1272PaiDiaHsPExt, P01C42_A1271PaiMesHsPExt, P01C42_A1252PaiReligDefault, P01C42_n1252PaiReligDefault, P01C42_A46PaiCod
            }
            , new Object[] {
            P01C43_A1252PaiReligDefault, P01C43_n1252PaiReligDefault, P01C43_A1737PaiVizzoti, P01C43_A1736PaiExcVizzoti, P01C43_A1626PaiGuarEdadMax, P01C43_A1625PaiGuarEdadMin, P01C43_A1814PaiFracVacAnt, P01C43_A1522PaiPerVacHas, P01C43_A1521PaiPerVacDes, P01C43_A1405PaiMaxHorNor,
            P01C43_A1402PaiFondoCese, P01C43_A1272PaiDiaHsPExt, P01C43_A1271PaiMesHsPExt, P01C43_A312PaiNom, P01C43_A46PaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV44TFPaiFondoCese_Sel ;
   private byte AV51TFPaiGuarEdadMin ;
   private byte AV52TFPaiGuarEdadMin_To ;
   private byte AV53TFPaiGuarEdadMax ;
   private byte AV54TFPaiGuarEdadMax_To ;
   private byte AV55TFPaiExcVizzoti_Sel ;
   private byte AV74Paiswwds_10_tfpaifondocese_sel ;
   private byte AV81Paiswwds_17_tfpaiguaredadmin ;
   private byte AV82Paiswwds_18_tfpaiguaredadmin_to ;
   private byte AV83Paiswwds_19_tfpaiguaredadmax ;
   private byte AV84Paiswwds_20_tfpaiguaredadmax_to ;
   private byte AV85Paiswwds_21_tfpaiexcvizzoti_sel ;
   private byte A1521PaiPerVacDes ;
   private byte A1522PaiPerVacHas ;
   private byte A1625PaiGuarEdadMin ;
   private byte A1626PaiGuarEdadMax ;
   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFPaiCod ;
   private short AV12TFPaiCod_To ;
   private short AV65Paiswwds_1_tfpaicod ;
   private short AV66Paiswwds_2_tfpaicod_to ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV63GXV1 ;
   private int AV68Paiswwds_4_tfpainom_sels_size ;
   private int AV70Paiswwds_6_tfpaireligdefault_sels_size ;
   private int AV73Paiswwds_9_tfpaidiahspext_sels_size ;
   private int AV77Paiswwds_13_tfpaipervacdes_sels_size ;
   private int AV78Paiswwds_14_tfpaipervachas_sels_size ;
   private long AV22count ;
   private java.math.BigDecimal AV40TFPaiMesHsPExt ;
   private java.math.BigDecimal AV41TFPaiMesHsPExt_To ;
   private java.math.BigDecimal AV45TFPaiMaxHorNor ;
   private java.math.BigDecimal AV46TFPaiMaxHorNor_To ;
   private java.math.BigDecimal AV58TFPaiFracVacAnt ;
   private java.math.BigDecimal AV59TFPaiFracVacAnt_To ;
   private java.math.BigDecimal AV56TFPaiVizzoti ;
   private java.math.BigDecimal AV57TFPaiVizzoti_To ;
   private java.math.BigDecimal AV71Paiswwds_7_tfpaimeshspext ;
   private java.math.BigDecimal AV72Paiswwds_8_tfpaimeshspext_to ;
   private java.math.BigDecimal AV75Paiswwds_11_tfpaimaxhornor ;
   private java.math.BigDecimal AV76Paiswwds_12_tfpaimaxhornor_to ;
   private java.math.BigDecimal AV79Paiswwds_15_tfpaifracvacant ;
   private java.math.BigDecimal AV80Paiswwds_16_tfpaifracvacant_to ;
   private java.math.BigDecimal AV86Paiswwds_22_tfpaivizzoti ;
   private java.math.BigDecimal AV87Paiswwds_23_tfpaivizzoti_to ;
   private java.math.BigDecimal A1271PaiMesHsPExt ;
   private java.math.BigDecimal A1405PaiMaxHorNor ;
   private java.math.BigDecimal A1814PaiFracVacAnt ;
   private java.math.BigDecimal A1737PaiVizzoti ;
   private String AV38TFPaiReligDefault ;
   private String AV69Paiswwds_5_tfpaireligdefault ;
   private String scmdbuf ;
   private String lV69Paiswwds_5_tfpaireligdefault ;
   private String A1252PaiReligDefault ;
   private String A1272PaiDiaHsPExt ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1402PaiFondoCese ;
   private boolean A1736PaiExcVizzoti ;
   private boolean brk1C42 ;
   private boolean n1252PaiReligDefault ;
   private boolean brk1C44 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFPaiNom_SelsJson ;
   private String AV37TFPaiReligDefault_SelsJson ;
   private String AV42TFPaiDiaHsPExt_SelsJson ;
   private String AV47TFPaiPerVacDes_SelsJson ;
   private String AV49TFPaiPerVacHas_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFPaiNom ;
   private String AV60MenuOpcCod ;
   private String A312PaiNom ;
   private String AV67Paiswwds_3_tfpainom ;
   private String lV67Paiswwds_3_tfpainom ;
   private String AV17Option ;
   private GXSimpleCollection<Byte> AV48TFPaiPerVacDes_Sels ;
   private GXSimpleCollection<Byte> AV50TFPaiPerVacHas_Sels ;
   private GXSimpleCollection<Byte> AV77Paiswwds_13_tfpaipervacdes_sels ;
   private GXSimpleCollection<Byte> AV78Paiswwds_14_tfpaipervachas_sels ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01C42_A312PaiNom ;
   private java.math.BigDecimal[] P01C42_A1737PaiVizzoti ;
   private boolean[] P01C42_A1736PaiExcVizzoti ;
   private byte[] P01C42_A1626PaiGuarEdadMax ;
   private byte[] P01C42_A1625PaiGuarEdadMin ;
   private java.math.BigDecimal[] P01C42_A1814PaiFracVacAnt ;
   private byte[] P01C42_A1522PaiPerVacHas ;
   private byte[] P01C42_A1521PaiPerVacDes ;
   private java.math.BigDecimal[] P01C42_A1405PaiMaxHorNor ;
   private boolean[] P01C42_A1402PaiFondoCese ;
   private String[] P01C42_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] P01C42_A1271PaiMesHsPExt ;
   private String[] P01C42_A1252PaiReligDefault ;
   private boolean[] P01C42_n1252PaiReligDefault ;
   private short[] P01C42_A46PaiCod ;
   private String[] P01C43_A1252PaiReligDefault ;
   private boolean[] P01C43_n1252PaiReligDefault ;
   private java.math.BigDecimal[] P01C43_A1737PaiVizzoti ;
   private boolean[] P01C43_A1736PaiExcVizzoti ;
   private byte[] P01C43_A1626PaiGuarEdadMax ;
   private byte[] P01C43_A1625PaiGuarEdadMin ;
   private java.math.BigDecimal[] P01C43_A1814PaiFracVacAnt ;
   private byte[] P01C43_A1522PaiPerVacHas ;
   private byte[] P01C43_A1521PaiPerVacDes ;
   private java.math.BigDecimal[] P01C43_A1405PaiMaxHorNor ;
   private boolean[] P01C43_A1402PaiFondoCese ;
   private String[] P01C43_A1272PaiDiaHsPExt ;
   private java.math.BigDecimal[] P01C43_A1271PaiMesHsPExt ;
   private String[] P01C43_A312PaiNom ;
   private short[] P01C43_A46PaiCod ;
   private GXSimpleCollection<String> AV39TFPaiReligDefault_Sels ;
   private GXSimpleCollection<String> AV43TFPaiDiaHsPExt_Sels ;
   private GXSimpleCollection<String> AV70Paiswwds_6_tfpaireligdefault_sels ;
   private GXSimpleCollection<String> AV73Paiswwds_9_tfpaidiahspext_sels ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFPaiNom_Sels ;
   private GXSimpleCollection<String> AV68Paiswwds_4_tfpainom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class paiswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01C42( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV68Paiswwds_4_tfpainom_sels ,
                                          String A1252PaiReligDefault ,
                                          GXSimpleCollection<String> AV70Paiswwds_6_tfpaireligdefault_sels ,
                                          String A1272PaiDiaHsPExt ,
                                          GXSimpleCollection<String> AV73Paiswwds_9_tfpaidiahspext_sels ,
                                          byte A1521PaiPerVacDes ,
                                          GXSimpleCollection<Byte> AV77Paiswwds_13_tfpaipervacdes_sels ,
                                          byte A1522PaiPerVacHas ,
                                          GXSimpleCollection<Byte> AV78Paiswwds_14_tfpaipervachas_sels ,
                                          short AV65Paiswwds_1_tfpaicod ,
                                          short AV66Paiswwds_2_tfpaicod_to ,
                                          int AV68Paiswwds_4_tfpainom_sels_size ,
                                          String AV67Paiswwds_3_tfpainom ,
                                          int AV70Paiswwds_6_tfpaireligdefault_sels_size ,
                                          String AV69Paiswwds_5_tfpaireligdefault ,
                                          java.math.BigDecimal AV71Paiswwds_7_tfpaimeshspext ,
                                          java.math.BigDecimal AV72Paiswwds_8_tfpaimeshspext_to ,
                                          int AV73Paiswwds_9_tfpaidiahspext_sels_size ,
                                          byte AV74Paiswwds_10_tfpaifondocese_sel ,
                                          java.math.BigDecimal AV75Paiswwds_11_tfpaimaxhornor ,
                                          java.math.BigDecimal AV76Paiswwds_12_tfpaimaxhornor_to ,
                                          int AV77Paiswwds_13_tfpaipervacdes_sels_size ,
                                          int AV78Paiswwds_14_tfpaipervachas_sels_size ,
                                          java.math.BigDecimal AV79Paiswwds_15_tfpaifracvacant ,
                                          java.math.BigDecimal AV80Paiswwds_16_tfpaifracvacant_to ,
                                          byte AV81Paiswwds_17_tfpaiguaredadmin ,
                                          byte AV82Paiswwds_18_tfpaiguaredadmin_to ,
                                          byte AV83Paiswwds_19_tfpaiguaredadmax ,
                                          byte AV84Paiswwds_20_tfpaiguaredadmax_to ,
                                          byte AV85Paiswwds_21_tfpaiexcvizzoti_sel ,
                                          java.math.BigDecimal AV86Paiswwds_22_tfpaivizzoti ,
                                          java.math.BigDecimal AV87Paiswwds_23_tfpaivizzoti_to ,
                                          short A46PaiCod ,
                                          java.math.BigDecimal A1271PaiMesHsPExt ,
                                          boolean A1402PaiFondoCese ,
                                          java.math.BigDecimal A1405PaiMaxHorNor ,
                                          java.math.BigDecimal A1814PaiFracVacAnt ,
                                          byte A1625PaiGuarEdadMin ,
                                          byte A1626PaiGuarEdadMax ,
                                          boolean A1736PaiExcVizzoti ,
                                          java.math.BigDecimal A1737PaiVizzoti )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[16];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PaiNom, PaiVizzoti, PaiExcVizzoti, PaiGuarEdadMax, PaiGuarEdadMin, PaiFracVacAnt, PaiPerVacHas, PaiPerVacDes, PaiMaxHorNor, PaiFondoCese, PaiDiaHsPExt, PaiMesHsPExt," ;
      scmdbuf += " PaiReligDefault, PaiCod FROM Pais" ;
      if ( ! (0==AV65Paiswwds_1_tfpaicod) )
      {
         addWhere(sWhereString, "(PaiCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV66Paiswwds_2_tfpaicod_to) )
      {
         addWhere(sWhereString, "(PaiCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV68Paiswwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Paiswwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV68Paiswwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Paiswwds_4_tfpainom_sels, "PaiNom IN (", ")")+")");
      }
      if ( ( AV70Paiswwds_6_tfpaireligdefault_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Paiswwds_5_tfpaireligdefault)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiReligDefault) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV70Paiswwds_6_tfpaireligdefault_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Paiswwds_6_tfpaireligdefault_sels, "PaiReligDefault IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Paiswwds_7_tfpaimeshspext)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Paiswwds_8_tfpaimeshspext_to)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV73Paiswwds_9_tfpaidiahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Paiswwds_9_tfpaidiahspext_sels, "PaiDiaHsPExt IN (", ")")+")");
      }
      if ( AV74Paiswwds_10_tfpaifondocese_sel == 1 )
      {
         addWhere(sWhereString, "(PaiFondoCese = TRUE)");
      }
      if ( AV74Paiswwds_10_tfpaifondocese_sel == 2 )
      {
         addWhere(sWhereString, "(PaiFondoCese = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Paiswwds_11_tfpaimaxhornor)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Paiswwds_12_tfpaimaxhornor_to)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV77Paiswwds_13_tfpaipervacdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Paiswwds_13_tfpaipervacdes_sels, "PaiPerVacDes IN (", ")")+")");
      }
      if ( AV78Paiswwds_14_tfpaipervachas_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Paiswwds_14_tfpaipervachas_sels, "PaiPerVacHas IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Paiswwds_15_tfpaifracvacant)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Paiswwds_16_tfpaifracvacant_to)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV81Paiswwds_17_tfpaiguaredadmin) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV82Paiswwds_18_tfpaiguaredadmin_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV83Paiswwds_19_tfpaiguaredadmax) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV84Paiswwds_20_tfpaiguaredadmax_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( AV85Paiswwds_21_tfpaiexcvizzoti_sel == 1 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = TRUE)");
      }
      if ( AV85Paiswwds_21_tfpaiexcvizzoti_sel == 2 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Paiswwds_22_tfpaivizzoti)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti >= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Paiswwds_23_tfpaivizzoti_to)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti <= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01C43( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A312PaiNom ,
                                          GXSimpleCollection<String> AV68Paiswwds_4_tfpainom_sels ,
                                          String A1252PaiReligDefault ,
                                          GXSimpleCollection<String> AV70Paiswwds_6_tfpaireligdefault_sels ,
                                          String A1272PaiDiaHsPExt ,
                                          GXSimpleCollection<String> AV73Paiswwds_9_tfpaidiahspext_sels ,
                                          byte A1521PaiPerVacDes ,
                                          GXSimpleCollection<Byte> AV77Paiswwds_13_tfpaipervacdes_sels ,
                                          byte A1522PaiPerVacHas ,
                                          GXSimpleCollection<Byte> AV78Paiswwds_14_tfpaipervachas_sels ,
                                          short AV65Paiswwds_1_tfpaicod ,
                                          short AV66Paiswwds_2_tfpaicod_to ,
                                          int AV68Paiswwds_4_tfpainom_sels_size ,
                                          String AV67Paiswwds_3_tfpainom ,
                                          int AV70Paiswwds_6_tfpaireligdefault_sels_size ,
                                          String AV69Paiswwds_5_tfpaireligdefault ,
                                          java.math.BigDecimal AV71Paiswwds_7_tfpaimeshspext ,
                                          java.math.BigDecimal AV72Paiswwds_8_tfpaimeshspext_to ,
                                          int AV73Paiswwds_9_tfpaidiahspext_sels_size ,
                                          byte AV74Paiswwds_10_tfpaifondocese_sel ,
                                          java.math.BigDecimal AV75Paiswwds_11_tfpaimaxhornor ,
                                          java.math.BigDecimal AV76Paiswwds_12_tfpaimaxhornor_to ,
                                          int AV77Paiswwds_13_tfpaipervacdes_sels_size ,
                                          int AV78Paiswwds_14_tfpaipervachas_sels_size ,
                                          java.math.BigDecimal AV79Paiswwds_15_tfpaifracvacant ,
                                          java.math.BigDecimal AV80Paiswwds_16_tfpaifracvacant_to ,
                                          byte AV81Paiswwds_17_tfpaiguaredadmin ,
                                          byte AV82Paiswwds_18_tfpaiguaredadmin_to ,
                                          byte AV83Paiswwds_19_tfpaiguaredadmax ,
                                          byte AV84Paiswwds_20_tfpaiguaredadmax_to ,
                                          byte AV85Paiswwds_21_tfpaiexcvizzoti_sel ,
                                          java.math.BigDecimal AV86Paiswwds_22_tfpaivizzoti ,
                                          java.math.BigDecimal AV87Paiswwds_23_tfpaivizzoti_to ,
                                          short A46PaiCod ,
                                          java.math.BigDecimal A1271PaiMesHsPExt ,
                                          boolean A1402PaiFondoCese ,
                                          java.math.BigDecimal A1405PaiMaxHorNor ,
                                          java.math.BigDecimal A1814PaiFracVacAnt ,
                                          byte A1625PaiGuarEdadMin ,
                                          byte A1626PaiGuarEdadMax ,
                                          boolean A1736PaiExcVizzoti ,
                                          java.math.BigDecimal A1737PaiVizzoti )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[16];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT PaiReligDefault, PaiVizzoti, PaiExcVizzoti, PaiGuarEdadMax, PaiGuarEdadMin, PaiFracVacAnt, PaiPerVacHas, PaiPerVacDes, PaiMaxHorNor, PaiFondoCese, PaiDiaHsPExt," ;
      scmdbuf += " PaiMesHsPExt, PaiNom, PaiCod FROM Pais" ;
      if ( ! (0==AV65Paiswwds_1_tfpaicod) )
      {
         addWhere(sWhereString, "(PaiCod >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV66Paiswwds_2_tfpaicod_to) )
      {
         addWhere(sWhereString, "(PaiCod <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV68Paiswwds_4_tfpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Paiswwds_3_tfpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV68Paiswwds_4_tfpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Paiswwds_4_tfpainom_sels, "PaiNom IN (", ")")+")");
      }
      if ( ( AV70Paiswwds_6_tfpaireligdefault_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Paiswwds_5_tfpaireligdefault)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiReligDefault) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV70Paiswwds_6_tfpaireligdefault_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Paiswwds_6_tfpaireligdefault_sels, "PaiReligDefault IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Paiswwds_7_tfpaimeshspext)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Paiswwds_8_tfpaimeshspext_to)==0) )
      {
         addWhere(sWhereString, "(PaiMesHsPExt <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV73Paiswwds_9_tfpaidiahspext_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV73Paiswwds_9_tfpaidiahspext_sels, "PaiDiaHsPExt IN (", ")")+")");
      }
      if ( AV74Paiswwds_10_tfpaifondocese_sel == 1 )
      {
         addWhere(sWhereString, "(PaiFondoCese = TRUE)");
      }
      if ( AV74Paiswwds_10_tfpaifondocese_sel == 2 )
      {
         addWhere(sWhereString, "(PaiFondoCese = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Paiswwds_11_tfpaimaxhornor)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Paiswwds_12_tfpaimaxhornor_to)==0) )
      {
         addWhere(sWhereString, "(PaiMaxHorNor <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV77Paiswwds_13_tfpaipervacdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Paiswwds_13_tfpaipervacdes_sels, "PaiPerVacDes IN (", ")")+")");
      }
      if ( AV78Paiswwds_14_tfpaipervachas_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Paiswwds_14_tfpaipervachas_sels, "PaiPerVacHas IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Paiswwds_15_tfpaifracvacant)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Paiswwds_16_tfpaifracvacant_to)==0) )
      {
         addWhere(sWhereString, "(PaiFracVacAnt <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV81Paiswwds_17_tfpaiguaredadmin) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin >= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ! (0==AV82Paiswwds_18_tfpaiguaredadmin_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMin <= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (0==AV83Paiswwds_19_tfpaiguaredadmax) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV84Paiswwds_20_tfpaiguaredadmax_to) )
      {
         addWhere(sWhereString, "(PaiGuarEdadMax <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( AV85Paiswwds_21_tfpaiexcvizzoti_sel == 1 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = TRUE)");
      }
      if ( AV85Paiswwds_21_tfpaiexcvizzoti_sel == 2 )
      {
         addWhere(sWhereString, "(PaiExcVizzoti = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV86Paiswwds_22_tfpaivizzoti)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti >= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Paiswwds_23_tfpaivizzoti_to)==0) )
      {
         addWhere(sWhereString, "(PaiVizzoti <= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiReligDefault" ;
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
                  return conditional_P01C42(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).byteValue() , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).byteValue() , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , ((Boolean) dynConstraints[35]).booleanValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Boolean) dynConstraints[40]).booleanValue() , (java.math.BigDecimal)dynConstraints[41] );
            case 1 :
                  return conditional_P01C43(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).byteValue() , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).byteValue() , ((Number) dynConstraints[30]).byteValue() , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , ((Boolean) dynConstraints[35]).booleanValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Boolean) dynConstraints[40]).booleanValue() , (java.math.BigDecimal)dynConstraints[41] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01C42", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01C43", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,1);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(14);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,4);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((byte[]) buf[8])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(12,1);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((short[]) buf[14])[0] = rslt.getShort(14);
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
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 1);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 1);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 4);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 4);
               }
               return;
      }
   }

}

