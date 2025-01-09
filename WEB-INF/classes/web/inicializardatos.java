package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializardatos extends GXProcedure
{
   public inicializardatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializardatos.class ), "" );
   }

   public inicializardatos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        long aP2 ,
                        String aP3 ,
                        long aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        short aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        boolean aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             long aP2 ,
                             String aP3 ,
                             long aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             short aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             boolean aP12 )
   {
      inicializardatos.this.AV37SecUserId = aP0;
      inicializardatos.this.AV16CliNom = aP1;
      inicializardatos.this.AV14CliCUIT = aP2;
      inicializardatos.this.AV18EmpNom2 = aP3;
      inicializardatos.this.AV17EmpCUIT2 = aP4;
      inicializardatos.this.AV15CliMultiEmp = aP5;
      inicializardatos.this.AV38TipEmpleCod = aP6;
      inicializardatos.this.AV8ActCodigo = aP7;
      inicializardatos.this.AV10BaseUrl = aP8;
      inicializardatos.this.AV31PaiCod = aP9;
      inicializardatos.this.AV72clienteNucleoEs = aP10;
      inicializardatos.this.AV46ActComCodigo = aP11;
      inicializardatos.this.AV70clienteConvenioEs = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "2 &PaiCod ", "")+GXutil.trim( GXutil.str( AV31PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "&CliNom ", "")+AV16CliNom+httpContext.getMessage( " cuit ", "")+GXutil.trim( GXutil.str( AV14CliCUIT, 11, 0))+httpContext.getMessage( " multi ", "")+GXutil.trim( GXutil.booltostr( AV15CliMultiEmp))) ;
      GXv_int1[0] = AV13CliCod ;
      new web.crearcliente(remoteHandle, context).execute( AV16CliNom, AV14CliCUIT, AV15CliMultiEmp, AV31PaiCod, AV46ActComCodigo, AV72clienteNucleoEs, AV70clienteConvenioEs, GXv_int1) ;
      inicializardatos.this.AV13CliCod = GXv_int1[0] ;
      GXv_int1[0] = AV73padre_CliCod ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV31PaiCod, GXv_int1) ;
      inicializardatos.this.AV73padre_CliCod = GXv_int1[0] ;
      if ( AV13CliCod == 1 )
      {
         AV84PerfilId = (byte)(1) ;
         AV83RolId = (byte)(1) ;
      }
      else
      {
         if ( AV13CliCod == AV73padre_CliCod )
         {
            AV84PerfilId = (byte)(2) ;
            AV83RolId = (byte)(1) ;
         }
         else
         {
            if ( AV70clienteConvenioEs )
            {
               AV84PerfilId = (byte)(3) ;
               AV83RolId = (byte)(1) ;
            }
            else
            {
               AV84PerfilId = (byte)(4) ;
               if ( AV13CliCod == 4 )
               {
                  AV83RolId = (byte)(2) ;
               }
               else
               {
                  AV83RolId = (byte)(1) ;
               }
            }
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "ini 1 &clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV70clienteConvenioEs))) ;
      if ( ( AV13CliCod != AV73padre_CliCod ) && ( AV70clienteConvenioEs ) )
      {
         new web.inicializarcategorias(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarcategoriasuocrayaci(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarcategoriasuocrasereno(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarcategoriasuocrayacsereno(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarcategoriasuecara(remoteHandle, context).execute( AV13CliCod) ;
         new web.calcular_tope_default(remoteHandle, context).execute( AV13CliCod) ;
         GXt_char2 = AV80ConveAdicod ;
         GXv_char3[0] = GXt_char2 ;
         new web.getadicionalreservado(remoteHandle, context).execute( AV31PaiCod, "presentismo", GXv_char3) ;
         inicializardatos.this.GXt_char2 = GXv_char3[0] ;
         AV80ConveAdicod = GXt_char2 ;
         if ( ! new web.pruebapostgres(remoteHandle, context).executeUdp( ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouecara(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "T1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
            if ( (pr_default.getStatus(0) == 1) )
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouecara(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "A1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocra(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "T1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
            if ( (pr_default.getStatus(2) == 1) )
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocra(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "A1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "T1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
            if ( (pr_default.getStatus(4) == 1) )
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "A1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q7 */
            pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
            if ( (pr_default.getStatus(5) == 1) )
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocra(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            GXt_char2 = A1824ConveAdiSitCancela ;
            GXv_char3[0] = GXt_char2 ;
            new web.codigodesituacionenfermedad(remoteHandle, context).execute( AV13CliCod, GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1824ConveAdiSitCancela = GXt_char2 ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q8 */
            pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocra(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            GXt_char2 = A1824ConveAdiSitCancela ;
            GXv_char3[0] = GXt_char2 ;
            new web.codigodesituacioniltart(remoteHandle, context).execute( AV13CliCod, GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1824ConveAdiSitCancela = GXt_char2 ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q9 */
            pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
            AV80ConveAdicod = httpContext.getMessage( "vianda", "") ;
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "T1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "A1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q11 */
            pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
            AV80ConveAdicod = httpContext.getMessage( "ayuda_zona_3", "") ;
            /*
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "T1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q12 */
            pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
               INSERT RECORD ON TABLE convenio_adicionalCancela

            */
            A3CliCod = AV13CliCod ;
            A1564CliPaiConve = AV31PaiCod ;
            GXt_char2 = A1565CliConvenio ;
            GXv_char3[0] = GXt_char2 ;
            new web.conveniouocrayac(remoteHandle, context).execute( GXv_char3) ;
            inicializardatos.this.GXt_char2 = GXv_char3[0] ;
            A1565CliConvenio = GXt_char2 ;
            A996ConveAdicod = AV80ConveAdicod ;
            A1824ConveAdiSitCancela = httpContext.getMessage( "A1", "") ;
            A2050ConveAdiSitCanOld = "" ;
            A2048ConveAdiSitCanRelRef = "" ;
            /* Using cursor P001Q13 */
            pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela, A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "&clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV70clienteConvenioEs))) ;
         if ( ! AV70clienteConvenioEs )
         {
            GXv_int1[0] = AV81convenienteCliCod ;
            new web.getconveniadorclicod(remoteHandle, context).execute( true, GXv_int1) ;
            inicializardatos.this.AV81convenienteCliCod = GXv_int1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "&convenienteCliCod ", "")+GXutil.trim( GXutil.str( AV81convenienteCliCod, 6, 0))) ;
            new web.updatecategorias(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateescalasalarial(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updatecategoriaprovincias(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioimportes(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioadicional(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioadicionalimportes(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioadicionalcancelan(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioadicionalalicuotas(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconvenioparticularidades(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconveniovacaciones(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconveniofondocese(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconveniobasecalculos(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconveniotiposdetrabajo(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
            new web.updateconveniohsextpordia(remoteHandle, context).execute( AV81convenienteCliCod, AV13CliCod, 0) ;
         }
      }
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "&SecUserId ", "")+GXutil.trim( GXutil.str( AV37SecUserId, 4, 0))) ;
      AV82MenuVerId = 1 ;
      new web.userasignarcliente(remoteHandle, context).execute( AV37SecUserId, AV13CliCod, AV83RolId, AV84PerfilId, AV82MenuVerId) ;
      if ( AV13CliCod == 4 )
      {
         /* Optimized UPDATE. */
         cmdBuffer = " LOCK TABLE ObraSocial IN EXCLUSIVE MODE ";
         ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         /* Using cursor P001Q14 */
         pr_default.execute(12);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
         /* End optimized UPDATE. */
      }
      if ( (0==AV31PaiCod) )
      {
         new web.grabaparametro(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "FIN_INI", ""), httpContext.getMessage( "S", ""), "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      new web.userasignarparact(remoteHandle, context).execute( AV37SecUserId) ;
      if ( AV13CliCod != AV73padre_CliCod )
      {
         if ( false )
         {
            new web.mailnuevousuario(remoteHandle, context).execute( AV37SecUserId, AV10BaseUrl) ;
         }
      }
      else
      {
         GXv_char3[0] = "" ;
         new web.usuarioactivarbyid(remoteHandle, context).execute( AV37SecUserId, true, GXv_char3) ;
      }
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "pasó usuario 1", "")) ;
      GXt_boolean4 = AV49esClienteSistema ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclientenucleopais(remoteHandle, context).execute( AV13CliCod, GXv_boolean5) ;
      inicializardatos.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV49esClienteSistema = GXt_boolean4 ;
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "pasó usuario 2", "")) ;
      if ( AV49esClienteSistema )
      {
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "pasó feriados", "")) ;
         GXt_objcol_SdtSeccion6 = AV36Seccion ;
         GXv_objcol_SdtSeccion7[0] = GXt_objcol_SdtSeccion6 ;
         new web.seccion_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtSeccion7) ;
         GXt_objcol_SdtSeccion6 = GXv_objcol_SdtSeccion7[0] ;
         AV36Seccion = GXt_objcol_SdtSeccion6 ;
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "secion 1", "")) ;
         AV109GXV1 = 1 ;
         while ( AV109GXV1 <= AV36Seccion.size() )
         {
            AV35sec = (web.SdtSeccion)((web.SdtSeccion)AV36Seccion.elementAt(-1+AV109GXV1));
            new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "secion 2a", "")) ;
            AV35sec.setgxTv_SdtSeccion_Clicod( AV13CliCod );
            AV35sec.setgxTv_SdtSeccion_Secdescrip( GXutil.upper( AV35sec.getgxTv_SdtSeccion_Secdescrip()) );
            AV35sec.Save();
            Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
            new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "secion b", "")) ;
            AV109GXV1 = (int)(AV109GXV1+1) ;
         }
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "pasó seccion", "")) ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "011", "001", httpContext.getMessage( "Director General", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "011", "002", httpContext.getMessage( "CEO", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "000", httpContext.getMessage( "Programador", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "001", httpContext.getMessage( "Programador Full Stack", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "002", httpContext.getMessage( "Programador Front-end", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "003", httpContext.getMessage( "Programador Back-end", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "004", httpContext.getMessage( "Programador de Aplicaciones Móviles", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "005", httpContext.getMessage( "Administrador de Bases de Datos", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "006", httpContext.getMessage( "Programador de Sistemas Embebidos", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "007", httpContext.getMessage( "Programador de Inteligencia Artificial", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "008", httpContext.getMessage( "Programador de Seguridad Informática", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "009", httpContext.getMessage( "Programador de Automatización", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "010", httpContext.getMessage( "Analista de Sistemas", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "011", httpContext.getMessage( "Administrador de Sistemas", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "012", httpContext.getMessage( "Ingeniero de DevOps", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "013", httpContext.getMessage( "Especialista en Ciberseguridad", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "014", httpContext.getMessage( "Ingeniero de Software", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "015", httpContext.getMessage( "Arquitecto de Soluciones", ""), "", true, 0, 0, "") ;
         new web.newpuesto(remoteHandle, context).execute( AV13CliCod, "010", "016", httpContext.getMessage( "Ingeniero de Redes", ""), "", true, 0, 0, "") ;
         /*
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "001" ;
         A1240PuestoCodigo = "001" ;
         A1241PuestoDescrip = httpContext.getMessage( "Director de Proyectos de Construcción", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "DIRECTOR DE PROYECTOS DE CONSTRUCCION", "") ;
         A1255PuestoHorasExt = false ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "001" ;
         A1240PuestoCodigo = "002" ;
         A1241PuestoDescrip = httpContext.getMessage( "Gerente de Obra", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "GERENTE DE OBRA", "") ;
         A1255PuestoHorasExt = false ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "003" ;
         A1241PuestoDescrip = httpContext.getMessage( "Ingeniero Civil", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "INGENIERO CIVIL", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "003" ;
         A1240PuestoCodigo = "004" ;
         A1241PuestoDescrip = httpContext.getMessage( "Encargado de Seguridad en el Trabajo", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "ENCARGADO DE SEGURIDAD EN EL TRABAJO", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A1240PuestoCodigo = "005" ;
         A1241PuestoDescrip = httpContext.getMessage( "Jefe de Topografía", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "JEFE DE TOPOGRAFIA", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "006" ;
         A1241PuestoDescrip = httpContext.getMessage( "Capataz de Construcción", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "CAPATAZ DE CONSTRUCCION", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "007" ;
         A1241PuestoDescrip = httpContext.getMessage( "Operador de Maquinaria Pesada", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "OPERADOR DE MAQUINARIA PESADA", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "008" ;
         A1241PuestoDescrip = httpContext.getMessage( "Albañil", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "ALBANIL", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
         /*
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "009" ;
         A1241PuestoDescrip = httpContext.getMessage( "Electricista", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "ELECTRICISTA", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         if ( (pr_default.getStatus(21) == 1) )
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "010" ;
         A1241PuestoDescrip = httpContext.getMessage( "Plomero", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "PLOMERO", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
         /*
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "011" ;
         A1241PuestoDescrip = httpContext.getMessage( "Carpintero", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "CARPINTERO", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         if ( (pr_default.getStatus(23) == 1) )
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "005" ;
         A1240PuestoCodigo = "012" ;
         A1241PuestoDescrip = httpContext.getMessage( "Pintor de Construcción", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "PINTOR DE CONSTRUCCION", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         if ( (pr_default.getStatus(24) == 1) )
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
            INSERT RECORD ON TABLE Puesto

         */
         A3CliCod = AV13CliCod ;
         A13SecCodigo = "009" ;
         A1240PuestoCodigo = "013" ;
         A1241PuestoDescrip = httpContext.getMessage( "Inspector de Calidad", "") ;
         A1242PuestoDescripSinAc = httpContext.getMessage( "INSPECTOR DE CALIDAD", "") ;
         A1255PuestoHorasExt = true ;
         A1987PuestoRelSec = 0 ;
         A1988PuestoRelSecCli = 0 ;
         A1989PuestoPadre = "" ;
         A2016PuestoRelRef = "" ;
         A2034PuestoOld = "" ;
         /* Using cursor P001Q27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, A1242PuestoDescripSinAc, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
         if ( (pr_default.getStatus(25) == 1) )
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
      else
      {
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "antes importa seccion", "")) ;
         new web.updateareas(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod, 0) ;
         new web.updatepuestos(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod, 0) ;
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "importa seccion", "")) ;
      }
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "pasó ....", "")) ;
      if ( AV13CliCod == AV73padre_CliCod )
      {
         /* Execute user subroutine: 'INI BANCOS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         new web.updatebancos(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod, 0) ;
      }
      GXt_objcol_SdtEscolaridad8 = AV20Escolaridad ;
      GXv_objcol_SdtEscolaridad9[0] = GXt_objcol_SdtEscolaridad8 ;
      new web.escolaridad_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtEscolaridad9) ;
      GXt_objcol_SdtEscolaridad8 = GXv_objcol_SdtEscolaridad9[0] ;
      AV20Escolaridad = GXt_objcol_SdtEscolaridad8 ;
      AV110GXV2 = 1 ;
      while ( AV110GXV2 <= AV20Escolaridad.size() )
      {
         AV19esc = (web.SdtEscolaridad)((web.SdtEscolaridad)AV20Escolaridad.elementAt(-1+AV110GXV2));
         AV19esc.setgxTv_SdtEscolaridad_Clicod( AV13CliCod );
         AV19esc.Save();
         Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
         AV110GXV2 = (int)(AV110GXV2+1) ;
      }
      GXv_int10[0] = AV75PaiTipoExpDef ;
      new web.getpaitipoexpdef(remoteHandle, context).execute( AV31PaiCod, GXv_int10) ;
      inicializardatos.this.AV75PaiTipoExpDef = GXv_int10[0] ;
      GXv_int10[0] = AV77EmpPerVacDes ;
      GXv_int11[0] = AV78EmpPerVacHas ;
      GXv_decimal12[0] = AV79EmpFracVacAnt ;
      new web.getpaivacper(remoteHandle, context).execute( AV31PaiCod, GXv_int10, GXv_int11, GXv_decimal12) ;
      inicializardatos.this.AV77EmpPerVacDes = GXv_int10[0] ;
      inicializardatos.this.AV78EmpPerVacHas = GXv_int11[0] ;
      inicializardatos.this.AV79EmpFracVacAnt = GXv_decimal12[0] ;
      if ( ! AV70clienteConvenioEs )
      {
         /*
            INSERT RECORD ON TABLE Empresa

         */
         A3CliCod = AV13CliCod ;
         A1EmpCod = (short)(1) ;
         A2EmpNom = GXutil.trim( AV16CliNom) ;
         A1556EmpGuarEdadMin = (byte)(0) ;
         A1557EmpGuarEdadMax = (byte)(0) ;
         A1151ARTSec = (short)(2) ;
         A177EmpCUIT = AV14CliCUIT ;
         A125CatIvaCod = (short)(1) ;
         n125CatIvaCod = false ;
         GXt_int13 = A46PaiCod ;
         GXv_int14[0] = GXt_int13 ;
         new web.paisargentina(remoteHandle, context).execute( GXv_int14) ;
         inicializardatos.this.GXt_int13 = GXv_int14[0] ;
         A46PaiCod = GXt_int13 ;
         n46PaiCod = false ;
         if ( AV13CliCod == 4 )
         {
            GXt_int13 = A47ProvCod ;
            GXv_int14[0] = GXt_int13 ;
            new web.provinciabuenosaires(remoteHandle, context).execute( GXv_int14) ;
            inicializardatos.this.GXt_int13 = GXv_int14[0] ;
            A47ProvCod = GXt_int13 ;
            n47ProvCod = false ;
            A48LocCod = (short)(1100) ;
            n48LocCod = false ;
            A43ActCodigo = "03" ;
            n43ActCodigo = false ;
            A2265EmpCondiCod = (short)(5) ;
            A178EmpDir = httpContext.getMessage( "Aguado 139", "") ;
         }
         else
         {
            if ( AV13CliCod == 5 )
            {
               A43ActCodigo = "132" ;
               n43ActCodigo = false ;
               A178EmpDir = httpContext.getMessage( "Fitz Roy 1947 4° piso oficina 402", "") ;
            }
            else
            {
               A43ActCodigo = "49" ;
               n43ActCodigo = false ;
            }
            A2265EmpCondiCod = (short)(1) ;
            A47ProvCod = (short)(1) ;
            n47ProvCod = false ;
            A48LocCod = (short)(42) ;
            n48LocCod = false ;
         }
         if ( ! (GXutil.strcmp("", AV38TipEmpleCod)==0) )
         {
            A45TipEmpleCod = AV38TipEmpleCod ;
            n45TipEmpleCod = false ;
         }
         else
         {
            A45TipEmpleCod = "1" ;
            n45TipEmpleCod = false ;
         }
         new web.msgdebug6(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "EmpZonCod.SetNull()nulooo", "")) ;
         A1533EmpActComercial = AV46ActComCodigo ;
         A903ActComCodigo = AV46ActComCodigo ;
         GXv_char3[0] = AV101LocaZona ;
         new web.getzonaporlocalidad(remoteHandle, context).execute( A46PaiCod, A47ProvCod, A48LocCod, GXv_char3) ;
         inicializardatos.this.AV101LocaZona = GXv_char3[0] ;
         A44EmpZonCod = AV101LocaZona ;
         n44EmpZonCod = false ;
         A1524EmpLiqFer = false ;
         A1750EmpLiqFerJor = true ;
         A1787EmpLiqGan = false ;
         A1792EmpTipoExp = AV75PaiTipoExpDef ;
         A1802EmpPromDesde = "actual" ;
         if ( AV13CliCod == 4 )
         {
            A1811EmpPerVacDes = (byte)(5) ;
            A1812EmpPerVacHas = (byte)(4) ;
            A1813EmpFracVacAnt = DecimalUtil.doubleToDec(1) ;
            A2259EmpVacExpLim = false ;
            A2260EmpVacExpTie = (byte)(0) ;
            A2261EmpVacDisMax = 0 ;
         }
         else
         {
            A1811EmpPerVacDes = AV77EmpPerVacDes ;
            A1812EmpPerVacHas = AV78EmpPerVacHas ;
            A1813EmpFracVacAnt = AV79EmpFracVacAnt ;
            A2259EmpVacExpLim = true ;
            A2260EmpVacExpTie = (byte)(1) ;
            A2261EmpVacDisMax = 0 ;
         }
         A1965EmpOsoCod = "" ;
         n1965EmpOsoCod = false ;
         n1965EmpOsoCod = true ;
         GXv_decimal12[0] = AV102EmpMesHsPExt ;
         GXv_char3[0] = AV103EmpDiaHsPExt ;
         new web.getpaisdiasmespara1hora(remoteHandle, context).execute( AV31PaiCod, GXv_decimal12, GXv_char3) ;
         inicializardatos.this.AV102EmpMesHsPExt = GXv_decimal12[0] ;
         inicializardatos.this.AV103EmpDiaHsPExt = GXv_char3[0] ;
         A1302EmpMesHsPExt = AV102EmpMesHsPExt ;
         n1302EmpMesHsPExt = false ;
         A1303EmpDiaHsPExt = AV103EmpDiaHsPExt ;
         n1303EmpDiaHsPExt = false ;
         /* Using cursor P001Q28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), A178EmpDir, Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Short.valueOf(A1151ARTSec), Boolean.valueOf(n1302EmpMesHsPExt), A1302EmpMesHsPExt, Boolean.valueOf(n1303EmpDiaHsPExt), A1303EmpDiaHsPExt, Boolean.valueOf(A1524EmpLiqFer), A1533EmpActComercial, Byte.valueOf(A1556EmpGuarEdadMin), Byte.valueOf(A1557EmpGuarEdadMax), A903ActComCodigo, Boolean.valueOf(A1750EmpLiqFerJor), Boolean.valueOf(A1787EmpLiqGan), Byte.valueOf(A1792EmpTipoExp), A1802EmpPromDesde, Byte.valueOf(A1811EmpPerVacDes), Byte.valueOf(A1812EmpPerVacHas), A1813EmpFracVacAnt, Boolean.valueOf(n1965EmpOsoCod), A1965EmpOsoCod, Short.valueOf(A2265EmpCondiCod), Boolean.valueOf(A2259EmpVacExpLim), Byte.valueOf(A2260EmpVacExpTie), Integer.valueOf(A2261EmpVacDisMax)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
         if ( (pr_default.getStatus(26) == 1) )
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
         new web.newempresabanco(remoteHandle, context).execute( AV13CliCod, (short)(1), "00007", "", "", "CA", "") ;
         new web.crearcarpetaupload(remoteHandle, context).execute( AV13CliCod, (short)(1)) ;
         new web.empresajornadalegal(remoteHandle, context).execute( AV13CliCod, (short)(1)) ;
         /* Using cursor P001Q29 */
         pr_default.execute(27);
         while ( (pr_default.getStatus(27) != 101) )
         {
            A9ConveCodigo = P001Q29_A9ConveCodigo[0] ;
            A46PaiCod = P001Q29_A46PaiCod[0] ;
            n46PaiCod = P001Q29_n46PaiCod[0] ;
            /*
               INSERT RECORD ON TABLE Empresanolaborables_convenio

            */
            A3CliCod = AV13CliCod ;
            A1EmpCod = (short)(1) ;
            A1239EmpConvenio = A9ConveCodigo ;
            /* Using cursor P001Q30 */
            pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1239EmpConvenio});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_convenio");
            if ( (pr_default.getStatus(28) == 1) )
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
            pr_default.readNext(27);
         }
         pr_default.close(27);
         new web.newempreligiondefault(remoteHandle, context).execute( AV13CliCod, (short)(1)) ;
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, "2") ;
      /*
         INSERT RECORD ON TABLE MotEgrTipo

      */
      A3CliCod = AV13CliCod ;
      A1525MegTipo = "SINCAUSA" ;
      /* Using cursor P001Q31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), A1525MegTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MotEgrTipo");
      if ( (pr_default.getStatus(29) == 1) )
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
         INSERT RECORD ON TABLE MotEgrTipo

      */
      A3CliCod = AV13CliCod ;
      A1525MegTipo = "SINPREAVISO" ;
      /* Using cursor P001Q32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), A1525MegTipo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("MotEgrTipo");
      if ( (pr_default.getStatus(30) == 1) )
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
      GXt_objcol_SdtMotivoEgreso15 = AV27MotivoEgreso ;
      GXv_objcol_SdtMotivoEgreso16[0] = GXt_objcol_SdtMotivoEgreso15 ;
      new web.motivoegreso_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtMotivoEgreso16) ;
      GXt_objcol_SdtMotivoEgreso15 = GXv_objcol_SdtMotivoEgreso16[0] ;
      AV27MotivoEgreso = GXt_objcol_SdtMotivoEgreso15 ;
      AV112GXV3 = 1 ;
      while ( AV112GXV3 <= AV27MotivoEgreso.size() )
      {
         AV26motegr = (web.SdtMotivoEgreso)((web.SdtMotivoEgreso)AV27MotivoEgreso.elementAt(-1+AV112GXV3));
         AV26motegr.setgxTv_SdtMotivoEgreso_Clicod( AV13CliCod );
         if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "FAL", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(0) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "MUE", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(29) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "BOC", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(2) );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(4) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "DES1", "")) == 0 ) || ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "DES2", "")) == 0 ) )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(7) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(8) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "DES2", "")) == 0 )
            {
               AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
               AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(26) );
               AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
               AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            }
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(36) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(37) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(39) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "DES1", "")) == 0 )
            {
               AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
               AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(23) );
               AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
               AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            }
            else
            {
            }
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(24) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(22) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(35) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(40) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "REN", "")) == 0 ) || ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "MAT", "")) == 0 ) )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(21) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(22) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(35) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(40) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "VTO", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(99) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(30) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(38) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "FUE", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(27) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(28) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "QU1", "")) == 0 ) || ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "QU2", "")) == 0 ) )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(31) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "JUB", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(33) );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         else if ( GXutil.strcmp(AV26motegr.getgxTv_SdtMotivoEgreso_Megcodigo(), httpContext.getMessage( "ABA", "")) == 0 )
         {
            AV71sitRevMotivo = (web.SdtMotivoEgreso_RevistaAfip)new web.SdtMotivoEgreso_RevistaAfip( remoteHandle, context);
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( (short)(25) );
            AV71sitRevMotivo.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( true );
            AV26motegr.getgxTv_SdtMotivoEgreso_Revistaafip().add(AV71sitRevMotivo, 0);
         }
         AV26motegr.Save();
         Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
         AV112GXV3 = (int)(AV112GXV3+1) ;
      }
      GXt_objcol_SdtParentesco17 = AV33Parentesco ;
      GXv_objcol_SdtParentesco18[0] = GXt_objcol_SdtParentesco17 ;
      new web.parentesco_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtParentesco18) ;
      GXt_objcol_SdtParentesco17 = GXv_objcol_SdtParentesco18[0] ;
      AV33Parentesco = GXt_objcol_SdtParentesco17 ;
      AV113GXV4 = 1 ;
      while ( AV113GXV4 <= AV33Parentesco.size() )
      {
         AV32paren = (web.SdtParentesco)((web.SdtParentesco)AV33Parentesco.elementAt(-1+AV113GXV4));
         AV32paren.setgxTv_SdtParentesco_Clicod( AV13CliCod );
         AV32paren.Save();
         Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
         AV113GXV4 = (int)(AV113GXV4+1) ;
      }
      GXt_objcol_SdtTipoLiquidacion19 = AV39TipoLiquidacion ;
      GXv_objcol_SdtTipoLiquidacion20[0] = GXt_objcol_SdtTipoLiquidacion19 ;
      new web.tipoliquidacion_dataprovider(remoteHandle, context).execute( GXv_objcol_SdtTipoLiquidacion20) ;
      GXt_objcol_SdtTipoLiquidacion19 = GXv_objcol_SdtTipoLiquidacion20[0] ;
      AV39TipoLiquidacion = GXt_objcol_SdtTipoLiquidacion19 ;
      AV114GXV5 = 1 ;
      while ( AV114GXV5 <= AV39TipoLiquidacion.size() )
      {
         AV21ipoLiq = (web.SdtTipoLiquidacion)((web.SdtTipoLiquidacion)AV39TipoLiquidacion.elementAt(-1+AV114GXV5));
         AV21ipoLiq.setgxTv_SdtTipoLiquidacion_Clicod( AV13CliCod );
         AV21ipoLiq.Save();
         if ( GXutil.strcmp(AV21ipoLiq.getgxTv_SdtTipoLiquidacion_Tliqcod(), httpContext.getMessage( "EGRESO", "")) == 0 )
         {
            new web.grabaparametro(remoteHandle, context).execute( AV13CliCod, new web.tipoliqegreso_codigoparam(remoteHandle, context).executeUdp( ), AV21ipoLiq.getgxTv_SdtTipoLiquidacion_Tliqcod(), httpContext.getMessage( "Tipo de liquidación egreso", "")) ;
         }
         else
         {
            if ( GXutil.strcmp(AV21ipoLiq.getgxTv_SdtTipoLiquidacion_Tliqcod(), httpContext.getMessage( "VACACIONES", "")) == 0 )
            {
               new web.grabaparametro(remoteHandle, context).execute( AV13CliCod, new web.tipoliqvacaciones_codigoparam(remoteHandle, context).executeUdp( ), AV21ipoLiq.getgxTv_SdtTipoLiquidacion_Tliqcod(), httpContext.getMessage( "Tipo de liquidación adelanto de vacaciones", "")) ;
            }
            else
            {
            }
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
         AV114GXV5 = (int)(AV114GXV5+1) ;
      }
      if ( false )
      {
         callWebObject(formatLink("web.iniexistentes", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      new web.initipoliqmodtra(remoteHandle, context).execute( AV13CliCod) ;
      if ( AV13CliCod == AV73padre_CliCod )
      {
         GXv_objcol_Sdtos_sdt_os_sdtItem21[0] = AV30os_sdt ;
         new web.ini_os(remoteHandle, context).execute( AV13CliCod, GXv_objcol_Sdtos_sdt_os_sdtItem21) ;
         AV30os_sdt = GXv_objcol_Sdtos_sdt_os_sdtItem21[0] ;
      }
      else
      {
         new web.importar_os(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod, new web.actcomconstruccion(remoteHandle, context).executeUdp( )) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "ini par antes &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      AV116GXV7 = 1 ;
      AV115GXV6 = web.gxdomainoperandos.getValues() ;
      while ( AV116GXV7 <= AV115GXV6.size() )
      {
         AV29operando = (String)AV115GXV6.elementAt(-1+AV116GXV7) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "calculo 1 &operando", "")+AV29operando+httpContext.getMessage( " &PaiCod ", "")+GXutil.trim( GXutil.str( AV31PaiCod, 4, 0))) ;
         /*
            INSERT RECORD ON TABLE calculo

         */
         A46PaiCod = AV31PaiCod ;
         n46PaiCod = false ;
         A74idOperando = AV29operando ;
         A2073OpeHelp = httpContext.getMessage( "Ayuda/Descripción (me falta completar", "") ;
         if ( ( GXutil.strcmp(AV29operando, "[dias_remunerados_semestre]") == 0 ) || ( GXutil.strcmp(AV29operando, "[dias_trabajados_mes]") == 0 ) )
         {
            A932OpeEsCant = true ;
         }
         else
         {
            A932OpeEsCant = false ;
         }
         if ( ( GXutil.strcmp(AV29operando, "[alicuota_sindical]") == 0 ) || ( GXutil.strcmp(AV29operando, "[jubilacion]") == 0 ) || ( GXutil.strcmp(AV29operando, "[ley_19032]") == 0 ) || ( GXutil.strcmp(AV29operando, "[obra_social]") == 0 ) || ( GXutil.strcmp(AV29operando, "[obra_social_adherentes]") == 0 ) || ( GXutil.strcmp(AV29operando, "[cuota_sindical]") == 0 ) || ( GXutil.strcmp(AV29operando, "{obra_social_diferencial}") == 0 ) )
         {
            A1032OpeAliEs = true ;
         }
         else
         {
            A1032OpeAliEs = false ;
         }
         AV45OpeCodFormula = AV29operando ;
         GXv_char3[0] = AV28OpeCodForMay ;
         new web.convertircalculomayus(remoteHandle, context).execute( AV29operando, GXv_char3) ;
         inicializardatos.this.AV28OpeCodForMay = GXv_char3[0] ;
         A537OpeCodForMay = AV28OpeCodForMay ;
         A474OpeDescripcion = httpContext.getMessage( web.gxdomainoperandos.getDescription(httpContext,(String)AV29operando), "") ;
         GXv_char3[0] = AV45OpeCodFormula ;
         new web.reemplazarcharcalculos(remoteHandle, context).execute( AV13CliCod, GXv_char3) ;
         inicializardatos.this.AV45OpeCodFormula = GXv_char3[0] ;
         A473OpeCodFormula = GXutil.lower( AV45OpeCodFormula) ;
         A1607OpeProcedure = "" ;
         A2138OpeDetail = "" ;
         /* Using cursor P001Q33 */
         pr_default.execute(31, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), A74idOperando, A473OpeCodFormula, A474OpeDescripcion, A537OpeCodForMay, Boolean.valueOf(A932OpeEsCant), Boolean.valueOf(A1032OpeAliEs), A1607OpeProcedure, A2073OpeHelp, A2138OpeDetail});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("calculo");
         if ( (pr_default.getStatus(31) == 1) )
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
         AV116GXV7 = (int)(AV116GXV7+1) ;
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "calculo 2 con commit", "")) ;
      new web.grabarcalpardesdejson(remoteHandle, context).execute( ) ;
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, "3") ;
      if ( AV13CliCod == AV73padre_CliCod )
      {
         new web.iniopecliente(remoteHandle, context).execute( AV13CliCod) ;
      }
      else
      {
         new web.importaropecli(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "importarConceptos &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " &clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV70clienteConvenioEs))) ;
      GXv_int22[0] = 0 ;
      GXv_char3[0] = AV25mensaje ;
      GXv_int14[0] = AV40ULTIMO_CALC ;
      GXv_int1[0] = AV41ultimo_ConOrden ;
      new web.importarconceptos2(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod, "", AV70clienteConvenioEs, (short)(0), "", 0, GXv_int22, GXv_char3, GXv_int14, GXv_int1) ;
      inicializardatos.this.AV25mensaje = GXv_char3[0] ;
      inicializardatos.this.AV40ULTIMO_CALC = GXv_int14[0] ;
      inicializardatos.this.AV41ultimo_ConOrden = GXv_int1[0] ;
      new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      new web.inicializarparametros(remoteHandle, context).execute( AV13CliCod) ;
      if ( AV13CliCod == AV73padre_CliCod )
      {
         new web.crearconceptosauxiliares(remoteHandle, context).execute( AV13CliCod, true, false) ;
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "llama", "")) ;
         new web.actualizarcodigosnuevos(remoteHandle, context).execute( AV13CliCod) ;
      }
      else
      {
         new web.importar_siradig_codigos(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
         new web.importar_condicion_exencion_iigg(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
         new web.importar_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
         new web.importar_concepto_motivos(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "4 &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " &padre_CliCod ", "")+GXutil.trim( GXutil.str( AV73padre_CliCod, 6, 0))) ;
      new web.inicializarparametros2(remoteHandle, context).execute( AV13CliCod) ;
      if ( AV13CliCod == AV73padre_CliCod )
      {
         GXv_int14[0] = AV43ULTIMO_CALC2 ;
         GXv_int1[0] = AV42ultimo_ConOrden2 ;
         new web.crearconceptoslsd_basesimponibles(remoteHandle, context).execute( AV13CliCod, AV40ULTIMO_CALC, AV41ultimo_ConOrden, GXv_int14, GXv_int1) ;
         inicializardatos.this.AV43ULTIMO_CALC2 = GXv_int14[0] ;
         inicializardatos.this.AV42ultimo_ConOrden2 = (short)((short)(GXv_int1[0])) ;
         new web.crearconceptosganancias_v3(remoteHandle, context).execute( AV13CliCod, AV43ULTIMO_CALC2, AV42ultimo_ConOrden2) ;
         new web.crearconceptosauxiliares(remoteHandle, context).execute( AV13CliCod, false, false) ;
         new web.actualizarcodigosnuevos2(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarconceptotipoliqparaganancias(remoteHandle, context).execute( AV13CliCod) ;
         new web.iniconceptoconvenio(remoteHandle, context).execute( AV13CliCod) ;
         new web.inicializarconceptosafipdefault(remoteHandle, context).execute( AV13CliCod, "") ;
         new web.inicializardefaultparam(remoteHandle, context).execute( AV13CliCod) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, "5") ;
      if ( AV13CliCod != AV73padre_CliCod )
      {
         new web.importarparametros(remoteHandle, context).execute( AV73padre_CliCod, AV13CliCod) ;
         new web.msgdebug(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "crearLegajoEjemplo", "")) ;
         if ( ! AV70clienteConvenioEs && false )
         {
            new web.crearlegajofulanos(remoteHandle, context).execute( AV13CliCod, (short)(1)) ;
         }
      }
      else
      {
         new web.ajustarordenconceptos(remoteHandle, context).execute( AV13CliCod) ;
         new web.ini_siradig_codigos(remoteHandle, context).execute( AV13CliCod) ;
         new web.ini_condicion_exencion_iigg(remoteHandle, context).execute( AV13CliCod) ;
         new web.ini_tipo_aplicacion_ganancias(remoteHandle, context).execute( AV13CliCod) ;
         new web.ini_conceptos_apliigg(remoteHandle, context).execute( AV13CliCod) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, "6") ;
      new web.inicializarconceptooperandos(remoteHandle, context).execute( AV13CliCod, "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "7 &clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV70clienteConvenioEs))) ;
      if ( ! AV70clienteConvenioEs )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "antes de inicializarTemplateRecibo ", "")) ;
         new web.inicializartemplaterecibo(remoteHandle, context).execute( AV13CliCod, (short)(1)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "despues de inicializarTemplateRecibo ", "")) ;
      }
      if ( AV13CliCod == AV73padre_CliCod )
      {
         /*
            INSERT RECORD ON TABLE Debug

         */
         A3CliCod = AV13CliCod ;
         A1754DebugPgm = httpContext.getMessage( "newOpcionMenu", "") ;
         A1755DebugActivo = true ;
         /* Using cursor P001Q34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), A1754DebugPgm, Boolean.valueOf(A1755DebugActivo)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Debug");
         if ( (pr_default.getStatus(32) == 1) )
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
         /* Using cursor P001Q35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(AV13CliCod)});
         while ( (pr_default.getStatus(33) != 101) )
         {
            A3CliCod = P001Q35_A3CliCod[0] ;
            A38SubTipoConCod1 = P001Q35_A38SubTipoConCod1[0] ;
            n38SubTipoConCod1 = P001Q35_n38SubTipoConCod1[0] ;
            A39SubTipoConCod2 = P001Q35_A39SubTipoConCod2[0] ;
            n39SubTipoConCod2 = P001Q35_n39SubTipoConCod2[0] ;
            A26ConCodigo = P001Q35_A26ConCodigo[0] ;
            A148ConFormula = P001Q35_A148ConFormula[0] ;
            n148ConFormula = P001Q35_n148ConFormula[0] ;
            A41ConDescrip = P001Q35_A41ConDescrip[0] ;
            A953ConCondicion = P001Q35_A953ConCondicion[0] ;
            n953ConCondicion = P001Q35_n953ConCondicion[0] ;
            A954ConCondCodigo = P001Q35_A954ConCondCodigo[0] ;
            GXv_char3[0] = AV47ConCondicion ;
            GXv_char23[0] = AV48ConCondCodigo ;
            new web.validarconceptoini(remoteHandle, context).execute( A3CliCod, A38SubTipoConCod1, A39SubTipoConCod2, A26ConCodigo, A148ConFormula, A41ConDescrip, GXv_char3, GXv_char23) ;
            inicializardatos.this.AV47ConCondicion = GXv_char3[0] ;
            inicializardatos.this.AV48ConCondCodigo = GXv_char23[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "a concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " le pongo ", "")+AV47ConCondicion) ;
            if ( ! (GXutil.strcmp("", AV47ConCondicion)==0) )
            {
               A953ConCondicion = AV47ConCondicion ;
               n953ConCondicion = false ;
            }
            else
            {
               A953ConCondicion = "" ;
               n953ConCondicion = false ;
               n953ConCondicion = true ;
            }
            A954ConCondCodigo = AV48ConCondCodigo ;
            /* Using cursor P001Q36 */
            pr_default.execute(34, new Object[] {Boolean.valueOf(n953ConCondicion), A953ConCondicion, A954ConCondCodigo, Integer.valueOf(A3CliCod), A26ConCodigo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
            pr_default.readNext(33);
         }
         pr_default.close(33);
         new web.corregircorchetesconceptos(remoteHandle, context).execute( AV13CliCod) ;
      }
      else
      {
         new web.initests(remoteHandle, context).execute( ) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "antes dellamar a ajustarTiposLiq ", "")) ;
      new web.ajustartiposliq(remoteHandle, context).execute( AV13CliCod, (short)(0), "", "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( "despues dellamar a ajustarTiposLiq ", "")) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, httpContext.getMessage( " llama desde aca despues de ajustar", "")) ;
      new web.grabatipoliqaux(remoteHandle, context).execute( AV13CliCod, "") ;
      AV53ConCodigo = httpContext.getMessage( "basico", "") ;
      AV61actual_ConCodigo.add(AV53ConCodigo, 0);
      GXv_char23[0] = AV53ConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "ANTIGUEDAD", ""), GXv_char23) ;
      inicializardatos.this.AV53ConCodigo = GXv_char23[0] ;
      AV61actual_ConCodigo.add(AV53ConCodigo, 0);
      GXv_char23[0] = AV53ConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "PRESENTISMO", ""), GXv_char23) ;
      inicializardatos.this.AV53ConCodigo = GXv_char23[0] ;
      AV61actual_ConCodigo.add(AV53ConCodigo, 0);
      GXv_char23[0] = AV53ConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "ADICIONAL POR HORAS NOCTURNAS", ""), GXv_char23) ;
      inicializardatos.this.AV53ConCodigo = GXv_char23[0] ;
      AV61actual_ConCodigo.add(AV53ConCodigo, 0);
      if ( ! AV70clienteConvenioEs )
      {
         /* Execute user subroutine: 'GENERAR CABECERAS BASE DE CALCULO EMPRESA' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         new web.copiarbasecalcdepaiaemp(remoteHandle, context).execute( AV31PaiCod, AV13CliCod, (short)(1), 0) ;
         new web.copiarconfhorasextdepaiaemp(remoteHandle, context).execute( AV31PaiCod, AV13CliCod, (short)(1), 0) ;
      }
      GXt_dtime24 = AV86ahora ;
      GXv_dtime25[0] = GXt_dtime24 ;
      new web.getahora(remoteHandle, context).execute( AV13CliCod, GXv_dtime25) ;
      inicializardatos.this.GXt_dtime24 = GXv_dtime25[0] ;
      AV86ahora = GXt_dtime24 ;
      /* Using cursor P001Q37 */
      pr_default.execute(35);
      while ( (pr_default.getStatus(35) != 101) )
      {
         A1876CliRelease = P001Q37_A1876CliRelease[0] ;
         A3CliCod = P001Q37_A3CliCod[0] ;
         A1885CliRelSec = P001Q37_A1885CliRelSec[0] ;
         A1879CliReleaseDes = P001Q37_A1879CliReleaseDes[0] ;
         A1973CliRelNombre = P001Q37_A1973CliRelNombre[0] ;
         if ( A1876CliRelease.after( AV86ahora ) )
         {
            GXv_boolean5[0] = AV88alguienYaActualizo ;
            new web.alguienyaactualizoliberacion(remoteHandle, context).execute( A3CliCod, A1885CliRelSec, GXv_boolean5) ;
            inicializardatos.this.AV88alguienYaActualizo = GXv_boolean5[0] ;
            if ( ! AV88alguienYaActualizo )
            {
               AV87CliUpdRelDesc = GXutil.trim( A1973CliRelNombre) + " - " + A1879CliReleaseDes ;
               new web.newcliente_update(remoteHandle, context).execute( AV13CliCod, A1885CliRelSec, A3CliCod, AV87CliUpdRelDesc, AV89DateTime) ;
            }
         }
         else
         {
            AV87CliUpdRelDesc = GXutil.trim( A1973CliRelNombre) + " - " + A1879CliReleaseDes ;
            new web.newcliente_update(remoteHandle, context).execute( AV13CliCod, A1885CliRelSec, A3CliCod, AV87CliUpdRelDesc, AV86ahora) ;
         }
         pr_default.readNext(35);
      }
      pr_default.close(35);
      if ( false )
      {
      }
      if ( ! AV70clienteConvenioEs )
      {
      }
      else
      {
         if ( ! new web.pruebapostgres(remoteHandle, context).executeUdp( ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            if ( new web.espostgres(remoteHandle, context).executeUdp( AV13CliCod) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               new web.fix_escalas_noviembre_postgres(remoteHandle, context).execute( ) ;
            }
            else
            {
               new web.fix_escalas_noviembre(remoteHandle, context).execute( ) ;
            }
            new web.ajustartarifasdesdediciembre2023(remoteHandle, context).execute( AV13CliCod, AV31PaiCod, 0) ;
         }
      }
      if ( AV13CliCod <= 3 )
      {
         if ( AV13CliCod == 3 )
         {
            new web.capitalizardescripciones(remoteHandle, context).execute( 0) ;
         }
      }
      AV92baseTexto = "" ;
      AV95liquidacionContenedor = httpContext.getMessage( "procesoLiquidacion", "") ;
      AV96procPDFContenedor = httpContext.getMessage( "procesoLiqPDF", "") ;
      AV98procConcAuxContenedor = httpContext.getMessage( "procesoLiqAux", "") ;
      AV99notificacionContenedor = httpContext.getMessage( "aplicacion", "") ;
      AV100soapAgregar = false ;
      new web.newsoap_location(remoteHandle, context).execute( AV13CliCod, new web.id_soap_guardaliq(remoteHandle, context).executeUdp( ), AV100soapAgregar, "/"+GXutil.trim( AV92baseTexto), (byte)(0), GXutil.trim( AV95liquidacionContenedor), new web.puertotomcat(remoteHandle, context).executeUdp( ), GXutil.trim( new web.paquetejava(remoteHandle, context).executeUdp( ))+httpContext.getMessage( "asoap_guardaliquidacion", ""), (byte)(new web.esssl(remoteHandle, context).executeUdp( )), (short)(0)) ;
      new web.newsoap_location(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "procesosSegundoPlanoPDF2_soap", ""), AV100soapAgregar, "/"+GXutil.trim( AV92baseTexto), (byte)(0), GXutil.trim( AV96procPDFContenedor), new web.puertotomcat(remoteHandle, context).executeUdp( ), GXutil.trim( new web.paquetejava(remoteHandle, context).executeUdp( ))+httpContext.getMessage( "asoap_procesossegundoplanopdf", ""), (byte)(new web.esssl(remoteHandle, context).executeUdp( )), (short)(0)) ;
      new web.newsoap_location(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "generarConceptosAuxiliaresPorLote_soap", ""), AV100soapAgregar, "/"+GXutil.trim( AV92baseTexto), (byte)(0), GXutil.trim( AV98procConcAuxContenedor), new web.puertotomcat(remoteHandle, context).executeUdp( ), GXutil.trim( new web.paquetejava(remoteHandle, context).executeUdp( ))+httpContext.getMessage( "asoap_generarconceptosauxiliares", ""), (byte)(new web.esssl(remoteHandle, context).executeUdp( )), (short)(0)) ;
      new web.newsoap_location(remoteHandle, context).execute( AV13CliCod, new web.id_soap_notificacion(remoteHandle, context).executeUdp( ), AV100soapAgregar, "/"+GXutil.trim( AV92baseTexto), (byte)(0), GXutil.trim( AV99notificacionContenedor), new web.puertotomcat(remoteHandle, context).executeUdp( ), GXutil.trim( new web.paquetejava(remoteHandle, context).executeUdp( ))+httpContext.getMessage( "asoap_notification", ""), (byte)(new web.esssl(remoteHandle, context).executeUdp( )), (short)(0)) ;
      new web.ini_rest_locations(remoteHandle, context).execute( AV13CliCod) ;
      new web.grabaparametro(remoteHandle, context).execute( AV13CliCod, httpContext.getMessage( "FIN_INI", ""), httpContext.getMessage( "S", ""), "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV107Pgmname, "8") ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GENERAR CABECERAS BASE DE CALCULO EMPRESA' Routine */
      returnInSub = false ;
      AV120GXV9 = 1 ;
      AV119GXV8 = web.gxdomainclaseleg.getValues() ;
      while ( AV120GXV9 <= AV119GXV8.size() )
      {
         AV54claseLeg = ((Number) AV119GXV8.elementAt(-1+AV120GXV9)).byteValue() ;
         AV122GXV11 = 1 ;
         AV121GXV10 = web.gxdomaintipo_base.getValues() ;
         while ( AV122GXV11 <= AV121GXV10.size() )
         {
            AV55tipo_base = (String)AV121GXV10.elementAt(-1+AV122GXV11) ;
            AV58EmpBaseCod1.clear();
            AV59EmpBaseCod2.clear();
            if ( GXutil.strcmp(AV55tipo_base, "licencia") == 0 )
            {
               GXv_objcol_char26[0] = AV58EmpBaseCod1 ;
               new web.devuelvelicenciasparacalculo(remoteHandle, context).execute( AV13CliCod, AV31PaiCod, GXv_objcol_char26) ;
               AV58EmpBaseCod1 = GXv_objcol_char26[0] ;
            }
            else
            {
               if ( GXutil.strcmp(AV55tipo_base, "feriado") == 0 )
               {
                  AV58EmpBaseCod1.add(new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV13CliCod), 0);
                  AV58EmpBaseCod1.add(new web.palabracod1nolaborableopcional(remoteHandle, context).executeUdp( AV13CliCod), 0);
               }
               else
               {
                  AV58EmpBaseCod1.add("", 0);
               }
            }
            AV56i = (short)(1) ;
            while ( AV56i <= AV58EmpBaseCod1.size() )
            {
               AV59EmpBaseCod2.clear();
               if ( ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.palabracod1nolaborableopcional(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV59EmpBaseCod2.add(new web.palabracod2feriadotrabajado(remoteHandle, context).executeUdp( AV13CliCod), 0);
                  AV59EmpBaseCod2.add(new web.palabracod2feriadonotrabajado(remoteHandle, context).executeUdp( AV13CliCod), 0);
               }
               else
               {
                  AV59EmpBaseCod2.add("", 0);
               }
               AV60i2 = (short)(1) ;
               while ( AV60i2 <= AV59EmpBaseCod2.size() )
               {
                  if ( GXutil.strcmp(AV55tipo_base, "licencia") == 0 )
                  {
                     Cond_result = true ;
                  }
                  else
                  {
                     Cond_result = false ;
                  }
                  if ( Cond_result )
                  {
                     GXv_int11[0] = AV65SitLicMesesProm ;
                     GXv_int10[0] = AV66SitLicMesesProm2 ;
                     new web.getsitdatos(remoteHandle, context).execute( (String)AV58EmpBaseCod1.elementAt(-1+AV56i), GXv_int11, GXv_int10) ;
                     inicializardatos.this.AV65SitLicMesesProm = GXv_int11[0] ;
                     inicializardatos.this.AV66SitLicMesesProm2 = GXv_int10[0] ;
                     AV67EmpBasePromTCnt = "meses" ;
                  }
                  else
                  {
                     if ( GXutil.strcmp(AV55tipo_base, "feriado") == 0 )
                     {
                        AV65SitLicMesesProm = (byte)(30) ;
                        AV66SitLicMesesProm2 = (byte)(0) ;
                        AV67EmpBasePromTCnt = "dias" ;
                     }
                     else
                     {
                        AV65SitLicMesesProm = (byte)(6) ;
                        AV66SitLicMesesProm2 = (byte)(0) ;
                        AV67EmpBasePromTCnt = "meses" ;
                     }
                  }
                  AV123GXLvl1361 = (byte)(0) ;
                  AV124Udparg5 = new web.paisargentina(remoteHandle, context).executeUdp( ) ;
                  /* Using cursor P001Q38 */
                  pr_default.execute(36, new Object[] {Short.valueOf(AV124Udparg5), Byte.valueOf(AV54claseLeg), AV55tipo_base});
                  while ( (pr_default.getStatus(36) != 101) )
                  {
                     A1443PaiBaseCod2 = P001Q38_A1443PaiBaseCod2[0] ;
                     A1442PaiBaseCod1 = P001Q38_A1442PaiBaseCod1[0] ;
                     A1441PaiBaseTipo = P001Q38_A1441PaiBaseTipo[0] ;
                     A1440PaiBaseClaseLeg = P001Q38_A1440PaiBaseClaseLeg[0] ;
                     A46PaiCod = P001Q38_A46PaiCod[0] ;
                     n46PaiCod = P001Q38_n46PaiCod[0] ;
                     if ( GXutil.strcmp(A1442PaiBaseCod1, (String)AV58EmpBaseCod1.elementAt(-1+AV56i)) == 0 )
                     {
                        if ( GXutil.strcmp(A1443PaiBaseCod2, (String)AV59EmpBaseCod2.elementAt(-1+AV60i2)) == 0 )
                        {
                           AV123GXLvl1361 = (byte)(1) ;
                        }
                     }
                     pr_default.readNext(36);
                  }
                  pr_default.close(36);
                  if ( AV123GXLvl1361 == 0 )
                  {
                     /*
                        INSERT RECORD ON TABLE Paisbase_calculo

                     */
                     GXt_int13 = A46PaiCod ;
                     GXv_int14[0] = GXt_int13 ;
                     new web.paisargentina(remoteHandle, context).execute( GXv_int14) ;
                     inicializardatos.this.GXt_int13 = GXv_int14[0] ;
                     A46PaiCod = GXt_int13 ;
                     n46PaiCod = false ;
                     A1440PaiBaseClaseLeg = AV54claseLeg ;
                     A1441PaiBaseTipo = AV55tipo_base ;
                     A1442PaiBaseCod1 = (String)AV58EmpBaseCod1.elementAt(-1+AV56i) ;
                     A1443PaiBaseCod2 = (String)AV59EmpBaseCod2.elementAt(-1+AV60i2) ;
                     if ( ( AV54claseLeg == 1 ) && ( GXutil.strcmp(AV55tipo_base, "licencia") == 0 ) && ( ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), "32") == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), httpContext.getMessage( "E2", "")) == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), httpContext.getMessage( "F1", "")) == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), httpContext.getMessage( "M1", "")) == 0 ) || ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), httpContext.getMessage( "D1", "")) == 0 ) ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        A1444PaiBasePlus = DecimalUtil.stringToDec("0.2") ;
                     }
                     else
                     {
                        if ( ( AV54claseLeg == 1 ) && ( GXutil.strcmp(AV55tipo_base, "feriado") == 0 ) && ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) && ( GXutil.strcmp((String)AV59EmpBaseCod2.elementAt(-1+AV60i2), new web.palabracod2feriadonotrabajado(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) )
                        {
                           Cond_result = true ;
                        }
                        else
                        {
                           Cond_result = false ;
                        }
                        if ( Cond_result )
                        {
                           A1444PaiBasePlus = DecimalUtil.doubleToDec(0) ;
                        }
                        else
                        {
                           if ( ( GXutil.strcmp(AV55tipo_base, "feriado") == 0 ) && ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) && ( GXutil.strcmp((String)AV59EmpBaseCod2.elementAt(-1+AV60i2), new web.palabracod2feriadotrabajado(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              A1444PaiBasePlus = DecimalUtil.doubleToDec(1) ;
                           }
                           else
                           {
                              A1444PaiBasePlus = DecimalUtil.doubleToDec(0) ;
                           }
                        }
                     }
                     if ( ( ( GXutil.strcmp(AV55tipo_base, "feriado") == 0 ) && ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.palabracod1nolaborableopcional(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) ) || ( ( GXutil.strcmp(AV55tipo_base, "licencia") == 0 ) && ( GXutil.strcmp((String)AV58EmpBaseCod1.elementAt(-1+AV56i), new web.estadoausenciasinjustificadas(remoteHandle, context).executeUdp( AV13CliCod)) == 0 ) ) )
                     {
                        Cond_result = true ;
                     }
                     else
                     {
                        Cond_result = false ;
                     }
                     if ( Cond_result )
                     {
                        A1451PaiBasePromCnt1 = (short)(0) ;
                        A1452PaiBasePromCnt2 = (short)(0) ;
                        A1453PaiBasePromTCnt = "" ;
                     }
                     else
                     {
                        A1451PaiBasePromCnt1 = AV65SitLicMesesProm ;
                        A1452PaiBasePromCnt2 = AV66SitLicMesesProm2 ;
                        A1453PaiBasePromTCnt = AV67EmpBasePromTCnt ;
                     }
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Paibaseplus( A1444PaiBasePlus );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdlim( A1629PaiLicDLim );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdseman( A1630PaiLicDSeman );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdmes( A1631PaiLicDMes );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdsemes( A1632PaiLicDSemes );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicdanual( A1633PaiLicDAnual );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicadju( A1634PaiLicAdju );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicadjuobl( A1635PaiLicAdjuObl );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicnecaut( A1636PaiLicNecAut );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicingmot( A1637PaiLicIngMot );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Pailicmotobl( A1638PaiLicMotObl );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromcnt1( A1451PaiBasePromCnt1 );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromcnt2( A1452PaiBasePromCnt2 );
                     AV90Paisbase_old.setgxTv_SdtPaisbase_old_Paibasepromtcnt( A1453PaiBasePromTCnt );
                     A2069PaiBaseOld = AV90Paisbase_old.toJSonString(false, true) ;
                     A1975PaiBaseOldDefault = "" ;
                     A2053PaiBaseRelSec = 0 ;
                     A2054PaiBaseRelRef = "" ;
                     /* Using cursor P001Q39 */
                     pr_default.execute(37, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Byte.valueOf(A1440PaiBaseClaseLeg), A1441PaiBaseTipo, A1442PaiBaseCod1, A1443PaiBaseCod2, A1444PaiBasePlus, Short.valueOf(A1451PaiBasePromCnt1), Short.valueOf(A1452PaiBasePromCnt2), A1453PaiBasePromTCnt, A1975PaiBaseOldDefault, Integer.valueOf(A2053PaiBaseRelSec), A2054PaiBaseRelRef, A2069PaiBaseOld});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("Paisbase_calculo");
                     if ( (pr_default.getStatus(37) == 1) )
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
                  AV62i3 = (short)(1) ;
                  while ( AV62i3 <= AV61actual_ConCodigo.size() )
                  {
                     AV62i3 = (short)(AV62i3+1) ;
                  }
                  AV60i2 = (short)(AV60i2+1) ;
               }
               AV56i = (short)(AV56i+1) ;
            }
            AV122GXV11 = (int)(AV122GXV11+1) ;
         }
         AV120GXV9 = (int)(AV120GXV9+1) ;
      }
   }

   public void S121( )
   {
      /* 'INI BANCOS' Routine */
      returnInSub = false ;
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem27[0] = AV9banco_sdt ;
      new web.ini_bancos(remoteHandle, context).execute( GXv_objcol_Sdtbanco_sdt_banco_sdtItem27) ;
      AV9banco_sdt = GXv_objcol_Sdtbanco_sdt_banco_sdtItem27[0] ;
      AV125GXV12 = 1 ;
      while ( AV125GXV12 <= AV9banco_sdt.size() )
      {
         AV22item = (web.Sdtbanco_sdt_banco_sdtItem)((web.Sdtbanco_sdt_banco_sdtItem)AV9banco_sdt.elementAt(-1+AV125GXV12));
         if ( ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00007") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00011") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00014") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00016") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00017") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00027") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00034") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00072") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00150") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00191") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00259") == 0 ) || ( GXutil.strcmp(AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), "00301") == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV85BanHabilitado = true ;
         }
         else
         {
            AV85BanHabilitado = false ;
         }
         new web.newbanco(remoteHandle, context).execute( AV13CliCod, AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bancod(), GXutil.trim( AV22item.getgxTv_Sdtbanco_sdt_banco_sdtItem_Bandescrip()), "", AV85BanHabilitado, 0, "", 0) ;
         AV125GXV12 = (int)(AV125GXV12+1) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializardatos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV107Pgmname = "" ;
      AV80ConveAdicod = "" ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1824ConveAdiSitCancela = "" ;
      A2050ConveAdiSitCanOld = "" ;
      A2048ConveAdiSitCanRelRef = "" ;
      Gx_emsg = "" ;
      GXt_char2 = "" ;
      cmdBuffer = "" ;
      AV36Seccion = new GXBCCollection<web.SdtSeccion>(web.SdtSeccion.class, "Seccion", "PayDay", remoteHandle);
      GXt_objcol_SdtSeccion6 = new GXBCCollection<web.SdtSeccion>(web.SdtSeccion.class, "Seccion", "PayDay", remoteHandle);
      GXv_objcol_SdtSeccion7 = new GXBCCollection[1] ;
      AV35sec = new web.SdtSeccion(remoteHandle);
      A13SecCodigo = "" ;
      A1240PuestoCodigo = "" ;
      A1241PuestoDescrip = "" ;
      A1242PuestoDescripSinAc = "" ;
      A1989PuestoPadre = "" ;
      A2016PuestoRelRef = "" ;
      A2034PuestoOld = "" ;
      AV20Escolaridad = new GXBCCollection<web.SdtEscolaridad>(web.SdtEscolaridad.class, "Escolaridad", "PayDay", remoteHandle);
      GXt_objcol_SdtEscolaridad8 = new GXBCCollection<web.SdtEscolaridad>(web.SdtEscolaridad.class, "Escolaridad", "PayDay", remoteHandle);
      GXv_objcol_SdtEscolaridad9 = new GXBCCollection[1] ;
      AV19esc = new web.SdtEscolaridad(remoteHandle);
      AV79EmpFracVacAnt = DecimalUtil.ZERO ;
      A2EmpNom = "" ;
      A43ActCodigo = "" ;
      A178EmpDir = "" ;
      A45TipEmpleCod = "" ;
      A1533EmpActComercial = "" ;
      A903ActComCodigo = "" ;
      AV101LocaZona = "" ;
      A44EmpZonCod = "" ;
      A1802EmpPromDesde = "" ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      A1965EmpOsoCod = "" ;
      AV102EmpMesHsPExt = DecimalUtil.ZERO ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      AV103EmpDiaHsPExt = "" ;
      A1302EmpMesHsPExt = DecimalUtil.ZERO ;
      A1303EmpDiaHsPExt = "" ;
      scmdbuf = "" ;
      P001Q29_A9ConveCodigo = new String[] {""} ;
      P001Q29_A46PaiCod = new short[1] ;
      P001Q29_n46PaiCod = new boolean[] {false} ;
      A9ConveCodigo = "" ;
      A1239EmpConvenio = "" ;
      A1525MegTipo = "" ;
      AV27MotivoEgreso = new GXBCCollection<web.SdtMotivoEgreso>(web.SdtMotivoEgreso.class, "MotivoEgreso", "PayDay", remoteHandle);
      GXt_objcol_SdtMotivoEgreso15 = new GXBCCollection<web.SdtMotivoEgreso>(web.SdtMotivoEgreso.class, "MotivoEgreso", "PayDay", remoteHandle);
      GXv_objcol_SdtMotivoEgreso16 = new GXBCCollection[1] ;
      AV26motegr = new web.SdtMotivoEgreso(remoteHandle);
      AV71sitRevMotivo = new web.SdtMotivoEgreso_RevistaAfip(remoteHandle);
      AV33Parentesco = new GXBCCollection<web.SdtParentesco>(web.SdtParentesco.class, "Parentesco", "PayDay", remoteHandle);
      GXt_objcol_SdtParentesco17 = new GXBCCollection<web.SdtParentesco>(web.SdtParentesco.class, "Parentesco", "PayDay", remoteHandle);
      GXv_objcol_SdtParentesco18 = new GXBCCollection[1] ;
      AV32paren = new web.SdtParentesco(remoteHandle);
      AV39TipoLiquidacion = new GXBCCollection<web.SdtTipoLiquidacion>(web.SdtTipoLiquidacion.class, "TipoLiquidacion", "PayDay", remoteHandle);
      GXt_objcol_SdtTipoLiquidacion19 = new GXBCCollection<web.SdtTipoLiquidacion>(web.SdtTipoLiquidacion.class, "TipoLiquidacion", "PayDay", remoteHandle);
      GXv_objcol_SdtTipoLiquidacion20 = new GXBCCollection[1] ;
      AV21ipoLiq = new web.SdtTipoLiquidacion(remoteHandle);
      AV30os_sdt = new GXBaseCollection<web.Sdtos_sdt_os_sdtItem>(web.Sdtos_sdt_os_sdtItem.class, "os_sdtItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtos_sdt_os_sdtItem21 = new GXBaseCollection[1] ;
      AV115GXV6 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29operando = "" ;
      A74idOperando = "" ;
      A2073OpeHelp = "" ;
      AV45OpeCodFormula = "" ;
      AV28OpeCodForMay = "" ;
      A537OpeCodForMay = "" ;
      A474OpeDescripcion = "" ;
      A473OpeCodFormula = "" ;
      A1607OpeProcedure = "" ;
      A2138OpeDetail = "" ;
      GXv_int22 = new long[1] ;
      AV25mensaje = "" ;
      GXv_int1 = new int[1] ;
      A1754DebugPgm = "" ;
      P001Q35_A3CliCod = new int[1] ;
      P001Q35_A38SubTipoConCod1 = new String[] {""} ;
      P001Q35_n38SubTipoConCod1 = new boolean[] {false} ;
      P001Q35_A39SubTipoConCod2 = new String[] {""} ;
      P001Q35_n39SubTipoConCod2 = new boolean[] {false} ;
      P001Q35_A26ConCodigo = new String[] {""} ;
      P001Q35_A148ConFormula = new String[] {""} ;
      P001Q35_n148ConFormula = new boolean[] {false} ;
      P001Q35_A41ConDescrip = new String[] {""} ;
      P001Q35_A953ConCondicion = new String[] {""} ;
      P001Q35_n953ConCondicion = new boolean[] {false} ;
      P001Q35_A954ConCondCodigo = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      A953ConCondicion = "" ;
      A954ConCondCodigo = "" ;
      AV47ConCondicion = "" ;
      GXv_char3 = new String[1] ;
      AV48ConCondCodigo = "" ;
      AV53ConCodigo = "" ;
      AV61actual_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_char23 = new String[1] ;
      AV86ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime24 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime25 = new java.util.Date[1] ;
      P001Q37_A1876CliRelease = new java.util.Date[] {GXutil.nullDate()} ;
      P001Q37_A3CliCod = new int[1] ;
      P001Q37_A1885CliRelSec = new int[1] ;
      P001Q37_A1879CliReleaseDes = new String[] {""} ;
      P001Q37_A1973CliRelNombre = new String[] {""} ;
      A1876CliRelease = GXutil.resetTime( GXutil.nullDate() );
      A1879CliReleaseDes = "" ;
      A1973CliRelNombre = "" ;
      GXv_boolean5 = new boolean[1] ;
      AV87CliUpdRelDesc = "" ;
      AV89DateTime = GXutil.resetTime( GXutil.nullDate() );
      AV92baseTexto = "" ;
      AV95liquidacionContenedor = "" ;
      AV96procPDFContenedor = "" ;
      AV98procConcAuxContenedor = "" ;
      AV99notificacionContenedor = "" ;
      A1453PaiBasePromTCnt = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1975PaiBaseOldDefault = "" ;
      A2054PaiBaseRelRef = "" ;
      A1441PaiBaseTipo = "" ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      A2069PaiBaseOld = "" ;
      AV119GXV8 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV121GXV10 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55tipo_base = "" ;
      AV58EmpBaseCod1 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59EmpBaseCod2 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char26 = new GXSimpleCollection[1] ;
      GXv_int11 = new byte[1] ;
      GXv_int10 = new byte[1] ;
      AV67EmpBasePromTCnt = "" ;
      P001Q38_A1443PaiBaseCod2 = new String[] {""} ;
      P001Q38_A1442PaiBaseCod1 = new String[] {""} ;
      P001Q38_A1441PaiBaseTipo = new String[] {""} ;
      P001Q38_A1440PaiBaseClaseLeg = new byte[1] ;
      P001Q38_A46PaiCod = new short[1] ;
      P001Q38_n46PaiCod = new boolean[] {false} ;
      GXv_int14 = new short[1] ;
      AV90Paisbase_old = new web.SdtPaisbase_old(remoteHandle, context);
      AV9banco_sdt = new GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem>(web.Sdtbanco_sdt_banco_sdtItem.class, "banco_sdtItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtbanco_sdt_banco_sdtItem27 = new GXBaseCollection[1] ;
      AV22item = new web.Sdtbanco_sdt_banco_sdtItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializardatos__default(),
         new Object[] {
             new Object[] {
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
            P001Q29_A9ConveCodigo, P001Q29_A46PaiCod
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
            P001Q35_A3CliCod, P001Q35_A38SubTipoConCod1, P001Q35_n38SubTipoConCod1, P001Q35_A39SubTipoConCod2, P001Q35_n39SubTipoConCod2, P001Q35_A26ConCodigo, P001Q35_A148ConFormula, P001Q35_n148ConFormula, P001Q35_A41ConDescrip, P001Q35_A953ConCondicion,
            P001Q35_n953ConCondicion, P001Q35_A954ConCondCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P001Q37_A1876CliRelease, P001Q37_A3CliCod, P001Q37_A1885CliRelSec, P001Q37_A1879CliReleaseDes, P001Q37_A1973CliRelNombre
            }
            , new Object[] {
            P001Q38_A1443PaiBaseCod2, P001Q38_A1442PaiBaseCod1, P001Q38_A1441PaiBaseTipo, P001Q38_A1440PaiBaseClaseLeg, P001Q38_A46PaiCod
            }
            , new Object[] {
            }
         }
      );
      AV107Pgmname = "InicializarDatos" ;
      /* GeneXus formulas. */
      AV107Pgmname = "InicializarDatos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV84PerfilId ;
   private byte AV83RolId ;
   private byte AV75PaiTipoExpDef ;
   private byte AV77EmpPerVacDes ;
   private byte AV78EmpPerVacHas ;
   private byte A1556EmpGuarEdadMin ;
   private byte A1557EmpGuarEdadMax ;
   private byte A1792EmpTipoExp ;
   private byte A1811EmpPerVacDes ;
   private byte A1812EmpPerVacHas ;
   private byte A2260EmpVacExpTie ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte A1440PaiBaseClaseLeg ;
   private byte AV54claseLeg ;
   private byte AV65SitLicMesesProm ;
   private byte GXv_int11[] ;
   private byte AV66SitLicMesesProm2 ;
   private byte GXv_int10[] ;
   private byte AV123GXLvl1361 ;
   private short AV37SecUserId ;
   private short AV31PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private short A1EmpCod ;
   private short A1151ARTSec ;
   private short A125CatIvaCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short A2265EmpCondiCod ;
   private short AV40ULTIMO_CALC ;
   private short AV43ULTIMO_CALC2 ;
   private short AV42ultimo_ConOrden2 ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short AV56i ;
   private short AV60i2 ;
   private short AV124Udparg5 ;
   private short GXt_int13 ;
   private short GXv_int14[] ;
   private short AV62i3 ;
   private int AV13CliCod ;
   private int AV73padre_CliCod ;
   private int GX_INS245 ;
   private int A3CliCod ;
   private int AV81convenienteCliCod ;
   private int AV109GXV1 ;
   private int GX_INS153 ;
   private int A1987PuestoRelSec ;
   private int A1988PuestoRelSecCli ;
   private int AV110GXV2 ;
   private int GX_INS13 ;
   private int A2261EmpVacDisMax ;
   private int GX_INS144 ;
   private int GX_INS192 ;
   private int AV112GXV3 ;
   private int AV113GXV4 ;
   private int AV114GXV5 ;
   private int AV116GXV7 ;
   private int GX_INS62 ;
   private int AV41ultimo_ConOrden ;
   private int GXv_int1[] ;
   private int GX_INS287 ;
   private int A1885CliRelSec ;
   private int A2053PaiBaseRelSec ;
   private int AV120GXV9 ;
   private int AV122GXV11 ;
   private int GX_INS183 ;
   private int AV125GXV12 ;
   private long AV14CliCUIT ;
   private long AV17EmpCUIT2 ;
   private long AV82MenuVerId ;
   private long A177EmpCUIT ;
   private long GXv_int22[] ;
   private java.math.BigDecimal AV79EmpFracVacAnt ;
   private java.math.BigDecimal A1813EmpFracVacAnt ;
   private java.math.BigDecimal AV102EmpMesHsPExt ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal A1302EmpMesHsPExt ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String AV38TipEmpleCod ;
   private String AV8ActCodigo ;
   private String AV46ActComCodigo ;
   private String AV107Pgmname ;
   private String AV80ConveAdicod ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private String Gx_emsg ;
   private String GXt_char2 ;
   private String cmdBuffer ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String A1989PuestoPadre ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private String A1533EmpActComercial ;
   private String A903ActComCodigo ;
   private String AV101LocaZona ;
   private String A44EmpZonCod ;
   private String A1802EmpPromDesde ;
   private String A1965EmpOsoCod ;
   private String AV103EmpDiaHsPExt ;
   private String A1303EmpDiaHsPExt ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private String A1239EmpConvenio ;
   private String A1525MegTipo ;
   private String AV29operando ;
   private String A74idOperando ;
   private String AV45OpeCodFormula ;
   private String AV28OpeCodForMay ;
   private String A537OpeCodForMay ;
   private String A473OpeCodFormula ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A26ConCodigo ;
   private String A953ConCondicion ;
   private String A954ConCondCodigo ;
   private String AV47ConCondicion ;
   private String GXv_char3[] ;
   private String AV48ConCondCodigo ;
   private String AV53ConCodigo ;
   private String GXv_char23[] ;
   private String A1453PaiBasePromTCnt ;
   private String A1441PaiBaseTipo ;
   private String A1442PaiBaseCod1 ;
   private String A1443PaiBaseCod2 ;
   private String AV55tipo_base ;
   private String AV67EmpBasePromTCnt ;
   private java.util.Date AV86ahora ;
   private java.util.Date GXt_dtime24 ;
   private java.util.Date GXv_dtime25[] ;
   private java.util.Date A1876CliRelease ;
   private java.util.Date AV89DateTime ;
   private boolean AV15CliMultiEmp ;
   private boolean AV72clienteNucleoEs ;
   private boolean AV70clienteConvenioEs ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private boolean AV49esClienteSistema ;
   private boolean GXt_boolean4 ;
   private boolean A1255PuestoHorasExt ;
   private boolean n125CatIvaCod ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private boolean A1524EmpLiqFer ;
   private boolean A1750EmpLiqFerJor ;
   private boolean A1787EmpLiqGan ;
   private boolean A2259EmpVacExpLim ;
   private boolean n1965EmpOsoCod ;
   private boolean n1302EmpMesHsPExt ;
   private boolean n1303EmpDiaHsPExt ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private boolean A1755DebugActivo ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n148ConFormula ;
   private boolean n953ConCondicion ;
   private boolean AV88alguienYaActualizo ;
   private boolean GXv_boolean5[] ;
   private boolean AV100soapAgregar ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
   private boolean AV85BanHabilitado ;
   private String A2050ConveAdiSitCanOld ;
   private String A2034PuestoOld ;
   private String A2073OpeHelp ;
   private String A148ConFormula ;
   private String A1975PaiBaseOldDefault ;
   private String A2069PaiBaseOld ;
   private String AV16CliNom ;
   private String AV18EmpNom2 ;
   private String AV10BaseUrl ;
   private String A2048ConveAdiSitCanRelRef ;
   private String A1241PuestoDescrip ;
   private String A1242PuestoDescripSinAc ;
   private String A2016PuestoRelRef ;
   private String A2EmpNom ;
   private String A178EmpDir ;
   private String A474OpeDescripcion ;
   private String A1607OpeProcedure ;
   private String A2138OpeDetail ;
   private String AV25mensaje ;
   private String A1754DebugPgm ;
   private String A41ConDescrip ;
   private String A1879CliReleaseDes ;
   private String A1973CliRelNombre ;
   private String AV87CliUpdRelDesc ;
   private String AV92baseTexto ;
   private String AV95liquidacionContenedor ;
   private String AV96procPDFContenedor ;
   private String AV98procConcAuxContenedor ;
   private String AV99notificacionContenedor ;
   private String A2054PaiBaseRelRef ;
   private GXSimpleCollection<Byte> AV119GXV8 ;
   private web.SdtPaisbase_old AV90Paisbase_old ;
   private IDataStoreProvider pr_default ;
   private String[] P001Q29_A9ConveCodigo ;
   private short[] P001Q29_A46PaiCod ;
   private boolean[] P001Q29_n46PaiCod ;
   private int[] P001Q35_A3CliCod ;
   private String[] P001Q35_A38SubTipoConCod1 ;
   private boolean[] P001Q35_n38SubTipoConCod1 ;
   private String[] P001Q35_A39SubTipoConCod2 ;
   private boolean[] P001Q35_n39SubTipoConCod2 ;
   private String[] P001Q35_A26ConCodigo ;
   private String[] P001Q35_A148ConFormula ;
   private boolean[] P001Q35_n148ConFormula ;
   private String[] P001Q35_A41ConDescrip ;
   private String[] P001Q35_A953ConCondicion ;
   private boolean[] P001Q35_n953ConCondicion ;
   private String[] P001Q35_A954ConCondCodigo ;
   private java.util.Date[] P001Q37_A1876CliRelease ;
   private int[] P001Q37_A3CliCod ;
   private int[] P001Q37_A1885CliRelSec ;
   private String[] P001Q37_A1879CliReleaseDes ;
   private String[] P001Q37_A1973CliRelNombre ;
   private String[] P001Q38_A1443PaiBaseCod2 ;
   private String[] P001Q38_A1442PaiBaseCod1 ;
   private String[] P001Q38_A1441PaiBaseTipo ;
   private byte[] P001Q38_A1440PaiBaseClaseLeg ;
   private short[] P001Q38_A46PaiCod ;
   private boolean[] P001Q38_n46PaiCod ;
   private GXSimpleCollection<String> AV115GXV6 ;
   private GXSimpleCollection<String> AV61actual_ConCodigo ;
   private GXSimpleCollection<String> AV121GXV10 ;
   private GXSimpleCollection<String> AV58EmpBaseCod1 ;
   private GXSimpleCollection<String> AV59EmpBaseCod2 ;
   private GXSimpleCollection<String> GXv_objcol_char26[] ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> AV9banco_sdt ;
   private GXBaseCollection<web.Sdtbanco_sdt_banco_sdtItem> GXv_objcol_Sdtbanco_sdt_banco_sdtItem27[] ;
   private GXBCCollection<web.SdtEscolaridad> AV20Escolaridad ;
   private GXBCCollection<web.SdtEscolaridad> GXt_objcol_SdtEscolaridad8 ;
   private GXBCCollection<web.SdtEscolaridad> GXv_objcol_SdtEscolaridad9[] ;
   private GXBCCollection<web.SdtTipoLiquidacion> AV39TipoLiquidacion ;
   private GXBCCollection<web.SdtTipoLiquidacion> GXt_objcol_SdtTipoLiquidacion19 ;
   private GXBCCollection<web.SdtTipoLiquidacion> GXv_objcol_SdtTipoLiquidacion20[] ;
   private GXBCCollection<web.SdtMotivoEgreso> AV27MotivoEgreso ;
   private GXBCCollection<web.SdtMotivoEgreso> GXt_objcol_SdtMotivoEgreso15 ;
   private GXBCCollection<web.SdtMotivoEgreso> GXv_objcol_SdtMotivoEgreso16[] ;
   private GXBaseCollection<web.Sdtos_sdt_os_sdtItem> AV30os_sdt ;
   private GXBaseCollection<web.Sdtos_sdt_os_sdtItem> GXv_objcol_Sdtos_sdt_os_sdtItem21[] ;
   private GXBCCollection<web.SdtParentesco> AV33Parentesco ;
   private GXBCCollection<web.SdtParentesco> GXt_objcol_SdtParentesco17 ;
   private GXBCCollection<web.SdtParentesco> GXv_objcol_SdtParentesco18[] ;
   private GXBCCollection<web.SdtSeccion> AV36Seccion ;
   private GXBCCollection<web.SdtSeccion> GXt_objcol_SdtSeccion6 ;
   private GXBCCollection<web.SdtSeccion> GXv_objcol_SdtSeccion7[] ;
   private web.Sdtbanco_sdt_banco_sdtItem AV22item ;
   private web.SdtEscolaridad AV19esc ;
   private web.SdtTipoLiquidacion AV21ipoLiq ;
   private web.SdtMotivoEgreso AV26motegr ;
   private web.SdtMotivoEgreso_RevistaAfip AV71sitRevMotivo ;
   private web.SdtParentesco AV32paren ;
   private web.SdtSeccion AV35sec ;
}

