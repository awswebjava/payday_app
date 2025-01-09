package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class estadowwgetfilterdata extends GXProcedure
{
   public estadowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estadowwgetfilterdata.class ), "" );
   }

   public estadowwgetfilterdata( int remoteHandle ,
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
      estadowwgetfilterdata.this.aP5 = new String[] {""};
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
      estadowwgetfilterdata.this.AV16DDOName = aP0;
      estadowwgetfilterdata.this.AV14SearchTxt = aP1;
      estadowwgetfilterdata.this.AV15SearchTxtTo = aP2;
      estadowwgetfilterdata.this.aP3 = aP3;
      estadowwgetfilterdata.this.aP4 = aP4;
      estadowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      estadowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV35CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      estadowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV35CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion", GXv_boolean6) ;
      estadowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SITCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSITCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SITDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSITDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_ESTADOSINIESTRO") == 0 )
         {
            /* Execute user subroutine: 'LOADESTADOSINIESTROOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("EstadoWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EstadoWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("EstadoWWGridState"), null, null);
      }
      AV61GXV1 = 1 ;
      while ( AV61GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV61GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITCODIGO") == 0 )
         {
            AV10TFSitCodigo = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITCODIGO_SEL") == 0 )
         {
            AV38TFSitCodigo_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV39TFSitCodigo_Sels.fromJSonString(AV38TFSitCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITDESCRIP") == 0 )
         {
            AV12TFSitDescrip = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITDESCRIP_SEL") == 0 )
         {
            AV33TFSitDescrip_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV34TFSitDescrip_Sels.fromJSonString(AV33TFSitDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITESLICENCIA_SEL") == 0 )
         {
            AV40TFSitEsLicencia_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITLICCUENTATRAB_SEL") == 0 )
         {
            AV41TFSitLicCuentaTrab_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITESAUSENCIA_SEL") == 0 )
         {
            AV48TFSitEsAusencia_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITABSORBEFER_SEL") == 0 )
         {
            AV49TFSitAbsorbeFer_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSITREVISTA") == 0 )
         {
            AV50TFEstadoSitRevista = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV51TFEstadoSitRevista_To = (short)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSINIESTRO") == 0 )
         {
            AV53TFEstadoSiniestro = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOSINIESTRO_SEL") == 0 )
         {
            AV52TFEstadoSiniestro_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFEstadoSiniestro_Sels.fromJSonString(AV52TFEstadoSiniestro_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOCANPRESEN_SEL") == 0 )
         {
            AV56TFEstadoCanPresen_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESTADOREMCORR_SEL") == 0 )
         {
            AV57TFEstadoRemCorr_Sel = (byte)(GXutil.lval( AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV58MenuOpcCod = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV61GXV1 = (int)(AV61GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSITCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSitCodigo = AV14SearchTxt ;
      AV39TFSitCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63Estadowwds_1_tfsitcodigo = AV10TFSitCodigo ;
      AV64Estadowwds_2_tfsitcodigo_sels = AV39TFSitCodigo_Sels ;
      AV65Estadowwds_3_tfsitdescrip = AV12TFSitDescrip ;
      AV66Estadowwds_4_tfsitdescrip_sels = AV34TFSitDescrip_Sels ;
      AV67Estadowwds_5_tfsiteslicencia_sel = AV40TFSitEsLicencia_Sel ;
      AV68Estadowwds_6_tfsitliccuentatrab_sel = AV41TFSitLicCuentaTrab_Sel ;
      AV69Estadowwds_7_tfsitesausencia_sel = AV48TFSitEsAusencia_Sel ;
      AV70Estadowwds_8_tfsitabsorbefer_sel = AV49TFSitAbsorbeFer_Sel ;
      AV71Estadowwds_9_tfestadositrevista = AV50TFEstadoSitRevista ;
      AV72Estadowwds_10_tfestadositrevista_to = AV51TFEstadoSitRevista_To ;
      AV73Estadowwds_11_tfestadosiniestro = AV53TFEstadoSiniestro ;
      AV74Estadowwds_12_tfestadosiniestro_sels = AV54TFEstadoSiniestro_Sels ;
      AV75Estadowwds_13_tfestadocanpresen_sel = AV56TFEstadoCanPresen_Sel ;
      AV76Estadowwds_14_tfestadoremcorr_sel = AV57TFEstadoRemCorr_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A16SitCodigo ,
                                           AV64Estadowwds_2_tfsitcodigo_sels ,
                                           A334SitDescrip ,
                                           AV66Estadowwds_4_tfsitdescrip_sels ,
                                           A1600EstadoSiniestro ,
                                           AV74Estadowwds_12_tfestadosiniestro_sels ,
                                           Integer.valueOf(AV64Estadowwds_2_tfsitcodigo_sels.size()) ,
                                           AV63Estadowwds_1_tfsitcodigo ,
                                           Integer.valueOf(AV66Estadowwds_4_tfsitdescrip_sels.size()) ,
                                           AV65Estadowwds_3_tfsitdescrip ,
                                           Byte.valueOf(AV67Estadowwds_5_tfsiteslicencia_sel) ,
                                           Byte.valueOf(AV68Estadowwds_6_tfsitliccuentatrab_sel) ,
                                           Byte.valueOf(AV69Estadowwds_7_tfsitesausencia_sel) ,
                                           Byte.valueOf(AV70Estadowwds_8_tfsitabsorbefer_sel) ,
                                           Short.valueOf(AV71Estadowwds_9_tfestadositrevista) ,
                                           Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to) ,
                                           Integer.valueOf(AV74Estadowwds_12_tfestadosiniestro_sels.size()) ,
                                           AV73Estadowwds_11_tfestadosiniestro ,
                                           Byte.valueOf(AV75Estadowwds_13_tfestadocanpresen_sel) ,
                                           Byte.valueOf(AV76Estadowwds_14_tfestadoremcorr_sel) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Boolean.valueOf(A739SitLicCuentaTrab) ,
                                           Boolean.valueOf(A916SitEsAusencia) ,
                                           Boolean.valueOf(A1220SitAbsorbeFer) ,
                                           Short.valueOf(A1598EstadoSitRevista) ,
                                           Boolean.valueOf(A1807EstadoCanPresen) ,
                                           Boolean.valueOf(A1809EstadoRemCorr) ,
                                           Short.valueOf(A1593SitPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV63Estadowwds_1_tfsitcodigo = GXutil.padr( GXutil.rtrim( AV63Estadowwds_1_tfsitcodigo), 4, "%") ;
      lV65Estadowwds_3_tfsitdescrip = GXutil.concat( GXutil.rtrim( AV65Estadowwds_3_tfsitdescrip), "%", "") ;
      lV73Estadowwds_11_tfestadosiniestro = GXutil.padr( GXutil.rtrim( AV73Estadowwds_11_tfestadosiniestro), 4, "%") ;
      /* Using cursor P00892 */
      pr_default.execute(0, new Object[] {lV63Estadowwds_1_tfsitcodigo, lV65Estadowwds_3_tfsitdescrip, Short.valueOf(AV71Estadowwds_9_tfestadositrevista), Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to), lV73Estadowwds_11_tfestadosiniestro, Short.valueOf(AV55PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1593SitPaiCod = P00892_A1593SitPaiCod[0] ;
         n1593SitPaiCod = P00892_n1593SitPaiCod[0] ;
         A1809EstadoRemCorr = P00892_A1809EstadoRemCorr[0] ;
         A1807EstadoCanPresen = P00892_A1807EstadoCanPresen[0] ;
         A1600EstadoSiniestro = P00892_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P00892_n1600EstadoSiniestro[0] ;
         A1598EstadoSitRevista = P00892_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P00892_n1598EstadoSitRevista[0] ;
         A1220SitAbsorbeFer = P00892_A1220SitAbsorbeFer[0] ;
         A916SitEsAusencia = P00892_A916SitEsAusencia[0] ;
         A739SitLicCuentaTrab = P00892_A739SitLicCuentaTrab[0] ;
         A738SitEsLicencia = P00892_A738SitEsLicencia[0] ;
         A334SitDescrip = P00892_A334SitDescrip[0] ;
         A16SitCodigo = P00892_A16SitCodigo[0] ;
         if ( ! (GXutil.strcmp("", A16SitCodigo)==0) )
         {
            AV18Option = A16SitCodigo ;
            AV19Options.add(AV18Option, 0);
         }
         if ( AV19Options.size() == 50 )
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
      /* 'LOADSITDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSitDescrip = AV14SearchTxt ;
      AV34TFSitDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63Estadowwds_1_tfsitcodigo = AV10TFSitCodigo ;
      AV64Estadowwds_2_tfsitcodigo_sels = AV39TFSitCodigo_Sels ;
      AV65Estadowwds_3_tfsitdescrip = AV12TFSitDescrip ;
      AV66Estadowwds_4_tfsitdescrip_sels = AV34TFSitDescrip_Sels ;
      AV67Estadowwds_5_tfsiteslicencia_sel = AV40TFSitEsLicencia_Sel ;
      AV68Estadowwds_6_tfsitliccuentatrab_sel = AV41TFSitLicCuentaTrab_Sel ;
      AV69Estadowwds_7_tfsitesausencia_sel = AV48TFSitEsAusencia_Sel ;
      AV70Estadowwds_8_tfsitabsorbefer_sel = AV49TFSitAbsorbeFer_Sel ;
      AV71Estadowwds_9_tfestadositrevista = AV50TFEstadoSitRevista ;
      AV72Estadowwds_10_tfestadositrevista_to = AV51TFEstadoSitRevista_To ;
      AV73Estadowwds_11_tfestadosiniestro = AV53TFEstadoSiniestro ;
      AV74Estadowwds_12_tfestadosiniestro_sels = AV54TFEstadoSiniestro_Sels ;
      AV75Estadowwds_13_tfestadocanpresen_sel = AV56TFEstadoCanPresen_Sel ;
      AV76Estadowwds_14_tfestadoremcorr_sel = AV57TFEstadoRemCorr_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A16SitCodigo ,
                                           AV64Estadowwds_2_tfsitcodigo_sels ,
                                           A334SitDescrip ,
                                           AV66Estadowwds_4_tfsitdescrip_sels ,
                                           A1600EstadoSiniestro ,
                                           AV74Estadowwds_12_tfestadosiniestro_sels ,
                                           Integer.valueOf(AV64Estadowwds_2_tfsitcodigo_sels.size()) ,
                                           AV63Estadowwds_1_tfsitcodigo ,
                                           Integer.valueOf(AV66Estadowwds_4_tfsitdescrip_sels.size()) ,
                                           AV65Estadowwds_3_tfsitdescrip ,
                                           Byte.valueOf(AV67Estadowwds_5_tfsiteslicencia_sel) ,
                                           Byte.valueOf(AV68Estadowwds_6_tfsitliccuentatrab_sel) ,
                                           Byte.valueOf(AV69Estadowwds_7_tfsitesausencia_sel) ,
                                           Byte.valueOf(AV70Estadowwds_8_tfsitabsorbefer_sel) ,
                                           Short.valueOf(AV71Estadowwds_9_tfestadositrevista) ,
                                           Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to) ,
                                           Integer.valueOf(AV74Estadowwds_12_tfestadosiniestro_sels.size()) ,
                                           AV73Estadowwds_11_tfestadosiniestro ,
                                           Byte.valueOf(AV75Estadowwds_13_tfestadocanpresen_sel) ,
                                           Byte.valueOf(AV76Estadowwds_14_tfestadoremcorr_sel) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Boolean.valueOf(A739SitLicCuentaTrab) ,
                                           Boolean.valueOf(A916SitEsAusencia) ,
                                           Boolean.valueOf(A1220SitAbsorbeFer) ,
                                           Short.valueOf(A1598EstadoSitRevista) ,
                                           Boolean.valueOf(A1807EstadoCanPresen) ,
                                           Boolean.valueOf(A1809EstadoRemCorr) ,
                                           Short.valueOf(A1593SitPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV63Estadowwds_1_tfsitcodigo = GXutil.padr( GXutil.rtrim( AV63Estadowwds_1_tfsitcodigo), 4, "%") ;
      lV65Estadowwds_3_tfsitdescrip = GXutil.concat( GXutil.rtrim( AV65Estadowwds_3_tfsitdescrip), "%", "") ;
      lV73Estadowwds_11_tfestadosiniestro = GXutil.padr( GXutil.rtrim( AV73Estadowwds_11_tfestadosiniestro), 4, "%") ;
      /* Using cursor P00893 */
      pr_default.execute(1, new Object[] {lV63Estadowwds_1_tfsitcodigo, lV65Estadowwds_3_tfsitdescrip, Short.valueOf(AV71Estadowwds_9_tfestadositrevista), Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to), lV73Estadowwds_11_tfestadosiniestro, Short.valueOf(AV55PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk893 = false ;
         A334SitDescrip = P00893_A334SitDescrip[0] ;
         A1593SitPaiCod = P00893_A1593SitPaiCod[0] ;
         n1593SitPaiCod = P00893_n1593SitPaiCod[0] ;
         A1809EstadoRemCorr = P00893_A1809EstadoRemCorr[0] ;
         A1807EstadoCanPresen = P00893_A1807EstadoCanPresen[0] ;
         A1600EstadoSiniestro = P00893_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P00893_n1600EstadoSiniestro[0] ;
         A1598EstadoSitRevista = P00893_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P00893_n1598EstadoSitRevista[0] ;
         A1220SitAbsorbeFer = P00893_A1220SitAbsorbeFer[0] ;
         A916SitEsAusencia = P00893_A916SitEsAusencia[0] ;
         A739SitLicCuentaTrab = P00893_A739SitLicCuentaTrab[0] ;
         A738SitEsLicencia = P00893_A738SitEsLicencia[0] ;
         A16SitCodigo = P00893_A16SitCodigo[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00893_A334SitDescrip[0], A334SitDescrip) == 0 ) )
         {
            brk893 = false ;
            A16SitCodigo = P00893_A16SitCodigo[0] ;
            AV26count = (long)(AV26count+1) ;
            brk893 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A334SitDescrip)==0) )
         {
            AV18Option = A334SitDescrip ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk893 )
         {
            brk893 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADESTADOSINIESTROOPTIONS' Routine */
      returnInSub = false ;
      AV53TFEstadoSiniestro = AV14SearchTxt ;
      AV54TFEstadoSiniestro_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV63Estadowwds_1_tfsitcodigo = AV10TFSitCodigo ;
      AV64Estadowwds_2_tfsitcodigo_sels = AV39TFSitCodigo_Sels ;
      AV65Estadowwds_3_tfsitdescrip = AV12TFSitDescrip ;
      AV66Estadowwds_4_tfsitdescrip_sels = AV34TFSitDescrip_Sels ;
      AV67Estadowwds_5_tfsiteslicencia_sel = AV40TFSitEsLicencia_Sel ;
      AV68Estadowwds_6_tfsitliccuentatrab_sel = AV41TFSitLicCuentaTrab_Sel ;
      AV69Estadowwds_7_tfsitesausencia_sel = AV48TFSitEsAusencia_Sel ;
      AV70Estadowwds_8_tfsitabsorbefer_sel = AV49TFSitAbsorbeFer_Sel ;
      AV71Estadowwds_9_tfestadositrevista = AV50TFEstadoSitRevista ;
      AV72Estadowwds_10_tfestadositrevista_to = AV51TFEstadoSitRevista_To ;
      AV73Estadowwds_11_tfestadosiniestro = AV53TFEstadoSiniestro ;
      AV74Estadowwds_12_tfestadosiniestro_sels = AV54TFEstadoSiniestro_Sels ;
      AV75Estadowwds_13_tfestadocanpresen_sel = AV56TFEstadoCanPresen_Sel ;
      AV76Estadowwds_14_tfestadoremcorr_sel = AV57TFEstadoRemCorr_Sel ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A16SitCodigo ,
                                           AV64Estadowwds_2_tfsitcodigo_sels ,
                                           A334SitDescrip ,
                                           AV66Estadowwds_4_tfsitdescrip_sels ,
                                           A1600EstadoSiniestro ,
                                           AV74Estadowwds_12_tfestadosiniestro_sels ,
                                           Integer.valueOf(AV64Estadowwds_2_tfsitcodigo_sels.size()) ,
                                           AV63Estadowwds_1_tfsitcodigo ,
                                           Integer.valueOf(AV66Estadowwds_4_tfsitdescrip_sels.size()) ,
                                           AV65Estadowwds_3_tfsitdescrip ,
                                           Byte.valueOf(AV67Estadowwds_5_tfsiteslicencia_sel) ,
                                           Byte.valueOf(AV68Estadowwds_6_tfsitliccuentatrab_sel) ,
                                           Byte.valueOf(AV69Estadowwds_7_tfsitesausencia_sel) ,
                                           Byte.valueOf(AV70Estadowwds_8_tfsitabsorbefer_sel) ,
                                           Short.valueOf(AV71Estadowwds_9_tfestadositrevista) ,
                                           Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to) ,
                                           Integer.valueOf(AV74Estadowwds_12_tfestadosiniestro_sels.size()) ,
                                           AV73Estadowwds_11_tfestadosiniestro ,
                                           Byte.valueOf(AV75Estadowwds_13_tfestadocanpresen_sel) ,
                                           Byte.valueOf(AV76Estadowwds_14_tfestadoremcorr_sel) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           Boolean.valueOf(A738SitEsLicencia) ,
                                           Boolean.valueOf(A739SitLicCuentaTrab) ,
                                           Boolean.valueOf(A916SitEsAusencia) ,
                                           Boolean.valueOf(A1220SitAbsorbeFer) ,
                                           Short.valueOf(A1598EstadoSitRevista) ,
                                           Boolean.valueOf(A1807EstadoCanPresen) ,
                                           Boolean.valueOf(A1809EstadoRemCorr) ,
                                           Short.valueOf(A1593SitPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV63Estadowwds_1_tfsitcodigo = GXutil.padr( GXutil.rtrim( AV63Estadowwds_1_tfsitcodigo), 4, "%") ;
      lV65Estadowwds_3_tfsitdescrip = GXutil.concat( GXutil.rtrim( AV65Estadowwds_3_tfsitdescrip), "%", "") ;
      lV73Estadowwds_11_tfestadosiniestro = GXutil.padr( GXutil.rtrim( AV73Estadowwds_11_tfestadosiniestro), 4, "%") ;
      /* Using cursor P00894 */
      pr_default.execute(2, new Object[] {lV63Estadowwds_1_tfsitcodigo, lV65Estadowwds_3_tfsitdescrip, Short.valueOf(AV71Estadowwds_9_tfestadositrevista), Short.valueOf(AV72Estadowwds_10_tfestadositrevista_to), lV73Estadowwds_11_tfestadosiniestro, Short.valueOf(AV55PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk895 = false ;
         A1600EstadoSiniestro = P00894_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = P00894_n1600EstadoSiniestro[0] ;
         A1593SitPaiCod = P00894_A1593SitPaiCod[0] ;
         n1593SitPaiCod = P00894_n1593SitPaiCod[0] ;
         A1809EstadoRemCorr = P00894_A1809EstadoRemCorr[0] ;
         A1807EstadoCanPresen = P00894_A1807EstadoCanPresen[0] ;
         A1598EstadoSitRevista = P00894_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = P00894_n1598EstadoSitRevista[0] ;
         A1220SitAbsorbeFer = P00894_A1220SitAbsorbeFer[0] ;
         A916SitEsAusencia = P00894_A916SitEsAusencia[0] ;
         A739SitLicCuentaTrab = P00894_A739SitLicCuentaTrab[0] ;
         A738SitEsLicencia = P00894_A738SitEsLicencia[0] ;
         A334SitDescrip = P00894_A334SitDescrip[0] ;
         A16SitCodigo = P00894_A16SitCodigo[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00894_A1600EstadoSiniestro[0], A1600EstadoSiniestro) == 0 ) )
         {
            brk895 = false ;
            A16SitCodigo = P00894_A16SitCodigo[0] ;
            AV26count = (long)(AV26count+1) ;
            brk895 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1600EstadoSiniestro)==0) )
         {
            AV18Option = A1600EstadoSiniestro ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk895 )
         {
            brk895 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = estadowwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = estadowwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = estadowwgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSitCodigo = "" ;
      AV38TFSitCodigo_SelsJson = "" ;
      AV39TFSitCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSitDescrip = "" ;
      AV33TFSitDescrip_SelsJson = "" ;
      AV34TFSitDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53TFEstadoSiniestro = "" ;
      AV52TFEstadoSiniestro_SelsJson = "" ;
      AV54TFEstadoSiniestro_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58MenuOpcCod = "" ;
      A16SitCodigo = "" ;
      AV63Estadowwds_1_tfsitcodigo = "" ;
      AV64Estadowwds_2_tfsitcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Estadowwds_3_tfsitdescrip = "" ;
      AV66Estadowwds_4_tfsitdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Estadowwds_11_tfestadosiniestro = "" ;
      AV74Estadowwds_12_tfestadosiniestro_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV63Estadowwds_1_tfsitcodigo = "" ;
      lV65Estadowwds_3_tfsitdescrip = "" ;
      lV73Estadowwds_11_tfestadosiniestro = "" ;
      A334SitDescrip = "" ;
      A1600EstadoSiniestro = "" ;
      P00892_A1593SitPaiCod = new short[1] ;
      P00892_n1593SitPaiCod = new boolean[] {false} ;
      P00892_A1809EstadoRemCorr = new boolean[] {false} ;
      P00892_A1807EstadoCanPresen = new boolean[] {false} ;
      P00892_A1600EstadoSiniestro = new String[] {""} ;
      P00892_n1600EstadoSiniestro = new boolean[] {false} ;
      P00892_A1598EstadoSitRevista = new short[1] ;
      P00892_n1598EstadoSitRevista = new boolean[] {false} ;
      P00892_A1220SitAbsorbeFer = new boolean[] {false} ;
      P00892_A916SitEsAusencia = new boolean[] {false} ;
      P00892_A739SitLicCuentaTrab = new boolean[] {false} ;
      P00892_A738SitEsLicencia = new boolean[] {false} ;
      P00892_A334SitDescrip = new String[] {""} ;
      P00892_A16SitCodigo = new String[] {""} ;
      AV18Option = "" ;
      P00893_A334SitDescrip = new String[] {""} ;
      P00893_A1593SitPaiCod = new short[1] ;
      P00893_n1593SitPaiCod = new boolean[] {false} ;
      P00893_A1809EstadoRemCorr = new boolean[] {false} ;
      P00893_A1807EstadoCanPresen = new boolean[] {false} ;
      P00893_A1600EstadoSiniestro = new String[] {""} ;
      P00893_n1600EstadoSiniestro = new boolean[] {false} ;
      P00893_A1598EstadoSitRevista = new short[1] ;
      P00893_n1598EstadoSitRevista = new boolean[] {false} ;
      P00893_A1220SitAbsorbeFer = new boolean[] {false} ;
      P00893_A916SitEsAusencia = new boolean[] {false} ;
      P00893_A739SitLicCuentaTrab = new boolean[] {false} ;
      P00893_A738SitEsLicencia = new boolean[] {false} ;
      P00893_A16SitCodigo = new String[] {""} ;
      P00894_A1600EstadoSiniestro = new String[] {""} ;
      P00894_n1600EstadoSiniestro = new boolean[] {false} ;
      P00894_A1593SitPaiCod = new short[1] ;
      P00894_n1593SitPaiCod = new boolean[] {false} ;
      P00894_A1809EstadoRemCorr = new boolean[] {false} ;
      P00894_A1807EstadoCanPresen = new boolean[] {false} ;
      P00894_A1598EstadoSitRevista = new short[1] ;
      P00894_n1598EstadoSitRevista = new boolean[] {false} ;
      P00894_A1220SitAbsorbeFer = new boolean[] {false} ;
      P00894_A916SitEsAusencia = new boolean[] {false} ;
      P00894_A739SitLicCuentaTrab = new boolean[] {false} ;
      P00894_A738SitEsLicencia = new boolean[] {false} ;
      P00894_A334SitDescrip = new String[] {""} ;
      P00894_A16SitCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estadowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00892_A1593SitPaiCod, P00892_n1593SitPaiCod, P00892_A1809EstadoRemCorr, P00892_A1807EstadoCanPresen, P00892_A1600EstadoSiniestro, P00892_n1600EstadoSiniestro, P00892_A1598EstadoSitRevista, P00892_n1598EstadoSitRevista, P00892_A1220SitAbsorbeFer, P00892_A916SitEsAusencia,
            P00892_A739SitLicCuentaTrab, P00892_A738SitEsLicencia, P00892_A334SitDescrip, P00892_A16SitCodigo
            }
            , new Object[] {
            P00893_A334SitDescrip, P00893_A1593SitPaiCod, P00893_n1593SitPaiCod, P00893_A1809EstadoRemCorr, P00893_A1807EstadoCanPresen, P00893_A1600EstadoSiniestro, P00893_n1600EstadoSiniestro, P00893_A1598EstadoSitRevista, P00893_n1598EstadoSitRevista, P00893_A1220SitAbsorbeFer,
            P00893_A916SitEsAusencia, P00893_A739SitLicCuentaTrab, P00893_A738SitEsLicencia, P00893_A16SitCodigo
            }
            , new Object[] {
            P00894_A1600EstadoSiniestro, P00894_n1600EstadoSiniestro, P00894_A1593SitPaiCod, P00894_n1593SitPaiCod, P00894_A1809EstadoRemCorr, P00894_A1807EstadoCanPresen, P00894_A1598EstadoSitRevista, P00894_n1598EstadoSitRevista, P00894_A1220SitAbsorbeFer, P00894_A916SitEsAusencia,
            P00894_A739SitLicCuentaTrab, P00894_A738SitEsLicencia, P00894_A334SitDescrip, P00894_A16SitCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV40TFSitEsLicencia_Sel ;
   private byte AV41TFSitLicCuentaTrab_Sel ;
   private byte AV48TFSitEsAusencia_Sel ;
   private byte AV49TFSitAbsorbeFer_Sel ;
   private byte AV56TFEstadoCanPresen_Sel ;
   private byte AV57TFEstadoRemCorr_Sel ;
   private byte AV67Estadowwds_5_tfsiteslicencia_sel ;
   private byte AV68Estadowwds_6_tfsitliccuentatrab_sel ;
   private byte AV69Estadowwds_7_tfsitesausencia_sel ;
   private byte AV70Estadowwds_8_tfsitabsorbefer_sel ;
   private byte AV75Estadowwds_13_tfestadocanpresen_sel ;
   private byte AV76Estadowwds_14_tfestadoremcorr_sel ;
   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV50TFEstadoSitRevista ;
   private short AV51TFEstadoSitRevista_To ;
   private short AV71Estadowwds_9_tfestadositrevista ;
   private short AV72Estadowwds_10_tfestadositrevista_to ;
   private short AV55PaiCod ;
   private short A1598EstadoSitRevista ;
   private short A1593SitPaiCod ;
   private short Gx_err ;
   private int AV35CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV61GXV1 ;
   private int AV64Estadowwds_2_tfsitcodigo_sels_size ;
   private int AV66Estadowwds_4_tfsitdescrip_sels_size ;
   private int AV74Estadowwds_12_tfestadosiniestro_sels_size ;
   private long AV26count ;
   private String AV10TFSitCodigo ;
   private String AV53TFEstadoSiniestro ;
   private String A16SitCodigo ;
   private String AV63Estadowwds_1_tfsitcodigo ;
   private String AV73Estadowwds_11_tfestadosiniestro ;
   private String scmdbuf ;
   private String lV63Estadowwds_1_tfsitcodigo ;
   private String lV73Estadowwds_11_tfestadosiniestro ;
   private String A1600EstadoSiniestro ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A738SitEsLicencia ;
   private boolean A739SitLicCuentaTrab ;
   private boolean A916SitEsAusencia ;
   private boolean A1220SitAbsorbeFer ;
   private boolean A1807EstadoCanPresen ;
   private boolean A1809EstadoRemCorr ;
   private boolean n1593SitPaiCod ;
   private boolean n1600EstadoSiniestro ;
   private boolean n1598EstadoSitRevista ;
   private boolean brk893 ;
   private boolean brk895 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV38TFSitCodigo_SelsJson ;
   private String AV33TFSitDescrip_SelsJson ;
   private String AV52TFEstadoSiniestro_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV12TFSitDescrip ;
   private String AV58MenuOpcCod ;
   private String AV65Estadowwds_3_tfsitdescrip ;
   private String lV65Estadowwds_3_tfsitdescrip ;
   private String A334SitDescrip ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00892_A1593SitPaiCod ;
   private boolean[] P00892_n1593SitPaiCod ;
   private boolean[] P00892_A1809EstadoRemCorr ;
   private boolean[] P00892_A1807EstadoCanPresen ;
   private String[] P00892_A1600EstadoSiniestro ;
   private boolean[] P00892_n1600EstadoSiniestro ;
   private short[] P00892_A1598EstadoSitRevista ;
   private boolean[] P00892_n1598EstadoSitRevista ;
   private boolean[] P00892_A1220SitAbsorbeFer ;
   private boolean[] P00892_A916SitEsAusencia ;
   private boolean[] P00892_A739SitLicCuentaTrab ;
   private boolean[] P00892_A738SitEsLicencia ;
   private String[] P00892_A334SitDescrip ;
   private String[] P00892_A16SitCodigo ;
   private String[] P00893_A334SitDescrip ;
   private short[] P00893_A1593SitPaiCod ;
   private boolean[] P00893_n1593SitPaiCod ;
   private boolean[] P00893_A1809EstadoRemCorr ;
   private boolean[] P00893_A1807EstadoCanPresen ;
   private String[] P00893_A1600EstadoSiniestro ;
   private boolean[] P00893_n1600EstadoSiniestro ;
   private short[] P00893_A1598EstadoSitRevista ;
   private boolean[] P00893_n1598EstadoSitRevista ;
   private boolean[] P00893_A1220SitAbsorbeFer ;
   private boolean[] P00893_A916SitEsAusencia ;
   private boolean[] P00893_A739SitLicCuentaTrab ;
   private boolean[] P00893_A738SitEsLicencia ;
   private String[] P00893_A16SitCodigo ;
   private String[] P00894_A1600EstadoSiniestro ;
   private boolean[] P00894_n1600EstadoSiniestro ;
   private short[] P00894_A1593SitPaiCod ;
   private boolean[] P00894_n1593SitPaiCod ;
   private boolean[] P00894_A1809EstadoRemCorr ;
   private boolean[] P00894_A1807EstadoCanPresen ;
   private short[] P00894_A1598EstadoSitRevista ;
   private boolean[] P00894_n1598EstadoSitRevista ;
   private boolean[] P00894_A1220SitAbsorbeFer ;
   private boolean[] P00894_A916SitEsAusencia ;
   private boolean[] P00894_A739SitLicCuentaTrab ;
   private boolean[] P00894_A738SitEsLicencia ;
   private String[] P00894_A334SitDescrip ;
   private String[] P00894_A16SitCodigo ;
   private GXSimpleCollection<String> AV39TFSitCodigo_Sels ;
   private GXSimpleCollection<String> AV54TFEstadoSiniestro_Sels ;
   private GXSimpleCollection<String> AV64Estadowwds_2_tfsitcodigo_sels ;
   private GXSimpleCollection<String> AV74Estadowwds_12_tfestadosiniestro_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV34TFSitDescrip_Sels ;
   private GXSimpleCollection<String> AV66Estadowwds_4_tfsitdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
}

final  class estadowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00892( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A16SitCodigo ,
                                          GXSimpleCollection<String> AV64Estadowwds_2_tfsitcodigo_sels ,
                                          String A334SitDescrip ,
                                          GXSimpleCollection<String> AV66Estadowwds_4_tfsitdescrip_sels ,
                                          String A1600EstadoSiniestro ,
                                          GXSimpleCollection<String> AV74Estadowwds_12_tfestadosiniestro_sels ,
                                          int AV64Estadowwds_2_tfsitcodigo_sels_size ,
                                          String AV63Estadowwds_1_tfsitcodigo ,
                                          int AV66Estadowwds_4_tfsitdescrip_sels_size ,
                                          String AV65Estadowwds_3_tfsitdescrip ,
                                          byte AV67Estadowwds_5_tfsiteslicencia_sel ,
                                          byte AV68Estadowwds_6_tfsitliccuentatrab_sel ,
                                          byte AV69Estadowwds_7_tfsitesausencia_sel ,
                                          byte AV70Estadowwds_8_tfsitabsorbefer_sel ,
                                          short AV71Estadowwds_9_tfestadositrevista ,
                                          short AV72Estadowwds_10_tfestadositrevista_to ,
                                          int AV74Estadowwds_12_tfestadosiniestro_sels_size ,
                                          String AV73Estadowwds_11_tfestadosiniestro ,
                                          byte AV75Estadowwds_13_tfestadocanpresen_sel ,
                                          byte AV76Estadowwds_14_tfestadoremcorr_sel ,
                                          short AV55PaiCod ,
                                          boolean A738SitEsLicencia ,
                                          boolean A739SitLicCuentaTrab ,
                                          boolean A916SitEsAusencia ,
                                          boolean A1220SitAbsorbeFer ,
                                          short A1598EstadoSitRevista ,
                                          boolean A1807EstadoCanPresen ,
                                          boolean A1809EstadoRemCorr ,
                                          short A1593SitPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS SitPaiCod, NULL AS EstadoRemCorr, NULL AS EstadoCanPresen, NULL AS EstadoSiniestro, NULL AS EstadoSitRevista, NULL AS SitAbsorbeFer, NULL" ;
      scmdbuf += " AS SitEsAusencia, NULL AS SitLicCuentaTrab, NULL AS SitEsLicencia, NULL AS SitDescrip, SitCodigo FROM ( SELECT SitPaiCod, EstadoRemCorr, EstadoCanPresen, EstadoSiniestro," ;
      scmdbuf += " EstadoSitRevista, SitAbsorbeFer, SitEsAusencia, SitLicCuentaTrab, SitEsLicencia, SitDescrip, SitCodigo FROM Estado" ;
      if ( ( AV64Estadowwds_2_tfsitcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Estadowwds_1_tfsitcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV64Estadowwds_2_tfsitcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Estadowwds_2_tfsitcodigo_sels, "SitCodigo IN (", ")")+")");
      }
      if ( ( AV66Estadowwds_4_tfsitdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Estadowwds_3_tfsitdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV66Estadowwds_4_tfsitdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Estadowwds_4_tfsitdescrip_sels, "SitDescrip IN (", ")")+")");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsLicencia = TRUE)");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsLicencia = FALSE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 1 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = TRUE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 2 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = FALSE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsAusencia = TRUE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsAusencia = FALSE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 1 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = TRUE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 2 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = FALSE)");
      }
      if ( ! (0==AV71Estadowwds_9_tfestadositrevista) )
      {
         addWhere(sWhereString, "(EstadoSitRevista >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Estadowwds_10_tfestadositrevista_to) )
      {
         addWhere(sWhereString, "(EstadoSitRevista <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV74Estadowwds_12_tfestadosiniestro_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Estadowwds_11_tfestadosiniestro)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstadoSiniestro) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV74Estadowwds_12_tfestadosiniestro_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Estadowwds_12_tfestadosiniestro_sels, "EstadoSiniestro IN (", ")")+")");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = TRUE)");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = FALSE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = TRUE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = FALSE)");
      }
      if ( ! (0==AV55PaiCod) )
      {
         addWhere(sWhereString, "(SitPaiCod = ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitCodigo" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY SitCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00893( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A16SitCodigo ,
                                          GXSimpleCollection<String> AV64Estadowwds_2_tfsitcodigo_sels ,
                                          String A334SitDescrip ,
                                          GXSimpleCollection<String> AV66Estadowwds_4_tfsitdescrip_sels ,
                                          String A1600EstadoSiniestro ,
                                          GXSimpleCollection<String> AV74Estadowwds_12_tfestadosiniestro_sels ,
                                          int AV64Estadowwds_2_tfsitcodigo_sels_size ,
                                          String AV63Estadowwds_1_tfsitcodigo ,
                                          int AV66Estadowwds_4_tfsitdescrip_sels_size ,
                                          String AV65Estadowwds_3_tfsitdescrip ,
                                          byte AV67Estadowwds_5_tfsiteslicencia_sel ,
                                          byte AV68Estadowwds_6_tfsitliccuentatrab_sel ,
                                          byte AV69Estadowwds_7_tfsitesausencia_sel ,
                                          byte AV70Estadowwds_8_tfsitabsorbefer_sel ,
                                          short AV71Estadowwds_9_tfestadositrevista ,
                                          short AV72Estadowwds_10_tfestadositrevista_to ,
                                          int AV74Estadowwds_12_tfestadosiniestro_sels_size ,
                                          String AV73Estadowwds_11_tfestadosiniestro ,
                                          byte AV75Estadowwds_13_tfestadocanpresen_sel ,
                                          byte AV76Estadowwds_14_tfestadoremcorr_sel ,
                                          short AV55PaiCod ,
                                          boolean A738SitEsLicencia ,
                                          boolean A739SitLicCuentaTrab ,
                                          boolean A916SitEsAusencia ,
                                          boolean A1220SitAbsorbeFer ,
                                          short A1598EstadoSitRevista ,
                                          boolean A1807EstadoCanPresen ,
                                          boolean A1809EstadoRemCorr ,
                                          short A1593SitPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT SitDescrip, SitPaiCod, EstadoRemCorr, EstadoCanPresen, EstadoSiniestro, EstadoSitRevista, SitAbsorbeFer, SitEsAusencia, SitLicCuentaTrab, SitEsLicencia, SitCodigo" ;
      scmdbuf += " FROM Estado" ;
      if ( ( AV64Estadowwds_2_tfsitcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Estadowwds_1_tfsitcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV64Estadowwds_2_tfsitcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Estadowwds_2_tfsitcodigo_sels, "SitCodigo IN (", ")")+")");
      }
      if ( ( AV66Estadowwds_4_tfsitdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Estadowwds_3_tfsitdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV66Estadowwds_4_tfsitdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Estadowwds_4_tfsitdescrip_sels, "SitDescrip IN (", ")")+")");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsLicencia = TRUE)");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsLicencia = FALSE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 1 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = TRUE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 2 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = FALSE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsAusencia = TRUE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsAusencia = FALSE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 1 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = TRUE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 2 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = FALSE)");
      }
      if ( ! (0==AV71Estadowwds_9_tfestadositrevista) )
      {
         addWhere(sWhereString, "(EstadoSitRevista >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Estadowwds_10_tfestadositrevista_to) )
      {
         addWhere(sWhereString, "(EstadoSitRevista <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV74Estadowwds_12_tfestadosiniestro_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Estadowwds_11_tfestadosiniestro)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstadoSiniestro) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV74Estadowwds_12_tfestadosiniestro_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Estadowwds_12_tfestadosiniestro_sels, "EstadoSiniestro IN (", ")")+")");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = TRUE)");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = FALSE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = TRUE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = FALSE)");
      }
      if ( ! (0==AV55PaiCod) )
      {
         addWhere(sWhereString, "(SitPaiCod = ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P00894( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A16SitCodigo ,
                                          GXSimpleCollection<String> AV64Estadowwds_2_tfsitcodigo_sels ,
                                          String A334SitDescrip ,
                                          GXSimpleCollection<String> AV66Estadowwds_4_tfsitdescrip_sels ,
                                          String A1600EstadoSiniestro ,
                                          GXSimpleCollection<String> AV74Estadowwds_12_tfestadosiniestro_sels ,
                                          int AV64Estadowwds_2_tfsitcodigo_sels_size ,
                                          String AV63Estadowwds_1_tfsitcodigo ,
                                          int AV66Estadowwds_4_tfsitdescrip_sels_size ,
                                          String AV65Estadowwds_3_tfsitdescrip ,
                                          byte AV67Estadowwds_5_tfsiteslicencia_sel ,
                                          byte AV68Estadowwds_6_tfsitliccuentatrab_sel ,
                                          byte AV69Estadowwds_7_tfsitesausencia_sel ,
                                          byte AV70Estadowwds_8_tfsitabsorbefer_sel ,
                                          short AV71Estadowwds_9_tfestadositrevista ,
                                          short AV72Estadowwds_10_tfestadositrevista_to ,
                                          int AV74Estadowwds_12_tfestadosiniestro_sels_size ,
                                          String AV73Estadowwds_11_tfestadosiniestro ,
                                          byte AV75Estadowwds_13_tfestadocanpresen_sel ,
                                          byte AV76Estadowwds_14_tfestadoremcorr_sel ,
                                          short AV55PaiCod ,
                                          boolean A738SitEsLicencia ,
                                          boolean A739SitLicCuentaTrab ,
                                          boolean A916SitEsAusencia ,
                                          boolean A1220SitAbsorbeFer ,
                                          short A1598EstadoSitRevista ,
                                          boolean A1807EstadoCanPresen ,
                                          boolean A1809EstadoRemCorr ,
                                          short A1593SitPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT EstadoSiniestro, SitPaiCod, EstadoRemCorr, EstadoCanPresen, EstadoSitRevista, SitAbsorbeFer, SitEsAusencia, SitLicCuentaTrab, SitEsLicencia, SitDescrip, SitCodigo" ;
      scmdbuf += " FROM Estado" ;
      if ( ( AV64Estadowwds_2_tfsitcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Estadowwds_1_tfsitcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV64Estadowwds_2_tfsitcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Estadowwds_2_tfsitcodigo_sels, "SitCodigo IN (", ")")+")");
      }
      if ( ( AV66Estadowwds_4_tfsitdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Estadowwds_3_tfsitdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV66Estadowwds_4_tfsitdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Estadowwds_4_tfsitdescrip_sels, "SitDescrip IN (", ")")+")");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsLicencia = TRUE)");
      }
      if ( AV67Estadowwds_5_tfsiteslicencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsLicencia = FALSE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 1 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = TRUE)");
      }
      if ( AV68Estadowwds_6_tfsitliccuentatrab_sel == 2 )
      {
         addWhere(sWhereString, "(SitLicCuentaTrab = FALSE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 1 )
      {
         addWhere(sWhereString, "(SitEsAusencia = TRUE)");
      }
      if ( AV69Estadowwds_7_tfsitesausencia_sel == 2 )
      {
         addWhere(sWhereString, "(SitEsAusencia = FALSE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 1 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = TRUE)");
      }
      if ( AV70Estadowwds_8_tfsitabsorbefer_sel == 2 )
      {
         addWhere(sWhereString, "(SitAbsorbeFer = FALSE)");
      }
      if ( ! (0==AV71Estadowwds_9_tfestadositrevista) )
      {
         addWhere(sWhereString, "(EstadoSitRevista >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (0==AV72Estadowwds_10_tfestadositrevista_to) )
      {
         addWhere(sWhereString, "(EstadoSitRevista <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ( AV74Estadowwds_12_tfestadosiniestro_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Estadowwds_11_tfestadosiniestro)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EstadoSiniestro) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV74Estadowwds_12_tfestadosiniestro_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Estadowwds_12_tfestadosiniestro_sels, "EstadoSiniestro IN (", ")")+")");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = TRUE)");
      }
      if ( AV75Estadowwds_13_tfestadocanpresen_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoCanPresen = FALSE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 1 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = TRUE)");
      }
      if ( AV76Estadowwds_14_tfestadoremcorr_sel == 2 )
      {
         addWhere(sWhereString, "(EstadoRemCorr = FALSE)");
      }
      if ( ! (0==AV55PaiCod) )
      {
         addWhere(sWhereString, "(SitPaiCod = ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EstadoSiniestro" ;
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
                  return conditional_P00892(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).shortValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).shortValue() );
            case 1 :
                  return conditional_P00893(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).shortValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).shortValue() );
            case 2 :
                  return conditional_P00894(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).byteValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).shortValue() , ((Boolean) dynConstraints[21]).booleanValue() , ((Boolean) dynConstraints[22]).booleanValue() , ((Boolean) dynConstraints[23]).booleanValue() , ((Boolean) dynConstraints[24]).booleanValue() , ((Number) dynConstraints[25]).shortValue() , ((Boolean) dynConstraints[26]).booleanValue() , ((Boolean) dynConstraints[27]).booleanValue() , ((Number) dynConstraints[28]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00892", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00893", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00894", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((boolean[]) buf[2])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(9);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((boolean[]) buf[4])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(9);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((String[]) buf[13])[0] = rslt.getString(11, 4);
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
                  stmt.setString(sIdx, (String)parms[6], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               return;
      }
   }

}

