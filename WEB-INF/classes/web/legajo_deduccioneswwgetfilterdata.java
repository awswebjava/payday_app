package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajo_deduccioneswwgetfilterdata extends GXProcedure
{
   public legajo_deduccioneswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajo_deduccioneswwgetfilterdata.class ), "" );
   }

   public legajo_deduccioneswwgetfilterdata( int remoteHandle ,
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
      legajo_deduccioneswwgetfilterdata.this.aP5 = new String[] {""};
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
      legajo_deduccioneswwgetfilterdata.this.AV31DDOName = aP0;
      legajo_deduccioneswwgetfilterdata.this.AV29SearchTxt = aP1;
      legajo_deduccioneswwgetfilterdata.this.AV30SearchTxtTo = aP2;
      legajo_deduccioneswwgetfilterdata.this.aP3 = aP3;
      legajo_deduccioneswwgetfilterdata.this.aP4 = aP4;
      legajo_deduccioneswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV48EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      legajo_deduccioneswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV48EmpCod = GXt_int1 ;
      GXt_int3 = AV49CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      legajo_deduccioneswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV49CliCod = GXt_int3 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWlegajo_deducciones", GXv_boolean6) ;
      legajo_deduccioneswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LEGIDNOMAPE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LEGDEDCONCODYDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGDEDCONCODYDESCOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LEGDEDDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGDEDDESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV35OptionsJson = AV34Options.toJSonString(false) ;
      AV38OptionsDescJson = AV37OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV39OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV42Session.getValue("legajo_deduccionesWWGridState"), "") == 0 )
      {
         AV44GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "legajo_deduccionesWWGridState"), null, null);
      }
      else
      {
         AV44GridState.fromxml(AV42Session.getValue("legajo_deduccionesWWGridState"), null, null);
      }
      AV68GXV1 = 1 ;
      while ( AV68GXV1 <= AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV45GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV68GXV1));
         if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE") == 0 )
         {
            AV51TFLegIdNomApe = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGIDNOMAPE_SEL") == 0 )
         {
            AV50TFLegIdNomApe_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFLegIdNomApe_Sels.fromJSonString(AV50TFLegIdNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDANIO") == 0 )
         {
            AV61TFLegDedAnio = (short)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV62TFLegDedAnio_To = (short)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDMES_SEL") == 0 )
         {
            AV63TFLegDedMes_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV64TFLegDedMes_Sels.fromJSonString(AV63TFLegDedMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC") == 0 )
         {
            AV59TFLegDedConCodYDesc = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDCONCODYDESC_SEL") == 0 )
         {
            AV58TFLegDedConCodYDesc_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFLegDedConCodYDesc_Sels.fromJSonString(AV58TFLegDedConCodYDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP") == 0 )
         {
            AV54TFLegDedDescrip = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDDESCRIP_SEL") == 0 )
         {
            AV53TFLegDedDescrip_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFLegDedDescrip_Sels.fromJSonString(AV53TFLegDedDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGDEDIMPORTE") == 0 )
         {
            AV56TFLegDedImporte = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV57TFLegDedImporte_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV65MenuOpcCod = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV68GXV1 = (int)(AV68GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV51TFLegIdNomApe = AV29SearchTxt ;
      AV52TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV70Legajo_deduccioneswwds_1_tflegidnomape = AV51TFLegIdNomApe ;
      AV71Legajo_deduccioneswwds_2_tflegidnomape_sels = AV52TFLegIdNomApe_Sels ;
      AV72Legajo_deduccioneswwds_3_tflegdedanio = AV61TFLegDedAnio ;
      AV73Legajo_deduccioneswwds_4_tflegdedanio_to = AV62TFLegDedAnio_To ;
      AV74Legajo_deduccioneswwds_5_tflegdedmes_sels = AV64TFLegDedMes_Sels ;
      AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV59TFLegDedConCodYDesc ;
      AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV60TFLegDedConCodYDesc_Sels ;
      AV77Legajo_deduccioneswwds_8_tflegdeddescrip = AV54TFLegDedDescrip ;
      AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV55TFLegDedDescrip_Sels ;
      AV79Legajo_deduccioneswwds_10_tflegdedimporte = AV56TFLegDedImporte ;
      AV80Legajo_deduccioneswwds_11_tflegdedimporte_to = AV57TFLegDedImporte_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV71Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV74Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV70Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV70Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV77Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV77Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor P006R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV49CliCod), Short.valueOf(AV48EmpCod), Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV70Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to), lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV77Legajo_deduccioneswwds_8_tflegdeddescrip, AV79Legajo_deduccioneswwds_10_tflegdedimporte, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6R2 = false ;
         A6LegNumero = P006R2_A6LegNumero[0] ;
         A1EmpCod = P006R2_A1EmpCod[0] ;
         A3CliCod = P006R2_A3CliCod[0] ;
         A560LegDedImporte = P006R2_A560LegDedImporte[0] ;
         A568LegDedDescrip = P006R2_A568LegDedDescrip[0] ;
         A570LegDedConCodYDesc = P006R2_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P006R2_A767LegDedMes[0] ;
         A768LegDedAnio = P006R2_A768LegDedAnio[0] ;
         A250LegIdNomApe = P006R2_A250LegIdNomApe[0] ;
         A84LegDedConCodigo = P006R2_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P006R2_A559LegDedConDescrip[0] ;
         A83LegDedSec = P006R2_A83LegDedSec[0] ;
         A250LegIdNomApe = P006R2_A250LegIdNomApe[0] ;
         A559LegDedConDescrip = P006R2_A559LegDedConDescrip[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006R2_A3CliCod[0] == A3CliCod ) && ( P006R2_A1EmpCod[0] == A1EmpCod ) && ( P006R2_A6LegNumero[0] == A6LegNumero ) )
         {
            brk6R2 = false ;
            A83LegDedSec = P006R2_A83LegDedSec[0] ;
            AV41count = (long)(AV41count+1) ;
            brk6R2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A250LegIdNomApe)==0) )
         {
            AV33Option = A250LegIdNomApe ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            AV34Options.add(AV33Option, AV32InsertIndex);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6R2 )
         {
            brk6R2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGDEDCONCODYDESCOPTIONS' Routine */
      returnInSub = false ;
      AV59TFLegDedConCodYDesc = AV29SearchTxt ;
      AV60TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV70Legajo_deduccioneswwds_1_tflegidnomape = AV51TFLegIdNomApe ;
      AV71Legajo_deduccioneswwds_2_tflegidnomape_sels = AV52TFLegIdNomApe_Sels ;
      AV72Legajo_deduccioneswwds_3_tflegdedanio = AV61TFLegDedAnio ;
      AV73Legajo_deduccioneswwds_4_tflegdedanio_to = AV62TFLegDedAnio_To ;
      AV74Legajo_deduccioneswwds_5_tflegdedmes_sels = AV64TFLegDedMes_Sels ;
      AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV59TFLegDedConCodYDesc ;
      AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV60TFLegDedConCodYDesc_Sels ;
      AV77Legajo_deduccioneswwds_8_tflegdeddescrip = AV54TFLegDedDescrip ;
      AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV55TFLegDedDescrip_Sels ;
      AV79Legajo_deduccioneswwds_10_tflegdedimporte = AV56TFLegDedImporte ;
      AV80Legajo_deduccioneswwds_11_tflegdedimporte_to = AV57TFLegDedImporte_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV71Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV74Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV70Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV70Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV77Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV77Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor P006R3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV49CliCod), Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), Short.valueOf(AV48EmpCod), lV70Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to), lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV77Legajo_deduccioneswwds_8_tflegdeddescrip, AV79Legajo_deduccioneswwds_10_tflegdedimporte, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6R4 = false ;
         A6LegNumero = P006R3_A6LegNumero[0] ;
         A3CliCod = P006R3_A3CliCod[0] ;
         A1EmpCod = P006R3_A1EmpCod[0] ;
         A560LegDedImporte = P006R3_A560LegDedImporte[0] ;
         A568LegDedDescrip = P006R3_A568LegDedDescrip[0] ;
         A570LegDedConCodYDesc = P006R3_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P006R3_A767LegDedMes[0] ;
         A768LegDedAnio = P006R3_A768LegDedAnio[0] ;
         A250LegIdNomApe = P006R3_A250LegIdNomApe[0] ;
         A84LegDedConCodigo = P006R3_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P006R3_A559LegDedConDescrip[0] ;
         A83LegDedSec = P006R3_A83LegDedSec[0] ;
         A250LegIdNomApe = P006R3_A250LegIdNomApe[0] ;
         A559LegDedConDescrip = P006R3_A559LegDedConDescrip[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006R3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006R3_A84LegDedConCodigo[0], A84LegDedConCodigo) == 0 ) )
         {
            brk6R4 = false ;
            A6LegNumero = P006R3_A6LegNumero[0] ;
            A1EmpCod = P006R3_A1EmpCod[0] ;
            A83LegDedSec = P006R3_A83LegDedSec[0] ;
            AV41count = (long)(AV41count+1) ;
            brk6R4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A570LegDedConCodYDesc)==0) )
         {
            AV33Option = A570LegDedConCodYDesc ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV34Options.elementAt(-1+AV32InsertIndex), AV33Option) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            AV34Options.add(AV33Option, AV32InsertIndex);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6R4 )
         {
            brk6R4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLEGDEDDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV54TFLegDedDescrip = AV29SearchTxt ;
      AV55TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV70Legajo_deduccioneswwds_1_tflegidnomape = AV51TFLegIdNomApe ;
      AV71Legajo_deduccioneswwds_2_tflegidnomape_sels = AV52TFLegIdNomApe_Sels ;
      AV72Legajo_deduccioneswwds_3_tflegdedanio = AV61TFLegDedAnio ;
      AV73Legajo_deduccioneswwds_4_tflegdedanio_to = AV62TFLegDedAnio_To ;
      AV74Legajo_deduccioneswwds_5_tflegdedmes_sels = AV64TFLegDedMes_Sels ;
      AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = AV59TFLegDedConCodYDesc ;
      AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = AV60TFLegDedConCodYDesc_Sels ;
      AV77Legajo_deduccioneswwds_8_tflegdeddescrip = AV54TFLegDedDescrip ;
      AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels = AV55TFLegDedDescrip_Sels ;
      AV79Legajo_deduccioneswwds_10_tflegdedimporte = AV56TFLegDedImporte ;
      AV80Legajo_deduccioneswwds_11_tflegdedimporte_to = AV57TFLegDedImporte_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A570LegDedConCodYDesc ,
                                           AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                           A250LegIdNomApe ,
                                           AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                           Byte.valueOf(A767LegDedMes) ,
                                           AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                           A568LegDedDescrip ,
                                           AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                           Integer.valueOf(AV71Legajo_deduccioneswwds_2_tflegidnomape_sels.size()) ,
                                           AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                           Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio) ,
                                           Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to) ,
                                           Integer.valueOf(AV74Legajo_deduccioneswwds_5_tflegdedmes_sels.size()) ,
                                           Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()) ,
                                           AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                           Integer.valueOf(AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels.size()) ,
                                           AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                           AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                           AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           A84LegDedConCodigo ,
                                           A559LegDedConDescrip ,
                                           A560LegDedImporte ,
                                           Integer.valueOf(AV49CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV70Legajo_deduccioneswwds_1_tflegidnomape = GXutil.concat( GXutil.rtrim( AV70Legajo_deduccioneswwds_1_tflegidnomape), "%", "") ;
      lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = GXutil.concat( GXutil.rtrim( AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc), "%", "") ;
      lV77Legajo_deduccioneswwds_8_tflegdeddescrip = GXutil.concat( GXutil.rtrim( AV77Legajo_deduccioneswwds_8_tflegdeddescrip), "%", "") ;
      /* Using cursor P006R4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV49CliCod), Short.valueOf(AV48EmpCod), Integer.valueOf(AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels.size()), lV70Legajo_deduccioneswwds_1_tflegidnomape, Short.valueOf(AV72Legajo_deduccioneswwds_3_tflegdedanio), Short.valueOf(AV73Legajo_deduccioneswwds_4_tflegdedanio_to), lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc, lV77Legajo_deduccioneswwds_8_tflegdeddescrip, AV79Legajo_deduccioneswwds_10_tflegdedimporte, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6R6 = false ;
         A6LegNumero = P006R4_A6LegNumero[0] ;
         A1EmpCod = P006R4_A1EmpCod[0] ;
         A3CliCod = P006R4_A3CliCod[0] ;
         A568LegDedDescrip = P006R4_A568LegDedDescrip[0] ;
         A560LegDedImporte = P006R4_A560LegDedImporte[0] ;
         A570LegDedConCodYDesc = P006R4_A570LegDedConCodYDesc[0] ;
         A767LegDedMes = P006R4_A767LegDedMes[0] ;
         A768LegDedAnio = P006R4_A768LegDedAnio[0] ;
         A250LegIdNomApe = P006R4_A250LegIdNomApe[0] ;
         A84LegDedConCodigo = P006R4_A84LegDedConCodigo[0] ;
         A559LegDedConDescrip = P006R4_A559LegDedConDescrip[0] ;
         A83LegDedSec = P006R4_A83LegDedSec[0] ;
         A250LegIdNomApe = P006R4_A250LegIdNomApe[0] ;
         A559LegDedConDescrip = P006R4_A559LegDedConDescrip[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P006R4_A3CliCod[0] == A3CliCod ) && ( P006R4_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P006R4_A568LegDedDescrip[0], A568LegDedDescrip) == 0 ) )
         {
            brk6R6 = false ;
            A6LegNumero = P006R4_A6LegNumero[0] ;
            A83LegDedSec = P006R4_A83LegDedSec[0] ;
            AV41count = (long)(AV41count+1) ;
            brk6R6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A568LegDedDescrip)==0) )
         {
            AV33Option = A568LegDedDescrip ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6R6 )
         {
            brk6R6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajo_deduccioneswwgetfilterdata.this.AV35OptionsJson;
      this.aP4[0] = legajo_deduccioneswwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = legajo_deduccioneswwgetfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Session = httpContext.getWebSession();
      AV44GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV51TFLegIdNomApe = "" ;
      AV50TFLegIdNomApe_SelsJson = "" ;
      AV52TFLegIdNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFLegDedMes_SelsJson = "" ;
      AV64TFLegDedMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV59TFLegDedConCodYDesc = "" ;
      AV58TFLegDedConCodYDesc_SelsJson = "" ;
      AV60TFLegDedConCodYDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54TFLegDedDescrip = "" ;
      AV53TFLegDedDescrip_SelsJson = "" ;
      AV55TFLegDedDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56TFLegDedImporte = DecimalUtil.ZERO ;
      AV57TFLegDedImporte_To = DecimalUtil.ZERO ;
      AV65MenuOpcCod = "" ;
      A250LegIdNomApe = "" ;
      AV70Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      AV71Legajo_deduccioneswwds_2_tflegidnomape_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV74Legajo_deduccioneswwds_5_tflegdedmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV79Legajo_deduccioneswwds_10_tflegdedimporte = DecimalUtil.ZERO ;
      AV80Legajo_deduccioneswwds_11_tflegdedimporte_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV70Legajo_deduccioneswwds_1_tflegidnomape = "" ;
      lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc = "" ;
      lV77Legajo_deduccioneswwds_8_tflegdeddescrip = "" ;
      A570LegDedConCodYDesc = "" ;
      A568LegDedDescrip = "" ;
      A84LegDedConCodigo = "" ;
      A559LegDedConDescrip = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      P006R2_A6LegNumero = new int[1] ;
      P006R2_A1EmpCod = new short[1] ;
      P006R2_A3CliCod = new int[1] ;
      P006R2_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006R2_A568LegDedDescrip = new String[] {""} ;
      P006R2_A570LegDedConCodYDesc = new String[] {""} ;
      P006R2_A767LegDedMes = new byte[1] ;
      P006R2_A768LegDedAnio = new short[1] ;
      P006R2_A250LegIdNomApe = new String[] {""} ;
      P006R2_A84LegDedConCodigo = new String[] {""} ;
      P006R2_A559LegDedConDescrip = new String[] {""} ;
      P006R2_A83LegDedSec = new int[1] ;
      AV33Option = "" ;
      P006R3_A6LegNumero = new int[1] ;
      P006R3_A3CliCod = new int[1] ;
      P006R3_A1EmpCod = new short[1] ;
      P006R3_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006R3_A568LegDedDescrip = new String[] {""} ;
      P006R3_A570LegDedConCodYDesc = new String[] {""} ;
      P006R3_A767LegDedMes = new byte[1] ;
      P006R3_A768LegDedAnio = new short[1] ;
      P006R3_A250LegIdNomApe = new String[] {""} ;
      P006R3_A84LegDedConCodigo = new String[] {""} ;
      P006R3_A559LegDedConDescrip = new String[] {""} ;
      P006R3_A83LegDedSec = new int[1] ;
      P006R4_A6LegNumero = new int[1] ;
      P006R4_A1EmpCod = new short[1] ;
      P006R4_A3CliCod = new int[1] ;
      P006R4_A568LegDedDescrip = new String[] {""} ;
      P006R4_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006R4_A570LegDedConCodYDesc = new String[] {""} ;
      P006R4_A767LegDedMes = new byte[1] ;
      P006R4_A768LegDedAnio = new short[1] ;
      P006R4_A250LegIdNomApe = new String[] {""} ;
      P006R4_A84LegDedConCodigo = new String[] {""} ;
      P006R4_A559LegDedConDescrip = new String[] {""} ;
      P006R4_A83LegDedSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajo_deduccioneswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006R2_A6LegNumero, P006R2_A1EmpCod, P006R2_A3CliCod, P006R2_A560LegDedImporte, P006R2_A568LegDedDescrip, P006R2_A570LegDedConCodYDesc, P006R2_A767LegDedMes, P006R2_A768LegDedAnio, P006R2_A250LegIdNomApe, P006R2_A84LegDedConCodigo,
            P006R2_A559LegDedConDescrip, P006R2_A83LegDedSec
            }
            , new Object[] {
            P006R3_A6LegNumero, P006R3_A3CliCod, P006R3_A1EmpCod, P006R3_A560LegDedImporte, P006R3_A568LegDedDescrip, P006R3_A570LegDedConCodYDesc, P006R3_A767LegDedMes, P006R3_A768LegDedAnio, P006R3_A250LegIdNomApe, P006R3_A84LegDedConCodigo,
            P006R3_A559LegDedConDescrip, P006R3_A83LegDedSec
            }
            , new Object[] {
            P006R4_A6LegNumero, P006R4_A1EmpCod, P006R4_A3CliCod, P006R4_A568LegDedDescrip, P006R4_A560LegDedImporte, P006R4_A570LegDedConCodYDesc, P006R4_A767LegDedMes, P006R4_A768LegDedAnio, P006R4_A250LegIdNomApe, P006R4_A84LegDedConCodigo,
            P006R4_A559LegDedConDescrip, P006R4_A83LegDedSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A767LegDedMes ;
   private short AV48EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV61TFLegDedAnio ;
   private short AV62TFLegDedAnio_To ;
   private short AV72Legajo_deduccioneswwds_3_tflegdedanio ;
   private short AV73Legajo_deduccioneswwds_4_tflegdedanio_to ;
   private short A768LegDedAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV68GXV1 ;
   private int AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size ;
   private int AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size ;
   private int AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ;
   private int AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A83LegDedSec ;
   private int AV32InsertIndex ;
   private long AV41count ;
   private java.math.BigDecimal AV56TFLegDedImporte ;
   private java.math.BigDecimal AV57TFLegDedImporte_To ;
   private java.math.BigDecimal AV79Legajo_deduccioneswwds_10_tflegdedimporte ;
   private java.math.BigDecimal AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String scmdbuf ;
   private String A84LegDedConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6R2 ;
   private boolean brk6R4 ;
   private boolean brk6R6 ;
   private String AV35OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV50TFLegIdNomApe_SelsJson ;
   private String AV63TFLegDedMes_SelsJson ;
   private String AV58TFLegDedConCodYDesc_SelsJson ;
   private String AV53TFLegDedDescrip_SelsJson ;
   private String AV31DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV51TFLegIdNomApe ;
   private String AV59TFLegDedConCodYDesc ;
   private String AV54TFLegDedDescrip ;
   private String AV65MenuOpcCod ;
   private String A250LegIdNomApe ;
   private String AV70Legajo_deduccioneswwds_1_tflegidnomape ;
   private String AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String AV77Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String lV70Legajo_deduccioneswwds_1_tflegidnomape ;
   private String lV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ;
   private String lV77Legajo_deduccioneswwds_8_tflegdeddescrip ;
   private String A570LegDedConCodYDesc ;
   private String A568LegDedDescrip ;
   private String A559LegDedConDescrip ;
   private String AV33Option ;
   private GXSimpleCollection<Byte> AV64TFLegDedMes_Sels ;
   private GXSimpleCollection<Byte> AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ;
   private com.genexus.webpanels.WebSession AV42Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006R2_A6LegNumero ;
   private short[] P006R2_A1EmpCod ;
   private int[] P006R2_A3CliCod ;
   private java.math.BigDecimal[] P006R2_A560LegDedImporte ;
   private String[] P006R2_A568LegDedDescrip ;
   private String[] P006R2_A570LegDedConCodYDesc ;
   private byte[] P006R2_A767LegDedMes ;
   private short[] P006R2_A768LegDedAnio ;
   private String[] P006R2_A250LegIdNomApe ;
   private String[] P006R2_A84LegDedConCodigo ;
   private String[] P006R2_A559LegDedConDescrip ;
   private int[] P006R2_A83LegDedSec ;
   private int[] P006R3_A6LegNumero ;
   private int[] P006R3_A3CliCod ;
   private short[] P006R3_A1EmpCod ;
   private java.math.BigDecimal[] P006R3_A560LegDedImporte ;
   private String[] P006R3_A568LegDedDescrip ;
   private String[] P006R3_A570LegDedConCodYDesc ;
   private byte[] P006R3_A767LegDedMes ;
   private short[] P006R3_A768LegDedAnio ;
   private String[] P006R3_A250LegIdNomApe ;
   private String[] P006R3_A84LegDedConCodigo ;
   private String[] P006R3_A559LegDedConDescrip ;
   private int[] P006R3_A83LegDedSec ;
   private int[] P006R4_A6LegNumero ;
   private short[] P006R4_A1EmpCod ;
   private int[] P006R4_A3CliCod ;
   private String[] P006R4_A568LegDedDescrip ;
   private java.math.BigDecimal[] P006R4_A560LegDedImporte ;
   private String[] P006R4_A570LegDedConCodYDesc ;
   private byte[] P006R4_A767LegDedMes ;
   private short[] P006R4_A768LegDedAnio ;
   private String[] P006R4_A250LegIdNomApe ;
   private String[] P006R4_A84LegDedConCodigo ;
   private String[] P006R4_A559LegDedConDescrip ;
   private int[] P006R4_A83LegDedSec ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV37OptionsDesc ;
   private GXSimpleCollection<String> AV39OptionIndexes ;
   private GXSimpleCollection<String> AV52TFLegIdNomApe_Sels ;
   private GXSimpleCollection<String> AV60TFLegDedConCodYDesc_Sels ;
   private GXSimpleCollection<String> AV55TFLegDedDescrip_Sels ;
   private GXSimpleCollection<String> AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ;
   private GXSimpleCollection<String> AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ;
   private GXSimpleCollection<String> AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV44GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV45GridStateFilterValue ;
}

final  class legajo_deduccioneswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006R2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV72Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV73Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          int AV49CliCod ,
                                          short AV48EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[10];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T2.LegIdNomApe, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM ((legajo_deducciones T1" ;
      scmdbuf += " INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo" ;
      scmdbuf += " = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV72Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006R3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV72Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV73Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          short A1EmpCod ,
                                          short AV48EmpCod ,
                                          int AV49CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[10];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.CliCod, T1.EmpCod, T1.LegDedImporte, T1.LegDedDescrip, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T2.LegIdNomApe, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM ((legajo_deducciones T1" ;
      scmdbuf += " INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo" ;
      scmdbuf += " = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV72Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.LegDedConCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006R4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A570LegDedConCodYDesc ,
                                          GXSimpleCollection<String> AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels ,
                                          String A250LegIdNomApe ,
                                          GXSimpleCollection<String> AV71Legajo_deduccioneswwds_2_tflegidnomape_sels ,
                                          byte A767LegDedMes ,
                                          GXSimpleCollection<Byte> AV74Legajo_deduccioneswwds_5_tflegdedmes_sels ,
                                          String A568LegDedDescrip ,
                                          GXSimpleCollection<String> AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels ,
                                          int AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size ,
                                          String AV70Legajo_deduccioneswwds_1_tflegidnomape ,
                                          short AV72Legajo_deduccioneswwds_3_tflegdedanio ,
                                          short AV73Legajo_deduccioneswwds_4_tflegdedanio_to ,
                                          int AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size ,
                                          int AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size ,
                                          String AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc ,
                                          int AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size ,
                                          String AV77Legajo_deduccioneswwds_8_tflegdeddescrip ,
                                          java.math.BigDecimal AV79Legajo_deduccioneswwds_10_tflegdedimporte ,
                                          java.math.BigDecimal AV80Legajo_deduccioneswwds_11_tflegdedimporte_to ,
                                          short A768LegDedAnio ,
                                          String A84LegDedConCodigo ,
                                          String A559LegDedConDescrip ,
                                          java.math.BigDecimal A560LegDedImporte ,
                                          int AV49CliCod ,
                                          short AV48EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[10];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LegDedDescrip, T1.LegDedImporte, RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) AS LegDedConCodYDesc," ;
      scmdbuf += " T1.LegDedMes, T1.LegDedAnio, T2.LegIdNomApe, T1.LegDedConCodigo AS LegDedConCodigo, T3.ConDescrip AS LegDedConDescrip, T1.LegDedSec FROM ((legajo_deducciones T1" ;
      scmdbuf += " INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = T1.CliCod AND T3.ConCodigo" ;
      scmdbuf += " = T1.LegDedConCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(? <= 0 or ( "+GXutil.toValueList("postgresql", AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels, "RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip)) IN (", ")")+"))");
      if ( ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Legajo_deduccioneswwds_1_tflegidnomape)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegIdNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV71Legajo_deduccioneswwds_2_tflegidnomape_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Legajo_deduccioneswwds_2_tflegidnomape_sels, "T2.LegIdNomApe IN (", ")")+")");
      }
      if ( ! (0==AV72Legajo_deduccioneswwds_3_tflegdedanio) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (0==AV73Legajo_deduccioneswwds_4_tflegdedanio_to) )
      {
         addWhere(sWhereString, "(T1.LegDedAnio <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV74Legajo_deduccioneswwds_5_tflegdedmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Legajo_deduccioneswwds_5_tflegdedmes_sels, "T1.LegDedMes IN (", ")")+")");
      }
      if ( ( AV76Legajo_deduccioneswwds_7_tflegdedconcodydesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Legajo_deduccioneswwds_6_tflegdedconcodydesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(RTRIM(LTRIM(T1.LegDedConCodigo)) || ' - ' || RTRIM(LTRIM(T3.ConDescrip))) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Legajo_deduccioneswwds_8_tflegdeddescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LegDedDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Legajo_deduccioneswwds_9_tflegdeddescrip_sels, "T1.LegDedDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Legajo_deduccioneswwds_10_tflegdedimporte)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte >= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Legajo_deduccioneswwds_11_tflegdedimporte_to)==0) )
      {
         addWhere(sWhereString, "(T1.LegDedImporte <= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegDedDescrip" ;
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
                  return conditional_P006R2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() );
            case 1 :
                  return conditional_P006R3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() );
            case 2 :
                  return conditional_P006R4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006R2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006R3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006R4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

