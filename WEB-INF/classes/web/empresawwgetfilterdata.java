package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresawwgetfilterdata extends GXProcedure
{
   public empresawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresawwgetfilterdata.class ), "" );
   }

   public empresawwgetfilterdata( int remoteHandle ,
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
      empresawwgetfilterdata.this.aP5 = new String[] {""};
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
      empresawwgetfilterdata.this.AV50DDOName = aP0;
      empresawwgetfilterdata.this.AV48SearchTxt = aP1;
      empresawwgetfilterdata.this.AV49SearchTxtTo = aP2;
      empresawwgetfilterdata.this.aP3 = aP3;
      empresawwgetfilterdata.this.aP4 = aP4;
      empresawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV92EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV92EmpCod = GXt_int1 ;
      GXt_int3 = AV91CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV91CliCod = GXt_int3 ;
      AV53Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa", GXv_boolean6) ;
      empresawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_EMPNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPNOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_ACTDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADACTDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_TIPEMPLEDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPEMPLEDESCRIOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_EMPZONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPZONDESCRIPOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV54OptionsJson = AV53Options.toJSonString(false) ;
      AV57OptionsDescJson = AV56OptionsDesc.toJSonString(false) ;
      AV59OptionIndexesJson = AV58OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV61Session.getValue("EmpresaWWGridState"), "") == 0 )
      {
         AV63GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaWWGridState"), null, null);
      }
      else
      {
         AV63GridState.fromxml(AV61Session.getValue("EmpresaWWGridState"), null, null);
      }
      AV103GXV1 = 1 ;
      while ( AV103GXV1 <= AV63GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV64GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV63GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV103GXV1));
         if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM") == 0 )
         {
            AV12TFEmpNom = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPNOM_SEL") == 0 )
         {
            AV67TFEmpNom_SelsJson = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV68TFEmpNom_Sels.fromJSonString(AV67TFEmpNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUIT") == 0 )
         {
            AV14TFEmpCUIT = GXutil.lval( AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV99TFEmpCUIT_To = GXutil.lval( AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP") == 0 )
         {
            AV40TFActDescrip = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFACTDESCRIP_SEL") == 0 )
         {
            AV85TFActDescrip_SelsJson = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV86TFActDescrip_Sels.fromJSonString(AV85TFActDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI") == 0 )
         {
            AV46TFTipEmpleDescri = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI_SEL") == 0 )
         {
            AV89TFTipEmpleDescri_SelsJson = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV90TFTipEmpleDescri_Sels.fromJSonString(AV89TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP") == 0 )
         {
            AV97TFEmpZonDescrip = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPZONDESCRIP_SEL") == 0 )
         {
            AV96TFEmpZonDescrip_SelsJson = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV98TFEmpZonDescrip_Sels.fromJSonString(AV96TFEmpZonDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV100MenuOpcCod = AV64GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV103GXV1 = (int)(AV103GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPNOMOPTIONS' Routine */
      returnInSub = false ;
      AV12TFEmpNom = AV48SearchTxt ;
      AV68TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV105Empresawwds_1_tfempnom = AV12TFEmpNom ;
      AV106Empresawwds_2_tfempnom_sels = AV68TFEmpNom_Sels ;
      AV107Empresawwds_3_tfempcuit = AV14TFEmpCUIT ;
      AV108Empresawwds_4_tfempcuit_to = AV99TFEmpCUIT_To ;
      AV109Empresawwds_5_tfactdescrip = AV40TFActDescrip ;
      AV110Empresawwds_6_tfactdescrip_sels = AV86TFActDescrip_Sels ;
      AV111Empresawwds_7_tftipempledescri = AV46TFTipEmpleDescri ;
      AV112Empresawwds_8_tftipempledescri_sels = AV90TFTipEmpleDescri_Sels ;
      AV113Empresawwds_9_tfempzondescrip = AV97TFEmpZonDescrip ;
      AV114Empresawwds_10_tfempzondescrip_sels = AV98TFEmpZonDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV106Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV110Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV112Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV114Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV106Empresawwds_2_tfempnom_sels.size()) ,
                                           AV105Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV107Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV108Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV110Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV109Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV112Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV111Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV114Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV113Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Integer.valueOf(AV91CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV105Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV105Empresawwds_1_tfempnom), "%", "") ;
      lV109Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV109Empresawwds_5_tfactdescrip), "%", "") ;
      lV111Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV111Empresawwds_7_tftipempledescri), "%", "") ;
      lV113Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV113Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor P00502 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV91CliCod), lV105Empresawwds_1_tfempnom, Long.valueOf(AV107Empresawwds_3_tfempcuit), Long.valueOf(AV108Empresawwds_4_tfempcuit_to), lV109Empresawwds_5_tfactdescrip, lV111Empresawwds_7_tftipempledescri, lV113Empresawwds_9_tfempzondescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk502 = false ;
         A43ActCodigo = P00502_A43ActCodigo[0] ;
         n43ActCodigo = P00502_n43ActCodigo[0] ;
         A45TipEmpleCod = P00502_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00502_n45TipEmpleCod[0] ;
         A44EmpZonCod = P00502_A44EmpZonCod[0] ;
         n44EmpZonCod = P00502_n44EmpZonCod[0] ;
         A3CliCod = P00502_A3CliCod[0] ;
         A2EmpNom = P00502_A2EmpNom[0] ;
         A518EmpZonDescrip = P00502_A518EmpZonDescrip[0] ;
         A339TipEmpleDescri = P00502_A339TipEmpleDescri[0] ;
         A108ActDescrip = P00502_A108ActDescrip[0] ;
         A177EmpCUIT = P00502_A177EmpCUIT[0] ;
         A1EmpCod = P00502_A1EmpCod[0] ;
         A108ActDescrip = P00502_A108ActDescrip[0] ;
         A339TipEmpleDescri = P00502_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P00502_A518EmpZonDescrip[0] ;
         AV60count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00502_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P00502_A2EmpNom[0], A2EmpNom) == 0 ) )
         {
            brk502 = false ;
            A1EmpCod = P00502_A1EmpCod[0] ;
            AV60count = (long)(AV60count+1) ;
            brk502 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2EmpNom)==0) )
         {
            AV52Option = A2EmpNom ;
            AV53Options.add(AV52Option, 0);
            AV58OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV60count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV53Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk502 )
         {
            brk502 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADACTDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV40TFActDescrip = AV48SearchTxt ;
      AV86TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV105Empresawwds_1_tfempnom = AV12TFEmpNom ;
      AV106Empresawwds_2_tfempnom_sels = AV68TFEmpNom_Sels ;
      AV107Empresawwds_3_tfempcuit = AV14TFEmpCUIT ;
      AV108Empresawwds_4_tfempcuit_to = AV99TFEmpCUIT_To ;
      AV109Empresawwds_5_tfactdescrip = AV40TFActDescrip ;
      AV110Empresawwds_6_tfactdescrip_sels = AV86TFActDescrip_Sels ;
      AV111Empresawwds_7_tftipempledescri = AV46TFTipEmpleDescri ;
      AV112Empresawwds_8_tftipempledescri_sels = AV90TFTipEmpleDescri_Sels ;
      AV113Empresawwds_9_tfempzondescrip = AV97TFEmpZonDescrip ;
      AV114Empresawwds_10_tfempzondescrip_sels = AV98TFEmpZonDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV106Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV110Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV112Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV114Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV106Empresawwds_2_tfempnom_sels.size()) ,
                                           AV105Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV107Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV108Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV110Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV109Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV112Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV111Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV114Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV113Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV91CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV105Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV105Empresawwds_1_tfempnom), "%", "") ;
      lV109Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV109Empresawwds_5_tfactdescrip), "%", "") ;
      lV111Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV111Empresawwds_7_tftipempledescri), "%", "") ;
      lV113Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV113Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor P00503 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV91CliCod), lV105Empresawwds_1_tfempnom, Long.valueOf(AV107Empresawwds_3_tfempcuit), Long.valueOf(AV108Empresawwds_4_tfempcuit_to), lV109Empresawwds_5_tfactdescrip, lV111Empresawwds_7_tftipempledescri, lV113Empresawwds_9_tfempzondescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk504 = false ;
         A45TipEmpleCod = P00503_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00503_n45TipEmpleCod[0] ;
         A44EmpZonCod = P00503_A44EmpZonCod[0] ;
         n44EmpZonCod = P00503_n44EmpZonCod[0] ;
         A43ActCodigo = P00503_A43ActCodigo[0] ;
         n43ActCodigo = P00503_n43ActCodigo[0] ;
         A3CliCod = P00503_A3CliCod[0] ;
         A518EmpZonDescrip = P00503_A518EmpZonDescrip[0] ;
         A339TipEmpleDescri = P00503_A339TipEmpleDescri[0] ;
         A108ActDescrip = P00503_A108ActDescrip[0] ;
         A177EmpCUIT = P00503_A177EmpCUIT[0] ;
         A2EmpNom = P00503_A2EmpNom[0] ;
         A1EmpCod = P00503_A1EmpCod[0] ;
         A339TipEmpleDescri = P00503_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P00503_A518EmpZonDescrip[0] ;
         A108ActDescrip = P00503_A108ActDescrip[0] ;
         AV60count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00503_A43ActCodigo[0], A43ActCodigo) == 0 ) )
         {
            brk504 = false ;
            A3CliCod = P00503_A3CliCod[0] ;
            A1EmpCod = P00503_A1EmpCod[0] ;
            AV60count = (long)(AV60count+1) ;
            brk504 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A108ActDescrip)==0) )
         {
            AV52Option = A108ActDescrip ;
            AV51InsertIndex = 1 ;
            while ( ( AV51InsertIndex <= AV53Options.size() ) && ( GXutil.strcmp((String)AV53Options.elementAt(-1+AV51InsertIndex), AV52Option) < 0 ) )
            {
               AV51InsertIndex = (int)(AV51InsertIndex+1) ;
            }
            AV53Options.add(AV52Option, AV51InsertIndex);
            AV58OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV60count), "Z,ZZZ,ZZZ,ZZ9")), AV51InsertIndex);
         }
         if ( AV53Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk504 )
         {
            brk504 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADTIPEMPLEDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV46TFTipEmpleDescri = AV48SearchTxt ;
      AV90TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV105Empresawwds_1_tfempnom = AV12TFEmpNom ;
      AV106Empresawwds_2_tfempnom_sels = AV68TFEmpNom_Sels ;
      AV107Empresawwds_3_tfempcuit = AV14TFEmpCUIT ;
      AV108Empresawwds_4_tfempcuit_to = AV99TFEmpCUIT_To ;
      AV109Empresawwds_5_tfactdescrip = AV40TFActDescrip ;
      AV110Empresawwds_6_tfactdescrip_sels = AV86TFActDescrip_Sels ;
      AV111Empresawwds_7_tftipempledescri = AV46TFTipEmpleDescri ;
      AV112Empresawwds_8_tftipempledescri_sels = AV90TFTipEmpleDescri_Sels ;
      AV113Empresawwds_9_tfempzondescrip = AV97TFEmpZonDescrip ;
      AV114Empresawwds_10_tfempzondescrip_sels = AV98TFEmpZonDescrip_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV106Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV110Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV112Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV114Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV106Empresawwds_2_tfempnom_sels.size()) ,
                                           AV105Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV107Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV108Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV110Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV109Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV112Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV111Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV114Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV113Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV91CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV105Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV105Empresawwds_1_tfempnom), "%", "") ;
      lV109Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV109Empresawwds_5_tfactdescrip), "%", "") ;
      lV111Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV111Empresawwds_7_tftipempledescri), "%", "") ;
      lV113Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV113Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor P00504 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV91CliCod), lV105Empresawwds_1_tfempnom, Long.valueOf(AV107Empresawwds_3_tfempcuit), Long.valueOf(AV108Empresawwds_4_tfempcuit_to), lV109Empresawwds_5_tfactdescrip, lV111Empresawwds_7_tftipempledescri, lV113Empresawwds_9_tfempzondescrip});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk506 = false ;
         A43ActCodigo = P00504_A43ActCodigo[0] ;
         n43ActCodigo = P00504_n43ActCodigo[0] ;
         A45TipEmpleCod = P00504_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00504_n45TipEmpleCod[0] ;
         A44EmpZonCod = P00504_A44EmpZonCod[0] ;
         n44EmpZonCod = P00504_n44EmpZonCod[0] ;
         A3CliCod = P00504_A3CliCod[0] ;
         A339TipEmpleDescri = P00504_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P00504_A518EmpZonDescrip[0] ;
         A108ActDescrip = P00504_A108ActDescrip[0] ;
         A177EmpCUIT = P00504_A177EmpCUIT[0] ;
         A2EmpNom = P00504_A2EmpNom[0] ;
         A1EmpCod = P00504_A1EmpCod[0] ;
         A108ActDescrip = P00504_A108ActDescrip[0] ;
         A339TipEmpleDescri = P00504_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P00504_A518EmpZonDescrip[0] ;
         AV60count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00504_A339TipEmpleDescri[0], A339TipEmpleDescri) == 0 ) )
         {
            brk506 = false ;
            A45TipEmpleCod = P00504_A45TipEmpleCod[0] ;
            n45TipEmpleCod = P00504_n45TipEmpleCod[0] ;
            A3CliCod = P00504_A3CliCod[0] ;
            A1EmpCod = P00504_A1EmpCod[0] ;
            AV60count = (long)(AV60count+1) ;
            brk506 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A339TipEmpleDescri)==0) )
         {
            AV52Option = A339TipEmpleDescri ;
            AV53Options.add(AV52Option, 0);
            AV58OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV60count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV53Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk506 )
         {
            brk506 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADEMPZONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV97TFEmpZonDescrip = AV48SearchTxt ;
      AV98TFEmpZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV105Empresawwds_1_tfempnom = AV12TFEmpNom ;
      AV106Empresawwds_2_tfempnom_sels = AV68TFEmpNom_Sels ;
      AV107Empresawwds_3_tfempcuit = AV14TFEmpCUIT ;
      AV108Empresawwds_4_tfempcuit_to = AV99TFEmpCUIT_To ;
      AV109Empresawwds_5_tfactdescrip = AV40TFActDescrip ;
      AV110Empresawwds_6_tfactdescrip_sels = AV86TFActDescrip_Sels ;
      AV111Empresawwds_7_tftipempledescri = AV46TFTipEmpleDescri ;
      AV112Empresawwds_8_tftipempledescri_sels = AV90TFTipEmpleDescri_Sels ;
      AV113Empresawwds_9_tfempzondescrip = AV97TFEmpZonDescrip ;
      AV114Empresawwds_10_tfempzondescrip_sels = AV98TFEmpZonDescrip_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A2EmpNom ,
                                           AV106Empresawwds_2_tfempnom_sels ,
                                           A108ActDescrip ,
                                           AV110Empresawwds_6_tfactdescrip_sels ,
                                           A339TipEmpleDescri ,
                                           AV112Empresawwds_8_tftipempledescri_sels ,
                                           A518EmpZonDescrip ,
                                           AV114Empresawwds_10_tfempzondescrip_sels ,
                                           Integer.valueOf(AV106Empresawwds_2_tfempnom_sels.size()) ,
                                           AV105Empresawwds_1_tfempnom ,
                                           Long.valueOf(AV107Empresawwds_3_tfempcuit) ,
                                           Long.valueOf(AV108Empresawwds_4_tfempcuit_to) ,
                                           Integer.valueOf(AV110Empresawwds_6_tfactdescrip_sels.size()) ,
                                           AV109Empresawwds_5_tfactdescrip ,
                                           Integer.valueOf(AV112Empresawwds_8_tftipempledescri_sels.size()) ,
                                           AV111Empresawwds_7_tftipempledescri ,
                                           Integer.valueOf(AV114Empresawwds_10_tfempzondescrip_sels.size()) ,
                                           AV113Empresawwds_9_tfempzondescrip ,
                                           Long.valueOf(A177EmpCUIT) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV91CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV105Empresawwds_1_tfempnom = GXutil.concat( GXutil.rtrim( AV105Empresawwds_1_tfempnom), "%", "") ;
      lV109Empresawwds_5_tfactdescrip = GXutil.concat( GXutil.rtrim( AV109Empresawwds_5_tfactdescrip), "%", "") ;
      lV111Empresawwds_7_tftipempledescri = GXutil.concat( GXutil.rtrim( AV111Empresawwds_7_tftipempledescri), "%", "") ;
      lV113Empresawwds_9_tfempzondescrip = GXutil.concat( GXutil.rtrim( AV113Empresawwds_9_tfempzondescrip), "%", "") ;
      /* Using cursor P00505 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV91CliCod), lV105Empresawwds_1_tfempnom, Long.valueOf(AV107Empresawwds_3_tfempcuit), Long.valueOf(AV108Empresawwds_4_tfempcuit_to), lV109Empresawwds_5_tfactdescrip, lV111Empresawwds_7_tftipempledescri, lV113Empresawwds_9_tfempzondescrip});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk508 = false ;
         A43ActCodigo = P00505_A43ActCodigo[0] ;
         n43ActCodigo = P00505_n43ActCodigo[0] ;
         A45TipEmpleCod = P00505_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00505_n45TipEmpleCod[0] ;
         A44EmpZonCod = P00505_A44EmpZonCod[0] ;
         n44EmpZonCod = P00505_n44EmpZonCod[0] ;
         A3CliCod = P00505_A3CliCod[0] ;
         A518EmpZonDescrip = P00505_A518EmpZonDescrip[0] ;
         A339TipEmpleDescri = P00505_A339TipEmpleDescri[0] ;
         A108ActDescrip = P00505_A108ActDescrip[0] ;
         A177EmpCUIT = P00505_A177EmpCUIT[0] ;
         A2EmpNom = P00505_A2EmpNom[0] ;
         A1EmpCod = P00505_A1EmpCod[0] ;
         A108ActDescrip = P00505_A108ActDescrip[0] ;
         A339TipEmpleDescri = P00505_A339TipEmpleDescri[0] ;
         A518EmpZonDescrip = P00505_A518EmpZonDescrip[0] ;
         AV60count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P00505_A44EmpZonCod[0], A44EmpZonCod) == 0 ) )
         {
            brk508 = false ;
            A3CliCod = P00505_A3CliCod[0] ;
            A1EmpCod = P00505_A1EmpCod[0] ;
            AV60count = (long)(AV60count+1) ;
            brk508 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A518EmpZonDescrip)==0) )
         {
            AV52Option = A518EmpZonDescrip ;
            AV51InsertIndex = 1 ;
            while ( ( AV51InsertIndex <= AV53Options.size() ) && ( GXutil.strcmp((String)AV53Options.elementAt(-1+AV51InsertIndex), AV52Option) < 0 ) )
            {
               AV51InsertIndex = (int)(AV51InsertIndex+1) ;
            }
            AV53Options.add(AV52Option, AV51InsertIndex);
            AV58OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV60count), "Z,ZZZ,ZZZ,ZZ9")), AV51InsertIndex);
         }
         if ( AV53Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk508 )
         {
            brk508 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresawwgetfilterdata.this.AV54OptionsJson;
      this.aP4[0] = empresawwgetfilterdata.this.AV57OptionsDescJson;
      this.aP5[0] = empresawwgetfilterdata.this.AV59OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV54OptionsJson = "" ;
      AV57OptionsDescJson = "" ;
      AV59OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV53Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV61Session = httpContext.getWebSession();
      AV63GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV64GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFEmpNom = "" ;
      AV67TFEmpNom_SelsJson = "" ;
      AV68TFEmpNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFActDescrip = "" ;
      AV85TFActDescrip_SelsJson = "" ;
      AV86TFActDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFTipEmpleDescri = "" ;
      AV89TFTipEmpleDescri_SelsJson = "" ;
      AV90TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV97TFEmpZonDescrip = "" ;
      AV96TFEmpZonDescrip_SelsJson = "" ;
      AV98TFEmpZonDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100MenuOpcCod = "" ;
      A2EmpNom = "" ;
      AV105Empresawwds_1_tfempnom = "" ;
      AV106Empresawwds_2_tfempnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV109Empresawwds_5_tfactdescrip = "" ;
      AV110Empresawwds_6_tfactdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV111Empresawwds_7_tftipempledescri = "" ;
      AV112Empresawwds_8_tftipempledescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV113Empresawwds_9_tfempzondescrip = "" ;
      AV114Empresawwds_10_tfempzondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV105Empresawwds_1_tfempnom = "" ;
      lV109Empresawwds_5_tfactdescrip = "" ;
      lV111Empresawwds_7_tftipempledescri = "" ;
      lV113Empresawwds_9_tfempzondescrip = "" ;
      A108ActDescrip = "" ;
      A339TipEmpleDescri = "" ;
      A518EmpZonDescrip = "" ;
      P00502_A43ActCodigo = new String[] {""} ;
      P00502_n43ActCodigo = new boolean[] {false} ;
      P00502_A45TipEmpleCod = new String[] {""} ;
      P00502_n45TipEmpleCod = new boolean[] {false} ;
      P00502_A44EmpZonCod = new String[] {""} ;
      P00502_n44EmpZonCod = new boolean[] {false} ;
      P00502_A3CliCod = new int[1] ;
      P00502_A2EmpNom = new String[] {""} ;
      P00502_A518EmpZonDescrip = new String[] {""} ;
      P00502_A339TipEmpleDescri = new String[] {""} ;
      P00502_A108ActDescrip = new String[] {""} ;
      P00502_A177EmpCUIT = new long[1] ;
      P00502_A1EmpCod = new short[1] ;
      A43ActCodigo = "" ;
      A45TipEmpleCod = "" ;
      A44EmpZonCod = "" ;
      AV52Option = "" ;
      P00503_A45TipEmpleCod = new String[] {""} ;
      P00503_n45TipEmpleCod = new boolean[] {false} ;
      P00503_A44EmpZonCod = new String[] {""} ;
      P00503_n44EmpZonCod = new boolean[] {false} ;
      P00503_A43ActCodigo = new String[] {""} ;
      P00503_n43ActCodigo = new boolean[] {false} ;
      P00503_A3CliCod = new int[1] ;
      P00503_A518EmpZonDescrip = new String[] {""} ;
      P00503_A339TipEmpleDescri = new String[] {""} ;
      P00503_A108ActDescrip = new String[] {""} ;
      P00503_A177EmpCUIT = new long[1] ;
      P00503_A2EmpNom = new String[] {""} ;
      P00503_A1EmpCod = new short[1] ;
      P00504_A43ActCodigo = new String[] {""} ;
      P00504_n43ActCodigo = new boolean[] {false} ;
      P00504_A45TipEmpleCod = new String[] {""} ;
      P00504_n45TipEmpleCod = new boolean[] {false} ;
      P00504_A44EmpZonCod = new String[] {""} ;
      P00504_n44EmpZonCod = new boolean[] {false} ;
      P00504_A3CliCod = new int[1] ;
      P00504_A339TipEmpleDescri = new String[] {""} ;
      P00504_A518EmpZonDescrip = new String[] {""} ;
      P00504_A108ActDescrip = new String[] {""} ;
      P00504_A177EmpCUIT = new long[1] ;
      P00504_A2EmpNom = new String[] {""} ;
      P00504_A1EmpCod = new short[1] ;
      P00505_A43ActCodigo = new String[] {""} ;
      P00505_n43ActCodigo = new boolean[] {false} ;
      P00505_A45TipEmpleCod = new String[] {""} ;
      P00505_n45TipEmpleCod = new boolean[] {false} ;
      P00505_A44EmpZonCod = new String[] {""} ;
      P00505_n44EmpZonCod = new boolean[] {false} ;
      P00505_A3CliCod = new int[1] ;
      P00505_A518EmpZonDescrip = new String[] {""} ;
      P00505_A339TipEmpleDescri = new String[] {""} ;
      P00505_A108ActDescrip = new String[] {""} ;
      P00505_A177EmpCUIT = new long[1] ;
      P00505_A2EmpNom = new String[] {""} ;
      P00505_A1EmpCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00502_A43ActCodigo, P00502_n43ActCodigo, P00502_A45TipEmpleCod, P00502_n45TipEmpleCod, P00502_A44EmpZonCod, P00502_n44EmpZonCod, P00502_A3CliCod, P00502_A2EmpNom, P00502_A518EmpZonDescrip, P00502_A339TipEmpleDescri,
            P00502_A108ActDescrip, P00502_A177EmpCUIT, P00502_A1EmpCod
            }
            , new Object[] {
            P00503_A45TipEmpleCod, P00503_n45TipEmpleCod, P00503_A44EmpZonCod, P00503_n44EmpZonCod, P00503_A43ActCodigo, P00503_n43ActCodigo, P00503_A3CliCod, P00503_A518EmpZonDescrip, P00503_A339TipEmpleDescri, P00503_A108ActDescrip,
            P00503_A177EmpCUIT, P00503_A2EmpNom, P00503_A1EmpCod
            }
            , new Object[] {
            P00504_A43ActCodigo, P00504_n43ActCodigo, P00504_A45TipEmpleCod, P00504_n45TipEmpleCod, P00504_A44EmpZonCod, P00504_n44EmpZonCod, P00504_A3CliCod, P00504_A339TipEmpleDescri, P00504_A518EmpZonDescrip, P00504_A108ActDescrip,
            P00504_A177EmpCUIT, P00504_A2EmpNom, P00504_A1EmpCod
            }
            , new Object[] {
            P00505_A43ActCodigo, P00505_n43ActCodigo, P00505_A45TipEmpleCod, P00505_n45TipEmpleCod, P00505_A44EmpZonCod, P00505_n44EmpZonCod, P00505_A3CliCod, P00505_A518EmpZonDescrip, P00505_A339TipEmpleDescri, P00505_A108ActDescrip,
            P00505_A177EmpCUIT, P00505_A2EmpNom, P00505_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV92EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV91CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV103GXV1 ;
   private int AV106Empresawwds_2_tfempnom_sels_size ;
   private int AV110Empresawwds_6_tfactdescrip_sels_size ;
   private int AV112Empresawwds_8_tftipempledescri_sels_size ;
   private int AV114Empresawwds_10_tfempzondescrip_sels_size ;
   private int A3CliCod ;
   private int AV51InsertIndex ;
   private long AV14TFEmpCUIT ;
   private long AV99TFEmpCUIT_To ;
   private long AV107Empresawwds_3_tfempcuit ;
   private long AV108Empresawwds_4_tfempcuit_to ;
   private long A177EmpCUIT ;
   private long AV60count ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private String A44EmpZonCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk502 ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private boolean brk504 ;
   private boolean brk506 ;
   private boolean brk508 ;
   private String AV54OptionsJson ;
   private String AV57OptionsDescJson ;
   private String AV59OptionIndexesJson ;
   private String AV67TFEmpNom_SelsJson ;
   private String AV85TFActDescrip_SelsJson ;
   private String AV89TFTipEmpleDescri_SelsJson ;
   private String AV96TFEmpZonDescrip_SelsJson ;
   private String AV50DDOName ;
   private String AV48SearchTxt ;
   private String AV49SearchTxtTo ;
   private String AV12TFEmpNom ;
   private String AV40TFActDescrip ;
   private String AV46TFTipEmpleDescri ;
   private String AV97TFEmpZonDescrip ;
   private String AV100MenuOpcCod ;
   private String A2EmpNom ;
   private String AV105Empresawwds_1_tfempnom ;
   private String AV109Empresawwds_5_tfactdescrip ;
   private String AV111Empresawwds_7_tftipempledescri ;
   private String AV113Empresawwds_9_tfempzondescrip ;
   private String lV105Empresawwds_1_tfempnom ;
   private String lV109Empresawwds_5_tfactdescrip ;
   private String lV111Empresawwds_7_tftipempledescri ;
   private String lV113Empresawwds_9_tfempzondescrip ;
   private String A108ActDescrip ;
   private String A339TipEmpleDescri ;
   private String A518EmpZonDescrip ;
   private String AV52Option ;
   private com.genexus.webpanels.WebSession AV61Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00502_A43ActCodigo ;
   private boolean[] P00502_n43ActCodigo ;
   private String[] P00502_A45TipEmpleCod ;
   private boolean[] P00502_n45TipEmpleCod ;
   private String[] P00502_A44EmpZonCod ;
   private boolean[] P00502_n44EmpZonCod ;
   private int[] P00502_A3CliCod ;
   private String[] P00502_A2EmpNom ;
   private String[] P00502_A518EmpZonDescrip ;
   private String[] P00502_A339TipEmpleDescri ;
   private String[] P00502_A108ActDescrip ;
   private long[] P00502_A177EmpCUIT ;
   private short[] P00502_A1EmpCod ;
   private String[] P00503_A45TipEmpleCod ;
   private boolean[] P00503_n45TipEmpleCod ;
   private String[] P00503_A44EmpZonCod ;
   private boolean[] P00503_n44EmpZonCod ;
   private String[] P00503_A43ActCodigo ;
   private boolean[] P00503_n43ActCodigo ;
   private int[] P00503_A3CliCod ;
   private String[] P00503_A518EmpZonDescrip ;
   private String[] P00503_A339TipEmpleDescri ;
   private String[] P00503_A108ActDescrip ;
   private long[] P00503_A177EmpCUIT ;
   private String[] P00503_A2EmpNom ;
   private short[] P00503_A1EmpCod ;
   private String[] P00504_A43ActCodigo ;
   private boolean[] P00504_n43ActCodigo ;
   private String[] P00504_A45TipEmpleCod ;
   private boolean[] P00504_n45TipEmpleCod ;
   private String[] P00504_A44EmpZonCod ;
   private boolean[] P00504_n44EmpZonCod ;
   private int[] P00504_A3CliCod ;
   private String[] P00504_A339TipEmpleDescri ;
   private String[] P00504_A518EmpZonDescrip ;
   private String[] P00504_A108ActDescrip ;
   private long[] P00504_A177EmpCUIT ;
   private String[] P00504_A2EmpNom ;
   private short[] P00504_A1EmpCod ;
   private String[] P00505_A43ActCodigo ;
   private boolean[] P00505_n43ActCodigo ;
   private String[] P00505_A45TipEmpleCod ;
   private boolean[] P00505_n45TipEmpleCod ;
   private String[] P00505_A44EmpZonCod ;
   private boolean[] P00505_n44EmpZonCod ;
   private int[] P00505_A3CliCod ;
   private String[] P00505_A518EmpZonDescrip ;
   private String[] P00505_A339TipEmpleDescri ;
   private String[] P00505_A108ActDescrip ;
   private long[] P00505_A177EmpCUIT ;
   private String[] P00505_A2EmpNom ;
   private short[] P00505_A1EmpCod ;
   private GXSimpleCollection<String> AV53Options ;
   private GXSimpleCollection<String> AV56OptionsDesc ;
   private GXSimpleCollection<String> AV58OptionIndexes ;
   private GXSimpleCollection<String> AV68TFEmpNom_Sels ;
   private GXSimpleCollection<String> AV86TFActDescrip_Sels ;
   private GXSimpleCollection<String> AV90TFTipEmpleDescri_Sels ;
   private GXSimpleCollection<String> AV98TFEmpZonDescrip_Sels ;
   private GXSimpleCollection<String> AV106Empresawwds_2_tfempnom_sels ;
   private GXSimpleCollection<String> AV110Empresawwds_6_tfactdescrip_sels ;
   private GXSimpleCollection<String> AV112Empresawwds_8_tftipempledescri_sels ;
   private GXSimpleCollection<String> AV114Empresawwds_10_tfempzondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV63GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV64GridStateFilterValue ;
}

final  class empresawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00502( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV106Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV110Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV112Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV114Empresawwds_10_tfempzondescrip_sels ,
                                          int AV106Empresawwds_2_tfempnom_sels_size ,
                                          String AV105Empresawwds_1_tfempnom ,
                                          long AV107Empresawwds_3_tfempcuit ,
                                          long AV108Empresawwds_4_tfempcuit_to ,
                                          int AV110Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV109Empresawwds_5_tfactdescrip ,
                                          int AV112Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV111Empresawwds_7_tftipempledescri ,
                                          int AV114Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV113Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          int AV91CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.ActCodigo, T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T1.CliCod, T1.EmpNom, T4.ZonDescrip AS EmpZonDescrip, T3.TipEmpleDescri, T2.ActDescrip, T1.EmpCUIT," ;
      scmdbuf += " T1.EmpCod FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona" ;
      scmdbuf += " T4 ON T4.ZonCod = T1.EmpZonCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV106Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV106Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV107Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV108Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV110Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV110Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV112Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV111Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV112Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV114Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV114Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00503( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV106Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV110Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV112Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV114Empresawwds_10_tfempzondescrip_sels ,
                                          int AV106Empresawwds_2_tfempnom_sels_size ,
                                          String AV105Empresawwds_1_tfempnom ,
                                          long AV107Empresawwds_3_tfempcuit ,
                                          long AV108Empresawwds_4_tfempcuit_to ,
                                          int AV110Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV109Empresawwds_5_tfactdescrip ,
                                          int AV112Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV111Empresawwds_7_tftipempledescri ,
                                          int AV114Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV113Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          int A3CliCod ,
                                          int AV91CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T1.ActCodigo, T1.CliCod, T3.ZonDescrip AS EmpZonDescrip, T2.TipEmpleDescri, T4.ActDescrip, T1.EmpCUIT, T1.EmpNom," ;
      scmdbuf += " T1.EmpCod FROM (((Empresa T1 LEFT JOIN TipoEmpleador T2 ON T2.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona T3 ON T3.ZonCod = T1.EmpZonCod) LEFT JOIN Actividad T4" ;
      scmdbuf += " ON T4.ActCodigo = T1.ActCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV106Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV106Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV107Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV108Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV110Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV110Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Empresawwds_6_tfactdescrip_sels, "T4.ActDescrip IN (", ")")+")");
      }
      if ( ( AV112Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV111Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV112Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Empresawwds_8_tftipempledescri_sels, "T2.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV114Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV114Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Empresawwds_10_tfempzondescrip_sels, "T3.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ActCodigo" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P00504( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV106Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV110Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV112Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV114Empresawwds_10_tfempzondescrip_sels ,
                                          int AV106Empresawwds_2_tfempnom_sels_size ,
                                          String AV105Empresawwds_1_tfempnom ,
                                          long AV107Empresawwds_3_tfempcuit ,
                                          long AV108Empresawwds_4_tfempcuit_to ,
                                          int AV110Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV109Empresawwds_5_tfactdescrip ,
                                          int AV112Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV111Empresawwds_7_tftipempledescri ,
                                          int AV114Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV113Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          int A3CliCod ,
                                          int AV91CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[7];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.ActCodigo, T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T1.CliCod, T3.TipEmpleDescri, T4.ZonDescrip AS EmpZonDescrip, T2.ActDescrip, T1.EmpCUIT, T1.EmpNom," ;
      scmdbuf += " T1.EmpCod FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona" ;
      scmdbuf += " T4 ON T4.ZonCod = T1.EmpZonCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV106Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV106Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV107Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (0==AV108Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ( AV110Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV110Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV112Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV111Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV112Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV114Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV114Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T3.TipEmpleDescri" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P00505( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2EmpNom ,
                                          GXSimpleCollection<String> AV106Empresawwds_2_tfempnom_sels ,
                                          String A108ActDescrip ,
                                          GXSimpleCollection<String> AV110Empresawwds_6_tfactdescrip_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV112Empresawwds_8_tftipempledescri_sels ,
                                          String A518EmpZonDescrip ,
                                          GXSimpleCollection<String> AV114Empresawwds_10_tfempzondescrip_sels ,
                                          int AV106Empresawwds_2_tfempnom_sels_size ,
                                          String AV105Empresawwds_1_tfempnom ,
                                          long AV107Empresawwds_3_tfempcuit ,
                                          long AV108Empresawwds_4_tfempcuit_to ,
                                          int AV110Empresawwds_6_tfactdescrip_sels_size ,
                                          String AV109Empresawwds_5_tfactdescrip ,
                                          int AV112Empresawwds_8_tftipempledescri_sels_size ,
                                          String AV111Empresawwds_7_tftipempledescri ,
                                          int AV114Empresawwds_10_tfempzondescrip_sels_size ,
                                          String AV113Empresawwds_9_tfempzondescrip ,
                                          long A177EmpCUIT ,
                                          int A3CliCod ,
                                          int AV91CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[7];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.ActCodigo, T1.TipEmpleCod, T1.EmpZonCod AS EmpZonCod, T1.CliCod, T4.ZonDescrip AS EmpZonDescrip, T3.TipEmpleDescri, T2.ActDescrip, T1.EmpCUIT, T1.EmpNom," ;
      scmdbuf += " T1.EmpCod FROM (((Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) LEFT JOIN TipoEmpleador T3 ON T3.TipEmpleCod = T1.TipEmpleCod) LEFT JOIN Zona" ;
      scmdbuf += " T4 ON T4.ZonCod = T1.EmpZonCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV106Empresawwds_2_tfempnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV105Empresawwds_1_tfempnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpNom) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV106Empresawwds_2_tfempnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV106Empresawwds_2_tfempnom_sels, "T1.EmpNom IN (", ")")+")");
      }
      if ( ! (0==AV107Empresawwds_3_tfempcuit) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT >= ?)");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( ! (0==AV108Empresawwds_4_tfempcuit_to) )
      {
         addWhere(sWhereString, "(T1.EmpCUIT <= ?)");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( ( AV110Empresawwds_6_tfactdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV109Empresawwds_5_tfactdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ActDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV110Empresawwds_6_tfactdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV110Empresawwds_6_tfactdescrip_sels, "T2.ActDescrip IN (", ")")+")");
      }
      if ( ( AV112Empresawwds_8_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV111Empresawwds_7_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV112Empresawwds_8_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV112Empresawwds_8_tftipempledescri_sels, "T3.TipEmpleDescri IN (", ")")+")");
      }
      if ( ( AV114Empresawwds_10_tfempzondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV113Empresawwds_9_tfempzondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T4.ZonDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( AV114Empresawwds_10_tfempzondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV114Empresawwds_10_tfempzondescrip_sels, "T4.ZonDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.EmpZonCod" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P00502(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
            case 1 :
                  return conditional_P00503(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
            case 2 :
                  return conditional_P00504(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
            case 3 :
                  return conditional_P00505(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).longValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00502", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00503", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00504", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00505", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((long[]) buf[11])[0] = rslt.getLong(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 8);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((long[]) buf[10])[0] = rslt.getLong(8);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((long[]) buf[10])[0] = rslt.getLong(8);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 8);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((String[]) buf[7])[0] = rslt.getVarchar(5);
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((long[]) buf[10])[0] = rslt.getLong(8);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((short[]) buf[12])[0] = rslt.getShort(10);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[9]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[10]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 150);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               return;
      }
   }

}

