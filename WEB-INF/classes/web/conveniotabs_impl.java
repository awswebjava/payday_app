package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conveniotabs_impl extends GXDataArea
{
   public conveniotabs_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conveniotabs_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniotabs_impl.class ));
   }

   public conveniotabs_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConveDiaHsPExt = new HTMLChoice();
      chkConveFondoCese = UIFactory.getCheckbox(this);
      cmbCatClase = new HTMLChoice();
      cmbCliConveImpTipo = new HTMLChoice();
      cmbavCliconveimptipo = new HTMLChoice();
      cmbConveAdiTipo = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_vacaciones") == 0 )
         {
            gxnrgridlevel_vacaciones_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_vacaciones") == 0 )
         {
            gxgrgridlevel_vacaciones_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylelevel_datos") == 0 )
         {
            gxnrfreestylelevel_datos_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylelevel_datos") == 0 )
         {
            gxgrfreestylelevel_datos_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_valores") == 0 )
         {
            gxnrgridlevel_valores_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_valores") == 0 )
         {
            gxgrgridlevel_valores_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylelevel_categorias") == 0 )
         {
            gxnrfreestylelevel_categorias_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylelevel_categorias") == 0 )
         {
            gxgrfreestylelevel_categorias_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_importes") == 0 )
         {
            gxnrgridlevel_importes_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_importes") == 0 )
         {
            gxgrgridlevel_importes_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_importes2") == 0 )
         {
            gxnrgridlevel_importes2_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_importes2") == 0 )
         {
            gxgrgridlevel_importes2_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_importesdeadicional") == 0 )
         {
            gxnrgridlevel_importesdeadicional_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_importesdeadicional") == 0 )
         {
            gxgrgridlevel_importesdeadicional_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_opciones") == 0 )
         {
            gxnrgridlevel_opciones_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_opciones") == 0 )
         {
            gxgrgridlevel_opciones_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_estadoscancelan") == 0 )
         {
            gxnrgridlevel_estadoscancelan_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlevel_estadoscancelan") == 0 )
         {
            gxgrgridlevel_estadoscancelan_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylelevel_adicionales") == 0 )
         {
            gxnrfreestylelevel_adicionales_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylelevel_adicionales") == 0 )
         {
            gxgrfreestylelevel_adicionales_refresh_invoke( ) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            A3CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_vacaciones_newrow_invoke( )
   {
      nRC_GXsfl_93 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_93"))) ;
      nGXsfl_93_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_93_idx"))) ;
      sGXsfl_93_idx = httpContext.GetPar( "sGXsfl_93_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_vacaciones_newrow( ) ;
      /* End function gxnrGridlevel_vacaciones_newrow_invoke */
   }

   public void gxgrgridlevel_vacaciones_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_vacaciones_refresh_invoke */
   }

   public void gxnrfreestylelevel_datos_newrow_invoke( )
   {
      nRC_GXsfl_36 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_36"))) ;
      nGXsfl_36_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_36_idx"))) ;
      sGXsfl_36_idx = httpContext.GetPar( "sGXsfl_36_idx") ;
      edtCliConveVig_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), !bGXsfl_36_Refreshing);
      cmbConveDiaHsPExt.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveDiaHsPExt.getVisible(), 5, 0), !bGXsfl_36_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylelevel_datos_newrow( ) ;
      /* End function gxnrFreestylelevel_datos_newrow_invoke */
   }

   public void gxgrfreestylelevel_datos_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      edtCliConveVig_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), !bGXsfl_36_Refreshing);
      cmbConveDiaHsPExt.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveDiaHsPExt.getVisible(), 5, 0), !bGXsfl_36_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfreestylelevel_datos_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFreestylelevel_datos_refresh_invoke */
   }

   public void gxnrgridlevel_valores_newrow_invoke( )
   {
      nRC_GXsfl_166 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_166"))) ;
      nGXsfl_166_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_166_idx"))) ;
      sGXsfl_166_idx = httpContext.GetPar( "sGXsfl_166_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_valores_newrow( ) ;
      /* End function gxnrGridlevel_valores_newrow_invoke */
   }

   public void gxgrgridlevel_valores_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_valores_refresh_invoke */
   }

   public void gxnrfreestylelevel_categorias_newrow_invoke( )
   {
      nRC_GXsfl_130 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_130"))) ;
      nGXsfl_130_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_130_idx"))) ;
      sGXsfl_130_idx = httpContext.GetPar( "sGXsfl_130_idx") ;
      cmbCatClase.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Visible", GXutil.ltrimstr( cmbCatClase.getVisible(), 5, 0), !bGXsfl_130_Refreshing);
      edtCatFrecAct_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatFrecAct_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatFrecAct_Visible), 5, 0), !bGXsfl_130_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylelevel_categorias_newrow( ) ;
      /* End function gxnrFreestylelevel_categorias_newrow_invoke */
   }

   public void gxgrfreestylelevel_categorias_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      cmbCatClase.setVisible( (int)(GXutil.lval( httpContext.GetNextPar( ))) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Visible", GXutil.ltrimstr( cmbCatClase.getVisible(), 5, 0), !bGXsfl_130_Refreshing);
      edtCatFrecAct_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatFrecAct_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatFrecAct_Visible), 5, 0), !bGXsfl_130_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfreestylelevel_categorias_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFreestylelevel_categorias_refresh_invoke */
   }

   public void gxnrgridlevel_importes_newrow_invoke( )
   {
      nRC_GXsfl_194 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_194"))) ;
      nGXsfl_194_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_194_idx"))) ;
      sGXsfl_194_idx = httpContext.GetPar( "sGXsfl_194_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_importes_newrow( ) ;
      /* End function gxnrGridlevel_importes_newrow_invoke */
   }

   public void gxgrgridlevel_importes_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_importes_refresh_invoke */
   }

   public void gxnrgridlevel_importes2_newrow_invoke( )
   {
      nRC_GXsfl_204 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_204"))) ;
      nGXsfl_204_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_204_idx"))) ;
      sGXsfl_204_idx = httpContext.GetPar( "sGXsfl_204_idx") ;
      AV32CliConveImpVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveImpVig")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_importes2_newrow( ) ;
      /* End function gxnrGridlevel_importes2_newrow_invoke */
   }

   public void gxgrgridlevel_importes2_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      AV32CliConveImpVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveImpVig")) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A1587CliConveImpVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveImpVig")) ;
      cmbCliConveImpTipo.fromJSonString( httpContext.GetNextPar( ));
      A1588CliConveImpTipo = httpContext.GetPar( "CliConveImpTipo") ;
      A1589CliConveImporte = CommonUtil.decimalVal( httpContext.GetPar( "CliConveImporte"), ".") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_importes2_refresh_invoke */
   }

   public void gxnrgridlevel_importesdeadicional_newrow_invoke( )
   {
      nRC_GXsfl_265 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_265"))) ;
      nGXsfl_265_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_265_idx"))) ;
      sGXsfl_265_idx = httpContext.GetPar( "sGXsfl_265_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_importesdeadicional_newrow( ) ;
      /* End function gxnrGridlevel_importesdeadicional_newrow_invoke */
   }

   public void gxgrgridlevel_importesdeadicional_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_importesdeadicional_refresh_invoke */
   }

   public void gxnrgridlevel_opciones_newrow_invoke( )
   {
      nRC_GXsfl_277 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_277"))) ;
      nGXsfl_277_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_277_idx"))) ;
      sGXsfl_277_idx = httpContext.GetPar( "sGXsfl_277_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_opciones_newrow( ) ;
      /* End function gxnrGridlevel_opciones_newrow_invoke */
   }

   public void gxgrgridlevel_opciones_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_opciones_refresh_invoke */
   }

   public void gxnrgridlevel_estadoscancelan_newrow_invoke( )
   {
      nRC_GXsfl_291 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_291"))) ;
      nGXsfl_291_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_291_idx"))) ;
      sGXsfl_291_idx = httpContext.GetPar( "sGXsfl_291_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_estadoscancelan_newrow( ) ;
      /* End function gxnrGridlevel_estadoscancelan_newrow_invoke */
   }

   public void gxgrgridlevel_estadoscancelan_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridlevel_estadoscancelan_refresh_invoke */
   }

   public void gxnrfreestylelevel_adicionales_newrow_invoke( )
   {
      nRC_GXsfl_218 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_218"))) ;
      nGXsfl_218_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_218_idx"))) ;
      sGXsfl_218_idx = httpContext.GetPar( "sGXsfl_218_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylelevel_adicionales_newrow( ) ;
      /* End function gxnrFreestylelevel_adicionales_newrow_invoke */
   }

   public void gxgrfreestylelevel_adicionales_refresh_invoke( )
   {
      subGridlevel_vacaciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_vacaciones_Rows"))) ;
      subGridlevel_valores_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_valores_Rows"))) ;
      subGridlevel_importes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes_Rows"))) ;
      subGridlevel_importes2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importes2_Rows"))) ;
      subGridlevel_importesdeadicional_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_importesdeadicional_Rows"))) ;
      subGridlevel_opciones_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_opciones_Rows"))) ;
      subGridlevel_estadoscancelan_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridlevel_estadoscancelan_Rows"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
      A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfreestylelevel_adicionales_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFreestylelevel_adicionales_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      paLV2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startLV2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.conveniotabs", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio))}, new String[] {"CliCod","CliPaiConve","CliConvenio"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_36", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_36, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_130", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_130, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_194", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_194, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_204", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_204, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_218", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_218, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_estadoscancelan_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERER_Infinitescrolling", GXutil.rtrim( Gridlevel_estadoscancelan_empowerer_Infinitescrolling));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_OPCIONES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_opciones_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTESDEADICIONAL_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_importesdeadicional_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_importes2_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_importes_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VALORES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_valores_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_VACACIONES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridlevel_vacaciones_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVEVIG_Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveVig_Visible, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEDIAHSPEXT_Visible", GXutil.ltrim( localUtil.ntoc( cmbConveDiaHsPExt.getVisible(), (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weLV2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtLV2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.conveniotabs", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1564CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(A1565CliConvenio))}, new String[] {"CliCod","CliPaiConve","CliConvenio"})  ;
   }

   public String getPgmname( )
   {
      return "ConvenioTabs" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio Tabs", "") ;
   }

   public void wbLV0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_LV2( true) ;
      }
      else
      {
         wb_table1_9_LV2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_LV2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, 0, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConvenioTabs.htm");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, 0, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ConvenioTabs.htm");
         /* User Defined Control */
         ucGridlevel_estadoscancelan_empowerer.setProperty("InfiniteScrolling", Gridlevel_estadoscancelan_empowerer_Infinitescrolling);
         ucGridlevel_estadoscancelan_empowerer.render(context, "wwp.gridempowerer", Gridlevel_estadoscancelan_empowerer_Internalname, "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_opciones_empowerer.render(context, "wwp.gridempowerer", Gridlevel_opciones_empowerer_Internalname, "GRIDLEVEL_OPCIONES_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_importesdeadicional_empowerer.render(context, "wwp.gridempowerer", Gridlevel_importesdeadicional_empowerer_Internalname, "GRIDLEVEL_IMPORTESDEADICIONAL_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_importes2_empowerer.render(context, "wwp.gridempowerer", Gridlevel_importes2_empowerer_Internalname, "GRIDLEVEL_IMPORTES2_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_importes_empowerer.render(context, "wwp.gridempowerer", Gridlevel_importes_empowerer_Internalname, "GRIDLEVEL_IMPORTES_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_valores_empowerer.render(context, "wwp.gridempowerer", Gridlevel_valores_empowerer_Internalname, "GRIDLEVEL_VALORES_EMPOWERERContainer");
         /* User Defined Control */
         ucGridlevel_vacaciones_empowerer.render(context, "wwp.gridempowerer", Gridlevel_vacaciones_empowerer_Internalname, "GRIDLEVEL_VACACIONES_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 36 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Freestylelevel_datosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_datos", Freestylelevel_datosContainer, subFreestylelevel_datos_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_datosContainerData", Freestylelevel_datosContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_datosContainerData"+"V", Freestylelevel_datosContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_datosContainerData"+"V"+"\" value='"+Freestylelevel_datosContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 93 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nEOF", GRIDLEVEL_VACACIONES_nEOF);
               Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_vacacionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_vacaciones", Gridlevel_vacacionesContainer, subGridlevel_vacaciones_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData", Gridlevel_vacacionesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData"+"V", Gridlevel_vacacionesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_vacacionesContainerData"+"V"+"\" value='"+Gridlevel_vacacionesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 130 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Freestylelevel_categoriasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_categorias", Freestylelevel_categoriasContainer, subFreestylelevel_categorias_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_categoriasContainerData", Freestylelevel_categoriasContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_categoriasContainerData"+"V", Freestylelevel_categoriasContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_categoriasContainerData"+"V"+"\" value='"+Freestylelevel_categoriasContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 166 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_valoresContainer.AddObjectProperty("GRIDLEVEL_VALORES_nEOF", GRIDLEVEL_VALORES_nEOF);
               Gridlevel_valoresContainer.AddObjectProperty("GRIDLEVEL_VALORES_nFirstRecordOnPage", GRIDLEVEL_VALORES_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_valoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_valores", Gridlevel_valoresContainer, subGridlevel_valores_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData", Gridlevel_valoresContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"V", Gridlevel_valoresContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_valoresContainerData"+"V"+"\" value='"+Gridlevel_valoresContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 194 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_importesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_importesContainer.AddObjectProperty("GRIDLEVEL_IMPORTES_nEOF", GRIDLEVEL_IMPORTES_nEOF);
               Gridlevel_importesContainer.AddObjectProperty("GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GRIDLEVEL_IMPORTES_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_importesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importes", Gridlevel_importesContainer, subGridlevel_importes_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData", Gridlevel_importesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData"+"V", Gridlevel_importesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesContainerData"+"V"+"\" value='"+Gridlevel_importesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 204 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_importes2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_importes2Container.AddObjectProperty("GRIDLEVEL_IMPORTES2_nEOF", GRIDLEVEL_IMPORTES2_nEOF);
               Gridlevel_importes2Container.AddObjectProperty("GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GRIDLEVEL_IMPORTES2_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_importes2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importes2", Gridlevel_importes2Container, subGridlevel_importes2_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importes2ContainerData", Gridlevel_importes2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importes2ContainerData"+"V", Gridlevel_importes2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importes2ContainerData"+"V"+"\" value='"+Gridlevel_importes2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 218 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Freestylelevel_adicionalesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_adicionales", Freestylelevel_adicionalesContainer, subFreestylelevel_adicionales_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_adicionalesContainerData", Freestylelevel_adicionalesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_adicionalesContainerData"+"V", Freestylelevel_adicionalesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_adicionalesContainerData"+"V"+"\" value='"+Freestylelevel_adicionalesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 265 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_importesdeadicionalContainer.AddObjectProperty("GRIDLEVEL_IMPORTESDEADICIONAL_nEOF", GRIDLEVEL_IMPORTESDEADICIONAL_nEOF);
               Gridlevel_importesdeadicionalContainer.AddObjectProperty("GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage", GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_importesdeadicionalContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importesdeadicional", Gridlevel_importesdeadicionalContainer, subGridlevel_importesdeadicional_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesdeadicionalContainerData", Gridlevel_importesdeadicionalContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesdeadicionalContainerData"+"V", Gridlevel_importesdeadicionalContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesdeadicionalContainerData"+"V"+"\" value='"+Gridlevel_importesdeadicionalContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 277 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_opcionesContainer.AddObjectProperty("GRIDLEVEL_OPCIONES_nEOF", GRIDLEVEL_OPCIONES_nEOF);
               Gridlevel_opcionesContainer.AddObjectProperty("GRIDLEVEL_OPCIONES_nFirstRecordOnPage", GRIDLEVEL_OPCIONES_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_opcionesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_opciones", Gridlevel_opcionesContainer, subGridlevel_opciones_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData", Gridlevel_opcionesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData"+"V", Gridlevel_opcionesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_opcionesContainerData"+"V"+"\" value='"+Gridlevel_opcionesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 291 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridlevel_estadoscancelanContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridlevel_estadoscancelanContainer.AddObjectProperty("GRIDLEVEL_ESTADOSCANCELAN_nEOF", GRIDLEVEL_ESTADOSCANCELAN_nEOF);
               Gridlevel_estadoscancelanContainer.AddObjectProperty("GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage", GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridlevel_estadoscancelanContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_estadoscancelan", Gridlevel_estadoscancelanContainer, subGridlevel_estadoscancelan_Internalname);
               if ( ! isAjaxCallMode( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_estadoscancelanContainerData", Gridlevel_estadoscancelanContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_estadoscancelanContainerData"+"V", Gridlevel_estadoscancelanContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_estadoscancelanContainerData"+"V"+"\" value='"+Gridlevel_estadoscancelanContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startLV2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio Tabs", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupLV0( ) ;
   }

   public void wsLV2( )
   {
      startLV2( ) ;
      evtLV2( ) ;
   }

   public void evtLV2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VACACIONESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_VACACIONESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_vacaciones_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_vacaciones_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_vacaciones_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_vacaciones_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VALORESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_VALORESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_valores_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_valores_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_valores_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_valores_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_IMPORTESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_importes_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_importes_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_importes_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_importes_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTES2PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_IMPORTES2PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_importes2_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_importes2_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_importes2_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_importes2_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTESDEADICIONALPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_IMPORTESDEADICIONALPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_importesdeadicional_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_importesdeadicional_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_importesdeadicional_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_importesdeadicional_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_OPCIONESPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_OPCIONESPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_opciones_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_opciones_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_opciones_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_opciones_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDLEVEL_ESTADOSCANCELANPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDLEVEL_ESTADOSCANCELANPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridlevel_estadoscancelan_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridlevel_estadoscancelan_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridlevel_estadoscancelan_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridlevel_estadoscancelan_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "FREESTYLELEVEL_DATOS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDLEVEL_VACACIONES.LOAD") == 0 ) )
                        {
                           nGXsfl_36_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_362( ) ;
                           GXCCtl = "GRIDLEVEL_VACACIONES_Rows_" + sGXsfl_36_idx ;
                           subGridlevel_vacaciones_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_VACACIONES_Rows_" + sGXsfl_36_idx ;
                           web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Width_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Width = httpContext.cgiGet( GXCCtl) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "Width", Dvpanel_unnamedtable20_Width);
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autowidth_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Autowidth = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "AutoWidth", GXutil.booltostr( Dvpanel_unnamedtable20_Autowidth));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autoheight_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Autoheight = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "AutoHeight", GXutil.booltostr( Dvpanel_unnamedtable20_Autoheight));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Cls_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Cls = httpContext.cgiGet( GXCCtl) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "Cls", Dvpanel_unnamedtable20_Cls);
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Title_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Title = httpContext.cgiGet( GXCCtl) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "Title", Dvpanel_unnamedtable20_Title);
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Collapsible_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Collapsible = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "Collapsible", GXutil.booltostr( Dvpanel_unnamedtable20_Collapsible));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Collapsed_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Collapsed = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "Collapsed", GXutil.booltostr( Dvpanel_unnamedtable20_Collapsed));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Showcollapseicon_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "ShowCollapseIcon", GXutil.booltostr( Dvpanel_unnamedtable20_Showcollapseicon));
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Iconposition_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Iconposition = httpContext.cgiGet( GXCCtl) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "IconPosition", Dvpanel_unnamedtable20_Iconposition);
                           GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autoscroll_" + sGXsfl_36_idx ;
                           Dvpanel_unnamedtable20_Autoscroll = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucDvpanel_unnamedtable20.sendProperty(context, "", false, Dvpanel_unnamedtable20_Internalname, "AutoScroll", GXutil.booltostr( Dvpanel_unnamedtable20_Autoscroll));
                           A1575CliConveVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtCliConveVig_Internalname), 0)) ;
                           A1269ConveMesHsPExt = localUtil.ctond( httpContext.cgiGet( edtConveMesHsPExt_Internalname)) ;
                           cmbConveDiaHsPExt.setName( cmbConveDiaHsPExt.getInternalname() );
                           cmbConveDiaHsPExt.setValue( httpContext.cgiGet( cmbConveDiaHsPExt.getInternalname()) );
                           A1270ConveDiaHsPExt = httpContext.cgiGet( cmbConveDiaHsPExt.getInternalname()) ;
                           n1270ConveDiaHsPExt = false ;
                           A1401ConveFondoCese = GXutil.strtobool( httpContext.cgiGet( chkConveFondoCese.getInternalname())) ;
                           A1043ConveInterDiasJor = (short)(localUtil.ctol( httpContext.cgiGet( edtConveInterDiasJor_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1046ConveMinMesesVac = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveMinMesesVac_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1627ConveGuarEdadMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1627ConveGuarEdadMin = false ;
                           A1628ConveGuarEdadMax = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveGuarEdadMax_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           n1628ConveGuarEdadMax = false ;
                           GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
                           GRIDLEVEL_VACACIONES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_VACACIONES_nEOF_" + sGXsfl_36_idx ;
                           GRIDLEVEL_VACACIONES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_93_" + sGXsfl_36_idx ;
                           nRC_GXsfl_93 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e11LV2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FREESTYLELEVEL_DATOS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e12LV2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDLEVEL_VACACIONES.LOAD") == 0 )
                              {
                                 nGXsfl_93_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") + sGXsfl_36_idx ;
                                 subsflControlProps_9312( ) ;
                                 A1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                                 A1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                                 A1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                                 A1902ConveVacRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveVacRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VACACIONES.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e13LV12 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 30), "FREESTYLELEVEL_CATEGORIAS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 22), "GRIDLEVEL_VALORES.LOAD") == 0 ) )
                        {
                           nGXsfl_130_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_130_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_130_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_13010( ) ;
                           GXCCtl = "GRIDLEVEL_VALORES_Rows_" + sGXsfl_130_idx ;
                           subGridlevel_valores_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_VALORES_Rows_" + sGXsfl_130_idx ;
                           web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Rows, (byte)(6), (byte)(0), ".", "")));
                           A8CatCodigo = httpContext.cgiGet( edtCatCodigo_Internalname) ;
                           A123CatDescrip = httpContext.cgiGet( edtCatDescrip_Internalname) ;
                           cmbCatClase.setName( cmbCatClase.getInternalname() );
                           cmbCatClase.setValue( httpContext.cgiGet( cmbCatClase.getInternalname()) );
                           A1838CatClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbCatClase.getInternalname()))) ;
                           A1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( edtCatFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
                           GRIDLEVEL_VALORES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_VALORES_nEOF_" + sGXsfl_130_idx ;
                           GRIDLEVEL_VALORES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_166_" + sGXsfl_130_idx ;
                           nRC_GXsfl_166 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "FREESTYLELEVEL_CATEGORIAS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14LV10 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( GXutil.strcmp(GXutil.left( sEvt, 22), "GRIDLEVEL_VALORES.LOAD") == 0 )
                              {
                                 nGXsfl_166_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") + sGXsfl_130_idx ;
                                 subsflControlProps_16611( ) ;
                                 A907CatVigencia = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtCatVigencia_Internalname), 0)) ;
                                 A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
                                 A1893EscAdicional = localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_VALORES.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e15LV11 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLEVEL_IMPORTES.LOAD") == 0 )
                        {
                           nGXsfl_194_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1949( ) ;
                           A1587CliConveImpVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtCliConveImpVig_Internalname), 0)) ;
                           cmbCliConveImpTipo.setName( cmbCliConveImpTipo.getInternalname() );
                           cmbCliConveImpTipo.setValue( httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) );
                           A1588CliConveImpTipo = httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) ;
                           A1589CliConveImporte = localUtil.ctond( httpContext.cgiGet( edtCliConveImporte_Internalname)) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e16LV9 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 24), "GRIDLEVEL_IMPORTES2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLEVEL_IMPORTES.LOAD") == 0 ) )
                        {
                           nGXsfl_204_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_204_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_204_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2047( ) ;
                           GXCCtl = "GRIDLEVEL_IMPORTES_Rows_" + sGXsfl_204_idx ;
                           subGridlevel_importes_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Rows, (byte)(6), (byte)(0), ".", "")));
                           AV32CliConveImpVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtavCliconveimpvig_Internalname), 0)) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCliconveimpvig_Internalname, localUtil.format(AV32CliConveImpVig, "99/99/99"));
                           web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG"+"_"+sGXsfl_204_idx, getSecureSignedToken( sGXsfl_204_idx, AV32CliConveImpVig));
                           cmbavCliconveimptipo.setName( cmbavCliconveimptipo.getInternalname() );
                           cmbavCliconveimptipo.setValue( httpContext.cgiGet( cmbavCliconveimptipo.getInternalname()) );
                           AV35CliConveImpTipo = httpContext.cgiGet( cmbavCliconveimptipo.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavCliconveimptipo.getInternalname(), AV35CliConveImpTipo);
                           AV36CliConveImporte = localUtil.ctond( httpContext.cgiGet( edtavCliconveimporte_Internalname)) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCliconveimporte_Internalname, GXutil.ltrimstr( AV36CliConveImporte, 14, 2));
                           GXCCtl = "GRIDLEVEL_IMPORTES_nFirstRecordOnPage_" + sGXsfl_204_idx ;
                           GRIDLEVEL_IMPORTES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_IMPORTES_nEOF_" + sGXsfl_204_idx ;
                           GRIDLEVEL_IMPORTES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_194_" + sGXsfl_204_idx ;
                           nRC_GXsfl_194 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTES2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17LV7 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLEVEL_IMPORTES.LOAD") == 0 )
                              {
                                 nGXsfl_194_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
                                 subsflControlProps_1949( ) ;
                                 A1587CliConveImpVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtCliConveImpVig_Internalname), 0)) ;
                                 cmbCliConveImpTipo.setName( cmbCliConveImpTipo.getInternalname() );
                                 cmbCliConveImpTipo.setValue( httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) );
                                 A1588CliConveImpTipo = httpContext.cgiGet( cmbCliConveImpTipo.getInternalname()) ;
                                 A1589CliConveImporte = localUtil.ctond( httpContext.cgiGet( edtCliConveImporte_Internalname)) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTES.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e16LV9 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 31), "FREESTYLELEVEL_ADICIONALES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 34), "GRIDLEVEL_IMPORTESDEADICIONAL.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLEVEL_OPCIONES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 30), "GRIDLEVEL_ESTADOSCANCELAN.LOAD") == 0 ) )
                        {
                           nGXsfl_218_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_218_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_218_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2183( ) ;
                           GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_Rows_" + sGXsfl_218_idx ;
                           subGridlevel_importesdeadicional_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_Rows_" + sGXsfl_218_idx ;
                           web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Rows, (byte)(6), (byte)(0), ".", "")));
                           GXCCtl = "GRIDLEVEL_OPCIONES_Rows_" + sGXsfl_218_idx ;
                           subGridlevel_opciones_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_OPCIONES_Rows_" + sGXsfl_218_idx ;
                           web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Rows, (byte)(6), (byte)(0), ".", "")));
                           GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_Rows_" + sGXsfl_218_idx ;
                           subGridlevel_estadoscancelan_Rows = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_Rows_" + sGXsfl_218_idx ;
                           web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Rows, (byte)(6), (byte)(0), ".", "")));
                           A996ConveAdicod = httpContext.cgiGet( edtConveAdicod_Internalname) ;
                           A997ConveAdiDescri = httpContext.cgiGet( edtConveAdiDescri_Internalname) ;
                           A998ConveAdiAli = localUtil.ctond( httpContext.cgiGet( edtConveAdiAli_Internalname)) ;
                           A1019ConveAdiInfo = httpContext.cgiGet( edtConveAdiInfo_Internalname) ;
                           n1019ConveAdiInfo = false ;
                           cmbConveAdiTipo.setName( cmbConveAdiTipo.getInternalname() );
                           cmbConveAdiTipo.setValue( httpContext.cgiGet( cmbConveAdiTipo.getInternalname()) );
                           A1803ConveAdiTipo = httpContext.cgiGet( cmbConveAdiTipo.getInternalname()) ;
                           GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
                           GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
                           GRIDLEVEL_OPCIONES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
                           GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nEOF_" + sGXsfl_218_idx ;
                           GRIDLEVEL_IMPORTESDEADICIONAL_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_OPCIONES_nEOF_" + sGXsfl_218_idx ;
                           GRIDLEVEL_OPCIONES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nEOF_" + sGXsfl_218_idx ;
                           GRIDLEVEL_ESTADOSCANCELAN_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_265_" + sGXsfl_218_idx ;
                           nRC_GXsfl_265 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_277_" + sGXsfl_218_idx ;
                           nRC_GXsfl_277 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           GXCCtl = "nRC_GXsfl_291_" + sGXsfl_218_idx ;
                           nRC_GXsfl_291 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "FREESTYLELEVEL_ADICIONALES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18LV3 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                              sEvtType = GXutil.right( sEvt, 4) ;
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                              if ( GXutil.strcmp(GXutil.left( sEvt, 34), "GRIDLEVEL_IMPORTESDEADICIONAL.LOAD") == 0 )
                              {
                                 nGXsfl_265_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_265_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_265_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
                                 subsflControlProps_2656( ) ;
                                 A999ConveAdiVig = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtConveAdiVig_Internalname), 0)) ;
                                 A1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_IMPORTESDEADICIONAL.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e19LV6 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                              else if ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLEVEL_OPCIONES.LOAD") == 0 )
                              {
                                 nGXsfl_277_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_277_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_277_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
                                 subsflControlProps_2775( ) ;
                                 A1011ConveAdiOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                                 A1021ConveAdiOpcFor = httpContext.cgiGet( edtConveAdiOpcFor_Internalname) ;
                                 A1012ConveAdiOpcDes = httpContext.cgiGet( edtConveAdiOpcDes_Internalname) ;
                                 A1013ConveAdiOpcAli = localUtil.ctond( httpContext.cgiGet( edtConveAdiOpcAli_Internalname)) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_OPCIONES.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e20LV5 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                              else if ( GXutil.strcmp(GXutil.left( sEvt, 30), "GRIDLEVEL_ESTADOSCANCELAN.LOAD") == 0 )
                              {
                                 nGXsfl_291_idx = (int)(GXutil.lval( sEvtType)) ;
                                 sGXsfl_291_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_291_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
                                 subsflControlProps_2914( ) ;
                                 A1824ConveAdiSitCancela = httpContext.cgiGet( edtConveAdiSitCancela_Internalname) ;
                                 sEvtType = GXutil.right( sEvt, 1) ;
                                 if ( GXutil.strcmp(sEvtType, ".") == 0 )
                                 {
                                    sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                                    if ( GXutil.strcmp(sEvt, "GRIDLEVEL_ESTADOSCANCELAN.LOAD") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                       e21LV4 ();
                                    }
                                    else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                                    {
                                       httpContext.wbHandled = (byte)(1) ;
                                       dynload_actions( ) ;
                                    }
                                 }
                                 else
                                 {
                                 }
                              }
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weLV2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void paLV2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrfreestylelevel_datos_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_362( ) ;
      while ( nGXsfl_36_idx <= nRC_GXsfl_36 )
      {
         sendrow_362( ) ;
         nGXsfl_36_idx = ((subFreestylelevel_datos_Islastpage==1)&&(nGXsfl_36_idx+1>subfreestylelevel_datos_fnc_recordsperpage( )) ? 1 : nGXsfl_36_idx+1) ;
         sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_362( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylelevel_datosContainer)) ;
      /* End function gxnrFreestylelevel_datos_newrow */
   }

   public void gxnrfreestylelevel_adicionales_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2183( ) ;
      while ( nGXsfl_218_idx <= nRC_GXsfl_218 )
      {
         sendrow_2183( ) ;
         nGXsfl_218_idx = ((subFreestylelevel_adicionales_Islastpage==1)&&(nGXsfl_218_idx+1>subfreestylelevel_adicionales_fnc_recordsperpage( )) ? 1 : nGXsfl_218_idx+1) ;
         sGXsfl_218_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_218_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2183( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylelevel_adicionalesContainer)) ;
      /* End function gxnrFreestylelevel_adicionales_newrow */
   }

   public void gxnrgridlevel_estadoscancelan_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2914( ) ;
      while ( nGXsfl_291_idx <= nRC_GXsfl_291 )
      {
         sendrow_2914( ) ;
         nGXsfl_291_idx = ((subGridlevel_estadoscancelan_Islastpage==1)&&(nGXsfl_291_idx+1>subgridlevel_estadoscancelan_fnc_recordsperpage( )) ? 1 : nGXsfl_291_idx+1) ;
         sGXsfl_291_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_291_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2914( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_estadoscancelanContainer)) ;
      /* End function gxnrGridlevel_estadoscancelan_newrow */
   }

   public void gxnrgridlevel_opciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2775( ) ;
      while ( nGXsfl_277_idx <= nRC_GXsfl_277 )
      {
         sendrow_2775( ) ;
         nGXsfl_277_idx = ((subGridlevel_opciones_Islastpage==1)&&(nGXsfl_277_idx+1>subgridlevel_opciones_fnc_recordsperpage( )) ? 1 : nGXsfl_277_idx+1) ;
         sGXsfl_277_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_277_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2775( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_opcionesContainer)) ;
      /* End function gxnrGridlevel_opciones_newrow */
   }

   public void gxnrgridlevel_importesdeadicional_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2656( ) ;
      while ( nGXsfl_265_idx <= nRC_GXsfl_265 )
      {
         sendrow_2656( ) ;
         nGXsfl_265_idx = ((subGridlevel_importesdeadicional_Islastpage==1)&&(nGXsfl_265_idx+1>subgridlevel_importesdeadicional_fnc_recordsperpage( )) ? 1 : nGXsfl_265_idx+1) ;
         sGXsfl_265_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_265_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2656( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_importesdeadicionalContainer)) ;
      /* End function gxnrGridlevel_importesdeadicional_newrow */
   }

   public void gxnrgridlevel_importes2_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2047( ) ;
      while ( nGXsfl_204_idx <= nRC_GXsfl_204 )
      {
         sendrow_2047( ) ;
         nGXsfl_204_idx = ((subGridlevel_importes2_Islastpage==1)&&(nGXsfl_204_idx+1>subgridlevel_importes2_fnc_recordsperpage( )) ? 1 : nGXsfl_204_idx+1) ;
         sGXsfl_204_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_204_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2047( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_importes2Container)) ;
      /* End function gxnrGridlevel_importes2_newrow */
   }

   public void gxnrgridlevel_importes_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1949( ) ;
      while ( nGXsfl_194_idx <= nRC_GXsfl_194 )
      {
         sendrow_1949( ) ;
         nGXsfl_194_idx = ((subGridlevel_importes_Islastpage==1)&&(nGXsfl_194_idx+1>subgridlevel_importes_fnc_recordsperpage( )) ? 1 : nGXsfl_194_idx+1) ;
         sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1949( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_importesContainer)) ;
      /* End function gxnrGridlevel_importes_newrow */
   }

   public void gxnrfreestylelevel_categorias_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_13010( ) ;
      while ( nGXsfl_130_idx <= nRC_GXsfl_130 )
      {
         sendrow_13010( ) ;
         nGXsfl_130_idx = ((subFreestylelevel_categorias_Islastpage==1)&&(nGXsfl_130_idx+1>subfreestylelevel_categorias_fnc_recordsperpage( )) ? 1 : nGXsfl_130_idx+1) ;
         sGXsfl_130_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_130_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_13010( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylelevel_categoriasContainer)) ;
      /* End function gxnrFreestylelevel_categorias_newrow */
   }

   public void gxnrgridlevel_valores_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_16611( ) ;
      while ( nGXsfl_166_idx <= nRC_GXsfl_166 )
      {
         sendrow_16611( ) ;
         nGXsfl_166_idx = ((subGridlevel_valores_Islastpage==1)&&(nGXsfl_166_idx+1>subgridlevel_valores_fnc_recordsperpage( )) ? 1 : nGXsfl_166_idx+1) ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") + sGXsfl_130_idx ;
         subsflControlProps_16611( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_valoresContainer)) ;
      /* End function gxnrGridlevel_valores_newrow */
   }

   public void gxnrgridlevel_vacaciones_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_9312( ) ;
      while ( nGXsfl_93_idx <= nRC_GXsfl_93 )
      {
         sendrow_9312( ) ;
         nGXsfl_93_idx = ((subGridlevel_vacaciones_Islastpage==1)&&(nGXsfl_93_idx+1>subgridlevel_vacaciones_fnc_recordsperpage( )) ? 1 : nGXsfl_93_idx+1) ;
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") + sGXsfl_36_idx ;
         subsflControlProps_9312( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_vacacionesContainer)) ;
      /* End function gxnrGridlevel_vacaciones_newrow */
   }

   public void gxgrgridlevel_vacaciones_refresh( int subGridlevel_vacaciones_Rows ,
                                                 int subGridlevel_valores_Rows ,
                                                 int subGridlevel_importes_Rows ,
                                                 int subGridlevel_importes2_Rows ,
                                                 int subGridlevel_importesdeadicional_Rows ,
                                                 int subGridlevel_opciones_Rows ,
                                                 int subGridlevel_estadoscancelan_Rows ,
                                                 int A3CliCod ,
                                                 short A1564CliPaiConve ,
                                                 String A1565CliConvenio ,
                                                 java.util.Date A1575CliConveVig )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_VACACIONES_nCurrentRecord = 0 ;
      rfLV12( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_vacaciones_refresh */
   }

   public void gxgrfreestylelevel_datos_refresh( int subGridlevel_vacaciones_Rows ,
                                                 int subGridlevel_valores_Rows ,
                                                 int subGridlevel_importes_Rows ,
                                                 int subGridlevel_importes2_Rows ,
                                                 int subGridlevel_importesdeadicional_Rows ,
                                                 int subGridlevel_opciones_Rows ,
                                                 int subGridlevel_estadoscancelan_Rows ,
                                                 int A3CliCod ,
                                                 short A1564CliPaiConve ,
                                                 String A1565CliConvenio )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FREESTYLELEVEL_DATOS_nCurrentRecord = 0 ;
      rfLV2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFreestylelevel_datos_refresh */
   }

   public void gxgrgridlevel_valores_refresh( int subGridlevel_vacaciones_Rows ,
                                              int subGridlevel_valores_Rows ,
                                              int subGridlevel_importes_Rows ,
                                              int subGridlevel_importes2_Rows ,
                                              int subGridlevel_importesdeadicional_Rows ,
                                              int subGridlevel_opciones_Rows ,
                                              int subGridlevel_estadoscancelan_Rows ,
                                              int A3CliCod ,
                                              short A1564CliPaiConve ,
                                              String A1565CliConvenio ,
                                              String A8CatCodigo )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_VALORES_nCurrentRecord = 0 ;
      rfLV11( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_valores_refresh */
   }

   public void gxgrfreestylelevel_categorias_refresh( int subGridlevel_vacaciones_Rows ,
                                                      int subGridlevel_valores_Rows ,
                                                      int subGridlevel_importes_Rows ,
                                                      int subGridlevel_importes2_Rows ,
                                                      int subGridlevel_importesdeadicional_Rows ,
                                                      int subGridlevel_opciones_Rows ,
                                                      int subGridlevel_estadoscancelan_Rows ,
                                                      int A3CliCod ,
                                                      short A1564CliPaiConve ,
                                                      String A1565CliConvenio )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FREESTYLELEVEL_CATEGORIAS_nCurrentRecord = 0 ;
      rfLV10( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFreestylelevel_categorias_refresh */
   }

   public void gxgrgridlevel_importes_refresh( int subGridlevel_vacaciones_Rows ,
                                               int subGridlevel_valores_Rows ,
                                               int subGridlevel_importes_Rows ,
                                               int subGridlevel_importes2_Rows ,
                                               int subGridlevel_importesdeadicional_Rows ,
                                               int subGridlevel_opciones_Rows ,
                                               int subGridlevel_estadoscancelan_Rows ,
                                               int A3CliCod ,
                                               short A1564CliPaiConve ,
                                               String A1565CliConvenio )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_IMPORTES_nCurrentRecord = 0 ;
      rfLV9( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_importes_refresh */
   }

   public void gxgrgridlevel_importes2_refresh( int subGridlevel_vacaciones_Rows ,
                                                int subGridlevel_valores_Rows ,
                                                int subGridlevel_importes_Rows ,
                                                int subGridlevel_importes2_Rows ,
                                                int subGridlevel_importesdeadicional_Rows ,
                                                int subGridlevel_opciones_Rows ,
                                                int subGridlevel_estadoscancelan_Rows ,
                                                java.util.Date AV32CliConveImpVig ,
                                                int A3CliCod ,
                                                short A1564CliPaiConve ,
                                                String A1565CliConvenio ,
                                                java.util.Date A1587CliConveImpVig ,
                                                String A1588CliConveImpTipo ,
                                                java.math.BigDecimal A1589CliConveImporte )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_IMPORTES2_nCurrentRecord = 0 ;
      rfLV7( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_importes2_refresh */
   }

   public void gxgrgridlevel_importesdeadicional_refresh( int subGridlevel_vacaciones_Rows ,
                                                          int subGridlevel_valores_Rows ,
                                                          int subGridlevel_importes_Rows ,
                                                          int subGridlevel_importes2_Rows ,
                                                          int subGridlevel_importesdeadicional_Rows ,
                                                          int subGridlevel_opciones_Rows ,
                                                          int subGridlevel_estadoscancelan_Rows ,
                                                          int A3CliCod ,
                                                          short A1564CliPaiConve ,
                                                          String A1565CliConvenio ,
                                                          String A996ConveAdicod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord = 0 ;
      rfLV6( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_importesdeadicional_refresh */
   }

   public void gxgrgridlevel_opciones_refresh( int subGridlevel_vacaciones_Rows ,
                                               int subGridlevel_valores_Rows ,
                                               int subGridlevel_importes_Rows ,
                                               int subGridlevel_importes2_Rows ,
                                               int subGridlevel_importesdeadicional_Rows ,
                                               int subGridlevel_opciones_Rows ,
                                               int subGridlevel_estadoscancelan_Rows ,
                                               int A3CliCod ,
                                               short A1564CliPaiConve ,
                                               String A1565CliConvenio ,
                                               String A996ConveAdicod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_OPCIONES_nCurrentRecord = 0 ;
      rfLV5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_opciones_refresh */
   }

   public void gxgrgridlevel_estadoscancelan_refresh( int subGridlevel_vacaciones_Rows ,
                                                      int subGridlevel_valores_Rows ,
                                                      int subGridlevel_importes_Rows ,
                                                      int subGridlevel_importes2_Rows ,
                                                      int subGridlevel_importesdeadicional_Rows ,
                                                      int subGridlevel_opciones_Rows ,
                                                      int subGridlevel_estadoscancelan_Rows ,
                                                      int A3CliCod ,
                                                      short A1564CliPaiConve ,
                                                      String A1565CliConvenio ,
                                                      String A996ConveAdicod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord = 0 ;
      rfLV4( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlevel_estadoscancelan_refresh */
   }

   public void gxgrfreestylelevel_adicionales_refresh( int subGridlevel_vacaciones_Rows ,
                                                       int subGridlevel_valores_Rows ,
                                                       int subGridlevel_importes_Rows ,
                                                       int subGridlevel_importes2_Rows ,
                                                       int subGridlevel_importesdeadicional_Rows ,
                                                       int subGridlevel_opciones_Rows ,
                                                       int subGridlevel_estadoscancelan_Rows ,
                                                       int A3CliCod ,
                                                       short A1564CliPaiConve ,
                                                       String A1565CliConvenio )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      FREESTYLELEVEL_ADICIONALES_nCurrentRecord = 0 ;
      rfLV3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrFreestylelevel_adicionales_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG", getSecureSignedToken( "", AV32CliConveImpVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEIMPVIG", localUtil.format(AV32CliConveImpVig, "99/99/99"));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord = 0 ;
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_291_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rfLV2( ) ;
      rfLV10( ) ;
      rfLV9( ) ;
      rfLV7( ) ;
      rfLV3( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV41Pgmname = "ConvenioTabs" ;
      Gx_err = (short)(0) ;
      edtavCliconveimpvig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliconveimpvig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconveimpvig_Enabled), 5, 0), !bGXsfl_204_Refreshing);
      cmbavCliconveimptipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCliconveimptipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCliconveimptipo.getEnabled(), 5, 0), !bGXsfl_204_Refreshing);
      edtavCliconveimporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliconveimporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconveimporte_Enabled), 5, 0), !bGXsfl_204_Refreshing);
   }

   public void rfLV2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Freestylelevel_datosContainer.ClearRows();
      }
      wbStart = (short)(36) ;
      nGXsfl_36_idx = 1 ;
      sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_362( ) ;
      bGXsfl_36_Refreshing = true ;
      Freestylelevel_datosContainer.AddObjectProperty("GridName", "Freestylelevel_datos");
      Freestylelevel_datosContainer.AddObjectProperty("CmpContext", "");
      Freestylelevel_datosContainer.AddObjectProperty("InMasterPage", "false");
      Freestylelevel_datosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Freestylelevel_datosContainer.AddObjectProperty("Class", "FreeStyleGrid");
      Freestylelevel_datosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_datosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_datosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_datosContainer.setPageSize( subfreestylelevel_datos_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_362( ) ;
         /* Using cursor H00LV2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1575CliConveVig = H00LV2_A1575CliConveVig[0] ;
            A1628ConveGuarEdadMax = H00LV2_A1628ConveGuarEdadMax[0] ;
            n1628ConveGuarEdadMax = H00LV2_n1628ConveGuarEdadMax[0] ;
            A1627ConveGuarEdadMin = H00LV2_A1627ConveGuarEdadMin[0] ;
            n1627ConveGuarEdadMin = H00LV2_n1627ConveGuarEdadMin[0] ;
            A1046ConveMinMesesVac = H00LV2_A1046ConveMinMesesVac[0] ;
            A1043ConveInterDiasJor = H00LV2_A1043ConveInterDiasJor[0] ;
            A1401ConveFondoCese = H00LV2_A1401ConveFondoCese[0] ;
            A1270ConveDiaHsPExt = H00LV2_A1270ConveDiaHsPExt[0] ;
            n1270ConveDiaHsPExt = H00LV2_n1270ConveDiaHsPExt[0] ;
            A1269ConveMesHsPExt = H00LV2_A1269ConveMesHsPExt[0] ;
            e12LV2 ();
            pr_default.readNext(0);
         }
         pr_default.close(0);
         wbEnd = (short)(36) ;
         wbLV0( ) ;
      }
      bGXsfl_36_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV2( )
   {
   }

   public void rfLV3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Freestylelevel_adicionalesContainer.ClearRows();
      }
      wbStart = (short)(218) ;
      nGXsfl_218_idx = 1 ;
      sGXsfl_218_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_218_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2183( ) ;
      bGXsfl_218_Refreshing = true ;
      Freestylelevel_adicionalesContainer.AddObjectProperty("GridName", "Freestylelevel_adicionales");
      Freestylelevel_adicionalesContainer.AddObjectProperty("CmpContext", "");
      Freestylelevel_adicionalesContainer.AddObjectProperty("InMasterPage", "false");
      Freestylelevel_adicionalesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Freestylelevel_adicionalesContainer.AddObjectProperty("Class", "FreeStyleGrid");
      Freestylelevel_adicionalesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_adicionalesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_adicionalesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_adicionalesContainer.setPageSize( subfreestylelevel_adicionales_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2183( ) ;
         /* Using cursor H00LV3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A996ConveAdicod = H00LV3_A996ConveAdicod[0] ;
            A1803ConveAdiTipo = H00LV3_A1803ConveAdiTipo[0] ;
            A1019ConveAdiInfo = H00LV3_A1019ConveAdiInfo[0] ;
            n1019ConveAdiInfo = H00LV3_n1019ConveAdiInfo[0] ;
            A998ConveAdiAli = H00LV3_A998ConveAdiAli[0] ;
            A997ConveAdiDescri = H00LV3_A997ConveAdiDescri[0] ;
            e18LV3 ();
            pr_default.readNext(1);
         }
         pr_default.close(1);
         wbEnd = (short)(218) ;
         wbLV0( ) ;
      }
      bGXsfl_218_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV3( )
   {
   }

   public void rfLV4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_estadoscancelanContainer.ClearRows();
      }
      wbStart = (short)(291) ;
      nGXsfl_291_idx = (int)(1+GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage) ;
      sGXsfl_291_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_291_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
      subsflControlProps_2914( ) ;
      bGXsfl_291_Refreshing = true ;
      Gridlevel_estadoscancelanContainer.AddObjectProperty("GridName", "Gridlevel_estadoscancelan");
      Gridlevel_estadoscancelanContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_estadoscancelanContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_estadoscancelanContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_estadoscancelanContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_estadoscancelanContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_estadoscancelanContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_estadoscancelanContainer.setPageSize( subgridlevel_estadoscancelan_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2914( ) ;
         GXPagingFrom4 = (int)(((subGridlevel_estadoscancelan_Rows==0) ? 0 : GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage)) ;
         GXPagingTo4 = ((subGridlevel_estadoscancelan_Rows==0) ? 10000 : subgridlevel_estadoscancelan_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Integer.valueOf(GXPagingFrom4), Integer.valueOf(GXPagingTo4), Integer.valueOf(GXPagingTo4)});
         nGXsfl_291_idx = (int)(1+GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage) ;
         sGXsfl_291_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_291_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2914( ) ;
         while ( ( (pr_default.getStatus(2) != 101) ) && ( ( ( subGridlevel_estadoscancelan_Rows == 0 ) || ( GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord < subgridlevel_estadoscancelan_fnc_recordsperpage( ) ) ) ) )
         {
            A1824ConveAdiSitCancela = H00LV4_A1824ConveAdiSitCancela[0] ;
            e21LV4 ();
            pr_default.readNext(2);
         }
         GRIDLEVEL_ESTADOSCANCELAN_nEOF = (byte)(((pr_default.getStatus(2) == 101) ? 1 : 0)) ;
         GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nEOF_" + sGXsfl_218_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(2);
         wbEnd = (short)(291) ;
         wbLV0( ) ;
      }
      bGXsfl_291_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV4( )
   {
   }

   public void rfLV5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_opcionesContainer.ClearRows();
      }
      wbStart = (short)(277) ;
      nGXsfl_277_idx = 1 ;
      sGXsfl_277_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_277_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
      subsflControlProps_2775( ) ;
      bGXsfl_277_Refreshing = true ;
      Gridlevel_opcionesContainer.AddObjectProperty("GridName", "Gridlevel_opciones");
      Gridlevel_opcionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_opcionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_opcionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_opcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.setPageSize( subgridlevel_opciones_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2775( ) ;
         GXPagingFrom5 = (int)(((subGridlevel_opciones_Rows==0) ? 0 : GRIDLEVEL_OPCIONES_nFirstRecordOnPage)) ;
         GXPagingTo5 = ((subGridlevel_opciones_Rows==0) ? 10000 : subgridlevel_opciones_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Integer.valueOf(GXPagingFrom5), Integer.valueOf(GXPagingTo5), Integer.valueOf(GXPagingTo5)});
         nGXsfl_277_idx = 1 ;
         sGXsfl_277_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_277_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2775( ) ;
         while ( ( (pr_default.getStatus(3) != 101) ) && ( ( ( subGridlevel_opciones_Rows == 0 ) || ( GRIDLEVEL_OPCIONES_nCurrentRecord < subgridlevel_opciones_fnc_recordsperpage( ) ) ) ) )
         {
            A1013ConveAdiOpcAli = H00LV5_A1013ConveAdiOpcAli[0] ;
            A1012ConveAdiOpcDes = H00LV5_A1012ConveAdiOpcDes[0] ;
            A1021ConveAdiOpcFor = H00LV5_A1021ConveAdiOpcFor[0] ;
            A1011ConveAdiOpcCod = H00LV5_A1011ConveAdiOpcCod[0] ;
            e20LV5 ();
            pr_default.readNext(3);
         }
         GRIDLEVEL_OPCIONES_nEOF = (byte)(((pr_default.getStatus(3) == 101) ? 1 : 0)) ;
         GXCCtl = "GRIDLEVEL_OPCIONES_nEOF_" + sGXsfl_218_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(3);
         wbEnd = (short)(277) ;
         wbLV0( ) ;
      }
      bGXsfl_277_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV5( )
   {
   }

   public void rfLV6( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_importesdeadicionalContainer.ClearRows();
      }
      wbStart = (short)(265) ;
      nGXsfl_265_idx = 1 ;
      sGXsfl_265_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_265_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
      subsflControlProps_2656( ) ;
      bGXsfl_265_Refreshing = true ;
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("GridName", "Gridlevel_importesdeadicional");
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesdeadicionalContainer.setPageSize( subgridlevel_importesdeadicional_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2656( ) ;
         GXPagingFrom6 = (int)(((subGridlevel_importesdeadicional_Rows==0) ? 0 : GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage)) ;
         GXPagingTo6 = ((subGridlevel_importesdeadicional_Rows==0) ? 10000 : subgridlevel_importesdeadicional_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, AV31ConveAdiVig, Integer.valueOf(GXPagingFrom6), Integer.valueOf(GXPagingTo6), Integer.valueOf(GXPagingTo6)});
         nGXsfl_265_idx = 1 ;
         sGXsfl_265_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_265_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2656( ) ;
         while ( ( (pr_default.getStatus(4) != 101) ) && ( ( ( subGridlevel_importesdeadicional_Rows == 0 ) || ( GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord < subgridlevel_importesdeadicional_fnc_recordsperpage( ) ) ) ) )
         {
            A1000ConveAdiImporte = H00LV6_A1000ConveAdiImporte[0] ;
            A999ConveAdiVig = H00LV6_A999ConveAdiVig[0] ;
            e19LV6 ();
            pr_default.readNext(4);
         }
         GRIDLEVEL_IMPORTESDEADICIONAL_nEOF = (byte)(((pr_default.getStatus(4) == 101) ? 1 : 0)) ;
         GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nEOF_" + sGXsfl_218_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(4);
         wbEnd = (short)(265) ;
         wbLV0( ) ;
      }
      bGXsfl_265_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV6( )
   {
   }

   public void rfLV7( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_importes2Container.ClearRows();
      }
      wbStart = (short)(204) ;
      nGXsfl_204_idx = 1 ;
      sGXsfl_204_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_204_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2047( ) ;
      bGXsfl_204_Refreshing = true ;
      Gridlevel_importes2Container.AddObjectProperty("GridName", "Gridlevel_importes2");
      Gridlevel_importes2Container.AddObjectProperty("CmpContext", "");
      Gridlevel_importes2Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel_importes2Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel_importes2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importes2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importes2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importes2Container.setPageSize( subgridlevel_importes2_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2047( ) ;
         e17LV7 ();
         wbEnd = (short)(204) ;
         wbLV0( ) ;
      }
      bGXsfl_204_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV7( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG"+"_"+sGXsfl_204_idx, getSecureSignedToken( sGXsfl_204_idx, AV32CliConveImpVig));
   }

   public void rfLV9( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_importesContainer.ClearRows();
      }
      wbStart = (short)(194) ;
      nGXsfl_194_idx = 1 ;
      sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1949( ) ;
      bGXsfl_194_Refreshing = true ;
      Gridlevel_importesContainer.AddObjectProperty("GridName", "Gridlevel_importes");
      Gridlevel_importesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_importesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_importesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_importesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesContainer.setPageSize( subgridlevel_importes_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1949( ) ;
         GXPagingFrom9 = (int)(((subGridlevel_importes_Rows==0) ? 0 : GRIDLEVEL_IMPORTES_nFirstRecordOnPage)) ;
         GXPagingTo9 = ((subGridlevel_importes_Rows==0) ? 10000 : subgridlevel_importes_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, AV32CliConveImpVig, Integer.valueOf(GXPagingFrom9), Integer.valueOf(GXPagingTo9), Integer.valueOf(GXPagingTo9)});
         nGXsfl_194_idx = 1 ;
         sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1949( ) ;
         while ( ( (pr_default.getStatus(5) != 101) ) && ( ( ( subGridlevel_importes_Rows == 0 ) || ( GRIDLEVEL_IMPORTES_nCurrentRecord < subgridlevel_importes_fnc_recordsperpage( ) ) ) ) )
         {
            A1589CliConveImporte = H00LV7_A1589CliConveImporte[0] ;
            A1588CliConveImpTipo = H00LV7_A1588CliConveImpTipo[0] ;
            A1587CliConveImpVig = H00LV7_A1587CliConveImpVig[0] ;
            e16LV9 ();
            pr_default.readNext(5);
         }
         GRIDLEVEL_IMPORTES_nEOF = (byte)(((pr_default.getStatus(5) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(5);
         wbEnd = (short)(194) ;
         wbLV0( ) ;
      }
      bGXsfl_194_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV9( )
   {
   }

   public void rfLV10( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Freestylelevel_categoriasContainer.ClearRows();
      }
      wbStart = (short)(130) ;
      nGXsfl_130_idx = 1 ;
      sGXsfl_130_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_130_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_13010( ) ;
      bGXsfl_130_Refreshing = true ;
      Freestylelevel_categoriasContainer.AddObjectProperty("GridName", "Freestylelevel_categorias");
      Freestylelevel_categoriasContainer.AddObjectProperty("CmpContext", "");
      Freestylelevel_categoriasContainer.AddObjectProperty("InMasterPage", "false");
      Freestylelevel_categoriasContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Freestylelevel_categoriasContainer.AddObjectProperty("Class", "FreeStyleGrid");
      Freestylelevel_categoriasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_categoriasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylelevel_categoriasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylelevel_categoriasContainer.setPageSize( subfreestylelevel_categorias_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_13010( ) ;
         /* Using cursor H00LV8 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A8CatCodigo = H00LV8_A8CatCodigo[0] ;
            A1914CatFrecAct = H00LV8_A1914CatFrecAct[0] ;
            A1838CatClase = H00LV8_A1838CatClase[0] ;
            A123CatDescrip = H00LV8_A123CatDescrip[0] ;
            e14LV10 ();
            pr_default.readNext(6);
         }
         pr_default.close(6);
         wbEnd = (short)(130) ;
         wbLV0( ) ;
      }
      bGXsfl_130_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV10( )
   {
   }

   public void rfLV11( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_valoresContainer.ClearRows();
      }
      wbStart = (short)(166) ;
      nGXsfl_166_idx = 1 ;
      sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") + sGXsfl_130_idx ;
      subsflControlProps_16611( ) ;
      bGXsfl_166_Refreshing = true ;
      Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
      Gridlevel_valoresContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_valoresContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_valoresContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_valoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.setPageSize( subgridlevel_valores_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_16611( ) ;
         GXPagingFrom11 = (int)(((subGridlevel_valores_Rows==0) ? 0 : GRIDLEVEL_VALORES_nFirstRecordOnPage)) ;
         GXPagingTo11 = ((subGridlevel_valores_Rows==0) ? 10000 : subgridlevel_valores_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, AV33CatVigencia, Integer.valueOf(GXPagingFrom11), Integer.valueOf(GXPagingTo11), Integer.valueOf(GXPagingTo11)});
         nGXsfl_166_idx = 1 ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") + sGXsfl_130_idx ;
         subsflControlProps_16611( ) ;
         while ( ( (pr_default.getStatus(7) != 101) ) && ( ( ( subGridlevel_valores_Rows == 0 ) || ( GRIDLEVEL_VALORES_nCurrentRecord < subgridlevel_valores_fnc_recordsperpage( ) ) ) ) )
         {
            A1893EscAdicional = H00LV9_A1893EscAdicional[0] ;
            A1892EscBasico = H00LV9_A1892EscBasico[0] ;
            A907CatVigencia = H00LV9_A907CatVigencia[0] ;
            e15LV11 ();
            pr_default.readNext(7);
         }
         GRIDLEVEL_VALORES_nEOF = (byte)(((pr_default.getStatus(7) == 101) ? 1 : 0)) ;
         GXCCtl = "GRIDLEVEL_VALORES_nEOF_" + sGXsfl_130_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(7);
         wbEnd = (short)(166) ;
         wbLV0( ) ;
      }
      bGXsfl_166_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV11( )
   {
   }

   public void rfLV12( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_vacacionesContainer.ClearRows();
      }
      wbStart = (short)(93) ;
      nGXsfl_93_idx = 1 ;
      sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") + sGXsfl_36_idx ;
      subsflControlProps_9312( ) ;
      bGXsfl_93_Refreshing = true ;
      Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
      Gridlevel_vacacionesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_vacacionesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_vacacionesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_vacacionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.setPageSize( subgridlevel_vacaciones_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_9312( ) ;
         GXPagingFrom12 = (int)(((subGridlevel_vacaciones_Rows==0) ? 0 : GRIDLEVEL_VACACIONES_nFirstRecordOnPage)) ;
         GXPagingTo12 = ((subGridlevel_vacaciones_Rows==0) ? 10000 : subgridlevel_vacaciones_fnc_recordsperpage( )+1) ;
         /* Using cursor H00LV10 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Integer.valueOf(GXPagingFrom12), Integer.valueOf(GXPagingTo12), Integer.valueOf(GXPagingTo12)});
         nGXsfl_93_idx = 1 ;
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") + sGXsfl_36_idx ;
         subsflControlProps_9312( ) ;
         while ( ( (pr_default.getStatus(8) != 101) ) && ( ( ( subGridlevel_vacaciones_Rows == 0 ) || ( GRIDLEVEL_VACACIONES_nCurrentRecord < subgridlevel_vacaciones_fnc_recordsperpage( ) ) ) ) )
         {
            A1902ConveVacRelSec = H00LV10_A1902ConveVacRelSec[0] ;
            A1763CliConveVacDias = H00LV10_A1763CliConveVacDias[0] ;
            A1762CliConveVacHasAnt = H00LV10_A1762CliConveVacHasAnt[0] ;
            A1761CliConveVacDesAnt = H00LV10_A1761CliConveVacDesAnt[0] ;
            e13LV12 ();
            pr_default.readNext(8);
         }
         GRIDLEVEL_VACACIONES_nEOF = (byte)(((pr_default.getStatus(8) == 101) ? 1 : 0)) ;
         GXCCtl = "GRIDLEVEL_VACACIONES_nEOF_" + sGXsfl_36_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(8);
         wbEnd = (short)(93) ;
         wbLV0( ) ;
      }
      bGXsfl_93_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesLV12( )
   {
   }

   public int subfreestylelevel_datos_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_datos_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_datos_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylelevel_datos_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subfreestylelevel_adicionales_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_adicionales_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_adicionales_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylelevel_adicionales_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridlevel_estadoscancelan_fnc_pagecount( )
   {
      GRIDLEVEL_ESTADOSCANCELAN_nRecordCount = subgridlevel_estadoscancelan_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_ESTADOSCANCELAN_nRecordCount) % (subgridlevel_estadoscancelan_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_ESTADOSCANCELAN_nRecordCount/ (double) (subgridlevel_estadoscancelan_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_ESTADOSCANCELAN_nRecordCount/ (double) (subgridlevel_estadoscancelan_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_estadoscancelan_fnc_recordcount( )
   {
      /* Using cursor H00LV11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      GRIDLEVEL_ESTADOSCANCELAN_nRecordCount = H00LV11_AGRIDLEVEL_ESTADOSCANCELAN_nRecordCount[0] ;
      pr_default.close(9);
      return (int)(GRIDLEVEL_ESTADOSCANCELAN_nRecordCount) ;
   }

   public int subgridlevel_estadoscancelan_fnc_recordsperpage( )
   {
      if ( subGridlevel_estadoscancelan_Rows > 0 )
      {
         return subGridlevel_estadoscancelan_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_estadoscancelan_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage/ (double) (subgridlevel_estadoscancelan_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_estadoscancelan_firstpage( )
   {
      GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = 0 ;
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_estadoscancelan_nextpage( )
   {
      GRIDLEVEL_ESTADOSCANCELAN_nRecordCount = subgridlevel_estadoscancelan_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_ESTADOSCANCELAN_nRecordCount >= subgridlevel_estadoscancelan_fnc_recordsperpage( ) ) && ( GRIDLEVEL_ESTADOSCANCELAN_nEOF == 0 ) )
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = (long)(GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage+subgridlevel_estadoscancelan_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      if ( GRIDLEVEL_ESTADOSCANCELAN_nEOF == 1 )
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_estadoscancelanContainer.AddObjectProperty("GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage", GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_ESTADOSCANCELAN_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_estadoscancelan_previouspage( )
   {
      if ( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage >= subgridlevel_estadoscancelan_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = (long)(GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage-subgridlevel_estadoscancelan_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_estadoscancelan_lastpage( )
   {
      GRIDLEVEL_ESTADOSCANCELAN_nRecordCount = subgridlevel_estadoscancelan_fnc_recordcount( ) ;
      if ( GRIDLEVEL_ESTADOSCANCELAN_nRecordCount > subgridlevel_estadoscancelan_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_ESTADOSCANCELAN_nRecordCount) % (subgridlevel_estadoscancelan_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = (long)(GRIDLEVEL_ESTADOSCANCELAN_nRecordCount-subgridlevel_estadoscancelan_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = (long)(GRIDLEVEL_ESTADOSCANCELAN_nRecordCount-((int)((GRIDLEVEL_ESTADOSCANCELAN_nRecordCount) % (subgridlevel_estadoscancelan_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_estadoscancelan_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = (long)(subgridlevel_estadoscancelan_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_estadoscancelan_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_opciones_fnc_pagecount( )
   {
      GRIDLEVEL_OPCIONES_nRecordCount = subgridlevel_opciones_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_OPCIONES_nRecordCount) % (subgridlevel_opciones_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_OPCIONES_nRecordCount/ (double) (subgridlevel_opciones_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_OPCIONES_nRecordCount/ (double) (subgridlevel_opciones_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_opciones_fnc_recordcount( )
   {
      /* Using cursor H00LV12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      GRIDLEVEL_OPCIONES_nRecordCount = H00LV12_AGRIDLEVEL_OPCIONES_nRecordCount[0] ;
      pr_default.close(10);
      return (int)(GRIDLEVEL_OPCIONES_nRecordCount) ;
   }

   public int subgridlevel_opciones_fnc_recordsperpage( )
   {
      if ( subGridlevel_opciones_Rows > 0 )
      {
         return subGridlevel_opciones_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_opciones_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_OPCIONES_nFirstRecordOnPage/ (double) (subgridlevel_opciones_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_opciones_firstpage( )
   {
      GRIDLEVEL_OPCIONES_nFirstRecordOnPage = 0 ;
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_opciones_nextpage( )
   {
      GRIDLEVEL_OPCIONES_nRecordCount = subgridlevel_opciones_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_OPCIONES_nRecordCount >= subgridlevel_opciones_fnc_recordsperpage( ) ) && ( GRIDLEVEL_OPCIONES_nEOF == 0 ) )
      {
         GRIDLEVEL_OPCIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_OPCIONES_nFirstRecordOnPage+subgridlevel_opciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_opcionesContainer.AddObjectProperty("GRIDLEVEL_OPCIONES_nFirstRecordOnPage", GRIDLEVEL_OPCIONES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_OPCIONES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_opciones_previouspage( )
   {
      if ( GRIDLEVEL_OPCIONES_nFirstRecordOnPage >= subgridlevel_opciones_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_OPCIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_OPCIONES_nFirstRecordOnPage-subgridlevel_opciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_opciones_lastpage( )
   {
      GRIDLEVEL_OPCIONES_nRecordCount = subgridlevel_opciones_fnc_recordcount( ) ;
      if ( GRIDLEVEL_OPCIONES_nRecordCount > subgridlevel_opciones_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_OPCIONES_nRecordCount) % (subgridlevel_opciones_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_OPCIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_OPCIONES_nRecordCount-subgridlevel_opciones_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_OPCIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_OPCIONES_nRecordCount-((int)((GRIDLEVEL_OPCIONES_nRecordCount) % (subgridlevel_opciones_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_OPCIONES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_opciones_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_OPCIONES_nFirstRecordOnPage = (long)(subgridlevel_opciones_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_OPCIONES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_opciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_importesdeadicional_fnc_pagecount( )
   {
      GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount = subgridlevel_importesdeadicional_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount) % (subgridlevel_importesdeadicional_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount/ (double) (subgridlevel_importesdeadicional_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount/ (double) (subgridlevel_importesdeadicional_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_importesdeadicional_fnc_recordcount( )
   {
      /* Using cursor H00LV13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, AV31ConveAdiVig});
      GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount = H00LV13_AGRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount[0] ;
      pr_default.close(11);
      return (int)(GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount) ;
   }

   public int subgridlevel_importesdeadicional_fnc_recordsperpage( )
   {
      if ( subGridlevel_importesdeadicional_Rows > 0 )
      {
         return subGridlevel_importesdeadicional_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_importesdeadicional_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage/ (double) (subgridlevel_importesdeadicional_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_importesdeadicional_firstpage( )
   {
      GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = 0 ;
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importesdeadicional_nextpage( )
   {
      GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount = subgridlevel_importesdeadicional_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount >= subgridlevel_importesdeadicional_fnc_recordsperpage( ) ) && ( GRIDLEVEL_IMPORTESDEADICIONAL_nEOF == 0 ) )
      {
         GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage+subgridlevel_importesdeadicional_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_importesdeadicionalContainer.AddObjectProperty("GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage", GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_IMPORTESDEADICIONAL_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_importesdeadicional_previouspage( )
   {
      if ( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage >= subgridlevel_importesdeadicional_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage-subgridlevel_importesdeadicional_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importesdeadicional_lastpage( )
   {
      GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount = subgridlevel_importesdeadicional_fnc_recordcount( ) ;
      if ( GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount > subgridlevel_importesdeadicional_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount) % (subgridlevel_importesdeadicional_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount-subgridlevel_importesdeadicional_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount-((int)((GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount) % (subgridlevel_importesdeadicional_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_importesdeadicional_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = (long)(subgridlevel_importesdeadicional_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importesdeadicional_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_importes2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridlevel_importes2_fnc_recordcount( )
   {
      return (int)(GRIDLEVEL_IMPORTES2_nFirstRecordOnPage+1) ;
   }

   public int subgridlevel_importes2_fnc_recordsperpage( )
   {
      if ( subGridlevel_importes2_Rows > 0 )
      {
         return subGridlevel_importes2_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_importes2_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage/ (double) (subgridlevel_importes2_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_importes2_firstpage( )
   {
      GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_IMPORTES2_IsPaging = 1 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importes2_nextpage( )
   {
      if ( GRIDLEVEL_IMPORTES2_nEOF == 0 )
      {
         GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES2_nFirstRecordOnPage+subgridlevel_importes2_fnc_recordsperpage( )) ;
         GRIDLEVEL_IMPORTES2_IsPaging = 1 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_importes2Container.AddObjectProperty("GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GRIDLEVEL_IMPORTES2_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_IMPORTES2_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_importes2_previouspage( )
   {
      if ( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage >= subgridlevel_importes2_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES2_nFirstRecordOnPage-subgridlevel_importes2_fnc_recordsperpage( )) ;
         GRIDLEVEL_IMPORTES2_IsPaging = 1 ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importes2_lastpage( )
   {
      subGridlevel_importes2_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_importes2_gotopage( int nPageNo )
   {
      GRIDLEVEL_IMPORTES2_IsPaging = 1 ;
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = (long)(subgridlevel_importes2_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes2_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, AV32CliConveImpVig, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1587CliConveImpVig, A1588CliConveImpTipo, A1589CliConveImporte) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_importes_fnc_pagecount( )
   {
      GRIDLEVEL_IMPORTES_nRecordCount = subgridlevel_importes_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_IMPORTES_nRecordCount) % (subgridlevel_importes_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_IMPORTES_nRecordCount/ (double) (subgridlevel_importes_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_IMPORTES_nRecordCount/ (double) (subgridlevel_importes_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_importes_fnc_recordcount( )
   {
      /* Using cursor H00LV14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, AV32CliConveImpVig});
      GRIDLEVEL_IMPORTES_nRecordCount = H00LV14_AGRIDLEVEL_IMPORTES_nRecordCount[0] ;
      pr_default.close(12);
      return (int)(GRIDLEVEL_IMPORTES_nRecordCount) ;
   }

   public int subgridlevel_importes_fnc_recordsperpage( )
   {
      if ( subGridlevel_importes_Rows > 0 )
      {
         return subGridlevel_importes_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_importes_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_IMPORTES_nFirstRecordOnPage/ (double) (subgridlevel_importes_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_importes_firstpage( )
   {
      GRIDLEVEL_IMPORTES_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importes_nextpage( )
   {
      GRIDLEVEL_IMPORTES_nRecordCount = subgridlevel_importes_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_IMPORTES_nRecordCount >= subgridlevel_importes_fnc_recordsperpage( ) ) && ( GRIDLEVEL_IMPORTES_nEOF == 0 ) )
      {
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES_nFirstRecordOnPage+subgridlevel_importes_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GRIDLEVEL_IMPORTES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_IMPORTES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_importes_previouspage( )
   {
      if ( GRIDLEVEL_IMPORTES_nFirstRecordOnPage >= subgridlevel_importes_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES_nFirstRecordOnPage-subgridlevel_importes_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_importes_lastpage( )
   {
      GRIDLEVEL_IMPORTES_nRecordCount = subgridlevel_importes_fnc_recordcount( ) ;
      if ( GRIDLEVEL_IMPORTES_nRecordCount > subgridlevel_importes_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_IMPORTES_nRecordCount) % (subgridlevel_importes_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_IMPORTES_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES_nRecordCount-subgridlevel_importes_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_IMPORTES_nFirstRecordOnPage = (long)(GRIDLEVEL_IMPORTES_nRecordCount-((int)((GRIDLEVEL_IMPORTES_nRecordCount) % (subgridlevel_importes_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_importes_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = (long)(subgridlevel_importes_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_importes_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subfreestylelevel_categorias_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_categorias_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylelevel_categorias_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylelevel_categorias_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridlevel_valores_fnc_pagecount( )
   {
      GRIDLEVEL_VALORES_nRecordCount = subgridlevel_valores_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_VALORES_nRecordCount) % (subgridlevel_valores_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_VALORES_nRecordCount/ (double) (subgridlevel_valores_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_VALORES_nRecordCount/ (double) (subgridlevel_valores_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_valores_fnc_recordcount( )
   {
      /* Using cursor H00LV15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, AV33CatVigencia});
      GRIDLEVEL_VALORES_nRecordCount = H00LV15_AGRIDLEVEL_VALORES_nRecordCount[0] ;
      pr_default.close(13);
      return (int)(GRIDLEVEL_VALORES_nRecordCount) ;
   }

   public int subgridlevel_valores_fnc_recordsperpage( )
   {
      if ( subGridlevel_valores_Rows > 0 )
      {
         return subGridlevel_valores_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_valores_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_VALORES_nFirstRecordOnPage/ (double) (subgridlevel_valores_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_valores_firstpage( )
   {
      GRIDLEVEL_VALORES_nFirstRecordOnPage = 0 ;
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_valores_nextpage( )
   {
      GRIDLEVEL_VALORES_nRecordCount = subgridlevel_valores_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_VALORES_nRecordCount >= subgridlevel_valores_fnc_recordsperpage( ) ) && ( GRIDLEVEL_VALORES_nEOF == 0 ) )
      {
         GRIDLEVEL_VALORES_nFirstRecordOnPage = (long)(GRIDLEVEL_VALORES_nFirstRecordOnPage+subgridlevel_valores_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("GRIDLEVEL_VALORES_nFirstRecordOnPage", GRIDLEVEL_VALORES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_VALORES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_valores_previouspage( )
   {
      if ( GRIDLEVEL_VALORES_nFirstRecordOnPage >= subgridlevel_valores_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_VALORES_nFirstRecordOnPage = (long)(GRIDLEVEL_VALORES_nFirstRecordOnPage-subgridlevel_valores_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_valores_lastpage( )
   {
      GRIDLEVEL_VALORES_nRecordCount = subgridlevel_valores_fnc_recordcount( ) ;
      if ( GRIDLEVEL_VALORES_nRecordCount > subgridlevel_valores_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_VALORES_nRecordCount) % (subgridlevel_valores_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_VALORES_nFirstRecordOnPage = (long)(GRIDLEVEL_VALORES_nRecordCount-subgridlevel_valores_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_VALORES_nFirstRecordOnPage = (long)(GRIDLEVEL_VALORES_nRecordCount-((int)((GRIDLEVEL_VALORES_nRecordCount) % (subgridlevel_valores_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_VALORES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_valores_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_VALORES_nFirstRecordOnPage = (long)(subgridlevel_valores_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_VALORES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_valores_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridlevel_vacaciones_fnc_pagecount( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( ((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nRecordCount/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nRecordCount/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))+1) ;
   }

   public int subgridlevel_vacaciones_fnc_recordcount( )
   {
      /* Using cursor H00LV16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      GRIDLEVEL_VACACIONES_nRecordCount = H00LV16_AGRIDLEVEL_VACACIONES_nRecordCount[0] ;
      pr_default.close(14);
      return (int)(GRIDLEVEL_VACACIONES_nRecordCount) ;
   }

   public int subgridlevel_vacaciones_fnc_recordsperpage( )
   {
      if ( subGridlevel_vacaciones_Rows > 0 )
      {
         return subGridlevel_vacaciones_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridlevel_vacaciones_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDLEVEL_VACACIONES_nFirstRecordOnPage/ (double) (subgridlevel_vacaciones_fnc_recordsperpage( )))+1) ;
   }

   public short subgridlevel_vacaciones_firstpage( )
   {
      GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_vacaciones_nextpage( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( ( GRIDLEVEL_VACACIONES_nRecordCount >= subgridlevel_vacaciones_fnc_recordsperpage( ) ) && ( GRIDLEVEL_VACACIONES_nEOF == 0 ) )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nFirstRecordOnPage+subgridlevel_vacaciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDLEVEL_VACACIONES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridlevel_vacaciones_previouspage( )
   {
      if ( GRIDLEVEL_VACACIONES_nFirstRecordOnPage >= subgridlevel_vacaciones_fnc_recordsperpage( ) )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nFirstRecordOnPage-subgridlevel_vacaciones_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridlevel_vacaciones_lastpage( )
   {
      GRIDLEVEL_VACACIONES_nRecordCount = subgridlevel_vacaciones_fnc_recordcount( ) ;
      if ( GRIDLEVEL_VACACIONES_nRecordCount > subgridlevel_vacaciones_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( )))) == 0 )
         {
            GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nRecordCount-subgridlevel_vacaciones_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(GRIDLEVEL_VACACIONES_nRecordCount-((int)((GRIDLEVEL_VACACIONES_nRecordCount) % (subgridlevel_vacaciones_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridlevel_vacaciones_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = (long)(subgridlevel_vacaciones_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      }
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridlevel_vacaciones_refresh( subGridlevel_vacaciones_Rows, subGridlevel_valores_Rows, subGridlevel_importes_Rows, subGridlevel_importes2_Rows, subGridlevel_importesdeadicional_Rows, subGridlevel_opciones_Rows, subGridlevel_estadoscancelan_Rows, A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV41Pgmname = "ConvenioTabs" ;
      Gx_err = (short)(0) ;
      edtavCliconveimpvig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliconveimpvig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconveimpvig_Enabled), 5, 0), !bGXsfl_204_Refreshing);
      cmbavCliconveimptipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCliconveimptipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCliconveimptipo.getEnabled(), 5, 0), !bGXsfl_204_Refreshing);
      edtavCliconveimporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCliconveimporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCliconveimporte_Enabled), 5, 0), !bGXsfl_204_Refreshing);
      /* Using cursor H00LV17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      A1567CliConvenioDescrip = H00LV17_A1567CliConvenioDescrip[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A1567CliConvenioDescrip", A1567CliConvenioDescrip);
      pr_default.close(15);
      pr_default.close(15);
      fix_multi_value_controls( ) ;
   }

   public void strupLV0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11LV2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_36 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_36"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_130 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_130"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_194 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_194"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_204 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_204"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_218 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_218"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDLEVEL_IMPORTES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES2_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDLEVEL_IMPORTES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDLEVEL_IMPORTES2_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES2_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridlevel_importes_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridlevel_importes2_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDLEVEL_IMPORTES2_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Rows, (byte)(6), (byte)(0), ".", "")));
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         Gridlevel_estadoscancelan_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERER_Gridinternalname") ;
         Gridlevel_estadoscancelan_empowerer_Infinitescrolling = httpContext.cgiGet( "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERER_Infinitescrolling") ;
         Gridlevel_opciones_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_OPCIONES_EMPOWERER_Gridinternalname") ;
         Gridlevel_importesdeadicional_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_IMPORTESDEADICIONAL_EMPOWERER_Gridinternalname") ;
         Gridlevel_importes2_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_IMPORTES2_EMPOWERER_Gridinternalname") ;
         Gridlevel_importes_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_IMPORTES_EMPOWERER_Gridinternalname") ;
         Gridlevel_valores_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_VALORES_EMPOWERER_Gridinternalname") ;
         Gridlevel_vacaciones_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDLEVEL_VACACIONES_EMPOWERER_Gridinternalname") ;
         /* Read variables values. */
         A1567CliConvenioDescrip = httpContext.cgiGet( edtCliConvenioDescrip_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1567CliConvenioDescrip", A1567CliConvenioDescrip);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e11LV2 ();
      if (returnInSub) return;
   }

   public void e11LV2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_decimal1[0] = AV37ConveMesHsPExt ;
      new web.getconvemeshspext(remoteHandle, context).execute( A3CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_decimal1) ;
      conveniotabs_impl.this.AV37ConveMesHsPExt = GXv_decimal1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37ConveMesHsPExt", GXutil.ltrimstr( AV37ConveMesHsPExt, 5, 1));
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      Gridlevel_estadoscancelan_empowerer_Gridinternalname = subGridlevel_estadoscancelan_Internalname ;
      ucGridlevel_estadoscancelan_empowerer.sendProperty(context, "", false, Gridlevel_estadoscancelan_empowerer_Internalname, "GridInternalName", Gridlevel_estadoscancelan_empowerer_Gridinternalname);
      subGridlevel_estadoscancelan_Rows = 0 ;
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_opciones_empowerer_Gridinternalname = subGridlevel_opciones_Internalname ;
      ucGridlevel_opciones_empowerer.sendProperty(context, "", false, Gridlevel_opciones_empowerer_Internalname, "GridInternalName", Gridlevel_opciones_empowerer_Gridinternalname);
      subGridlevel_opciones_Rows = 0 ;
      GXCCtl = "GRIDLEVEL_OPCIONES_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_importesdeadicional_empowerer_Gridinternalname = subGridlevel_importesdeadicional_Internalname ;
      ucGridlevel_importesdeadicional_empowerer.sendProperty(context, "", false, Gridlevel_importesdeadicional_empowerer_Internalname, "GridInternalName", Gridlevel_importesdeadicional_empowerer_Gridinternalname);
      subGridlevel_importesdeadicional_Rows = 0 ;
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_importes2_empowerer_Gridinternalname = subGridlevel_importes2_Internalname ;
      ucGridlevel_importes2_empowerer.sendProperty(context, "", false, Gridlevel_importes2_empowerer_Internalname, "GridInternalName", Gridlevel_importes2_empowerer_Gridinternalname);
      subGridlevel_importes2_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_importes_empowerer_Gridinternalname = subGridlevel_importes_Internalname ;
      ucGridlevel_importes_empowerer.sendProperty(context, "", false, Gridlevel_importes_empowerer_Internalname, "GridInternalName", Gridlevel_importes_empowerer_Gridinternalname);
      subGridlevel_importes_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_Rows", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Rows, (byte)(6), (byte)(0), ".", "")));
      cmbCatClase.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Visible", GXutil.ltrimstr( cmbCatClase.getVisible(), 5, 0), !bGXsfl_130_Refreshing);
      edtCatFrecAct_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatFrecAct_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatFrecAct_Visible), 5, 0), !bGXsfl_130_Refreshing);
      Gridlevel_valores_empowerer_Gridinternalname = subGridlevel_valores_Internalname ;
      ucGridlevel_valores_empowerer.sendProperty(context, "", false, Gridlevel_valores_empowerer_Internalname, "GridInternalName", Gridlevel_valores_empowerer_Gridinternalname);
      subGridlevel_valores_Rows = 0 ;
      GXCCtl = "GRIDLEVEL_VALORES_Rows_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_vacaciones_empowerer_Gridinternalname = subGridlevel_vacaciones_Internalname ;
      ucGridlevel_vacaciones_empowerer.sendProperty(context, "", false, Gridlevel_vacaciones_empowerer_Internalname, "GridInternalName", Gridlevel_vacaciones_empowerer_Gridinternalname);
      subGridlevel_vacaciones_Rows = 0 ;
      GXCCtl = "GRIDLEVEL_VACACIONES_Rows_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
      new web.setopcionmenusesion(remoteHandle, context).execute( "", httpContext.getMessage( "DSP", ""), "") ;
      GXv_date2[0] = AV34CliConveVig ;
      GXv_date3[0] = AV32CliConveImpVig ;
      GXv_date4[0] = AV31ConveAdiVig ;
      GXv_date5[0] = AV33CatVigencia ;
      new web.getcliconvefecdesdes(remoteHandle, context).execute( A3CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_date2, GXv_date3, GXv_date4, GXv_date5) ;
      conveniotabs_impl.this.AV34CliConveVig = GXv_date2[0] ;
      conveniotabs_impl.this.AV32CliConveImpVig = GXv_date3[0] ;
      conveniotabs_impl.this.AV31ConveAdiVig = GXv_date4[0] ;
      conveniotabs_impl.this.AV33CatVigencia = GXv_date5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCliconveimpvig_Internalname, localUtil.format(AV32CliConveImpVig, "99/99/99"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG"+"_"+sGXsfl_204_idx, getSecureSignedToken( sGXsfl_204_idx, AV32CliConveImpVig));
      httpContext.ajax_rsp_assign_attri("", false, "AV31ConveAdiVig", localUtil.format(AV31ConveAdiVig, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "AV33CatVigencia", localUtil.format(AV33CatVigencia, "99/99/9999"));
   }

   private void e12LV2( )
   {
      /* Freestylelevel_datos_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(36) ;
      }
      sendrow_362( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_36_Refreshing )
      {
         httpContext.doAjaxLoad(36, Freestylelevel_datosRow);
      }
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&ConveMesHsPExt ", "")+GXutil.trim( GXutil.str( AV37ConveMesHsPExt, 5, 1))) ;
      if ( ! ( ! new web.convenioparticularidadunicaes(remoteHandle, context).executeUdp( 0, (short)(0), "") ) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         edtCliConveVig_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), !bGXsfl_36_Refreshing);
         divCliconvevig_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconvevig_cell_Internalname, "Class", divCliconvevig_cell_Class, !bGXsfl_36_Refreshing);
      }
      else
      {
         edtCliConveVig_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVig_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVig_Visible), 5, 0), !bGXsfl_36_Refreshing);
         divCliconvevig_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divCliconvevig_cell_Internalname, "Class", divCliconvevig_cell_Class, !bGXsfl_36_Refreshing);
      }
      if ( ! ( ( AV37ConveMesHsPExt.doubleValue() == 0 ) ) )
      {
         cmbConveDiaHsPExt.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveDiaHsPExt.getVisible(), 5, 0), !bGXsfl_36_Refreshing);
         divConvediahspext_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divConvediahspext_cell_Internalname, "Class", divConvediahspext_cell_Class, !bGXsfl_36_Refreshing);
      }
      else
      {
         cmbConveDiaHsPExt.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveDiaHsPExt.getVisible(), 5, 0), !bGXsfl_36_Refreshing);
         divConvediahspext_cell_Class = "col-xs-12 DataContentCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divConvediahspext_cell_Internalname, "Class", divConvediahspext_cell_Class, !bGXsfl_36_Refreshing);
      }
   }

   private void e18LV3( )
   {
      /* Freestylelevel_adicionales_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(218) ;
      }
      sendrow_2183( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_218_Refreshing )
      {
         httpContext.doAjaxLoad(218, Freestylelevel_adicionalesRow);
      }
   }

   private void e21LV4( )
   {
      /* Gridlevel_estadoscancelan_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(291) ;
      }
      sendrow_2914( ) ;
      GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord = (long)(GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_291_Refreshing )
      {
         httpContext.doAjaxLoad(291, Gridlevel_estadoscancelanRow);
      }
   }

   private void e20LV5( )
   {
      /* Gridlevel_opciones_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(277) ;
      }
      sendrow_2775( ) ;
      GRIDLEVEL_OPCIONES_nCurrentRecord = (long)(GRIDLEVEL_OPCIONES_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_277_Refreshing )
      {
         httpContext.doAjaxLoad(277, Gridlevel_opcionesRow);
      }
   }

   private void e19LV6( )
   {
      /* Gridlevel_importesdeadicional_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(265) ;
      }
      sendrow_2656( ) ;
      GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord = (long)(GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_265_Refreshing )
      {
         httpContext.doAjaxLoad(265, Gridlevel_importesdeadicionalRow);
      }
   }

   private void e17LV7( )
   {
      /* Gridlevel_importes2_Load Routine */
      returnInSub = false ;
      /* Using cursor H00LV18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, AV32CliConveImpVig});
      nGXsfl_194_idx = 1 ;
      sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1949( ) ;
      GRIDLEVEL_IMPORTES_nEOF = (byte)(0) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nEOF, (byte)(1), (byte)(0), ".", "")));
      while ( ( (pr_default.getStatus(16) != 101) ) && ( ( ( subGridlevel_importes_Rows == 0 ) || ( GRIDLEVEL_IMPORTES_nCurrentRecord < GRIDLEVEL_IMPORTES_nFirstRecordOnPage + subgridlevel_importes_fnc_recordsperpage( ) ) ) ) )
      {
         A1588CliConveImpTipo = H00LV18_A1588CliConveImpTipo[0] ;
         A1587CliConveImpVig = H00LV18_A1587CliConveImpVig[0] ;
         A1589CliConveImporte = H00LV18_A1589CliConveImporte[0] ;
         AV32CliConveImpVig = A1587CliConveImpVig ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCliconveimpvig_Internalname, localUtil.format(AV32CliConveImpVig, "99/99/99"));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEIMPVIG"+"_"+sGXsfl_204_idx, getSecureSignedToken( sGXsfl_204_idx, AV32CliConveImpVig));
         AV35CliConveImpTipo = A1588CliConveImpTipo ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavCliconveimptipo.getInternalname(), AV35CliConveImpTipo);
         AV36CliConveImporte = A1589CliConveImporte ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCliconveimporte_Internalname, GXutil.ltrimstr( AV36CliConveImporte, 14, 2));
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(204) ;
         }
         if ( ( subGridlevel_importes2_Islastpage == 1 ) || ( subGridlevel_importes2_Rows == 0 ) || ( ( GRIDLEVEL_IMPORTES2_nCurrentRecord >= GRIDLEVEL_IMPORTES2_nFirstRecordOnPage ) && ( GRIDLEVEL_IMPORTES2_nCurrentRecord < GRIDLEVEL_IMPORTES2_nFirstRecordOnPage + subgridlevel_importes2_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2047( ) ;
            GRIDLEVEL_IMPORTES2_nEOF = (byte)(1) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGridlevel_importes2_Islastpage == 1 ) && ( ((int)((GRIDLEVEL_IMPORTES2_nCurrentRecord) % (subgridlevel_importes2_fnc_recordsperpage( )))) == 0 ) )
            {
               GRIDLEVEL_IMPORTES2_nFirstRecordOnPage = GRIDLEVEL_IMPORTES2_nCurrentRecord ;
            }
         }
         if ( GRIDLEVEL_IMPORTES2_nCurrentRecord >= GRIDLEVEL_IMPORTES2_nFirstRecordOnPage + subgridlevel_importes2_fnc_recordsperpage( ) )
         {
            GRIDLEVEL_IMPORTES2_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES2_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRIDLEVEL_IMPORTES2_nCurrentRecord = (long)(GRIDLEVEL_IMPORTES2_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_204_Refreshing )
         {
            httpContext.doAjaxLoad(204, Gridlevel_importes2Row);
         }
         pr_default.readNext(16);
      }
      GRIDLEVEL_IMPORTES_nEOF = (byte)(((pr_default.getStatus(16) == 101) ? 1 : 0)) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDLEVEL_IMPORTES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nEOF, (byte)(1), (byte)(0), ".", "")));
      pr_default.close(16);
      /*  Sending Event outputs  */
      cmbavCliconveimptipo.setValue( GXutil.rtrim( AV35CliConveImpTipo) );
   }

   private void e16LV9( )
   {
      /* Gridlevel_importes_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(194) ;
      }
      sendrow_1949( ) ;
      GRIDLEVEL_IMPORTES_nCurrentRecord = (long)(GRIDLEVEL_IMPORTES_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_194_Refreshing )
      {
         httpContext.doAjaxLoad(194, Gridlevel_importesRow);
      }
   }

   private void e14LV10( )
   {
      /* Freestylelevel_categorias_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(130) ;
      }
      sendrow_13010( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_130_Refreshing )
      {
         httpContext.doAjaxLoad(130, Freestylelevel_categoriasRow);
      }
   }

   private void e15LV11( )
   {
      /* Gridlevel_valores_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(166) ;
      }
      sendrow_16611( ) ;
      GRIDLEVEL_VALORES_nCurrentRecord = (long)(GRIDLEVEL_VALORES_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_166_Refreshing )
      {
         httpContext.doAjaxLoad(166, Gridlevel_valoresRow);
      }
   }

   private void e13LV12( )
   {
      /* Gridlevel_vacaciones_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(93) ;
      }
      sendrow_9312( ) ;
      GRIDLEVEL_VACACIONES_nCurrentRecord = (long)(GRIDLEVEL_VACACIONES_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_93_Refreshing )
      {
         httpContext.doAjaxLoad(93, Gridlevel_vacacionesRow);
      }
   }

   public void wb_table1_9_LV2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTabgeneral_title_Internalname, httpContext.getMessage( "WWP_TemplateDataPanelTitle", ""), "", "", lblTabgeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConvenioTabs.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabGeneral") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConvenio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliConvenio_Internalname, httpContext.getMessage( "Código", ""), "col-sm-4 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConvenio_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ConvenioTabs.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConvenioDescrip_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtCliConvenioDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-4 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-8 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtCliConvenioDescrip_Internalname, A1567CliConvenioDescrip, "", "", (short)(0), 1, edtCliConvenioDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ConvenioTabs.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableintermediatelevel_datos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Freestylelevel_datosContainer.SetIsFreestyle(true);
         Freestylelevel_datosContainer.SetWrapped(nGXWrapped);
         startgridcontrol36( ) ;
      }
      if ( wbEnd == 36 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_36 = (int)(nGXsfl_36_idx-1) ;
         if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Freestylelevel_datosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_datos", Freestylelevel_datosContainer, subFreestylelevel_datos_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_datosContainerData", Freestylelevel_datosContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_datosContainerData"+"V", Freestylelevel_datosContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_datosContainerData"+"V"+"\" value='"+Freestylelevel_datosContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTablevel_categorias_title_Internalname, httpContext.getMessage( "Categorías", ""), "", "", lblTablevel_categorias_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConvenioTabs.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabLevel_Categorias") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabtablelevel_categorias_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableintermediatelevel_categorias_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Freestylelevel_categoriasContainer.SetIsFreestyle(true);
         Freestylelevel_categoriasContainer.SetWrapped(nGXWrapped);
         startgridcontrol130( ) ;
      }
      if ( wbEnd == 130 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_130 = (int)(nGXsfl_130_idx-1) ;
         if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Freestylelevel_categoriasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_categorias", Freestylelevel_categoriasContainer, subFreestylelevel_categorias_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_categoriasContainerData", Freestylelevel_categoriasContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_categoriasContainerData"+"V", Freestylelevel_categoriasContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_categoriasContainerData"+"V"+"\" value='"+Freestylelevel_categoriasContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTablevel_importes_title_Internalname, httpContext.getMessage( "Importes", ""), "", "", lblTablevel_importes_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConvenioTabs.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabLevel_Importes") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabtablelevel_importes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_importes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup10_Internalname, httpContext.getMessage( "Tope indemnizatorio", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ConvenioTabs.htm");
         wb_table2_191_LV2( true) ;
      }
      else
      {
         wb_table2_191_LV2( false) ;
      }
      return  ;
   }

   public void wb_table2_191_LV2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup12_Internalname, httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_ConvenioTabs.htm");
         wb_table3_201_LV2( true) ;
      }
      else
      {
         wb_table3_201_LV2( false) ;
      }
      return  ;
   }

   public void wb_table3_201_LV2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTablevel_adicionales_title_Internalname, httpContext.getMessage( "Adicionales", ""), "", "", lblTablevel_adicionales_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ConvenioTabs.htm");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabLevel_Adicionales") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTabtablelevel_adicionales_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableintermediatelevel_adicionales_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Freestylelevel_adicionalesContainer.SetIsFreestyle(true);
         Freestylelevel_adicionalesContainer.SetWrapped(nGXWrapped);
         startgridcontrol218( ) ;
      }
      if ( wbEnd == 218 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_218 = (int)(nGXsfl_218_idx-1) ;
         if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Freestylelevel_adicionalesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylelevel_adicionales", Freestylelevel_adicionalesContainer, subFreestylelevel_adicionales_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_adicionalesContainerData", Freestylelevel_adicionalesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylelevel_adicionalesContainerData"+"V", Freestylelevel_adicionalesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylelevel_adicionalesContainerData"+"V"+"\" value='"+Freestylelevel_adicionalesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 300,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 36, 2, 0)+","+"null"+");", httpContext.getMessage( "Confirmar", ""), bttBtnconfirmar_Jsonclick, 7, httpContext.getMessage( "Confirmar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e22lv1_client"+"'", TempTags, "", 2, "HLP_ConvenioTabs.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 302,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 36, 2, 0)+","+"null"+");", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 7, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e23lv1_client"+"'", TempTags, "", 2, "HLP_ConvenioTabs.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_LV2e( true) ;
      }
      else
      {
         wb_table1_9_LV2e( false) ;
      }
   }

   public void wb_table3_201_LV2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable11_Internalname, tblUnnamedtable11_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         Gridlevel_importes2Container.SetWrapped(nGXWrapped);
         startgridcontrol204( ) ;
      }
      if ( wbEnd == 204 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_204 = (int)(nGXsfl_204_idx-1) ;
         if ( Gridlevel_importes2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridlevel_importes2Container.AddObjectProperty("GRIDLEVEL_IMPORTES2_nEOF", GRIDLEVEL_IMPORTES2_nEOF);
            Gridlevel_importes2Container.AddObjectProperty("GRIDLEVEL_IMPORTES2_nFirstRecordOnPage", GRIDLEVEL_IMPORTES2_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridlevel_importes2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importes2", Gridlevel_importes2Container, subGridlevel_importes2_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importes2ContainerData", Gridlevel_importes2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importes2ContainerData"+"V", Gridlevel_importes2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importes2ContainerData"+"V"+"\" value='"+Gridlevel_importes2Container.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_201_LV2e( true) ;
      }
      else
      {
         wb_table3_201_LV2e( false) ;
      }
   }

   public void wb_table2_191_LV2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable9_Internalname, tblUnnamedtable9_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /*  Grid Control  */
         Gridlevel_importesContainer.SetWrapped(nGXWrapped);
         startgridcontrol194( ) ;
      }
      if ( wbEnd == 194 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_194 = (int)(nGXsfl_194_idx-1) ;
         if ( Gridlevel_importesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridlevel_importesContainer.AddObjectProperty("GRIDLEVEL_IMPORTES_nEOF", GRIDLEVEL_IMPORTES_nEOF);
            Gridlevel_importesContainer.AddObjectProperty("GRIDLEVEL_IMPORTES_nFirstRecordOnPage", GRIDLEVEL_IMPORTES_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridlevel_importesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importes", Gridlevel_importesContainer, subGridlevel_importes_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData", Gridlevel_importesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData"+"V", Gridlevel_importesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesContainerData"+"V"+"\" value='"+Gridlevel_importesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_191_LV2e( true) ;
      }
      else
      {
         wb_table2_191_LV2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")));
      A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")));
      A1565CliConvenio = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_CLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( A1565CliConvenio, ""))));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      paLV2( ) ;
      wsLV2( ) ;
      weLV2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187212747", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("conveniotabs.js", "?2025187212748", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
         httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
         httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_9312( )
   {
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT_"+sGXsfl_93_idx ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT_"+sGXsfl_93_idx ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS_"+sGXsfl_93_idx ;
      edtConveVacRelSec_Internalname = "CONVEVACRELSEC_"+sGXsfl_93_idx ;
   }

   public void subsflControlProps_fel_9312( )
   {
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT_"+sGXsfl_93_fel_idx ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT_"+sGXsfl_93_fel_idx ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS_"+sGXsfl_93_fel_idx ;
      edtConveVacRelSec_Internalname = "CONVEVACRELSEC_"+sGXsfl_93_fel_idx ;
   }

   public void sendrow_9312( )
   {
      subsflControlProps_9312( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_vacaciones_Rows * 1 == 0 ) || ( nGXsfl_93_idx <= subgridlevel_vacaciones_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_vacacionesRow = GXWebRow.GetNew(context,Gridlevel_vacacionesContainer) ;
         if ( subGridlevel_vacaciones_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(0) ;
            subGridlevel_vacaciones_Backcolor = subGridlevel_vacaciones_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
            }
            subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_vacaciones_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_vacaciones_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_93_idx) % (2))) == 0 )
            {
               subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_vacaciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_vacaciones_Class, "") != 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_93_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacDesAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacDesAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacHasAnt_Internalname,GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacHasAnt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVacDias_Internalname,GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1763CliConveVacDias), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVacDias_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_vacacionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveVacRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1902ConveVacRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1902ConveVacRelSec), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveVacRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(93),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV12( ) ;
         Gridlevel_vacacionesContainer.AddRow(Gridlevel_vacacionesRow);
         nGXsfl_93_idx = ((subGridlevel_vacaciones_Islastpage==1)&&(nGXsfl_93_idx+1>subgridlevel_vacaciones_fnc_recordsperpage( )) ? 1 : nGXsfl_93_idx+1) ;
         sGXsfl_93_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_93_idx), 4, 0), (short)(4), "0") + sGXsfl_36_idx ;
         subsflControlProps_9312( ) ;
      }
      /* End function sendrow_9312 */
   }

   public void subsflControlProps_362( )
   {
      edtCliConveVig_Internalname = "CLICONVEVIG_"+sGXsfl_36_idx ;
      edtConveMesHsPExt_Internalname = "CONVEMESHSPEXT_"+sGXsfl_36_idx ;
      cmbConveDiaHsPExt.setInternalname( "CONVEDIAHSPEXT_"+sGXsfl_36_idx );
      chkConveFondoCese.setInternalname( "CONVEFONDOCESE_"+sGXsfl_36_idx );
      lblTextblockconveinterdiasjor_Internalname = "TEXTBLOCKCONVEINTERDIASJOR_"+sGXsfl_36_idx ;
      edtConveInterDiasJor_Internalname = "CONVEINTERDIASJOR_"+sGXsfl_36_idx ;
      lblTextblockconveminmesesvac_Internalname = "TEXTBLOCKCONVEMINMESESVAC_"+sGXsfl_36_idx ;
      edtConveMinMesesVac_Internalname = "CONVEMINMESESVAC_"+sGXsfl_36_idx ;
      Dvpanel_unnamedtable20_Internalname = "DVPANEL_UNNAMEDTABLE20_"+sGXsfl_36_idx ;
      lblTextblockconveguaredadmin_Internalname = "TEXTBLOCKCONVEGUAREDADMIN_"+sGXsfl_36_idx ;
      edtConveGuarEdadMin_Internalname = "CONVEGUAREDADMIN_"+sGXsfl_36_idx ;
      lblTextblockconveguaredadmax_Internalname = "TEXTBLOCKCONVEGUAREDADMAX_"+sGXsfl_36_idx ;
      edtConveGuarEdadMax_Internalname = "CONVEGUAREDADMAX_"+sGXsfl_36_idx ;
      subGridlevel_vacaciones_Internalname = "GRIDLEVEL_VACACIONES_"+sGXsfl_36_idx ;
   }

   public void subsflControlProps_fel_362( )
   {
      edtCliConveVig_Internalname = "CLICONVEVIG_"+sGXsfl_36_fel_idx ;
      edtConveMesHsPExt_Internalname = "CONVEMESHSPEXT_"+sGXsfl_36_fel_idx ;
      cmbConveDiaHsPExt.setInternalname( "CONVEDIAHSPEXT_"+sGXsfl_36_fel_idx );
      chkConveFondoCese.setInternalname( "CONVEFONDOCESE_"+sGXsfl_36_fel_idx );
      lblTextblockconveinterdiasjor_Internalname = "TEXTBLOCKCONVEINTERDIASJOR_"+sGXsfl_36_fel_idx ;
      edtConveInterDiasJor_Internalname = "CONVEINTERDIASJOR_"+sGXsfl_36_fel_idx ;
      lblTextblockconveminmesesvac_Internalname = "TEXTBLOCKCONVEMINMESESVAC_"+sGXsfl_36_fel_idx ;
      edtConveMinMesesVac_Internalname = "CONVEMINMESESVAC_"+sGXsfl_36_fel_idx ;
      Dvpanel_unnamedtable20_Internalname = "DVPANEL_UNNAMEDTABLE20_"+sGXsfl_36_fel_idx ;
      lblTextblockconveguaredadmin_Internalname = "TEXTBLOCKCONVEGUAREDADMIN_"+sGXsfl_36_fel_idx ;
      edtConveGuarEdadMin_Internalname = "CONVEGUAREDADMIN_"+sGXsfl_36_fel_idx ;
      lblTextblockconveguaredadmax_Internalname = "TEXTBLOCKCONVEGUAREDADMAX_"+sGXsfl_36_fel_idx ;
      edtConveGuarEdadMax_Internalname = "CONVEGUAREDADMAX_"+sGXsfl_36_fel_idx ;
      subGridlevel_vacaciones_Internalname = "GRIDLEVEL_VACACIONES_"+sGXsfl_36_fel_idx ;
   }

   public void sendrow_362( )
   {
      subsflControlProps_362( ) ;
      wbLV0( ) ;
      Freestylelevel_datosRow = GXWebRow.GetNew(context,Freestylelevel_datosContainer) ;
      if ( subFreestylelevel_datos_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylelevel_datos_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylelevel_datos_Class, "") != 0 )
         {
            subFreestylelevel_datos_Linesclass = subFreestylelevel_datos_Class+"Odd" ;
         }
      }
      else if ( subFreestylelevel_datos_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylelevel_datos_Backstyle = (byte)(0) ;
         subFreestylelevel_datos_Backcolor = subFreestylelevel_datos_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylelevel_datos_Class, "") != 0 )
         {
            subFreestylelevel_datos_Linesclass = subFreestylelevel_datos_Class+"Uniform" ;
         }
      }
      else if ( subFreestylelevel_datos_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylelevel_datos_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylelevel_datos_Class, "") != 0 )
         {
            subFreestylelevel_datos_Linesclass = subFreestylelevel_datos_Class+"Odd" ;
         }
         subFreestylelevel_datos_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylelevel_datos_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylelevel_datos_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_36_idx) % (2))) == 0 )
         {
            subFreestylelevel_datos_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylelevel_datos_Class, "") != 0 )
            {
               subFreestylelevel_datos_Linesclass = subFreestylelevel_datos_Class+"Even" ;
            }
         }
         else
         {
            subFreestylelevel_datos_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylelevel_datos_Class, "") != 0 )
            {
               subFreestylelevel_datos_Linesclass = subFreestylelevel_datos_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylelevel_datos_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_36_idx+"\">") ;
      }
      /* Table start */
      Freestylelevel_datosRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablefsfreestylelevel_datos_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableintermediateinslevel_datos_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divCliconvevig_cell_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divCliconvevig_cell_Class,"left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(edtCliConveVig_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtCliConveVig_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtCliConveVig_Internalname,httpContext.getMessage( "Fecha de vigencia", ""),"col-sm-6 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveVig_Internalname,localUtil.format(A1575CliConveVig, "99/99/99"),localUtil.format( A1575CliConveVig, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveVig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtCliConveVig_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtConveMesHsPExt_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveMesHsPExt_Internalname,httpContext.getMessage( "Cantidad de horas del mes para calcular horas extras", ""),"col-sm-6 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveMesHsPExt_Internalname,GXutil.ltrim( localUtil.ntoc( A1269ConveMesHsPExt, (byte)(5), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1269ConveMesHsPExt, "ZZ9.9")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveMesHsPExt_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(5),"chr",Integer.valueOf(1),"row",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divConvediahspext_cell_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",divConvediahspext_cell_Class,"left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(cmbConveDiaHsPExt.getVisible()),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbConveDiaHsPExt.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbConveDiaHsPExt.getInternalname(),httpContext.getMessage( "Algoritmo para cantidad de días del mes para cálculo de horas extras", ""),"col-sm-6 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-6 gx-attribute","left","top","","","div"});
      if ( ( cmbConveDiaHsPExt.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CONVEDIAHSPEXT_" + sGXsfl_36_idx ;
         cmbConveDiaHsPExt.setName( GXCCtl );
         cmbConveDiaHsPExt.setWebtags( "" );
         cmbConveDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
         cmbConveDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
         cmbConveDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
         cmbConveDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
         if ( cmbConveDiaHsPExt.getItemCount() > 0 )
         {
            A1270ConveDiaHsPExt = cmbConveDiaHsPExt.getValidValue(A1270ConveDiaHsPExt) ;
            n1270ConveDiaHsPExt = false ;
         }
      }
      /* ComboBox */
      Freestylelevel_datosRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveDiaHsPExt,cmbConveDiaHsPExt.getInternalname(),GXutil.rtrim( A1270ConveDiaHsPExt),Integer.valueOf(1),cmbConveDiaHsPExt.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(cmbConveDiaHsPExt.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbConveDiaHsPExt.setValue( GXutil.rtrim( A1270ConveDiaHsPExt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveDiaHsPExt.getInternalname(), "Values", cmbConveDiaHsPExt.ToJavascriptSource(), !bGXsfl_36_Refreshing);
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+chkConveFondoCese.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkConveFondoCese.getInternalname(),httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""),"col-sm-6 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-6 gx-attribute","left","top","","","div"});
      /* Check box */
      ClassString = "Attribute" ;
      StyleString = "" ;
      GXCCtl = "CONVEFONDOCESE_" + sGXsfl_36_idx ;
      chkConveFondoCese.setName( GXCCtl );
      chkConveFondoCese.setWebtags( "" );
      chkConveFondoCese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveFondoCese.getInternalname(), "TitleCaption", chkConveFondoCese.getCaption(), !bGXsfl_36_Refreshing);
      chkConveFondoCese.setCheckedValue( "false" );
      A1401ConveFondoCese = GXutil.strtobool( GXutil.booltostr( A1401ConveFondoCese)) ;
      Freestylelevel_datosRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkConveFondoCese.getInternalname(),GXutil.booltostr( A1401ConveFondoCese),"",httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", ""),Integer.valueOf(1),Integer.valueOf(0),"true","",StyleString,ClassString,"","",""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Control Group */
      Freestylelevel_datosRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup17_Internalname+"_"+sGXsfl_36_idx,httpContext.getMessage( "Vacaciones", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_datosRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable16_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtableconveinterdiasjor_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      sendrow_36230( ) ;
   }

   public void sendrow_36230( )
   {
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_datosRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockconveinterdiasjor_Internalname,httpContext.getMessage( "Intervalo de jornadas trabajadas para x días de vacación", ""),"","",lblTextblockconveinterdiasjor_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-3","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveInterDiasJor_Internalname,httpContext.getMessage( "Intervalo de jornadas trabajadas para X días de vacación (20)", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveInterDiasJor_Internalname,GXutil.ltrim( localUtil.ntoc( A1043ConveInterDiasJor, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1043ConveInterDiasJor), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveInterDiasJor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(3),"chr",Integer.valueOf(1),"row",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtableconveminmesesvac_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_datosRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockconveminmesesvac_Internalname,httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones", ""),"","",lblTextblockconveminmesesvac_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-3","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveMinMesesVac_Internalname,httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones (6)", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveMinMesesVac_Internalname,GXutil.ltrim( localUtil.ntoc( A1046ConveMinMesesVac, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1046ConveMinMesesVac), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveMinMesesVac_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(2),"chr",Integer.valueOf(1),"row",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* User Defined Control */
      Freestylelevel_datosRow.AddColumnProperties("usercontrol", -1, isAjaxCallMode( ), new Object[] {"DVPANEL_UNNAMEDTABLE20Container"+"_"+sGXsfl_36_idx,Integer.valueOf(-1)});
      Freestylelevel_datosRow.AddColumnProperties("usercontrolcontainer", -1, isAjaxCallMode( ), new Object[] {"DVPANEL_UNNAMEDTABLE20Container","UnnamedTable20"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable20_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginTop","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_vacaciones_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 HasGridEmpowerer","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_datosRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_vacacionesContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_vacacionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_vacacionesContainer.Clear();
      }
      Gridlevel_vacacionesContainer.SetWrapped(nGXWrapped);
      startgridcontrol93( ) ;
      rfLV12( ) ;
      nRC_GXsfl_93 = (int)(nGXsfl_93_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_93_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_93, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nEOF", GRIDLEVEL_VACACIONES_nEOF);
         Gridlevel_vacacionesContainer.AddObjectProperty("GRIDLEVEL_VACACIONES_nFirstRecordOnPage", GRIDLEVEL_VACACIONES_nFirstRecordOnPage);
         if ( ! isAjaxCallMode( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData"+"_"+sGXsfl_36_idx, Gridlevel_vacacionesContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_datosRow.AddGrid("Gridlevel_vacaciones", Gridlevel_vacacionesContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_vacacionesContainerData"+"V_"+sGXsfl_36_idx, Gridlevel_vacacionesContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_vacacionesContainerData"+"V_"+sGXsfl_36_idx+"\" value='"+Gridlevel_vacacionesContainer.GridValuesHidden()+"'/>") ;
         }
      }
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("table");
      }
      /* End of table */
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Control Group */
      Freestylelevel_datosRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup19_Internalname+"_"+sGXsfl_36_idx,httpContext.getMessage( "Guardería", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_datosRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable18_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      sendrow_36260( ) ;
   }

   public void sendrow_36260( )
   {
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtableconveguaredadmin_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_datosRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockconveguaredadmin_Internalname,httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""),"","",lblTextblockconveguaredadmin_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-3","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveGuarEdadMin_Internalname,httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveGuarEdadMin_Internalname,GXutil.ltrim( localUtil.ntoc( A1627ConveGuarEdadMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1627ConveGuarEdadMin), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveGuarEdadMin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(2),"chr",Integer.valueOf(1),"row",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      Freestylelevel_datosRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_datosRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtableconveguaredadmax_Internalname+"_"+sGXsfl_36_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_datosRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockconveguaredadmax_Internalname,httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", ""),"","",lblTextblockconveguaredadmax_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-3","left","top","","","div"});
      /* Div Control */
      Freestylelevel_datosRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_datosRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveGuarEdadMax_Internalname,httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_datosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveGuarEdadMax_Internalname,GXutil.ltrim( localUtil.ntoc( A1628ConveGuarEdadMax, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1628ConveGuarEdadMax), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveGuarEdadMax_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(2),"chr",Integer.valueOf(1),"row",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("table");
      }
      /* End of table */
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_datosRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("cell");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("row");
      }
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         Freestylelevel_datosContainer.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashesLV2( ) ;
      GXCCtl = "GRIDLEVEL_VACACIONES_nFirstRecordOnPage_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_VACACIONES_nEOF_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VACACIONES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_VACACIONES_Rows_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Rows, (byte)(6), (byte)(0), ".", "")));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Width_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Dvpanel_unnamedtable20_Width));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autowidth_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Autowidth));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autoheight_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Autoheight));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Cls_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Dvpanel_unnamedtable20_Cls));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Title_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Dvpanel_unnamedtable20_Title));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Collapsible_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Collapsible));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Collapsed_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Collapsed));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Showcollapseicon_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Showcollapseicon));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Iconposition_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Dvpanel_unnamedtable20_Iconposition));
      GXCCtl = "DVPANEL_UNNAMEDTABLE20_Autoscroll_" + sGXsfl_36_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Dvpanel_unnamedtable20_Autoscroll));
      GRIDLEVEL_VACACIONES_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_VACACIONES_nCurrentRecord = 0 ;
      /* End of Columns property logic. */
      Freestylelevel_datosContainer.AddRow(Freestylelevel_datosRow);
      nGXsfl_36_idx = ((subFreestylelevel_datos_Islastpage==1)&&(nGXsfl_36_idx+1>subfreestylelevel_datos_fnc_recordsperpage( )) ? 1 : nGXsfl_36_idx+1) ;
      sGXsfl_36_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_36_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_362( ) ;
      /* End function sendrow_362 */
   }

   public void subsflControlProps_16611( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_166_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_166_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_166_idx ;
   }

   public void subsflControlProps_fel_16611( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_166_fel_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_166_fel_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_166_fel_idx ;
   }

   public void sendrow_16611( )
   {
      subsflControlProps_16611( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_valores_Rows * 1 == 0 ) || ( nGXsfl_166_idx <= subgridlevel_valores_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_valoresRow = GXWebRow.GetNew(context,Gridlevel_valoresContainer) ;
         if ( subGridlevel_valores_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_valores_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_valores_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_valores_Backstyle = (byte)(0) ;
            subGridlevel_valores_Backcolor = subGridlevel_valores_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_valores_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_valores_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
            }
            subGridlevel_valores_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_valores_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_valores_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_166_idx) % (2))) == 0 )
            {
               subGridlevel_valores_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
               {
                  subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_valores_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
               {
                  subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_166_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatVigencia_Internalname,localUtil.format(A907CatVigencia, "99/99/9999"),localUtil.format( A907CatVigencia, "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatVigencia_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(166),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(166),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"Importes","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscAdicional_Internalname,GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscAdicional_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(166),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"Importes","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV11( ) ;
         Gridlevel_valoresContainer.AddRow(Gridlevel_valoresRow);
         nGXsfl_166_idx = ((subGridlevel_valores_Islastpage==1)&&(nGXsfl_166_idx+1>subgridlevel_valores_fnc_recordsperpage( )) ? 1 : nGXsfl_166_idx+1) ;
         sGXsfl_166_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_166_idx), 4, 0), (short)(4), "0") + sGXsfl_130_idx ;
         subsflControlProps_16611( ) ;
      }
      /* End function sendrow_16611 */
   }

   public void subsflControlProps_13010( )
   {
      lblTextblockcatcodigo_Internalname = "TEXTBLOCKCATCODIGO_"+sGXsfl_130_idx ;
      edtCatCodigo_Internalname = "CATCODIGO_"+sGXsfl_130_idx ;
      lblTextblockcatdescrip_Internalname = "TEXTBLOCKCATDESCRIP_"+sGXsfl_130_idx ;
      edtCatDescrip_Internalname = "CATDESCRIP_"+sGXsfl_130_idx ;
      cmbCatClase.setInternalname( "CATCLASE_"+sGXsfl_130_idx );
      edtCatFrecAct_Internalname = "CATFRECACT_"+sGXsfl_130_idx ;
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES_"+sGXsfl_130_idx ;
   }

   public void subsflControlProps_fel_13010( )
   {
      lblTextblockcatcodigo_Internalname = "TEXTBLOCKCATCODIGO_"+sGXsfl_130_fel_idx ;
      edtCatCodigo_Internalname = "CATCODIGO_"+sGXsfl_130_fel_idx ;
      lblTextblockcatdescrip_Internalname = "TEXTBLOCKCATDESCRIP_"+sGXsfl_130_fel_idx ;
      edtCatDescrip_Internalname = "CATDESCRIP_"+sGXsfl_130_fel_idx ;
      cmbCatClase.setInternalname( "CATCLASE_"+sGXsfl_130_fel_idx );
      edtCatFrecAct_Internalname = "CATFRECACT_"+sGXsfl_130_fel_idx ;
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES_"+sGXsfl_130_fel_idx ;
   }

   public void sendrow_13010( )
   {
      subsflControlProps_13010( ) ;
      wbLV0( ) ;
      Freestylelevel_categoriasRow = GXWebRow.GetNew(context,Freestylelevel_categoriasContainer) ;
      if ( subFreestylelevel_categorias_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylelevel_categorias_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylelevel_categorias_Class, "") != 0 )
         {
            subFreestylelevel_categorias_Linesclass = subFreestylelevel_categorias_Class+"Odd" ;
         }
      }
      else if ( subFreestylelevel_categorias_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylelevel_categorias_Backstyle = (byte)(0) ;
         subFreestylelevel_categorias_Backcolor = subFreestylelevel_categorias_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylelevel_categorias_Class, "") != 0 )
         {
            subFreestylelevel_categorias_Linesclass = subFreestylelevel_categorias_Class+"Uniform" ;
         }
      }
      else if ( subFreestylelevel_categorias_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylelevel_categorias_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylelevel_categorias_Class, "") != 0 )
         {
            subFreestylelevel_categorias_Linesclass = subFreestylelevel_categorias_Class+"Odd" ;
         }
         subFreestylelevel_categorias_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylelevel_categorias_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylelevel_categorias_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_130_idx) % (2))) == 0 )
         {
            subFreestylelevel_categorias_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylelevel_categorias_Class, "") != 0 )
            {
               subFreestylelevel_categorias_Linesclass = subFreestylelevel_categorias_Class+"Even" ;
            }
         }
         else
         {
            subFreestylelevel_categorias_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylelevel_categorias_Class, "") != 0 )
            {
               subFreestylelevel_categorias_Linesclass = subFreestylelevel_categorias_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylelevel_categorias_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_130_idx+"\">") ;
      }
      /* Table start */
      Freestylelevel_categoriasRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablefsfreestylelevel_categorias_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableintermediateinslevel_categorias_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Control Group */
      Freestylelevel_categoriasRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup14_Internalname+"_"+sGXsfl_130_idx,httpContext.getMessage( "Categoría", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_categoriasRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable13_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablecatcodigo_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_categoriasRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockcatcodigo_Internalname,httpContext.getMessage( "Código", ""),"","",lblTextblockcatcodigo_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_categoriasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtCatCodigo_Internalname,httpContext.getMessage( "Categoria", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_categoriasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatCodigo_Internalname,GXutil.rtrim( A8CatCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(130),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablecatdescrip_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_categoriasRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockcatdescrip_Internalname,httpContext.getMessage( "Descripción", ""),"","",lblTextblockcatdescrip_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_categoriasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtCatDescrip_Internalname,httpContext.getMessage( "Descripción", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Freestylelevel_categoriasRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtCatDescrip_Internalname,A123CatDescrip,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(5),"row",Integer.valueOf(0),StyleString,ClassString,"","","400",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Control Group */
      Freestylelevel_categoriasRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup15_Internalname+"_"+sGXsfl_130_idx,httpContext.getMessage( "Salarios", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_categoriasRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblGroupsalario_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      sendrow_1301030( ) ;
   }

   public void sendrow_1301030( )
   {
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","CellMarginTop"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_valores_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 HasGridEmpowerer","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_categoriasRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_valoresContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_valoresContainer.Clear();
      }
      Gridlevel_valoresContainer.SetWrapped(nGXWrapped);
      startgridcontrol166( ) ;
      rfLV11( ) ;
      nRC_GXsfl_166 = (int)(nGXsfl_166_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_166_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_166, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         Gridlevel_valoresContainer.AddObjectProperty("GRIDLEVEL_VALORES_nEOF", GRIDLEVEL_VALORES_nEOF);
         Gridlevel_valoresContainer.AddObjectProperty("GRIDLEVEL_VALORES_nFirstRecordOnPage", GRIDLEVEL_VALORES_nFirstRecordOnPage);
         if ( ! isAjaxCallMode( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"_"+sGXsfl_130_idx, Gridlevel_valoresContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_categoriasRow.AddGrid("Gridlevel_valores", Gridlevel_valoresContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"V_"+sGXsfl_130_idx, Gridlevel_valoresContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_valoresContainerData"+"V_"+sGXsfl_130_idx+"\" value='"+Gridlevel_valoresContainer.GridValuesHidden()+"'/>") ;
         }
      }
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("table");
      }
      /* End of table */
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("table");
      }
      /* End of table */
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","Invisible"});
      /* Table start */
      Freestylelevel_categoriasRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfreestylelevel_categorias_Internalname+"_"+sGXsfl_130_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_categoriasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_categoriasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbCatClase.getInternalname(),httpContext.getMessage( "Frecuencia de pago", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      if ( ( cmbCatClase.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CATCLASE_" + sGXsfl_130_idx ;
         cmbCatClase.setName( GXCCtl );
         cmbCatClase.setWebtags( "" );
         cmbCatClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
         cmbCatClase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
         cmbCatClase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
         cmbCatClase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
         if ( cmbCatClase.getItemCount() > 0 )
         {
            A1838CatClase = (byte)(GXutil.lval( cmbCatClase.getValidValue(GXutil.trim( GXutil.str( A1838CatClase, 1, 0))))) ;
         }
      }
      /* ComboBox */
      Freestylelevel_categoriasRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCatClase,cmbCatClase.getInternalname(),GXutil.trim( GXutil.str( A1838CatClase, 1, 0)),Integer.valueOf(1),cmbCatClase.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(cmbCatClase.getVisible()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbCatClase.setValue( GXutil.trim( GXutil.str( A1838CatClase, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Values", cmbCatClase.ToJavascriptSource(), !bGXsfl_130_Refreshing);
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      Freestylelevel_categoriasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_categoriasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_categoriasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtCatFrecAct_Internalname,httpContext.getMessage( "Frecuencia de actualización (meses)", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_categoriasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatFrecAct_Internalname,GXutil.ltrim( localUtil.ntoc( A1914CatFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1914CatFrecAct), "Z9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatFrecAct_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtCatFrecAct_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(2),"chr",Integer.valueOf(1),"row",Integer.valueOf(2),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(130),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylelevel_categoriasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("table");
      }
      /* End of table */
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("cell");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("row");
      }
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         Freestylelevel_categoriasContainer.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashesLV10( ) ;
      GXCCtl = "GRIDLEVEL_VALORES_nFirstRecordOnPage_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_VALORES_nEOF_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_VALORES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_VALORES_Rows_" + sGXsfl_130_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Rows, (byte)(6), (byte)(0), ".", "")));
      GRIDLEVEL_VALORES_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_VALORES_nCurrentRecord = 0 ;
      /* End of Columns property logic. */
      Freestylelevel_categoriasContainer.AddRow(Freestylelevel_categoriasRow);
      nGXsfl_130_idx = ((subFreestylelevel_categorias_Islastpage==1)&&(nGXsfl_130_idx+1>subfreestylelevel_categorias_fnc_recordsperpage( )) ? 1 : nGXsfl_130_idx+1) ;
      sGXsfl_130_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_130_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_13010( ) ;
      /* End function sendrow_13010 */
   }

   public void subsflControlProps_1949( )
   {
      edtCliConveImpVig_Internalname = "CLICONVEIMPVIG_"+sGXsfl_194_idx ;
      cmbCliConveImpTipo.setInternalname( "CLICONVEIMPTIPO_"+sGXsfl_194_idx );
      edtCliConveImporte_Internalname = "CLICONVEIMPORTE_"+sGXsfl_194_idx ;
   }

   public void subsflControlProps_fel_1949( )
   {
      edtCliConveImpVig_Internalname = "CLICONVEIMPVIG_"+sGXsfl_194_fel_idx ;
      cmbCliConveImpTipo.setInternalname( "CLICONVEIMPTIPO_"+sGXsfl_194_fel_idx );
      edtCliConveImporte_Internalname = "CLICONVEIMPORTE_"+sGXsfl_194_fel_idx ;
   }

   public void sendrow_1949( )
   {
      subsflControlProps_1949( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_importes_Rows * 1 == 0 ) || ( nGXsfl_194_idx <= subgridlevel_importes_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_importesRow = GXWebRow.GetNew(context,Gridlevel_importesContainer) ;
         if ( subGridlevel_importes_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_importes_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_importes_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_importes_Backstyle = (byte)(0) ;
            subGridlevel_importes_Backcolor = subGridlevel_importes_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_importes_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_importes_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
            }
            subGridlevel_importes_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_importes_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_importes_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_194_idx) % (2))) == 0 )
            {
               subGridlevel_importes_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
               {
                  subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_importes_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
               {
                  subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_importesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_194_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_importesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveImpVig_Internalname,localUtil.format(A1587CliConveImpVig, "99/99/99"),localUtil.format( A1587CliConveImpVig, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveImpVig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(194),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_importesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCliConveImpTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CLICONVEIMPTIPO_" + sGXsfl_194_idx ;
            cmbCliConveImpTipo.setName( GXCCtl );
            cmbCliConveImpTipo.setWebtags( "" );
            cmbCliConveImpTipo.addItem("TopeIndem", httpContext.getMessage( "Tope indemnizatorio", ""), (short)(0));
            cmbCliConveImpTipo.addItem("Guarderia", httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), (short)(0));
            if ( cmbCliConveImpTipo.getItemCount() > 0 )
            {
               A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
            }
         }
         /* ComboBox */
         Gridlevel_importesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCliConveImpTipo,cmbCliConveImpTipo.getInternalname(),GXutil.rtrim( A1588CliConveImpTipo),Integer.valueOf(1),cmbCliConveImpTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(false),Integer.valueOf(0)});
         cmbCliConveImpTipo.setValue( GXutil.rtrim( A1588CliConveImpTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCliConveImpTipo.getInternalname(), "Values", cmbCliConveImpTipo.ToJavascriptSource(), !bGXsfl_194_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_importesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliConveImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A1589CliConveImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1589CliConveImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliConveImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(194),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"Importes","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV9( ) ;
         Gridlevel_importesContainer.AddRow(Gridlevel_importesRow);
         nGXsfl_194_idx = ((subGridlevel_importes_Islastpage==1)&&(nGXsfl_194_idx+1>subgridlevel_importes_fnc_recordsperpage( )) ? 1 : nGXsfl_194_idx+1) ;
         sGXsfl_194_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_194_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1949( ) ;
      }
      /* End function sendrow_1949 */
   }

   public void subsflControlProps_2047( )
   {
      edtavCliconveimpvig_Internalname = "vCLICONVEIMPVIG_"+sGXsfl_204_idx ;
      cmbavCliconveimptipo.setInternalname( "vCLICONVEIMPTIPO_"+sGXsfl_204_idx );
      edtavCliconveimporte_Internalname = "vCLICONVEIMPORTE_"+sGXsfl_204_idx ;
   }

   public void subsflControlProps_fel_2047( )
   {
      edtavCliconveimpvig_Internalname = "vCLICONVEIMPVIG_"+sGXsfl_204_fel_idx ;
      cmbavCliconveimptipo.setInternalname( "vCLICONVEIMPTIPO_"+sGXsfl_204_fel_idx );
      edtavCliconveimporte_Internalname = "vCLICONVEIMPORTE_"+sGXsfl_204_fel_idx ;
   }

   public void sendrow_2047( )
   {
      subsflControlProps_2047( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_importes2_Rows * 1 == 0 ) || ( nGXsfl_204_idx <= subgridlevel_importes2_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_importes2Row = GXWebRow.GetNew(context,Gridlevel_importes2Container) ;
         if ( subGridlevel_importes2_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_importes2_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_importes2_Class, "") != 0 )
            {
               subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_importes2_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_importes2_Backstyle = (byte)(0) ;
            subGridlevel_importes2_Backcolor = subGridlevel_importes2_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_importes2_Class, "") != 0 )
            {
               subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_importes2_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_importes2_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_importes2_Class, "") != 0 )
            {
               subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Odd" ;
            }
            subGridlevel_importes2_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_importes2_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_importes2_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_204_idx) % (2))) == 0 )
            {
               subGridlevel_importes2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importes2_Class, "") != 0 )
               {
                  subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_importes2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importes2_Class, "") != 0 )
               {
                  subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_importes2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_204_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_importes2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importes2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCliconveimpvig_Internalname,localUtil.format(AV32CliConveImpVig, "99/99/99"),localUtil.format( AV32CliConveImpVig, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCliconveimpvig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavCliconveimpvig_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(204),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_importes2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavCliconveimptipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vCLICONVEIMPTIPO_" + sGXsfl_204_idx ;
            cmbavCliconveimptipo.setName( GXCCtl );
            cmbavCliconveimptipo.setWebtags( "" );
            cmbavCliconveimptipo.addItem("TopeIndem", httpContext.getMessage( "Tope indemnizatorio", ""), (short)(0));
            cmbavCliconveimptipo.addItem("Guarderia", httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), (short)(0));
            if ( cmbavCliconveimptipo.getItemCount() > 0 )
            {
               AV35CliConveImpTipo = cmbavCliconveimptipo.getValidValue(AV35CliConveImpTipo) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavCliconveimptipo.getInternalname(), AV35CliConveImpTipo);
            }
         }
         /* ComboBox */
         Gridlevel_importes2Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCliconveimptipo,cmbavCliconveimptipo.getInternalname(),GXutil.rtrim( AV35CliConveImpTipo),Integer.valueOf(1),cmbavCliconveimptipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavCliconveimptipo.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(false),Integer.valueOf(0)});
         cmbavCliconveimptipo.setValue( GXutil.rtrim( AV35CliConveImpTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCliconveimptipo.getInternalname(), "Values", cmbavCliconveimptipo.ToJavascriptSource(), !bGXsfl_204_Refreshing);
         /* Subfile cell */
         if ( Gridlevel_importes2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importes2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCliconveimporte_Internalname,GXutil.ltrim( localUtil.ntoc( AV36CliConveImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavCliconveimporte_Enabled!=0) ? localUtil.format( AV36CliConveImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV36CliConveImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCliconveimporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavCliconveimporte_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(204),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV7( ) ;
         GXCCtl = "GRIDLEVEL_IMPORTES_nFirstRecordOnPage_" + sGXsfl_204_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
         GXCCtl = "GRIDLEVEL_IMPORTES_nEOF_" + sGXsfl_204_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
         GXCCtl = "GRIDLEVEL_IMPORTES_Rows_" + sGXsfl_204_idx ;
         web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddRow(Gridlevel_importes2Row);
         nGXsfl_204_idx = ((subGridlevel_importes2_Islastpage==1)&&(nGXsfl_204_idx+1>subgridlevel_importes2_fnc_recordsperpage( )) ? 1 : nGXsfl_204_idx+1) ;
         sGXsfl_204_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_204_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2047( ) ;
      }
      /* End function sendrow_2047 */
   }

   public void subsflControlProps_2656( )
   {
      edtConveAdiVig_Internalname = "CONVEADIVIG_"+sGXsfl_265_idx ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE_"+sGXsfl_265_idx ;
   }

   public void subsflControlProps_fel_2656( )
   {
      edtConveAdiVig_Internalname = "CONVEADIVIG_"+sGXsfl_265_fel_idx ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE_"+sGXsfl_265_fel_idx ;
   }

   public void sendrow_2656( )
   {
      subsflControlProps_2656( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_importesdeadicional_Rows * 1 == 0 ) || ( nGXsfl_265_idx <= subgridlevel_importesdeadicional_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_importesdeadicionalRow = GXWebRow.GetNew(context,Gridlevel_importesdeadicionalContainer) ;
         if ( subGridlevel_importesdeadicional_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_importesdeadicional_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_importesdeadicional_Class, "") != 0 )
            {
               subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_importesdeadicional_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_importesdeadicional_Backstyle = (byte)(0) ;
            subGridlevel_importesdeadicional_Backcolor = subGridlevel_importesdeadicional_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_importesdeadicional_Class, "") != 0 )
            {
               subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_importesdeadicional_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_importesdeadicional_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_importesdeadicional_Class, "") != 0 )
            {
               subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Odd" ;
            }
            subGridlevel_importesdeadicional_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_importesdeadicional_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_importesdeadicional_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_265_idx) % (2))) == 0 )
            {
               subGridlevel_importesdeadicional_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importesdeadicional_Class, "") != 0 )
               {
                  subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_importesdeadicional_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_importesdeadicional_Class, "") != 0 )
               {
                  subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_265_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importesdeadicionalRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiVig_Internalname,localUtil.format(A999ConveAdiVig, "99/99/99"),localUtil.format( A999ConveAdiVig, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiVig_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(265),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_importesdeadicionalRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1000ConveAdiImporte, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(265),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"Importes","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV6( ) ;
         Gridlevel_importesdeadicionalContainer.AddRow(Gridlevel_importesdeadicionalRow);
         nGXsfl_265_idx = ((subGridlevel_importesdeadicional_Islastpage==1)&&(nGXsfl_265_idx+1>subgridlevel_importesdeadicional_fnc_recordsperpage( )) ? 1 : nGXsfl_265_idx+1) ;
         sGXsfl_265_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_265_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2656( ) ;
      }
      /* End function sendrow_2656 */
   }

   public void subsflControlProps_2775( )
   {
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD_"+sGXsfl_277_idx ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR_"+sGXsfl_277_idx ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES_"+sGXsfl_277_idx ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI_"+sGXsfl_277_idx ;
   }

   public void subsflControlProps_fel_2775( )
   {
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD_"+sGXsfl_277_fel_idx ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR_"+sGXsfl_277_fel_idx ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES_"+sGXsfl_277_fel_idx ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI_"+sGXsfl_277_fel_idx ;
   }

   public void sendrow_2775( )
   {
      subsflControlProps_2775( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_opciones_Rows * 1 == 0 ) || ( nGXsfl_277_idx <= subgridlevel_opciones_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_opcionesRow = GXWebRow.GetNew(context,Gridlevel_opcionesContainer) ;
         if ( subGridlevel_opciones_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_opciones_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_opciones_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_opciones_Backstyle = (byte)(0) ;
            subGridlevel_opciones_Backcolor = subGridlevel_opciones_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_opciones_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_opciones_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
            }
            subGridlevel_opciones_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_opciones_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_opciones_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_277_idx) % (2))) == 0 )
            {
               subGridlevel_opciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
               {
                  subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_opciones_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_opciones_Class, "") != 0 )
               {
                  subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_277_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1011ConveAdiOpcCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(277),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcFor_Internalname,GXutil.rtrim( A1021ConveAdiOpcFor),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(277),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcDes_Internalname,A1012ConveAdiOpcDes,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(277),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_opcionesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcAli_Internalname,GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1013ConveAdiOpcAli, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcAli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(277),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"porUnaje","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesLV5( ) ;
         Gridlevel_opcionesContainer.AddRow(Gridlevel_opcionesRow);
         nGXsfl_277_idx = ((subGridlevel_opciones_Islastpage==1)&&(nGXsfl_277_idx+1>subgridlevel_opciones_fnc_recordsperpage( )) ? 1 : nGXsfl_277_idx+1) ;
         sGXsfl_277_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_277_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2775( ) ;
      }
      /* End function sendrow_2775 */
   }

   public void subsflControlProps_2914( )
   {
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA_"+sGXsfl_291_idx ;
   }

   public void subsflControlProps_fel_2914( )
   {
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA_"+sGXsfl_291_fel_idx ;
   }

   public void sendrow_2914( )
   {
      subsflControlProps_2914( ) ;
      wbLV0( ) ;
      if ( ( subGridlevel_estadoscancelan_Rows * 1 == 0 ) || ( nGXsfl_291_idx - GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage <= subgridlevel_estadoscancelan_fnc_recordsperpage( ) * 1 ) )
      {
         Gridlevel_estadoscancelanRow = GXWebRow.GetNew(context,Gridlevel_estadoscancelanContainer) ;
         if ( subGridlevel_estadoscancelan_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridlevel_estadoscancelan_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridlevel_estadoscancelan_Class, "") != 0 )
            {
               subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Odd" ;
            }
         }
         else if ( subGridlevel_estadoscancelan_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridlevel_estadoscancelan_Backstyle = (byte)(0) ;
            subGridlevel_estadoscancelan_Backcolor = subGridlevel_estadoscancelan_Allbackcolor ;
            if ( GXutil.strcmp(subGridlevel_estadoscancelan_Class, "") != 0 )
            {
               subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Uniform" ;
            }
         }
         else if ( subGridlevel_estadoscancelan_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridlevel_estadoscancelan_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridlevel_estadoscancelan_Class, "") != 0 )
            {
               subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Odd" ;
            }
            subGridlevel_estadoscancelan_Backcolor = (int)(0x0) ;
         }
         else if ( subGridlevel_estadoscancelan_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridlevel_estadoscancelan_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_291_idx) % (2))) == 0 )
            {
               subGridlevel_estadoscancelan_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_estadoscancelan_Class, "") != 0 )
               {
                  subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Even" ;
               }
            }
            else
            {
               subGridlevel_estadoscancelan_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridlevel_estadoscancelan_Class, "") != 0 )
               {
                  subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Odd" ;
               }
            }
         }
         if ( Gridlevel_estadoscancelanContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_291_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridlevel_estadoscancelanContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridlevel_estadoscancelanRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiSitCancela_Internalname,GXutil.rtrim( A1824ConveAdiSitCancela),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiSitCancela_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(291),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesLV4( ) ;
         Gridlevel_estadoscancelanContainer.AddRow(Gridlevel_estadoscancelanRow);
         nGXsfl_291_idx = ((subGridlevel_estadoscancelan_Islastpage==1)&&(nGXsfl_291_idx+1>subgridlevel_estadoscancelan_fnc_recordsperpage( )) ? 1 : nGXsfl_291_idx+1) ;
         sGXsfl_291_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_291_idx), 4, 0), (short)(4), "0") + sGXsfl_218_idx ;
         subsflControlProps_2914( ) ;
      }
      /* End function sendrow_2914 */
   }

   public void subsflControlProps_2183( )
   {
      edtConveAdicod_Internalname = "CONVEADICOD_"+sGXsfl_218_idx ;
      edtConveAdiDescri_Internalname = "CONVEADIDESCRI_"+sGXsfl_218_idx ;
      edtConveAdiAli_Internalname = "CONVEADIALI_"+sGXsfl_218_idx ;
      lblTextblockconveadiinfo_Internalname = "TEXTBLOCKCONVEADIINFO_"+sGXsfl_218_idx ;
      edtConveAdiInfo_Internalname = "CONVEADIINFO_"+sGXsfl_218_idx ;
      cmbConveAdiTipo.setInternalname( "CONVEADITIPO_"+sGXsfl_218_idx );
      subGridlevel_importesdeadicional_Internalname = "GRIDLEVEL_IMPORTESDEADICIONAL_"+sGXsfl_218_idx ;
      subGridlevel_opciones_Internalname = "GRIDLEVEL_OPCIONES_"+sGXsfl_218_idx ;
      subGridlevel_estadoscancelan_Internalname = "GRIDLEVEL_ESTADOSCANCELAN_"+sGXsfl_218_idx ;
   }

   public void subsflControlProps_fel_2183( )
   {
      edtConveAdicod_Internalname = "CONVEADICOD_"+sGXsfl_218_fel_idx ;
      edtConveAdiDescri_Internalname = "CONVEADIDESCRI_"+sGXsfl_218_fel_idx ;
      edtConveAdiAli_Internalname = "CONVEADIALI_"+sGXsfl_218_fel_idx ;
      lblTextblockconveadiinfo_Internalname = "TEXTBLOCKCONVEADIINFO_"+sGXsfl_218_fel_idx ;
      edtConveAdiInfo_Internalname = "CONVEADIINFO_"+sGXsfl_218_fel_idx ;
      cmbConveAdiTipo.setInternalname( "CONVEADITIPO_"+sGXsfl_218_fel_idx );
      subGridlevel_importesdeadicional_Internalname = "GRIDLEVEL_IMPORTESDEADICIONAL_"+sGXsfl_218_fel_idx ;
      subGridlevel_opciones_Internalname = "GRIDLEVEL_OPCIONES_"+sGXsfl_218_fel_idx ;
      subGridlevel_estadoscancelan_Internalname = "GRIDLEVEL_ESTADOSCANCELAN_"+sGXsfl_218_fel_idx ;
   }

   public void sendrow_2183( )
   {
      subsflControlProps_2183( ) ;
      wbLV0( ) ;
      Freestylelevel_adicionalesRow = GXWebRow.GetNew(context,Freestylelevel_adicionalesContainer) ;
      if ( subFreestylelevel_adicionales_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylelevel_adicionales_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylelevel_adicionales_Class, "") != 0 )
         {
            subFreestylelevel_adicionales_Linesclass = subFreestylelevel_adicionales_Class+"Odd" ;
         }
      }
      else if ( subFreestylelevel_adicionales_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylelevel_adicionales_Backstyle = (byte)(0) ;
         subFreestylelevel_adicionales_Backcolor = subFreestylelevel_adicionales_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylelevel_adicionales_Class, "") != 0 )
         {
            subFreestylelevel_adicionales_Linesclass = subFreestylelevel_adicionales_Class+"Uniform" ;
         }
      }
      else if ( subFreestylelevel_adicionales_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylelevel_adicionales_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylelevel_adicionales_Class, "") != 0 )
         {
            subFreestylelevel_adicionales_Linesclass = subFreestylelevel_adicionales_Class+"Odd" ;
         }
         subFreestylelevel_adicionales_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylelevel_adicionales_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylelevel_adicionales_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_218_idx) % (2))) == 0 )
         {
            subFreestylelevel_adicionales_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylelevel_adicionales_Class, "") != 0 )
            {
               subFreestylelevel_adicionales_Linesclass = subFreestylelevel_adicionales_Class+"Even" ;
            }
         }
         else
         {
            subFreestylelevel_adicionales_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylelevel_adicionales_Class, "") != 0 )
            {
               subFreestylelevel_adicionales_Linesclass = subFreestylelevel_adicionales_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylelevel_adicionales_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_218_idx+"\">") ;
      }
      /* Table start */
      Freestylelevel_adicionalesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablefsfreestylelevel_adicionales_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableintermediateinslevel_adicionales_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Control Group */
      Freestylelevel_adicionalesRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup2_Internalname+"_"+sGXsfl_218_idx,httpContext.getMessage( "Adicional", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_adicionalesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable1_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","left","top",""+" data-gx-for=\""+edtConveAdicod_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_adicionalesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveAdicod_Internalname,httpContext.getMessage( "Código", ""),"gx-form-item AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),"width: 25%;"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_adicionalesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdicod_Internalname,GXutil.rtrim( A996ConveAdicod),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdicod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(20),"chr",Integer.valueOf(1),"row",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(218),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","left","top",""+" data-gx-for=\""+edtConveAdiDescri_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_adicionalesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveAdiDescri_Internalname,httpContext.getMessage( "Descripción", ""),"gx-form-item AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),"width: 25%;"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Freestylelevel_adicionalesRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtConveAdiDescri_Internalname,A997ConveAdiDescri,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(5),"row",Integer.valueOf(0),StyleString,ClassString,"","","400",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","left","top",""+" data-gx-for=\""+edtConveAdiAli_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_adicionalesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveAdiAli_Internalname,httpContext.getMessage( "Alícuota", ""),"gx-form-item AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),"width: 25%;"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylelevel_adicionalesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiAli_Internalname,GXutil.ltrim( localUtil.ntoc( A998ConveAdiAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A998ConveAdiAli, "9.9999")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiAli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(218),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtableconveadiinfo_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 MergeLabelCell","left","top","","","div"});
      /* Text block */
      Freestylelevel_adicionalesRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblockconveadiinfo_Internalname,httpContext.getMessage( "Información adicional", ""),"","",lblTextblockconveadiinfo_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Label",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_218330( ) ;
   }

   public void sendrow_218330( )
   {
      /* Attribute/Variable Label */
      Freestylelevel_adicionalesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtConveAdiInfo_Internalname,httpContext.getMessage( "Información adicional", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Freestylelevel_adicionalesRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtConveAdiInfo_Internalname,A1019ConveAdiInfo,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",Integer.valueOf(0),StyleString,ClassString,"","","2000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"Obs","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","DataContentCell"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","left","top",""+" data-gx-for=\""+cmbConveAdiTipo.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylelevel_adicionalesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbConveAdiTipo.getInternalname(),httpContext.getMessage( "Tipo", ""),"gx-form-item AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),"width: 25%;"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","left","top","","","div"});
      if ( ( cmbConveAdiTipo.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CONVEADITIPO_" + sGXsfl_218_idx ;
         cmbConveAdiTipo.setName( GXCCtl );
         cmbConveAdiTipo.setWebtags( "" );
         cmbConveAdiTipo.addItem("titulo", httpContext.getMessage( "Tìtulo", ""), (short)(0));
         cmbConveAdiTipo.addItem("otros", httpContext.getMessage( "Otros", ""), (short)(0));
         if ( cmbConveAdiTipo.getItemCount() > 0 )
         {
            A1803ConveAdiTipo = cmbConveAdiTipo.getValidValue(A1803ConveAdiTipo) ;
         }
      }
      /* ComboBox */
      Freestylelevel_adicionalesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbConveAdiTipo,cmbConveAdiTipo.getInternalname(),GXutil.rtrim( A1803ConveAdiTipo),Integer.valueOf(1),cmbConveAdiTipo.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbConveAdiTipo.setValue( GXutil.rtrim( A1803ConveAdiTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveAdiTipo.getInternalname(), "Values", cmbConveAdiTipo.ToJavascriptSource(), !bGXsfl_218_Refreshing);
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Control Group */
      Freestylelevel_adicionalesRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup4_Internalname+"_"+sGXsfl_218_idx,httpContext.getMessage( "Importes", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_adicionalesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable3_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","CellMarginTop"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_importesdeadicional_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 HasGridEmpowerer","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_adicionalesRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_importesdeadicionalContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_importesdeadicionalContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_importesdeadicionalContainer.Clear();
      }
      Gridlevel_importesdeadicionalContainer.SetWrapped(nGXWrapped);
      startgridcontrol265( ) ;
      rfLV6( ) ;
      nRC_GXsfl_265 = (int)(nGXsfl_265_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_265_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_265, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("GRIDLEVEL_IMPORTESDEADICIONAL_nEOF", GRIDLEVEL_IMPORTESDEADICIONAL_nEOF);
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage", GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage);
         if ( ! isAjaxCallMode( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesdeadicionalContainerData"+"_"+sGXsfl_218_idx, Gridlevel_importesdeadicionalContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_adicionalesRow.AddGrid("Gridlevel_importesdeadicional", Gridlevel_importesdeadicionalContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesdeadicionalContainerData"+"V_"+sGXsfl_218_idx, Gridlevel_importesdeadicionalContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesdeadicionalContainerData"+"V_"+sGXsfl_218_idx+"\" value='"+Gridlevel_importesdeadicionalContainer.GridValuesHidden()+"'/>") ;
         }
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("table");
      }
      /* End of table */
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Control Group */
      Freestylelevel_adicionalesRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup6_Internalname+"_"+sGXsfl_218_idx,httpContext.getMessage( "Opciones", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_adicionalesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable5_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","CellMarginTop"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_alicuotas_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 HasGridEmpowerer","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_adicionalesRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_opcionesContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_opcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_opcionesContainer.Clear();
      }
      Gridlevel_opcionesContainer.SetWrapped(nGXWrapped);
      startgridcontrol277( ) ;
      rfLV5( ) ;
      nRC_GXsfl_277 = (int)(nGXsfl_277_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_277_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_277, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         Gridlevel_opcionesContainer.AddObjectProperty("GRIDLEVEL_OPCIONES_nEOF", GRIDLEVEL_OPCIONES_nEOF);
         Gridlevel_opcionesContainer.AddObjectProperty("GRIDLEVEL_OPCIONES_nFirstRecordOnPage", GRIDLEVEL_OPCIONES_nFirstRecordOnPage);
         if ( ! isAjaxCallMode( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData"+"_"+sGXsfl_218_idx, Gridlevel_opcionesContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_adicionalesRow.AddGrid("Gridlevel_opciones", Gridlevel_opcionesContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_opcionesContainerData"+"V_"+sGXsfl_218_idx, Gridlevel_opcionesContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_opcionesContainerData"+"V_"+sGXsfl_218_idx+"\" value='"+Gridlevel_opcionesContainer.GridValuesHidden()+"'/>") ;
         }
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("table");
      }
      /* End of table */
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Control Group */
      Freestylelevel_adicionalesRow.AddColumnProperties("group", -1, isAjaxCallMode( ), new Object[] {grpUnnamedgroup8_Internalname+"_"+sGXsfl_218_idx,httpContext.getMessage( "Estados que lo cancelan", ""),Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Group",""});
      /* Table start */
      Freestylelevel_adicionalesRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtable7_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),"","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      sendrow_218360( ) ;
   }

   public void sendrow_218360( )
   {
      Freestylelevel_adicionalesRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylelevel_adicionalesRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","CellMarginTop"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableleaflevel_estadoscancelan_Internalname+"_"+sGXsfl_218_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 HasGridEmpowerer","left","top","","","div"});
      /*  Child Grid Control  */
      Freestylelevel_adicionalesRow.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridlevel_estadoscancelanContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridlevel_estadoscancelanContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridlevel_estadoscancelanContainer.Clear();
      }
      Gridlevel_estadoscancelanContainer.SetWrapped(nGXWrapped);
      startgridcontrol291( ) ;
      rfLV4( ) ;
      nRC_GXsfl_291 = (int)(nGXsfl_291_idx-1) ;
      send_integrity_footer_hashes( ) ;
      GXCCtl = "nRC_GXsfl_291_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_291, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( Gridlevel_estadoscancelanContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "</table>") ;
      }
      else
      {
         Gridlevel_estadoscancelanContainer.AddObjectProperty("GRIDLEVEL_ESTADOSCANCELAN_nEOF", GRIDLEVEL_ESTADOSCANCELAN_nEOF);
         Gridlevel_estadoscancelanContainer.AddObjectProperty("GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage", GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage);
         if ( ! isAjaxCallMode( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_estadoscancelanContainerData"+"_"+sGXsfl_218_idx, Gridlevel_estadoscancelanContainer.ToJavascriptSource());
         }
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_adicionalesRow.AddGrid("Gridlevel_estadoscancelan", Gridlevel_estadoscancelanContainer);
         }
         if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
         {
            web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_estadoscancelanContainerData"+"V_"+sGXsfl_218_idx, Gridlevel_estadoscancelanContainer.GridValuesHidden());
         }
         else
         {
            httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_estadoscancelanContainerData"+"V_"+sGXsfl_218_idx+"\" value='"+Gridlevel_estadoscancelanContainer.GridValuesHidden()+"'/>") ;
         }
      }
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("table");
      }
      /* End of table */
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("table");
      }
      /* End of table */
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylelevel_adicionalesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("cell");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("row");
      }
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         Freestylelevel_adicionalesContainer.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashesLV3( ) ;
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_OPCIONES_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_nEOF_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_IMPORTESDEADICIONAL_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_OPCIONES_nEOF_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_OPCIONES_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_nEOF_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRIDLEVEL_ESTADOSCANCELAN_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "GRIDLEVEL_IMPORTESDEADICIONAL_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Rows, (byte)(6), (byte)(0), ".", "")));
      GXCCtl = "GRIDLEVEL_OPCIONES_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Rows, (byte)(6), (byte)(0), ".", "")));
      GXCCtl = "GRIDLEVEL_ESTADOSCANCELAN_Rows_" + sGXsfl_218_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Rows, (byte)(6), (byte)(0), ".", "")));
      GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage = 0 ;
      GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord = 0 ;
      /* End of Columns property logic. */
      Freestylelevel_adicionalesContainer.AddRow(Freestylelevel_adicionalesRow);
      nGXsfl_218_idx = ((subFreestylelevel_adicionales_Islastpage==1)&&(nGXsfl_218_idx+1>subfreestylelevel_adicionales_fnc_recordsperpage( )) ? 1 : nGXsfl_218_idx+1) ;
      sGXsfl_218_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_218_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2183( ) ;
      /* End function sendrow_2183 */
   }

   public void startgridcontrol36( )
   {
      if ( Freestylelevel_datosContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Freestylelevel_datosContainer"+"DivS\" data-gxgridid=\"36\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subFreestylelevel_datos_Internalname, subFreestylelevel_datos_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Freestylelevel_datosContainer.AddObjectProperty("GridName", "Freestylelevel_datos");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_datosContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Freestylelevel_datosContainer.Clear();
         }
         Freestylelevel_datosContainer.SetIsFreestyle(true);
         Freestylelevel_datosContainer.SetWrapped(nGXWrapped);
         Freestylelevel_datosContainer.AddObjectProperty("GridName", "Freestylelevel_datos");
         Freestylelevel_datosContainer.AddObjectProperty("Header", subFreestylelevel_datos_Header);
         Freestylelevel_datosContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         Freestylelevel_datosContainer.AddObjectProperty("Class", "FreeStyleGrid");
         Freestylelevel_datosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("CmpContext", "");
         Freestylelevel_datosContainer.AddObjectProperty("InMasterPage", "false");
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", localUtil.format(A1575CliConveVig, "99/99/99"));
         Freestylelevel_datosColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCliConveVig_Visible, (byte)(5), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1269ConveMesHsPExt, (byte)(5), (byte)(1), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.rtrim( A1270ConveDiaHsPExt));
         Freestylelevel_datosColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbConveDiaHsPExt.getVisible(), (byte)(5), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.booltostr( A1401ConveFondoCese));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", lblTextblockconveinterdiasjor_Caption);
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1043ConveInterDiasJor, (byte)(3), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", lblTextblockconveminmesesvac_Caption);
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1046ConveMinMesesVac, (byte)(2), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", lblTextblockconveguaredadmin_Caption);
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1627ConveGuarEdadMin, (byte)(2), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", lblTextblockconveguaredadmax_Caption);
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_datosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1628ConveGuarEdadMax, (byte)(2), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddColumnProperties(Freestylelevel_datosColumn);
         Freestylelevel_datosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_datosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_datos_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol130( )
   {
      if ( Freestylelevel_categoriasContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Freestylelevel_categoriasContainer"+"DivS\" data-gxgridid=\"130\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subFreestylelevel_categorias_Internalname, subFreestylelevel_categorias_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Freestylelevel_categoriasContainer.AddObjectProperty("GridName", "Freestylelevel_categorias");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_categoriasContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Freestylelevel_categoriasContainer.Clear();
         }
         Freestylelevel_categoriasContainer.SetIsFreestyle(true);
         Freestylelevel_categoriasContainer.SetWrapped(nGXWrapped);
         Freestylelevel_categoriasContainer.AddObjectProperty("GridName", "Freestylelevel_categorias");
         Freestylelevel_categoriasContainer.AddObjectProperty("Header", subFreestylelevel_categorias_Header);
         Freestylelevel_categoriasContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         Freestylelevel_categoriasContainer.AddObjectProperty("Class", "FreeStyleGrid");
         Freestylelevel_categoriasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("CmpContext", "");
         Freestylelevel_categoriasContainer.AddObjectProperty("InMasterPage", "false");
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", lblTextblockcatcodigo_Caption);
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", GXutil.rtrim( A8CatCodigo));
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", lblTextblockcatdescrip_Caption);
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", A123CatDescrip);
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1838CatClase, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_categoriasColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( cmbCatClase.getVisible(), (byte)(5), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_categoriasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1914CatFrecAct, (byte)(2), (byte)(0), ".", "")));
         Freestylelevel_categoriasColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtCatFrecAct_Visible, (byte)(5), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddColumnProperties(Freestylelevel_categoriasColumn);
         Freestylelevel_categoriasContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_categoriasContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_categorias_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol218( )
   {
      if ( Freestylelevel_adicionalesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Freestylelevel_adicionalesContainer"+"DivS\" data-gxgridid=\"218\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subFreestylelevel_adicionales_Internalname, subFreestylelevel_adicionales_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Freestylelevel_adicionalesContainer.AddObjectProperty("GridName", "Freestylelevel_adicionales");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Freestylelevel_adicionalesContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Freestylelevel_adicionalesContainer.Clear();
         }
         Freestylelevel_adicionalesContainer.SetIsFreestyle(true);
         Freestylelevel_adicionalesContainer.SetWrapped(nGXWrapped);
         Freestylelevel_adicionalesContainer.AddObjectProperty("GridName", "Freestylelevel_adicionales");
         Freestylelevel_adicionalesContainer.AddObjectProperty("Header", subFreestylelevel_adicionales_Header);
         Freestylelevel_adicionalesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         Freestylelevel_adicionalesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("CmpContext", "");
         Freestylelevel_adicionalesContainer.AddObjectProperty("InMasterPage", "false");
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", GXutil.rtrim( A996ConveAdicod));
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", A997ConveAdiDescri);
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A998ConveAdiAli, (byte)(6), (byte)(4), ".", "")));
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", lblTextblockconveadiinfo_Caption);
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", A1019ConveAdiInfo);
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesColumn.AddObjectProperty("Value", GXutil.rtrim( A1803ConveAdiTipo));
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylelevel_adicionalesContainer.AddColumnProperties(Freestylelevel_adicionalesColumn);
         Freestylelevel_adicionalesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Freestylelevel_adicionalesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylelevel_adicionales_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol204( )
   {
      if ( Gridlevel_importes2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_importes2Container"+"DivS\" data-gxgridid=\"204\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_importes2_Internalname, subGridlevel_importes2_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_importes2_Backcolorstyle == 0 )
         {
            subGridlevel_importes2_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_importes2_Class) > 0 )
            {
               subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_importes2_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_importes2_Backcolorstyle == 1 )
            {
               subGridlevel_importes2_Titlebackcolor = subGridlevel_importes2_Allbackcolor ;
               if ( GXutil.len( subGridlevel_importes2_Class) > 0 )
               {
                  subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_importes2_Class) > 0 )
               {
                  subGridlevel_importes2_Linesclass = subGridlevel_importes2_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_importes2Container.AddObjectProperty("GridName", "Gridlevel_importes2");
      }
      else
      {
         Gridlevel_importes2Container.AddObjectProperty("GridName", "Gridlevel_importes2");
         Gridlevel_importes2Container.AddObjectProperty("Header", subGridlevel_importes2_Header);
         Gridlevel_importes2Container.AddObjectProperty("Class", "WorkWith");
         Gridlevel_importes2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("CmpContext", "");
         Gridlevel_importes2Container.AddObjectProperty("InMasterPage", "false");
         Gridlevel_importes2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importes2Column.AddObjectProperty("Value", localUtil.format(AV32CliConveImpVig, "99/99/99"));
         Gridlevel_importes2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCliconveimpvig_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddColumnProperties(Gridlevel_importes2Column);
         Gridlevel_importes2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importes2Column.AddObjectProperty("Value", GXutil.rtrim( AV35CliConveImpTipo));
         Gridlevel_importes2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavCliconveimptipo.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddColumnProperties(Gridlevel_importes2Column);
         Gridlevel_importes2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importes2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV36CliConveImporte, (byte)(17), (byte)(2), ".", "")));
         Gridlevel_importes2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCliconveimporte_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddColumnProperties(Gridlevel_importes2Column);
         Gridlevel_importes2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importes2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes2_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol194( )
   {
      if ( Gridlevel_importesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_importesContainer"+"DivS\" data-gxgridid=\"194\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_importes_Internalname, subGridlevel_importes_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_importes_Backcolorstyle == 0 )
         {
            subGridlevel_importes_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_importes_Class) > 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_importes_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_importes_Backcolorstyle == 1 )
            {
               subGridlevel_importes_Titlebackcolor = subGridlevel_importes_Allbackcolor ;
               if ( GXutil.len( subGridlevel_importes_Class) > 0 )
               {
                  subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_importes_Class) > 0 )
               {
                  subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_importesContainer.AddObjectProperty("GridName", "Gridlevel_importes");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_importesContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_importesContainer.Clear();
         }
         Gridlevel_importesContainer.SetWrapped(nGXWrapped);
         Gridlevel_importesContainer.AddObjectProperty("GridName", "Gridlevel_importes");
         Gridlevel_importesContainer.AddObjectProperty("Header", subGridlevel_importes_Header);
         Gridlevel_importesContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_importesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_importesContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importesColumn.AddObjectProperty("Value", localUtil.format(A1587CliConveImpVig, "99/99/99"));
         Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
         Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importesColumn.AddObjectProperty("Value", GXutil.rtrim( A1588CliConveImpTipo));
         Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
         Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1589CliConveImporte, (byte)(17), (byte)(2), ".", "")));
         Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
         Gridlevel_importesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol93( )
   {
      if ( Gridlevel_vacacionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_vacacionesContainer"+"DivS\" data-gxgridid=\"93\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_vacaciones_Internalname, subGridlevel_vacaciones_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_vacaciones_Backcolorstyle == 0 )
         {
            subGridlevel_vacaciones_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
            {
               subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_vacaciones_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_vacaciones_Backcolorstyle == 1 )
            {
               subGridlevel_vacaciones_Titlebackcolor = subGridlevel_vacaciones_Allbackcolor ;
               if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_vacaciones_Class) > 0 )
               {
                  subGridlevel_vacaciones_Linesclass = subGridlevel_vacaciones_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Años de antiguedad desde", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Años de antiguedad hasta", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Días de vacaciones", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liberación", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_vacacionesContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_vacacionesContainer.Clear();
         }
         Gridlevel_vacacionesContainer.SetWrapped(nGXWrapped);
         Gridlevel_vacacionesContainer.AddObjectProperty("GridName", "Gridlevel_vacaciones");
         Gridlevel_vacacionesContainer.AddObjectProperty("Header", subGridlevel_vacaciones_Header);
         Gridlevel_vacacionesContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_vacacionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_vacacionesContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_vacacionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1902ConveVacRelSec, (byte)(6), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddColumnProperties(Gridlevel_vacacionesColumn);
         Gridlevel_vacacionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_vacacionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_vacaciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol166( )
   {
      if ( Gridlevel_valoresContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_valoresContainer"+"DivS\" data-gxgridid=\"166\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_valores_Internalname, subGridlevel_valores_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_valores_Backcolorstyle == 0 )
         {
            subGridlevel_valores_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_valores_Class) > 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_valores_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_valores_Backcolorstyle == 1 )
            {
               subGridlevel_valores_Titlebackcolor = subGridlevel_valores_Allbackcolor ;
               if ( GXutil.len( subGridlevel_valores_Class) > 0 )
               {
                  subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_valores_Class) > 0 )
               {
                  subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Básico", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Adicional", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_valoresContainer.Clear();
         }
         Gridlevel_valoresContainer.SetWrapped(nGXWrapped);
         Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
         Gridlevel_valoresContainer.AddObjectProperty("Header", subGridlevel_valores_Header);
         Gridlevel_valoresContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_valoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_valoresContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_valoresColumn.AddObjectProperty("Value", localUtil.format(A907CatVigencia, "99/99/9999"));
         Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
         Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), ".", "")));
         Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
         Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), ".", "")));
         Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
         Gridlevel_valoresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_valoresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol265( )
   {
      if ( Gridlevel_importesdeadicionalContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_importesdeadicionalContainer"+"DivS\" data-gxgridid=\"265\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_importesdeadicional_Internalname, subGridlevel_importesdeadicional_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_importesdeadicional_Backcolorstyle == 0 )
         {
            subGridlevel_importesdeadicional_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_importesdeadicional_Class) > 0 )
            {
               subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_importesdeadicional_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_importesdeadicional_Backcolorstyle == 1 )
            {
               subGridlevel_importesdeadicional_Titlebackcolor = subGridlevel_importesdeadicional_Allbackcolor ;
               if ( GXutil.len( subGridlevel_importesdeadicional_Class) > 0 )
               {
                  subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_importesdeadicional_Class) > 0 )
               {
                  subGridlevel_importesdeadicional_Linesclass = subGridlevel_importesdeadicional_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha de vigencia", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("GridName", "Gridlevel_importesdeadicional");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_importesdeadicionalContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_importesdeadicionalContainer.Clear();
         }
         Gridlevel_importesdeadicionalContainer.SetWrapped(nGXWrapped);
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("GridName", "Gridlevel_importesdeadicional");
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Header", subGridlevel_importesdeadicional_Header);
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_importesdeadicionalColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importesdeadicionalColumn.AddObjectProperty("Value", localUtil.format(A999ConveAdiVig, "99/99/99"));
         Gridlevel_importesdeadicionalContainer.AddColumnProperties(Gridlevel_importesdeadicionalColumn);
         Gridlevel_importesdeadicionalColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_importesdeadicionalColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddColumnProperties(Gridlevel_importesdeadicionalColumn);
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_importesdeadicionalContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_importesdeadicional_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol277( )
   {
      if ( Gridlevel_opcionesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_opcionesContainer"+"DivS\" data-gxgridid=\"277\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_opciones_Internalname, subGridlevel_opciones_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_opciones_Backcolorstyle == 0 )
         {
            subGridlevel_opciones_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_opciones_Class) > 0 )
            {
               subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_opciones_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_opciones_Backcolorstyle == 1 )
            {
               subGridlevel_opciones_Titlebackcolor = subGridlevel_opciones_Allbackcolor ;
               if ( GXutil.len( subGridlevel_opciones_Class) > 0 )
               {
                  subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_opciones_Class) > 0 )
               {
                  subGridlevel_opciones_Linesclass = subGridlevel_opciones_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción Nro.", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opción Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Alícuota", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_opcionesContainer.AddObjectProperty("GridName", "Gridlevel_opciones");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_opcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_opcionesContainer.Clear();
         }
         Gridlevel_opcionesContainer.SetWrapped(nGXWrapped);
         Gridlevel_opcionesContainer.AddObjectProperty("GridName", "Gridlevel_opciones");
         Gridlevel_opcionesContainer.AddObjectProperty("Header", subGridlevel_opciones_Header);
         Gridlevel_opcionesContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_opcionesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_opcionesContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
         Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.rtrim( A1021ConveAdiOpcFor));
         Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
         Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_opcionesColumn.AddObjectProperty("Value", A1012ConveAdiOpcDes);
         Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
         Gridlevel_opcionesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_opcionesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), ".", "")));
         Gridlevel_opcionesContainer.AddColumnProperties(Gridlevel_opcionesColumn);
         Gridlevel_opcionesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_opcionesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_opciones_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol291( )
   {
      if ( Gridlevel_estadoscancelanContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridlevel_estadoscancelanContainer"+"DivS\" data-gxgridid=\"291\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridlevel_estadoscancelan_Internalname, subGridlevel_estadoscancelan_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridlevel_estadoscancelan_Backcolorstyle == 0 )
         {
            subGridlevel_estadoscancelan_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridlevel_estadoscancelan_Class) > 0 )
            {
               subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Title" ;
            }
         }
         else
         {
            subGridlevel_estadoscancelan_Titlebackstyle = (byte)(1) ;
            if ( subGridlevel_estadoscancelan_Backcolorstyle == 1 )
            {
               subGridlevel_estadoscancelan_Titlebackcolor = subGridlevel_estadoscancelan_Allbackcolor ;
               if ( GXutil.len( subGridlevel_estadoscancelan_Class) > 0 )
               {
                  subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridlevel_estadoscancelan_Class) > 0 )
               {
                  subGridlevel_estadoscancelan_Linesclass = subGridlevel_estadoscancelan_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridlevel_estadoscancelanContainer.AddObjectProperty("GridName", "Gridlevel_estadoscancelan");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Gridlevel_estadoscancelanContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Gridlevel_estadoscancelanContainer.Clear();
         }
         Gridlevel_estadoscancelanContainer.SetWrapped(nGXWrapped);
         Gridlevel_estadoscancelanContainer.AddObjectProperty("GridName", "Gridlevel_estadoscancelan");
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Header", subGridlevel_estadoscancelan_Header);
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Class", "WorkWith");
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("CmpContext", "");
         Gridlevel_estadoscancelanContainer.AddObjectProperty("InMasterPage", "false");
         Gridlevel_estadoscancelanColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridlevel_estadoscancelanColumn.AddObjectProperty("Value", GXutil.rtrim( A1824ConveAdiSitCancela));
         Gridlevel_estadoscancelanContainer.AddColumnProperties(Gridlevel_estadoscancelanColumn);
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridlevel_estadoscancelanContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_estadoscancelan_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTabgeneral_title_Internalname = "TABGENERAL_TITLE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      edtCliConvenioDescrip_Internalname = "CLICONVENIODESCRIP" ;
      edtCliConveVig_Internalname = "CLICONVEVIG" ;
      divCliconvevig_cell_Internalname = "CLICONVEVIG_CELL" ;
      edtConveMesHsPExt_Internalname = "CONVEMESHSPEXT" ;
      cmbConveDiaHsPExt.setInternalname( "CONVEDIAHSPEXT" );
      divConvediahspext_cell_Internalname = "CONVEDIAHSPEXT_CELL" ;
      chkConveFondoCese.setInternalname( "CONVEFONDOCESE" );
      lblTextblockconveinterdiasjor_Internalname = "TEXTBLOCKCONVEINTERDIASJOR" ;
      edtConveInterDiasJor_Internalname = "CONVEINTERDIASJOR" ;
      divUnnamedtableconveinterdiasjor_Internalname = "UNNAMEDTABLECONVEINTERDIASJOR" ;
      lblTextblockconveminmesesvac_Internalname = "TEXTBLOCKCONVEMINMESESVAC" ;
      edtConveMinMesesVac_Internalname = "CONVEMINMESESVAC" ;
      divUnnamedtableconveminmesesvac_Internalname = "UNNAMEDTABLECONVEMINMESESVAC" ;
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT" ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT" ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS" ;
      edtConveVacRelSec_Internalname = "CONVEVACRELSEC" ;
      divTableleaflevel_vacaciones_Internalname = "TABLELEAFLEVEL_VACACIONES" ;
      divUnnamedtable20_Internalname = "UNNAMEDTABLE20" ;
      Dvpanel_unnamedtable20_Internalname = "DVPANEL_UNNAMEDTABLE20" ;
      tblUnnamedtable16_Internalname = "UNNAMEDTABLE16" ;
      grpUnnamedgroup17_Internalname = "UNNAMEDGROUP17" ;
      lblTextblockconveguaredadmin_Internalname = "TEXTBLOCKCONVEGUAREDADMIN" ;
      edtConveGuarEdadMin_Internalname = "CONVEGUAREDADMIN" ;
      divUnnamedtableconveguaredadmin_Internalname = "UNNAMEDTABLECONVEGUAREDADMIN" ;
      lblTextblockconveguaredadmax_Internalname = "TEXTBLOCKCONVEGUAREDADMAX" ;
      edtConveGuarEdadMax_Internalname = "CONVEGUAREDADMAX" ;
      divUnnamedtableconveguaredadmax_Internalname = "UNNAMEDTABLECONVEGUAREDADMAX" ;
      tblUnnamedtable18_Internalname = "UNNAMEDTABLE18" ;
      grpUnnamedgroup19_Internalname = "UNNAMEDGROUP19" ;
      divTableintermediateinslevel_datos_Internalname = "TABLEINTERMEDIATEINSLEVEL_DATOS" ;
      tblUnnamedtablefsfreestylelevel_datos_Internalname = "UNNAMEDTABLEFSFREESTYLELEVEL_DATOS" ;
      divTableintermediatelevel_datos_Internalname = "TABLEINTERMEDIATELEVEL_DATOS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblTablevel_categorias_title_Internalname = "TABLEVEL_CATEGORIAS_TITLE" ;
      lblTextblockcatcodigo_Internalname = "TEXTBLOCKCATCODIGO" ;
      edtCatCodigo_Internalname = "CATCODIGO" ;
      divUnnamedtablecatcodigo_Internalname = "UNNAMEDTABLECATCODIGO" ;
      lblTextblockcatdescrip_Internalname = "TEXTBLOCKCATDESCRIP" ;
      edtCatDescrip_Internalname = "CATDESCRIP" ;
      divUnnamedtablecatdescrip_Internalname = "UNNAMEDTABLECATDESCRIP" ;
      edtCatVigencia_Internalname = "CATVIGENCIA" ;
      edtEscBasico_Internalname = "ESCBASICO" ;
      edtEscAdicional_Internalname = "ESCADICIONAL" ;
      divTableleaflevel_valores_Internalname = "TABLELEAFLEVEL_VALORES" ;
      tblGroupsalario_Internalname = "GROUPSALARIO" ;
      grpUnnamedgroup15_Internalname = "UNNAMEDGROUP15" ;
      tblUnnamedtable13_Internalname = "UNNAMEDTABLE13" ;
      grpUnnamedgroup14_Internalname = "UNNAMEDGROUP14" ;
      divTableintermediateinslevel_categorias_Internalname = "TABLEINTERMEDIATEINSLEVEL_CATEGORIAS" ;
      cmbCatClase.setInternalname( "CATCLASE" );
      edtCatFrecAct_Internalname = "CATFRECACT" ;
      tblUnnamedtablecontentfsfreestylelevel_categorias_Internalname = "UNNAMEDTABLECONTENTFSFREESTYLELEVEL_CATEGORIAS" ;
      tblUnnamedtablefsfreestylelevel_categorias_Internalname = "UNNAMEDTABLEFSFREESTYLELEVEL_CATEGORIAS" ;
      divTableintermediatelevel_categorias_Internalname = "TABLEINTERMEDIATELEVEL_CATEGORIAS" ;
      divTabtablelevel_categorias_Internalname = "TABTABLELEVEL_CATEGORIAS" ;
      lblTablevel_importes_title_Internalname = "TABLEVEL_IMPORTES_TITLE" ;
      edtCliConveImpVig_Internalname = "CLICONVEIMPVIG" ;
      cmbCliConveImpTipo.setInternalname( "CLICONVEIMPTIPO" );
      edtCliConveImporte_Internalname = "CLICONVEIMPORTE" ;
      tblUnnamedtable9_Internalname = "UNNAMEDTABLE9" ;
      grpUnnamedgroup10_Internalname = "UNNAMEDGROUP10" ;
      edtavCliconveimpvig_Internalname = "vCLICONVEIMPVIG" ;
      cmbavCliconveimptipo.setInternalname( "vCLICONVEIMPTIPO" );
      edtavCliconveimporte_Internalname = "vCLICONVEIMPORTE" ;
      tblUnnamedtable11_Internalname = "UNNAMEDTABLE11" ;
      grpUnnamedgroup12_Internalname = "UNNAMEDGROUP12" ;
      divTableleaflevel_importes_Internalname = "TABLELEAFLEVEL_IMPORTES" ;
      divTabtablelevel_importes_Internalname = "TABTABLELEVEL_IMPORTES" ;
      lblTablevel_adicionales_title_Internalname = "TABLEVEL_ADICIONALES_TITLE" ;
      edtConveAdicod_Internalname = "CONVEADICOD" ;
      edtConveAdiDescri_Internalname = "CONVEADIDESCRI" ;
      edtConveAdiAli_Internalname = "CONVEADIALI" ;
      lblTextblockconveadiinfo_Internalname = "TEXTBLOCKCONVEADIINFO" ;
      edtConveAdiInfo_Internalname = "CONVEADIINFO" ;
      divUnnamedtableconveadiinfo_Internalname = "UNNAMEDTABLECONVEADIINFO" ;
      cmbConveAdiTipo.setInternalname( "CONVEADITIPO" );
      edtConveAdiVig_Internalname = "CONVEADIVIG" ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE" ;
      divTableleaflevel_importesdeadicional_Internalname = "TABLELEAFLEVEL_IMPORTESDEADICIONAL" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      grpUnnamedgroup4_Internalname = "UNNAMEDGROUP4" ;
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD" ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR" ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES" ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI" ;
      divTableleaflevel_alicuotas_Internalname = "TABLELEAFLEVEL_ALICUOTAS" ;
      tblUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      grpUnnamedgroup6_Internalname = "UNNAMEDGROUP6" ;
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA" ;
      divTableleaflevel_estadoscancelan_Internalname = "TABLELEAFLEVEL_ESTADOSCANCELAN" ;
      tblUnnamedtable7_Internalname = "UNNAMEDTABLE7" ;
      grpUnnamedgroup8_Internalname = "UNNAMEDGROUP8" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      divTableintermediateinslevel_adicionales_Internalname = "TABLEINTERMEDIATEINSLEVEL_ADICIONALES" ;
      tblUnnamedtablefsfreestylelevel_adicionales_Internalname = "UNNAMEDTABLEFSFREESTYLELEVEL_ADICIONALES" ;
      divTableintermediatelevel_adicionales_Internalname = "TABLEINTERMEDIATELEVEL_ADICIONALES" ;
      divTabtablelevel_adicionales_Internalname = "TABTABLELEVEL_ADICIONALES" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      Gridlevel_estadoscancelan_empowerer_Internalname = "GRIDLEVEL_ESTADOSCANCELAN_EMPOWERER" ;
      Gridlevel_opciones_empowerer_Internalname = "GRIDLEVEL_OPCIONES_EMPOWERER" ;
      Gridlevel_importesdeadicional_empowerer_Internalname = "GRIDLEVEL_IMPORTESDEADICIONAL_EMPOWERER" ;
      Gridlevel_importes2_empowerer_Internalname = "GRIDLEVEL_IMPORTES2_EMPOWERER" ;
      Gridlevel_importes_empowerer_Internalname = "GRIDLEVEL_IMPORTES_EMPOWERER" ;
      Gridlevel_valores_empowerer_Internalname = "GRIDLEVEL_VALORES_EMPOWERER" ;
      Gridlevel_vacaciones_empowerer_Internalname = "GRIDLEVEL_VACACIONES_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_vacaciones_Internalname = "GRIDLEVEL_VACACIONES" ;
      subFreestylelevel_datos_Internalname = "FREESTYLELEVEL_DATOS" ;
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES" ;
      subFreestylelevel_categorias_Internalname = "FREESTYLELEVEL_CATEGORIAS" ;
      subGridlevel_importes_Internalname = "GRIDLEVEL_IMPORTES" ;
      subGridlevel_importes2_Internalname = "GRIDLEVEL_IMPORTES2" ;
      subGridlevel_importesdeadicional_Internalname = "GRIDLEVEL_IMPORTESDEADICIONAL" ;
      subGridlevel_opciones_Internalname = "GRIDLEVEL_OPCIONES" ;
      subGridlevel_estadoscancelan_Internalname = "GRIDLEVEL_ESTADOSCANCELAN" ;
      subFreestylelevel_adicionales_Internalname = "FREESTYLELEVEL_ADICIONALES" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridlevel_estadoscancelan_Allowcollapsing = (byte)(0) ;
      subGridlevel_estadoscancelan_Allowselection = (byte)(0) ;
      subGridlevel_estadoscancelan_Header = "" ;
      subGridlevel_opciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_opciones_Allowselection = (byte)(0) ;
      subGridlevel_opciones_Header = "" ;
      subGridlevel_importesdeadicional_Allowcollapsing = (byte)(0) ;
      subGridlevel_importesdeadicional_Allowselection = (byte)(0) ;
      subGridlevel_importesdeadicional_Header = "" ;
      subGridlevel_valores_Allowcollapsing = (byte)(0) ;
      subGridlevel_valores_Allowselection = (byte)(0) ;
      subGridlevel_valores_Header = "" ;
      subGridlevel_vacaciones_Allowcollapsing = (byte)(0) ;
      subGridlevel_vacaciones_Allowselection = (byte)(0) ;
      subGridlevel_vacaciones_Header = "" ;
      subGridlevel_importes_Allowcollapsing = (byte)(0) ;
      subGridlevel_importes_Allowselection = (byte)(0) ;
      subGridlevel_importes_Header = "" ;
      subGridlevel_importes2_Allowcollapsing = (byte)(0) ;
      subGridlevel_importes2_Allowselection = (byte)(0) ;
      subGridlevel_importes2_Header = "" ;
      subFreestylelevel_adicionales_Allowcollapsing = (byte)(0) ;
      lblTextblockconveadiinfo_Caption = httpContext.getMessage( "Información adicional", "") ;
      subFreestylelevel_categorias_Allowcollapsing = (byte)(0) ;
      lblTextblockcatdescrip_Caption = httpContext.getMessage( "Descripción", "") ;
      lblTextblockcatcodigo_Caption = httpContext.getMessage( "Código", "") ;
      subFreestylelevel_datos_Allowcollapsing = (byte)(0) ;
      lblTextblockconveguaredadmax_Caption = httpContext.getMessage( "Edad máxima en años del hijo/hija hasta la que puede gozar el beneficio de guardería", "") ;
      lblTextblockconveguaredadmin_Caption = httpContext.getMessage( "Edad del hijo/hija mínima en meses para gozar de beneficio de guardería", "") ;
      lblTextblockconveminmesesvac_Caption = httpContext.getMessage( "Antiguedad en meses mínima para acumular días fijos de vacaciones", "") ;
      lblTextblockconveinterdiasjor_Caption = httpContext.getMessage( "Intervalo de jornadas trabajadas para x días de vacación", "") ;
      cmbConveAdiTipo.setJsonclick( "" );
      edtConveAdiAli_Jsonclick = "" ;
      edtConveAdicod_Jsonclick = "" ;
      subFreestylelevel_adicionales_Class = "FreeStyleGrid" ;
      edtConveAdiSitCancela_Jsonclick = "" ;
      subGridlevel_estadoscancelan_Class = "WorkWith" ;
      subGridlevel_estadoscancelan_Backcolorstyle = (byte)(0) ;
      edtConveAdiOpcAli_Jsonclick = "" ;
      edtConveAdiOpcDes_Jsonclick = "" ;
      edtConveAdiOpcFor_Jsonclick = "" ;
      edtConveAdiOpcCod_Jsonclick = "" ;
      subGridlevel_opciones_Class = "WorkWith" ;
      subGridlevel_opciones_Backcolorstyle = (byte)(0) ;
      edtConveAdiImporte_Jsonclick = "" ;
      edtConveAdiVig_Jsonclick = "" ;
      subGridlevel_importesdeadicional_Class = "WorkWith" ;
      subGridlevel_importesdeadicional_Backcolorstyle = (byte)(0) ;
      edtavCliconveimporte_Jsonclick = "" ;
      edtavCliconveimporte_Enabled = 0 ;
      cmbavCliconveimptipo.setJsonclick( "" );
      cmbavCliconveimptipo.setEnabled( 0 );
      edtavCliconveimpvig_Jsonclick = "" ;
      edtavCliconveimpvig_Enabled = 0 ;
      subGridlevel_importes2_Class = "WorkWith" ;
      subGridlevel_importes2_Backcolorstyle = (byte)(0) ;
      edtCliConveImporte_Jsonclick = "" ;
      cmbCliConveImpTipo.setJsonclick( "" );
      edtCliConveImpVig_Jsonclick = "" ;
      subGridlevel_importes_Class = "WorkWith" ;
      subGridlevel_importes_Backcolorstyle = (byte)(0) ;
      edtCatFrecAct_Jsonclick = "" ;
      cmbCatClase.setJsonclick( "" );
      edtCatCodigo_Jsonclick = "" ;
      subFreestylelevel_categorias_Class = "FreeStyleGrid" ;
      edtEscAdicional_Jsonclick = "" ;
      edtEscBasico_Jsonclick = "" ;
      edtCatVigencia_Jsonclick = "" ;
      subGridlevel_valores_Class = "WorkWith" ;
      subGridlevel_valores_Backcolorstyle = (byte)(0) ;
      edtConveGuarEdadMax_Jsonclick = "" ;
      edtConveGuarEdadMin_Jsonclick = "" ;
      edtConveMinMesesVac_Jsonclick = "" ;
      edtConveInterDiasJor_Jsonclick = "" ;
      chkConveFondoCese.setCaption( httpContext.getMessage( "Maneja fondo de cese laboral (no liquida indemnizacion por antiguedad ni sustitutiva del preaviso)", "") );
      cmbConveDiaHsPExt.setJsonclick( "" );
      edtConveMesHsPExt_Jsonclick = "" ;
      edtCliConveVig_Jsonclick = "" ;
      subFreestylelevel_datos_Class = "FreeStyleGrid" ;
      edtConveVacRelSec_Jsonclick = "" ;
      edtCliConveVacDias_Jsonclick = "" ;
      edtCliConveVacHasAnt_Jsonclick = "" ;
      edtCliConveVacDesAnt_Jsonclick = "" ;
      subGridlevel_vacaciones_Class = "WorkWith" ;
      subGridlevel_vacaciones_Backcolorstyle = (byte)(0) ;
      edtCliConvenioDescrip_Enabled = 0 ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 0 ;
      divConvediahspext_cell_Class = "col-xs-12" ;
      divCliconvevig_cell_Class = "col-xs-12" ;
      subFreestylelevel_categorias_Backcolorstyle = (byte)(0) ;
      subFreestylelevel_adicionales_Backcolorstyle = (byte)(0) ;
      subFreestylelevel_datos_Backcolorstyle = (byte)(0) ;
      Dvpanel_unnamedtable20_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable20_Iconposition = "Right" ;
      Dvpanel_unnamedtable20_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable20_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable20_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable20_Title = httpContext.getMessage( "Vacaciones por antiguedad", "") ;
      Dvpanel_unnamedtable20_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable20_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable20_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable20_Width = "100%" ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Visible = 1 ;
      Gridlevel_estadoscancelan_empowerer_Infinitescrolling = "Grid" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "VerticalTabs" ;
      Gxuitabspanel_tabs_Pagecount = 4 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Convenio Tabs", "") );
      edtCatFrecAct_Visible = 1 ;
      cmbCatClase.setVisible( 1 );
      cmbConveDiaHsPExt.setVisible( 1 );
      edtCliConveVig_Visible = 1 ;
      subGridlevel_estadoscancelan_Rows = 50 ;
      subGridlevel_opciones_Rows = 0 ;
      subGridlevel_importesdeadicional_Rows = 0 ;
      subGridlevel_importes2_Rows = 0 ;
      subGridlevel_importes_Rows = 0 ;
      subGridlevel_valores_Rows = 0 ;
      subGridlevel_vacaciones_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "CONVEDIAHSPEXT_" + sGXsfl_36_idx ;
      cmbConveDiaHsPExt.setName( GXCCtl );
      cmbConveDiaHsPExt.setWebtags( "" );
      cmbConveDiaHsPExt.addItem("", httpContext.getMessage( "(Default)", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("Promedio", httpContext.getMessage( "Promedio anual de días hábiles semanales por mes del empleado", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("diasSemanaX4", httpContext.getMessage( "Cantidad de días hábiles semanales del empleado multiplicados por 4", ""), (short)(0));
      cmbConveDiaHsPExt.addItem("diasSemanaMes", httpContext.getMessage( "Cantidad de días hábiles del empleado en el mes específico de la liquidación", ""), (short)(0));
      if ( cmbConveDiaHsPExt.getItemCount() > 0 )
      {
         A1270ConveDiaHsPExt = cmbConveDiaHsPExt.getValidValue(A1270ConveDiaHsPExt) ;
         n1270ConveDiaHsPExt = false ;
      }
      GXCCtl = "CONVEFONDOCESE_" + sGXsfl_36_idx ;
      chkConveFondoCese.setName( GXCCtl );
      chkConveFondoCese.setWebtags( "" );
      chkConveFondoCese.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveFondoCese.getInternalname(), "TitleCaption", chkConveFondoCese.getCaption(), !bGXsfl_36_Refreshing);
      chkConveFondoCese.setCheckedValue( "false" );
      A1401ConveFondoCese = GXutil.strtobool( GXutil.booltostr( A1401ConveFondoCese)) ;
      GXCCtl = "CATCLASE_" + sGXsfl_130_idx ;
      cmbCatClase.setName( GXCCtl );
      cmbCatClase.setWebtags( "" );
      cmbCatClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbCatClase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbCatClase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbCatClase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbCatClase.getItemCount() > 0 )
      {
         A1838CatClase = (byte)(GXutil.lval( cmbCatClase.getValidValue(GXutil.trim( GXutil.str( A1838CatClase, 1, 0))))) ;
      }
      GXCCtl = "CLICONVEIMPTIPO_" + sGXsfl_194_idx ;
      cmbCliConveImpTipo.setName( GXCCtl );
      cmbCliConveImpTipo.setWebtags( "" );
      cmbCliConveImpTipo.addItem("TopeIndem", httpContext.getMessage( "Tope indemnizatorio", ""), (short)(0));
      cmbCliConveImpTipo.addItem("Guarderia", httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), (short)(0));
      if ( cmbCliConveImpTipo.getItemCount() > 0 )
      {
         A1588CliConveImpTipo = cmbCliConveImpTipo.getValidValue(A1588CliConveImpTipo) ;
      }
      GXCCtl = "vCLICONVEIMPTIPO_" + sGXsfl_204_idx ;
      cmbavCliconveimptipo.setName( GXCCtl );
      cmbavCliconveimptipo.setWebtags( "" );
      cmbavCliconveimptipo.addItem("TopeIndem", httpContext.getMessage( "Tope indemnizatorio", ""), (short)(0));
      cmbavCliconveimptipo.addItem("Guarderia", httpContext.getMessage( "Importe fijo para compensación por gastos de guardería", ""), (short)(0));
      if ( cmbavCliconveimptipo.getItemCount() > 0 )
      {
         AV35CliConveImpTipo = cmbavCliconveimptipo.getValidValue(AV35CliConveImpTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavCliconveimptipo.getInternalname(), AV35CliConveImpTipo);
      }
      GXCCtl = "CONVEADITIPO_" + sGXsfl_218_idx ;
      cmbConveAdiTipo.setName( GXCCtl );
      cmbConveAdiTipo.setWebtags( "" );
      cmbConveAdiTipo.addItem("titulo", httpContext.getMessage( "Tìtulo", ""), (short)(0));
      cmbConveAdiTipo.addItem("otros", httpContext.getMessage( "Otros", ""), (short)(0));
      if ( cmbConveAdiTipo.getItemCount() > 0 )
      {
         A1803ConveAdiTipo = cmbConveAdiTipo.getValidValue(A1803ConveAdiTipo) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FREESTYLELEVEL_DATOS_nFirstRecordOnPage'},{av:'FREESTYLELEVEL_DATOS_nEOF'},{av:'edtCliConveVig_Visible',ctrl:'CLICONVEVIG',prop:'Visible'},{av:'cmbConveDiaHsPExt'},{av:'FREESTYLELEVEL_ADICIONALES_nFirstRecordOnPage'},{av:'FREESTYLELEVEL_ADICIONALES_nEOF'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nEOF'},{av:'GRIDLEVEL_OPCIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_OPCIONES_nEOF'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nEOF'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''},{av:'GRIDLEVEL_IMPORTES2_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES2_nEOF'},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'GRIDLEVEL_IMPORTES_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES_nEOF'},{av:'FREESTYLELEVEL_CATEGORIAS_nFirstRecordOnPage'},{av:'FREESTYLELEVEL_CATEGORIAS_nEOF'},{av:'cmbCatClase'},{av:'edtCatFrecAct_Visible',ctrl:'CATFRECACT',prop:'Visible'},{av:'GRIDLEVEL_VALORES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VALORES_nEOF'},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''},{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("FREESTYLELEVEL_ADICIONALES.LOAD","{handler:'e18LV3',iparms:[]");
      setEventMetadata("FREESTYLELEVEL_ADICIONALES.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN.LOAD","{handler:'e21LV4',iparms:[]");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_OPCIONES.LOAD","{handler:'e20LV5',iparms:[]");
      setEventMetadata("GRIDLEVEL_OPCIONES.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL.LOAD","{handler:'e19LV6',iparms:[]");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES2.LOAD","{handler:'e17LV7',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRIDLEVEL_IMPORTES2.LOAD",",oparms:[{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'cmbavCliconveimptipo'},{av:'AV35CliConveImpTipo',fld:'vCLICONVEIMPTIPO',pic:''},{av:'AV36CliConveImporte',fld:'vCLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("GRIDLEVEL_IMPORTES.LOAD","{handler:'e16LV9',iparms:[]");
      setEventMetadata("GRIDLEVEL_IMPORTES.LOAD",",oparms:[]}");
      setEventMetadata("FREESTYLELEVEL_CATEGORIAS.LOAD","{handler:'e14LV10',iparms:[]");
      setEventMetadata("FREESTYLELEVEL_CATEGORIAS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VALORES.LOAD","{handler:'e15LV11',iparms:[]");
      setEventMetadata("GRIDLEVEL_VALORES.LOAD",",oparms:[]}");
      setEventMetadata("FREESTYLELEVEL_DATOS.LOAD","{handler:'e12LV2',iparms:[]");
      setEventMetadata("FREESTYLELEVEL_DATOS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VACACIONES.LOAD","{handler:'e13LV12',iparms:[]");
      setEventMetadata("GRIDLEVEL_VACACIONES.LOAD",",oparms:[]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e22LV1',iparms:[]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e23LV1',iparms:[]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_FIRSTPAGE","{handler:'subgridlevel_estadoscancelan_firstpage',iparms:[{av:'GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_PREVPAGE","{handler:'subgridlevel_estadoscancelan_previouspage',iparms:[{av:'GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_NEXTPAGE","{handler:'subgridlevel_estadoscancelan_nextpage',iparms:[{av:'GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_LASTPAGE","{handler:'subgridlevel_estadoscancelan_lastpage',iparms:[{av:'GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage'},{av:'GRIDLEVEL_ESTADOSCANCELAN_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_ESTADOSCANCELAN_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_OPCIONES_FIRSTPAGE","{handler:'subgridlevel_opciones_firstpage',iparms:[{av:'GRIDLEVEL_OPCIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_OPCIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_OPCIONES_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_OPCIONES_PREVPAGE","{handler:'subgridlevel_opciones_previouspage',iparms:[{av:'GRIDLEVEL_OPCIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_OPCIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_OPCIONES_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_OPCIONES_NEXTPAGE","{handler:'subgridlevel_opciones_nextpage',iparms:[{av:'GRIDLEVEL_OPCIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_OPCIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_OPCIONES_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_OPCIONES_LASTPAGE","{handler:'subgridlevel_opciones_lastpage',iparms:[{av:'GRIDLEVEL_OPCIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_OPCIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_OPCIONES_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_FIRSTPAGE","{handler:'subgridlevel_importesdeadicional_firstpage',iparms:[{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_PREVPAGE","{handler:'subgridlevel_importesdeadicional_previouspage',iparms:[{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_NEXTPAGE","{handler:'subgridlevel_importesdeadicional_nextpage',iparms:[{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_LASTPAGE","{handler:'subgridlevel_importesdeadicional_lastpage',iparms:[{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTESDEADICIONAL_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("GRIDLEVEL_IMPORTESDEADICIONAL_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES2_FIRSTPAGE","{handler:'subgridlevel_importes2_firstpage',iparms:[{av:'GRIDLEVEL_IMPORTES2_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES2_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRIDLEVEL_IMPORTES2_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES2_PREVPAGE","{handler:'subgridlevel_importes2_previouspage',iparms:[{av:'GRIDLEVEL_IMPORTES2_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES2_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRIDLEVEL_IMPORTES2_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES2_NEXTPAGE","{handler:'subgridlevel_importes2_nextpage',iparms:[{av:'GRIDLEVEL_IMPORTES2_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES2_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRIDLEVEL_IMPORTES2_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES2_LASTPAGE","{handler:'subgridlevel_importes2_lastpage',iparms:[{av:'GRIDLEVEL_IMPORTES2_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES2_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'AV32CliConveImpVig',fld:'vCLICONVEIMPVIG',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1587CliConveImpVig',fld:'CLICONVEIMPVIG',pic:''},{av:'cmbCliConveImpTipo'},{av:'A1588CliConveImpTipo',fld:'CLICONVEIMPTIPO',pic:''},{av:'A1589CliConveImporte',fld:'CLICONVEIMPORTE',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("GRIDLEVEL_IMPORTES2_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES_FIRSTPAGE","{handler:'subgridlevel_importes_firstpage',iparms:[{av:'GRIDLEVEL_IMPORTES_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_IMPORTES_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES_PREVPAGE","{handler:'subgridlevel_importes_previouspage',iparms:[{av:'GRIDLEVEL_IMPORTES_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_IMPORTES_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES_NEXTPAGE","{handler:'subgridlevel_importes_nextpage',iparms:[{av:'GRIDLEVEL_IMPORTES_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_IMPORTES_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_IMPORTES_LASTPAGE","{handler:'subgridlevel_importes_lastpage',iparms:[{av:'GRIDLEVEL_IMPORTES_nFirstRecordOnPage'},{av:'GRIDLEVEL_IMPORTES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true}]");
      setEventMetadata("GRIDLEVEL_IMPORTES_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VALORES_FIRSTPAGE","{handler:'subgridlevel_valores_firstpage',iparms:[{av:'GRIDLEVEL_VALORES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VALORES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("GRIDLEVEL_VALORES_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VALORES_PREVPAGE","{handler:'subgridlevel_valores_previouspage',iparms:[{av:'GRIDLEVEL_VALORES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VALORES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("GRIDLEVEL_VALORES_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VALORES_NEXTPAGE","{handler:'subgridlevel_valores_nextpage',iparms:[{av:'GRIDLEVEL_VALORES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VALORES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("GRIDLEVEL_VALORES_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VALORES_LASTPAGE","{handler:'subgridlevel_valores_lastpage',iparms:[{av:'GRIDLEVEL_VALORES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VALORES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A8CatCodigo',fld:'CATCODIGO',pic:''}]");
      setEventMetadata("GRIDLEVEL_VALORES_LASTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_FIRSTPAGE","{handler:'subgridlevel_vacaciones_firstpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_PREVPAGE","{handler:'subgridlevel_vacaciones_previouspage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_NEXTPAGE","{handler:'subgridlevel_vacaciones_nextpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRIDLEVEL_VACACIONES_LASTPAGE","{handler:'subgridlevel_vacaciones_lastpage',iparms:[{av:'GRIDLEVEL_VACACIONES_nFirstRecordOnPage'},{av:'GRIDLEVEL_VACACIONES_nEOF'},{av:'subGridlevel_vacaciones_Rows',ctrl:'GRIDLEVEL_VACACIONES',prop:'Rows'},{av:'subGridlevel_valores_Rows',ctrl:'GRIDLEVEL_VALORES',prop:'Rows'},{av:'subGridlevel_importes_Rows',ctrl:'GRIDLEVEL_IMPORTES',prop:'Rows'},{av:'subGridlevel_importes2_Rows',ctrl:'GRIDLEVEL_IMPORTES2',prop:'Rows'},{av:'subGridlevel_importesdeadicional_Rows',ctrl:'GRIDLEVEL_IMPORTESDEADICIONAL',prop:'Rows'},{av:'subGridlevel_opciones_Rows',ctrl:'GRIDLEVEL_OPCIONES',prop:'Rows'},{av:'subGridlevel_estadoscancelan_Rows',ctrl:'GRIDLEVEL_ESTADOSCANCELAN',prop:'Rows'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9',hsh:true},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:'',hsh:true},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("GRIDLEVEL_VACACIONES_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVEVIG","{handler:'valid_Cliconvevig',iparms:[]");
      setEventMetadata("VALID_CLICONVEVIG",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Convevacrelsec',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveguaredadmax',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Escadicional',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Catfrecact',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Cliconveimporte',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALIDV_CLICONVEIMPTIPO","{handler:'validv_Cliconveimptipo',iparms:[]");
      setEventMetadata("VALIDV_CLICONVEIMPTIPO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Cliconveimporte',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALID_CONVEADICOD","{handler:'valid_Conveadicod',iparms:[]");
      setEventMetadata("VALID_CONVEADICOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveaditipo',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveadiimporte',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveadiopcali',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Conveadisitcancela',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOA1565CliConvenio = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      A8CatCodigo = "" ;
      AV32CliConveImpVig = GXutil.nullDate() ;
      A1587CliConveImpVig = GXutil.nullDate() ;
      A1588CliConveImpTipo = "" ;
      A1589CliConveImporte = DecimalUtil.ZERO ;
      A996ConveAdicod = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Gridlevel_estadoscancelan_empowerer_Gridinternalname = "" ;
      Gridlevel_opciones_empowerer_Gridinternalname = "" ;
      Gridlevel_importesdeadicional_empowerer_Gridinternalname = "" ;
      Gridlevel_importes2_empowerer_Gridinternalname = "" ;
      Gridlevel_importes_empowerer_Gridinternalname = "" ;
      Gridlevel_valores_empowerer_Gridinternalname = "" ;
      Gridlevel_vacaciones_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucGridlevel_estadoscancelan_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_opciones_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_importesdeadicional_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_importes2_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_importes_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_valores_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridlevel_vacaciones_empowerer = new com.genexus.webpanels.GXUserControl();
      Freestylelevel_datosContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      Gridlevel_vacacionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      Freestylelevel_categoriasContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_importesContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_importes2Container = new com.genexus.webpanels.GXWebGrid(context);
      Freestylelevel_adicionalesContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_importesdeadicionalContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_opcionesContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_estadoscancelanContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      ucDvpanel_unnamedtable20 = new com.genexus.webpanels.GXUserControl();
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      A123CatDescrip = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      AV35CliConveImpTipo = "" ;
      AV36CliConveImporte = DecimalUtil.ZERO ;
      A997ConveAdiDescri = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A1019ConveAdiInfo = "" ;
      A1803ConveAdiTipo = "" ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A1824ConveAdiSitCancela = "" ;
      AV41Pgmname = "" ;
      scmdbuf = "" ;
      H00LV2_A3CliCod = new int[1] ;
      H00LV2_A1564CliPaiConve = new short[1] ;
      H00LV2_A1565CliConvenio = new String[] {""} ;
      H00LV2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV2_A1567CliConvenioDescrip = new String[] {""} ;
      H00LV2_A1628ConveGuarEdadMax = new byte[1] ;
      H00LV2_n1628ConveGuarEdadMax = new boolean[] {false} ;
      H00LV2_A1627ConveGuarEdadMin = new byte[1] ;
      H00LV2_n1627ConveGuarEdadMin = new boolean[] {false} ;
      H00LV2_A1046ConveMinMesesVac = new byte[1] ;
      H00LV2_A1043ConveInterDiasJor = new short[1] ;
      H00LV2_A1401ConveFondoCese = new boolean[] {false} ;
      H00LV2_A1270ConveDiaHsPExt = new String[] {""} ;
      H00LV2_n1270ConveDiaHsPExt = new boolean[] {false} ;
      H00LV2_A1269ConveMesHsPExt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV3_A3CliCod = new int[1] ;
      H00LV3_A1564CliPaiConve = new short[1] ;
      H00LV3_A1565CliConvenio = new String[] {""} ;
      H00LV3_A996ConveAdicod = new String[] {""} ;
      H00LV3_A1803ConveAdiTipo = new String[] {""} ;
      H00LV3_A1019ConveAdiInfo = new String[] {""} ;
      H00LV3_n1019ConveAdiInfo = new boolean[] {false} ;
      H00LV3_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV3_A997ConveAdiDescri = new String[] {""} ;
      H00LV4_A3CliCod = new int[1] ;
      H00LV4_A1564CliPaiConve = new short[1] ;
      H00LV4_A1565CliConvenio = new String[] {""} ;
      H00LV4_A996ConveAdicod = new String[] {""} ;
      H00LV4_A1824ConveAdiSitCancela = new String[] {""} ;
      H00LV5_A3CliCod = new int[1] ;
      H00LV5_A1564CliPaiConve = new short[1] ;
      H00LV5_A1565CliConvenio = new String[] {""} ;
      H00LV5_A996ConveAdicod = new String[] {""} ;
      H00LV5_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV5_A1012ConveAdiOpcDes = new String[] {""} ;
      H00LV5_A1021ConveAdiOpcFor = new String[] {""} ;
      H00LV5_A1011ConveAdiOpcCod = new short[1] ;
      AV31ConveAdiVig = GXutil.nullDate() ;
      H00LV6_A3CliCod = new int[1] ;
      H00LV6_A1564CliPaiConve = new short[1] ;
      H00LV6_A1565CliConvenio = new String[] {""} ;
      H00LV6_A996ConveAdicod = new String[] {""} ;
      H00LV6_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV6_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV7_A3CliCod = new int[1] ;
      H00LV7_A1564CliPaiConve = new short[1] ;
      H00LV7_A1565CliConvenio = new String[] {""} ;
      H00LV7_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV7_A1588CliConveImpTipo = new String[] {""} ;
      H00LV7_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV8_A3CliCod = new int[1] ;
      H00LV8_A1564CliPaiConve = new short[1] ;
      H00LV8_A1565CliConvenio = new String[] {""} ;
      H00LV8_A8CatCodigo = new String[] {""} ;
      H00LV8_A1914CatFrecAct = new byte[1] ;
      H00LV8_A1838CatClase = new byte[1] ;
      H00LV8_A123CatDescrip = new String[] {""} ;
      AV33CatVigencia = GXutil.nullDate() ;
      H00LV9_A3CliCod = new int[1] ;
      H00LV9_A1564CliPaiConve = new short[1] ;
      H00LV9_A1565CliConvenio = new String[] {""} ;
      H00LV9_A8CatCodigo = new String[] {""} ;
      H00LV9_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV9_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00LV9_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV10_A3CliCod = new int[1] ;
      H00LV10_A1564CliPaiConve = new short[1] ;
      H00LV10_A1565CliConvenio = new String[] {""} ;
      H00LV10_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV10_A1902ConveVacRelSec = new int[1] ;
      H00LV10_A1763CliConveVacDias = new byte[1] ;
      H00LV10_A1762CliConveVacHasAnt = new byte[1] ;
      H00LV10_A1761CliConveVacDesAnt = new byte[1] ;
      H00LV11_AGRIDLEVEL_ESTADOSCANCELAN_nRecordCount = new long[1] ;
      H00LV12_AGRIDLEVEL_OPCIONES_nRecordCount = new long[1] ;
      H00LV13_AGRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount = new long[1] ;
      H00LV14_AGRIDLEVEL_IMPORTES_nRecordCount = new long[1] ;
      H00LV15_AGRIDLEVEL_VALORES_nRecordCount = new long[1] ;
      H00LV16_AGRIDLEVEL_VACACIONES_nRecordCount = new long[1] ;
      H00LV17_A1567CliConvenioDescrip = new String[] {""} ;
      A1567CliConvenioDescrip = "" ;
      AV37ConveMesHsPExt = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV34CliConveVig = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      GXv_date3 = new java.util.Date[1] ;
      GXv_date4 = new java.util.Date[1] ;
      GXv_date5 = new java.util.Date[1] ;
      Freestylelevel_datosRow = new com.genexus.webpanels.GXWebRow();
      Freestylelevel_adicionalesRow = new com.genexus.webpanels.GXWebRow();
      Gridlevel_estadoscancelanRow = new com.genexus.webpanels.GXWebRow();
      Gridlevel_opcionesRow = new com.genexus.webpanels.GXWebRow();
      Gridlevel_importesdeadicionalRow = new com.genexus.webpanels.GXWebRow();
      H00LV18_A3CliCod = new int[1] ;
      H00LV18_A1564CliPaiConve = new short[1] ;
      H00LV18_A1565CliConvenio = new String[] {""} ;
      H00LV18_A1588CliConveImpTipo = new String[] {""} ;
      H00LV18_A1587CliConveImpVig = new java.util.Date[] {GXutil.nullDate()} ;
      H00LV18_A1589CliConveImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      Gridlevel_importes2Row = new com.genexus.webpanels.GXWebRow();
      Gridlevel_importesRow = new com.genexus.webpanels.GXWebRow();
      Freestylelevel_categoriasRow = new com.genexus.webpanels.GXWebRow();
      Gridlevel_valoresRow = new com.genexus.webpanels.GXWebRow();
      Gridlevel_vacacionesRow = new com.genexus.webpanels.GXWebRow();
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblTabgeneral_title_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTablevel_categorias_title_Jsonclick = "" ;
      lblTablevel_importes_title_Jsonclick = "" ;
      lblTablevel_adicionales_title_Jsonclick = "" ;
      TempTags = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridlevel_vacaciones_Linesclass = "" ;
      ROClassString = "" ;
      subFreestylelevel_datos_Linesclass = "" ;
      lblTextblockconveinterdiasjor_Jsonclick = "" ;
      lblTextblockconveminmesesvac_Jsonclick = "" ;
      lblTextblockconveguaredadmin_Jsonclick = "" ;
      lblTextblockconveguaredadmax_Jsonclick = "" ;
      subGridlevel_valores_Linesclass = "" ;
      subFreestylelevel_categorias_Linesclass = "" ;
      lblTextblockcatcodigo_Jsonclick = "" ;
      lblTextblockcatdescrip_Jsonclick = "" ;
      subGridlevel_importes_Linesclass = "" ;
      subGridlevel_importes2_Linesclass = "" ;
      subGridlevel_importesdeadicional_Linesclass = "" ;
      subGridlevel_opciones_Linesclass = "" ;
      subGridlevel_estadoscancelan_Linesclass = "" ;
      subFreestylelevel_adicionales_Linesclass = "" ;
      lblTextblockconveadiinfo_Jsonclick = "" ;
      subFreestylelevel_datos_Header = "" ;
      Freestylelevel_datosColumn = new com.genexus.webpanels.GXWebColumn();
      subFreestylelevel_categorias_Header = "" ;
      Freestylelevel_categoriasColumn = new com.genexus.webpanels.GXWebColumn();
      subFreestylelevel_adicionales_Header = "" ;
      Freestylelevel_adicionalesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_importes2Column = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_importesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_vacacionesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_valoresColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_importesdeadicionalColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_opcionesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_estadoscancelanColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniotabs__default(),
         new Object[] {
             new Object[] {
            H00LV2_A3CliCod, H00LV2_A1564CliPaiConve, H00LV2_A1565CliConvenio, H00LV2_A1575CliConveVig, H00LV2_A1567CliConvenioDescrip, H00LV2_A1628ConveGuarEdadMax, H00LV2_n1628ConveGuarEdadMax, H00LV2_A1627ConveGuarEdadMin, H00LV2_n1627ConveGuarEdadMin, H00LV2_A1046ConveMinMesesVac,
            H00LV2_A1043ConveInterDiasJor, H00LV2_A1401ConveFondoCese, H00LV2_A1270ConveDiaHsPExt, H00LV2_n1270ConveDiaHsPExt, H00LV2_A1269ConveMesHsPExt
            }
            , new Object[] {
            H00LV3_A3CliCod, H00LV3_A1564CliPaiConve, H00LV3_A1565CliConvenio, H00LV3_A996ConveAdicod, H00LV3_A1803ConveAdiTipo, H00LV3_A1019ConveAdiInfo, H00LV3_n1019ConveAdiInfo, H00LV3_A998ConveAdiAli, H00LV3_A997ConveAdiDescri
            }
            , new Object[] {
            H00LV4_A3CliCod, H00LV4_A1564CliPaiConve, H00LV4_A1565CliConvenio, H00LV4_A996ConveAdicod, H00LV4_A1824ConveAdiSitCancela
            }
            , new Object[] {
            H00LV5_A3CliCod, H00LV5_A1564CliPaiConve, H00LV5_A1565CliConvenio, H00LV5_A996ConveAdicod, H00LV5_A1013ConveAdiOpcAli, H00LV5_A1012ConveAdiOpcDes, H00LV5_A1021ConveAdiOpcFor, H00LV5_A1011ConveAdiOpcCod
            }
            , new Object[] {
            H00LV6_A3CliCod, H00LV6_A1564CliPaiConve, H00LV6_A1565CliConvenio, H00LV6_A996ConveAdicod, H00LV6_A1000ConveAdiImporte, H00LV6_A999ConveAdiVig
            }
            , new Object[] {
            H00LV7_A3CliCod, H00LV7_A1564CliPaiConve, H00LV7_A1565CliConvenio, H00LV7_A1589CliConveImporte, H00LV7_A1588CliConveImpTipo, H00LV7_A1587CliConveImpVig
            }
            , new Object[] {
            H00LV8_A3CliCod, H00LV8_A1564CliPaiConve, H00LV8_A1565CliConvenio, H00LV8_A8CatCodigo, H00LV8_A1914CatFrecAct, H00LV8_A1838CatClase, H00LV8_A123CatDescrip
            }
            , new Object[] {
            H00LV9_A3CliCod, H00LV9_A1564CliPaiConve, H00LV9_A1565CliConvenio, H00LV9_A8CatCodigo, H00LV9_A1893EscAdicional, H00LV9_A1892EscBasico, H00LV9_A907CatVigencia
            }
            , new Object[] {
            H00LV10_A3CliCod, H00LV10_A1564CliPaiConve, H00LV10_A1565CliConvenio, H00LV10_A1575CliConveVig, H00LV10_A1902ConveVacRelSec, H00LV10_A1763CliConveVacDias, H00LV10_A1762CliConveVacHasAnt, H00LV10_A1761CliConveVacDesAnt
            }
            , new Object[] {
            H00LV11_AGRIDLEVEL_ESTADOSCANCELAN_nRecordCount
            }
            , new Object[] {
            H00LV12_AGRIDLEVEL_OPCIONES_nRecordCount
            }
            , new Object[] {
            H00LV13_AGRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount
            }
            , new Object[] {
            H00LV14_AGRIDLEVEL_IMPORTES_nRecordCount
            }
            , new Object[] {
            H00LV15_AGRIDLEVEL_VALORES_nRecordCount
            }
            , new Object[] {
            H00LV16_AGRIDLEVEL_VACACIONES_nRecordCount
            }
            , new Object[] {
            H00LV17_A1567CliConvenioDescrip
            }
            , new Object[] {
            H00LV18_A3CliCod, H00LV18_A1564CliPaiConve, H00LV18_A1565CliConvenio, H00LV18_A1588CliConveImpTipo, H00LV18_A1587CliConveImpVig, H00LV18_A1589CliConveImporte
            }
         }
      );
      AV41Pgmname = "ConvenioTabs" ;
      /* GeneXus formulas. */
      AV41Pgmname = "ConvenioTabs" ;
      Gx_err = (short)(0) ;
      edtavCliconveimpvig_Enabled = 0 ;
      cmbavCliconveimptipo.setEnabled( 0 );
      edtavCliconveimporte_Enabled = 0 ;
   }

   private byte GRIDLEVEL_IMPORTES_nEOF ;
   private byte GRIDLEVEL_IMPORTES2_nEOF ;
   private byte GRIDLEVEL_VALORES_nEOF ;
   private byte GRIDLEVEL_IMPORTESDEADICIONAL_nEOF ;
   private byte GRIDLEVEL_OPCIONES_nEOF ;
   private byte GRIDLEVEL_ESTADOSCANCELAN_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte GRIDLEVEL_VACACIONES_nEOF ;
   private byte A1046ConveMinMesesVac ;
   private byte A1627ConveGuarEdadMin ;
   private byte A1628ConveGuarEdadMax ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private byte nDonePA ;
   private byte subFreestylelevel_datos_Backcolorstyle ;
   private byte subFreestylelevel_adicionales_Backcolorstyle ;
   private byte subGridlevel_estadoscancelan_Backcolorstyle ;
   private byte subGridlevel_opciones_Backcolorstyle ;
   private byte subGridlevel_importesdeadicional_Backcolorstyle ;
   private byte subGridlevel_importes2_Backcolorstyle ;
   private byte subGridlevel_importes_Backcolorstyle ;
   private byte subFreestylelevel_categorias_Backcolorstyle ;
   private byte subGridlevel_valores_Backcolorstyle ;
   private byte subGridlevel_vacaciones_Backcolorstyle ;
   private byte subGridlevel_vacaciones_Backstyle ;
   private byte subFreestylelevel_datos_Backstyle ;
   private byte subGridlevel_valores_Backstyle ;
   private byte subFreestylelevel_categorias_Backstyle ;
   private byte subGridlevel_importes_Backstyle ;
   private byte subGridlevel_importes2_Backstyle ;
   private byte subGridlevel_importesdeadicional_Backstyle ;
   private byte subGridlevel_opciones_Backstyle ;
   private byte subGridlevel_estadoscancelan_Backstyle ;
   private byte subFreestylelevel_adicionales_Backstyle ;
   private byte subFreestylelevel_datos_Allowselection ;
   private byte subFreestylelevel_datos_Allowhovering ;
   private byte subFreestylelevel_datos_Allowcollapsing ;
   private byte subFreestylelevel_datos_Collapsed ;
   private byte subFreestylelevel_categorias_Allowselection ;
   private byte subFreestylelevel_categorias_Allowhovering ;
   private byte subFreestylelevel_categorias_Allowcollapsing ;
   private byte subFreestylelevel_categorias_Collapsed ;
   private byte subFreestylelevel_adicionales_Allowselection ;
   private byte subFreestylelevel_adicionales_Allowhovering ;
   private byte subFreestylelevel_adicionales_Allowcollapsing ;
   private byte subFreestylelevel_adicionales_Collapsed ;
   private byte subGridlevel_importes2_Titlebackstyle ;
   private byte subGridlevel_importes2_Allowselection ;
   private byte subGridlevel_importes2_Allowhovering ;
   private byte subGridlevel_importes2_Allowcollapsing ;
   private byte subGridlevel_importes2_Collapsed ;
   private byte subGridlevel_importes_Titlebackstyle ;
   private byte subGridlevel_importes_Allowselection ;
   private byte subGridlevel_importes_Allowhovering ;
   private byte subGridlevel_importes_Allowcollapsing ;
   private byte subGridlevel_importes_Collapsed ;
   private byte subGridlevel_vacaciones_Titlebackstyle ;
   private byte subGridlevel_vacaciones_Allowselection ;
   private byte subGridlevel_vacaciones_Allowhovering ;
   private byte subGridlevel_vacaciones_Allowcollapsing ;
   private byte subGridlevel_vacaciones_Collapsed ;
   private byte subGridlevel_valores_Titlebackstyle ;
   private byte subGridlevel_valores_Allowselection ;
   private byte subGridlevel_valores_Allowhovering ;
   private byte subGridlevel_valores_Allowcollapsing ;
   private byte subGridlevel_valores_Collapsed ;
   private byte subGridlevel_importesdeadicional_Titlebackstyle ;
   private byte subGridlevel_importesdeadicional_Allowselection ;
   private byte subGridlevel_importesdeadicional_Allowhovering ;
   private byte subGridlevel_importesdeadicional_Allowcollapsing ;
   private byte subGridlevel_importesdeadicional_Collapsed ;
   private byte subGridlevel_opciones_Titlebackstyle ;
   private byte subGridlevel_opciones_Allowselection ;
   private byte subGridlevel_opciones_Allowhovering ;
   private byte subGridlevel_opciones_Allowcollapsing ;
   private byte subGridlevel_opciones_Collapsed ;
   private byte subGridlevel_estadoscancelan_Titlebackstyle ;
   private byte subGridlevel_estadoscancelan_Allowselection ;
   private byte subGridlevel_estadoscancelan_Allowhovering ;
   private byte subGridlevel_estadoscancelan_Allowcollapsing ;
   private byte subGridlevel_estadoscancelan_Collapsed ;
   private byte FREESTYLELEVEL_DATOS_nEOF ;
   private byte FREESTYLELEVEL_ADICIONALES_nEOF ;
   private byte FREESTYLELEVEL_CATEGORIAS_nEOF ;
   private short wcpOA1564CliPaiConve ;
   private short nRcdExists_12 ;
   private short nIsMod_12 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short nRcdExists_11 ;
   private short nIsMod_11 ;
   private short nRcdExists_9 ;
   private short nIsMod_9 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short A1564CliPaiConve ;
   private short wbEnd ;
   private short wbStart ;
   private short A1043ConveInterDiasJor ;
   private short A1011ConveAdiOpcCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int nRC_GXsfl_93 ;
   private int nGXsfl_93_idx=1 ;
   private int edtCliConveVig_Visible ;
   private int nRC_GXsfl_36 ;
   private int nRC_GXsfl_130 ;
   private int nRC_GXsfl_194 ;
   private int nRC_GXsfl_204 ;
   private int nRC_GXsfl_218 ;
   private int nRC_GXsfl_166 ;
   private int nGXsfl_166_idx=1 ;
   private int nGXsfl_194_idx=1 ;
   private int nRC_GXsfl_265 ;
   private int nGXsfl_265_idx=1 ;
   private int nRC_GXsfl_277 ;
   private int nGXsfl_277_idx=1 ;
   private int nRC_GXsfl_291 ;
   private int nGXsfl_291_idx=1 ;
   private int subGridlevel_vacaciones_Rows ;
   private int subGridlevel_valores_Rows ;
   private int subGridlevel_importes_Rows ;
   private int subGridlevel_importes2_Rows ;
   private int subGridlevel_importesdeadicional_Rows ;
   private int subGridlevel_opciones_Rows ;
   private int subGridlevel_estadoscancelan_Rows ;
   private int A3CliCod ;
   private int nGXsfl_36_idx=1 ;
   private int nGXsfl_130_idx=1 ;
   private int edtCatFrecAct_Visible ;
   private int nGXsfl_204_idx=1 ;
   private int nGXsfl_218_idx=1 ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtCliCod_Visible ;
   private int edtCliPaiConve_Visible ;
   private int A1902ConveVacRelSec ;
   private int subFreestylelevel_datos_Islastpage ;
   private int subFreestylelevel_adicionales_Islastpage ;
   private int subGridlevel_estadoscancelan_Islastpage ;
   private int subGridlevel_opciones_Islastpage ;
   private int subGridlevel_importesdeadicional_Islastpage ;
   private int subGridlevel_importes2_Islastpage ;
   private int subGridlevel_importes_Islastpage ;
   private int subFreestylelevel_categorias_Islastpage ;
   private int subGridlevel_valores_Islastpage ;
   private int subGridlevel_vacaciones_Islastpage ;
   private int edtavCliconveimpvig_Enabled ;
   private int edtavCliconveimporte_Enabled ;
   private int GXPagingFrom4 ;
   private int GXPagingTo4 ;
   private int GXPagingFrom5 ;
   private int GXPagingTo5 ;
   private int GXPagingFrom6 ;
   private int GXPagingTo6 ;
   private int GXPagingFrom9 ;
   private int GXPagingTo9 ;
   private int GXPagingFrom11 ;
   private int GXPagingTo11 ;
   private int GXPagingFrom12 ;
   private int GXPagingTo12 ;
   private int GRIDLEVEL_IMPORTES2_IsPaging ;
   private int edtCliConvenio_Enabled ;
   private int edtCliConvenioDescrip_Enabled ;
   private int idxLst ;
   private int subGridlevel_vacaciones_Backcolor ;
   private int subGridlevel_vacaciones_Allbackcolor ;
   private int subFreestylelevel_datos_Backcolor ;
   private int subFreestylelevel_datos_Allbackcolor ;
   private int subGridlevel_valores_Backcolor ;
   private int subGridlevel_valores_Allbackcolor ;
   private int subFreestylelevel_categorias_Backcolor ;
   private int subFreestylelevel_categorias_Allbackcolor ;
   private int subGridlevel_importes_Backcolor ;
   private int subGridlevel_importes_Allbackcolor ;
   private int subGridlevel_importes2_Backcolor ;
   private int subGridlevel_importes2_Allbackcolor ;
   private int subGridlevel_importesdeadicional_Backcolor ;
   private int subGridlevel_importesdeadicional_Allbackcolor ;
   private int subGridlevel_opciones_Backcolor ;
   private int subGridlevel_opciones_Allbackcolor ;
   private int subGridlevel_estadoscancelan_Backcolor ;
   private int subGridlevel_estadoscancelan_Allbackcolor ;
   private int subFreestylelevel_adicionales_Backcolor ;
   private int subFreestylelevel_adicionales_Allbackcolor ;
   private int subFreestylelevel_datos_Selectedindex ;
   private int subFreestylelevel_datos_Selectioncolor ;
   private int subFreestylelevel_datos_Hoveringcolor ;
   private int subFreestylelevel_categorias_Selectedindex ;
   private int subFreestylelevel_categorias_Selectioncolor ;
   private int subFreestylelevel_categorias_Hoveringcolor ;
   private int subFreestylelevel_adicionales_Selectedindex ;
   private int subFreestylelevel_adicionales_Selectioncolor ;
   private int subFreestylelevel_adicionales_Hoveringcolor ;
   private int subGridlevel_importes2_Titlebackcolor ;
   private int subGridlevel_importes2_Selectedindex ;
   private int subGridlevel_importes2_Selectioncolor ;
   private int subGridlevel_importes2_Hoveringcolor ;
   private int subGridlevel_importes_Titlebackcolor ;
   private int subGridlevel_importes_Selectedindex ;
   private int subGridlevel_importes_Selectioncolor ;
   private int subGridlevel_importes_Hoveringcolor ;
   private int subGridlevel_vacaciones_Titlebackcolor ;
   private int subGridlevel_vacaciones_Selectedindex ;
   private int subGridlevel_vacaciones_Selectioncolor ;
   private int subGridlevel_vacaciones_Hoveringcolor ;
   private int subGridlevel_valores_Titlebackcolor ;
   private int subGridlevel_valores_Selectedindex ;
   private int subGridlevel_valores_Selectioncolor ;
   private int subGridlevel_valores_Hoveringcolor ;
   private int subGridlevel_importesdeadicional_Titlebackcolor ;
   private int subGridlevel_importesdeadicional_Selectedindex ;
   private int subGridlevel_importesdeadicional_Selectioncolor ;
   private int subGridlevel_importesdeadicional_Hoveringcolor ;
   private int subGridlevel_opciones_Titlebackcolor ;
   private int subGridlevel_opciones_Selectedindex ;
   private int subGridlevel_opciones_Selectioncolor ;
   private int subGridlevel_opciones_Hoveringcolor ;
   private int subGridlevel_estadoscancelan_Titlebackcolor ;
   private int subGridlevel_estadoscancelan_Selectedindex ;
   private int subGridlevel_estadoscancelan_Selectioncolor ;
   private int subGridlevel_estadoscancelan_Hoveringcolor ;
   private long GRIDLEVEL_IMPORTES_nFirstRecordOnPage ;
   private long GRIDLEVEL_IMPORTES2_nFirstRecordOnPage ;
   private long GRIDLEVEL_VALORES_nFirstRecordOnPage ;
   private long GRIDLEVEL_IMPORTESDEADICIONAL_nFirstRecordOnPage ;
   private long GRIDLEVEL_OPCIONES_nFirstRecordOnPage ;
   private long GRIDLEVEL_ESTADOSCANCELAN_nFirstRecordOnPage ;
   private long GRIDLEVEL_VACACIONES_nFirstRecordOnPage ;
   private long GRIDLEVEL_VACACIONES_nCurrentRecord ;
   private long FREESTYLELEVEL_DATOS_nCurrentRecord ;
   private long GRIDLEVEL_VALORES_nCurrentRecord ;
   private long FREESTYLELEVEL_CATEGORIAS_nCurrentRecord ;
   private long GRIDLEVEL_IMPORTES_nCurrentRecord ;
   private long GRIDLEVEL_IMPORTES2_nCurrentRecord ;
   private long GRIDLEVEL_IMPORTESDEADICIONAL_nCurrentRecord ;
   private long GRIDLEVEL_OPCIONES_nCurrentRecord ;
   private long GRIDLEVEL_ESTADOSCANCELAN_nCurrentRecord ;
   private long FREESTYLELEVEL_ADICIONALES_nCurrentRecord ;
   private long FREESTYLELEVEL_DATOS_nFirstRecordOnPage ;
   private long FREESTYLELEVEL_ADICIONALES_nFirstRecordOnPage ;
   private long FREESTYLELEVEL_CATEGORIAS_nFirstRecordOnPage ;
   private long GRIDLEVEL_ESTADOSCANCELAN_nRecordCount ;
   private long GRIDLEVEL_OPCIONES_nRecordCount ;
   private long GRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount ;
   private long GRIDLEVEL_IMPORTES_nRecordCount ;
   private long GRIDLEVEL_VALORES_nRecordCount ;
   private long GRIDLEVEL_VACACIONES_nRecordCount ;
   private java.math.BigDecimal A1589CliConveImporte ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal AV36CliConveImporte ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private java.math.BigDecimal AV37ConveMesHsPExt ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String wcpOA1565CliConvenio ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1565CliConvenio ;
   private String sGXsfl_93_idx="0001" ;
   private String sGXsfl_36_idx="0001" ;
   private String edtCliConveVig_Internalname ;
   private String sGXsfl_166_idx="0001" ;
   private String A8CatCodigo ;
   private String sGXsfl_130_idx="0001" ;
   private String edtCatFrecAct_Internalname ;
   private String sGXsfl_194_idx="0001" ;
   private String sGXsfl_204_idx="0001" ;
   private String A1588CliConveImpTipo ;
   private String sGXsfl_265_idx="0001" ;
   private String A996ConveAdicod ;
   private String sGXsfl_277_idx="0001" ;
   private String sGXsfl_291_idx="0001" ;
   private String sGXsfl_218_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gxuitabspanel_tabs_Class ;
   private String Gridlevel_estadoscancelan_empowerer_Gridinternalname ;
   private String Gridlevel_estadoscancelan_empowerer_Infinitescrolling ;
   private String Gridlevel_opciones_empowerer_Gridinternalname ;
   private String Gridlevel_importesdeadicional_empowerer_Gridinternalname ;
   private String Gridlevel_importes2_empowerer_Gridinternalname ;
   private String Gridlevel_importes_empowerer_Gridinternalname ;
   private String Gridlevel_valores_empowerer_Gridinternalname ;
   private String Gridlevel_vacaciones_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String Gridlevel_estadoscancelan_empowerer_Internalname ;
   private String Gridlevel_opciones_empowerer_Internalname ;
   private String Gridlevel_importesdeadicional_empowerer_Internalname ;
   private String Gridlevel_importes2_empowerer_Internalname ;
   private String Gridlevel_importes_empowerer_Internalname ;
   private String Gridlevel_valores_empowerer_Internalname ;
   private String Gridlevel_vacaciones_empowerer_Internalname ;
   private String sStyleString ;
   private String subFreestylelevel_datos_Internalname ;
   private String subGridlevel_vacaciones_Internalname ;
   private String subFreestylelevel_categorias_Internalname ;
   private String subGridlevel_valores_Internalname ;
   private String subGridlevel_importes_Internalname ;
   private String subGridlevel_importes2_Internalname ;
   private String subFreestylelevel_adicionales_Internalname ;
   private String subGridlevel_importesdeadicional_Internalname ;
   private String subGridlevel_opciones_Internalname ;
   private String subGridlevel_estadoscancelan_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXCCtl ;
   private String Dvpanel_unnamedtable20_Width ;
   private String Dvpanel_unnamedtable20_Internalname ;
   private String Dvpanel_unnamedtable20_Cls ;
   private String Dvpanel_unnamedtable20_Title ;
   private String Dvpanel_unnamedtable20_Iconposition ;
   private String edtConveMesHsPExt_Internalname ;
   private String A1270ConveDiaHsPExt ;
   private String edtConveInterDiasJor_Internalname ;
   private String edtConveMinMesesVac_Internalname ;
   private String edtConveGuarEdadMin_Internalname ;
   private String edtConveGuarEdadMax_Internalname ;
   private String edtCliConveVacDesAnt_Internalname ;
   private String edtCliConveVacHasAnt_Internalname ;
   private String edtCliConveVacDias_Internalname ;
   private String edtConveVacRelSec_Internalname ;
   private String edtCatCodigo_Internalname ;
   private String edtCatDescrip_Internalname ;
   private String edtCatVigencia_Internalname ;
   private String edtEscBasico_Internalname ;
   private String edtEscAdicional_Internalname ;
   private String edtCliConveImpVig_Internalname ;
   private String edtCliConveImporte_Internalname ;
   private String edtavCliconveimpvig_Internalname ;
   private String AV35CliConveImpTipo ;
   private String edtavCliconveimporte_Internalname ;
   private String edtConveAdicod_Internalname ;
   private String edtConveAdiDescri_Internalname ;
   private String edtConveAdiAli_Internalname ;
   private String edtConveAdiInfo_Internalname ;
   private String A1803ConveAdiTipo ;
   private String edtConveAdiVig_Internalname ;
   private String edtConveAdiImporte_Internalname ;
   private String edtConveAdiOpcCod_Internalname ;
   private String A1021ConveAdiOpcFor ;
   private String edtConveAdiOpcFor_Internalname ;
   private String edtConveAdiOpcDes_Internalname ;
   private String edtConveAdiOpcAli_Internalname ;
   private String A1824ConveAdiSitCancela ;
   private String edtConveAdiSitCancela_Internalname ;
   private String AV41Pgmname ;
   private String scmdbuf ;
   private String edtCliConvenioDescrip_Internalname ;
   private String divCliconvevig_cell_Class ;
   private String divCliconvevig_cell_Internalname ;
   private String divConvediahspext_cell_Class ;
   private String divConvediahspext_cell_Internalname ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblTabgeneral_title_Internalname ;
   private String lblTabgeneral_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTableintermediatelevel_datos_Internalname ;
   private String lblTablevel_categorias_title_Internalname ;
   private String lblTablevel_categorias_title_Jsonclick ;
   private String divTabtablelevel_categorias_Internalname ;
   private String divTableintermediatelevel_categorias_Internalname ;
   private String lblTablevel_importes_title_Internalname ;
   private String lblTablevel_importes_title_Jsonclick ;
   private String divTabtablelevel_importes_Internalname ;
   private String divTableleaflevel_importes_Internalname ;
   private String grpUnnamedgroup10_Internalname ;
   private String grpUnnamedgroup12_Internalname ;
   private String lblTablevel_adicionales_title_Internalname ;
   private String lblTablevel_adicionales_title_Jsonclick ;
   private String divTabtablelevel_adicionales_Internalname ;
   private String divTableintermediatelevel_adicionales_Internalname ;
   private String TempTags ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String tblUnnamedtable11_Internalname ;
   private String tblUnnamedtable9_Internalname ;
   private String sGXsfl_93_fel_idx="0001" ;
   private String subGridlevel_vacaciones_Class ;
   private String subGridlevel_vacaciones_Linesclass ;
   private String ROClassString ;
   private String edtCliConveVacDesAnt_Jsonclick ;
   private String edtCliConveVacHasAnt_Jsonclick ;
   private String edtCliConveVacDias_Jsonclick ;
   private String edtConveVacRelSec_Jsonclick ;
   private String lblTextblockconveinterdiasjor_Internalname ;
   private String lblTextblockconveminmesesvac_Internalname ;
   private String lblTextblockconveguaredadmin_Internalname ;
   private String lblTextblockconveguaredadmax_Internalname ;
   private String sGXsfl_36_fel_idx="0001" ;
   private String subFreestylelevel_datos_Class ;
   private String subFreestylelevel_datos_Linesclass ;
   private String tblUnnamedtablefsfreestylelevel_datos_Internalname ;
   private String divTableintermediateinslevel_datos_Internalname ;
   private String edtCliConveVig_Jsonclick ;
   private String edtConveMesHsPExt_Jsonclick ;
   private String grpUnnamedgroup17_Internalname ;
   private String tblUnnamedtable16_Internalname ;
   private String divUnnamedtableconveinterdiasjor_Internalname ;
   private String lblTextblockconveinterdiasjor_Jsonclick ;
   private String edtConveInterDiasJor_Jsonclick ;
   private String divUnnamedtableconveminmesesvac_Internalname ;
   private String lblTextblockconveminmesesvac_Jsonclick ;
   private String edtConveMinMesesVac_Jsonclick ;
   private String divUnnamedtable20_Internalname ;
   private String divTableleaflevel_vacaciones_Internalname ;
   private String grpUnnamedgroup19_Internalname ;
   private String tblUnnamedtable18_Internalname ;
   private String divUnnamedtableconveguaredadmin_Internalname ;
   private String lblTextblockconveguaredadmin_Jsonclick ;
   private String edtConveGuarEdadMin_Jsonclick ;
   private String divUnnamedtableconveguaredadmax_Internalname ;
   private String lblTextblockconveguaredadmax_Jsonclick ;
   private String edtConveGuarEdadMax_Jsonclick ;
   private String sGXsfl_166_fel_idx="0001" ;
   private String subGridlevel_valores_Class ;
   private String subGridlevel_valores_Linesclass ;
   private String edtCatVigencia_Jsonclick ;
   private String edtEscBasico_Jsonclick ;
   private String edtEscAdicional_Jsonclick ;
   private String lblTextblockcatcodigo_Internalname ;
   private String lblTextblockcatdescrip_Internalname ;
   private String sGXsfl_130_fel_idx="0001" ;
   private String subFreestylelevel_categorias_Class ;
   private String subFreestylelevel_categorias_Linesclass ;
   private String tblUnnamedtablefsfreestylelevel_categorias_Internalname ;
   private String divTableintermediateinslevel_categorias_Internalname ;
   private String grpUnnamedgroup14_Internalname ;
   private String tblUnnamedtable13_Internalname ;
   private String divUnnamedtablecatcodigo_Internalname ;
   private String lblTextblockcatcodigo_Jsonclick ;
   private String edtCatCodigo_Jsonclick ;
   private String divUnnamedtablecatdescrip_Internalname ;
   private String lblTextblockcatdescrip_Jsonclick ;
   private String grpUnnamedgroup15_Internalname ;
   private String tblGroupsalario_Internalname ;
   private String divTableleaflevel_valores_Internalname ;
   private String tblUnnamedtablecontentfsfreestylelevel_categorias_Internalname ;
   private String edtCatFrecAct_Jsonclick ;
   private String sGXsfl_194_fel_idx="0001" ;
   private String subGridlevel_importes_Class ;
   private String subGridlevel_importes_Linesclass ;
   private String edtCliConveImpVig_Jsonclick ;
   private String edtCliConveImporte_Jsonclick ;
   private String sGXsfl_204_fel_idx="0001" ;
   private String subGridlevel_importes2_Class ;
   private String subGridlevel_importes2_Linesclass ;
   private String edtavCliconveimpvig_Jsonclick ;
   private String edtavCliconveimporte_Jsonclick ;
   private String sGXsfl_265_fel_idx="0001" ;
   private String subGridlevel_importesdeadicional_Class ;
   private String subGridlevel_importesdeadicional_Linesclass ;
   private String edtConveAdiVig_Jsonclick ;
   private String edtConveAdiImporte_Jsonclick ;
   private String sGXsfl_277_fel_idx="0001" ;
   private String subGridlevel_opciones_Class ;
   private String subGridlevel_opciones_Linesclass ;
   private String edtConveAdiOpcCod_Jsonclick ;
   private String edtConveAdiOpcFor_Jsonclick ;
   private String edtConveAdiOpcDes_Jsonclick ;
   private String edtConveAdiOpcAli_Jsonclick ;
   private String sGXsfl_291_fel_idx="0001" ;
   private String subGridlevel_estadoscancelan_Class ;
   private String subGridlevel_estadoscancelan_Linesclass ;
   private String edtConveAdiSitCancela_Jsonclick ;
   private String lblTextblockconveadiinfo_Internalname ;
   private String sGXsfl_218_fel_idx="0001" ;
   private String subFreestylelevel_adicionales_Class ;
   private String subFreestylelevel_adicionales_Linesclass ;
   private String tblUnnamedtablefsfreestylelevel_adicionales_Internalname ;
   private String divTableintermediateinslevel_adicionales_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String edtConveAdicod_Jsonclick ;
   private String edtConveAdiAli_Jsonclick ;
   private String divUnnamedtableconveadiinfo_Internalname ;
   private String lblTextblockconveadiinfo_Jsonclick ;
   private String grpUnnamedgroup4_Internalname ;
   private String tblUnnamedtable3_Internalname ;
   private String divTableleaflevel_importesdeadicional_Internalname ;
   private String grpUnnamedgroup6_Internalname ;
   private String tblUnnamedtable5_Internalname ;
   private String divTableleaflevel_alicuotas_Internalname ;
   private String grpUnnamedgroup8_Internalname ;
   private String tblUnnamedtable7_Internalname ;
   private String divTableleaflevel_estadoscancelan_Internalname ;
   private String subFreestylelevel_datos_Header ;
   private String lblTextblockconveinterdiasjor_Caption ;
   private String lblTextblockconveminmesesvac_Caption ;
   private String lblTextblockconveguaredadmin_Caption ;
   private String lblTextblockconveguaredadmax_Caption ;
   private String subFreestylelevel_categorias_Header ;
   private String lblTextblockcatcodigo_Caption ;
   private String lblTextblockcatdescrip_Caption ;
   private String subFreestylelevel_adicionales_Header ;
   private String lblTextblockconveadiinfo_Caption ;
   private String subGridlevel_importes2_Header ;
   private String subGridlevel_importes_Header ;
   private String subGridlevel_vacaciones_Header ;
   private String subGridlevel_valores_Header ;
   private String subGridlevel_importesdeadicional_Header ;
   private String subGridlevel_opciones_Header ;
   private String subGridlevel_estadoscancelan_Header ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV32CliConveImpVig ;
   private java.util.Date A1587CliConveImpVig ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date A999ConveAdiVig ;
   private java.util.Date AV31ConveAdiVig ;
   private java.util.Date AV33CatVigencia ;
   private java.util.Date AV34CliConveVig ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date GXv_date3[] ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date GXv_date5[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_36_Refreshing=false ;
   private boolean bGXsfl_130_Refreshing=false ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean Dvpanel_unnamedtable20_Autowidth ;
   private boolean Dvpanel_unnamedtable20_Autoheight ;
   private boolean Dvpanel_unnamedtable20_Collapsible ;
   private boolean Dvpanel_unnamedtable20_Collapsed ;
   private boolean Dvpanel_unnamedtable20_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable20_Autoscroll ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean A1401ConveFondoCese ;
   private boolean n1627ConveGuarEdadMin ;
   private boolean n1628ConveGuarEdadMax ;
   private boolean n1019ConveAdiInfo ;
   private boolean bGXsfl_204_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_218_Refreshing=false ;
   private boolean bGXsfl_291_Refreshing=false ;
   private boolean bGXsfl_277_Refreshing=false ;
   private boolean bGXsfl_265_Refreshing=false ;
   private boolean bGXsfl_194_Refreshing=false ;
   private boolean bGXsfl_166_Refreshing=false ;
   private boolean bGXsfl_93_Refreshing=false ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String A1019ConveAdiInfo ;
   private String A123CatDescrip ;
   private String A997ConveAdiDescri ;
   private String A1012ConveAdiOpcDes ;
   private String A1567CliConvenioDescrip ;
   private com.genexus.webpanels.GXWebGrid Freestylelevel_datosContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_vacacionesContainer ;
   private com.genexus.webpanels.GXWebGrid Freestylelevel_categoriasContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_valoresContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_importesContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_importes2Container ;
   private com.genexus.webpanels.GXWebGrid Freestylelevel_adicionalesContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_importesdeadicionalContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_opcionesContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_estadoscancelanContainer ;
   private com.genexus.webpanels.GXWebRow Freestylelevel_datosRow ;
   private com.genexus.webpanels.GXWebRow Freestylelevel_adicionalesRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_estadoscancelanRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_opcionesRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_importesdeadicionalRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_importes2Row ;
   private com.genexus.webpanels.GXWebRow Gridlevel_importesRow ;
   private com.genexus.webpanels.GXWebRow Freestylelevel_categoriasRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_valoresRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_vacacionesRow ;
   private com.genexus.webpanels.GXWebColumn Freestylelevel_datosColumn ;
   private com.genexus.webpanels.GXWebColumn Freestylelevel_categoriasColumn ;
   private com.genexus.webpanels.GXWebColumn Freestylelevel_adicionalesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_importes2Column ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_importesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_vacacionesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_valoresColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_importesdeadicionalColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_opcionesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_estadoscancelanColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_estadoscancelan_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_opciones_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_importesdeadicional_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_importes2_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_importes_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_valores_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridlevel_vacaciones_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable20 ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private HTMLChoice cmbConveDiaHsPExt ;
   private ICheckbox chkConveFondoCese ;
   private HTMLChoice cmbCatClase ;
   private HTMLChoice cmbCliConveImpTipo ;
   private HTMLChoice cmbavCliconveimptipo ;
   private HTMLChoice cmbConveAdiTipo ;
   private IDataStoreProvider pr_default ;
   private int[] H00LV2_A3CliCod ;
   private short[] H00LV2_A1564CliPaiConve ;
   private String[] H00LV2_A1565CliConvenio ;
   private java.util.Date[] H00LV2_A1575CliConveVig ;
   private String[] H00LV2_A1567CliConvenioDescrip ;
   private byte[] H00LV2_A1628ConveGuarEdadMax ;
   private boolean[] H00LV2_n1628ConveGuarEdadMax ;
   private byte[] H00LV2_A1627ConveGuarEdadMin ;
   private boolean[] H00LV2_n1627ConveGuarEdadMin ;
   private byte[] H00LV2_A1046ConveMinMesesVac ;
   private short[] H00LV2_A1043ConveInterDiasJor ;
   private boolean[] H00LV2_A1401ConveFondoCese ;
   private String[] H00LV2_A1270ConveDiaHsPExt ;
   private boolean[] H00LV2_n1270ConveDiaHsPExt ;
   private java.math.BigDecimal[] H00LV2_A1269ConveMesHsPExt ;
   private int[] H00LV3_A3CliCod ;
   private short[] H00LV3_A1564CliPaiConve ;
   private String[] H00LV3_A1565CliConvenio ;
   private String[] H00LV3_A996ConveAdicod ;
   private String[] H00LV3_A1803ConveAdiTipo ;
   private String[] H00LV3_A1019ConveAdiInfo ;
   private boolean[] H00LV3_n1019ConveAdiInfo ;
   private java.math.BigDecimal[] H00LV3_A998ConveAdiAli ;
   private String[] H00LV3_A997ConveAdiDescri ;
   private int[] H00LV4_A3CliCod ;
   private short[] H00LV4_A1564CliPaiConve ;
   private String[] H00LV4_A1565CliConvenio ;
   private String[] H00LV4_A996ConveAdicod ;
   private String[] H00LV4_A1824ConveAdiSitCancela ;
   private int[] H00LV5_A3CliCod ;
   private short[] H00LV5_A1564CliPaiConve ;
   private String[] H00LV5_A1565CliConvenio ;
   private String[] H00LV5_A996ConveAdicod ;
   private java.math.BigDecimal[] H00LV5_A1013ConveAdiOpcAli ;
   private String[] H00LV5_A1012ConveAdiOpcDes ;
   private String[] H00LV5_A1021ConveAdiOpcFor ;
   private short[] H00LV5_A1011ConveAdiOpcCod ;
   private int[] H00LV6_A3CliCod ;
   private short[] H00LV6_A1564CliPaiConve ;
   private String[] H00LV6_A1565CliConvenio ;
   private String[] H00LV6_A996ConveAdicod ;
   private java.math.BigDecimal[] H00LV6_A1000ConveAdiImporte ;
   private java.util.Date[] H00LV6_A999ConveAdiVig ;
   private int[] H00LV7_A3CliCod ;
   private short[] H00LV7_A1564CliPaiConve ;
   private String[] H00LV7_A1565CliConvenio ;
   private java.math.BigDecimal[] H00LV7_A1589CliConveImporte ;
   private String[] H00LV7_A1588CliConveImpTipo ;
   private java.util.Date[] H00LV7_A1587CliConveImpVig ;
   private int[] H00LV8_A3CliCod ;
   private short[] H00LV8_A1564CliPaiConve ;
   private String[] H00LV8_A1565CliConvenio ;
   private String[] H00LV8_A8CatCodigo ;
   private byte[] H00LV8_A1914CatFrecAct ;
   private byte[] H00LV8_A1838CatClase ;
   private String[] H00LV8_A123CatDescrip ;
   private int[] H00LV9_A3CliCod ;
   private short[] H00LV9_A1564CliPaiConve ;
   private String[] H00LV9_A1565CliConvenio ;
   private String[] H00LV9_A8CatCodigo ;
   private java.math.BigDecimal[] H00LV9_A1893EscAdicional ;
   private java.math.BigDecimal[] H00LV9_A1892EscBasico ;
   private java.util.Date[] H00LV9_A907CatVigencia ;
   private int[] H00LV10_A3CliCod ;
   private short[] H00LV10_A1564CliPaiConve ;
   private String[] H00LV10_A1565CliConvenio ;
   private java.util.Date[] H00LV10_A1575CliConveVig ;
   private int[] H00LV10_A1902ConveVacRelSec ;
   private byte[] H00LV10_A1763CliConveVacDias ;
   private byte[] H00LV10_A1762CliConveVacHasAnt ;
   private byte[] H00LV10_A1761CliConveVacDesAnt ;
   private long[] H00LV11_AGRIDLEVEL_ESTADOSCANCELAN_nRecordCount ;
   private long[] H00LV12_AGRIDLEVEL_OPCIONES_nRecordCount ;
   private long[] H00LV13_AGRIDLEVEL_IMPORTESDEADICIONAL_nRecordCount ;
   private long[] H00LV14_AGRIDLEVEL_IMPORTES_nRecordCount ;
   private long[] H00LV15_AGRIDLEVEL_VALORES_nRecordCount ;
   private long[] H00LV16_AGRIDLEVEL_VACACIONES_nRecordCount ;
   private String[] H00LV17_A1567CliConvenioDescrip ;
   private int[] H00LV18_A3CliCod ;
   private short[] H00LV18_A1564CliPaiConve ;
   private String[] H00LV18_A1565CliConvenio ;
   private String[] H00LV18_A1588CliConveImpTipo ;
   private java.util.Date[] H00LV18_A1587CliConveImpVig ;
   private java.math.BigDecimal[] H00LV18_A1589CliConveImporte ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class conveniotabs__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00LV2", "SELECT T1.CliCod, T1.CliPaiConve AS CliPaiConve, T1.CliConvenio AS CliConvenio, T1.CliConveVig, T2.ConveDescri AS CliConvenioDescrip, T1.ConveGuarEdadMax, T1.ConveGuarEdadMin, T1.ConveMinMesesVac, T1.ConveInterDiasJor, T1.ConveFondoCese, T1.ConveDiaHsPExt, T1.ConveMesHsPExt FROM (ClienteConvenio_Particularidades T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.CliConveVig DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV3", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiTipo, ConveAdiInfo, ConveAdiAli, ConveAdiDescri FROM convenio_adicional WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV4", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,51, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV5", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcAli, ConveAdiOpcDes, ConveAdiOpcFor, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV6", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiImporte, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig >= ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig DESC  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV7", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImporte, CliConveImpTipo, CliConveImpVig FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig >= ? and CliConveImpTipo = ( 'TopeIndem') ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig DESC  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV8", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatFrecAct, CatClase, CatDescrip FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV9", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, EscAdicional, EscBasico, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia >= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia DESC  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV10", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveVacRelSec, CliConveVacDias, CliConveVacHasAnt, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV11", "SELECT COUNT(*) FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV12", "SELECT COUNT(*) FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV13", "SELECT COUNT(*) FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig >= ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV14", "SELECT COUNT(*) FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig >= ? and CliConveImpTipo = ( 'TopeIndem') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV15", "SELECT COUNT(*) FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia >= ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV16", "SELECT COUNT(*) FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV17", "SELECT ConveDescri AS CliConvenioDescrip FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00LV18", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveImpTipo, CliConveImpVig, CliConveImporte FROM clienteConvenio_importes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveImpVig >= ? and CliConveImpTipo = ( 'Guarderia') ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveImpVig DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((short[]) buf[10])[0] = rslt.getShort(9);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(12,1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