final  class inicializardatos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P001Q2", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q3", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q4", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q5", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q6", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q7", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q8", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q9", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q10", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q11", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q12", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q13", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela, ConveAdiSitCanRelRef, ConveAdiSitCanOld, ConveAdiSitCanRelSec) VALUES(?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q14", "UPDATE ObraSocial SET OsoAporteAdic=0 ", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q15", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q16", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q17", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q18", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q19", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q20", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q21", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q22", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q23", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q24", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q25", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q26", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q27", "SAVEPOINT gxupdate;INSERT INTO Puesto(CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoDescripSinAc, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q28", "SAVEPOINT gxupdate;INSERT INTO Empresa(CliCod, EmpCod, EmpNom, EmpCUIT, CatIvaCod, EmpDir, PaiCod, ProvCod, LocCod, ActCodigo, TipEmpleCod, EmpZonCod, ARTSec, EmpMesHsPExt, EmpDiaHsPExt, EmpLiqFer, EmpActComercial, EmpGuarEdadMin, EmpGuarEdadMax, ActComCodigo, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpPerVacDes, EmpPerVacHas, EmpFracVacAnt, EmpOsoCod, EmpCondiCod, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, CatIvaDesc, EmpTel, EmpCP, EmpReducc, EmpLogo, EmpLogoNom, EmpLogoExt, EmpFirma, EmpFirmaNom, EmpFirmaExt, EmpAntiguedad, EmpPresentismo, EmpUltSexoIng, EmpModTra, EmpModEmpl, EmpModAuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', FALSE, '', '', '', '', '', '', 0, 0, 0, '', FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001Q29", "SELECT ConveCodigo, PaiCod FROM Convenio ORDER BY PaiCod, ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P001Q30", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_convenio(CliCod, EmpCod, EmpConvenio) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q31", "SAVEPOINT gxupdate;INSERT INTO MotEgrTipo(CliCod, MegTipo) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q32", "SAVEPOINT gxupdate;INSERT INTO MotEgrTipo(CliCod, MegTipo) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q33", "SAVEPOINT gxupdate;INSERT INTO calculo(PaiCod, idOperando, OpeCodFormula, OpeDescripcion, OpeCodForMay, OpeEsCant, OpeAliEs, OpeProcedure, OpeHelp, OpeDetail) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P001Q34", "SAVEPOINT gxupdate;INSERT INTO Debug(CliCod, DebugPgm, DebugActivo) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001Q35", "SELECT CliCod, SubTipoConCod1, SubTipoConCod2, ConCodigo, ConFormula, ConDescrip, ConCondicion, ConCondCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P001Q36", "SAVEPOINT gxupdate;UPDATE Concepto SET ConCondicion=?, ConCondCodigo=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P001Q37", "SELECT CliRelease, CliCod, CliRelSec, CliReleaseDes, CliRelNombre FROM Cliente_Release ORDER BY CliCod, CliRelSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001Q38", "SELECT PaiBaseCod2, PaiBaseCod1, PaiBaseTipo, PaiBaseClaseLeg, PaiCod FROM Paisbase_calculo WHERE PaiCod = ? and PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?) ORDER BY PaiCod, PaiBaseClaseLeg, PaiBaseTipo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P001Q39", "SAVEPOINT gxupdate;INSERT INTO Paisbase_calculo(PaiCod, PaiBaseClaseLeg, PaiBaseTipo, PaiBaseCod1, PaiBaseCod2, PaiBasePlus, PaiBasePromCnt1, PaiBasePromCnt2, PaiBasePromTCnt, PaiBaseOldDefault, PaiBaseRelSec, PaiBaseRelRef, PaiBaseOld, PaiLicDLim, PaiLicDSeman, PaiLicDMes, PaiLicDSemes, PaiLicDAnual, PaiLicAdju, PaiLicAdjuObl, PaiLicNecAut, PaiLicIngMot, PaiLicMotObl) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, FALSE, FALSE, FALSE, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 27 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(4, 10);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(6);
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(8, 20);
               return;
            case 35 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 36 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               stmt.setVarchar(6, (String)parms[6], 40, false);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[8]).shortValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(8, ((Number) parms[10]).shortValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[12]).shortValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[14], 8);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 4);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[18], 20);
               }
               stmt.setShort(13, ((Number) parms[19]).shortValue());
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(14, (java.math.BigDecimal)parms[21], 1);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[23], 20);
               }
               stmt.setBoolean(16, ((Boolean) parms[24]).booleanValue());
               stmt.setString(17, (String)parms[25], 20);
               stmt.setByte(18, ((Number) parms[26]).byteValue());
               stmt.setByte(19, ((Number) parms[27]).byteValue());
               stmt.setString(20, (String)parms[28], 20);
               stmt.setBoolean(21, ((Boolean) parms[29]).booleanValue());
               stmt.setBoolean(22, ((Boolean) parms[30]).booleanValue());
               stmt.setByte(23, ((Number) parms[31]).byteValue());
               stmt.setString(24, (String)parms[32], 20);
               stmt.setByte(25, ((Number) parms[33]).byteValue());
               stmt.setByte(26, ((Number) parms[34]).byteValue());
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[35], 4);
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(28, (String)parms[37], 20);
               }
               stmt.setShort(29, ((Number) parms[38]).shortValue());
               stmt.setBoolean(30, ((Boolean) parms[39]).booleanValue());
               stmt.setByte(31, ((Number) parms[40]).byteValue());
               stmt.setInt(32, ((Number) parms[41]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setString(2, (String)parms[2], 40);
               stmt.setString(3, (String)parms[3], 40);
               stmt.setVarchar(4, (String)parms[4], 400, false);
               stmt.setString(5, (String)parms[5], 40);
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[7]).booleanValue());
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               stmt.setVarchar(10, (String)parms[10], 400, false);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 34 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setString(2, (String)parms[2], 20);
               stmt.setInt(3, ((Number) parms[3]).intValue());
               stmt.setString(4, (String)parms[4], 10);
               return;
            case 36 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 37 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setByte(2, ((Number) parms[2]).byteValue());
               stmt.setString(3, (String)parms[3], 20);
               stmt.setString(4, (String)parms[4], 20);
               stmt.setString(5, (String)parms[5], 20);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 4);
               stmt.setShort(7, ((Number) parms[7]).shortValue());
               stmt.setShort(8, ((Number) parms[8]).shortValue());
               stmt.setString(9, (String)parms[9], 20);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               stmt.setInt(11, ((Number) parms[11]).intValue());
               stmt.setVarchar(12, (String)parms[12], 40, false);
               stmt.setNLongVarchar(13, (String)parms[13], false);
               return;
      }
   }

}

