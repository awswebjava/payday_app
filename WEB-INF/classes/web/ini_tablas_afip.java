package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_tablas_afip extends GXProcedure
{
   public ini_tablas_afip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_tablas_afip.class ), "" );
   }

   public ini_tablas_afip( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "actividad 1", "")) ;
      AV25GXLvl4 = (byte)(0) ;
      /* Using cursor P01HW2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A43ActCodigo = P01HW2_A43ActCodigo[0] ;
         AV25GXLvl4 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "actividad 2", "")) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl4 == 0 )
      {
         GXv_char1[0] = AV14json ;
         new web.otros_desdearchivo(remoteHandle, context).execute( httpContext.getMessage( "actividad", ""), GXv_char1) ;
         ini_tablas_afip.this.AV14json = GXv_char1[0] ;
         AV15sdt_actividad.fromJSonString(AV14json, null);
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "actividad 3 &sdt_actividad ", "")+GXutil.trim( GXutil.str( AV15sdt_actividad.size(), 9, 0))) ;
         AV26GXV1 = 1 ;
         while ( AV26GXV1 <= AV15sdt_actividad.size() )
         {
            AV16itemAct = (web.Sdtsdt_actividad_sdt_actividadItem)((web.Sdtsdt_actividad_sdt_actividadItem)AV15sdt_actividad.elementAt(-1+AV26GXV1));
            /*
               INSERT RECORD ON TABLE Actividad

            */
            A43ActCodigo = AV16itemAct.getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actcodigo() ;
            A108ActDescrip = AV16itemAct.getgxTv_Sdtsdt_actividad_sdt_actividadItem_Actdescrip() ;
            GXt_char2 = A683ActDescripSinAc ;
            GXv_char1[0] = GXt_char2 ;
            new web.sacaracentos2(remoteHandle, context).execute( A108ActDescrip, GXv_char1) ;
            ini_tablas_afip.this.GXt_char2 = GXv_char1[0] ;
            A683ActDescripSinAc = GXutil.upper( GXt_char2) ;
            /* Using cursor P01HW3 */
            pr_default.execute(1, new Object[] {A43ActCodigo, A108ActDescrip, A683ActDescripSinAc});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Actividad");
            if ( (pr_default.getStatus(1) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            AV26GXV1 = (int)(AV26GXV1+1) ;
         }
      }
      AV27GXLvl21 = (byte)(0) ;
      /* Using cursor P01HW4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A18MprCod = P01HW4_A18MprCod[0] ;
         AV27GXLvl21 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV27GXLvl21 == 0 )
      {
         GXv_objcol_Sdtsdt_modprom_sdt_modpromItem3[0] = AV12sdt_modprom ;
         new web.ini_modprom(remoteHandle, context).execute( GXv_objcol_Sdtsdt_modprom_sdt_modpromItem3) ;
         AV12sdt_modprom = GXv_objcol_Sdtsdt_modprom_sdt_modpromItem3[0] ;
         AV28GXV2 = 1 ;
         while ( AV28GXV2 <= AV12sdt_modprom.size() )
         {
            AV13itemMod = (web.Sdtsdt_modprom_sdt_modpromItem)((web.Sdtsdt_modprom_sdt_modpromItem)AV12sdt_modprom.elementAt(-1+AV28GXV2));
            /*
               INSERT RECORD ON TABLE ModalidadAFIP

            */
            A18MprCod = GXutil.trim( AV13itemMod.getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprcod()) ;
            A303MprDescrip = GXutil.trim( AV13itemMod.getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip()) ;
            A304MprHabilitada = true ;
            if ( GXutil.strcmp(GXutil.trim( A18MprCod), "100") == 0 )
            {
               A305MprTasa = DecimalUtil.doubleToDec(100) ;
            }
            else
            {
               if ( ( GXutil.strcmp(GXutil.trim( A18MprCod), "050") == 0 ) || ( GXutil.strcmp(GXutil.trim( A18MprCod), httpContext.getMessage( "PR5", "")) == 0 ) )
               {
                  A305MprTasa = DecimalUtil.doubleToDec(50) ;
               }
               else
               {
                  A305MprTasa = DecimalUtil.doubleToDec(0) ;
               }
            }
            GXt_char2 = A684MprDescripSinAc ;
            GXv_char1[0] = GXt_char2 ;
            new web.sacaracentos2(remoteHandle, context).execute( A303MprDescrip, GXv_char1) ;
            ini_tablas_afip.this.GXt_char2 = GXv_char1[0] ;
            A684MprDescripSinAc = GXutil.upper( GXt_char2) ;
            if ( GXutil.strSearch( GXutil.upper( GXutil.trim( AV13itemMod.getgxTv_Sdtsdt_modprom_sdt_modpromItem_Mprdescrip())), httpContext.getMessage( "PARCIAL", ""), 1) != 0 )
            {
               A1024MprEsParcial = true ;
               A1353MprHorasExtras = false ;
            }
            else
            {
               A1024MprEsParcial = false ;
               A1353MprHorasExtras = true ;
            }
            if ( GXutil.strcmp(A18MprCod, "099") == 0 )
            {
               A1071MprNoDetrae = true ;
            }
            else
            {
               A1071MprNoDetrae = false ;
            }
            /* Using cursor P01HW5 */
            pr_default.execute(3, new Object[] {A18MprCod, A303MprDescrip, Boolean.valueOf(A304MprHabilitada), A305MprTasa, A684MprDescripSinAc, Boolean.valueOf(A1024MprEsParcial), Boolean.valueOf(A1071MprNoDetrae), Boolean.valueOf(A1353MprHorasExtras)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ModalidadAFIP");
            if ( (pr_default.getStatus(3) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            AV28GXV2 = (int)(AV28GXV2+1) ;
         }
      }
      AV29GXLvl58 = (byte)(0) ;
      /* Using cursor P01HW6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         A17CondiCodigo = P01HW6_A17CondiCodigo[0] ;
         AV29GXLvl58 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( AV29GXLvl58 == 0 )
      {
         GXt_objcol_SdtCondicionAFIP4 = AV10Condicion ;
         GXv_objcol_SdtCondicionAFIP5[0] = GXt_objcol_SdtCondicionAFIP4 ;
         new web.condicionafip_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtCondicionAFIP5) ;
         GXt_objcol_SdtCondicionAFIP4 = GXv_objcol_SdtCondicionAFIP5[0] ;
         AV10Condicion = GXt_objcol_SdtCondicionAFIP4 ;
         AV30GXV3 = 1 ;
         while ( AV30GXV3 <= AV10Condicion.size() )
         {
            AV11cond = (web.SdtCondicionAFIP)((web.SdtCondicionAFIP)AV10Condicion.elementAt(-1+AV30GXV3));
            if ( AV11cond.getgxTv_SdtCondicionAFIP_Condicodigo() != 0 )
            {
               AV11cond.Save();
               Application.commitDataStores(context, remoteHandle, pr_default, "ini_tablas_afip");
            }
            AV30GXV3 = (int)(AV30GXV3+1) ;
         }
      }
      AV31GXLvl74 = (byte)(0) ;
      /* Using cursor P01HW7 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         A45TipEmpleCod = P01HW7_A45TipEmpleCod[0] ;
         AV31GXLvl74 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(5);
      }
      pr_default.close(5);
      if ( AV31GXLvl74 == 0 )
      {
         AV33GXV5 = 1 ;
         AV32GXV4 = web.gxdomaintipoempl.getValues() ;
         while ( AV33GXV5 <= AV32GXV4.size() )
         {
            AV8TipoEmpl = (String)AV32GXV4.elementAt(-1+AV33GXV5) ;
            if ( ( GXutil.strcmp(AV8TipoEmpl, "1") == 0 ) || ( GXutil.strcmp(AV8TipoEmpl, "4") == 0 ) )
            {
               if ( GXutil.strcmp(AV8TipoEmpl, "1") == 0 )
               {
                  AV17TipEmpleCod = "1" ;
                  AV9TipEmpleDescri = httpContext.getMessage( "Otros (Inciso B)", "") ;
               }
               else
               {
                  AV17TipEmpleCod = "4" ;
                  AV9TipEmpleDescri = httpContext.getMessage( "Prestación de servicios de gran empresa (Inciso A)", "") ;
               }
               /*
                  INSERT RECORD ON TABLE TipoEmpleador

               */
               A45TipEmpleCod = AV17TipEmpleCod ;
               A339TipEmpleDescri = AV9TipEmpleDescri ;
               if ( GXutil.strSearch( GXutil.upper( A339TipEmpleDescri), httpContext.getMessage( "INCISO A", ""), 1) != 0 )
               {
                  A530TipEmpleDefIns = "A" ;
               }
               else
               {
                  A530TipEmpleDefIns = "B" ;
               }
               /* Using cursor P01HW8 */
               pr_default.execute(6, new Object[] {A45TipEmpleCod, A339TipEmpleDescri, A530TipEmpleDefIns});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoEmpleador");
               if ( (pr_default.getStatus(6) == 1) )
               {
                  Gx_err = (short)(1) ;
                  Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               }
               else
               {
                  Gx_err = (short)(0) ;
                  Gx_emsg = "" ;
               }
               /* End Insert */
            }
            AV33GXV5 = (int)(AV33GXV5+1) ;
         }
      }
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "0" ;
      A333SinieDescri = httpContext.getMessage( "No Siniestrado", "") ;
      GXv_char1[0] = AV21SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.AV21SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( AV21SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW9 */
      pr_default.execute(7, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(7) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "1" ;
      A333SinieDescri = httpContext.getMessage( "Incap. Laboral Temporaria (ILT)", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = true ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW10 */
      pr_default.execute(8, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(8) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "2" ;
      A333SinieDescri = httpContext.getMessage( "Incap. Laboral Perm. Parcial Provisoria (ILPPP)", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = true ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW11 */
      pr_default.execute(9, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(9) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "3" ;
      A333SinieDescri = httpContext.getMessage( "Incap. Laboral Perm. Parcial Definitiva (ILPPD)", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = true ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW12 */
      pr_default.execute(10, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(10) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "4" ;
      A333SinieDescri = httpContext.getMessage( "Incap. Laboral Perm. Total Provisoria (ILPTP)", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = true ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW13 */
      pr_default.execute(11, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(11) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "5" ;
      A333SinieDescri = httpContext.getMessage( "Cap. de Recomp. Punto 3. Art. 15 Ley Nro 24557", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW14 */
      pr_default.execute(12, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(12) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "6" ;
      A333SinieDescri = httpContext.getMessage( "Ajuste Definitivo ILPPD de Pago Mensual", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW15 */
      pr_default.execute(13, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(13) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "7" ;
      A333SinieDescri = httpContext.getMessage( "Renta Period. ILPPD Inc.Lab.Perm.Parc.Def. >50%<66%", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW16 */
      pr_default.execute(14, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(14) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "8" ;
      A333SinieDescri = httpContext.getMessage( "SRT/SSN F.Garantia/F.Reserva ILT Incap. Lab. Temp.", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW17 */
      pr_default.execute(15, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(15) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "9" ;
      A333SinieDescri = httpContext.getMessage( "SRT/SSN F.Gar./F.Res. ILPPP Inc Lab Perm Parc Temp", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW18 */
      pr_default.execute(16, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(16) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "10" ;
      A333SinieDescri = httpContext.getMessage( "SRT/SSN F.Gar./F.Res. ILPTP Inc Lab Perm Tot Temp", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW19 */
      pr_default.execute(17, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(17) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "11" ;
      A333SinieDescri = httpContext.getMessage( "SRT/SSN F.Gar./F.Res. ILPPD Inc Lab Perm Parc Def", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW20 */
      pr_default.execute(18, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(18) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "12" ;
      A333SinieDescri = httpContext.getMessage( "ILPPD Beneficios devengados art.11p.4", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW21 */
      pr_default.execute(19, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(19) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE Siniestrado

      */
      A19SinieCodigo = "13" ;
      A333SinieDescri = httpContext.getMessage( "INFORME Incremento salarial trabajador sin.a ART", "") ;
      GXv_char1[0] = A688SinieDescriSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( A333SinieDescri, GXv_char1) ;
      ini_tablas_afip.this.A688SinieDescriSinAc = GXv_char1[0] ;
      A688SinieDescriSinAc = GXutil.upper( A688SinieDescriSinAc) ;
      A1514SinieEsIncap = false ;
      n1514SinieEsIncap = false ;
      /* Using cursor P01HW22 */
      pr_default.execute(20, new Object[] {A19SinieCodigo, A333SinieDescri, A688SinieDescriSinAc, Boolean.valueOf(n1514SinieEsIncap), Boolean.valueOf(A1514SinieEsIncap)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Siniestrado");
      if ( (pr_default.getStatus(20) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      AV34GXLvl217 = (byte)(0) ;
      /* Using cursor P01HW23 */
      pr_default.execute(21);
      while ( (pr_default.getStatus(21) != 101) )
      {
         A1595SitRevCodigo = P01HW23_A1595SitRevCodigo[0] ;
         AV34GXLvl217 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(21);
      }
      pr_default.close(21);
      if ( AV34GXLvl217 == 0 )
      {
         GXv_char1[0] = AV14json ;
         new web.otros_desdearchivo(remoteHandle, context).execute( httpContext.getMessage( "situacionRevistaAfip", ""), GXv_char1) ;
         ini_tablas_afip.this.AV14json = GXv_char1[0] ;
         AV18sdt_situacion_revista_afip.fromJSonString(AV14json, null);
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "SituacionRevistaAFIP json ", "")+AV14json) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "SituacionRevistaAFIP sdt ", "")+GXutil.trim( AV19sdt_situacion.toJSonString(false))) ;
         AV35GXV6 = 1 ;
         while ( AV35GXV6 <= AV18sdt_situacion_revista_afip.size() )
         {
            AV20itemSituacionRev = (web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem)((web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem)AV18sdt_situacion_revista_afip.elementAt(-1+AV35GXV6));
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "situacionrevista insert 1", "")) ;
            /*
               INSERT RECORD ON TABLE SituacionRevistaAFIP

            */
            A1595SitRevCodigo = AV20itemSituacionRev.getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevcodigo() ;
            A1596SitRevDescrip = AV20itemSituacionRev.getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevdescrip() ;
            A1597SitRevEsBaja = AV20itemSituacionRev.getgxTv_Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem_Sitrevesbaja() ;
            /* Using cursor P01HW24 */
            pr_default.execute(22, new Object[] {Short.valueOf(A1595SitRevCodigo), A1596SitRevDescrip, Boolean.valueOf(A1597SitRevEsBaja)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("SituacionRevistaAFIP");
            if ( (pr_default.getStatus(22) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "situacionrevista insert 2", "")) ;
            AV35GXV6 = (int)(AV35GXV6+1) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_tablas_afip");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24Pgmname = "" ;
      scmdbuf = "" ;
      P01HW2_A43ActCodigo = new String[] {""} ;
      A43ActCodigo = "" ;
      AV14json = "" ;
      AV15sdt_actividad = new GXBaseCollection<web.Sdtsdt_actividad_sdt_actividadItem>(web.Sdtsdt_actividad_sdt_actividadItem.class, "sdt_actividadItem", "PayDay", remoteHandle);
      AV16itemAct = new web.Sdtsdt_actividad_sdt_actividadItem(remoteHandle, context);
      A108ActDescrip = "" ;
      A683ActDescripSinAc = "" ;
      Gx_emsg = "" ;
      P01HW4_A18MprCod = new String[] {""} ;
      A18MprCod = "" ;
      AV12sdt_modprom = new GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem>(web.Sdtsdt_modprom_sdt_modpromItem.class, "sdt_modpromItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_modprom_sdt_modpromItem3 = new GXBaseCollection[1] ;
      AV13itemMod = new web.Sdtsdt_modprom_sdt_modpromItem(remoteHandle, context);
      A303MprDescrip = "" ;
      A305MprTasa = DecimalUtil.ZERO ;
      A684MprDescripSinAc = "" ;
      GXt_char2 = "" ;
      P01HW6_A17CondiCodigo = new short[1] ;
      AV10Condicion = new GXBCCollection<web.SdtCondicionAFIP>(web.SdtCondicionAFIP.class, "CondicionAFIP", "PayDay", remoteHandle);
      GXt_objcol_SdtCondicionAFIP4 = new GXBCCollection<web.SdtCondicionAFIP>(web.SdtCondicionAFIP.class, "CondicionAFIP", "PayDay", remoteHandle);
      GXv_objcol_SdtCondicionAFIP5 = new GXBCCollection[1] ;
      AV11cond = new web.SdtCondicionAFIP(remoteHandle);
      P01HW7_A45TipEmpleCod = new String[] {""} ;
      A45TipEmpleCod = "" ;
      AV32GXV4 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV8TipoEmpl = "" ;
      AV17TipEmpleCod = "" ;
      AV9TipEmpleDescri = "" ;
      A339TipEmpleDescri = "" ;
      A530TipEmpleDefIns = "" ;
      A19SinieCodigo = "" ;
      A333SinieDescri = "" ;
      AV21SinieDescriSinAc = "" ;
      A688SinieDescriSinAc = "" ;
      P01HW23_A1595SitRevCodigo = new short[1] ;
      GXv_char1 = new String[1] ;
      AV18sdt_situacion_revista_afip = new GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem>(web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem.class, "sdt_situacion_revista_afipItem", "PayDay", remoteHandle);
      AV19sdt_situacion = new GXBaseCollection<web.Sdtsdt_situacion_sdt_situacionItem>(web.Sdtsdt_situacion_sdt_situacionItem.class, "sdt_situacionItem", "PayDay", remoteHandle);
      AV20itemSituacionRev = new web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem(remoteHandle, context);
      A1596SitRevDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_tablas_afip__default(),
         new Object[] {
             new Object[] {
            P01HW2_A43ActCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P01HW4_A18MprCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01HW6_A17CondiCodigo
            }
            , new Object[] {
            P01HW7_A45TipEmpleCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P01HW23_A1595SitRevCodigo
            }
            , new Object[] {
            }
         }
      );
      AV24Pgmname = "ini_tablas_afip" ;
      /* GeneXus formulas. */
      AV24Pgmname = "ini_tablas_afip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl4 ;
   private byte AV27GXLvl21 ;
   private byte AV29GXLvl58 ;
   private byte AV31GXLvl74 ;
   private byte AV34GXLvl217 ;
   private short Gx_err ;
   private short A17CondiCodigo ;
   private short A1595SitRevCodigo ;
   private int AV26GXV1 ;
   private int GX_INS1 ;
   private int AV28GXV2 ;
   private int GX_INS35 ;
   private int AV30GXV3 ;
   private int AV33GXV5 ;
   private int GX_INS70 ;
   private int GX_INS45 ;
   private int AV35GXV6 ;
   private int GX_INS219 ;
   private java.math.BigDecimal A305MprTasa ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private String Gx_emsg ;
   private String A18MprCod ;
   private String GXt_char2 ;
   private String A45TipEmpleCod ;
   private String AV8TipoEmpl ;
   private String AV17TipEmpleCod ;
   private String A530TipEmpleDefIns ;
   private String A19SinieCodigo ;
   private String GXv_char1[] ;
   private boolean A304MprHabilitada ;
   private boolean A1024MprEsParcial ;
   private boolean A1353MprHorasExtras ;
   private boolean A1071MprNoDetrae ;
   private boolean A1514SinieEsIncap ;
   private boolean n1514SinieEsIncap ;
   private boolean A1597SitRevEsBaja ;
   private String AV14json ;
   private String A108ActDescrip ;
   private String A683ActDescripSinAc ;
   private String A303MprDescrip ;
   private String A684MprDescripSinAc ;
   private String AV9TipEmpleDescri ;
   private String A339TipEmpleDescri ;
   private String A333SinieDescri ;
   private String AV21SinieDescriSinAc ;
   private String A688SinieDescriSinAc ;
   private String A1596SitRevDescrip ;
   private GXBaseCollection<web.Sdtsdt_situacion_sdt_situacionItem> AV19sdt_situacion ;
   private IDataStoreProvider pr_default ;
   private String[] P01HW2_A43ActCodigo ;
   private String[] P01HW4_A18MprCod ;
   private short[] P01HW6_A17CondiCodigo ;
   private String[] P01HW7_A45TipEmpleCod ;
   private short[] P01HW23_A1595SitRevCodigo ;
   private GXSimpleCollection<String> AV32GXV4 ;
   private GXBCCollection<web.SdtCondicionAFIP> AV10Condicion ;
   private GXBCCollection<web.SdtCondicionAFIP> GXt_objcol_SdtCondicionAFIP4 ;
   private GXBCCollection<web.SdtCondicionAFIP> GXv_objcol_SdtCondicionAFIP5[] ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> AV12sdt_modprom ;
   private GXBaseCollection<web.Sdtsdt_modprom_sdt_modpromItem> GXv_objcol_Sdtsdt_modprom_sdt_modpromItem3[] ;
   private GXBaseCollection<web.Sdtsdt_actividad_sdt_actividadItem> AV15sdt_actividad ;
   private GXBaseCollection<web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem> AV18sdt_situacion_revista_afip ;
   private web.SdtCondicionAFIP AV11cond ;
   private web.Sdtsdt_modprom_sdt_modpromItem AV13itemMod ;
   private web.Sdtsdt_actividad_sdt_actividadItem AV16itemAct ;
   private web.Sdtsdt_situacion_revista_afip_sdt_situacion_revista_afipItem AV20itemSituacionRev ;
}

final  class ini_tablas_afip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HW2", "SELECT ActCodigo FROM Actividad ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01HW3", "SAVEPOINT gxupdate;INSERT INTO Actividad(ActCodigo, ActDescrip, ActDescripSinAc) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HW4", "SELECT MprCod FROM ModalidadAFIP ORDER BY MprCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01HW5", "SAVEPOINT gxupdate;INSERT INTO ModalidadAFIP(MprCod, MprDescrip, MprHabilitada, MprTasa, MprDescripSinAc, MprEsParcial, MprNoDetrae, MprHorasExtras) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HW6", "SELECT CondiCodigo FROM CondicionAFIP ORDER BY CondiCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01HW7", "SELECT TipEmpleCod FROM TipoEmpleador ORDER BY TipEmpleCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01HW8", "SAVEPOINT gxupdate;INSERT INTO TipoEmpleador(TipEmpleCod, TipEmpleDescri, TipEmpleDefIns) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW9", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW10", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW11", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW12", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW13", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW14", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW15", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW16", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW17", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW18", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW19", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW20", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW21", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HW22", "SAVEPOINT gxupdate;INSERT INTO Siniestrado(SinieCodigo, SinieDescri, SinieDescriSinAc, SinieEsIncap) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01HW23", "SELECT SitRevCodigo FROM SituacionRevistaAFIP ORDER BY SitRevCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01HW24", "SAVEPOINT gxupdate;INSERT INTO SituacionRevistaAFIP(SitRevCodigo, SitRevDescrip, SitRevEsBaja) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setString(1, (String)parms[0], 8);
               stmt.setVarchar(2, (String)parms[1], 150, false);
               stmt.setVarchar(3, (String)parms[2], 150, false);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 1);
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 17 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               }
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               return;
      }
   }

}

