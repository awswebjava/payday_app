package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_aplicacion_gananciaswwgetfilterdata extends GXProcedure
{
   public tipo_aplicacion_gananciaswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_aplicacion_gananciaswwgetfilterdata.class ), "" );
   }

   public tipo_aplicacion_gananciaswwgetfilterdata( int remoteHandle ,
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
      tipo_aplicacion_gananciaswwgetfilterdata.this.aP5 = new String[] {""};
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
      tipo_aplicacion_gananciaswwgetfilterdata.this.AV50DDOName = aP0;
      tipo_aplicacion_gananciaswwgetfilterdata.this.AV51SearchTxt = aP1;
      tipo_aplicacion_gananciaswwgetfilterdata.this.AV52SearchTxtTo = aP2;
      tipo_aplicacion_gananciaswwgetfilterdata.this.aP3 = aP3;
      tipo_aplicacion_gananciaswwgetfilterdata.this.aP4 = aP4;
      tipo_aplicacion_gananciaswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV57EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      tipo_aplicacion_gananciaswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV57EmpCod = GXt_int1 ;
      GXt_int3 = AV58CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipo_aplicacion_gananciaswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV58CliCod = GXt_int3 ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias", GXv_boolean6) ;
      tipo_aplicacion_gananciaswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_APLIIGGNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADAPLIIGGNOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_APLIIGGTOPECON") == 0 )
         {
            /* Execute user subroutine: 'LOADAPLIIGGTOPECONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_APLIIGGEXENCON") == 0 )
         {
            /* Execute user subroutine: 'LOADAPLIIGGEXENCONOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_APLIIGGCONDICION") == 0 )
         {
            /* Execute user subroutine: 'LOADAPLIIGGCONDICIONOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_APLIIGGRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADAPLIIGGRELREFOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV53OptionsJson = AV40Options.toJSonString(false) ;
      AV54OptionsDescJson = AV42OptionsDesc.toJSonString(false) ;
      AV55OptionIndexesJson = AV43OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV45Session.getValue("tipo_aplicacion_gananciasWWGridState"), "") == 0 )
      {
         AV47GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "tipo_aplicacion_gananciasWWGridState"), null, null);
      }
      else
      {
         AV47GridState.fromxml(AV45Session.getValue("tipo_aplicacion_gananciasWWGridState"), null, null);
      }
      AV71GXV1 = 1 ;
      while ( AV71GXV1 <= AV47GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV48GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV47GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV71GXV1));
         if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGG") == 0 )
         {
            AV59TFAplIIGG = (short)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFAplIIGG_To = (short)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM") == 0 )
         {
            AV12TFAplIIGGNom = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGNOM_SEL") == 0 )
         {
            AV11TFAplIIGGNom_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFAplIIGGNom_Sels.fromJSonString(AV11TFAplIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTRAT_SEL") == 0 )
         {
            AV14TFAplIIGGTrat_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFAplIIGGTrat_Sels.fromJSonString(AV14TFAplIIGGTrat_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPROPOR") == 0 )
         {
            AV16TFAplIIGGPropor = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFAplIIGGPropor_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPETIP_SEL") == 0 )
         {
            AV18TFAplIIGGTopeTip_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFAplIIGGTopeTip_Sels.fromJSonString(AV18TFAplIIGGTopeTip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON") == 0 )
         {
            AV24TFAplIIGGTopeCon = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPECON_SEL") == 0 )
         {
            AV23TFAplIIGGTopeCon_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV25TFAplIIGGTopeCon_Sels.fromJSonString(AV23TFAplIIGGTopeCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGTOPEFIJ") == 0 )
         {
            AV26TFAplIIGGTopeFij = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV27TFAplIIGGTopeFij_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON") == 0 )
         {
            AV29TFAplIIGGExenCon = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGEXENCON_SEL") == 0 )
         {
            AV28TFAplIIGGExenCon_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFAplIIGGExenCon_Sels.fromJSonString(AV28TFAplIIGGExenCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGPRRTEAR_SEL") == 0 )
         {
            AV63TFAplIIGGPrrtear_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV64TFAplIIGGPrrtear_Sels.fromJSonString(AV63TFAplIIGGPrrtear_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION") == 0 )
         {
            AV36TFAplIIGGCondicion = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGCONDICION_SEL") == 0 )
         {
            AV35TFAplIIGGCondicion_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFAplIIGGCondicion_Sels.fromJSonString(AV35TFAplIIGGCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF") == 0 )
         {
            AV67TFAplIIGGRelRef = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFAPLIIGGRELREF_SEL") == 0 )
         {
            AV66TFAplIIGGRelRef_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV68TFAplIIGGRelRef_Sels.fromJSonString(AV66TFAplIIGGRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV65MenuOpcCod = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV71GXV1 = (int)(AV71GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADAPLIIGGNOMOPTIONS' Routine */
      returnInSub = false ;
      AV12TFAplIIGGNom = AV51SearchTxt ;
      AV13TFAplIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV59TFAplIIGG ;
      AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV60TFAplIIGG_To ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV12TFAplIIGGNom ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV13TFAplIIGGNom_Sels ;
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV15TFAplIIGGTrat_Sels ;
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV16TFAplIIGGPropor ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV17TFAplIIGGPropor_To ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV19TFAplIIGGTopeTip_Sels ;
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV24TFAplIIGGTopeCon ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV25TFAplIIGGTopeCon_Sels ;
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV26TFAplIIGGTopeFij ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV27TFAplIIGGTopeFij_To ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV29TFAplIIGGExenCon ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV30TFAplIIGGExenCon_Sels ;
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV64TFAplIIGGPrrtear_Sels ;
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV36TFAplIIGGCondicion ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV37TFAplIIGGCondicion_Sels ;
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV67TFAplIIGGRelRef ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV68TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV58CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P017X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk17X2 = false ;
         A3CliCod = P017X2_A3CliCod[0] ;
         A1113AplIIGGNom = P017X2_A1113AplIIGGNom[0] ;
         A2020AplIIGGRelRef = P017X2_A2020AplIIGGRelRef[0] ;
         A1124AplIIGGCondicion = P017X2_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017X2_n1124AplIIGGCondicion[0] ;
         A1121AplIIGGPrrtear = P017X2_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P017X2_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017X2_n1117AplIIGGExenCon[0] ;
         A1119AplIIGGTopeFij = P017X2_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P017X2_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017X2_n1111AplIIGGTopeCon[0] ;
         A1115AplIIGGTopeTip = P017X2_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P017X2_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P017X2_A1120AplIIGGTrat[0] ;
         A1112AplIIGG = P017X2_A1112AplIIGG[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P017X2_A1113AplIIGGNom[0], A1113AplIIGGNom) == 0 ) )
         {
            brk17X2 = false ;
            A3CliCod = P017X2_A3CliCod[0] ;
            A1112AplIIGG = P017X2_A1112AplIIGG[0] ;
            AV44count = (long)(AV44count+1) ;
            brk17X2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1113AplIIGGNom)==0) )
         {
            AV39Option = A1113AplIIGGNom ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17X2 )
         {
            brk17X2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADAPLIIGGTOPECONOPTIONS' Routine */
      returnInSub = false ;
      AV24TFAplIIGGTopeCon = AV51SearchTxt ;
      AV25TFAplIIGGTopeCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV59TFAplIIGG ;
      AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV60TFAplIIGG_To ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV12TFAplIIGGNom ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV13TFAplIIGGNom_Sels ;
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV15TFAplIIGGTrat_Sels ;
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV16TFAplIIGGPropor ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV17TFAplIIGGPropor_To ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV19TFAplIIGGTopeTip_Sels ;
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV24TFAplIIGGTopeCon ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV25TFAplIIGGTopeCon_Sels ;
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV26TFAplIIGGTopeFij ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV27TFAplIIGGTopeFij_To ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV29TFAplIIGGExenCon ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV30TFAplIIGGExenCon_Sels ;
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV64TFAplIIGGPrrtear_Sels ;
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV36TFAplIIGGCondicion ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV37TFAplIIGGCondicion_Sels ;
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV67TFAplIIGGRelRef ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV68TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P017X3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk17X4 = false ;
         A3CliCod = P017X3_A3CliCod[0] ;
         A1111AplIIGGTopeCon = P017X3_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017X3_n1111AplIIGGTopeCon[0] ;
         A2020AplIIGGRelRef = P017X3_A2020AplIIGGRelRef[0] ;
         A1124AplIIGGCondicion = P017X3_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017X3_n1124AplIIGGCondicion[0] ;
         A1121AplIIGGPrrtear = P017X3_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P017X3_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017X3_n1117AplIIGGExenCon[0] ;
         A1119AplIIGGTopeFij = P017X3_A1119AplIIGGTopeFij[0] ;
         A1115AplIIGGTopeTip = P017X3_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P017X3_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P017X3_A1120AplIIGGTrat[0] ;
         A1113AplIIGGNom = P017X3_A1113AplIIGGNom[0] ;
         A1112AplIIGG = P017X3_A1112AplIIGG[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P017X3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P017X3_A1111AplIIGGTopeCon[0], A1111AplIIGGTopeCon) == 0 ) )
         {
            brk17X4 = false ;
            A1112AplIIGG = P017X3_A1112AplIIGG[0] ;
            AV44count = (long)(AV44count+1) ;
            brk17X4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1111AplIIGGTopeCon)==0) )
         {
            AV39Option = A1111AplIIGGTopeCon ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17X4 )
         {
            brk17X4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADAPLIIGGEXENCONOPTIONS' Routine */
      returnInSub = false ;
      AV29TFAplIIGGExenCon = AV51SearchTxt ;
      AV30TFAplIIGGExenCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV59TFAplIIGG ;
      AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV60TFAplIIGG_To ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV12TFAplIIGGNom ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV13TFAplIIGGNom_Sels ;
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV15TFAplIIGGTrat_Sels ;
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV16TFAplIIGGPropor ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV17TFAplIIGGPropor_To ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV19TFAplIIGGTopeTip_Sels ;
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV24TFAplIIGGTopeCon ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV25TFAplIIGGTopeCon_Sels ;
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV26TFAplIIGGTopeFij ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV27TFAplIIGGTopeFij_To ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV29TFAplIIGGExenCon ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV30TFAplIIGGExenCon_Sels ;
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV64TFAplIIGGPrrtear_Sels ;
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV36TFAplIIGGCondicion ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV37TFAplIIGGCondicion_Sels ;
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV67TFAplIIGGRelRef ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV68TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P017X4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk17X6 = false ;
         A3CliCod = P017X4_A3CliCod[0] ;
         A1117AplIIGGExenCon = P017X4_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017X4_n1117AplIIGGExenCon[0] ;
         A2020AplIIGGRelRef = P017X4_A2020AplIIGGRelRef[0] ;
         A1124AplIIGGCondicion = P017X4_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017X4_n1124AplIIGGCondicion[0] ;
         A1121AplIIGGPrrtear = P017X4_A1121AplIIGGPrrtear[0] ;
         A1119AplIIGGTopeFij = P017X4_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P017X4_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017X4_n1111AplIIGGTopeCon[0] ;
         A1115AplIIGGTopeTip = P017X4_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P017X4_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P017X4_A1120AplIIGGTrat[0] ;
         A1113AplIIGGNom = P017X4_A1113AplIIGGNom[0] ;
         A1112AplIIGG = P017X4_A1112AplIIGG[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P017X4_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P017X4_A1117AplIIGGExenCon[0], A1117AplIIGGExenCon) == 0 ) )
         {
            brk17X6 = false ;
            A1112AplIIGG = P017X4_A1112AplIIGG[0] ;
            AV44count = (long)(AV44count+1) ;
            brk17X6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1117AplIIGGExenCon)==0) )
         {
            AV39Option = A1117AplIIGGExenCon ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17X6 )
         {
            brk17X6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADAPLIIGGCONDICIONOPTIONS' Routine */
      returnInSub = false ;
      AV36TFAplIIGGCondicion = AV51SearchTxt ;
      AV37TFAplIIGGCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV59TFAplIIGG ;
      AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV60TFAplIIGG_To ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV12TFAplIIGGNom ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV13TFAplIIGGNom_Sels ;
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV15TFAplIIGGTrat_Sels ;
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV16TFAplIIGGPropor ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV17TFAplIIGGPropor_To ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV19TFAplIIGGTopeTip_Sels ;
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV24TFAplIIGGTopeCon ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV25TFAplIIGGTopeCon_Sels ;
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV26TFAplIIGGTopeFij ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV27TFAplIIGGTopeFij_To ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV29TFAplIIGGExenCon ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV30TFAplIIGGExenCon_Sels ;
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV64TFAplIIGGPrrtear_Sels ;
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV36TFAplIIGGCondicion ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV37TFAplIIGGCondicion_Sels ;
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV67TFAplIIGGRelRef ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV68TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P017X5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk17X8 = false ;
         A3CliCod = P017X5_A3CliCod[0] ;
         A1124AplIIGGCondicion = P017X5_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017X5_n1124AplIIGGCondicion[0] ;
         A2020AplIIGGRelRef = P017X5_A2020AplIIGGRelRef[0] ;
         A1121AplIIGGPrrtear = P017X5_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P017X5_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017X5_n1117AplIIGGExenCon[0] ;
         A1119AplIIGGTopeFij = P017X5_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P017X5_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017X5_n1111AplIIGGTopeCon[0] ;
         A1115AplIIGGTopeTip = P017X5_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P017X5_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P017X5_A1120AplIIGGTrat[0] ;
         A1113AplIIGGNom = P017X5_A1113AplIIGGNom[0] ;
         A1112AplIIGG = P017X5_A1112AplIIGG[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( P017X5_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P017X5_A1124AplIIGGCondicion[0], A1124AplIIGGCondicion) == 0 ) )
         {
            brk17X8 = false ;
            A1112AplIIGG = P017X5_A1112AplIIGG[0] ;
            AV44count = (long)(AV44count+1) ;
            brk17X8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1124AplIIGGCondicion)==0) )
         {
            AV39Option = A1124AplIIGGCondicion ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17X8 )
         {
            brk17X8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADAPLIIGGRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV67TFAplIIGGRelRef = AV51SearchTxt ;
      AV68TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg = AV59TFAplIIGG ;
      AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to = AV60TFAplIIGG_To ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = AV12TFAplIIGGNom ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = AV13TFAplIIGGNom_Sels ;
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = AV15TFAplIIGGTrat_Sels ;
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = AV16TFAplIIGGPropor ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = AV17TFAplIIGGPropor_To ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = AV19TFAplIIGGTopeTip_Sels ;
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = AV24TFAplIIGGTopeCon ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = AV25TFAplIIGGTopeCon_Sels ;
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = AV26TFAplIIGGTopeFij ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = AV27TFAplIIGGTopeFij_To ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = AV29TFAplIIGGExenCon ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = AV30TFAplIIGGExenCon_Sels ;
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = AV64TFAplIIGGPrrtear_Sels ;
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = AV36TFAplIIGGCondicion ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = AV37TFAplIIGGCondicion_Sels ;
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = AV67TFAplIIGGRelRef ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = AV68TFAplIIGGRelRef_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A1113AplIIGGNom ,
                                           AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                           Byte.valueOf(A1120AplIIGGTrat) ,
                                           AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                           Byte.valueOf(A1115AplIIGGTopeTip) ,
                                           AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                           A1111AplIIGGTopeCon ,
                                           AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                           A1117AplIIGGExenCon ,
                                           AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                           A1121AplIIGGPrrtear ,
                                           AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                           A1124AplIIGGCondicion ,
                                           AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                           A2020AplIIGGRelRef ,
                                           AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                           Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) ,
                                           Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) ,
                                           Integer.valueOf(AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels.size()) ,
                                           AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                           Integer.valueOf(AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels.size()) ,
                                           AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                           AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                           Integer.valueOf(AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels.size()) ,
                                           Integer.valueOf(AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels.size()) ,
                                           AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                           AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                           AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                           Integer.valueOf(AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels.size()) ,
                                           AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                           Integer.valueOf(AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels.size()) ,
                                           Integer.valueOf(AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels.size()) ,
                                           AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                           Integer.valueOf(AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels.size()) ,
                                           AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                           Short.valueOf(A1112AplIIGG) ,
                                           A1114AplIIGGPropor ,
                                           A1119AplIIGGTopeFij ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV58CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = GXutil.concat( GXutil.rtrim( AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom), "%", "") ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = GXutil.padr( GXutil.rtrim( AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon), 10, "%") ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = GXutil.padr( GXutil.rtrim( AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon), 10, "%") ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = GXutil.padr( GXutil.rtrim( AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion), 20, "%") ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = GXutil.concat( GXutil.rtrim( AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref), "%", "") ;
      /* Using cursor P017X6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg), Short.valueOf(AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to), lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to, lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to, lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon, lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion, lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk17X10 = false ;
         A3CliCod = P017X6_A3CliCod[0] ;
         A2020AplIIGGRelRef = P017X6_A2020AplIIGGRelRef[0] ;
         A1124AplIIGGCondicion = P017X6_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = P017X6_n1124AplIIGGCondicion[0] ;
         A1121AplIIGGPrrtear = P017X6_A1121AplIIGGPrrtear[0] ;
         A1117AplIIGGExenCon = P017X6_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = P017X6_n1117AplIIGGExenCon[0] ;
         A1119AplIIGGTopeFij = P017X6_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P017X6_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017X6_n1111AplIIGGTopeCon[0] ;
         A1115AplIIGGTopeTip = P017X6_A1115AplIIGGTopeTip[0] ;
         A1114AplIIGGPropor = P017X6_A1114AplIIGGPropor[0] ;
         A1120AplIIGGTrat = P017X6_A1120AplIIGGTrat[0] ;
         A1113AplIIGGNom = P017X6_A1113AplIIGGNom[0] ;
         A1112AplIIGG = P017X6_A1112AplIIGG[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P017X6_A2020AplIIGGRelRef[0], A2020AplIIGGRelRef) == 0 ) )
         {
            brk17X10 = false ;
            A3CliCod = P017X6_A3CliCod[0] ;
            A1112AplIIGG = P017X6_A1112AplIIGG[0] ;
            AV44count = (long)(AV44count+1) ;
            brk17X10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A2020AplIIGGRelRef)==0) )
         {
            AV39Option = A2020AplIIGGRelRef ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17X10 )
         {
            brk17X10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipo_aplicacion_gananciaswwgetfilterdata.this.AV53OptionsJson;
      this.aP4[0] = tipo_aplicacion_gananciaswwgetfilterdata.this.AV54OptionsDescJson;
      this.aP5[0] = tipo_aplicacion_gananciaswwgetfilterdata.this.AV55OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV53OptionsJson = "" ;
      AV54OptionsDescJson = "" ;
      AV55OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV45Session = httpContext.getWebSession();
      AV47GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV48GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFAplIIGGNom = "" ;
      AV11TFAplIIGGNom_SelsJson = "" ;
      AV13TFAplIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFAplIIGGTrat_SelsJson = "" ;
      AV15TFAplIIGGTrat_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV16TFAplIIGGPropor = DecimalUtil.ZERO ;
      AV17TFAplIIGGPropor_To = DecimalUtil.ZERO ;
      AV18TFAplIIGGTopeTip_SelsJson = "" ;
      AV19TFAplIIGGTopeTip_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV24TFAplIIGGTopeCon = "" ;
      AV23TFAplIIGGTopeCon_SelsJson = "" ;
      AV25TFAplIIGGTopeCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFAplIIGGTopeFij = DecimalUtil.ZERO ;
      AV27TFAplIIGGTopeFij_To = DecimalUtil.ZERO ;
      AV29TFAplIIGGExenCon = "" ;
      AV28TFAplIIGGExenCon_SelsJson = "" ;
      AV30TFAplIIGGExenCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFAplIIGGPrrtear_SelsJson = "" ;
      AV64TFAplIIGGPrrtear_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36TFAplIIGGCondicion = "" ;
      AV35TFAplIIGGCondicion_SelsJson = "" ;
      AV37TFAplIIGGCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67TFAplIIGGRelRef = "" ;
      AV66TFAplIIGGRelRef_SelsJson = "" ;
      AV68TFAplIIGGRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65MenuOpcCod = "" ;
      A1113AplIIGGNom = "" ;
      AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor = DecimalUtil.ZERO ;
      AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to = DecimalUtil.ZERO ;
      AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij = DecimalUtil.ZERO ;
      AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to = DecimalUtil.ZERO ;
      AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom = "" ;
      lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon = "" ;
      lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon = "" ;
      lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion = "" ;
      lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1117AplIIGGExenCon = "" ;
      A1121AplIIGGPrrtear = "" ;
      A1124AplIIGGCondicion = "" ;
      A2020AplIIGGRelRef = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      P017X2_A3CliCod = new int[1] ;
      P017X2_A1113AplIIGGNom = new String[] {""} ;
      P017X2_A2020AplIIGGRelRef = new String[] {""} ;
      P017X2_A1124AplIIGGCondicion = new String[] {""} ;
      P017X2_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017X2_A1121AplIIGGPrrtear = new String[] {""} ;
      P017X2_A1117AplIIGGExenCon = new String[] {""} ;
      P017X2_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017X2_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X2_A1111AplIIGGTopeCon = new String[] {""} ;
      P017X2_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017X2_A1115AplIIGGTopeTip = new byte[1] ;
      P017X2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X2_A1120AplIIGGTrat = new byte[1] ;
      P017X2_A1112AplIIGG = new short[1] ;
      AV39Option = "" ;
      P017X3_A3CliCod = new int[1] ;
      P017X3_A1111AplIIGGTopeCon = new String[] {""} ;
      P017X3_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017X3_A2020AplIIGGRelRef = new String[] {""} ;
      P017X3_A1124AplIIGGCondicion = new String[] {""} ;
      P017X3_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017X3_A1121AplIIGGPrrtear = new String[] {""} ;
      P017X3_A1117AplIIGGExenCon = new String[] {""} ;
      P017X3_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017X3_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X3_A1115AplIIGGTopeTip = new byte[1] ;
      P017X3_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X3_A1120AplIIGGTrat = new byte[1] ;
      P017X3_A1113AplIIGGNom = new String[] {""} ;
      P017X3_A1112AplIIGG = new short[1] ;
      P017X4_A3CliCod = new int[1] ;
      P017X4_A1117AplIIGGExenCon = new String[] {""} ;
      P017X4_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017X4_A2020AplIIGGRelRef = new String[] {""} ;
      P017X4_A1124AplIIGGCondicion = new String[] {""} ;
      P017X4_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017X4_A1121AplIIGGPrrtear = new String[] {""} ;
      P017X4_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X4_A1111AplIIGGTopeCon = new String[] {""} ;
      P017X4_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017X4_A1115AplIIGGTopeTip = new byte[1] ;
      P017X4_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X4_A1120AplIIGGTrat = new byte[1] ;
      P017X4_A1113AplIIGGNom = new String[] {""} ;
      P017X4_A1112AplIIGG = new short[1] ;
      P017X5_A3CliCod = new int[1] ;
      P017X5_A1124AplIIGGCondicion = new String[] {""} ;
      P017X5_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017X5_A2020AplIIGGRelRef = new String[] {""} ;
      P017X5_A1121AplIIGGPrrtear = new String[] {""} ;
      P017X5_A1117AplIIGGExenCon = new String[] {""} ;
      P017X5_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017X5_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X5_A1111AplIIGGTopeCon = new String[] {""} ;
      P017X5_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017X5_A1115AplIIGGTopeTip = new byte[1] ;
      P017X5_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X5_A1120AplIIGGTrat = new byte[1] ;
      P017X5_A1113AplIIGGNom = new String[] {""} ;
      P017X5_A1112AplIIGG = new short[1] ;
      P017X6_A3CliCod = new int[1] ;
      P017X6_A2020AplIIGGRelRef = new String[] {""} ;
      P017X6_A1124AplIIGGCondicion = new String[] {""} ;
      P017X6_n1124AplIIGGCondicion = new boolean[] {false} ;
      P017X6_A1121AplIIGGPrrtear = new String[] {""} ;
      P017X6_A1117AplIIGGExenCon = new String[] {""} ;
      P017X6_n1117AplIIGGExenCon = new boolean[] {false} ;
      P017X6_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X6_A1111AplIIGGTopeCon = new String[] {""} ;
      P017X6_n1111AplIIGGTopeCon = new boolean[] {false} ;
      P017X6_A1115AplIIGGTopeTip = new byte[1] ;
      P017X6_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017X6_A1120AplIIGGTrat = new byte[1] ;
      P017X6_A1113AplIIGGNom = new String[] {""} ;
      P017X6_A1112AplIIGG = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_aplicacion_gananciaswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P017X2_A3CliCod, P017X2_A1113AplIIGGNom, P017X2_A2020AplIIGGRelRef, P017X2_A1124AplIIGGCondicion, P017X2_n1124AplIIGGCondicion, P017X2_A1121AplIIGGPrrtear, P017X2_A1117AplIIGGExenCon, P017X2_n1117AplIIGGExenCon, P017X2_A1119AplIIGGTopeFij, P017X2_A1111AplIIGGTopeCon,
            P017X2_n1111AplIIGGTopeCon, P017X2_A1115AplIIGGTopeTip, P017X2_A1114AplIIGGPropor, P017X2_A1120AplIIGGTrat, P017X2_A1112AplIIGG
            }
            , new Object[] {
            P017X3_A3CliCod, P017X3_A1111AplIIGGTopeCon, P017X3_n1111AplIIGGTopeCon, P017X3_A2020AplIIGGRelRef, P017X3_A1124AplIIGGCondicion, P017X3_n1124AplIIGGCondicion, P017X3_A1121AplIIGGPrrtear, P017X3_A1117AplIIGGExenCon, P017X3_n1117AplIIGGExenCon, P017X3_A1119AplIIGGTopeFij,
            P017X3_A1115AplIIGGTopeTip, P017X3_A1114AplIIGGPropor, P017X3_A1120AplIIGGTrat, P017X3_A1113AplIIGGNom, P017X3_A1112AplIIGG
            }
            , new Object[] {
            P017X4_A3CliCod, P017X4_A1117AplIIGGExenCon, P017X4_n1117AplIIGGExenCon, P017X4_A2020AplIIGGRelRef, P017X4_A1124AplIIGGCondicion, P017X4_n1124AplIIGGCondicion, P017X4_A1121AplIIGGPrrtear, P017X4_A1119AplIIGGTopeFij, P017X4_A1111AplIIGGTopeCon, P017X4_n1111AplIIGGTopeCon,
            P017X4_A1115AplIIGGTopeTip, P017X4_A1114AplIIGGPropor, P017X4_A1120AplIIGGTrat, P017X4_A1113AplIIGGNom, P017X4_A1112AplIIGG
            }
            , new Object[] {
            P017X5_A3CliCod, P017X5_A1124AplIIGGCondicion, P017X5_n1124AplIIGGCondicion, P017X5_A2020AplIIGGRelRef, P017X5_A1121AplIIGGPrrtear, P017X5_A1117AplIIGGExenCon, P017X5_n1117AplIIGGExenCon, P017X5_A1119AplIIGGTopeFij, P017X5_A1111AplIIGGTopeCon, P017X5_n1111AplIIGGTopeCon,
            P017X5_A1115AplIIGGTopeTip, P017X5_A1114AplIIGGPropor, P017X5_A1120AplIIGGTrat, P017X5_A1113AplIIGGNom, P017X5_A1112AplIIGG
            }
            , new Object[] {
            P017X6_A3CliCod, P017X6_A2020AplIIGGRelRef, P017X6_A1124AplIIGGCondicion, P017X6_n1124AplIIGGCondicion, P017X6_A1121AplIIGGPrrtear, P017X6_A1117AplIIGGExenCon, P017X6_n1117AplIIGGExenCon, P017X6_A1119AplIIGGTopeFij, P017X6_A1111AplIIGGTopeCon, P017X6_n1111AplIIGGTopeCon,
            P017X6_A1115AplIIGGTopeTip, P017X6_A1114AplIIGGPropor, P017X6_A1120AplIIGGTrat, P017X6_A1113AplIIGGNom, P017X6_A1112AplIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1120AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private short AV57EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV59TFAplIIGG ;
   private short AV60TFAplIIGG_To ;
   private short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ;
   private short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV58CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV71GXV1 ;
   private int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ;
   private int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ;
   private int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ;
   private int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ;
   private int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ;
   private int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ;
   private int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ;
   private int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ;
   private int A3CliCod ;
   private long AV44count ;
   private java.math.BigDecimal AV16TFAplIIGGPropor ;
   private java.math.BigDecimal AV17TFAplIIGGPropor_To ;
   private java.math.BigDecimal AV26TFAplIIGGTopeFij ;
   private java.math.BigDecimal AV27TFAplIIGGTopeFij_To ;
   private java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ;
   private java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ;
   private java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ;
   private java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private String AV24TFAplIIGGTopeCon ;
   private String AV29TFAplIIGGExenCon ;
   private String AV36TFAplIIGGCondicion ;
   private String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String scmdbuf ;
   private String lV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ;
   private String lV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ;
   private String lV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ;
   private String A1111AplIIGGTopeCon ;
   private String A1117AplIIGGExenCon ;
   private String A1121AplIIGGPrrtear ;
   private String A1124AplIIGGCondicion ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk17X2 ;
   private boolean n1124AplIIGGCondicion ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean brk17X4 ;
   private boolean brk17X6 ;
   private boolean brk17X8 ;
   private boolean brk17X10 ;
   private String AV53OptionsJson ;
   private String AV54OptionsDescJson ;
   private String AV55OptionIndexesJson ;
   private String AV11TFAplIIGGNom_SelsJson ;
   private String AV14TFAplIIGGTrat_SelsJson ;
   private String AV18TFAplIIGGTopeTip_SelsJson ;
   private String AV23TFAplIIGGTopeCon_SelsJson ;
   private String AV28TFAplIIGGExenCon_SelsJson ;
   private String AV63TFAplIIGGPrrtear_SelsJson ;
   private String AV35TFAplIIGGCondicion_SelsJson ;
   private String AV66TFAplIIGGRelRef_SelsJson ;
   private String AV50DDOName ;
   private String AV51SearchTxt ;
   private String AV52SearchTxtTo ;
   private String AV12TFAplIIGGNom ;
   private String AV67TFAplIIGGRelRef ;
   private String AV65MenuOpcCod ;
   private String A1113AplIIGGNom ;
   private String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String lV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ;
   private String lV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ;
   private String A2020AplIIGGRelRef ;
   private String AV39Option ;
   private GXSimpleCollection<Byte> AV15TFAplIIGGTrat_Sels ;
   private GXSimpleCollection<Byte> AV19TFAplIIGGTopeTip_Sels ;
   private GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ;
   private GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ;
   private com.genexus.webpanels.WebSession AV45Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P017X2_A3CliCod ;
   private String[] P017X2_A1113AplIIGGNom ;
   private String[] P017X2_A2020AplIIGGRelRef ;
   private String[] P017X2_A1124AplIIGGCondicion ;
   private boolean[] P017X2_n1124AplIIGGCondicion ;
   private String[] P017X2_A1121AplIIGGPrrtear ;
   private String[] P017X2_A1117AplIIGGExenCon ;
   private boolean[] P017X2_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] P017X2_A1119AplIIGGTopeFij ;
   private String[] P017X2_A1111AplIIGGTopeCon ;
   private boolean[] P017X2_n1111AplIIGGTopeCon ;
   private byte[] P017X2_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P017X2_A1114AplIIGGPropor ;
   private byte[] P017X2_A1120AplIIGGTrat ;
   private short[] P017X2_A1112AplIIGG ;
   private int[] P017X3_A3CliCod ;
   private String[] P017X3_A1111AplIIGGTopeCon ;
   private boolean[] P017X3_n1111AplIIGGTopeCon ;
   private String[] P017X3_A2020AplIIGGRelRef ;
   private String[] P017X3_A1124AplIIGGCondicion ;
   private boolean[] P017X3_n1124AplIIGGCondicion ;
   private String[] P017X3_A1121AplIIGGPrrtear ;
   private String[] P017X3_A1117AplIIGGExenCon ;
   private boolean[] P017X3_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] P017X3_A1119AplIIGGTopeFij ;
   private byte[] P017X3_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P017X3_A1114AplIIGGPropor ;
   private byte[] P017X3_A1120AplIIGGTrat ;
   private String[] P017X3_A1113AplIIGGNom ;
   private short[] P017X3_A1112AplIIGG ;
   private int[] P017X4_A3CliCod ;
   private String[] P017X4_A1117AplIIGGExenCon ;
   private boolean[] P017X4_n1117AplIIGGExenCon ;
   private String[] P017X4_A2020AplIIGGRelRef ;
   private String[] P017X4_A1124AplIIGGCondicion ;
   private boolean[] P017X4_n1124AplIIGGCondicion ;
   private String[] P017X4_A1121AplIIGGPrrtear ;
   private java.math.BigDecimal[] P017X4_A1119AplIIGGTopeFij ;
   private String[] P017X4_A1111AplIIGGTopeCon ;
   private boolean[] P017X4_n1111AplIIGGTopeCon ;
   private byte[] P017X4_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P017X4_A1114AplIIGGPropor ;
   private byte[] P017X4_A1120AplIIGGTrat ;
   private String[] P017X4_A1113AplIIGGNom ;
   private short[] P017X4_A1112AplIIGG ;
   private int[] P017X5_A3CliCod ;
   private String[] P017X5_A1124AplIIGGCondicion ;
   private boolean[] P017X5_n1124AplIIGGCondicion ;
   private String[] P017X5_A2020AplIIGGRelRef ;
   private String[] P017X5_A1121AplIIGGPrrtear ;
   private String[] P017X5_A1117AplIIGGExenCon ;
   private boolean[] P017X5_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] P017X5_A1119AplIIGGTopeFij ;
   private String[] P017X5_A1111AplIIGGTopeCon ;
   private boolean[] P017X5_n1111AplIIGGTopeCon ;
   private byte[] P017X5_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P017X5_A1114AplIIGGPropor ;
   private byte[] P017X5_A1120AplIIGGTrat ;
   private String[] P017X5_A1113AplIIGGNom ;
   private short[] P017X5_A1112AplIIGG ;
   private int[] P017X6_A3CliCod ;
   private String[] P017X6_A2020AplIIGGRelRef ;
   private String[] P017X6_A1124AplIIGGCondicion ;
   private boolean[] P017X6_n1124AplIIGGCondicion ;
   private String[] P017X6_A1121AplIIGGPrrtear ;
   private String[] P017X6_A1117AplIIGGExenCon ;
   private boolean[] P017X6_n1117AplIIGGExenCon ;
   private java.math.BigDecimal[] P017X6_A1119AplIIGGTopeFij ;
   private String[] P017X6_A1111AplIIGGTopeCon ;
   private boolean[] P017X6_n1111AplIIGGTopeCon ;
   private byte[] P017X6_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] P017X6_A1114AplIIGGPropor ;
   private byte[] P017X6_A1120AplIIGGTrat ;
   private String[] P017X6_A1113AplIIGGNom ;
   private short[] P017X6_A1112AplIIGG ;
   private GXSimpleCollection<String> AV25TFAplIIGGTopeCon_Sels ;
   private GXSimpleCollection<String> AV30TFAplIIGGExenCon_Sels ;
   private GXSimpleCollection<String> AV64TFAplIIGGPrrtear_Sels ;
   private GXSimpleCollection<String> AV37TFAplIIGGCondicion_Sels ;
   private GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ;
   private GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ;
   private GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ;
   private GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ;
   private GXSimpleCollection<String> AV40Options ;
   private GXSimpleCollection<String> AV42OptionsDesc ;
   private GXSimpleCollection<String> AV43OptionIndexes ;
   private GXSimpleCollection<String> AV13TFAplIIGGNom_Sels ;
   private GXSimpleCollection<String> AV68TFAplIIGGRelRef_Sels ;
   private GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ;
   private GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV47GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV48GridStateFilterValue ;
}

final  class tipo_aplicacion_gananciaswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P017X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          int A3CliCod ,
                                          int AV58CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGNom, AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat," ;
      scmdbuf += " AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AplIIGGNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P017X3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          int AV58CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[12];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGTopeCon, AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      scmdbuf += " AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, AplIIGGTopeCon" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P017X4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          int AV58CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[12];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGExenCon, AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      scmdbuf += " AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, AplIIGGExenCon" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P017X5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          int AV58CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[12];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGCondicion, AplIIGGRelRef, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      scmdbuf += " AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, AplIIGGCondicion" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P017X6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1113AplIIGGNom ,
                                          GXSimpleCollection<String> AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels ,
                                          byte A1120AplIIGGTrat ,
                                          GXSimpleCollection<Byte> AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels ,
                                          byte A1115AplIIGGTopeTip ,
                                          GXSimpleCollection<Byte> AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels ,
                                          String A1111AplIIGGTopeCon ,
                                          GXSimpleCollection<String> AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels ,
                                          String A1117AplIIGGExenCon ,
                                          GXSimpleCollection<String> AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels ,
                                          String A1121AplIIGGPrrtear ,
                                          GXSimpleCollection<String> AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels ,
                                          String A1124AplIIGGCondicion ,
                                          GXSimpleCollection<String> AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels ,
                                          String A2020AplIIGGRelRef ,
                                          GXSimpleCollection<String> AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels ,
                                          short AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg ,
                                          short AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to ,
                                          int AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size ,
                                          String AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom ,
                                          int AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size ,
                                          java.math.BigDecimal AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor ,
                                          java.math.BigDecimal AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to ,
                                          int AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size ,
                                          int AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size ,
                                          String AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon ,
                                          java.math.BigDecimal AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij ,
                                          java.math.BigDecimal AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to ,
                                          int AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size ,
                                          String AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon ,
                                          int AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size ,
                                          int AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size ,
                                          String AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion ,
                                          int AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size ,
                                          String AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref ,
                                          short A1112AplIIGG ,
                                          java.math.BigDecimal A1114AplIIGGPropor ,
                                          java.math.BigDecimal A1119AplIIGGTopeFij ,
                                          int A3CliCod ,
                                          int AV58CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[12];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT CliCod, AplIIGGRelRef, AplIIGGCondicion, AplIIGGPrrtear, AplIIGGExenCon, AplIIGGTopeFij, AplIIGGTopeCon, AplIIGGTopeTip, AplIIGGPropor, AplIIGGTrat, AplIIGGNom," ;
      scmdbuf += " AplIIGG FROM tipo_aplicacion_ganancias" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV73Tipo_aplicacion_gananciaswwds_1_tfapliigg) )
      {
         addWhere(sWhereString, "(AplIIGG >= ?)");
      }
      else
      {
         GXv_int20[1] = (byte)(1) ;
      }
      if ( ! (0==AV74Tipo_aplicacion_gananciaswwds_2_tfapliigg_to) )
      {
         addWhere(sWhereString, "(AplIIGG <= ?)");
      }
      else
      {
         GXv_int20[2] = (byte)(1) ;
      }
      if ( ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Tipo_aplicacion_gananciaswwds_3_tfapliiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Tipo_aplicacion_gananciaswwds_4_tfapliiggnom_sels, "AplIIGGNom IN (", ")")+")");
      }
      if ( AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV77Tipo_aplicacion_gananciaswwds_5_tfapliiggtrat_sels, "AplIIGGTrat IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Tipo_aplicacion_gananciaswwds_6_tfapliiggpropor)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor >= ?)");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Tipo_aplicacion_gananciaswwds_7_tfapliiggpropor_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGPropor <= ?)");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV80Tipo_aplicacion_gananciaswwds_8_tfapliiggtopetip_sels, "AplIIGGTopeTip IN (", ")")+")");
      }
      if ( ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV81Tipo_aplicacion_gananciaswwds_9_tfapliiggtopecon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGTopeCon) like LOWER(?))");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV82Tipo_aplicacion_gananciaswwds_10_tfapliiggtopecon_sels, "AplIIGGTopeCon IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83Tipo_aplicacion_gananciaswwds_11_tfapliiggtopefij)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij >= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV84Tipo_aplicacion_gananciaswwds_12_tfapliiggtopefij_to)==0) )
      {
         addWhere(sWhereString, "(AplIIGGTopeFij <= ?)");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV85Tipo_aplicacion_gananciaswwds_13_tfapliiggexencon)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGExenCon) like LOWER(?))");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Tipo_aplicacion_gananciaswwds_14_tfapliiggexencon_sels, "AplIIGGExenCon IN (", ")")+")");
      }
      if ( AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV87Tipo_aplicacion_gananciaswwds_15_tfapliiggprrtear_sels, "AplIIGGPrrtear IN (", ")")+")");
      }
      if ( ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV88Tipo_aplicacion_gananciaswwds_16_tfapliiggcondicion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGCondicion) like LOWER(?))");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV89Tipo_aplicacion_gananciaswwds_17_tfapliiggcondicion_sels, "AplIIGGCondicion IN (", ")")+")");
      }
      if ( ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV90Tipo_aplicacion_gananciaswwds_18_tfapliiggrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(AplIIGGRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV91Tipo_aplicacion_gananciaswwds_19_tfapliiggrelref_sels, "AplIIGGRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY AplIIGGRelRef" ;
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
                  return conditional_P017X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
            case 1 :
                  return conditional_P017X3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
            case 2 :
                  return conditional_P017X4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
            case 3 :
                  return conditional_P017X5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
            case 4 :
                  return conditional_P017X6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , (String)dynConstraints[14] , (GXSimpleCollection<String>)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (String)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , ((Number) dynConstraints[28]).intValue() , (String)dynConstraints[29] , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Number) dynConstraints[33]).intValue() , (String)dynConstraints[34] , ((Number) dynConstraints[35]).shortValue() , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , ((Number) dynConstraints[39]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017X3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017X4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017X5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017X6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((String[]) buf[6])[0] = rslt.getString(6, 10);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,4);
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(7,2);
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((byte[]) buf[10])[0] = rslt.getByte(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,4);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
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
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[18], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[22], 20);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 40);
               }
               return;
      }
   }

}

