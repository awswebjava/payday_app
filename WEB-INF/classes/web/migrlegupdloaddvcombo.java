package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class migrlegupdloaddvcombo extends GXProcedure
{
   public migrlegupdloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( migrlegupdloaddvcombo.class ), "" );
   }

   public migrlegupdloaddvcombo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> executeUdp( String aP0 ,
                                                                                    String aP1 ,
                                                                                    int aP2 ,
                                                                                    short aP3 ,
                                                                                    int aP4 ,
                                                                                    String[] aP5 )
   {
      migrlegupdloaddvcombo.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        String[] aP5 ,
                        GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             String[] aP5 ,
                             GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 )
   {
      migrlegupdloaddvcombo.this.AV25ComboName = aP0;
      migrlegupdloaddvcombo.this.AV54TrnMode = aP1;
      migrlegupdloaddvcombo.this.AV20CliCod = aP2;
      migrlegupdloaddvcombo.this.AV27EmpCod = aP3;
      migrlegupdloaddvcombo.this.AV42MigrLegNumero = aP4;
      migrlegupdloaddvcombo.this.aP5 = aP5;
      migrlegupdloaddvcombo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV36MigrLegArea ;
      GXv_char2[0] = AV14MigrLegLugarDePago ;
      GXv_char3[0] = AV39MigrLegCategoria ;
      GXv_char4[0] = AV38MigrLegBanco ;
      GXv_char5[0] = AV44MigrLegSindicato ;
      GXv_char6[0] = AV15MigrLegObraSocial ;
      GXv_char7[0] = AV43MigrLegPlanMedico ;
      GXv_char8[0] = AV35MigrLegActividad ;
      GXv_char9[0] = AV41MigrLegModalidad ;
      GXv_char10[0] = AV47MigrLegZona ;
      GXv_char11[0] = AV46MigrLegSituacionRevista ;
      GXv_char12[0] = AV10MigrLegConvenio ;
      GXv_char13[0] = AV40MigrLegCondicion ;
      GXv_char14[0] = AV45MigrLegSiniestrado ;
      GXv_char15[0] = AV17MigrLegSexo ;
      GXv_char16[0] = AV60MigrLegModTra ;
      GXv_char17[0] = AV61MigrLegTipoTarifa ;
      GXv_char18[0] = AV9MigrLegClase ;
      GXv_char19[0] = AV12MigrLegEstadoCivil ;
      GXv_char20[0] = AV8MigrLegBanTipCuen ;
      GXv_char21[0] = AV11MigrLegDiscapacidad ;
      GXv_char22[0] = AV13MigrLegFormaPago ;
      GXv_char23[0] = AV16MigrLegSCVO ;
      GXv_char24[0] = AV18MigrTieneConyuge ;
      GXv_boolean25[0] = false ;
      GXv_boolean26[0] = false ;
      new web.getmigrdatos2(remoteHandle, context).execute( AV20CliCod, AV27EmpCod, AV42MigrLegNumero, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10, GXv_char11, GXv_char12, GXv_char13, GXv_char14, GXv_char15, GXv_char16, GXv_char17, GXv_char18, GXv_char19, GXv_char20, GXv_char21, GXv_char22, GXv_char23, GXv_char24, GXv_boolean25, GXv_boolean26) ;
      migrlegupdloaddvcombo.this.AV36MigrLegArea = GXv_char1[0] ;
      migrlegupdloaddvcombo.this.AV14MigrLegLugarDePago = GXv_char2[0] ;
      migrlegupdloaddvcombo.this.AV39MigrLegCategoria = GXv_char3[0] ;
      migrlegupdloaddvcombo.this.AV38MigrLegBanco = GXv_char4[0] ;
      migrlegupdloaddvcombo.this.AV44MigrLegSindicato = GXv_char5[0] ;
      migrlegupdloaddvcombo.this.AV15MigrLegObraSocial = GXv_char6[0] ;
      migrlegupdloaddvcombo.this.AV43MigrLegPlanMedico = GXv_char7[0] ;
      migrlegupdloaddvcombo.this.AV35MigrLegActividad = GXv_char8[0] ;
      migrlegupdloaddvcombo.this.AV41MigrLegModalidad = GXv_char9[0] ;
      migrlegupdloaddvcombo.this.AV47MigrLegZona = GXv_char10[0] ;
      migrlegupdloaddvcombo.this.AV46MigrLegSituacionRevista = GXv_char11[0] ;
      migrlegupdloaddvcombo.this.AV10MigrLegConvenio = GXv_char12[0] ;
      migrlegupdloaddvcombo.this.AV40MigrLegCondicion = GXv_char13[0] ;
      migrlegupdloaddvcombo.this.AV45MigrLegSiniestrado = GXv_char14[0] ;
      migrlegupdloaddvcombo.this.AV17MigrLegSexo = GXv_char15[0] ;
      migrlegupdloaddvcombo.this.AV60MigrLegModTra = GXv_char16[0] ;
      migrlegupdloaddvcombo.this.AV61MigrLegTipoTarifa = GXv_char17[0] ;
      migrlegupdloaddvcombo.this.AV9MigrLegClase = GXv_char18[0] ;
      migrlegupdloaddvcombo.this.AV12MigrLegEstadoCivil = GXv_char19[0] ;
      migrlegupdloaddvcombo.this.AV8MigrLegBanTipCuen = GXv_char20[0] ;
      migrlegupdloaddvcombo.this.AV11MigrLegDiscapacidad = GXv_char21[0] ;
      migrlegupdloaddvcombo.this.AV13MigrLegFormaPago = GXv_char22[0] ;
      migrlegupdloaddvcombo.this.AV16MigrLegSCVO = GXv_char23[0] ;
      migrlegupdloaddvcombo.this.AV18MigrTieneConyuge = GXv_char24[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&ComboName ", "")+AV25ComboName) ;
      GXt_boolean27 = AV32IsAuthorized ;
      GXv_boolean26[0] = GXt_boolean27 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMigrLegUPD", GXv_boolean26) ;
      migrlegupdloaddvcombo.this.GXt_boolean27 = GXv_boolean26[0] ;
      AV32IsAuthorized = GXt_boolean27 ;
      if ( AV32IsAuthorized )
      {
         GXv_SdtWWPContext28[0] = AV56WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext28) ;
         AV56WWPContext = GXv_SdtWWPContext28[0] ;
         if ( GXutil.strcmp(AV25ComboName, "MigrLegSexo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGSEXO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegEstadoCivil") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGESTADOCIVIL' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegArea") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGAREA' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegSindicato") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGSINDICATO' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegConvenio") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGCONVENIO' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegCategoria") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGCATEGORIA' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegBanco") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGBANCO' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegObraSocial") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGOBRASOCIAL' */
            S191 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegModalidad") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGMODALIDAD' */
            S201 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegZona") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGZONA' */
            S211 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegActividad") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGACTIVIDAD' */
            S221 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV25ComboName, "MigrLegCondicion") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_MIGRLEGCONDICION' */
            S231 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGSEXO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Género", "") ;
      AV55valor = AV15MigrLegObraSocial ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      AV21Combo_Data.sort("Title");
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A87MigrLegNumero = P002X2_A87MigrLegNumero[0] ;
            A1EmpCod = P002X2_A1EmpCod[0] ;
            A3CliCod = P002X2_A3CliCod[0] ;
            A595MigrLegSexo = P002X2_A595MigrLegSexo[0] ;
            AV50SelectedValue = A595MigrLegSexo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
   }

   public void S131( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGESTADOCIVIL' Routine */
      returnInSub = false ;
      AV21Combo_Data.sort("Title");
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A87MigrLegNumero = P002X3_A87MigrLegNumero[0] ;
            A1EmpCod = P002X3_A1EmpCod[0] ;
            A3CliCod = P002X3_A3CliCod[0] ;
            A596MigrLegEstadoCivil = P002X3_A596MigrLegEstadoCivil[0] ;
            AV50SelectedValue = A596MigrLegEstadoCivil ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
   }

   public void S141( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGAREA' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Area", "") ;
      AV55valor = AV36MigrLegArea ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A87MigrLegNumero = P002X4_A87MigrLegNumero[0] ;
            A1EmpCod = P002X4_A1EmpCod[0] ;
            A3CliCod = P002X4_A3CliCod[0] ;
            A605MigrLegArea = P002X4_A605MigrLegArea[0] ;
            AV50SelectedValue = A605MigrLegArea ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(2);
      }
   }

   public void S151( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGSINDICATO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Sindicato", "") ;
      AV55valor = AV44MigrLegSindicato ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A87MigrLegNumero = P002X5_A87MigrLegNumero[0] ;
            A1EmpCod = P002X5_A1EmpCod[0] ;
            A3CliCod = P002X5_A3CliCod[0] ;
            A613MigrLegSindicato = P002X5_A613MigrLegSindicato[0] ;
            AV50SelectedValue = A613MigrLegSindicato ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
      }
   }

   public void S161( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGCONVENIO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Convenio", "") ;
      AV55valor = AV10MigrLegConvenio ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A87MigrLegNumero = P002X6_A87MigrLegNumero[0] ;
            A1EmpCod = P002X6_A1EmpCod[0] ;
            A3CliCod = P002X6_A3CliCod[0] ;
            A627MigrLegConvenio = P002X6_A627MigrLegConvenio[0] ;
            AV50SelectedValue = A627MigrLegConvenio ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
      }
   }

   public void S171( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGCATEGORIA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "LoadComboItems_MigrLegCategoria", "")) ;
      AV19campo = httpContext.getMessage( "Categoria", "") ;
      AV55valor = AV39MigrLegCategoria ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A87MigrLegNumero = P002X7_A87MigrLegNumero[0] ;
            A1EmpCod = P002X7_A1EmpCod[0] ;
            A3CliCod = P002X7_A3CliCod[0] ;
            A604MigrLegCategoria = P002X7_A604MigrLegCategoria[0] ;
            AV50SelectedValue = A604MigrLegCategoria ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(5);
      }
   }

   public void S181( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGBANCO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Banco", "") ;
      AV55valor = AV38MigrLegBanco ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A87MigrLegNumero = P002X8_A87MigrLegNumero[0] ;
            A1EmpCod = P002X8_A1EmpCod[0] ;
            A3CliCod = P002X8_A3CliCod[0] ;
            A610MigrLegBanco = P002X8_A610MigrLegBanco[0] ;
            AV50SelectedValue = A610MigrLegBanco ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(6);
      }
   }

   public void S191( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGOBRASOCIAL' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Obra Social", "") ;
      AV55valor = AV15MigrLegObraSocial ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A87MigrLegNumero = P002X9_A87MigrLegNumero[0] ;
            A1EmpCod = P002X9_A1EmpCod[0] ;
            A3CliCod = P002X9_A3CliCod[0] ;
            A614MigrLegObraSocial = P002X9_A614MigrLegObraSocial[0] ;
            AV50SelectedValue = A614MigrLegObraSocial ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(7);
      }
   }

   public void S201( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGMODALIDAD' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Modalidad", "") ;
      AV55valor = AV41MigrLegModalidad ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X10 */
         pr_default.execute(8, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(8) != 101) )
         {
            A87MigrLegNumero = P002X10_A87MigrLegNumero[0] ;
            A1EmpCod = P002X10_A1EmpCod[0] ;
            A3CliCod = P002X10_A3CliCod[0] ;
            A617MigrLegModalidad = P002X10_A617MigrLegModalidad[0] ;
            AV50SelectedValue = A617MigrLegModalidad ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(8);
      }
   }

   public void S211( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGZONA' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Zona", "") ;
      AV55valor = AV47MigrLegZona ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(9) != 101) )
         {
            A87MigrLegNumero = P002X11_A87MigrLegNumero[0] ;
            A1EmpCod = P002X11_A1EmpCod[0] ;
            A3CliCod = P002X11_A3CliCod[0] ;
            A620MigrLegZona = P002X11_A620MigrLegZona[0] ;
            AV50SelectedValue = A620MigrLegZona ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(9);
      }
   }

   public void S221( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGACTIVIDAD' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Actividad", "") ;
      AV55valor = AV35MigrLegActividad ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X12 */
         pr_default.execute(10, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(10) != 101) )
         {
            A87MigrLegNumero = P002X12_A87MigrLegNumero[0] ;
            A1EmpCod = P002X12_A1EmpCod[0] ;
            A3CliCod = P002X12_A3CliCod[0] ;
            A616MigrLegActividad = P002X12_A616MigrLegActividad[0] ;
            AV50SelectedValue = A616MigrLegActividad ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(10);
      }
   }

   public void S231( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGCONDICION' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Condicion", "") ;
      AV55valor = AV40MigrLegCondicion ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV54TrnMode, "INS") != 0 )
      {
         /* Using cursor P002X13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(AV20CliCod), Short.valueOf(AV27EmpCod), Integer.valueOf(AV42MigrLegNumero)});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A87MigrLegNumero = P002X13_A87MigrLegNumero[0] ;
            A1EmpCod = P002X13_A1EmpCod[0] ;
            A3CliCod = P002X13_A3CliCod[0] ;
            A624MigrLegCondicion = P002X13_A624MigrLegCondicion[0] ;
            AV50SelectedValue = A624MigrLegCondicion ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(11);
      }
   }

   public void S241( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGPLANMEDICO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Plan Medico", "") ;
      AV55valor = AV43MigrLegPlanMedico ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
   }

   public void S251( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGLUGARDEPAGO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Lugar de Pago", "") ;
      AV55valor = AV14MigrLegLugarDePago ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
   }

   public void S261( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGSITUACIONREVISTA' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Situacion", "") ;
      AV55valor = AV46MigrLegSituacionRevista ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
   }

   public void S271( )
   {
      /* 'LOADCOMBOITEMS_MIGRLEGSINIESTRADO' Routine */
      returnInSub = false ;
      AV19campo = httpContext.getMessage( "Siniestrado", "") ;
      AV55valor = AV45MigrLegSiniestrado ;
      /* Execute user subroutine: 'ARMAR COLECCIONES' */
      S121 ();
      if (returnInSub) return;
   }

   public void S121( )
   {
      /* 'ARMAR COLECCIONES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&campo ", "")+AV19campo) ;
      if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Categoria", "")) == 0 )
      {
         AV58dependenciaCodigo = AV59websession.getValue(httpContext.getMessage( "&SelectedValueMigrLegConvenio", "")) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "obtiene &dependenciaCodigo ", "")+AV58dependenciaCodigo) ;
      }
      else
      {
         AV58dependenciaCodigo = "" ;
      }
      GXv_objcol_char29[0] = AV52similares ;
      GXv_objcol_char30[0] = AV48otras ;
      GXv_char24[0] = AV53tituloVacio ;
      GXv_boolean26[0] = false ;
      GXv_char23[0] = "" ;
      GXv_boolean25[0] = AV29existe ;
      GXv_boolean31[0] = false ;
      new web.loadcombomigr2(remoteHandle, context).execute( AV20CliCod, AV27EmpCod, AV42MigrLegNumero, AV19campo, AV58dependenciaCodigo, AV55valor, GXv_objcol_char29, GXv_objcol_char30, GXv_char24, GXv_boolean26, GXv_char23, GXv_boolean25, GXv_boolean31) ;
      AV52similares = GXv_objcol_char29[0] ;
      AV48otras = GXv_objcol_char30[0] ;
      migrlegupdloaddvcombo.this.AV53tituloVacio = GXv_char24[0] ;
      migrlegupdloaddvcombo.this.AV29existe = GXv_boolean25[0] ;
      if ( ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Modalidad", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Actividad", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Situacion", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Condicion", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Siniestrado", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Zona", "")) != 0 ) && ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Género", "")) != 0 ) )
      {
         if ( ! (GXutil.strcmp("", AV53tituloVacio)==0) )
         {
            AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( "" );
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( AV53tituloVacio) );
            AV21Combo_Data.add(AV22Combo_DataItem, 0);
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&valor ", "")+AV55valor) ;
      if ( ! (GXutil.strcmp("", AV55valor)==0) )
      {
         AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&existe ", "")+GXutil.trim( GXutil.booltostr( AV29existe))+httpContext.getMessage( " campo ", "")+AV19campo) ;
         if ( ! AV29existe && ( ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Modalidad", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Actividad", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Situacion", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Condicion", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Siniestrado", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Zona", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Género", "")) == 0 ) ) )
         {
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( AV55valor) );
            GXt_char32 = "" ;
            GXv_char24[0] = GXt_char32 ;
            new web.mensajemigrselvalida(remoteHandle, context).execute( AV20CliCod, GXv_char24) ;
            migrlegupdloaddvcombo.this.GXt_char32 = GXv_char24[0] ;
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXt_char32 );
            new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "agrega como no valido", "")) ;
         }
         else
         {
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( AV55valor) );
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( AV55valor) );
            new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "agrega como valido", "")) ;
         }
         AV21Combo_Data.add(AV22Combo_DataItem, 0);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&similares ", "")+AV52similares.toJSonString(false)) ;
      if ( AV52similares.size() > 0 )
      {
         AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( httpContext.getMessage( "Similares", "") );
         AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "Similares", "") );
         AV21Combo_Data.add(AV22Combo_DataItem, 0);
         AV31i = (short)(1) ;
         while ( AV31i <= AV52similares.size() )
         {
            AV34itemChildren = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV34itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV52similares.elementAt(-1+AV31i)) );
            AV34itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV52similares.elementAt(-1+AV31i)) );
            AV22Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV34itemChildren, 0);
            AV31i = (short)(AV31i+1) ;
         }
         if ( AV48otras.size() > 0 )
         {
            AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( httpContext.getMessage( "Otras", "") );
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( httpContext.getMessage( "Otras", "") );
            AV21Combo_Data.add(AV22Combo_DataItem, 0);
            AV31i = (short)(1) ;
            while ( AV31i <= AV48otras.size() )
            {
               AV34itemChildren = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
               AV34itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV48otras.elementAt(-1+AV31i)) );
               AV34itemChildren.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV48otras.elementAt(-1+AV31i)) );
               AV22Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().add(AV34itemChildren, 0);
               AV31i = (short)(AV31i+1) ;
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&otras ", "")+AV48otras.toJSonString(false)) ;
         AV31i = (short)(1) ;
         while ( AV31i <= AV48otras.size() )
         {
            AV22Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( (String)AV48otras.elementAt(-1+AV31i)) );
            AV22Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( GXutil.trim( (String)AV48otras.elementAt(-1+AV31i)) );
            AV22Combo_DataItem.getgxTv_SdtDVB_SDTComboData_Item_Children().clear();
            AV21Combo_Data.add(AV22Combo_DataItem, 0);
            AV31i = (short)(AV31i+1) ;
         }
      }
      AV31i = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&otras.Count ", "")+GXutil.trim( GXutil.str( AV48otras.size(), 9, 0))+httpContext.getMessage( " similares ", "")+GXutil.str( AV52similares.size(), 9, 0)) ;
   }

   protected void cleanup( )
   {
      this.aP5[0] = migrlegupdloaddvcombo.this.AV50SelectedValue;
      this.aP6[0] = migrlegupdloaddvcombo.this.AV21Combo_Data;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV50SelectedValue = "" ;
      AV21Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV36MigrLegArea = "" ;
      GXv_char1 = new String[1] ;
      AV14MigrLegLugarDePago = "" ;
      GXv_char2 = new String[1] ;
      AV39MigrLegCategoria = "" ;
      GXv_char3 = new String[1] ;
      AV38MigrLegBanco = "" ;
      GXv_char4 = new String[1] ;
      AV44MigrLegSindicato = "" ;
      GXv_char5 = new String[1] ;
      AV15MigrLegObraSocial = "" ;
      GXv_char6 = new String[1] ;
      AV43MigrLegPlanMedico = "" ;
      GXv_char7 = new String[1] ;
      AV35MigrLegActividad = "" ;
      GXv_char8 = new String[1] ;
      AV41MigrLegModalidad = "" ;
      GXv_char9 = new String[1] ;
      AV47MigrLegZona = "" ;
      GXv_char10 = new String[1] ;
      AV46MigrLegSituacionRevista = "" ;
      GXv_char11 = new String[1] ;
      AV10MigrLegConvenio = "" ;
      GXv_char12 = new String[1] ;
      AV40MigrLegCondicion = "" ;
      GXv_char13 = new String[1] ;
      AV45MigrLegSiniestrado = "" ;
      GXv_char14 = new String[1] ;
      AV17MigrLegSexo = "" ;
      GXv_char15 = new String[1] ;
      AV60MigrLegModTra = "" ;
      GXv_char16 = new String[1] ;
      AV61MigrLegTipoTarifa = "" ;
      GXv_char17 = new String[1] ;
      AV9MigrLegClase = "" ;
      GXv_char18 = new String[1] ;
      AV12MigrLegEstadoCivil = "" ;
      GXv_char19 = new String[1] ;
      AV8MigrLegBanTipCuen = "" ;
      GXv_char20 = new String[1] ;
      AV11MigrLegDiscapacidad = "" ;
      GXv_char21 = new String[1] ;
      AV13MigrLegFormaPago = "" ;
      GXv_char22 = new String[1] ;
      AV16MigrLegSCVO = "" ;
      AV18MigrTieneConyuge = "" ;
      AV64Pgmname = "" ;
      AV56WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext28 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV19campo = "" ;
      AV55valor = "" ;
      scmdbuf = "" ;
      P002X2_A87MigrLegNumero = new int[1] ;
      P002X2_A1EmpCod = new short[1] ;
      P002X2_A3CliCod = new int[1] ;
      P002X2_A595MigrLegSexo = new String[] {""} ;
      A595MigrLegSexo = "" ;
      P002X3_A87MigrLegNumero = new int[1] ;
      P002X3_A1EmpCod = new short[1] ;
      P002X3_A3CliCod = new int[1] ;
      P002X3_A596MigrLegEstadoCivil = new String[] {""} ;
      A596MigrLegEstadoCivil = "" ;
      P002X4_A87MigrLegNumero = new int[1] ;
      P002X4_A1EmpCod = new short[1] ;
      P002X4_A3CliCod = new int[1] ;
      P002X4_A605MigrLegArea = new String[] {""} ;
      A605MigrLegArea = "" ;
      P002X5_A87MigrLegNumero = new int[1] ;
      P002X5_A1EmpCod = new short[1] ;
      P002X5_A3CliCod = new int[1] ;
      P002X5_A613MigrLegSindicato = new String[] {""} ;
      A613MigrLegSindicato = "" ;
      P002X6_A87MigrLegNumero = new int[1] ;
      P002X6_A1EmpCod = new short[1] ;
      P002X6_A3CliCod = new int[1] ;
      P002X6_A627MigrLegConvenio = new String[] {""} ;
      A627MigrLegConvenio = "" ;
      P002X7_A87MigrLegNumero = new int[1] ;
      P002X7_A1EmpCod = new short[1] ;
      P002X7_A3CliCod = new int[1] ;
      P002X7_A604MigrLegCategoria = new String[] {""} ;
      A604MigrLegCategoria = "" ;
      P002X8_A87MigrLegNumero = new int[1] ;
      P002X8_A1EmpCod = new short[1] ;
      P002X8_A3CliCod = new int[1] ;
      P002X8_A610MigrLegBanco = new String[] {""} ;
      A610MigrLegBanco = "" ;
      P002X9_A87MigrLegNumero = new int[1] ;
      P002X9_A1EmpCod = new short[1] ;
      P002X9_A3CliCod = new int[1] ;
      P002X9_A614MigrLegObraSocial = new String[] {""} ;
      A614MigrLegObraSocial = "" ;
      P002X10_A87MigrLegNumero = new int[1] ;
      P002X10_A1EmpCod = new short[1] ;
      P002X10_A3CliCod = new int[1] ;
      P002X10_A617MigrLegModalidad = new String[] {""} ;
      A617MigrLegModalidad = "" ;
      P002X11_A87MigrLegNumero = new int[1] ;
      P002X11_A1EmpCod = new short[1] ;
      P002X11_A3CliCod = new int[1] ;
      P002X11_A620MigrLegZona = new String[] {""} ;
      A620MigrLegZona = "" ;
      P002X12_A87MigrLegNumero = new int[1] ;
      P002X12_A1EmpCod = new short[1] ;
      P002X12_A3CliCod = new int[1] ;
      P002X12_A616MigrLegActividad = new String[] {""} ;
      A616MigrLegActividad = "" ;
      P002X13_A87MigrLegNumero = new int[1] ;
      P002X13_A1EmpCod = new short[1] ;
      P002X13_A3CliCod = new int[1] ;
      P002X13_A624MigrLegCondicion = new String[] {""} ;
      A624MigrLegCondicion = "" ;
      AV58dependenciaCodigo = "" ;
      AV59websession = httpContext.getWebSession();
      AV52similares = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char29 = new GXSimpleCollection[1] ;
      AV48otras = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char30 = new GXSimpleCollection[1] ;
      AV53tituloVacio = "" ;
      GXv_boolean26 = new boolean[1] ;
      GXv_char23 = new String[1] ;
      GXv_boolean25 = new boolean[1] ;
      GXv_boolean31 = new boolean[1] ;
      AV22Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      GXt_char32 = "" ;
      GXv_char24 = new String[1] ;
      AV34itemChildren = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.migrlegupdloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002X2_A87MigrLegNumero, P002X2_A1EmpCod, P002X2_A3CliCod, P002X2_A595MigrLegSexo
            }
            , new Object[] {
            P002X3_A87MigrLegNumero, P002X3_A1EmpCod, P002X3_A3CliCod, P002X3_A596MigrLegEstadoCivil
            }
            , new Object[] {
            P002X4_A87MigrLegNumero, P002X4_A1EmpCod, P002X4_A3CliCod, P002X4_A605MigrLegArea
            }
            , new Object[] {
            P002X5_A87MigrLegNumero, P002X5_A1EmpCod, P002X5_A3CliCod, P002X5_A613MigrLegSindicato
            }
            , new Object[] {
            P002X6_A87MigrLegNumero, P002X6_A1EmpCod, P002X6_A3CliCod, P002X6_A627MigrLegConvenio
            }
            , new Object[] {
            P002X7_A87MigrLegNumero, P002X7_A1EmpCod, P002X7_A3CliCod, P002X7_A604MigrLegCategoria
            }
            , new Object[] {
            P002X8_A87MigrLegNumero, P002X8_A1EmpCod, P002X8_A3CliCod, P002X8_A610MigrLegBanco
            }
            , new Object[] {
            P002X9_A87MigrLegNumero, P002X9_A1EmpCod, P002X9_A3CliCod, P002X9_A614MigrLegObraSocial
            }
            , new Object[] {
            P002X10_A87MigrLegNumero, P002X10_A1EmpCod, P002X10_A3CliCod, P002X10_A617MigrLegModalidad
            }
            , new Object[] {
            P002X11_A87MigrLegNumero, P002X11_A1EmpCod, P002X11_A3CliCod, P002X11_A620MigrLegZona
            }
            , new Object[] {
            P002X12_A87MigrLegNumero, P002X12_A1EmpCod, P002X12_A3CliCod, P002X12_A616MigrLegActividad
            }
            , new Object[] {
            P002X13_A87MigrLegNumero, P002X13_A1EmpCod, P002X13_A3CliCod, P002X13_A624MigrLegCondicion
            }
         }
      );
      AV64Pgmname = "MigrLegUPDLoadDVCombo" ;
      /* GeneXus formulas. */
      AV64Pgmname = "MigrLegUPDLoadDVCombo" ;
      Gx_err = (short)(0) ;
   }

   private short AV27EmpCod ;
   private short A1EmpCod ;
   private short AV31i ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV42MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV54TrnMode ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private String GXv_char11[] ;
   private String GXv_char12[] ;
   private String GXv_char13[] ;
   private String GXv_char14[] ;
   private String AV17MigrLegSexo ;
   private String GXv_char15[] ;
   private String GXv_char16[] ;
   private String GXv_char17[] ;
   private String GXv_char18[] ;
   private String GXv_char19[] ;
   private String GXv_char20[] ;
   private String AV11MigrLegDiscapacidad ;
   private String GXv_char21[] ;
   private String GXv_char22[] ;
   private String AV16MigrLegSCVO ;
   private String AV18MigrTieneConyuge ;
   private String AV64Pgmname ;
   private String AV19campo ;
   private String scmdbuf ;
   private String A595MigrLegSexo ;
   private String AV58dependenciaCodigo ;
   private String AV53tituloVacio ;
   private String GXv_char23[] ;
   private String GXt_char32 ;
   private String GXv_char24[] ;
   private boolean AV32IsAuthorized ;
   private boolean GXt_boolean27 ;
   private boolean returnInSub ;
   private boolean GXv_boolean26[] ;
   private boolean AV29existe ;
   private boolean GXv_boolean25[] ;
   private boolean GXv_boolean31[] ;
   private String AV25ComboName ;
   private String AV50SelectedValue ;
   private String AV36MigrLegArea ;
   private String AV14MigrLegLugarDePago ;
   private String AV39MigrLegCategoria ;
   private String AV38MigrLegBanco ;
   private String AV44MigrLegSindicato ;
   private String AV15MigrLegObraSocial ;
   private String AV43MigrLegPlanMedico ;
   private String AV35MigrLegActividad ;
   private String AV41MigrLegModalidad ;
   private String AV47MigrLegZona ;
   private String AV46MigrLegSituacionRevista ;
   private String AV10MigrLegConvenio ;
   private String AV40MigrLegCondicion ;
   private String AV45MigrLegSiniestrado ;
   private String AV60MigrLegModTra ;
   private String AV61MigrLegTipoTarifa ;
   private String AV9MigrLegClase ;
   private String AV12MigrLegEstadoCivil ;
   private String AV8MigrLegBanTipCuen ;
   private String AV13MigrLegFormaPago ;
   private String AV55valor ;
   private String A596MigrLegEstadoCivil ;
   private String A605MigrLegArea ;
   private String A613MigrLegSindicato ;
   private String A627MigrLegConvenio ;
   private String A604MigrLegCategoria ;
   private String A610MigrLegBanco ;
   private String A614MigrLegObraSocial ;
   private String A617MigrLegModalidad ;
   private String A620MigrLegZona ;
   private String A616MigrLegActividad ;
   private String A624MigrLegCondicion ;
   private com.genexus.webpanels.WebSession AV59websession ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>[] aP6 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P002X2_A87MigrLegNumero ;
   private short[] P002X2_A1EmpCod ;
   private int[] P002X2_A3CliCod ;
   private String[] P002X2_A595MigrLegSexo ;
   private int[] P002X3_A87MigrLegNumero ;
   private short[] P002X3_A1EmpCod ;
   private int[] P002X3_A3CliCod ;
   private String[] P002X3_A596MigrLegEstadoCivil ;
   private int[] P002X4_A87MigrLegNumero ;
   private short[] P002X4_A1EmpCod ;
   private int[] P002X4_A3CliCod ;
   private String[] P002X4_A605MigrLegArea ;
   private int[] P002X5_A87MigrLegNumero ;
   private short[] P002X5_A1EmpCod ;
   private int[] P002X5_A3CliCod ;
   private String[] P002X5_A613MigrLegSindicato ;
   private int[] P002X6_A87MigrLegNumero ;
   private short[] P002X6_A1EmpCod ;
   private int[] P002X6_A3CliCod ;
   private String[] P002X6_A627MigrLegConvenio ;
   private int[] P002X7_A87MigrLegNumero ;
   private short[] P002X7_A1EmpCod ;
   private int[] P002X7_A3CliCod ;
   private String[] P002X7_A604MigrLegCategoria ;
   private int[] P002X8_A87MigrLegNumero ;
   private short[] P002X8_A1EmpCod ;
   private int[] P002X8_A3CliCod ;
   private String[] P002X8_A610MigrLegBanco ;
   private int[] P002X9_A87MigrLegNumero ;
   private short[] P002X9_A1EmpCod ;
   private int[] P002X9_A3CliCod ;
   private String[] P002X9_A614MigrLegObraSocial ;
   private int[] P002X10_A87MigrLegNumero ;
   private short[] P002X10_A1EmpCod ;
   private int[] P002X10_A3CliCod ;
   private String[] P002X10_A617MigrLegModalidad ;
   private int[] P002X11_A87MigrLegNumero ;
   private short[] P002X11_A1EmpCod ;
   private int[] P002X11_A3CliCod ;
   private String[] P002X11_A620MigrLegZona ;
   private int[] P002X12_A87MigrLegNumero ;
   private short[] P002X12_A1EmpCod ;
   private int[] P002X12_A3CliCod ;
   private String[] P002X12_A616MigrLegActividad ;
   private int[] P002X13_A87MigrLegNumero ;
   private short[] P002X13_A1EmpCod ;
   private int[] P002X13_A3CliCod ;
   private String[] P002X13_A624MigrLegCondicion ;
   private GXSimpleCollection<String> AV52similares ;
   private GXSimpleCollection<String> GXv_objcol_char29[] ;
   private GXSimpleCollection<String> AV48otras ;
   private GXSimpleCollection<String> GXv_objcol_char30[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21Combo_Data ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV22Combo_DataItem ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV34itemChildren ;
   private web.wwpbaseobjects.SdtWWPContext AV56WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext28[] ;
}

final  class migrlegupdloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002X2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegSexo FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X3", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegEstadoCivil FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X4", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegArea FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X5", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegSindicato FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X6", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegConvenio FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X7", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegCategoria FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X8", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegBanco FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X9", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegObraSocial FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X10", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegModalidad FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X11", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegZona FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X12", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegActividad FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002X13", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegCondicion FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

