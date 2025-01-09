package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obligacionwwgetfilterdata extends GXProcedure
{
   public obligacionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacionwwgetfilterdata.class ), "" );
   }

   public obligacionwwgetfilterdata( int remoteHandle ,
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
      obligacionwwgetfilterdata.this.aP5 = new String[] {""};
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
      obligacionwwgetfilterdata.this.AV44DDOName = aP0;
      obligacionwwgetfilterdata.this.AV45SearchTxt = aP1;
      obligacionwwgetfilterdata.this.AV46SearchTxtTo = aP2;
      obligacionwwgetfilterdata.this.aP3 = aP3;
      obligacionwwgetfilterdata.this.aP4 = aP4;
      obligacionwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV51EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      obligacionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV51EmpCod = GXt_int1 ;
      GXt_int3 = AV52CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      obligacionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV52CliCod = GXt_int3 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion", GXv_boolean6) ;
      obligacionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_LEGIDNOMAPE") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGIDNOMAPEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_TIPOOBLDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOOBLDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_OBLCONCEPTO") == 0 )
         {
            /* Execute user subroutine: 'LOADOBLCONCEPTOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_OBLOBS") == 0 )
         {
            /* Execute user subroutine: 'LOADOBLOBSOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV44DDOName), "DDO_OBLCONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADOBLCONCODIGOOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV47OptionsJson = AV34Options.toJSonString(false) ;
      AV48OptionsDescJson = AV36OptionsDesc.toJSonString(false) ;
      AV49OptionIndexesJson = AV37OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV39Session.getValue("ObligacionWWGridState"), "") == 0 )
      {
         AV41GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ObligacionWWGridState"), null, null);
      }
      else
      {
         AV41GridState.fromxml(AV39Session.getValue("ObligacionWWGridState"), null, null);
      }
      AV69GXV1 = 1 ;
      while ( AV69GXV1 <= AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV42GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV41GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV69GXV1));
         if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLSECUENCIAL") == 0 )
         {
            AV11TFOblSecuencial = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFOblSecuencial_To = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV14TFLegIdNomApe = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV13TFLegIdNomApe_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFLegIdNomApe_Sels.fromJSonString(AV13TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLSEC") == 0 )
         {
            AV53TFTipoOblSec = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV54TFTipoOblSec_To = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP") == 0 )
         {
            AV62TFTipoOblDescrip = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP_SEL") == 0 )
         {
            AV61TFTipoOblDescrip_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFTipoOblDescrip_Sels.fromJSonString(AV61TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO") == 0 )
         {
            AV65TFOblConcepto = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCEPTO_SEL") == 0 )
         {
            AV64TFOblConcepto_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFOblConcepto_Sels.fromJSonString(AV64TFOblConcepto_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLESTADO_SEL") == 0 )
         {
            AV16TFOblEstado_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFOblEstado_Sels.fromJSonString(AV16TFOblEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS") == 0 )
         {
            AV19TFOblObs = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLOBS_SEL") == 0 )
         {
            AV18TFOblObs_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFOblObs_Sels.fromJSonString(AV18TFOblObs_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLORIPER_SEL") == 0 )
         {
            AV55TFOblOriPer_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFOblOriPer_Sels.fromJSonString(AV55TFOblOriPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO") == 0 )
         {
            AV58TFOblConCodigo = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCONCODIGO_SEL") == 0 )
         {
            AV57TFOblConCodigo_SelsJson = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV59TFOblConCodigo_Sels.fromJSonString(AV57TFOblConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLTOTAL") == 0 )
         {
            AV21TFOblTotal = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV22TFOblTotal_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLCANCUO") == 0 )
         {
            AV23TFOblCanCuo = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFOblCanCuo_To = (short)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLIMPFIJ") == 0 )
         {
            AV25TFOblImpFij = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV26TFOblImpFij_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLPORC") == 0 )
         {
            AV27TFOblPorc = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV28TFOblPorc_To = CommonUtil.decimalVal( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLNOREMU_SEL") == 0 )
         {
            AV30TFOblNoRemu_Sel = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFOBLDESCU_SEL") == 0 )
         {
            AV31TFOblDescu_Sel = (byte)(GXutil.lval( AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV60MenuOpcCod = AV42GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV69GXV1 = (int)(AV69GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV14TFLegIdNomApe = AV45SearchTxt ;
      AV15TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71Obligacionwwds_1_tfoblsecuencial = AV11TFOblSecuencial ;
      AV72Obligacionwwds_2_tfoblsecuencial_to = AV12TFOblSecuencial_To ;
      AV73Obligacionwwds_3_tflegidnomape = AV14TFLegIdNomApe ;
      AV74Obligacionwwds_4_tflegidnomape_sels = AV15TFLegIdNomApe_Sels ;
      AV75Obligacionwwds_5_tftipooblsec = AV53TFTipoOblSec ;
      AV76Obligacionwwds_6_tftipooblsec_to = AV54TFTipoOblSec_To ;
      AV77Obligacionwwds_7_tftipoobldescrip = AV62TFTipoOblDescrip ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = AV63TFTipoOblDescrip_Sels ;
      AV79Obligacionwwds_9_tfoblconcepto = AV65TFOblConcepto ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = AV66TFOblConcepto_Sels ;
      AV81Obligacionwwds_11_tfoblestado_sels = AV17TFOblEstado_Sels ;
      AV82Obligacionwwds_12_tfoblobs = AV19TFOblObs ;
      AV83Obligacionwwds_13_tfoblobs_sels = AV20TFOblObs_Sels ;
      AV84Obligacionwwds_14_tfobloriper_sels = AV56TFOblOriPer_Sels ;
      AV85Obligacionwwds_15_tfoblconcodigo = AV58TFOblConCodigo ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = AV59TFOblConCodigo_Sels ;
      AV87Obligacionwwds_17_tfobltotal = AV21TFOblTotal ;
      AV88Obligacionwwds_18_tfobltotal_to = AV22TFOblTotal_To ;
      AV89Obligacionwwds_19_tfoblcancuo = AV23TFOblCanCuo ;
      AV90Obligacionwwds_20_tfoblcancuo_to = AV24TFOblCanCuo_To ;
      AV91Obligacionwwds_21_tfoblimpfij = AV25TFOblImpFij ;
      AV92Obligacionwwds_22_tfoblimpfij_to = AV26TFOblImpFij_To ;
      AV93Obligacionwwds_23_tfoblporc = AV27TFOblPorc ;
      AV94Obligacionwwds_24_tfoblporc_to = AV28TFOblPorc_To ;
      AV95Obligacionwwds_25_tfoblnoremu_sel = AV30TFOblNoRemu_Sel ;
      AV96Obligacionwwds_26_tfobldescu_sel = AV31TFOblDescu_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV74Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV81Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV83Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV84Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV74Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV73Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV75Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV78Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV77Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV80Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV79Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV81Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV83Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV82Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV84Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV86Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV85Obligacionwwds_15_tfoblconcodigo ,
                                           AV87Obligacionwwds_17_tfobltotal ,
                                           AV88Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV91Obligacionwwds_21_tfoblimpfij ,
                                           AV92Obligacionwwds_22_tfoblimpfij_to ,
                                           AV93Obligacionwwds_23_tfoblporc ,
                                           AV94Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV95Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV96Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Short.valueOf(AV51EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV73Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV73Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV77Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV77Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV79Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV79Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV82Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV82Obligacionwwds_12_tfoblobs), "%", "") ;
      lV85Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV85Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P019I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV51EmpCod), Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to), lV73Obligacionwwds_3_tflegidnomape, Short.valueOf(AV75Obligacionwwds_5_tftipooblsec), Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to), lV77Obligacionwwds_7_tftipoobldescrip, lV79Obligacionwwds_9_tfoblconcepto, lV82Obligacionwwds_12_tfoblobs, lV85Obligacionwwds_15_tfoblconcodigo, AV87Obligacionwwds_17_tfobltotal, AV88Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to), AV91Obligacionwwds_21_tfoblimpfij, AV92Obligacionwwds_22_tfoblimpfij_to, AV93Obligacionwwds_23_tfoblporc, AV94Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P019I2_A6LegNumero[0] ;
         A1EmpCod = P019I2_A1EmpCod[0] ;
         A3CliCod = P019I2_A3CliCod[0] ;
         A1182OblDescu = P019I2_A1182OblDescu[0] ;
         A1181OblNoRemu = P019I2_A1181OblNoRemu[0] ;
         A1179OblPorc = P019I2_A1179OblPorc[0] ;
         A1178OblImpFij = P019I2_A1178OblImpFij[0] ;
         A1177OblCanCuo = P019I2_A1177OblCanCuo[0] ;
         A1176OblTotal = P019I2_A1176OblTotal[0] ;
         A1169OblConCodigo = P019I2_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P019I2_n1169OblConCodigo[0] ;
         A1175OblOriPer = P019I2_A1175OblOriPer[0] ;
         A1174OblObs = P019I2_A1174OblObs[0] ;
         A1173OblEstado = P019I2_A1173OblEstado[0] ;
         A2343OblConcepto = P019I2_A2343OblConcepto[0] ;
         A1165TipoOblDescrip = P019I2_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P019I2_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P019I2_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P019I2_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P019I2_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P019I2_A1165TipoOblDescrip[0] ;
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV33Option = A250LegIdNomApe ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            if ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) == 0 ) )
            {
               AV38count = GXutil.lval( (String)AV37OptionIndexes.elementAt(-1+AV32InsertIndex)) ;
               AV38count = (long)(AV38count+1) ;
               AV37OptionIndexes.removeItem(AV32InsertIndex);
               AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
            }
            else
            {
               AV34Options.add(AV33Option, AV32InsertIndex);
               AV37OptionIndexes.add("1", AV32InsertIndex);
            }
         }
         if ( AV34Options.size() == 50 )
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
      /* 'LOADTIPOOBLDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV62TFTipoOblDescrip = AV45SearchTxt ;
      AV63TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71Obligacionwwds_1_tfoblsecuencial = AV11TFOblSecuencial ;
      AV72Obligacionwwds_2_tfoblsecuencial_to = AV12TFOblSecuencial_To ;
      AV73Obligacionwwds_3_tflegidnomape = AV14TFLegIdNomApe ;
      AV74Obligacionwwds_4_tflegidnomape_sels = AV15TFLegIdNomApe_Sels ;
      AV75Obligacionwwds_5_tftipooblsec = AV53TFTipoOblSec ;
      AV76Obligacionwwds_6_tftipooblsec_to = AV54TFTipoOblSec_To ;
      AV77Obligacionwwds_7_tftipoobldescrip = AV62TFTipoOblDescrip ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = AV63TFTipoOblDescrip_Sels ;
      AV79Obligacionwwds_9_tfoblconcepto = AV65TFOblConcepto ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = AV66TFOblConcepto_Sels ;
      AV81Obligacionwwds_11_tfoblestado_sels = AV17TFOblEstado_Sels ;
      AV82Obligacionwwds_12_tfoblobs = AV19TFOblObs ;
      AV83Obligacionwwds_13_tfoblobs_sels = AV20TFOblObs_Sels ;
      AV84Obligacionwwds_14_tfobloriper_sels = AV56TFOblOriPer_Sels ;
      AV85Obligacionwwds_15_tfoblconcodigo = AV58TFOblConCodigo ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = AV59TFOblConCodigo_Sels ;
      AV87Obligacionwwds_17_tfobltotal = AV21TFOblTotal ;
      AV88Obligacionwwds_18_tfobltotal_to = AV22TFOblTotal_To ;
      AV89Obligacionwwds_19_tfoblcancuo = AV23TFOblCanCuo ;
      AV90Obligacionwwds_20_tfoblcancuo_to = AV24TFOblCanCuo_To ;
      AV91Obligacionwwds_21_tfoblimpfij = AV25TFOblImpFij ;
      AV92Obligacionwwds_22_tfoblimpfij_to = AV26TFOblImpFij_To ;
      AV93Obligacionwwds_23_tfoblporc = AV27TFOblPorc ;
      AV94Obligacionwwds_24_tfoblporc_to = AV28TFOblPorc_To ;
      AV95Obligacionwwds_25_tfoblnoremu_sel = AV30TFOblNoRemu_Sel ;
      AV96Obligacionwwds_26_tfobldescu_sel = AV31TFOblDescu_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV74Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV81Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV83Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV84Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV74Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV73Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV75Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV78Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV77Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV80Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV79Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV81Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV83Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV82Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV84Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV86Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV85Obligacionwwds_15_tfoblconcodigo ,
                                           AV87Obligacionwwds_17_tfobltotal ,
                                           AV88Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV91Obligacionwwds_21_tfoblimpfij ,
                                           AV92Obligacionwwds_22_tfoblimpfij_to ,
                                           AV93Obligacionwwds_23_tfoblporc ,
                                           AV94Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV95Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV96Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV51EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV73Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV73Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV77Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV77Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV79Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV79Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV82Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV82Obligacionwwds_12_tfoblobs), "%", "") ;
      lV85Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV85Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P019I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV51EmpCod), Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to), lV73Obligacionwwds_3_tflegidnomape, Short.valueOf(AV75Obligacionwwds_5_tftipooblsec), Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to), lV77Obligacionwwds_7_tftipoobldescrip, lV79Obligacionwwds_9_tfoblconcepto, lV82Obligacionwwds_12_tfoblobs, lV85Obligacionwwds_15_tfoblconcodigo, AV87Obligacionwwds_17_tfobltotal, AV88Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to), AV91Obligacionwwds_21_tfoblimpfij, AV92Obligacionwwds_22_tfoblimpfij_to, AV93Obligacionwwds_23_tfoblporc, AV94Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk19I3 = false ;
         A6LegNumero = P019I3_A6LegNumero[0] ;
         A3CliCod = P019I3_A3CliCod[0] ;
         A1EmpCod = P019I3_A1EmpCod[0] ;
         A1165TipoOblDescrip = P019I3_A1165TipoOblDescrip[0] ;
         A1182OblDescu = P019I3_A1182OblDescu[0] ;
         A1181OblNoRemu = P019I3_A1181OblNoRemu[0] ;
         A1179OblPorc = P019I3_A1179OblPorc[0] ;
         A1178OblImpFij = P019I3_A1178OblImpFij[0] ;
         A1177OblCanCuo = P019I3_A1177OblCanCuo[0] ;
         A1176OblTotal = P019I3_A1176OblTotal[0] ;
         A1169OblConCodigo = P019I3_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P019I3_n1169OblConCodigo[0] ;
         A1175OblOriPer = P019I3_A1175OblOriPer[0] ;
         A1174OblObs = P019I3_A1174OblObs[0] ;
         A1173OblEstado = P019I3_A1173OblEstado[0] ;
         A2343OblConcepto = P019I3_A2343OblConcepto[0] ;
         A1163TipoOblSec = P019I3_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P019I3_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P019I3_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P019I3_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P019I3_A1165TipoOblDescrip[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P019I3_A1165TipoOblDescrip[0], A1165TipoOblDescrip) == 0 ) )
         {
            brk19I3 = false ;
            A6LegNumero = P019I3_A6LegNumero[0] ;
            A3CliCod = P019I3_A3CliCod[0] ;
            A1EmpCod = P019I3_A1EmpCod[0] ;
            A1163TipoOblSec = P019I3_A1163TipoOblSec[0] ;
            A1172OblSecuencial = P019I3_A1172OblSecuencial[0] ;
            AV38count = (long)(AV38count+1) ;
            brk19I3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1165TipoOblDescrip)==0) )
         {
            AV33Option = A1165TipoOblDescrip ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19I3 )
         {
            brk19I3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADOBLCONCEPTOOPTIONS' Routine */
      returnInSub = false ;
      AV65TFOblConcepto = AV45SearchTxt ;
      AV66TFOblConcepto_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71Obligacionwwds_1_tfoblsecuencial = AV11TFOblSecuencial ;
      AV72Obligacionwwds_2_tfoblsecuencial_to = AV12TFOblSecuencial_To ;
      AV73Obligacionwwds_3_tflegidnomape = AV14TFLegIdNomApe ;
      AV74Obligacionwwds_4_tflegidnomape_sels = AV15TFLegIdNomApe_Sels ;
      AV75Obligacionwwds_5_tftipooblsec = AV53TFTipoOblSec ;
      AV76Obligacionwwds_6_tftipooblsec_to = AV54TFTipoOblSec_To ;
      AV77Obligacionwwds_7_tftipoobldescrip = AV62TFTipoOblDescrip ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = AV63TFTipoOblDescrip_Sels ;
      AV79Obligacionwwds_9_tfoblconcepto = AV65TFOblConcepto ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = AV66TFOblConcepto_Sels ;
      AV81Obligacionwwds_11_tfoblestado_sels = AV17TFOblEstado_Sels ;
      AV82Obligacionwwds_12_tfoblobs = AV19TFOblObs ;
      AV83Obligacionwwds_13_tfoblobs_sels = AV20TFOblObs_Sels ;
      AV84Obligacionwwds_14_tfobloriper_sels = AV56TFOblOriPer_Sels ;
      AV85Obligacionwwds_15_tfoblconcodigo = AV58TFOblConCodigo ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = AV59TFOblConCodigo_Sels ;
      AV87Obligacionwwds_17_tfobltotal = AV21TFOblTotal ;
      AV88Obligacionwwds_18_tfobltotal_to = AV22TFOblTotal_To ;
      AV89Obligacionwwds_19_tfoblcancuo = AV23TFOblCanCuo ;
      AV90Obligacionwwds_20_tfoblcancuo_to = AV24TFOblCanCuo_To ;
      AV91Obligacionwwds_21_tfoblimpfij = AV25TFOblImpFij ;
      AV92Obligacionwwds_22_tfoblimpfij_to = AV26TFOblImpFij_To ;
      AV93Obligacionwwds_23_tfoblporc = AV27TFOblPorc ;
      AV94Obligacionwwds_24_tfoblporc_to = AV28TFOblPorc_To ;
      AV95Obligacionwwds_25_tfoblnoremu_sel = AV30TFOblNoRemu_Sel ;
      AV96Obligacionwwds_26_tfobldescu_sel = AV31TFOblDescu_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV74Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV81Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV83Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV84Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV74Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV73Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV75Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV78Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV77Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV80Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV79Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV81Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV83Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV82Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV84Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV86Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV85Obligacionwwds_15_tfoblconcodigo ,
                                           AV87Obligacionwwds_17_tfobltotal ,
                                           AV88Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV91Obligacionwwds_21_tfoblimpfij ,
                                           AV92Obligacionwwds_22_tfoblimpfij_to ,
                                           AV93Obligacionwwds_23_tfoblporc ,
                                           AV94Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV95Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV96Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV51EmpCod) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV73Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV73Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV77Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV77Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV79Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV79Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV82Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV82Obligacionwwds_12_tfoblobs), "%", "") ;
      lV85Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV85Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P019I4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV51EmpCod), Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to), lV73Obligacionwwds_3_tflegidnomape, Short.valueOf(AV75Obligacionwwds_5_tftipooblsec), Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to), lV77Obligacionwwds_7_tftipoobldescrip, lV79Obligacionwwds_9_tfoblconcepto, lV82Obligacionwwds_12_tfoblobs, lV85Obligacionwwds_15_tfoblconcodigo, AV87Obligacionwwds_17_tfobltotal, AV88Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to), AV91Obligacionwwds_21_tfoblimpfij, AV92Obligacionwwds_22_tfoblimpfij_to, AV93Obligacionwwds_23_tfoblporc, AV94Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk19I5 = false ;
         A6LegNumero = P019I4_A6LegNumero[0] ;
         A3CliCod = P019I4_A3CliCod[0] ;
         A2343OblConcepto = P019I4_A2343OblConcepto[0] ;
         A1EmpCod = P019I4_A1EmpCod[0] ;
         A1182OblDescu = P019I4_A1182OblDescu[0] ;
         A1181OblNoRemu = P019I4_A1181OblNoRemu[0] ;
         A1179OblPorc = P019I4_A1179OblPorc[0] ;
         A1178OblImpFij = P019I4_A1178OblImpFij[0] ;
         A1177OblCanCuo = P019I4_A1177OblCanCuo[0] ;
         A1176OblTotal = P019I4_A1176OblTotal[0] ;
         A1169OblConCodigo = P019I4_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P019I4_n1169OblConCodigo[0] ;
         A1175OblOriPer = P019I4_A1175OblOriPer[0] ;
         A1174OblObs = P019I4_A1174OblObs[0] ;
         A1173OblEstado = P019I4_A1173OblEstado[0] ;
         A1165TipoOblDescrip = P019I4_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P019I4_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P019I4_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P019I4_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P019I4_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P019I4_A1165TipoOblDescrip[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P019I4_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P019I4_A2343OblConcepto[0], A2343OblConcepto) == 0 ) )
         {
            brk19I5 = false ;
            A6LegNumero = P019I4_A6LegNumero[0] ;
            A1EmpCod = P019I4_A1EmpCod[0] ;
            A1172OblSecuencial = P019I4_A1172OblSecuencial[0] ;
            AV38count = (long)(AV38count+1) ;
            brk19I5 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2343OblConcepto)==0) )
         {
            AV33Option = A2343OblConcepto ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19I5 )
         {
            brk19I5 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADOBLOBSOPTIONS' Routine */
      returnInSub = false ;
      AV19TFOblObs = AV45SearchTxt ;
      AV20TFOblObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71Obligacionwwds_1_tfoblsecuencial = AV11TFOblSecuencial ;
      AV72Obligacionwwds_2_tfoblsecuencial_to = AV12TFOblSecuencial_To ;
      AV73Obligacionwwds_3_tflegidnomape = AV14TFLegIdNomApe ;
      AV74Obligacionwwds_4_tflegidnomape_sels = AV15TFLegIdNomApe_Sels ;
      AV75Obligacionwwds_5_tftipooblsec = AV53TFTipoOblSec ;
      AV76Obligacionwwds_6_tftipooblsec_to = AV54TFTipoOblSec_To ;
      AV77Obligacionwwds_7_tftipoobldescrip = AV62TFTipoOblDescrip ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = AV63TFTipoOblDescrip_Sels ;
      AV79Obligacionwwds_9_tfoblconcepto = AV65TFOblConcepto ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = AV66TFOblConcepto_Sels ;
      AV81Obligacionwwds_11_tfoblestado_sels = AV17TFOblEstado_Sels ;
      AV82Obligacionwwds_12_tfoblobs = AV19TFOblObs ;
      AV83Obligacionwwds_13_tfoblobs_sels = AV20TFOblObs_Sels ;
      AV84Obligacionwwds_14_tfobloriper_sels = AV56TFOblOriPer_Sels ;
      AV85Obligacionwwds_15_tfoblconcodigo = AV58TFOblConCodigo ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = AV59TFOblConCodigo_Sels ;
      AV87Obligacionwwds_17_tfobltotal = AV21TFOblTotal ;
      AV88Obligacionwwds_18_tfobltotal_to = AV22TFOblTotal_To ;
      AV89Obligacionwwds_19_tfoblcancuo = AV23TFOblCanCuo ;
      AV90Obligacionwwds_20_tfoblcancuo_to = AV24TFOblCanCuo_To ;
      AV91Obligacionwwds_21_tfoblimpfij = AV25TFOblImpFij ;
      AV92Obligacionwwds_22_tfoblimpfij_to = AV26TFOblImpFij_To ;
      AV93Obligacionwwds_23_tfoblporc = AV27TFOblPorc ;
      AV94Obligacionwwds_24_tfoblporc_to = AV28TFOblPorc_To ;
      AV95Obligacionwwds_25_tfoblnoremu_sel = AV30TFOblNoRemu_Sel ;
      AV96Obligacionwwds_26_tfobldescu_sel = AV31TFOblDescu_Sel ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV74Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV81Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV83Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV84Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV74Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV73Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV75Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV78Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV77Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV80Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV79Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV81Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV83Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV82Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV84Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV86Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV85Obligacionwwds_15_tfoblconcodigo ,
                                           AV87Obligacionwwds_17_tfobltotal ,
                                           AV88Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV91Obligacionwwds_21_tfoblimpfij ,
                                           AV92Obligacionwwds_22_tfoblimpfij_to ,
                                           AV93Obligacionwwds_23_tfoblporc ,
                                           AV94Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV95Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV96Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV51EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV73Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV73Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV77Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV77Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV79Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV79Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV82Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV82Obligacionwwds_12_tfoblobs), "%", "") ;
      lV85Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV85Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P019I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV51EmpCod), Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to), lV73Obligacionwwds_3_tflegidnomape, Short.valueOf(AV75Obligacionwwds_5_tftipooblsec), Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to), lV77Obligacionwwds_7_tftipoobldescrip, lV79Obligacionwwds_9_tfoblconcepto, lV82Obligacionwwds_12_tfoblobs, lV85Obligacionwwds_15_tfoblconcodigo, AV87Obligacionwwds_17_tfobltotal, AV88Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to), AV91Obligacionwwds_21_tfoblimpfij, AV92Obligacionwwds_22_tfoblimpfij_to, AV93Obligacionwwds_23_tfoblporc, AV94Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk19I7 = false ;
         A6LegNumero = P019I5_A6LegNumero[0] ;
         A3CliCod = P019I5_A3CliCod[0] ;
         A1EmpCod = P019I5_A1EmpCod[0] ;
         A1174OblObs = P019I5_A1174OblObs[0] ;
         A1182OblDescu = P019I5_A1182OblDescu[0] ;
         A1181OblNoRemu = P019I5_A1181OblNoRemu[0] ;
         A1179OblPorc = P019I5_A1179OblPorc[0] ;
         A1178OblImpFij = P019I5_A1178OblImpFij[0] ;
         A1177OblCanCuo = P019I5_A1177OblCanCuo[0] ;
         A1176OblTotal = P019I5_A1176OblTotal[0] ;
         A1169OblConCodigo = P019I5_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P019I5_n1169OblConCodigo[0] ;
         A1175OblOriPer = P019I5_A1175OblOriPer[0] ;
         A1173OblEstado = P019I5_A1173OblEstado[0] ;
         A2343OblConcepto = P019I5_A2343OblConcepto[0] ;
         A1165TipoOblDescrip = P019I5_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P019I5_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P019I5_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P019I5_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P019I5_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P019I5_A1165TipoOblDescrip[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P019I5_A1174OblObs[0], A1174OblObs) == 0 ) )
         {
            brk19I7 = false ;
            A6LegNumero = P019I5_A6LegNumero[0] ;
            A3CliCod = P019I5_A3CliCod[0] ;
            A1EmpCod = P019I5_A1EmpCod[0] ;
            A1172OblSecuencial = P019I5_A1172OblSecuencial[0] ;
            AV38count = (long)(AV38count+1) ;
            brk19I7 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1174OblObs)==0) )
         {
            AV33Option = A1174OblObs ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19I7 )
         {
            brk19I7 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADOBLCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV58TFOblConCodigo = AV45SearchTxt ;
      AV59TFOblConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV71Obligacionwwds_1_tfoblsecuencial = AV11TFOblSecuencial ;
      AV72Obligacionwwds_2_tfoblsecuencial_to = AV12TFOblSecuencial_To ;
      AV73Obligacionwwds_3_tflegidnomape = AV14TFLegIdNomApe ;
      AV74Obligacionwwds_4_tflegidnomape_sels = AV15TFLegIdNomApe_Sels ;
      AV75Obligacionwwds_5_tftipooblsec = AV53TFTipoOblSec ;
      AV76Obligacionwwds_6_tftipooblsec_to = AV54TFTipoOblSec_To ;
      AV77Obligacionwwds_7_tftipoobldescrip = AV62TFTipoOblDescrip ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = AV63TFTipoOblDescrip_Sels ;
      AV79Obligacionwwds_9_tfoblconcepto = AV65TFOblConcepto ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = AV66TFOblConcepto_Sels ;
      AV81Obligacionwwds_11_tfoblestado_sels = AV17TFOblEstado_Sels ;
      AV82Obligacionwwds_12_tfoblobs = AV19TFOblObs ;
      AV83Obligacionwwds_13_tfoblobs_sels = AV20TFOblObs_Sels ;
      AV84Obligacionwwds_14_tfobloriper_sels = AV56TFOblOriPer_Sels ;
      AV85Obligacionwwds_15_tfoblconcodigo = AV58TFOblConCodigo ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = AV59TFOblConCodigo_Sels ;
      AV87Obligacionwwds_17_tfobltotal = AV21TFOblTotal ;
      AV88Obligacionwwds_18_tfobltotal_to = AV22TFOblTotal_To ;
      AV89Obligacionwwds_19_tfoblcancuo = AV23TFOblCanCuo ;
      AV90Obligacionwwds_20_tfoblcancuo_to = AV24TFOblCanCuo_To ;
      AV91Obligacionwwds_21_tfoblimpfij = AV25TFOblImpFij ;
      AV92Obligacionwwds_22_tfoblimpfij_to = AV26TFOblImpFij_To ;
      AV93Obligacionwwds_23_tfoblporc = AV27TFOblPorc ;
      AV94Obligacionwwds_24_tfoblporc_to = AV28TFOblPorc_To ;
      AV95Obligacionwwds_25_tfoblnoremu_sel = AV30TFOblNoRemu_Sel ;
      AV96Obligacionwwds_26_tfobldescu_sel = AV31TFOblDescu_Sel ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A250LegIdNomApe ,
                                           AV74Obligacionwwds_4_tflegidnomape_sels ,
                                           A1165TipoOblDescrip ,
                                           AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                           A2343OblConcepto ,
                                           AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                           Byte.valueOf(A1173OblEstado) ,
                                           AV81Obligacionwwds_11_tfoblestado_sels ,
                                           A1174OblObs ,
                                           AV83Obligacionwwds_13_tfoblobs_sels ,
                                           Byte.valueOf(A1175OblOriPer) ,
                                           AV84Obligacionwwds_14_tfobloriper_sels ,
                                           A1169OblConCodigo ,
                                           AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                           Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial) ,
                                           Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to) ,
                                           Integer.valueOf(AV74Obligacionwwds_4_tflegidnomape_sels.size()) ,
                                           AV73Obligacionwwds_3_tflegidnomape ,
                                           Short.valueOf(AV75Obligacionwwds_5_tftipooblsec) ,
                                           Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to) ,
                                           Integer.valueOf(AV78Obligacionwwds_8_tftipoobldescrip_sels.size()) ,
                                           AV77Obligacionwwds_7_tftipoobldescrip ,
                                           Integer.valueOf(AV80Obligacionwwds_10_tfoblconcepto_sels.size()) ,
                                           AV79Obligacionwwds_9_tfoblconcepto ,
                                           Integer.valueOf(AV81Obligacionwwds_11_tfoblestado_sels.size()) ,
                                           Integer.valueOf(AV83Obligacionwwds_13_tfoblobs_sels.size()) ,
                                           AV82Obligacionwwds_12_tfoblobs ,
                                           Integer.valueOf(AV84Obligacionwwds_14_tfobloriper_sels.size()) ,
                                           Integer.valueOf(AV86Obligacionwwds_16_tfoblconcodigo_sels.size()) ,
                                           AV85Obligacionwwds_15_tfoblconcodigo ,
                                           AV87Obligacionwwds_17_tfobltotal ,
                                           AV88Obligacionwwds_18_tfobltotal_to ,
                                           Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo) ,
                                           Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to) ,
                                           AV91Obligacionwwds_21_tfoblimpfij ,
                                           AV92Obligacionwwds_22_tfoblimpfij_to ,
                                           AV93Obligacionwwds_23_tfoblporc ,
                                           AV94Obligacionwwds_24_tfoblporc_to ,
                                           Byte.valueOf(AV95Obligacionwwds_25_tfoblnoremu_sel) ,
                                           Byte.valueOf(AV96Obligacionwwds_26_tfobldescu_sel) ,
                                           Short.valueOf(A1172OblSecuencial) ,
                                           Short.valueOf(A1163TipoOblSec) ,
                                           A1176OblTotal ,
                                           Short.valueOf(A1177OblCanCuo) ,
                                           A1178OblImpFij ,
                                           A1179OblPorc ,
                                           Boolean.valueOf(A1181OblNoRemu) ,
                                           Boolean.valueOf(A1182OblDescu) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV51EmpCod) ,
                                           Integer.valueOf(AV52CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV73Obligacionwwds_3_tflegidnomape = GXutil.concat( GXutil.rtrim( AV73Obligacionwwds_3_tflegidnomape), "%", "") ;
      lV77Obligacionwwds_7_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV77Obligacionwwds_7_tftipoobldescrip), "%", "") ;
      lV79Obligacionwwds_9_tfoblconcepto = GXutil.padr( GXutil.rtrim( AV79Obligacionwwds_9_tfoblconcepto), 10, "%") ;
      lV82Obligacionwwds_12_tfoblobs = GXutil.concat( GXutil.rtrim( AV82Obligacionwwds_12_tfoblobs), "%", "") ;
      lV85Obligacionwwds_15_tfoblconcodigo = GXutil.padr( GXutil.rtrim( AV85Obligacionwwds_15_tfoblconcodigo), 10, "%") ;
      /* Using cursor P019I6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV52CliCod), Short.valueOf(AV51EmpCod), Short.valueOf(AV71Obligacionwwds_1_tfoblsecuencial), Short.valueOf(AV72Obligacionwwds_2_tfoblsecuencial_to), lV73Obligacionwwds_3_tflegidnomape, Short.valueOf(AV75Obligacionwwds_5_tftipooblsec), Short.valueOf(AV76Obligacionwwds_6_tftipooblsec_to), lV77Obligacionwwds_7_tftipoobldescrip, lV79Obligacionwwds_9_tfoblconcepto, lV82Obligacionwwds_12_tfoblobs, lV85Obligacionwwds_15_tfoblconcodigo, AV87Obligacionwwds_17_tfobltotal, AV88Obligacionwwds_18_tfobltotal_to, Short.valueOf(AV89Obligacionwwds_19_tfoblcancuo), Short.valueOf(AV90Obligacionwwds_20_tfoblcancuo_to), AV91Obligacionwwds_21_tfoblimpfij, AV92Obligacionwwds_22_tfoblimpfij_to, AV93Obligacionwwds_23_tfoblporc, AV94Obligacionwwds_24_tfoblporc_to});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk19I9 = false ;
         A6LegNumero = P019I6_A6LegNumero[0] ;
         A3CliCod = P019I6_A3CliCod[0] ;
         A1169OblConCodigo = P019I6_A1169OblConCodigo[0] ;
         n1169OblConCodigo = P019I6_n1169OblConCodigo[0] ;
         A1EmpCod = P019I6_A1EmpCod[0] ;
         A1182OblDescu = P019I6_A1182OblDescu[0] ;
         A1181OblNoRemu = P019I6_A1181OblNoRemu[0] ;
         A1179OblPorc = P019I6_A1179OblPorc[0] ;
         A1178OblImpFij = P019I6_A1178OblImpFij[0] ;
         A1177OblCanCuo = P019I6_A1177OblCanCuo[0] ;
         A1176OblTotal = P019I6_A1176OblTotal[0] ;
         A1175OblOriPer = P019I6_A1175OblOriPer[0] ;
         A1174OblObs = P019I6_A1174OblObs[0] ;
         A1173OblEstado = P019I6_A1173OblEstado[0] ;
         A2343OblConcepto = P019I6_A2343OblConcepto[0] ;
         A1165TipoOblDescrip = P019I6_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P019I6_A1163TipoOblSec[0] ;
         A250LegIdNomApe = P019I6_A250LegIdNomApe[0] ;
         A1172OblSecuencial = P019I6_A1172OblSecuencial[0] ;
         A250LegIdNomApe = P019I6_A250LegIdNomApe[0] ;
         A1165TipoOblDescrip = P019I6_A1165TipoOblDescrip[0] ;
         AV38count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( P019I6_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P019I6_A1169OblConCodigo[0], A1169OblConCodigo) == 0 ) )
         {
            brk19I9 = false ;
            A6LegNumero = P019I6_A6LegNumero[0] ;
            A1EmpCod = P019I6_A1EmpCod[0] ;
            A1172OblSecuencial = P019I6_A1172OblSecuencial[0] ;
            AV38count = (long)(AV38count+1) ;
            brk19I9 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A1169OblConCodigo)==0) )
         {
            AV33Option = A1169OblConCodigo ;
            AV34Options.add(AV33Option, 0);
            AV37OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV38count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19I9 )
         {
            brk19I9 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP3[0] = obligacionwwgetfilterdata.this.AV47OptionsJson;
      this.aP4[0] = obligacionwwgetfilterdata.this.AV48OptionsDescJson;
      this.aP5[0] = obligacionwwgetfilterdata.this.AV49OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV47OptionsJson = "" ;
      AV48OptionsDescJson = "" ;
      AV49OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV39Session = httpContext.getWebSession();
      AV41GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV42GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFLegIdNomApe = "" ;
      AV13TFLegIdNomApe_SelsJson = "" ;
      AV15TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFTipoOblDescrip = "" ;
      AV61TFTipoOblDescrip_SelsJson = "" ;
      AV63TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65TFOblConcepto = "" ;
      AV64TFOblConcepto_SelsJson = "" ;
      AV66TFOblConcepto_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFOblEstado_SelsJson = "" ;
      AV17TFOblEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV19TFOblObs = "" ;
      AV18TFOblObs_SelsJson = "" ;
      AV20TFOblObs_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFOblOriPer_SelsJson = "" ;
      AV56TFOblOriPer_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV58TFOblConCodigo = "" ;
      AV57TFOblConCodigo_SelsJson = "" ;
      AV59TFOblConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFOblTotal = DecimalUtil.ZERO ;
      AV22TFOblTotal_To = DecimalUtil.ZERO ;
      AV25TFOblImpFij = DecimalUtil.ZERO ;
      AV26TFOblImpFij_To = DecimalUtil.ZERO ;
      AV27TFOblPorc = DecimalUtil.ZERO ;
      AV28TFOblPorc_To = DecimalUtil.ZERO ;
      AV60MenuOpcCod = "" ;
      A250LegIdNomApe = "" ;
      AV73Obligacionwwds_3_tflegidnomape = "" ;
      AV74Obligacionwwds_4_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Obligacionwwds_7_tftipoobldescrip = "" ;
      AV78Obligacionwwds_8_tftipoobldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Obligacionwwds_9_tfoblconcepto = "" ;
      AV80Obligacionwwds_10_tfoblconcepto_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV81Obligacionwwds_11_tfoblestado_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV82Obligacionwwds_12_tfoblobs = "" ;
      AV83Obligacionwwds_13_tfoblobs_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Obligacionwwds_14_tfobloriper_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV85Obligacionwwds_15_tfoblconcodigo = "" ;
      AV86Obligacionwwds_16_tfoblconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87Obligacionwwds_17_tfobltotal = DecimalUtil.ZERO ;
      AV88Obligacionwwds_18_tfobltotal_to = DecimalUtil.ZERO ;
      AV91Obligacionwwds_21_tfoblimpfij = DecimalUtil.ZERO ;
      AV92Obligacionwwds_22_tfoblimpfij_to = DecimalUtil.ZERO ;
      AV93Obligacionwwds_23_tfoblporc = DecimalUtil.ZERO ;
      AV94Obligacionwwds_24_tfoblporc_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV73Obligacionwwds_3_tflegidnomape = "" ;
      lV77Obligacionwwds_7_tftipoobldescrip = "" ;
      lV79Obligacionwwds_9_tfoblconcepto = "" ;
      lV82Obligacionwwds_12_tfoblobs = "" ;
      lV85Obligacionwwds_15_tfoblconcodigo = "" ;
      A1165TipoOblDescrip = "" ;
      A2343OblConcepto = "" ;
      A1174OblObs = "" ;
      A1169OblConCodigo = "" ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      P019I2_A6LegNumero = new int[1] ;
      P019I2_A1EmpCod = new short[1] ;
      P019I2_A3CliCod = new int[1] ;
      P019I2_A1182OblDescu = new boolean[] {false} ;
      P019I2_A1181OblNoRemu = new boolean[] {false} ;
      P019I2_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I2_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I2_A1177OblCanCuo = new short[1] ;
      P019I2_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I2_A1169OblConCodigo = new String[] {""} ;
      P019I2_n1169OblConCodigo = new boolean[] {false} ;
      P019I2_A1175OblOriPer = new byte[1] ;
      P019I2_A1174OblObs = new String[] {""} ;
      P019I2_A1173OblEstado = new byte[1] ;
      P019I2_A2343OblConcepto = new String[] {""} ;
      P019I2_A1165TipoOblDescrip = new String[] {""} ;
      P019I2_A1163TipoOblSec = new short[1] ;
      P019I2_A250LegIdNomApe = new String[] {""} ;
      P019I2_A1172OblSecuencial = new short[1] ;
      AV33Option = "" ;
      P019I3_A6LegNumero = new int[1] ;
      P019I3_A3CliCod = new int[1] ;
      P019I3_A1EmpCod = new short[1] ;
      P019I3_A1165TipoOblDescrip = new String[] {""} ;
      P019I3_A1182OblDescu = new boolean[] {false} ;
      P019I3_A1181OblNoRemu = new boolean[] {false} ;
      P019I3_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I3_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I3_A1177OblCanCuo = new short[1] ;
      P019I3_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I3_A1169OblConCodigo = new String[] {""} ;
      P019I3_n1169OblConCodigo = new boolean[] {false} ;
      P019I3_A1175OblOriPer = new byte[1] ;
      P019I3_A1174OblObs = new String[] {""} ;
      P019I3_A1173OblEstado = new byte[1] ;
      P019I3_A2343OblConcepto = new String[] {""} ;
      P019I3_A1163TipoOblSec = new short[1] ;
      P019I3_A250LegIdNomApe = new String[] {""} ;
      P019I3_A1172OblSecuencial = new short[1] ;
      P019I4_A6LegNumero = new int[1] ;
      P019I4_A3CliCod = new int[1] ;
      P019I4_A2343OblConcepto = new String[] {""} ;
      P019I4_A1EmpCod = new short[1] ;
      P019I4_A1182OblDescu = new boolean[] {false} ;
      P019I4_A1181OblNoRemu = new boolean[] {false} ;
      P019I4_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I4_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I4_A1177OblCanCuo = new short[1] ;
      P019I4_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I4_A1169OblConCodigo = new String[] {""} ;
      P019I4_n1169OblConCodigo = new boolean[] {false} ;
      P019I4_A1175OblOriPer = new byte[1] ;
      P019I4_A1174OblObs = new String[] {""} ;
      P019I4_A1173OblEstado = new byte[1] ;
      P019I4_A1165TipoOblDescrip = new String[] {""} ;
      P019I4_A1163TipoOblSec = new short[1] ;
      P019I4_A250LegIdNomApe = new String[] {""} ;
      P019I4_A1172OblSecuencial = new short[1] ;
      P019I5_A6LegNumero = new int[1] ;
      P019I5_A3CliCod = new int[1] ;
      P019I5_A1EmpCod = new short[1] ;
      P019I5_A1174OblObs = new String[] {""} ;
      P019I5_A1182OblDescu = new boolean[] {false} ;
      P019I5_A1181OblNoRemu = new boolean[] {false} ;
      P019I5_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I5_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I5_A1177OblCanCuo = new short[1] ;
      P019I5_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I5_A1169OblConCodigo = new String[] {""} ;
      P019I5_n1169OblConCodigo = new boolean[] {false} ;
      P019I5_A1175OblOriPer = new byte[1] ;
      P019I5_A1173OblEstado = new byte[1] ;
      P019I5_A2343OblConcepto = new String[] {""} ;
      P019I5_A1165TipoOblDescrip = new String[] {""} ;
      P019I5_A1163TipoOblSec = new short[1] ;
      P019I5_A250LegIdNomApe = new String[] {""} ;
      P019I5_A1172OblSecuencial = new short[1] ;
      P019I6_A6LegNumero = new int[1] ;
      P019I6_A3CliCod = new int[1] ;
      P019I6_A1169OblConCodigo = new String[] {""} ;
      P019I6_n1169OblConCodigo = new boolean[] {false} ;
      P019I6_A1EmpCod = new short[1] ;
      P019I6_A1182OblDescu = new boolean[] {false} ;
      P019I6_A1181OblNoRemu = new boolean[] {false} ;
      P019I6_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I6_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I6_A1177OblCanCuo = new short[1] ;
      P019I6_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019I6_A1175OblOriPer = new byte[1] ;
      P019I6_A1174OblObs = new String[] {""} ;
      P019I6_A1173OblEstado = new byte[1] ;
      P019I6_A2343OblConcepto = new String[] {""} ;
      P019I6_A1165TipoOblDescrip = new String[] {""} ;
      P019I6_A1163TipoOblSec = new short[1] ;
      P019I6_A250LegIdNomApe = new String[] {""} ;
      P019I6_A1172OblSecuencial = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P019I2_A6LegNumero, P019I2_A1EmpCod, P019I2_A3CliCod, P019I2_A1182OblDescu, P019I2_A1181OblNoRemu, P019I2_A1179OblPorc, P019I2_A1178OblImpFij, P019I2_A1177OblCanCuo, P019I2_A1176OblTotal, P019I2_A1169OblConCodigo,
            P019I2_n1169OblConCodigo, P019I2_A1175OblOriPer, P019I2_A1174OblObs, P019I2_A1173OblEstado, P019I2_A2343OblConcepto, P019I2_A1165TipoOblDescrip, P019I2_A1163TipoOblSec, P019I2_A250LegIdNomApe, P019I2_A1172OblSecuencial
            }
            , new Object[] {
            P019I3_A6LegNumero, P019I3_A3CliCod, P019I3_A1EmpCod, P019I3_A1165TipoOblDescrip, P019I3_A1182OblDescu, P019I3_A1181OblNoRemu, P019I3_A1179OblPorc, P019I3_A1178OblImpFij, P019I3_A1177OblCanCuo, P019I3_A1176OblTotal,
            P019I3_A1169OblConCodigo, P019I3_n1169OblConCodigo, P019I3_A1175OblOriPer, P019I3_A1174OblObs, P019I3_A1173OblEstado, P019I3_A2343OblConcepto, P019I3_A1163TipoOblSec, P019I3_A250LegIdNomApe, P019I3_A1172OblSecuencial
            }
            , new Object[] {
            P019I4_A6LegNumero, P019I4_A3CliCod, P019I4_A2343OblConcepto, P019I4_A1EmpCod, P019I4_A1182OblDescu, P019I4_A1181OblNoRemu, P019I4_A1179OblPorc, P019I4_A1178OblImpFij, P019I4_A1177OblCanCuo, P019I4_A1176OblTotal,
            P019I4_A1169OblConCodigo, P019I4_n1169OblConCodigo, P019I4_A1175OblOriPer, P019I4_A1174OblObs, P019I4_A1173OblEstado, P019I4_A1165TipoOblDescrip, P019I4_A1163TipoOblSec, P019I4_A250LegIdNomApe, P019I4_A1172OblSecuencial
            }
            , new Object[] {
            P019I5_A6LegNumero, P019I5_A3CliCod, P019I5_A1EmpCod, P019I5_A1174OblObs, P019I5_A1182OblDescu, P019I5_A1181OblNoRemu, P019I5_A1179OblPorc, P019I5_A1178OblImpFij, P019I5_A1177OblCanCuo, P019I5_A1176OblTotal,
            P019I5_A1169OblConCodigo, P019I5_n1169OblConCodigo, P019I5_A1175OblOriPer, P019I5_A1173OblEstado, P019I5_A2343OblConcepto, P019I5_A1165TipoOblDescrip, P019I5_A1163TipoOblSec, P019I5_A250LegIdNomApe, P019I5_A1172OblSecuencial
            }
            , new Object[] {
            P019I6_A6LegNumero, P019I6_A3CliCod, P019I6_A1169OblConCodigo, P019I6_n1169OblConCodigo, P019I6_A1EmpCod, P019I6_A1182OblDescu, P019I6_A1181OblNoRemu, P019I6_A1179OblPorc, P019I6_A1178OblImpFij, P019I6_A1177OblCanCuo,
            P019I6_A1176OblTotal, P019I6_A1175OblOriPer, P019I6_A1174OblObs, P019I6_A1173OblEstado, P019I6_A2343OblConcepto, P019I6_A1165TipoOblDescrip, P019I6_A1163TipoOblSec, P019I6_A250LegIdNomApe, P019I6_A1172OblSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV30TFOblNoRemu_Sel ;
   private byte AV31TFOblDescu_Sel ;
   private byte AV95Obligacionwwds_25_tfoblnoremu_sel ;
   private byte AV96Obligacionwwds_26_tfobldescu_sel ;
   private byte A1173OblEstado ;
   private byte A1175OblOriPer ;
   private short AV51EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFOblSecuencial ;
   private short AV12TFOblSecuencial_To ;
   private short AV53TFTipoOblSec ;
   private short AV54TFTipoOblSec_To ;
   private short AV23TFOblCanCuo ;
   private short AV24TFOblCanCuo_To ;
   private short AV71Obligacionwwds_1_tfoblsecuencial ;
   private short AV72Obligacionwwds_2_tfoblsecuencial_to ;
   private short AV75Obligacionwwds_5_tftipooblsec ;
   private short AV76Obligacionwwds_6_tftipooblsec_to ;
   private short AV89Obligacionwwds_19_tfoblcancuo ;
   private short AV90Obligacionwwds_20_tfoblcancuo_to ;
   private short A1172OblSecuencial ;
   private short A1163TipoOblSec ;
   private short A1177OblCanCuo ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV52CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV69GXV1 ;
   private int AV74Obligacionwwds_4_tflegidnomape_sels_size ;
   private int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ;
   private int AV80Obligacionwwds_10_tfoblconcepto_sels_size ;
   private int AV81Obligacionwwds_11_tfoblestado_sels_size ;
   private int AV83Obligacionwwds_13_tfoblobs_sels_size ;
   private int AV84Obligacionwwds_14_tfobloriper_sels_size ;
   private int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV32InsertIndex ;
   private long AV38count ;
   private java.math.BigDecimal AV21TFOblTotal ;
   private java.math.BigDecimal AV22TFOblTotal_To ;
   private java.math.BigDecimal AV25TFOblImpFij ;
   private java.math.BigDecimal AV26TFOblImpFij_To ;
   private java.math.BigDecimal AV27TFOblPorc ;
   private java.math.BigDecimal AV28TFOblPorc_To ;
   private java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ;
   private java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ;
   private java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ;
   private java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ;
   private java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ;
   private java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal A1179OblPorc ;
   private String AV65TFOblConcepto ;
   private String AV58TFOblConCodigo ;
   private String AV79Obligacionwwds_9_tfoblconcepto ;
   private String AV85Obligacionwwds_15_tfoblconcodigo ;
   private String scmdbuf ;
   private String lV79Obligacionwwds_9_tfoblconcepto ;
   private String lV85Obligacionwwds_15_tfoblconcodigo ;
   private String A2343OblConcepto ;
   private String A1169OblConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1181OblNoRemu ;
   private boolean A1182OblDescu ;
   private boolean n1169OblConCodigo ;
   private boolean brk19I3 ;
   private boolean brk19I5 ;
   private boolean brk19I7 ;
   private boolean brk19I9 ;
   private String AV47OptionsJson ;
   private String AV48OptionsDescJson ;
   private String AV49OptionIndexesJson ;
   private String AV13TFLegIdNomApe_SelsJson ;
   private String AV61TFTipoOblDescrip_SelsJson ;
   private String AV64TFOblConcepto_SelsJson ;
   private String AV16TFOblEstado_SelsJson ;
   private String AV18TFOblObs_SelsJson ;
   private String AV55TFOblOriPer_SelsJson ;
   private String AV57TFOblConCodigo_SelsJson ;
   private String A1174OblObs ;
   private String AV44DDOName ;
   private String AV45SearchTxt ;
   private String AV46SearchTxtTo ;
   private String AV14TFLegIdNomApe ;
   private String AV62TFTipoOblDescrip ;
   private String AV19TFOblObs ;
   private String AV60MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String AV73Obligacionwwds_3_tflegidnomape ;
   private String AV77Obligacionwwds_7_tftipoobldescrip ;
   private String AV82Obligacionwwds_12_tfoblobs ;
   private String lV73Obligacionwwds_3_tflegidnomape ;
   private String lV77Obligacionwwds_7_tftipoobldescrip ;
   private String lV82Obligacionwwds_12_tfoblobs ;
   private String A1165TipoOblDescrip ;
   private String AV33Option ;
   private GXSimpleCollection<Byte> AV17TFOblEstado_Sels ;
   private GXSimpleCollection<Byte> AV56TFOblOriPer_Sels ;
   private GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ;
   private GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ;
   private com.genexus.webpanels.WebSession AV39Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P019I2_A6LegNumero ;
   private short[] P019I2_A1EmpCod ;
   private int[] P019I2_A3CliCod ;
   private boolean[] P019I2_A1182OblDescu ;
   private boolean[] P019I2_A1181OblNoRemu ;
   private java.math.BigDecimal[] P019I2_A1179OblPorc ;
   private java.math.BigDecimal[] P019I2_A1178OblImpFij ;
   private short[] P019I2_A1177OblCanCuo ;
   private java.math.BigDecimal[] P019I2_A1176OblTotal ;
   private String[] P019I2_A1169OblConCodigo ;
   private boolean[] P019I2_n1169OblConCodigo ;
   private byte[] P019I2_A1175OblOriPer ;
   private String[] P019I2_A1174OblObs ;
   private byte[] P019I2_A1173OblEstado ;
   private String[] P019I2_A2343OblConcepto ;
   private String[] P019I2_A1165TipoOblDescrip ;
   private short[] P019I2_A1163TipoOblSec ;
   private String[] P019I2_A250LegIdNomApe ;
   private short[] P019I2_A1172OblSecuencial ;
   private int[] P019I3_A6LegNumero ;
   private int[] P019I3_A3CliCod ;
   private short[] P019I3_A1EmpCod ;
   private String[] P019I3_A1165TipoOblDescrip ;
   private boolean[] P019I3_A1182OblDescu ;
   private boolean[] P019I3_A1181OblNoRemu ;
   private java.math.BigDecimal[] P019I3_A1179OblPorc ;
   private java.math.BigDecimal[] P019I3_A1178OblImpFij ;
   private short[] P019I3_A1177OblCanCuo ;
   private java.math.BigDecimal[] P019I3_A1176OblTotal ;
   private String[] P019I3_A1169OblConCodigo ;
   private boolean[] P019I3_n1169OblConCodigo ;
   private byte[] P019I3_A1175OblOriPer ;
   private String[] P019I3_A1174OblObs ;
   private byte[] P019I3_A1173OblEstado ;
   private String[] P019I3_A2343OblConcepto ;
   private short[] P019I3_A1163TipoOblSec ;
   private String[] P019I3_A250LegIdNomApe ;
   private short[] P019I3_A1172OblSecuencial ;
   private int[] P019I4_A6LegNumero ;
   private int[] P019I4_A3CliCod ;
   private String[] P019I4_A2343OblConcepto ;
   private short[] P019I4_A1EmpCod ;
   private boolean[] P019I4_A1182OblDescu ;
   private boolean[] P019I4_A1181OblNoRemu ;
   private java.math.BigDecimal[] P019I4_A1179OblPorc ;
   private java.math.BigDecimal[] P019I4_A1178OblImpFij ;
   private short[] P019I4_A1177OblCanCuo ;
   private java.math.BigDecimal[] P019I4_A1176OblTotal ;
   private String[] P019I4_A1169OblConCodigo ;
   private boolean[] P019I4_n1169OblConCodigo ;
   private byte[] P019I4_A1175OblOriPer ;
   private String[] P019I4_A1174OblObs ;
   private byte[] P019I4_A1173OblEstado ;
   private String[] P019I4_A1165TipoOblDescrip ;
   private short[] P019I4_A1163TipoOblSec ;
   private String[] P019I4_A250LegIdNomApe ;
   private short[] P019I4_A1172OblSecuencial ;
   private int[] P019I5_A6LegNumero ;
   private int[] P019I5_A3CliCod ;
   private short[] P019I5_A1EmpCod ;
   private String[] P019I5_A1174OblObs ;
   private boolean[] P019I5_A1182OblDescu ;
   private boolean[] P019I5_A1181OblNoRemu ;
   private java.math.BigDecimal[] P019I5_A1179OblPorc ;
   private java.math.BigDecimal[] P019I5_A1178OblImpFij ;
   private short[] P019I5_A1177OblCanCuo ;
   private java.math.BigDecimal[] P019I5_A1176OblTotal ;
   private String[] P019I5_A1169OblConCodigo ;
   private boolean[] P019I5_n1169OblConCodigo ;
   private byte[] P019I5_A1175OblOriPer ;
   private byte[] P019I5_A1173OblEstado ;
   private String[] P019I5_A2343OblConcepto ;
   private String[] P019I5_A1165TipoOblDescrip ;
   private short[] P019I5_A1163TipoOblSec ;
   private String[] P019I5_A250LegIdNomApe ;
   private short[] P019I5_A1172OblSecuencial ;
   private int[] P019I6_A6LegNumero ;
   private int[] P019I6_A3CliCod ;
   private String[] P019I6_A1169OblConCodigo ;
   private boolean[] P019I6_n1169OblConCodigo ;
   private short[] P019I6_A1EmpCod ;
   private boolean[] P019I6_A1182OblDescu ;
   private boolean[] P019I6_A1181OblNoRemu ;
   private java.math.BigDecimal[] P019I6_A1179OblPorc ;
   private java.math.BigDecimal[] P019I6_A1178OblImpFij ;
   private short[] P019I6_A1177OblCanCuo ;
   private java.math.BigDecimal[] P019I6_A1176OblTotal ;
   private byte[] P019I6_A1175OblOriPer ;
   private String[] P019I6_A1174OblObs ;
   private byte[] P019I6_A1173OblEstado ;
   private String[] P019I6_A2343OblConcepto ;
   private String[] P019I6_A1165TipoOblDescrip ;
   private short[] P019I6_A1163TipoOblSec ;
   private String[] P019I6_A250LegIdNomApe ;
   private short[] P019I6_A1172OblSecuencial ;
   private GXSimpleCollection<String> AV66TFOblConcepto_Sels ;
   private GXSimpleCollection<String> AV59TFOblConCodigo_Sels ;
   private GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ;
   private GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV36OptionsDesc ;
   private GXSimpleCollection<String> AV37OptionIndexes ;
   private GXSimpleCollection<String> AV15TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV63TFTipoOblDescrip_Sels ;
   private GXSimpleCollection<String> AV20TFOblObs_Sels ;
   private GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ;
   private GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV41GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV42GridStateFilterValue ;
}

final  class obligacionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P019I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV71Obligacionwwds_1_tfoblsecuencial ,
                                          short AV72Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV74Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV73Obligacionwwds_3_tflegidnomape ,
                                          short AV75Obligacionwwds_5_tftipooblsec ,
                                          short AV76Obligacionwwds_6_tftipooblsec_to ,
                                          int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV77Obligacionwwds_7_tftipoobldescrip ,
                                          int AV80Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV79Obligacionwwds_9_tfoblconcepto ,
                                          int AV81Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV83Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV82Obligacionwwds_12_tfoblobs ,
                                          int AV84Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV85Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ,
                                          short AV89Obligacionwwds_19_tfoblcancuo ,
                                          short AV90Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ,
                                          byte AV95Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV96Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          int AV52CliCod ,
                                          short AV51EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[19];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer, T1.OblObs," ;
      scmdbuf += " T1.OblEstado, T1.OblConcepto, T3.TipoOblDescrip, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ! (0==AV71Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV74Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV74Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV75Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV76Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV80Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV80Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV81Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV83Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV83Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV84Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P019I3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV71Obligacionwwds_1_tfoblsecuencial ,
                                          short AV72Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV74Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV73Obligacionwwds_3_tflegidnomape ,
                                          short AV75Obligacionwwds_5_tftipooblsec ,
                                          short AV76Obligacionwwds_6_tftipooblsec_to ,
                                          int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV77Obligacionwwds_7_tftipoobldescrip ,
                                          int AV80Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV79Obligacionwwds_9_tfoblconcepto ,
                                          int AV81Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV83Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV82Obligacionwwds_12_tfoblobs ,
                                          int AV84Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV85Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ,
                                          short AV89Obligacionwwds_19_tfoblcancuo ,
                                          short AV90Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ,
                                          byte AV95Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV96Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          int A3CliCod ,
                                          int AV52CliCod ,
                                          short A1EmpCod ,
                                          short AV51EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[19];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T3.TipoOblDescrip, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer," ;
      scmdbuf += " T1.OblObs, T1.OblEstado, T1.OblConcepto, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND" ;
      scmdbuf += " T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV71Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV74Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV74Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV75Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV76Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV80Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV80Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV81Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV83Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( AV83Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV84Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.TipoOblDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P019I4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV71Obligacionwwds_1_tfoblsecuencial ,
                                          short AV72Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV74Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV73Obligacionwwds_3_tflegidnomape ,
                                          short AV75Obligacionwwds_5_tftipooblsec ,
                                          short AV76Obligacionwwds_6_tftipooblsec_to ,
                                          int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV77Obligacionwwds_7_tftipoobldescrip ,
                                          int AV80Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV79Obligacionwwds_9_tfoblconcepto ,
                                          int AV81Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV83Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV82Obligacionwwds_12_tfoblobs ,
                                          int AV84Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV85Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ,
                                          short AV89Obligacionwwds_19_tfoblcancuo ,
                                          short AV90Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ,
                                          byte AV95Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV96Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          short A1EmpCod ,
                                          short AV51EmpCod ,
                                          int AV52CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[19];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.OblConcepto, T1.EmpCod, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer," ;
      scmdbuf += " T1.OblObs, T1.OblEstado, T3.TipoOblDescrip, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND" ;
      scmdbuf += " T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV71Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ( AV74Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV74Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV75Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (0==AV76Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV80Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV80Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV81Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV83Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( AV83Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV84Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int14[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int14[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int14[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int14[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int14[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int14[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int14[18] = (byte)(1) ;
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.OblConcepto" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P019I5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV71Obligacionwwds_1_tfoblsecuencial ,
                                          short AV72Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV74Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV73Obligacionwwds_3_tflegidnomape ,
                                          short AV75Obligacionwwds_5_tftipooblsec ,
                                          short AV76Obligacionwwds_6_tftipooblsec_to ,
                                          int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV77Obligacionwwds_7_tftipoobldescrip ,
                                          int AV80Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV79Obligacionwwds_9_tfoblconcepto ,
                                          int AV81Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV83Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV82Obligacionwwds_12_tfoblobs ,
                                          int AV84Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV85Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ,
                                          short AV89Obligacionwwds_19_tfoblcancuo ,
                                          short AV90Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ,
                                          byte AV95Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV96Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          int A3CliCod ,
                                          int AV52CliCod ,
                                          short A1EmpCod ,
                                          short AV51EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[19];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.OblObs, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblConCodigo, T1.OblOriPer," ;
      scmdbuf += " T1.OblEstado, T1.OblConcepto, T3.TipoOblDescrip, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV71Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( ( AV74Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV74Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV75Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! (0==AV76Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV80Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV80Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV81Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV83Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( AV83Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV84Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int17[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int17[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int17[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int17[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int17[18] = (byte)(1) ;
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.OblObs" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P019I6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV74Obligacionwwds_4_tflegidnomape_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV78Obligacionwwds_8_tftipoobldescrip_sels ,
                                          String A2343OblConcepto ,
                                          GXSimpleCollection<String> AV80Obligacionwwds_10_tfoblconcepto_sels ,
                                          byte A1173OblEstado ,
                                          GXSimpleCollection<Byte> AV81Obligacionwwds_11_tfoblestado_sels ,
                                          String A1174OblObs ,
                                          GXSimpleCollection<String> AV83Obligacionwwds_13_tfoblobs_sels ,
                                          byte A1175OblOriPer ,
                                          GXSimpleCollection<Byte> AV84Obligacionwwds_14_tfobloriper_sels ,
                                          String A1169OblConCodigo ,
                                          GXSimpleCollection<String> AV86Obligacionwwds_16_tfoblconcodigo_sels ,
                                          short AV71Obligacionwwds_1_tfoblsecuencial ,
                                          short AV72Obligacionwwds_2_tfoblsecuencial_to ,
                                          int AV74Obligacionwwds_4_tflegidnomape_sels_size ,
                                          String AV73Obligacionwwds_3_tflegidnomape ,
                                          short AV75Obligacionwwds_5_tftipooblsec ,
                                          short AV76Obligacionwwds_6_tftipooblsec_to ,
                                          int AV78Obligacionwwds_8_tftipoobldescrip_sels_size ,
                                          String AV77Obligacionwwds_7_tftipoobldescrip ,
                                          int AV80Obligacionwwds_10_tfoblconcepto_sels_size ,
                                          String AV79Obligacionwwds_9_tfoblconcepto ,
                                          int AV81Obligacionwwds_11_tfoblestado_sels_size ,
                                          int AV83Obligacionwwds_13_tfoblobs_sels_size ,
                                          String AV82Obligacionwwds_12_tfoblobs ,
                                          int AV84Obligacionwwds_14_tfobloriper_sels_size ,
                                          int AV86Obligacionwwds_16_tfoblconcodigo_sels_size ,
                                          String AV85Obligacionwwds_15_tfoblconcodigo ,
                                          java.math.BigDecimal AV87Obligacionwwds_17_tfobltotal ,
                                          java.math.BigDecimal AV88Obligacionwwds_18_tfobltotal_to ,
                                          short AV89Obligacionwwds_19_tfoblcancuo ,
                                          short AV90Obligacionwwds_20_tfoblcancuo_to ,
                                          java.math.BigDecimal AV91Obligacionwwds_21_tfoblimpfij ,
                                          java.math.BigDecimal AV92Obligacionwwds_22_tfoblimpfij_to ,
                                          java.math.BigDecimal AV93Obligacionwwds_23_tfoblporc ,
                                          java.math.BigDecimal AV94Obligacionwwds_24_tfoblporc_to ,
                                          byte AV95Obligacionwwds_25_tfoblnoremu_sel ,
                                          byte AV96Obligacionwwds_26_tfobldescu_sel ,
                                          short A1172OblSecuencial ,
                                          short A1163TipoOblSec ,
                                          java.math.BigDecimal A1176OblTotal ,
                                          short A1177OblCanCuo ,
                                          java.math.BigDecimal A1178OblImpFij ,
                                          java.math.BigDecimal A1179OblPorc ,
                                          boolean A1181OblNoRemu ,
                                          boolean A1182OblDescu ,
                                          short A1EmpCod ,
                                          short AV51EmpCod ,
                                          int AV52CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[19];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.OblConCodigo, T1.EmpCod, T1.OblDescu, T1.OblNoRemu, T1.OblPorc, T1.OblImpFij, T1.OblCanCuo, T1.OblTotal, T1.OblOriPer, T1.OblObs," ;
      scmdbuf += " T1.OblEstado, T1.OblConcepto, T3.TipoOblDescrip, T1.TipoOblSec, T2.LegIdNomApe, T1.OblSecuencial FROM ((Obligacion T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = T1.TipoOblSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ! (0==AV71Obligacionwwds_1_tfoblsecuencial) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial >= ?)");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Obligacionwwds_2_tfoblsecuencial_to) )
      {
         addWhere(sWhereString, "(T1.OblSecuencial <= ?)");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( ( AV74Obligacionwwds_4_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Obligacionwwds_3_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( AV74Obligacionwwds_4_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Obligacionwwds_4_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV75Obligacionwwds_5_tftipooblsec) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec >= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! (0==AV76Obligacionwwds_6_tftipooblsec_to) )
      {
         addWhere(sWhereString, "(T1.TipoOblSec <= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Obligacionwwds_7_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( AV78Obligacionwwds_8_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Obligacionwwds_8_tftipoobldescrip_sels, "T3.TipoOblDescrip IN (", ")")+")");
      }
      if ( ( AV80Obligacionwwds_10_tfoblconcepto_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV79Obligacionwwds_9_tfoblconcepto)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConcepto) like LOWER(?))");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV80Obligacionwwds_10_tfoblconcepto_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Obligacionwwds_10_tfoblconcepto_sels, "T1.OblConcepto IN (", ")")+")");
      }
      if ( AV81Obligacionwwds_11_tfoblestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV81Obligacionwwds_11_tfoblestado_sels, "T1.OblEstado IN (", ")")+")");
      }
      if ( ( AV83Obligacionwwds_13_tfoblobs_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Obligacionwwds_12_tfoblobs)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblObs) like LOWER(?))");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( AV83Obligacionwwds_13_tfoblobs_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Obligacionwwds_13_tfoblobs_sels, "T1.OblObs IN (", ")")+")");
      }
      if ( AV84Obligacionwwds_14_tfobloriper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV84Obligacionwwds_14_tfobloriper_sels, "T1.OblOriPer IN (", ")")+")");
      }
      if ( ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Obligacionwwds_15_tfoblconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.OblConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( AV86Obligacionwwds_16_tfoblconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Obligacionwwds_16_tfoblconcodigo_sels, "T1.OblConCodigo IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87Obligacionwwds_17_tfobltotal)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal >= ?)");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88Obligacionwwds_18_tfobltotal_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblTotal <= ?)");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( ! (0==AV89Obligacionwwds_19_tfoblcancuo) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo >= ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      if ( ! (0==AV90Obligacionwwds_20_tfoblcancuo_to) )
      {
         addWhere(sWhereString, "(T1.OblCanCuo <= ?)");
      }
      else
      {
         GXv_int20[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91Obligacionwwds_21_tfoblimpfij)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij >= ?)");
      }
      else
      {
         GXv_int20[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92Obligacionwwds_22_tfoblimpfij_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblImpFij <= ?)");
      }
      else
      {
         GXv_int20[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93Obligacionwwds_23_tfoblporc)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc >= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94Obligacionwwds_24_tfoblporc_to)==0) )
      {
         addWhere(sWhereString, "(T1.OblPorc <= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = TRUE)");
      }
      if ( AV95Obligacionwwds_25_tfoblnoremu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblNoRemu = FALSE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 1 )
      {
         addWhere(sWhereString, "(T1.OblDescu = TRUE)");
      }
      if ( AV96Obligacionwwds_26_tfobldescu_sel == 2 )
      {
         addWhere(sWhereString, "(T1.OblDescu = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.OblConCodigo" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
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
                  return conditional_P019I2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).shortValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).shortValue() );
            case 1 :
                  return conditional_P019I3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() , ((Number) dynConstraints[51]).shortValue() );
            case 2 :
                  return conditional_P019I4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).shortValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).intValue() );
            case 3 :
                  return conditional_P019I5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).shortValue() , ((Number) dynConstraints[51]).shortValue() );
            case 4 :
                  return conditional_P019I6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).shortValue() , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).byteValue() , ((Number) dynConstraints[39]).byteValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).shortValue() , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Boolean) dynConstraints[46]).booleanValue() , ((Boolean) dynConstraints[47]).booleanValue() , ((Number) dynConstraints[48]).shortValue() , ((Number) dynConstraints[49]).shortValue() , ((Number) dynConstraints[50]).intValue() , ((Number) dynConstraints[51]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019I3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019I4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019I5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019I6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((byte[]) buf[14])[0] = rslt.getByte(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(13);
               ((byte[]) buf[14])[0] = rslt.getByte(14);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((String[]) buf[10])[0] = rslt.getString(11, 10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((byte[]) buf[12])[0] = rslt.getByte(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((byte[]) buf[13])[0] = rslt.getByte(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((short[]) buf[16])[0] = rslt.getShort(16);
               ((String[]) buf[17])[0] = rslt.getVarchar(17);
               ((short[]) buf[18])[0] = rslt.getShort(18);
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
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 200);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[30], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[31], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 4);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 4);
               }
               return;
      }
   }

}

