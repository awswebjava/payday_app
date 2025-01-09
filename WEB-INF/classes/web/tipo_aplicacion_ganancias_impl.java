package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipo_aplicacion_ganancias_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action32") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1998AplIIGGgRelSec = (int)(GXutil.lval( httpContext.GetPar( "AplIIGGgRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_32_37126( Gx_mode, AV7CliCod, A1998AplIIGGgRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"APLIIGGCONDICION") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaapliiggcondicion37126( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"APLIIGGGRELSEC") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaapliigggrelsec37126( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx6asaclicod37126( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel20"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel21"+"_"+"") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxasa199837126( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_35") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_35( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_36") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1111AplIIGGTopeCon = httpContext.GetPar( "AplIIGGTopeCon") ;
         n1111AplIIGGTopeCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_36( A3CliCod, A1111AplIIGGTopeCon) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_37") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1117AplIIGGExenCon = httpContext.GetPar( "AplIIGGExenCon") ;
         n1117AplIIGGExenCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_37( A3CliCod, A1117AplIIGGExenCon) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_38") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1118ApliIIGGExenOtr = httpContext.GetPar( "ApliIIGGExenOtr") ;
         n1118ApliIIGGExenOtr = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_38( A3CliCod, A1118ApliIIGGExenOtr) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_39") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1109AplIIGGTopeVar = httpContext.GetPar( "AplIIGGTopeVar") ;
         n1109AplIIGGTopeVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_39( A3CliCod, A1109AplIIGGTopeVar) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_40") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1124AplIIGGCondicion = httpContext.GetPar( "AplIIGGCondicion") ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_40( A3CliCod, A1124AplIIGGCondicion) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8AplIIGG = (short)(GXutil.lval( httpContext.GetPar( "AplIIGG"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8AplIIGG), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPLIIGG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8AplIIGG), "ZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "tipo_aplicacion_ganancias", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtAplIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public tipo_aplicacion_ganancias_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipo_aplicacion_ganancias_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_aplicacion_ganancias_impl.class ));
   }

   public tipo_aplicacion_ganancias_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbAplIIGGTrat = new HTMLChoice();
      cmbAplIIGGPrrtear = new HTMLChoice();
      dynAplIIGGCondicion = new HTMLChoice();
      cmbAplIIGGTopeTip = new HTMLChoice();
      dynAplIIGGgRelSec = new HTMLChoice();
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      if ( cmbAplIIGGTrat.getItemCount() > 0 )
      {
         A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValidValue(GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGTrat.setValue( GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTrat.getInternalname(), "Values", cmbAplIIGGTrat.ToJavascriptSource(), true);
      }
      if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
      {
         A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValidValue(A1121AplIIGGPrrtear) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGPrrtear.setValue( GXutil.rtrim( A1121AplIIGGPrrtear) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGPrrtear.getInternalname(), "Values", cmbAplIIGGPrrtear.ToJavascriptSource(), true);
      }
      if ( dynAplIIGGCondicion.getItemCount() > 0 )
      {
         A1124AplIIGGCondicion = dynAplIIGGCondicion.getValidValue(A1124AplIIGGCondicion) ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynAplIIGGCondicion.setValue( GXutil.rtrim( A1124AplIIGGCondicion) );
         httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGCondicion.getInternalname(), "Values", dynAplIIGGCondicion.ToJavascriptSource(), true);
      }
      if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
      {
         A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValidValue(GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbAplIIGGTopeTip.setValue( GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTopeTip.getInternalname(), "Values", cmbAplIIGGTopeTip.ToJavascriptSource(), true);
      }
      if ( dynAplIIGGgRelSec.getItemCount() > 0 )
      {
         A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValidValue(GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynAplIIGGgRelSec.setValue( GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGgRelSec.getInternalname(), "Values", dynAplIIGGgRelSec.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGG_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGG_Internalname, httpContext.getMessage( "Tratamiento IIGG Nro", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGG_Internalname, GXutil.ltrim( localUtil.ntoc( A1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1112AplIIGG), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGG_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGG_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGNom_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGNom_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtAplIIGGNom_Internalname, A1113AplIIGGNom, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtAplIIGGNom_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGTrat.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGTrat.getInternalname(), httpContext.getMessage( "Tratamiento específico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGTrat, cmbAplIIGGTrat.getInternalname(), GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)), 1, cmbAplIIGGTrat.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbAplIIGGTrat.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_tipo_aplicacion_ganancias.htm");
      cmbAplIIGGTrat.setValue( GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTrat.getInternalname(), "Values", cmbAplIIGGTrat.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGPropor_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGPropor_Internalname, httpContext.getMessage( "Proporción del tope (1 =100%)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGPropor_Internalname, GXutil.ltrim( localUtil.ntoc( A1114AplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGGPropor_Enabled!=0) ? localUtil.format( A1114AplIIGGPropor, "9.9999") : localUtil.format( A1114AplIIGGPropor, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGPropor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGGPropor_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedapliiggexencon_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockapliiggexencon_Internalname, httpContext.getMessage( "Concepto exento agrupador para F1357", ""), "", "", lblTextblockapliiggexencon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_apliiggexencon.setProperty("Caption", Combo_apliiggexencon_Caption);
      ucCombo_apliiggexencon.setProperty("Cls", Combo_apliiggexencon_Cls);
      ucCombo_apliiggexencon.setProperty("DataListProc", Combo_apliiggexencon_Datalistproc);
      ucCombo_apliiggexencon.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_apliiggexencon.setProperty("DropDownOptionsData", AV30AplIIGGExenCon_Data);
      ucCombo_apliiggexencon.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_apliiggexencon_Internalname, "COMBO_APLIIGGEXENCONContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGExenCon_Internalname, httpContext.getMessage( "Concepto exento agrupador para F1357", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGExenCon_Internalname, GXutil.rtrim( A1117AplIIGGExenCon), GXutil.rtrim( localUtil.format( A1117AplIIGGExenCon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGExenCon_Jsonclick, 0, "Attribute", "", "", "", "", edtAplIIGGExenCon_Visible, edtAplIIGGExenCon_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGPrrtear.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGPrrtear.getInternalname(), httpContext.getMessage( "Tipo de cuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGPrrtear, cmbAplIIGGPrrtear.getInternalname(), GXutil.rtrim( A1121AplIIGGPrrtear), 1, cmbAplIIGGPrrtear.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbAplIIGGPrrtear.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_tipo_aplicacion_ganancias.htm");
      cmbAplIIGGPrrtear.setValue( GXutil.rtrim( A1121AplIIGGPrrtear) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGPrrtear.getInternalname(), "Values", cmbAplIIGGPrrtear.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynAplIIGGCondicion.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynAplIIGGCondicion.getInternalname(), httpContext.getMessage( "Condición a cumplir para exención", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynAplIIGGCondicion, dynAplIIGGCondicion.getInternalname(), GXutil.rtrim( A1124AplIIGGCondicion), 1, dynAplIIGGCondicion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynAplIIGGCondicion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(0), "HLP_tipo_aplicacion_ganancias.htm");
      dynAplIIGGCondicion.setValue( GXutil.rtrim( A1124AplIIGGCondicion) );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGCondicion.getInternalname(), "Values", dynAplIIGGCondicion.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Control Group */
      web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup3_Internalname, httpContext.getMessage( "Tope", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_tipo_aplicacion_ganancias.htm");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbAplIIGGTopeTip.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbAplIIGGTopeTip.getInternalname(), httpContext.getMessage( "Tipo de tope", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbAplIIGGTopeTip, cmbAplIIGGTopeTip.getInternalname(), GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)), 1, cmbAplIIGGTopeTip.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbAplIIGGTopeTip.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "", true, (byte)(0), "HLP_tipo_aplicacion_ganancias.htm");
      cmbAplIIGGTopeTip.setValue( GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTopeTip.getInternalname(), "Values", cmbAplIIGGTopeTip.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell ExtendedComboCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedapliiggtopevar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockapliiggtopevar_Internalname, httpContext.getMessage( "Variable para tope", ""), "", "", lblTextblockapliiggtopevar_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_apliiggtopevar.setProperty("Caption", Combo_apliiggtopevar_Caption);
      ucCombo_apliiggtopevar.setProperty("Cls", Combo_apliiggtopevar_Cls);
      ucCombo_apliiggtopevar.setProperty("DataListProc", Combo_apliiggtopevar_Datalistproc);
      ucCombo_apliiggtopevar.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_apliiggtopevar.setProperty("DropDownOptionsData", AV26AplIIGGTopeVar_Data);
      ucCombo_apliiggtopevar.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_apliiggtopevar_Internalname, "COMBO_APLIIGGTOPEVARContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGTopeVar_Internalname, httpContext.getMessage( "Variable para tope", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGTopeVar_Internalname, GXutil.rtrim( A1109AplIIGGTopeVar), GXutil.rtrim( localUtil.format( A1109AplIIGGTopeVar, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,81);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGTopeVar_Jsonclick, 0, "Attribute", "", "", "", "", edtAplIIGGTopeVar_Visible, edtAplIIGGTopeVar_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell ExtendedComboCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedapliiggtopecon_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockapliiggtopecon_Internalname, httpContext.getMessage( "Concepto para tope", ""), "", "", lblTextblockapliiggtopecon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_apliiggtopecon.setProperty("Caption", Combo_apliiggtopecon_Caption);
      ucCombo_apliiggtopecon.setProperty("Cls", Combo_apliiggtopecon_Cls);
      ucCombo_apliiggtopecon.setProperty("DataListProc", Combo_apliiggtopecon_Datalistproc);
      ucCombo_apliiggtopecon.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_apliiggtopecon.setProperty("DropDownOptionsData", AV38AplIIGGTopeCon_Data);
      ucCombo_apliiggtopecon.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_apliiggtopecon_Internalname, "COMBO_APLIIGGTOPECONContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGTopeCon_Internalname, httpContext.getMessage( "Concepto para tope", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGTopeCon_Internalname, GXutil.rtrim( A1111AplIIGGTopeCon), GXutil.rtrim( localUtil.format( A1111AplIIGGTopeCon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGTopeCon_Jsonclick, 0, "Attribute", "", "", "", "", edtAplIIGGTopeCon_Visible, edtAplIIGGTopeCon_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='DataContentCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtAplIIGGTopeFij_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtAplIIGGTopeFij_Internalname, httpContext.getMessage( "Tope fijo", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtAplIIGGTopeFij_Internalname, GXutil.ltrim( localUtil.ntoc( A1119AplIIGGTopeFij, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtAplIIGGTopeFij_Enabled!=0) ? localUtil.format( A1119AplIIGGTopeFij, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1119AplIIGGTopeFij, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAplIIGGTopeFij_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAplIIGGTopeFij_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      httpContext.writeText( "</fieldset>") ;
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divApliigggrelsec_cell_Internalname, 1, 0, "px", 0, "px", divApliigggrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynAplIIGGgRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynAplIIGGgRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynAplIIGGgRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynAplIIGGgRelSec, dynAplIIGGgRelSec.getInternalname(), GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)), 1, dynAplIIGGgRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynAplIIGGgRelSec.getVisible(), dynAplIIGGgRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "", true, (byte)(0), "HLP_tipo_aplicacion_ganancias.htm");
      dynAplIIGGgRelSec.setValue( GXutil.trim( GXutil.str( A1998AplIIGGgRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGgRelSec.getInternalname(), "Values", dynAplIIGGgRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_apliiggexencon_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboapliiggexencon_Internalname, GXutil.rtrim( AV31ComboAplIIGGExenCon), GXutil.rtrim( localUtil.format( AV31ComboAplIIGGExenCon, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboapliiggexencon_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboapliiggexencon_Visible, edtavComboapliiggexencon_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_apliiggtopevar_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboapliiggtopevar_Internalname, GXutil.rtrim( AV27ComboAplIIGGTopeVar), GXutil.rtrim( localUtil.format( AV27ComboAplIIGGTopeVar, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboapliiggtopevar_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboapliiggtopevar_Visible, edtavComboapliiggtopevar_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_apliiggtopecon_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboapliiggtopecon_Internalname, GXutil.rtrim( AV39ComboAplIIGGTopeCon), GXutil.rtrim( localUtil.format( AV39ComboAplIIGGTopeCon, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboapliiggtopecon_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboapliiggtopecon_Visible, edtavComboapliiggtopecon_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,124);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_tipo_aplicacion_ganancias.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtApliIIGGExenOtr_Internalname, GXutil.rtrim( A1118ApliIIGGExenOtr), GXutil.rtrim( localUtil.format( A1118ApliIIGGExenOtr, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,125);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtApliIIGGExenOtr_Jsonclick, 0, "Attribute", "", "", "", "", edtApliIIGGExenOtr_Visible, edtApliIIGGExenOtr_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodConcepto", "left", true, "", "HLP_tipo_aplicacion_ganancias.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11372 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAPLIIGGEXENCON_DATA"), AV30AplIIGGExenCon_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAPLIIGGTOPEVAR_DATA"), AV26AplIIGGTopeVar_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAPLIIGGTOPECON_DATA"), AV38AplIIGGTopeCon_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "Z1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1113AplIIGGNom = httpContext.cgiGet( "Z1113AplIIGGNom") ;
            Z1120AplIIGGTrat = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1120AplIIGGTrat"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1114AplIIGGPropor = localUtil.ctond( httpContext.cgiGet( "Z1114AplIIGGPropor")) ;
            Z1115AplIIGGTopeTip = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1115AplIIGGTopeTip"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1119AplIIGGTopeFij = localUtil.ctond( httpContext.cgiGet( "Z1119AplIIGGTopeFij")) ;
            Z1121AplIIGGPrrtear = httpContext.cgiGet( "Z1121AplIIGGPrrtear") ;
            Z1998AplIIGGgRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1998AplIIGGgRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1999AplIIGGRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1999AplIIGGRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2000AplIIGGPadre = (short)(localUtil.ctol( httpContext.cgiGet( "Z2000AplIIGGPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2020AplIIGGRelRef = httpContext.cgiGet( "Z2020AplIIGGRelRef") ;
            Z1111AplIIGGTopeCon = httpContext.cgiGet( "Z1111AplIIGGTopeCon") ;
            n1111AplIIGGTopeCon = ((GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ? true : false) ;
            Z1117AplIIGGExenCon = httpContext.cgiGet( "Z1117AplIIGGExenCon") ;
            n1117AplIIGGExenCon = ((GXutil.strcmp("", A1117AplIIGGExenCon)==0) ? true : false) ;
            Z1118ApliIIGGExenOtr = httpContext.cgiGet( "Z1118ApliIIGGExenOtr") ;
            n1118ApliIIGGExenOtr = ((GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ? true : false) ;
            Z1109AplIIGGTopeVar = httpContext.cgiGet( "Z1109AplIIGGTopeVar") ;
            n1109AplIIGGTopeVar = ((GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ? true : false) ;
            Z1124AplIIGGCondicion = httpContext.cgiGet( "Z1124AplIIGGCondicion") ;
            n1124AplIIGGCondicion = ((GXutil.strcmp("", A1124AplIIGGCondicion)==0) ? true : false) ;
            A1999AplIIGGRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1999AplIIGGRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2000AplIIGGPadre = (short)(localUtil.ctol( httpContext.cgiGet( "Z2000AplIIGGPadre"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2020AplIIGGRelRef = httpContext.cgiGet( "Z2020AplIIGGRelRef") ;
            O1124AplIIGGCondicion = httpContext.cgiGet( "O1124AplIIGGCondicion") ;
            n1124AplIIGGCondicion = ((GXutil.strcmp("", A1124AplIIGGCondicion)==0) ? true : false) ;
            O1119AplIIGGTopeFij = localUtil.ctond( httpContext.cgiGet( "O1119AplIIGGTopeFij")) ;
            O1111AplIIGGTopeCon = httpContext.cgiGet( "O1111AplIIGGTopeCon") ;
            n1111AplIIGGTopeCon = ((GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ? true : false) ;
            O1109AplIIGGTopeVar = httpContext.cgiGet( "O1109AplIIGGTopeVar") ;
            n1109AplIIGGTopeVar = ((GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ? true : false) ;
            O1115AplIIGGTopeTip = (byte)(localUtil.ctol( httpContext.cgiGet( "O1115AplIIGGTopeTip"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1121AplIIGGPrrtear = httpContext.cgiGet( "O1121AplIIGGPrrtear") ;
            O1117AplIIGGExenCon = httpContext.cgiGet( "O1117AplIIGGExenCon") ;
            n1117AplIIGGExenCon = ((GXutil.strcmp("", A1117AplIIGGExenCon)==0) ? true : false) ;
            O1114AplIIGGPropor = localUtil.ctond( httpContext.cgiGet( "O1114AplIIGGPropor")) ;
            O1120AplIIGGTrat = (byte)(localUtil.ctol( httpContext.cgiGet( "O1120AplIIGGTrat"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1113AplIIGGNom = httpContext.cgiGet( "O1113AplIIGGNom") ;
            O1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "O1112AplIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N1109AplIIGGTopeVar = httpContext.cgiGet( "N1109AplIIGGTopeVar") ;
            n1109AplIIGGTopeVar = ((GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ? true : false) ;
            N1111AplIIGGTopeCon = httpContext.cgiGet( "N1111AplIIGGTopeCon") ;
            n1111AplIIGGTopeCon = ((GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ? true : false) ;
            N1117AplIIGGExenCon = httpContext.cgiGet( "N1117AplIIGGExenCon") ;
            n1117AplIIGGExenCon = ((GXutil.strcmp("", A1117AplIIGGExenCon)==0) ? true : false) ;
            N1118ApliIIGGExenOtr = httpContext.cgiGet( "N1118ApliIIGGExenOtr") ;
            n1118ApliIIGGExenOtr = ((GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ? true : false) ;
            N1124AplIIGGCondicion = httpContext.cgiGet( "N1124AplIIGGCondicion") ;
            n1124AplIIGGCondicion = ((GXutil.strcmp("", A1124AplIIGGCondicion)==0) ? true : false) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( "vAPLIIGG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV14Insert_AplIIGGTopeVar = httpContext.cgiGet( "vINSERT_APLIIGGTOPEVAR") ;
            AV15Insert_AplIIGGTopeCon = httpContext.cgiGet( "vINSERT_APLIIGGTOPECON") ;
            AV16Insert_AplIIGGExenCon = httpContext.cgiGet( "vINSERT_APLIIGGEXENCON") ;
            AV17Insert_ApliIIGGExenOtr = httpContext.cgiGet( "vINSERT_APLIIIGGEXENOTR") ;
            AV18Insert_AplIIGGCondicion = httpContext.cgiGet( "vINSERT_APLIIGGCONDICION") ;
            AV41aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A1999AplIIGGRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "APLIIGGRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2000AplIIGGPadre = (short)(localUtil.ctol( httpContext.cgiGet( "APLIIGGPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2020AplIIGGRelRef = httpContext.cgiGet( "APLIIGGRELREF") ;
            A2028AplIIGGOld = httpContext.cgiGet( "APLIIGGOLD") ;
            AV42Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_apliiggexencon_Objectcall = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Objectcall") ;
            Combo_apliiggexencon_Class = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Class") ;
            Combo_apliiggexencon_Icontype = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Icontype") ;
            Combo_apliiggexencon_Icon = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Icon") ;
            Combo_apliiggexencon_Caption = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Caption") ;
            Combo_apliiggexencon_Tooltip = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Tooltip") ;
            Combo_apliiggexencon_Cls = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Cls") ;
            Combo_apliiggexencon_Selectedvalue_set = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Selectedvalue_set") ;
            Combo_apliiggexencon_Selectedvalue_get = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Selectedvalue_get") ;
            Combo_apliiggexencon_Selectedtext_set = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Selectedtext_set") ;
            Combo_apliiggexencon_Selectedtext_get = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Selectedtext_get") ;
            Combo_apliiggexencon_Gamoauthtoken = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Gamoauthtoken") ;
            Combo_apliiggexencon_Ddointernalname = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Ddointernalname") ;
            Combo_apliiggexencon_Titlecontrolalign = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Titlecontrolalign") ;
            Combo_apliiggexencon_Dropdownoptionstype = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Dropdownoptionstype") ;
            Combo_apliiggexencon_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Enabled")) ;
            Combo_apliiggexencon_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Visible")) ;
            Combo_apliiggexencon_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Titlecontrolidtoreplace") ;
            Combo_apliiggexencon_Datalisttype = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Datalisttype") ;
            Combo_apliiggexencon_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Allowmultipleselection")) ;
            Combo_apliiggexencon_Datalistfixedvalues = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Datalistfixedvalues") ;
            Combo_apliiggexencon_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Isgriditem")) ;
            Combo_apliiggexencon_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Hasdescription")) ;
            Combo_apliiggexencon_Datalistproc = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Datalistproc") ;
            Combo_apliiggexencon_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Datalistprocparametersprefix") ;
            Combo_apliiggexencon_Remoteservicesparameters = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Remoteservicesparameters") ;
            Combo_apliiggexencon_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_apliiggexencon_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Includeonlyselectedoption")) ;
            Combo_apliiggexencon_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Includeselectalloption")) ;
            Combo_apliiggexencon_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Emptyitem")) ;
            Combo_apliiggexencon_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Includeaddnewoption")) ;
            Combo_apliiggexencon_Htmltemplate = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Htmltemplate") ;
            Combo_apliiggexencon_Multiplevaluestype = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Multiplevaluestype") ;
            Combo_apliiggexencon_Loadingdata = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Loadingdata") ;
            Combo_apliiggexencon_Noresultsfound = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Noresultsfound") ;
            Combo_apliiggexencon_Emptyitemtext = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Emptyitemtext") ;
            Combo_apliiggexencon_Onlyselectedvalues = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Onlyselectedvalues") ;
            Combo_apliiggexencon_Selectalltext = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Selectalltext") ;
            Combo_apliiggexencon_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Multiplevaluesseparator") ;
            Combo_apliiggexencon_Addnewoptiontext = httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Addnewoptiontext") ;
            Combo_apliiggexencon_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGEXENCON_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_apliiggtopevar_Objectcall = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Objectcall") ;
            Combo_apliiggtopevar_Class = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Class") ;
            Combo_apliiggtopevar_Icontype = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Icontype") ;
            Combo_apliiggtopevar_Icon = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Icon") ;
            Combo_apliiggtopevar_Caption = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Caption") ;
            Combo_apliiggtopevar_Tooltip = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Tooltip") ;
            Combo_apliiggtopevar_Cls = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Cls") ;
            Combo_apliiggtopevar_Selectedvalue_set = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Selectedvalue_set") ;
            Combo_apliiggtopevar_Selectedvalue_get = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Selectedvalue_get") ;
            Combo_apliiggtopevar_Selectedtext_set = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Selectedtext_set") ;
            Combo_apliiggtopevar_Selectedtext_get = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Selectedtext_get") ;
            Combo_apliiggtopevar_Gamoauthtoken = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Gamoauthtoken") ;
            Combo_apliiggtopevar_Ddointernalname = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Ddointernalname") ;
            Combo_apliiggtopevar_Titlecontrolalign = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Titlecontrolalign") ;
            Combo_apliiggtopevar_Dropdownoptionstype = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Dropdownoptionstype") ;
            Combo_apliiggtopevar_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Enabled")) ;
            Combo_apliiggtopevar_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Visible")) ;
            Combo_apliiggtopevar_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Titlecontrolidtoreplace") ;
            Combo_apliiggtopevar_Datalisttype = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Datalisttype") ;
            Combo_apliiggtopevar_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Allowmultipleselection")) ;
            Combo_apliiggtopevar_Datalistfixedvalues = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Datalistfixedvalues") ;
            Combo_apliiggtopevar_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Isgriditem")) ;
            Combo_apliiggtopevar_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Hasdescription")) ;
            Combo_apliiggtopevar_Datalistproc = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Datalistproc") ;
            Combo_apliiggtopevar_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Datalistprocparametersprefix") ;
            Combo_apliiggtopevar_Remoteservicesparameters = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Remoteservicesparameters") ;
            Combo_apliiggtopevar_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_apliiggtopevar_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Includeonlyselectedoption")) ;
            Combo_apliiggtopevar_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Includeselectalloption")) ;
            Combo_apliiggtopevar_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Emptyitem")) ;
            Combo_apliiggtopevar_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Includeaddnewoption")) ;
            Combo_apliiggtopevar_Htmltemplate = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Htmltemplate") ;
            Combo_apliiggtopevar_Multiplevaluestype = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Multiplevaluestype") ;
            Combo_apliiggtopevar_Loadingdata = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Loadingdata") ;
            Combo_apliiggtopevar_Noresultsfound = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Noresultsfound") ;
            Combo_apliiggtopevar_Emptyitemtext = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Emptyitemtext") ;
            Combo_apliiggtopevar_Onlyselectedvalues = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Onlyselectedvalues") ;
            Combo_apliiggtopevar_Selectalltext = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Selectalltext") ;
            Combo_apliiggtopevar_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Multiplevaluesseparator") ;
            Combo_apliiggtopevar_Addnewoptiontext = httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Addnewoptiontext") ;
            Combo_apliiggtopevar_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGTOPEVAR_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_apliiggtopecon_Objectcall = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Objectcall") ;
            Combo_apliiggtopecon_Class = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Class") ;
            Combo_apliiggtopecon_Icontype = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Icontype") ;
            Combo_apliiggtopecon_Icon = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Icon") ;
            Combo_apliiggtopecon_Caption = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Caption") ;
            Combo_apliiggtopecon_Tooltip = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Tooltip") ;
            Combo_apliiggtopecon_Cls = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Cls") ;
            Combo_apliiggtopecon_Selectedvalue_set = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Selectedvalue_set") ;
            Combo_apliiggtopecon_Selectedvalue_get = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Selectedvalue_get") ;
            Combo_apliiggtopecon_Selectedtext_set = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Selectedtext_set") ;
            Combo_apliiggtopecon_Selectedtext_get = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Selectedtext_get") ;
            Combo_apliiggtopecon_Gamoauthtoken = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Gamoauthtoken") ;
            Combo_apliiggtopecon_Ddointernalname = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Ddointernalname") ;
            Combo_apliiggtopecon_Titlecontrolalign = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Titlecontrolalign") ;
            Combo_apliiggtopecon_Dropdownoptionstype = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Dropdownoptionstype") ;
            Combo_apliiggtopecon_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Enabled")) ;
            Combo_apliiggtopecon_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Visible")) ;
            Combo_apliiggtopecon_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Titlecontrolidtoreplace") ;
            Combo_apliiggtopecon_Datalisttype = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Datalisttype") ;
            Combo_apliiggtopecon_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Allowmultipleselection")) ;
            Combo_apliiggtopecon_Datalistfixedvalues = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Datalistfixedvalues") ;
            Combo_apliiggtopecon_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Isgriditem")) ;
            Combo_apliiggtopecon_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Hasdescription")) ;
            Combo_apliiggtopecon_Datalistproc = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Datalistproc") ;
            Combo_apliiggtopecon_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Datalistprocparametersprefix") ;
            Combo_apliiggtopecon_Remoteservicesparameters = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Remoteservicesparameters") ;
            Combo_apliiggtopecon_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_apliiggtopecon_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Includeonlyselectedoption")) ;
            Combo_apliiggtopecon_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Includeselectalloption")) ;
            Combo_apliiggtopecon_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Emptyitem")) ;
            Combo_apliiggtopecon_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Includeaddnewoption")) ;
            Combo_apliiggtopecon_Htmltemplate = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Htmltemplate") ;
            Combo_apliiggtopecon_Multiplevaluestype = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Multiplevaluestype") ;
            Combo_apliiggtopecon_Loadingdata = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Loadingdata") ;
            Combo_apliiggtopecon_Noresultsfound = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Noresultsfound") ;
            Combo_apliiggtopecon_Emptyitemtext = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Emptyitemtext") ;
            Combo_apliiggtopecon_Onlyselectedvalues = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Onlyselectedvalues") ;
            Combo_apliiggtopecon_Selectalltext = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Selectalltext") ;
            Combo_apliiggtopecon_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Multiplevaluesseparator") ;
            Combo_apliiggtopecon_Addnewoptiontext = httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Addnewoptiontext") ;
            Combo_apliiggtopecon_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_APLIIGGTOPECON_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "APLIIGG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAplIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1112AplIIGG = (short)(0) ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            }
            else
            {
               A1112AplIIGG = (short)(localUtil.ctol( httpContext.cgiGet( edtAplIIGG_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            }
            A1113AplIIGGNom = httpContext.cgiGet( edtAplIIGGNom_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
            cmbAplIIGGTrat.setValue( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()) );
            A1120AplIIGGTrat = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTrat.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtAplIIGGPropor_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAplIIGGPropor_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "APLIIGGPROPOR");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAplIIGGPropor_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1114AplIIGGPropor = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
            }
            else
            {
               A1114AplIIGGPropor = localUtil.ctond( httpContext.cgiGet( edtAplIIGGPropor_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
            }
            A1117AplIIGGExenCon = httpContext.cgiGet( edtAplIIGGExenCon_Internalname) ;
            n1117AplIIGGExenCon = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
            n1117AplIIGGExenCon = ((GXutil.strcmp("", A1117AplIIGGExenCon)==0) ? true : false) ;
            cmbAplIIGGPrrtear.setValue( httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) );
            A1121AplIIGGPrrtear = httpContext.cgiGet( cmbAplIIGGPrrtear.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
            dynAplIIGGCondicion.setValue( httpContext.cgiGet( dynAplIIGGCondicion.getInternalname()) );
            A1124AplIIGGCondicion = httpContext.cgiGet( dynAplIIGGCondicion.getInternalname()) ;
            n1124AplIIGGCondicion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
            n1124AplIIGGCondicion = ((GXutil.strcmp("", A1124AplIIGGCondicion)==0) ? true : false) ;
            cmbAplIIGGTopeTip.setValue( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()) );
            A1115AplIIGGTopeTip = (byte)(GXutil.lval( httpContext.cgiGet( cmbAplIIGGTopeTip.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
            A1109AplIIGGTopeVar = httpContext.cgiGet( edtAplIIGGTopeVar_Internalname) ;
            n1109AplIIGGTopeVar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
            n1109AplIIGGTopeVar = ((GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ? true : false) ;
            A1111AplIIGGTopeCon = httpContext.cgiGet( edtAplIIGGTopeCon_Internalname) ;
            n1111AplIIGGTopeCon = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
            n1111AplIIGGTopeCon = ((GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ? true : false) ;
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAplIIGGTopeFij_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtAplIIGGTopeFij_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "APLIIGGTOPEFIJ");
               AnyError = (short)(1) ;
               GX_FocusControl = edtAplIIGGTopeFij_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
            }
            else
            {
               A1119AplIIGGTopeFij = localUtil.ctond( httpContext.cgiGet( edtAplIIGGTopeFij_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
            }
            dynAplIIGGgRelSec.setValue( httpContext.cgiGet( dynAplIIGGgRelSec.getInternalname()) );
            A1998AplIIGGgRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynAplIIGGgRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
            AV31ComboAplIIGGExenCon = httpContext.cgiGet( edtavComboapliiggexencon_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31ComboAplIIGGExenCon", AV31ComboAplIIGGExenCon);
            AV27ComboAplIIGGTopeVar = httpContext.cgiGet( edtavComboapliiggtopevar_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ComboAplIIGGTopeVar", AV27ComboAplIIGGTopeVar);
            AV39ComboAplIIGGTopeCon = httpContext.cgiGet( edtavComboapliiggtopecon_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39ComboAplIIGGTopeCon", AV39ComboAplIIGGTopeCon);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            A1118ApliIIGGExenOtr = httpContext.cgiGet( edtApliIIGGExenOtr_Internalname) ;
            n1118ApliIIGGExenOtr = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
            n1118ApliIIGGExenOtr = ((GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"tipo_aplicacion_ganancias");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("AplIIGGRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1999AplIIGGRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("AplIIGGPadre", localUtil.format( DecimalUtil.doubleToDec(A2000AplIIGGPadre), "ZZZ9"));
            forbiddenHiddens.add("AplIIGGRelRef", GXutil.rtrim( localUtil.format( A2020AplIIGGRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1112AplIIGG != Z1112AplIIGG ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("tipo_aplicacion_ganancias:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1112AplIIGG = (short)(GXutil.lval( httpContext.GetPar( "AplIIGG"))) ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode126 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode126 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound126 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_370( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11372 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12372 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12372 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll37126( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes37126( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggexencon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggexencon_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopevar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopevar_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopecon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopecon_Enabled), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_370( )
   {
      beforeValidate37126( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls37126( ) ;
         }
         else
         {
            checkExtendedTable37126( ) ;
            closeExtendedTableCursors37126( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption370( )
   {
   }

   public void e11372( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtAplIIGGTopeCon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeCon_Visible), 5, 0), true);
      AV39ComboAplIIGGTopeCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39ComboAplIIGGTopeCon", AV39ComboAplIIGGTopeCon);
      edtavComboapliiggtopecon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopecon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopecon_Visible), 5, 0), true);
      edtAplIIGGTopeVar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeVar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeVar_Visible), 5, 0), true);
      AV27ComboAplIIGGTopeVar = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboAplIIGGTopeVar", AV27ComboAplIIGGTopeVar);
      edtavComboapliiggtopevar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopevar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopevar_Visible), 5, 0), true);
      edtAplIIGGExenCon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGExenCon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGExenCon_Visible), 5, 0), true);
      AV31ComboAplIIGGExenCon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31ComboAplIIGGExenCon", AV31ComboAplIIGGExenCon);
      edtavComboapliiggexencon_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggexencon_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggexencon_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOAPLIIGGEXENCON' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOAPLIIGGTOPEVAR' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOAPLIIGGTOPECON' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Insert", GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Update", GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_aplicacion_ganancias_Delete", GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV42Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S142 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV42Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV43GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GXV1), 8, 0));
         while ( AV43GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV19TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV43GXV1));
            if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGGTopeVar") == 0 )
            {
               AV14Insert_AplIIGGTopeVar = AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_AplIIGGTopeVar", AV14Insert_AplIIGGTopeVar);
               if ( ! (GXutil.strcmp("", AV14Insert_AplIIGGTopeVar)==0) )
               {
                  AV27ComboAplIIGGTopeVar = AV14Insert_AplIIGGTopeVar ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV27ComboAplIIGGTopeVar", AV27ComboAplIIGGTopeVar);
                  Combo_apliiggtopevar_Selectedvalue_set = AV27ComboAplIIGGTopeVar ;
                  ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "SelectedValue_set", Combo_apliiggtopevar_Selectedvalue_set);
                  GXt_char6 = AV24Combo_DataJson ;
                  GXv_char7[0] = AV22ComboSelectedValue ;
                  GXv_char8[0] = AV23ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeVar", "GET", false, AV7CliCod, AV8AplIIGG, AV40Insert_CliCod, AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char7[0] ;
                  tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
                  tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
                  AV24Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
                  Combo_apliiggtopevar_Selectedtext_set = AV23ComboSelectedText ;
                  ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "SelectedText_set", Combo_apliiggtopevar_Selectedtext_set);
                  Combo_apliiggtopevar_Enabled = false ;
                  ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggtopevar_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGGTopeCon") == 0 )
            {
               AV15Insert_AplIIGGTopeCon = AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_AplIIGGTopeCon", AV15Insert_AplIIGGTopeCon);
               if ( ! (GXutil.strcmp("", AV15Insert_AplIIGGTopeCon)==0) )
               {
                  AV39ComboAplIIGGTopeCon = AV15Insert_AplIIGGTopeCon ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV39ComboAplIIGGTopeCon", AV39ComboAplIIGGTopeCon);
                  Combo_apliiggtopecon_Selectedvalue_set = AV39ComboAplIIGGTopeCon ;
                  ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "SelectedValue_set", Combo_apliiggtopecon_Selectedvalue_set);
                  GXt_char6 = AV24Combo_DataJson ;
                  GXv_char9[0] = AV22ComboSelectedValue ;
                  GXv_char8[0] = AV23ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeCon", "GET", false, AV7CliCod, AV8AplIIGG, AV40Insert_CliCod, AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
                  tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
                  tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
                  AV24Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
                  Combo_apliiggtopecon_Selectedtext_set = AV23ComboSelectedText ;
                  ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "SelectedText_set", Combo_apliiggtopecon_Selectedtext_set);
                  Combo_apliiggtopecon_Enabled = false ;
                  ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggtopecon_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGGExenCon") == 0 )
            {
               AV16Insert_AplIIGGExenCon = AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_AplIIGGExenCon", AV16Insert_AplIIGGExenCon);
               if ( ! (GXutil.strcmp("", AV16Insert_AplIIGGExenCon)==0) )
               {
                  AV31ComboAplIIGGExenCon = AV16Insert_AplIIGGExenCon ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV31ComboAplIIGGExenCon", AV31ComboAplIIGGExenCon);
                  Combo_apliiggexencon_Selectedvalue_set = AV31ComboAplIIGGExenCon ;
                  ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "SelectedValue_set", Combo_apliiggexencon_Selectedvalue_set);
                  GXt_char6 = AV24Combo_DataJson ;
                  GXv_char9[0] = AV22ComboSelectedValue ;
                  GXv_char8[0] = AV23ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGExenCon", "GET", false, AV7CliCod, AV8AplIIGG, AV40Insert_CliCod, AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
                  tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
                  tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
                  AV24Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
                  Combo_apliiggexencon_Selectedtext_set = AV23ComboSelectedText ;
                  ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "SelectedText_set", Combo_apliiggexencon_Selectedtext_set);
                  Combo_apliiggexencon_Enabled = false ;
                  ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggexencon_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ApliIIGGExenOtr") == 0 )
            {
               AV17Insert_ApliIIGGExenOtr = AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV17Insert_ApliIIGGExenOtr", AV17Insert_ApliIIGGExenOtr);
            }
            else if ( GXutil.strcmp(AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AplIIGGCondicion") == 0 )
            {
               AV18Insert_AplIIGGCondicion = AV19TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18Insert_AplIIGGCondicion", AV18Insert_AplIIGGCondicion);
            }
            AV43GXV1 = (int)(AV43GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV43GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GXV1), 8, 0));
         }
      }
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtApliIIGGExenOtr_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtApliIIGGExenOtr_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtApliIIGGExenOtr_Visible), 5, 0), true);
   }

   public void e12372( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.tipoiiggrabarrelref(remoteHandle, context).execute( A3CliCod) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S142( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divApliigggrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
   }

   public void S132( )
   {
      /* 'LOADCOMBOAPLIIGGTOPECON' Routine */
      returnInSub = false ;
      Combo_apliiggtopecon_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"AplIIGGTopeCon\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"AplIIGG\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "DataListProcParametersPrefix", Combo_apliiggtopecon_Datalistprocparametersprefix);
      GXt_char6 = AV24Combo_DataJson ;
      GXv_char9[0] = AV22ComboSelectedValue ;
      GXv_char8[0] = AV23ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeCon", Gx_mode, false, AV7CliCod, AV8AplIIGG, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
      tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
      tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
      AV24Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
      Combo_apliiggtopecon_Selectedvalue_set = AV22ComboSelectedValue ;
      ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "SelectedValue_set", Combo_apliiggtopecon_Selectedvalue_set);
      Combo_apliiggtopecon_Selectedtext_set = AV23ComboSelectedText ;
      ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "SelectedText_set", Combo_apliiggtopecon_Selectedtext_set);
      AV39ComboAplIIGGTopeCon = AV22ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39ComboAplIIGGTopeCon", AV39ComboAplIIGGTopeCon);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_apliiggtopecon_Enabled = false ;
         ucCombo_apliiggtopecon.sendProperty(context, "", false, Combo_apliiggtopecon_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggtopecon_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOAPLIIGGTOPEVAR' Routine */
      returnInSub = false ;
      Combo_apliiggtopevar_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"AplIIGGTopeVar\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"AplIIGG\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "DataListProcParametersPrefix", Combo_apliiggtopevar_Datalistprocparametersprefix);
      GXt_char6 = AV24Combo_DataJson ;
      GXv_char9[0] = AV22ComboSelectedValue ;
      GXv_char8[0] = AV23ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGTopeVar", Gx_mode, false, AV7CliCod, AV8AplIIGG, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
      tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
      tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
      AV24Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
      Combo_apliiggtopevar_Selectedvalue_set = AV22ComboSelectedValue ;
      ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "SelectedValue_set", Combo_apliiggtopevar_Selectedvalue_set);
      Combo_apliiggtopevar_Selectedtext_set = AV23ComboSelectedText ;
      ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "SelectedText_set", Combo_apliiggtopevar_Selectedtext_set);
      AV27ComboAplIIGGTopeVar = AV22ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboAplIIGGTopeVar", AV27ComboAplIIGGTopeVar);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_apliiggtopevar_Enabled = false ;
         ucCombo_apliiggtopevar.sendProperty(context, "", false, Combo_apliiggtopevar_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggtopevar_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOAPLIIGGEXENCON' Routine */
      returnInSub = false ;
      Combo_apliiggexencon_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"AplIIGGExenCon\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"AplIIGG\": 0, \"Cond_CliCod\": \"#%1#\"", edtCliCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "DataListProcParametersPrefix", Combo_apliiggexencon_Datalistprocparametersprefix);
      GXt_char6 = AV24Combo_DataJson ;
      GXv_char9[0] = AV22ComboSelectedValue ;
      GXv_char8[0] = AV23ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new web.tipo_aplicacion_gananciasloaddvcombo(remoteHandle, context).execute( "AplIIGGExenCon", Gx_mode, false, AV7CliCod, AV8AplIIGG, A3CliCod, "", GXv_char9, GXv_char8, GXv_char7) ;
      tipo_aplicacion_ganancias_impl.this.AV22ComboSelectedValue = GXv_char9[0] ;
      tipo_aplicacion_ganancias_impl.this.AV23ComboSelectedText = GXv_char8[0] ;
      tipo_aplicacion_ganancias_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboSelectedValue", AV22ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSelectedText", AV23ComboSelectedText);
      AV24Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Combo_DataJson", AV24Combo_DataJson);
      Combo_apliiggexencon_Selectedvalue_set = AV22ComboSelectedValue ;
      ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "SelectedValue_set", Combo_apliiggexencon_Selectedvalue_set);
      Combo_apliiggexencon_Selectedtext_set = AV23ComboSelectedText ;
      ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "SelectedText_set", Combo_apliiggexencon_Selectedtext_set);
      AV31ComboAplIIGGExenCon = AV22ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31ComboAplIIGGExenCon", AV31ComboAplIIGGExenCon);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_apliiggexencon_Enabled = false ;
         ucCombo_apliiggexencon.sendProperty(context, "", false, Combo_apliiggexencon_Internalname, "Enabled", GXutil.booltostr( Combo_apliiggexencon_Enabled));
      }
   }

   public void zm37126( int GX_JID )
   {
      if ( ( GX_JID == 34 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1113AplIIGGNom = T00373_A1113AplIIGGNom[0] ;
            Z1120AplIIGGTrat = T00373_A1120AplIIGGTrat[0] ;
            Z1114AplIIGGPropor = T00373_A1114AplIIGGPropor[0] ;
            Z1115AplIIGGTopeTip = T00373_A1115AplIIGGTopeTip[0] ;
            Z1119AplIIGGTopeFij = T00373_A1119AplIIGGTopeFij[0] ;
            Z1121AplIIGGPrrtear = T00373_A1121AplIIGGPrrtear[0] ;
            Z1998AplIIGGgRelSec = T00373_A1998AplIIGGgRelSec[0] ;
            Z1999AplIIGGRelSecCli = T00373_A1999AplIIGGRelSecCli[0] ;
            Z2000AplIIGGPadre = T00373_A2000AplIIGGPadre[0] ;
            Z2020AplIIGGRelRef = T00373_A2020AplIIGGRelRef[0] ;
            Z1111AplIIGGTopeCon = T00373_A1111AplIIGGTopeCon[0] ;
            Z1117AplIIGGExenCon = T00373_A1117AplIIGGExenCon[0] ;
            Z1118ApliIIGGExenOtr = T00373_A1118ApliIIGGExenOtr[0] ;
            Z1109AplIIGGTopeVar = T00373_A1109AplIIGGTopeVar[0] ;
            Z1124AplIIGGCondicion = T00373_A1124AplIIGGCondicion[0] ;
         }
         else
         {
            Z1113AplIIGGNom = A1113AplIIGGNom ;
            Z1120AplIIGGTrat = A1120AplIIGGTrat ;
            Z1114AplIIGGPropor = A1114AplIIGGPropor ;
            Z1115AplIIGGTopeTip = A1115AplIIGGTopeTip ;
            Z1119AplIIGGTopeFij = A1119AplIIGGTopeFij ;
            Z1121AplIIGGPrrtear = A1121AplIIGGPrrtear ;
            Z1998AplIIGGgRelSec = A1998AplIIGGgRelSec ;
            Z1999AplIIGGRelSecCli = A1999AplIIGGRelSecCli ;
            Z2000AplIIGGPadre = A2000AplIIGGPadre ;
            Z2020AplIIGGRelRef = A2020AplIIGGRelRef ;
            Z1111AplIIGGTopeCon = A1111AplIIGGTopeCon ;
            Z1117AplIIGGExenCon = A1117AplIIGGExenCon ;
            Z1118ApliIIGGExenOtr = A1118ApliIIGGExenOtr ;
            Z1109AplIIGGTopeVar = A1109AplIIGGTopeVar ;
            Z1124AplIIGGCondicion = A1124AplIIGGCondicion ;
         }
      }
      if ( GX_JID == -34 )
      {
         Z1112AplIIGG = A1112AplIIGG ;
         Z1113AplIIGGNom = A1113AplIIGGNom ;
         Z1120AplIIGGTrat = A1120AplIIGGTrat ;
         Z1114AplIIGGPropor = A1114AplIIGGPropor ;
         Z1115AplIIGGTopeTip = A1115AplIIGGTopeTip ;
         Z1119AplIIGGTopeFij = A1119AplIIGGTopeFij ;
         Z1121AplIIGGPrrtear = A1121AplIIGGPrrtear ;
         Z1998AplIIGGgRelSec = A1998AplIIGGgRelSec ;
         Z1999AplIIGGRelSecCli = A1999AplIIGGRelSecCli ;
         Z2000AplIIGGPadre = A2000AplIIGGPadre ;
         Z2020AplIIGGRelRef = A2020AplIIGGRelRef ;
         Z2028AplIIGGOld = A2028AplIIGGOld ;
         Z3CliCod = A3CliCod ;
         Z1111AplIIGGTopeCon = A1111AplIIGGTopeCon ;
         Z1117AplIIGGExenCon = A1117AplIIGGExenCon ;
         Z1118ApliIIGGExenOtr = A1118ApliIIGGExenOtr ;
         Z1109AplIIGGTopeVar = A1109AplIIGGTopeVar ;
         Z1124AplIIGGCondicion = A1124AplIIGGCondicion ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaapliiggcondicion_html37126( AV7CliCod) ;
      gxaapliigggrelsec_html37126( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            tipo_aplicacion_ganancias_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynAplIIGGgRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGgRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynAplIIGGgRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8AplIIGG) )
      {
         A1112AplIIGG = AV8AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      if ( ! (0==AV8AplIIGG) )
      {
         edtAplIIGG_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      }
      else
      {
         edtAplIIGG_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8AplIIGG) )
      {
         edtAplIIGG_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_AplIIGGTopeVar)==0) )
      {
         edtAplIIGGTopeVar_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeVar_Enabled), 5, 0), true);
      }
      else
      {
         edtAplIIGGTopeVar_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeVar_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_AplIIGGTopeCon)==0) )
      {
         edtAplIIGGTopeCon_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeCon_Enabled), 5, 0), true);
      }
      else
      {
         edtAplIIGGTopeCon_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeCon_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_AplIIGGExenCon)==0) )
      {
         edtAplIIGGExenCon_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGExenCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGExenCon_Enabled), 5, 0), true);
      }
      else
      {
         edtAplIIGGExenCon_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGExenCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGExenCon_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_ApliIIGGExenOtr)==0) )
      {
         edtApliIIGGExenOtr_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtApliIIGGExenOtr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtApliIIGGExenOtr_Enabled), 5, 0), true);
      }
      else
      {
         edtApliIIGGExenOtr_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtApliIIGGExenOtr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtApliIIGGExenOtr_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV18Insert_AplIIGGCondicion)==0) )
      {
         dynAplIIGGCondicion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( dynAplIIGGCondicion.getEnabled(), 5, 0), true);
      }
      else
      {
         dynAplIIGGCondicion.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( dynAplIIGGCondicion.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV18Insert_AplIIGGCondicion)==0) )
      {
         A1124AplIIGGCondicion = AV18Insert_AplIIGGCondicion ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV17Insert_ApliIIGGExenOtr)==0) )
      {
         A1118ApliIIGGExenOtr = AV17Insert_ApliIIGGExenOtr ;
         n1118ApliIIGGExenOtr = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV16Insert_AplIIGGExenCon)==0) )
      {
         A1117AplIIGGExenCon = AV16Insert_AplIIGGExenCon ;
         n1117AplIIGGExenCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
      }
      else
      {
         if ( (GXutil.strcmp("", AV31ComboAplIIGGExenCon)==0) )
         {
            A1117AplIIGGExenCon = "" ;
            n1117AplIIGGExenCon = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
            n1117AplIIGGExenCon = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV31ComboAplIIGGExenCon)==0) )
            {
               A1117AplIIGGExenCon = AV31ComboAplIIGGExenCon ;
               n1117AplIIGGExenCon = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV14Insert_AplIIGGTopeVar)==0) )
      {
         A1109AplIIGGTopeVar = AV14Insert_AplIIGGTopeVar ;
         n1109AplIIGGTopeVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
      }
      else
      {
         if ( (GXutil.strcmp("", AV27ComboAplIIGGTopeVar)==0) )
         {
            A1109AplIIGGTopeVar = "" ;
            n1109AplIIGGTopeVar = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
            n1109AplIIGGTopeVar = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV27ComboAplIIGGTopeVar)==0) )
            {
               A1109AplIIGGTopeVar = AV27ComboAplIIGGTopeVar ;
               n1109AplIIGGTopeVar = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_AplIIGGTopeCon)==0) )
      {
         A1111AplIIGGTopeCon = AV15Insert_AplIIGGTopeCon ;
         n1111AplIIGGTopeCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
      }
      else
      {
         if ( (GXutil.strcmp("", AV39ComboAplIIGGTopeCon)==0) )
         {
            A1111AplIIGGTopeCon = "" ;
            n1111AplIIGGTopeCon = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
            n1111AplIIGGTopeCon = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV39ComboAplIIGGTopeCon)==0) )
            {
               A1111AplIIGGTopeCon = AV39ComboAplIIGGTopeCon ;
               n1111AplIIGGTopeCon = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
            }
         }
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV42Pgmname = "tipo_aplicacion_ganancias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42Pgmname", AV42Pgmname);
      }
   }

   public void load37126( )
   {
      /* Using cursor T003710 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound126 = (short)(1) ;
         A1113AplIIGGNom = T003710_A1113AplIIGGNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
         A1120AplIIGGTrat = T003710_A1120AplIIGGTrat[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
         A1114AplIIGGPropor = T003710_A1114AplIIGGPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
         A1115AplIIGGTopeTip = T003710_A1115AplIIGGTopeTip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
         A1119AplIIGGTopeFij = T003710_A1119AplIIGGTopeFij[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
         A1121AplIIGGPrrtear = T003710_A1121AplIIGGPrrtear[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
         A1998AplIIGGgRelSec = T003710_A1998AplIIGGgRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
         A1999AplIIGGRelSecCli = T003710_A1999AplIIGGRelSecCli[0] ;
         A2000AplIIGGPadre = T003710_A2000AplIIGGPadre[0] ;
         A2020AplIIGGRelRef = T003710_A2020AplIIGGRelRef[0] ;
         A2028AplIIGGOld = T003710_A2028AplIIGGOld[0] ;
         A1111AplIIGGTopeCon = T003710_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = T003710_n1111AplIIGGTopeCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
         A1117AplIIGGExenCon = T003710_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = T003710_n1117AplIIGGExenCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
         A1118ApliIIGGExenOtr = T003710_A1118ApliIIGGExenOtr[0] ;
         n1118ApliIIGGExenOtr = T003710_n1118ApliIIGGExenOtr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
         A1109AplIIGGTopeVar = T003710_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = T003710_n1109AplIIGGTopeVar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
         A1124AplIIGGCondicion = T003710_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = T003710_n1124AplIIGGCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
         zm37126( -34) ;
      }
      pr_default.close(8);
      onLoadActions37126( ) ;
   }

   public void onLoadActions37126( )
   {
      AV42Pgmname = "tipo_aplicacion_ganancias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42Pgmname", AV42Pgmname);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) )
      {
         divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) )
         {
            divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable37126( )
   {
      nIsDirty_126 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV42Pgmname = "tipo_aplicacion_ganancias" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42Pgmname", AV42Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV41aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1998AplIIGGgRelSec, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.AV41aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41aplicadoHay", AV41aplicadoHay);
      }
      /* Using cursor T00374 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T00375 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGConc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPECON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      /* Using cursor T00376 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1117AplIIGGExenCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGCon Exen Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGEXENCON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(4);
      /* Using cursor T00377 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGOtros Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIIGGEXENOTR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(5);
      /* Using cursor T00378 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGOpe Cli", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPEVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(6);
      /* Using cursor T00379 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1124AplIIGGCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "APl IIGGCond Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(7);
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) )
      {
         divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) )
         {
            divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
         }
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) && (0==A1998AplIIGGgRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "APLIIGG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtAplIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1120AplIIGGTrat == 1 ) || ( A1120AplIIGGTrat == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tratamiento específico", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "APLIIGGTRAT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAplIIGGTrat.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A1115AplIIGGTopeTip == 1 ) || ( A1115AplIIGGTopeTip == 2 ) || ( A1115AplIIGGTopeTip == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tope", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "APLIIGGTOPETIP");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAplIIGGTopeTip.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1121AplIIGGPrrtear, "SIN") == 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, "FIJA") == 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, "VAR") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de cuota", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "APLIIGGPRRTEAR");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbAplIIGGPrrtear.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors37126( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(7);
   }

   public void enableDisable( )
   {
   }

   public void gxload_35( int A3CliCod )
   {
      /* Using cursor T003711 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_36( int A3CliCod ,
                          String A1111AplIIGGTopeCon )
   {
      /* Using cursor T003712 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon});
      if ( (pr_default.getStatus(10) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGConc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPECON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_37( int A3CliCod ,
                          String A1117AplIIGGExenCon )
   {
      /* Using cursor T003713 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1117AplIIGGExenCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGCon Exen Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGEXENCON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_38( int A3CliCod ,
                          String A1118ApliIIGGExenOtr )
   {
      /* Using cursor T003714 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGOtros Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIIGGEXENOTR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_39( int A3CliCod ,
                          String A1109AplIIGGTopeVar )
   {
      /* Using cursor T003715 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGOpe Cli", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPEVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_40( int A3CliCod ,
                          String A1124AplIIGGCondicion )
   {
      /* Using cursor T003716 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1124AplIIGGCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "APl IIGGCond Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey37126( )
   {
      /* Using cursor T003717 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound126 = (short)(1) ;
      }
      else
      {
         RcdFound126 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00373 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm37126( 34) ;
         RcdFound126 = (short)(1) ;
         A1112AplIIGG = T00373_A1112AplIIGG[0] ;
         n1112AplIIGG = T00373_n1112AplIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         A1113AplIIGGNom = T00373_A1113AplIIGGNom[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
         A1120AplIIGGTrat = T00373_A1120AplIIGGTrat[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
         A1114AplIIGGPropor = T00373_A1114AplIIGGPropor[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
         A1115AplIIGGTopeTip = T00373_A1115AplIIGGTopeTip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
         A1119AplIIGGTopeFij = T00373_A1119AplIIGGTopeFij[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
         A1121AplIIGGPrrtear = T00373_A1121AplIIGGPrrtear[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
         A1998AplIIGGgRelSec = T00373_A1998AplIIGGgRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
         A1999AplIIGGRelSecCli = T00373_A1999AplIIGGRelSecCli[0] ;
         A2000AplIIGGPadre = T00373_A2000AplIIGGPadre[0] ;
         A2020AplIIGGRelRef = T00373_A2020AplIIGGRelRef[0] ;
         A2028AplIIGGOld = T00373_A2028AplIIGGOld[0] ;
         A3CliCod = T00373_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1111AplIIGGTopeCon = T00373_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = T00373_n1111AplIIGGTopeCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
         A1117AplIIGGExenCon = T00373_A1117AplIIGGExenCon[0] ;
         n1117AplIIGGExenCon = T00373_n1117AplIIGGExenCon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
         A1118ApliIIGGExenOtr = T00373_A1118ApliIIGGExenOtr[0] ;
         n1118ApliIIGGExenOtr = T00373_n1118ApliIIGGExenOtr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
         A1109AplIIGGTopeVar = T00373_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = T00373_n1109AplIIGGTopeVar[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
         A1124AplIIGGCondicion = T00373_A1124AplIIGGCondicion[0] ;
         n1124AplIIGGCondicion = T00373_n1124AplIIGGCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
         O1124AplIIGGCondicion = A1124AplIIGGCondicion ;
         n1124AplIIGGCondicion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
         O1119AplIIGGTopeFij = A1119AplIIGGTopeFij ;
         httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
         O1111AplIIGGTopeCon = A1111AplIIGGTopeCon ;
         n1111AplIIGGTopeCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
         O1109AplIIGGTopeVar = A1109AplIIGGTopeVar ;
         n1109AplIIGGTopeVar = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
         O1115AplIIGGTopeTip = A1115AplIIGGTopeTip ;
         httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
         O1121AplIIGGPrrtear = A1121AplIIGGPrrtear ;
         httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
         O1117AplIIGGExenCon = A1117AplIIGGExenCon ;
         n1117AplIIGGExenCon = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
         O1114AplIIGGPropor = A1114AplIIGGPropor ;
         httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
         O1120AplIIGGTrat = A1120AplIIGGTrat ;
         httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
         O1113AplIIGGNom = A1113AplIIGGNom ;
         httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
         O1112AplIIGG = A1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1112AplIIGG = A1112AplIIGG ;
         sMode126 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load37126( ) ;
         if ( AnyError == 1 )
         {
            RcdFound126 = (short)(0) ;
            initializeNonKey37126( ) ;
         }
         Gx_mode = sMode126 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound126 = (short)(0) ;
         initializeNonKey37126( ) ;
         sMode126 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode126 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey37126( ) ;
      if ( RcdFound126 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound126 = (short)(0) ;
      /* Using cursor T003718 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T003718_A3CliCod[0] < A3CliCod ) || ( T003718_A3CliCod[0] == A3CliCod ) && ( T003718_A1112AplIIGG[0] < A1112AplIIGG ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T003718_A3CliCod[0] > A3CliCod ) || ( T003718_A3CliCod[0] == A3CliCod ) && ( T003718_A1112AplIIGG[0] > A1112AplIIGG ) ) )
         {
            A3CliCod = T003718_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1112AplIIGG = T003718_A1112AplIIGG[0] ;
            n1112AplIIGG = T003718_n1112AplIIGG[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            RcdFound126 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound126 = (short)(0) ;
      /* Using cursor T003719 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T003719_A3CliCod[0] > A3CliCod ) || ( T003719_A3CliCod[0] == A3CliCod ) && ( T003719_A1112AplIIGG[0] > A1112AplIIGG ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T003719_A3CliCod[0] < A3CliCod ) || ( T003719_A3CliCod[0] == A3CliCod ) && ( T003719_A1112AplIIGG[0] < A1112AplIIGG ) ) )
         {
            A3CliCod = T003719_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1112AplIIGG = T003719_A1112AplIIGG[0] ;
            n1112AplIIGG = T003719_n1112AplIIGG[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
            RcdFound126 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey37126( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtAplIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert37126( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound126 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1112AplIIGG != Z1112AplIIGG ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1112AplIIGG = Z1112AplIIGG ;
               n1112AplIIGG = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtAplIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update37126( ) ;
               GX_FocusControl = edtAplIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1112AplIIGG != Z1112AplIIGG ) )
            {
               /* Insert record */
               GX_FocusControl = edtAplIIGG_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert37126( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtAplIIGG_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert37126( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1112AplIIGG != Z1112AplIIGG ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = Z1112AplIIGG ;
         n1112AplIIGG = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtAplIIGG_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency37126( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00372 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_aplicacion_ganancias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1113AplIIGGNom, T00372_A1113AplIIGGNom[0]) != 0 ) || ( Z1120AplIIGGTrat != T00372_A1120AplIIGGTrat[0] ) || ( DecimalUtil.compareTo(Z1114AplIIGGPropor, T00372_A1114AplIIGGPropor[0]) != 0 ) || ( Z1115AplIIGGTopeTip != T00372_A1115AplIIGGTopeTip[0] ) || ( DecimalUtil.compareTo(Z1119AplIIGGTopeFij, T00372_A1119AplIIGGTopeFij[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1121AplIIGGPrrtear, T00372_A1121AplIIGGPrrtear[0]) != 0 ) || ( Z1998AplIIGGgRelSec != T00372_A1998AplIIGGgRelSec[0] ) || ( Z1999AplIIGGRelSecCli != T00372_A1999AplIIGGRelSecCli[0] ) || ( Z2000AplIIGGPadre != T00372_A2000AplIIGGPadre[0] ) || ( GXutil.strcmp(Z2020AplIIGGRelRef, T00372_A2020AplIIGGRelRef[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1111AplIIGGTopeCon, T00372_A1111AplIIGGTopeCon[0]) != 0 ) || ( GXutil.strcmp(Z1117AplIIGGExenCon, T00372_A1117AplIIGGExenCon[0]) != 0 ) || ( GXutil.strcmp(Z1118ApliIIGGExenOtr, T00372_A1118ApliIIGGExenOtr[0]) != 0 ) || ( GXutil.strcmp(Z1109AplIIGGTopeVar, T00372_A1109AplIIGGTopeVar[0]) != 0 ) || ( GXutil.strcmp(Z1124AplIIGGCondicion, T00372_A1124AplIIGGCondicion[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z1113AplIIGGNom, T00372_A1113AplIIGGNom[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGNom");
               GXutil.writeLogRaw("Old: ",Z1113AplIIGGNom);
               GXutil.writeLogRaw("Current: ",T00372_A1113AplIIGGNom[0]);
            }
            if ( Z1120AplIIGGTrat != T00372_A1120AplIIGGTrat[0] )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGTrat");
               GXutil.writeLogRaw("Old: ",Z1120AplIIGGTrat);
               GXutil.writeLogRaw("Current: ",T00372_A1120AplIIGGTrat[0]);
            }
            if ( DecimalUtil.compareTo(Z1114AplIIGGPropor, T00372_A1114AplIIGGPropor[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGPropor");
               GXutil.writeLogRaw("Old: ",Z1114AplIIGGPropor);
               GXutil.writeLogRaw("Current: ",T00372_A1114AplIIGGPropor[0]);
            }
            if ( Z1115AplIIGGTopeTip != T00372_A1115AplIIGGTopeTip[0] )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGTopeTip");
               GXutil.writeLogRaw("Old: ",Z1115AplIIGGTopeTip);
               GXutil.writeLogRaw("Current: ",T00372_A1115AplIIGGTopeTip[0]);
            }
            if ( DecimalUtil.compareTo(Z1119AplIIGGTopeFij, T00372_A1119AplIIGGTopeFij[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGTopeFij");
               GXutil.writeLogRaw("Old: ",Z1119AplIIGGTopeFij);
               GXutil.writeLogRaw("Current: ",T00372_A1119AplIIGGTopeFij[0]);
            }
            if ( GXutil.strcmp(Z1121AplIIGGPrrtear, T00372_A1121AplIIGGPrrtear[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGPrrtear");
               GXutil.writeLogRaw("Old: ",Z1121AplIIGGPrrtear);
               GXutil.writeLogRaw("Current: ",T00372_A1121AplIIGGPrrtear[0]);
            }
            if ( Z1998AplIIGGgRelSec != T00372_A1998AplIIGGgRelSec[0] )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGgRelSec");
               GXutil.writeLogRaw("Old: ",Z1998AplIIGGgRelSec);
               GXutil.writeLogRaw("Current: ",T00372_A1998AplIIGGgRelSec[0]);
            }
            if ( Z1999AplIIGGRelSecCli != T00372_A1999AplIIGGRelSecCli[0] )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1999AplIIGGRelSecCli);
               GXutil.writeLogRaw("Current: ",T00372_A1999AplIIGGRelSecCli[0]);
            }
            if ( Z2000AplIIGGPadre != T00372_A2000AplIIGGPadre[0] )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGPadre");
               GXutil.writeLogRaw("Old: ",Z2000AplIIGGPadre);
               GXutil.writeLogRaw("Current: ",T00372_A2000AplIIGGPadre[0]);
            }
            if ( GXutil.strcmp(Z2020AplIIGGRelRef, T00372_A2020AplIIGGRelRef[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGRelRef");
               GXutil.writeLogRaw("Old: ",Z2020AplIIGGRelRef);
               GXutil.writeLogRaw("Current: ",T00372_A2020AplIIGGRelRef[0]);
            }
            if ( GXutil.strcmp(Z1111AplIIGGTopeCon, T00372_A1111AplIIGGTopeCon[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGTopeCon");
               GXutil.writeLogRaw("Old: ",Z1111AplIIGGTopeCon);
               GXutil.writeLogRaw("Current: ",T00372_A1111AplIIGGTopeCon[0]);
            }
            if ( GXutil.strcmp(Z1117AplIIGGExenCon, T00372_A1117AplIIGGExenCon[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGExenCon");
               GXutil.writeLogRaw("Old: ",Z1117AplIIGGExenCon);
               GXutil.writeLogRaw("Current: ",T00372_A1117AplIIGGExenCon[0]);
            }
            if ( GXutil.strcmp(Z1118ApliIIGGExenOtr, T00372_A1118ApliIIGGExenOtr[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"ApliIIGGExenOtr");
               GXutil.writeLogRaw("Old: ",Z1118ApliIIGGExenOtr);
               GXutil.writeLogRaw("Current: ",T00372_A1118ApliIIGGExenOtr[0]);
            }
            if ( GXutil.strcmp(Z1109AplIIGGTopeVar, T00372_A1109AplIIGGTopeVar[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGTopeVar");
               GXutil.writeLogRaw("Old: ",Z1109AplIIGGTopeVar);
               GXutil.writeLogRaw("Current: ",T00372_A1109AplIIGGTopeVar[0]);
            }
            if ( GXutil.strcmp(Z1124AplIIGGCondicion, T00372_A1124AplIIGGCondicion[0]) != 0 )
            {
               GXutil.writeLogln("tipo_aplicacion_ganancias:[seudo value changed for attri]"+"AplIIGGCondicion");
               GXutil.writeLogRaw("Old: ",Z1124AplIIGGCondicion);
               GXutil.writeLogRaw("Current: ",T00372_A1124AplIIGGCondicion[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"tipo_aplicacion_ganancias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert37126( )
   {
      beforeValidate37126( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable37126( ) ;
      }
      if ( AnyError == 0 )
      {
         zm37126( 0) ;
         checkOptimisticConcurrency37126( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm37126( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert37126( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003720 */
                  pr_default.execute(18, new Object[] {Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG), A1113AplIIGGNom, Byte.valueOf(A1120AplIIGGTrat), A1114AplIIGGPropor, Byte.valueOf(A1115AplIIGGTopeTip), A1119AplIIGGTopeFij, A1121AplIIGGPrrtear, Integer.valueOf(A1998AplIIGGgRelSec), Integer.valueOf(A1999AplIIGGRelSecCli), Short.valueOf(A2000AplIIGGPadre), A2020AplIIGGRelRef, A2028AplIIGGOld, Integer.valueOf(A3CliCod), Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon, Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon, Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr, Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar, Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_aplicacion_ganancias");
                  if ( (pr_default.getStatus(18) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption370( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load37126( ) ;
         }
         endLevel37126( ) ;
      }
      closeExtendedTableCursors37126( ) ;
   }

   public void update37126( )
   {
      beforeValidate37126( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable37126( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency37126( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm37126( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate37126( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T003721 */
                  pr_default.execute(19, new Object[] {A1113AplIIGGNom, Byte.valueOf(A1120AplIIGGTrat), A1114AplIIGGPropor, Byte.valueOf(A1115AplIIGGTopeTip), A1119AplIIGGTopeFij, A1121AplIIGGPrrtear, Integer.valueOf(A1998AplIIGGgRelSec), Integer.valueOf(A1999AplIIGGRelSecCli), Short.valueOf(A2000AplIIGGPadre), A2020AplIIGGRelRef, A2028AplIIGGOld, Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon, Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon, Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr, Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar, Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion, Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_aplicacion_ganancias");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"tipo_aplicacion_ganancias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate37126( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel37126( ) ;
      }
      closeExtendedTableCursors37126( ) ;
   }

   public void deferredUpdate37126( )
   {
   }

   public void delete( )
   {
      beforeValidate37126( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency37126( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls37126( ) ;
         afterConfirm37126( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete37126( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T003722 */
               pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_aplicacion_ganancias");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode126 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel37126( ) ;
      Gx_mode = sMode126 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls37126( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV41aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1998AplIIGGgRelSec, GXv_boolean5) ;
            tipo_aplicacion_ganancias_impl.this.AV41aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41aplicadoHay", AV41aplicadoHay);
         }
         AV42Pgmname = "tipo_aplicacion_ganancias" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42Pgmname", AV42Pgmname);
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) )
         {
            divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean4 = false ;
            GXv_boolean5[0] = GXt_boolean4 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
            tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
            if ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) )
            {
               divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T003723 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "liquidacion_exencion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T003724 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T003725 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T003726 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T003727 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor T003728 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T003729 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor T003730 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T003731 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T003732 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T003733 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T003734 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T003735 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T003736 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T003737 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T003738 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor T003739 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor T003740 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor T003741 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor T003742 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor T003743 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor T003744 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor T003745 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor T003746 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T003747 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor T003748 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor T003749 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor T003750 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor T003751 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor T003752 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor T003753 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor T003754 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor T003755 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor T003756 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor T003757 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
         /* Using cursor T003758 */
         pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(56) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(56);
         /* Using cursor T003759 */
         pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(57) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(57);
         /* Using cursor T003760 */
         pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(58) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(58);
         /* Using cursor T003761 */
         pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(59) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(59);
         /* Using cursor T003762 */
         pr_default.execute(60, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(60) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(60);
         /* Using cursor T003763 */
         pr_default.execute(61, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(61) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(61);
         /* Using cursor T003764 */
         pr_default.execute(62, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(62) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(62);
         /* Using cursor T003765 */
         pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(63) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(63);
         /* Using cursor T003766 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor T003767 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor T003768 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor T003769 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor T003770 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor T003771 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor T003772 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor T003773 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor T003774 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor T003775 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor T003776 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor T003777 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor T003778 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor T003779 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor T003780 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1112AplIIGG), Short.valueOf(A1112AplIIGG)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
      }
   }

   public void endLevel37126( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete37126( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "tipo_aplicacion_ganancias");
         if ( AnyError == 0 )
         {
            confirmValues370( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "tipo_aplicacion_ganancias");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart37126( )
   {
      /* Scan By routine */
      /* Using cursor T003781 */
      pr_default.execute(79);
      RcdFound126 = (short)(0) ;
      if ( (pr_default.getStatus(79) != 101) )
      {
         RcdFound126 = (short)(1) ;
         A3CliCod = T003781_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = T003781_A1112AplIIGG[0] ;
         n1112AplIIGG = T003781_n1112AplIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext37126( )
   {
      /* Scan next routine */
      pr_default.readNext(79);
      RcdFound126 = (short)(0) ;
      if ( (pr_default.getStatus(79) != 101) )
      {
         RcdFound126 = (short)(1) ;
         A3CliCod = T003781_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1112AplIIGG = T003781_A1112AplIIGG[0] ;
         n1112AplIIGG = T003781_n1112AplIIGG[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      }
   }

   public void scanEnd37126( )
   {
      pr_default.close(79);
   }

   public void afterConfirm37126( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV41aplicadoHay ) && ! (0==A1998AplIIGGgRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "AplIIGGgRelSec", 1, "APLIIGGGRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynAplIIGGgRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert37126( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate37126( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete37126( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete37126( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate37126( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes37126( )
   {
      edtAplIIGG_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGG_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGG_Enabled), 5, 0), true);
      edtAplIIGGNom_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGNom_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGNom_Enabled), 5, 0), true);
      cmbAplIIGGTrat.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTrat.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAplIIGGTrat.getEnabled(), 5, 0), true);
      edtAplIIGGPropor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGPropor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGPropor_Enabled), 5, 0), true);
      edtAplIIGGExenCon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGExenCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGExenCon_Enabled), 5, 0), true);
      cmbAplIIGGPrrtear.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGPrrtear.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAplIIGGPrrtear.getEnabled(), 5, 0), true);
      dynAplIIGGCondicion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGCondicion.getInternalname(), "Enabled", GXutil.ltrimstr( dynAplIIGGCondicion.getEnabled(), 5, 0), true);
      cmbAplIIGGTopeTip.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbAplIIGGTopeTip.getInternalname(), "Enabled", GXutil.ltrimstr( cmbAplIIGGTopeTip.getEnabled(), 5, 0), true);
      edtAplIIGGTopeVar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeVar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeVar_Enabled), 5, 0), true);
      edtAplIIGGTopeCon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeCon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeCon_Enabled), 5, 0), true);
      edtAplIIGGTopeFij_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAplIIGGTopeFij_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAplIIGGTopeFij_Enabled), 5, 0), true);
      dynAplIIGGgRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGgRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynAplIIGGgRelSec.getEnabled(), 5, 0), true);
      edtavComboapliiggexencon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggexencon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggexencon_Enabled), 5, 0), true);
      edtavComboapliiggtopevar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopevar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopevar_Enabled), 5, 0), true);
      edtavComboapliiggtopecon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboapliiggtopecon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboapliiggtopecon_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtApliIIGGExenOtr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtApliIIGGExenOtr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtApliIIGGExenOtr_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes37126( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues370( )
   {
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
      MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.tipo_aplicacion_ganancias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8AplIIGG,4,0))}, new String[] {"Gx_mode","CliCod","AplIIGG"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"tipo_aplicacion_ganancias");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("AplIIGGRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1999AplIIGGRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("AplIIGGPadre", localUtil.format( DecimalUtil.doubleToDec(A2000AplIIGGPadre), "ZZZ9"));
      forbiddenHiddens.add("AplIIGGRelRef", GXutil.rtrim( localUtil.format( A2020AplIIGGRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("tipo_aplicacion_ganancias:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1112AplIIGG", GXutil.ltrim( localUtil.ntoc( Z1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1113AplIIGGNom", Z1113AplIIGGNom);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1120AplIIGGTrat", GXutil.ltrim( localUtil.ntoc( Z1120AplIIGGTrat, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1114AplIIGGPropor", GXutil.ltrim( localUtil.ntoc( Z1114AplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1115AplIIGGTopeTip", GXutil.ltrim( localUtil.ntoc( Z1115AplIIGGTopeTip, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1119AplIIGGTopeFij", GXutil.ltrim( localUtil.ntoc( Z1119AplIIGGTopeFij, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1121AplIIGGPrrtear", GXutil.rtrim( Z1121AplIIGGPrrtear));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1998AplIIGGgRelSec", GXutil.ltrim( localUtil.ntoc( Z1998AplIIGGgRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1999AplIIGGRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1999AplIIGGRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2000AplIIGGPadre", GXutil.ltrim( localUtil.ntoc( Z2000AplIIGGPadre, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2020AplIIGGRelRef", Z2020AplIIGGRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1111AplIIGGTopeCon", GXutil.rtrim( Z1111AplIIGGTopeCon));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1117AplIIGGExenCon", GXutil.rtrim( Z1117AplIIGGExenCon));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1118ApliIIGGExenOtr", GXutil.rtrim( Z1118ApliIIGGExenOtr));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1109AplIIGGTopeVar", GXutil.rtrim( Z1109AplIIGGTopeVar));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1124AplIIGGCondicion", GXutil.rtrim( Z1124AplIIGGCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "O1124AplIIGGCondicion", GXutil.rtrim( O1124AplIIGGCondicion));
      web.GxWebStd.gx_hidden_field( httpContext, "O1119AplIIGGTopeFij", GXutil.ltrim( localUtil.ntoc( O1119AplIIGGTopeFij, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1111AplIIGGTopeCon", GXutil.rtrim( O1111AplIIGGTopeCon));
      web.GxWebStd.gx_hidden_field( httpContext, "O1109AplIIGGTopeVar", GXutil.rtrim( O1109AplIIGGTopeVar));
      web.GxWebStd.gx_hidden_field( httpContext, "O1115AplIIGGTopeTip", GXutil.ltrim( localUtil.ntoc( O1115AplIIGGTopeTip, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1121AplIIGGPrrtear", GXutil.rtrim( O1121AplIIGGPrrtear));
      web.GxWebStd.gx_hidden_field( httpContext, "O1117AplIIGGExenCon", GXutil.rtrim( O1117AplIIGGExenCon));
      web.GxWebStd.gx_hidden_field( httpContext, "O1114AplIIGGPropor", GXutil.ltrim( localUtil.ntoc( O1114AplIIGGPropor, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1120AplIIGGTrat", GXutil.ltrim( localUtil.ntoc( O1120AplIIGGTrat, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1113AplIIGGNom", O1113AplIIGGNom);
      web.GxWebStd.gx_hidden_field( httpContext, "O1112AplIIGG", GXutil.ltrim( localUtil.ntoc( O1112AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N1109AplIIGGTopeVar", GXutil.rtrim( A1109AplIIGGTopeVar));
      web.GxWebStd.gx_hidden_field( httpContext, "N1111AplIIGGTopeCon", GXutil.rtrim( A1111AplIIGGTopeCon));
      web.GxWebStd.gx_hidden_field( httpContext, "N1117AplIIGGExenCon", GXutil.rtrim( A1117AplIIGGExenCon));
      web.GxWebStd.gx_hidden_field( httpContext, "N1118ApliIIGGExenOtr", GXutil.rtrim( A1118ApliIIGGExenOtr));
      web.GxWebStd.gx_hidden_field( httpContext, "N1124AplIIGGCondicion", GXutil.rtrim( A1124AplIIGGCondicion));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAPLIIGGEXENCON_DATA", AV30AplIIGGExenCon_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAPLIIGGEXENCON_DATA", AV30AplIIGGExenCon_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAPLIIGGTOPEVAR_DATA", AV26AplIIGGTopeVar_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAPLIIGGTOPEVAR_DATA", AV26AplIIGGTopeVar_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAPLIIGGTOPECON_DATA", AV38AplIIGGTopeCon_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAPLIIGGTOPECON_DATA", AV38AplIIGGTopeCon_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAPLIIGG", GXutil.ltrim( localUtil.ntoc( AV8AplIIGG, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPLIIGG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8AplIIGG), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGGTOPEVAR", GXutil.rtrim( AV14Insert_AplIIGGTopeVar));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGGTOPECON", GXutil.rtrim( AV15Insert_AplIIGGTopeCon));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGGEXENCON", GXutil.rtrim( AV16Insert_AplIIGGExenCon));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIIGGEXENOTR", GXutil.rtrim( AV17Insert_ApliIIGGExenOtr));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_APLIIGGCONDICION", GXutil.rtrim( AV18Insert_AplIIGGCondicion));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV41aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "APLIIGGRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1999AplIIGGRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "APLIIGGPADRE", GXutil.ltrim( localUtil.ntoc( A2000AplIIGGPadre, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "APLIIGGRELREF", A2020AplIIGGRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "APLIIGGOLD", A2028AplIIGGOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV42Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Objectcall", GXutil.rtrim( Combo_apliiggexencon_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Cls", GXutil.rtrim( Combo_apliiggexencon_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Selectedvalue_set", GXutil.rtrim( Combo_apliiggexencon_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Selectedtext_set", GXutil.rtrim( Combo_apliiggexencon_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Enabled", GXutil.booltostr( Combo_apliiggexencon_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Datalistproc", GXutil.rtrim( Combo_apliiggexencon_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGEXENCON_Datalistprocparametersprefix", GXutil.rtrim( Combo_apliiggexencon_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Objectcall", GXutil.rtrim( Combo_apliiggtopevar_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Cls", GXutil.rtrim( Combo_apliiggtopevar_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Selectedvalue_set", GXutil.rtrim( Combo_apliiggtopevar_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Selectedtext_set", GXutil.rtrim( Combo_apliiggtopevar_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Enabled", GXutil.booltostr( Combo_apliiggtopevar_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Datalistproc", GXutil.rtrim( Combo_apliiggtopevar_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPEVAR_Datalistprocparametersprefix", GXutil.rtrim( Combo_apliiggtopevar_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Objectcall", GXutil.rtrim( Combo_apliiggtopecon_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Cls", GXutil.rtrim( Combo_apliiggtopecon_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Selectedvalue_set", GXutil.rtrim( Combo_apliiggtopecon_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Selectedtext_set", GXutil.rtrim( Combo_apliiggtopecon_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Enabled", GXutil.booltostr( Combo_apliiggtopecon_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Datalistproc", GXutil.rtrim( Combo_apliiggtopecon_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_APLIIGGTOPECON_Datalistprocparametersprefix", GXutil.rtrim( Combo_apliiggtopecon_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
      httpContext.writeTextNL( "</form>") ;
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.tipo_aplicacion_ganancias", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8AplIIGG,4,0))}, new String[] {"Gx_mode","CliCod","AplIIGG"})  ;
   }

   public String getPgmname( )
   {
      return "tipo_aplicacion_ganancias" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "tipo_aplicacion_ganancias", "") ;
   }

   public void initializeNonKey37126( )
   {
      A1109AplIIGGTopeVar = "" ;
      n1109AplIIGGTopeVar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
      n1109AplIIGGTopeVar = ((GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ? true : false) ;
      A1111AplIIGGTopeCon = "" ;
      n1111AplIIGGTopeCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
      n1111AplIIGGTopeCon = ((GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ? true : false) ;
      A1117AplIIGGExenCon = "" ;
      n1117AplIIGGExenCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
      n1117AplIIGGExenCon = ((GXutil.strcmp("", A1117AplIIGGExenCon)==0) ? true : false) ;
      A1118ApliIIGGExenOtr = "" ;
      n1118ApliIIGGExenOtr = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1118ApliIIGGExenOtr", A1118ApliIIGGExenOtr);
      n1118ApliIIGGExenOtr = ((GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ? true : false) ;
      A1124AplIIGGCondicion = "" ;
      n1124AplIIGGCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
      n1124AplIIGGCondicion = ((GXutil.strcmp("", A1124AplIIGGCondicion)==0) ? true : false) ;
      AV41aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41aplicadoHay", AV41aplicadoHay);
      A1113AplIIGGNom = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
      A1120AplIIGGTrat = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
      A1115AplIIGGTopeTip = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
      A1121AplIIGGPrrtear = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
      A1998AplIIGGgRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1998AplIIGGgRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1998AplIIGGgRelSec), 6, 0));
      A1999AplIIGGRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1999AplIIGGRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1999AplIIGGRelSecCli), 6, 0));
      A2000AplIIGGPadre = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2000AplIIGGPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2000AplIIGGPadre), 4, 0));
      A2020AplIIGGRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2020AplIIGGRelRef", A2020AplIIGGRelRef);
      A2028AplIIGGOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2028AplIIGGOld", A2028AplIIGGOld);
      O1124AplIIGGCondicion = A1124AplIIGGCondicion ;
      n1124AplIIGGCondicion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1124AplIIGGCondicion", A1124AplIIGGCondicion);
      O1119AplIIGGTopeFij = A1119AplIIGGTopeFij ;
      httpContext.ajax_rsp_assign_attri("", false, "A1119AplIIGGTopeFij", GXutil.ltrimstr( A1119AplIIGGTopeFij, 14, 2));
      O1111AplIIGGTopeCon = A1111AplIIGGTopeCon ;
      n1111AplIIGGTopeCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1111AplIIGGTopeCon", A1111AplIIGGTopeCon);
      O1109AplIIGGTopeVar = A1109AplIIGGTopeVar ;
      n1109AplIIGGTopeVar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1109AplIIGGTopeVar", A1109AplIIGGTopeVar);
      O1115AplIIGGTopeTip = A1115AplIIGGTopeTip ;
      httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
      O1121AplIIGGPrrtear = A1121AplIIGGPrrtear ;
      httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
      O1117AplIIGGExenCon = A1117AplIIGGExenCon ;
      n1117AplIIGGExenCon = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1117AplIIGGExenCon", A1117AplIIGGExenCon);
      O1114AplIIGGPropor = A1114AplIIGGPropor ;
      httpContext.ajax_rsp_assign_attri("", false, "A1114AplIIGGPropor", GXutil.ltrimstr( A1114AplIIGGPropor, 6, 4));
      O1120AplIIGGTrat = A1120AplIIGGTrat ;
      httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
      O1113AplIIGGNom = A1113AplIIGGNom ;
      httpContext.ajax_rsp_assign_attri("", false, "A1113AplIIGGNom", A1113AplIIGGNom);
      Z1113AplIIGGNom = "" ;
      Z1120AplIIGGTrat = (byte)(0) ;
      Z1114AplIIGGPropor = DecimalUtil.ZERO ;
      Z1115AplIIGGTopeTip = (byte)(0) ;
      Z1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      Z1121AplIIGGPrrtear = "" ;
      Z1998AplIIGGgRelSec = 0 ;
      Z1999AplIIGGRelSecCli = 0 ;
      Z2000AplIIGGPadre = (short)(0) ;
      Z2020AplIIGGRelRef = "" ;
      Z1111AplIIGGTopeCon = "" ;
      Z1117AplIIGGExenCon = "" ;
      Z1118ApliIIGGExenOtr = "" ;
      Z1109AplIIGGTopeVar = "" ;
      Z1124AplIIGGCondicion = "" ;
   }

   public void initAll37126( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1112AplIIGG = (short)(0) ;
      n1112AplIIGG = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1112AplIIGG", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1112AplIIGG), 4, 0));
      initializeNonKey37126( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181781791", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("tipo_aplicacion_ganancias.js", "?2025181781791", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtAplIIGG_Internalname = "APLIIGG" ;
      edtAplIIGGNom_Internalname = "APLIIGGNOM" ;
      cmbAplIIGGTrat.setInternalname( "APLIIGGTRAT" );
      edtAplIIGGPropor_Internalname = "APLIIGGPROPOR" ;
      lblTextblockapliiggexencon_Internalname = "TEXTBLOCKAPLIIGGEXENCON" ;
      Combo_apliiggexencon_Internalname = "COMBO_APLIIGGEXENCON" ;
      edtAplIIGGExenCon_Internalname = "APLIIGGEXENCON" ;
      divTablesplittedapliiggexencon_Internalname = "TABLESPLITTEDAPLIIGGEXENCON" ;
      cmbAplIIGGPrrtear.setInternalname( "APLIIGGPRRTEAR" );
      dynAplIIGGCondicion.setInternalname( "APLIIGGCONDICION" );
      cmbAplIIGGTopeTip.setInternalname( "APLIIGGTOPETIP" );
      lblTextblockapliiggtopevar_Internalname = "TEXTBLOCKAPLIIGGTOPEVAR" ;
      Combo_apliiggtopevar_Internalname = "COMBO_APLIIGGTOPEVAR" ;
      edtAplIIGGTopeVar_Internalname = "APLIIGGTOPEVAR" ;
      divTablesplittedapliiggtopevar_Internalname = "TABLESPLITTEDAPLIIGGTOPEVAR" ;
      lblTextblockapliiggtopecon_Internalname = "TEXTBLOCKAPLIIGGTOPECON" ;
      Combo_apliiggtopecon_Internalname = "COMBO_APLIIGGTOPECON" ;
      edtAplIIGGTopeCon_Internalname = "APLIIGGTOPECON" ;
      divTablesplittedapliiggtopecon_Internalname = "TABLESPLITTEDAPLIIGGTOPECON" ;
      edtAplIIGGTopeFij_Internalname = "APLIIGGTOPEFIJ" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      grpUnnamedgroup3_Internalname = "UNNAMEDGROUP3" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      dynAplIIGGgRelSec.setInternalname( "APLIIGGGRELSEC" );
      divApliigggrelsec_cell_Internalname = "APLIIGGGRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboapliiggexencon_Internalname = "vCOMBOAPLIIGGEXENCON" ;
      divSectionattribute_apliiggexencon_Internalname = "SECTIONATTRIBUTE_APLIIGGEXENCON" ;
      edtavComboapliiggtopevar_Internalname = "vCOMBOAPLIIGGTOPEVAR" ;
      divSectionattribute_apliiggtopevar_Internalname = "SECTIONATTRIBUTE_APLIIGGTOPEVAR" ;
      edtavComboapliiggtopecon_Internalname = "vCOMBOAPLIIGGTOPECON" ;
      divSectionattribute_apliiggtopecon_Internalname = "SECTIONATTRIBUTE_APLIIGGTOPECON" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtApliIIGGExenOtr_Internalname = "APLIIIGGEXENOTR" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "tipo_aplicacion_ganancias", "") );
      Combo_apliiggexencon_Datalistprocparametersprefix = "" ;
      Combo_apliiggtopevar_Datalistprocparametersprefix = "" ;
      Combo_apliiggtopecon_Datalistprocparametersprefix = "" ;
      edtApliIIGGExenOtr_Jsonclick = "" ;
      edtApliIIGGExenOtr_Enabled = 1 ;
      edtApliIIGGExenOtr_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboapliiggtopecon_Jsonclick = "" ;
      edtavComboapliiggtopecon_Enabled = 0 ;
      edtavComboapliiggtopecon_Visible = 1 ;
      edtavComboapliiggtopevar_Jsonclick = "" ;
      edtavComboapliiggtopevar_Enabled = 0 ;
      edtavComboapliiggtopevar_Visible = 1 ;
      edtavComboapliiggexencon_Jsonclick = "" ;
      edtavComboapliiggexencon_Enabled = 0 ;
      edtavComboapliiggexencon_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynAplIIGGgRelSec.setJsonclick( "" );
      dynAplIIGGgRelSec.setEnabled( 1 );
      dynAplIIGGgRelSec.setVisible( 1 );
      divApliigggrelsec_cell_Class = "col-xs-12" ;
      edtAplIIGGTopeFij_Jsonclick = "" ;
      edtAplIIGGTopeFij_Enabled = 1 ;
      edtAplIIGGTopeCon_Jsonclick = "" ;
      edtAplIIGGTopeCon_Enabled = 1 ;
      edtAplIIGGTopeCon_Visible = 1 ;
      Combo_apliiggtopecon_Datalistproc = "tipo_aplicacion_gananciasLoadDVCombo" ;
      Combo_apliiggtopecon_Cls = "ExtendedCombo Attribute" ;
      Combo_apliiggtopecon_Caption = "" ;
      Combo_apliiggtopecon_Enabled = GXutil.toBoolean( -1) ;
      edtAplIIGGTopeVar_Jsonclick = "" ;
      edtAplIIGGTopeVar_Enabled = 1 ;
      edtAplIIGGTopeVar_Visible = 1 ;
      Combo_apliiggtopevar_Datalistproc = "tipo_aplicacion_gananciasLoadDVCombo" ;
      Combo_apliiggtopevar_Cls = "ExtendedCombo Attribute" ;
      Combo_apliiggtopevar_Caption = "" ;
      Combo_apliiggtopevar_Enabled = GXutil.toBoolean( -1) ;
      cmbAplIIGGTopeTip.setJsonclick( "" );
      cmbAplIIGGTopeTip.setEnabled( 1 );
      dynAplIIGGCondicion.setJsonclick( "" );
      dynAplIIGGCondicion.setEnabled( 1 );
      cmbAplIIGGPrrtear.setJsonclick( "" );
      cmbAplIIGGPrrtear.setEnabled( 1 );
      edtAplIIGGExenCon_Jsonclick = "" ;
      edtAplIIGGExenCon_Enabled = 1 ;
      edtAplIIGGExenCon_Visible = 1 ;
      Combo_apliiggexencon_Datalistproc = "tipo_aplicacion_gananciasLoadDVCombo" ;
      Combo_apliiggexencon_Cls = "ExtendedCombo Attribute" ;
      Combo_apliiggexencon_Caption = "" ;
      Combo_apliiggexencon_Enabled = GXutil.toBoolean( -1) ;
      edtAplIIGGPropor_Jsonclick = "" ;
      edtAplIIGGPropor_Enabled = 1 ;
      cmbAplIIGGTrat.setJsonclick( "" );
      cmbAplIIGGTrat.setEnabled( 1 );
      edtAplIIGGNom_Enabled = 1 ;
      edtAplIIGG_Jsonclick = "" ;
      edtAplIIGG_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlaapliiggcondicion37126( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaapliiggcondicion_data37126( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaapliiggcondicion_html37126( int AV7CliCod )
   {
      String gxdynajaxvalue;
      gxdlaapliiggcondicion_data37126( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynAplIIGGCondicion.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynAplIIGGCondicion.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaapliiggcondicion_data37126( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003782 */
      pr_default.execute(80, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(80) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T003782_A1105CondExenIIGG[0]));
         gxdynajaxctrldescr.add(T003782_A1108CondexenIIGGNom[0]);
         pr_default.readNext(80);
      }
      pr_default.close(80);
   }

   public void gxdlaapliigggrelsec37126( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaapliigggrelsec_data37126( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxaapliigggrelsec_html37126( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaapliigggrelsec_data37126( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynAplIIGGgRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynAplIIGGgRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaapliigggrelsec_data37126( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T003783 */
      pr_default.execute(81, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(81) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T003783_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T003783_A1880CliReDTChar[0]);
         pr_default.readNext(81);
      }
      pr_default.close(81);
   }

   public void gx6asaclicod37126( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            tipo_aplicacion_ganancias_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa199837126( int AV7CliCod )
   {
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      dynAplIIGGgRelSec.setVisible( (!GXt_boolean4 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynAplIIGGgRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynAplIIGGgRelSec.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_32_37126( String Gx_mode ,
                            int AV7CliCod ,
                            int A1998AplIIGGgRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV41aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1998AplIIGGgRelSec, GXv_boolean5) ;
         AV41aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41aplicadoHay", AV41aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV41aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      cmbAplIIGGTrat.setName( "APLIIGGTRAT" );
      cmbAplIIGGTrat.setWebtags( "" );
      cmbAplIIGGTrat.addItem(GXutil.trim( GXutil.str( 0, 2, 0)), httpContext.getMessage( "Ninguno", ""), (short)(0));
      cmbAplIIGGTrat.addItem("1", httpContext.getMessage( "Exento horas extras feriados y fines de semana", ""), (short)(0));
      cmbAplIIGGTrat.addItem("2", httpContext.getMessage( "SAC", ""), (short)(0));
      if ( cmbAplIIGGTrat.getItemCount() > 0 )
      {
         A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValidValue(GXutil.trim( GXutil.str( A1120AplIIGGTrat, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1120AplIIGGTrat", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1120AplIIGGTrat), 2, 0));
      }
      cmbAplIIGGPrrtear.setName( "APLIIGGPRRTEAR" );
      cmbAplIIGGPrrtear.setWebtags( "" );
      cmbAplIIGGPrrtear.addItem("SIN", httpContext.getMessage( "Sin cuotas", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("FIJA", httpContext.getMessage( "Cuota fija", ""), (short)(0));
      cmbAplIIGGPrrtear.addItem("VAR", httpContext.getMessage( "Cuota variable", ""), (short)(0));
      if ( cmbAplIIGGPrrtear.getItemCount() > 0 )
      {
         A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValidValue(A1121AplIIGGPrrtear) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1121AplIIGGPrrtear", A1121AplIIGGPrrtear);
      }
      dynAplIIGGCondicion.setName( "APLIIGGCONDICION" );
      dynAplIIGGCondicion.setWebtags( "" );
      cmbAplIIGGTopeTip.setName( "APLIIGGTOPETIP" );
      cmbAplIIGGTopeTip.setWebtags( "" );
      cmbAplIIGGTopeTip.addItem(GXutil.trim( GXutil.str( 0, 1, 0)), httpContext.getMessage( "Sin Tope", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("1", httpContext.getMessage( "Variable", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("2", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbAplIIGGTopeTip.addItem("3", httpContext.getMessage( "Valor Fijo", ""), (short)(0));
      if ( cmbAplIIGGTopeTip.getItemCount() > 0 )
      {
         A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValidValue(GXutil.trim( GXutil.str( A1115AplIIGGTopeTip, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1115AplIIGGTopeTip", GXutil.str( A1115AplIIGGTopeTip, 1, 0));
      }
      dynAplIIGGgRelSec.setName( "APLIIGGGRELSEC" );
      dynAplIIGGgRelSec.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Clicod( )
   {
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003784 */
      pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(82) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(82);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliiggexencon( )
   {
      n1117AplIIGGExenCon = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003785 */
      pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1117AplIIGGExenCon), A1117AplIIGGExenCon});
      if ( (pr_default.getStatus(83) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1117AplIIGGExenCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGCon Exen Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGEXENCON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(83);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliiggcondicion( )
   {
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003786 */
      pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1124AplIIGGCondicion), A1124AplIIGGCondicion});
      if ( (pr_default.getStatus(84) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1124AplIIGGCondicion)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "APl IIGGCond Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGCONDICION");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(84);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliiggtopevar( )
   {
      n1109AplIIGGTopeVar = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003787 */
      pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1109AplIIGGTopeVar), A1109AplIIGGTopeVar});
      if ( (pr_default.getStatus(85) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1109AplIIGGTopeVar)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGOpe Cli", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPEVAR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(85);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliiggtopecon( )
   {
      n1111AplIIGGTopeCon = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003788 */
      pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1111AplIIGGTopeCon), A1111AplIIGGTopeCon});
      if ( (pr_default.getStatus(86) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1111AplIIGGTopeCon)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Apl IIGGConc Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIGGTOPECON");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(86);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Apliiggtopefij( )
   {
      n1112AplIIGG = false ;
      A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValue())) ;
      n1117AplIIGGExenCon = false ;
      A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValue() ;
      A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValue())) ;
      n1109AplIIGGTopeVar = false ;
      n1111AplIIGGTopeCon = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
      tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( ! ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) )
      {
         divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! GXt_boolean4 && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) )
         {
            divApliigggrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divApliigggrelsec_cell_Internalname, "Class", divApliigggrelsec_cell_Class, true);
   }

   public void valid_Apliigggrelsec( )
   {
      n1112AplIIGG = false ;
      A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValue())) ;
      n1117AplIIGGExenCon = false ;
      A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValue() ;
      A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValue())) ;
      n1109AplIIGGTopeVar = false ;
      n1111AplIIGGTopeCon = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( A1112AplIIGG != O1112AplIIGG ) || ( GXutil.strcmp(A1113AplIIGGNom, O1113AplIIGGNom) != 0 ) || ( A1120AplIIGGTrat != O1120AplIIGGTrat ) || ( DecimalUtil.compareTo(A1114AplIIGGPropor, O1114AplIIGGPropor) != 0 ) || ( GXutil.strcmp(A1117AplIIGGExenCon, O1117AplIIGGExenCon) != 0 ) || ( GXutil.strcmp(A1121AplIIGGPrrtear, O1121AplIIGGPrrtear) != 0 ) || ( A1115AplIIGGTopeTip != O1115AplIIGGTopeTip ) || ( GXutil.strcmp(A1109AplIIGGTopeVar, O1109AplIIGGTopeVar) != 0 ) || ( GXutil.strcmp(A1111AplIIGGTopeCon, O1111AplIIGGTopeCon) != 0 ) || ( DecimalUtil.compareTo(A1119AplIIGGTopeFij, O1119AplIIGGTopeFij) != 0 ) || ( GXutil.strcmp(A1124AplIIGGCondicion, O1124AplIIGGCondicion) != 0 ) ) ) && (0==A1998AplIIGGgRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "APLIIGGGRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynAplIIGGgRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV41aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1998AplIIGGgRelSec, GXv_boolean5) ;
         tipo_aplicacion_ganancias_impl.this.AV41aplicadoHay = GXv_boolean5[0] ;
         AV41aplicadoHay = this.AV41aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV41aplicadoHay", AV41aplicadoHay);
   }

   public void valid_Apliiiggexenotr( )
   {
      n1112AplIIGG = false ;
      A1120AplIIGGTrat = (byte)(GXutil.lval( cmbAplIIGGTrat.getValue())) ;
      n1117AplIIGGExenCon = false ;
      A1121AplIIGGPrrtear = cmbAplIIGGPrrtear.getValue() ;
      A1115AplIIGGTopeTip = (byte)(GXutil.lval( cmbAplIIGGTopeTip.getValue())) ;
      n1109AplIIGGTopeVar = false ;
      n1111AplIIGGTopeCon = false ;
      n1118ApliIIGGExenOtr = false ;
      n1124AplIIGGCondicion = false ;
      A1124AplIIGGCondicion = dynAplIIGGCondicion.getValue() ;
      n1124AplIIGGCondicion = false ;
      A1998AplIIGGgRelSec = (int)(GXutil.lval( dynAplIIGGgRelSec.getValue())) ;
      /* Using cursor T003789 */
      pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1118ApliIIGGExenOtr), A1118ApliIIGGExenOtr});
      if ( (pr_default.getStatus(87) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1118ApliIIGGExenOtr)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Apl IIGGOtros Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "APLIIIGGEXENOTR");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCliCod_Internalname ;
         }
      }
      pr_default.close(87);
      O1124AplIIGGCondicion = A1124AplIIGGCondicion ;
      n1124AplIIGGCondicion = false ;
      O1119AplIIGGTopeFij = A1119AplIIGGTopeFij ;
      O1111AplIIGGTopeCon = A1111AplIIGGTopeCon ;
      n1111AplIIGGTopeCon = false ;
      O1109AplIIGGTopeVar = A1109AplIIGGTopeVar ;
      n1109AplIIGGTopeVar = false ;
      O1115AplIIGGTopeTip = A1115AplIIGGTopeTip ;
      O1121AplIIGGPrrtear = A1121AplIIGGPrrtear ;
      O1117AplIIGGExenCon = A1117AplIIGGExenCon ;
      n1117AplIIGGExenCon = false ;
      O1114AplIIGGPropor = A1114AplIIGGPropor ;
      O1120AplIIGGTrat = A1120AplIIGGTrat ;
      O1113AplIIGGNom = A1113AplIIGGNom ;
      O1112AplIIGG = A1112AplIIGG ;
      n1112AplIIGG = false ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8AplIIGG',fld:'vAPLIIGG',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8AplIIGG',fld:'vAPLIIGG',pic:'ZZZ9',hsh:true},{av:'A1999AplIIGGRelSecCli',fld:'APLIIGGRELSECCLI',pic:'ZZZZZ9'},{av:'A2000AplIIGGPadre',fld:'APLIIGGPADRE',pic:'ZZZ9'},{av:'A2020AplIIGGRelRef',fld:'APLIIGGRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12372',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGG","{handler:'valid_Apliigg',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGNOM","{handler:'valid_Apliiggnom',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGNOM",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGTRAT","{handler:'valid_Apliiggtrat',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGTRAT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGPROPOR","{handler:'valid_Apliiggpropor',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGPROPOR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGEXENCON","{handler:'valid_Apliiggexencon',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1117AplIIGGExenCon',fld:'APLIIGGEXENCON',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGEXENCON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGPRRTEAR","{handler:'valid_Apliiggprrtear',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGPRRTEAR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGCONDICION","{handler:'valid_Apliiggcondicion',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGCONDICION",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGTOPETIP","{handler:'valid_Apliiggtopetip',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGTOPETIP",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGTOPEVAR","{handler:'valid_Apliiggtopevar',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1109AplIIGGTopeVar',fld:'APLIIGGTOPEVAR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGTOPEVAR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGTOPECON","{handler:'valid_Apliiggtopecon',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1111AplIIGGTopeCon',fld:'APLIIGGTOPECON',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGTOPECON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGTOPEFIJ","{handler:'valid_Apliiggtopefij',iparms:[{av:'O1124AplIIGGCondicion'},{av:'O1119AplIIGGTopeFij'},{av:'O1111AplIIGGTopeCon'},{av:'O1109AplIIGGTopeVar'},{av:'O1115AplIIGGTopeTip'},{av:'O1121AplIIGGPrrtear'},{av:'O1117AplIIGGExenCon'},{av:'O1114AplIIGGPropor'},{av:'O1120AplIIGGTrat'},{av:'O1113AplIIGGNom'},{av:'O1112AplIIGG'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'A1113AplIIGGNom',fld:'APLIIGGNOM',pic:''},{av:'cmbAplIIGGTrat'},{av:'A1120AplIIGGTrat',fld:'APLIIGGTRAT',pic:'Z9'},{av:'A1114AplIIGGPropor',fld:'APLIIGGPROPOR',pic:'9.9999'},{av:'A1117AplIIGGExenCon',fld:'APLIIGGEXENCON',pic:''},{av:'cmbAplIIGGPrrtear'},{av:'A1121AplIIGGPrrtear',fld:'APLIIGGPRRTEAR',pic:''},{av:'cmbAplIIGGTopeTip'},{av:'A1115AplIIGGTopeTip',fld:'APLIIGGTOPETIP',pic:'9'},{av:'A1109AplIIGGTopeVar',fld:'APLIIGGTOPEVAR',pic:''},{av:'A1111AplIIGGTopeCon',fld:'APLIIGGTOPECON',pic:''},{av:'A1119AplIIGGTopeFij',fld:'APLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGTOPEFIJ",",oparms:[{av:'divApliigggrelsec_cell_Class',ctrl:'APLIIGGGRELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIGGGRELSEC","{handler:'valid_Apliigggrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1124AplIIGGCondicion'},{av:'O1119AplIIGGTopeFij'},{av:'O1111AplIIGGTopeCon'},{av:'O1109AplIIGGTopeVar'},{av:'O1115AplIIGGTopeTip'},{av:'O1121AplIIGGPrrtear'},{av:'O1117AplIIGGExenCon'},{av:'O1114AplIIGGPropor'},{av:'O1120AplIIGGTrat'},{av:'O1113AplIIGGNom'},{av:'O1112AplIIGG'},{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'A1113AplIIGGNom',fld:'APLIIGGNOM',pic:''},{av:'cmbAplIIGGTrat'},{av:'A1120AplIIGGTrat',fld:'APLIIGGTRAT',pic:'Z9'},{av:'A1114AplIIGGPropor',fld:'APLIIGGPROPOR',pic:'9.9999'},{av:'A1117AplIIGGExenCon',fld:'APLIIGGEXENCON',pic:''},{av:'cmbAplIIGGPrrtear'},{av:'A1121AplIIGGPrrtear',fld:'APLIIGGPRRTEAR',pic:''},{av:'cmbAplIIGGTopeTip'},{av:'A1115AplIIGGTopeTip',fld:'APLIIGGTOPETIP',pic:'9'},{av:'A1109AplIIGGTopeVar',fld:'APLIIGGTOPEVAR',pic:''},{av:'A1111AplIIGGTopeCon',fld:'APLIIGGTOPECON',pic:''},{av:'A1119AplIIGGTopeFij',fld:'APLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV41aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIGGGRELSEC",",oparms:[{av:'AV41aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOAPLIIGGEXENCON","{handler:'validv_Comboapliiggexencon',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOAPLIIGGEXENCON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOAPLIIGGTOPEVAR","{handler:'validv_Comboapliiggtopevar',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOAPLIIGGTOPEVAR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_COMBOAPLIIGGTOPECON","{handler:'validv_Comboapliiggtopecon',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALIDV_COMBOAPLIIGGTOPECON",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_APLIIIGGEXENOTR","{handler:'valid_Apliiiggexenotr',iparms:[{av:'A1112AplIIGG',fld:'APLIIGG',pic:'ZZZ9'},{av:'A1113AplIIGGNom',fld:'APLIIGGNOM',pic:''},{av:'cmbAplIIGGTrat'},{av:'A1120AplIIGGTrat',fld:'APLIIGGTRAT',pic:'Z9'},{av:'A1114AplIIGGPropor',fld:'APLIIGGPROPOR',pic:'9.9999'},{av:'A1117AplIIGGExenCon',fld:'APLIIGGEXENCON',pic:''},{av:'cmbAplIIGGPrrtear'},{av:'A1121AplIIGGPrrtear',fld:'APLIIGGPRRTEAR',pic:''},{av:'cmbAplIIGGTopeTip'},{av:'A1115AplIIGGTopeTip',fld:'APLIIGGTOPETIP',pic:'9'},{av:'A1109AplIIGGTopeVar',fld:'APLIIGGTOPEVAR',pic:''},{av:'A1111AplIIGGTopeCon',fld:'APLIIGGTOPECON',pic:''},{av:'A1119AplIIGGTopeFij',fld:'APLIIGGTOPEFIJ',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1118ApliIIGGExenOtr',fld:'APLIIIGGEXENOTR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_APLIIIGGEXENOTR",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynAplIIGGCondicion'},{av:'A1124AplIIGGCondicion',fld:'APLIIGGCONDICION',pic:''},{av:'dynAplIIGGgRelSec'},{av:'A1998AplIIGGgRelSec',fld:'APLIIGGGRELSEC',pic:'ZZZZZ9'}]}");
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
      pr_default.close(86);
      pr_default.close(83);
      pr_default.close(87);
      pr_default.close(82);
      pr_default.close(85);
      pr_default.close(84);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1113AplIIGGNom = "" ;
      Z1114AplIIGGPropor = DecimalUtil.ZERO ;
      Z1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      Z1121AplIIGGPrrtear = "" ;
      Z2020AplIIGGRelRef = "" ;
      Z1111AplIIGGTopeCon = "" ;
      Z1117AplIIGGExenCon = "" ;
      Z1118ApliIIGGExenOtr = "" ;
      Z1109AplIIGGTopeVar = "" ;
      Z1124AplIIGGCondicion = "" ;
      O1124AplIIGGCondicion = "" ;
      O1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      O1111AplIIGGTopeCon = "" ;
      O1109AplIIGGTopeVar = "" ;
      O1121AplIIGGPrrtear = "" ;
      O1117AplIIGGExenCon = "" ;
      O1114AplIIGGPropor = DecimalUtil.ZERO ;
      O1113AplIIGGNom = "" ;
      N1109AplIIGGTopeVar = "" ;
      N1111AplIIGGTopeCon = "" ;
      N1117AplIIGGExenCon = "" ;
      N1118ApliIIGGExenOtr = "" ;
      N1124AplIIGGCondicion = "" ;
      Combo_apliiggtopecon_Selectedvalue_get = "" ;
      Combo_apliiggtopevar_Selectedvalue_get = "" ;
      Combo_apliiggexencon_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1111AplIIGGTopeCon = "" ;
      A1117AplIIGGExenCon = "" ;
      A1118ApliIIGGExenOtr = "" ;
      A1109AplIIGGTopeVar = "" ;
      A1124AplIIGGCondicion = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1121AplIIGGPrrtear = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1113AplIIGGNom = "" ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      lblTextblockapliiggexencon_Jsonclick = "" ;
      ucCombo_apliiggexencon = new com.genexus.webpanels.GXUserControl();
      AV21DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV30AplIIGGExenCon_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockapliiggtopevar_Jsonclick = "" ;
      ucCombo_apliiggtopevar = new com.genexus.webpanels.GXUserControl();
      AV26AplIIGGTopeVar_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockapliiggtopecon_Jsonclick = "" ;
      ucCombo_apliiggtopecon = new com.genexus.webpanels.GXUserControl();
      AV38AplIIGGTopeCon_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV31ComboAplIIGGExenCon = "" ;
      AV27ComboAplIIGGTopeVar = "" ;
      AV39ComboAplIIGGTopeCon = "" ;
      A2020AplIIGGRelRef = "" ;
      AV14Insert_AplIIGGTopeVar = "" ;
      AV15Insert_AplIIGGTopeCon = "" ;
      AV16Insert_AplIIGGExenCon = "" ;
      AV17Insert_ApliIIGGExenOtr = "" ;
      AV18Insert_AplIIGGCondicion = "" ;
      A2028AplIIGGOld = "" ;
      AV42Pgmname = "" ;
      Combo_apliiggexencon_Objectcall = "" ;
      Combo_apliiggexencon_Class = "" ;
      Combo_apliiggexencon_Icontype = "" ;
      Combo_apliiggexencon_Icon = "" ;
      Combo_apliiggexencon_Tooltip = "" ;
      Combo_apliiggexencon_Selectedvalue_set = "" ;
      Combo_apliiggexencon_Selectedtext_set = "" ;
      Combo_apliiggexencon_Selectedtext_get = "" ;
      Combo_apliiggexencon_Gamoauthtoken = "" ;
      Combo_apliiggexencon_Ddointernalname = "" ;
      Combo_apliiggexencon_Titlecontrolalign = "" ;
      Combo_apliiggexencon_Dropdownoptionstype = "" ;
      Combo_apliiggexencon_Titlecontrolidtoreplace = "" ;
      Combo_apliiggexencon_Datalisttype = "" ;
      Combo_apliiggexencon_Datalistfixedvalues = "" ;
      Combo_apliiggexencon_Remoteservicesparameters = "" ;
      Combo_apliiggexencon_Htmltemplate = "" ;
      Combo_apliiggexencon_Multiplevaluestype = "" ;
      Combo_apliiggexencon_Loadingdata = "" ;
      Combo_apliiggexencon_Noresultsfound = "" ;
      Combo_apliiggexencon_Emptyitemtext = "" ;
      Combo_apliiggexencon_Onlyselectedvalues = "" ;
      Combo_apliiggexencon_Selectalltext = "" ;
      Combo_apliiggexencon_Multiplevaluesseparator = "" ;
      Combo_apliiggexencon_Addnewoptiontext = "" ;
      Combo_apliiggtopevar_Objectcall = "" ;
      Combo_apliiggtopevar_Class = "" ;
      Combo_apliiggtopevar_Icontype = "" ;
      Combo_apliiggtopevar_Icon = "" ;
      Combo_apliiggtopevar_Tooltip = "" ;
      Combo_apliiggtopevar_Selectedvalue_set = "" ;
      Combo_apliiggtopevar_Selectedtext_set = "" ;
      Combo_apliiggtopevar_Selectedtext_get = "" ;
      Combo_apliiggtopevar_Gamoauthtoken = "" ;
      Combo_apliiggtopevar_Ddointernalname = "" ;
      Combo_apliiggtopevar_Titlecontrolalign = "" ;
      Combo_apliiggtopevar_Dropdownoptionstype = "" ;
      Combo_apliiggtopevar_Titlecontrolidtoreplace = "" ;
      Combo_apliiggtopevar_Datalisttype = "" ;
      Combo_apliiggtopevar_Datalistfixedvalues = "" ;
      Combo_apliiggtopevar_Remoteservicesparameters = "" ;
      Combo_apliiggtopevar_Htmltemplate = "" ;
      Combo_apliiggtopevar_Multiplevaluestype = "" ;
      Combo_apliiggtopevar_Loadingdata = "" ;
      Combo_apliiggtopevar_Noresultsfound = "" ;
      Combo_apliiggtopevar_Emptyitemtext = "" ;
      Combo_apliiggtopevar_Onlyselectedvalues = "" ;
      Combo_apliiggtopevar_Selectalltext = "" ;
      Combo_apliiggtopevar_Multiplevaluesseparator = "" ;
      Combo_apliiggtopevar_Addnewoptiontext = "" ;
      Combo_apliiggtopecon_Objectcall = "" ;
      Combo_apliiggtopecon_Class = "" ;
      Combo_apliiggtopecon_Icontype = "" ;
      Combo_apliiggtopecon_Icon = "" ;
      Combo_apliiggtopecon_Tooltip = "" ;
      Combo_apliiggtopecon_Selectedvalue_set = "" ;
      Combo_apliiggtopecon_Selectedtext_set = "" ;
      Combo_apliiggtopecon_Selectedtext_get = "" ;
      Combo_apliiggtopecon_Gamoauthtoken = "" ;
      Combo_apliiggtopecon_Ddointernalname = "" ;
      Combo_apliiggtopecon_Titlecontrolalign = "" ;
      Combo_apliiggtopecon_Dropdownoptionstype = "" ;
      Combo_apliiggtopecon_Titlecontrolidtoreplace = "" ;
      Combo_apliiggtopecon_Datalisttype = "" ;
      Combo_apliiggtopecon_Datalistfixedvalues = "" ;
      Combo_apliiggtopecon_Remoteservicesparameters = "" ;
      Combo_apliiggtopecon_Htmltemplate = "" ;
      Combo_apliiggtopecon_Multiplevaluestype = "" ;
      Combo_apliiggtopecon_Loadingdata = "" ;
      Combo_apliiggtopecon_Noresultsfound = "" ;
      Combo_apliiggtopecon_Emptyitemtext = "" ;
      Combo_apliiggtopecon_Onlyselectedvalues = "" ;
      Combo_apliiggtopecon_Selectalltext = "" ;
      Combo_apliiggtopecon_Multiplevaluesseparator = "" ;
      Combo_apliiggtopecon_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode126 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV19TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV24Combo_DataJson = "" ;
      AV22ComboSelectedValue = "" ;
      AV23ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z2028AplIIGGOld = "" ;
      T003710_A1112AplIIGG = new short[1] ;
      T003710_n1112AplIIGG = new boolean[] {false} ;
      T003710_A1113AplIIGGNom = new String[] {""} ;
      T003710_A1120AplIIGGTrat = new byte[1] ;
      T003710_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003710_A1115AplIIGGTopeTip = new byte[1] ;
      T003710_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T003710_A1121AplIIGGPrrtear = new String[] {""} ;
      T003710_A1998AplIIGGgRelSec = new int[1] ;
      T003710_A1999AplIIGGRelSecCli = new int[1] ;
      T003710_A2000AplIIGGPadre = new short[1] ;
      T003710_A2020AplIIGGRelRef = new String[] {""} ;
      T003710_A2028AplIIGGOld = new String[] {""} ;
      T003710_A3CliCod = new int[1] ;
      T003710_A1111AplIIGGTopeCon = new String[] {""} ;
      T003710_n1111AplIIGGTopeCon = new boolean[] {false} ;
      T003710_A1117AplIIGGExenCon = new String[] {""} ;
      T003710_n1117AplIIGGExenCon = new boolean[] {false} ;
      T003710_A1118ApliIIGGExenOtr = new String[] {""} ;
      T003710_n1118ApliIIGGExenOtr = new boolean[] {false} ;
      T003710_A1109AplIIGGTopeVar = new String[] {""} ;
      T003710_n1109AplIIGGTopeVar = new boolean[] {false} ;
      T003710_A1124AplIIGGCondicion = new String[] {""} ;
      T003710_n1124AplIIGGCondicion = new boolean[] {false} ;
      T00374_A3CliCod = new int[1] ;
      T00375_A3CliCod = new int[1] ;
      T00376_A3CliCod = new int[1] ;
      T00377_A3CliCod = new int[1] ;
      T00378_A3CliCod = new int[1] ;
      T00379_A3CliCod = new int[1] ;
      T003711_A3CliCod = new int[1] ;
      T003712_A3CliCod = new int[1] ;
      T003713_A3CliCod = new int[1] ;
      T003714_A3CliCod = new int[1] ;
      T003715_A3CliCod = new int[1] ;
      T003716_A3CliCod = new int[1] ;
      T003717_A3CliCod = new int[1] ;
      T003717_A1112AplIIGG = new short[1] ;
      T003717_n1112AplIIGG = new boolean[] {false} ;
      T00373_A1112AplIIGG = new short[1] ;
      T00373_n1112AplIIGG = new boolean[] {false} ;
      T00373_A1113AplIIGGNom = new String[] {""} ;
      T00373_A1120AplIIGGTrat = new byte[1] ;
      T00373_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00373_A1115AplIIGGTopeTip = new byte[1] ;
      T00373_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00373_A1121AplIIGGPrrtear = new String[] {""} ;
      T00373_A1998AplIIGGgRelSec = new int[1] ;
      T00373_A1999AplIIGGRelSecCli = new int[1] ;
      T00373_A2000AplIIGGPadre = new short[1] ;
      T00373_A2020AplIIGGRelRef = new String[] {""} ;
      T00373_A2028AplIIGGOld = new String[] {""} ;
      T00373_A3CliCod = new int[1] ;
      T00373_A1111AplIIGGTopeCon = new String[] {""} ;
      T00373_n1111AplIIGGTopeCon = new boolean[] {false} ;
      T00373_A1117AplIIGGExenCon = new String[] {""} ;
      T00373_n1117AplIIGGExenCon = new boolean[] {false} ;
      T00373_A1118ApliIIGGExenOtr = new String[] {""} ;
      T00373_n1118ApliIIGGExenOtr = new boolean[] {false} ;
      T00373_A1109AplIIGGTopeVar = new String[] {""} ;
      T00373_n1109AplIIGGTopeVar = new boolean[] {false} ;
      T00373_A1124AplIIGGCondicion = new String[] {""} ;
      T00373_n1124AplIIGGCondicion = new boolean[] {false} ;
      T003718_A3CliCod = new int[1] ;
      T003718_A1112AplIIGG = new short[1] ;
      T003718_n1112AplIIGG = new boolean[] {false} ;
      T003719_A3CliCod = new int[1] ;
      T003719_A1112AplIIGG = new short[1] ;
      T003719_n1112AplIIGG = new boolean[] {false} ;
      T00372_A1112AplIIGG = new short[1] ;
      T00372_n1112AplIIGG = new boolean[] {false} ;
      T00372_A1113AplIIGGNom = new String[] {""} ;
      T00372_A1120AplIIGGTrat = new byte[1] ;
      T00372_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00372_A1115AplIIGGTopeTip = new byte[1] ;
      T00372_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00372_A1121AplIIGGPrrtear = new String[] {""} ;
      T00372_A1998AplIIGGgRelSec = new int[1] ;
      T00372_A1999AplIIGGRelSecCli = new int[1] ;
      T00372_A2000AplIIGGPadre = new short[1] ;
      T00372_A2020AplIIGGRelRef = new String[] {""} ;
      T00372_A2028AplIIGGOld = new String[] {""} ;
      T00372_A3CliCod = new int[1] ;
      T00372_A1111AplIIGGTopeCon = new String[] {""} ;
      T00372_n1111AplIIGGTopeCon = new boolean[] {false} ;
      T00372_A1117AplIIGGExenCon = new String[] {""} ;
      T00372_n1117AplIIGGExenCon = new boolean[] {false} ;
      T00372_A1118ApliIIGGExenOtr = new String[] {""} ;
      T00372_n1118ApliIIGGExenOtr = new boolean[] {false} ;
      T00372_A1109AplIIGGTopeVar = new String[] {""} ;
      T00372_n1109AplIIGGTopeVar = new boolean[] {false} ;
      T00372_A1124AplIIGGCondicion = new String[] {""} ;
      T00372_n1124AplIIGGCondicion = new boolean[] {false} ;
      T003723_A3CliCod = new int[1] ;
      T003723_A1EmpCod = new short[1] ;
      T003723_A1129LiqExAnio = new short[1] ;
      T003723_A31LiqNro = new int[1] ;
      T003723_A6LegNumero = new int[1] ;
      T003723_A1127LiqExenConCodigo = new String[] {""} ;
      T003723_A1128LiqExAplIIGG = new short[1] ;
      T003724_A3CliCod = new int[1] ;
      T003724_A1EmpCod = new short[1] ;
      T003724_A869LiqLegConAnio = new short[1] ;
      T003724_A6LegNumero = new int[1] ;
      T003724_A26ConCodigo = new String[] {""} ;
      T003724_A1097LiqAltaNro = new int[1] ;
      T003724_A1098LiqNuevaNro = new int[1] ;
      T003725_A3CliCod = new int[1] ;
      T003725_A26ConCodigo = new String[] {""} ;
      T003726_A3CliCod = new int[1] ;
      T003726_A26ConCodigo = new String[] {""} ;
      T003727_A3CliCod = new int[1] ;
      T003727_A26ConCodigo = new String[] {""} ;
      T003728_A3CliCod = new int[1] ;
      T003728_A26ConCodigo = new String[] {""} ;
      T003729_A3CliCod = new int[1] ;
      T003729_A26ConCodigo = new String[] {""} ;
      T003730_A3CliCod = new int[1] ;
      T003730_A26ConCodigo = new String[] {""} ;
      T003731_A3CliCod = new int[1] ;
      T003731_A26ConCodigo = new String[] {""} ;
      T003732_A3CliCod = new int[1] ;
      T003732_A26ConCodigo = new String[] {""} ;
      T003733_A3CliCod = new int[1] ;
      T003733_A26ConCodigo = new String[] {""} ;
      T003734_A3CliCod = new int[1] ;
      T003734_A26ConCodigo = new String[] {""} ;
      T003735_A3CliCod = new int[1] ;
      T003735_A26ConCodigo = new String[] {""} ;
      T003736_A3CliCod = new int[1] ;
      T003736_A26ConCodigo = new String[] {""} ;
      T003737_A3CliCod = new int[1] ;
      T003737_A26ConCodigo = new String[] {""} ;
      T003738_A3CliCod = new int[1] ;
      T003738_A26ConCodigo = new String[] {""} ;
      T003739_A3CliCod = new int[1] ;
      T003739_A26ConCodigo = new String[] {""} ;
      T003740_A3CliCod = new int[1] ;
      T003740_A26ConCodigo = new String[] {""} ;
      T003741_A3CliCod = new int[1] ;
      T003741_A26ConCodigo = new String[] {""} ;
      T003742_A3CliCod = new int[1] ;
      T003742_A26ConCodigo = new String[] {""} ;
      T003743_A3CliCod = new int[1] ;
      T003743_A26ConCodigo = new String[] {""} ;
      T003744_A3CliCod = new int[1] ;
      T003744_A26ConCodigo = new String[] {""} ;
      T003745_A3CliCod = new int[1] ;
      T003745_A26ConCodigo = new String[] {""} ;
      T003746_A3CliCod = new int[1] ;
      T003746_A26ConCodigo = new String[] {""} ;
      T003747_A3CliCod = new int[1] ;
      T003747_A26ConCodigo = new String[] {""} ;
      T003748_A3CliCod = new int[1] ;
      T003748_A26ConCodigo = new String[] {""} ;
      T003749_A3CliCod = new int[1] ;
      T003749_A26ConCodigo = new String[] {""} ;
      T003750_A3CliCod = new int[1] ;
      T003750_A26ConCodigo = new String[] {""} ;
      T003751_A3CliCod = new int[1] ;
      T003751_A26ConCodigo = new String[] {""} ;
      T003752_A3CliCod = new int[1] ;
      T003752_A26ConCodigo = new String[] {""} ;
      T003753_A3CliCod = new int[1] ;
      T003753_A26ConCodigo = new String[] {""} ;
      T003754_A3CliCod = new int[1] ;
      T003754_A26ConCodigo = new String[] {""} ;
      T003755_A3CliCod = new int[1] ;
      T003755_A26ConCodigo = new String[] {""} ;
      T003756_A3CliCod = new int[1] ;
      T003756_A26ConCodigo = new String[] {""} ;
      T003757_A3CliCod = new int[1] ;
      T003757_A26ConCodigo = new String[] {""} ;
      T003758_A3CliCod = new int[1] ;
      T003758_A26ConCodigo = new String[] {""} ;
      T003759_A3CliCod = new int[1] ;
      T003759_A26ConCodigo = new String[] {""} ;
      T003760_A3CliCod = new int[1] ;
      T003760_A26ConCodigo = new String[] {""} ;
      T003761_A3CliCod = new int[1] ;
      T003761_A26ConCodigo = new String[] {""} ;
      T003762_A3CliCod = new int[1] ;
      T003762_A26ConCodigo = new String[] {""} ;
      T003763_A3CliCod = new int[1] ;
      T003763_A26ConCodigo = new String[] {""} ;
      T003764_A3CliCod = new int[1] ;
      T003764_A26ConCodigo = new String[] {""} ;
      T003765_A3CliCod = new int[1] ;
      T003765_A26ConCodigo = new String[] {""} ;
      T003766_A3CliCod = new int[1] ;
      T003766_A26ConCodigo = new String[] {""} ;
      T003767_A3CliCod = new int[1] ;
      T003767_A26ConCodigo = new String[] {""} ;
      T003768_A3CliCod = new int[1] ;
      T003768_A26ConCodigo = new String[] {""} ;
      T003769_A3CliCod = new int[1] ;
      T003769_A26ConCodigo = new String[] {""} ;
      T003770_A3CliCod = new int[1] ;
      T003770_A26ConCodigo = new String[] {""} ;
      T003771_A3CliCod = new int[1] ;
      T003771_A26ConCodigo = new String[] {""} ;
      T003772_A3CliCod = new int[1] ;
      T003772_A26ConCodigo = new String[] {""} ;
      T003773_A3CliCod = new int[1] ;
      T003773_A26ConCodigo = new String[] {""} ;
      T003774_A3CliCod = new int[1] ;
      T003774_A26ConCodigo = new String[] {""} ;
      T003775_A3CliCod = new int[1] ;
      T003775_A26ConCodigo = new String[] {""} ;
      T003776_A3CliCod = new int[1] ;
      T003776_A26ConCodigo = new String[] {""} ;
      T003777_A3CliCod = new int[1] ;
      T003777_A26ConCodigo = new String[] {""} ;
      T003778_A3CliCod = new int[1] ;
      T003778_A26ConCodigo = new String[] {""} ;
      T003779_A3CliCod = new int[1] ;
      T003779_A26ConCodigo = new String[] {""} ;
      T003780_A3CliCod = new int[1] ;
      T003780_A26ConCodigo = new String[] {""} ;
      T003781_A3CliCod = new int[1] ;
      T003781_A1112AplIIGG = new short[1] ;
      T003781_n1112AplIIGG = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T003782_A3CliCod = new int[1] ;
      T003782_A1105CondExenIIGG = new String[] {""} ;
      T003782_A1108CondexenIIGGNom = new String[] {""} ;
      T003783_A3CliCod = new int[1] ;
      T003783_A1885CliRelSec = new int[1] ;
      T003783_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T003784_A3CliCod = new int[1] ;
      T003785_A3CliCod = new int[1] ;
      T003786_A3CliCod = new int[1] ;
      T003787_A3CliCod = new int[1] ;
      T003788_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      T003789_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_aplicacion_ganancias__default(),
         new Object[] {
             new Object[] {
            T00372_A1112AplIIGG, T00372_A1113AplIIGGNom, T00372_A1120AplIIGGTrat, T00372_A1114AplIIGGPropor, T00372_A1115AplIIGGTopeTip, T00372_A1119AplIIGGTopeFij, T00372_A1121AplIIGGPrrtear, T00372_A1998AplIIGGgRelSec, T00372_A1999AplIIGGRelSecCli, T00372_A2000AplIIGGPadre,
            T00372_A2020AplIIGGRelRef, T00372_A2028AplIIGGOld, T00372_A3CliCod, T00372_A1111AplIIGGTopeCon, T00372_n1111AplIIGGTopeCon, T00372_A1117AplIIGGExenCon, T00372_n1117AplIIGGExenCon, T00372_A1118ApliIIGGExenOtr, T00372_n1118ApliIIGGExenOtr, T00372_A1109AplIIGGTopeVar,
            T00372_n1109AplIIGGTopeVar, T00372_A1124AplIIGGCondicion, T00372_n1124AplIIGGCondicion
            }
            , new Object[] {
            T00373_A1112AplIIGG, T00373_A1113AplIIGGNom, T00373_A1120AplIIGGTrat, T00373_A1114AplIIGGPropor, T00373_A1115AplIIGGTopeTip, T00373_A1119AplIIGGTopeFij, T00373_A1121AplIIGGPrrtear, T00373_A1998AplIIGGgRelSec, T00373_A1999AplIIGGRelSecCli, T00373_A2000AplIIGGPadre,
            T00373_A2020AplIIGGRelRef, T00373_A2028AplIIGGOld, T00373_A3CliCod, T00373_A1111AplIIGGTopeCon, T00373_n1111AplIIGGTopeCon, T00373_A1117AplIIGGExenCon, T00373_n1117AplIIGGExenCon, T00373_A1118ApliIIGGExenOtr, T00373_n1118ApliIIGGExenOtr, T00373_A1109AplIIGGTopeVar,
            T00373_n1109AplIIGGTopeVar, T00373_A1124AplIIGGCondicion, T00373_n1124AplIIGGCondicion
            }
            , new Object[] {
            T00374_A3CliCod
            }
            , new Object[] {
            T00375_A3CliCod
            }
            , new Object[] {
            T00376_A3CliCod
            }
            , new Object[] {
            T00377_A3CliCod
            }
            , new Object[] {
            T00378_A3CliCod
            }
            , new Object[] {
            T00379_A3CliCod
            }
            , new Object[] {
            T003710_A1112AplIIGG, T003710_A1113AplIIGGNom, T003710_A1120AplIIGGTrat, T003710_A1114AplIIGGPropor, T003710_A1115AplIIGGTopeTip, T003710_A1119AplIIGGTopeFij, T003710_A1121AplIIGGPrrtear, T003710_A1998AplIIGGgRelSec, T003710_A1999AplIIGGRelSecCli, T003710_A2000AplIIGGPadre,
            T003710_A2020AplIIGGRelRef, T003710_A2028AplIIGGOld, T003710_A3CliCod, T003710_A1111AplIIGGTopeCon, T003710_n1111AplIIGGTopeCon, T003710_A1117AplIIGGExenCon, T003710_n1117AplIIGGExenCon, T003710_A1118ApliIIGGExenOtr, T003710_n1118ApliIIGGExenOtr, T003710_A1109AplIIGGTopeVar,
            T003710_n1109AplIIGGTopeVar, T003710_A1124AplIIGGCondicion, T003710_n1124AplIIGGCondicion
            }
            , new Object[] {
            T003711_A3CliCod
            }
            , new Object[] {
            T003712_A3CliCod
            }
            , new Object[] {
            T003713_A3CliCod
            }
            , new Object[] {
            T003714_A3CliCod
            }
            , new Object[] {
            T003715_A3CliCod
            }
            , new Object[] {
            T003716_A3CliCod
            }
            , new Object[] {
            T003717_A3CliCod, T003717_A1112AplIIGG
            }
            , new Object[] {
            T003718_A3CliCod, T003718_A1112AplIIGG
            }
            , new Object[] {
            T003719_A3CliCod, T003719_A1112AplIIGG
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T003723_A3CliCod, T003723_A1EmpCod, T003723_A1129LiqExAnio, T003723_A31LiqNro, T003723_A6LegNumero, T003723_A1127LiqExenConCodigo, T003723_A1128LiqExAplIIGG
            }
            , new Object[] {
            T003724_A3CliCod, T003724_A1EmpCod, T003724_A869LiqLegConAnio, T003724_A6LegNumero, T003724_A26ConCodigo, T003724_A1097LiqAltaNro, T003724_A1098LiqNuevaNro
            }
            , new Object[] {
            T003725_A3CliCod, T003725_A26ConCodigo
            }
            , new Object[] {
            T003726_A3CliCod, T003726_A26ConCodigo
            }
            , new Object[] {
            T003727_A3CliCod, T003727_A26ConCodigo
            }
            , new Object[] {
            T003728_A3CliCod, T003728_A26ConCodigo
            }
            , new Object[] {
            T003729_A3CliCod, T003729_A26ConCodigo
            }
            , new Object[] {
            T003730_A3CliCod, T003730_A26ConCodigo
            }
            , new Object[] {
            T003731_A3CliCod, T003731_A26ConCodigo
            }
            , new Object[] {
            T003732_A3CliCod, T003732_A26ConCodigo
            }
            , new Object[] {
            T003733_A3CliCod, T003733_A26ConCodigo
            }
            , new Object[] {
            T003734_A3CliCod, T003734_A26ConCodigo
            }
            , new Object[] {
            T003735_A3CliCod, T003735_A26ConCodigo
            }
            , new Object[] {
            T003736_A3CliCod, T003736_A26ConCodigo
            }
            , new Object[] {
            T003737_A3CliCod, T003737_A26ConCodigo
            }
            , new Object[] {
            T003738_A3CliCod, T003738_A26ConCodigo
            }
            , new Object[] {
            T003739_A3CliCod, T003739_A26ConCodigo
            }
            , new Object[] {
            T003740_A3CliCod, T003740_A26ConCodigo
            }
            , new Object[] {
            T003741_A3CliCod, T003741_A26ConCodigo
            }
            , new Object[] {
            T003742_A3CliCod, T003742_A26ConCodigo
            }
            , new Object[] {
            T003743_A3CliCod, T003743_A26ConCodigo
            }
            , new Object[] {
            T003744_A3CliCod, T003744_A26ConCodigo
            }
            , new Object[] {
            T003745_A3CliCod, T003745_A26ConCodigo
            }
            , new Object[] {
            T003746_A3CliCod, T003746_A26ConCodigo
            }
            , new Object[] {
            T003747_A3CliCod, T003747_A26ConCodigo
            }
            , new Object[] {
            T003748_A3CliCod, T003748_A26ConCodigo
            }
            , new Object[] {
            T003749_A3CliCod, T003749_A26ConCodigo
            }
            , new Object[] {
            T003750_A3CliCod, T003750_A26ConCodigo
            }
            , new Object[] {
            T003751_A3CliCod, T003751_A26ConCodigo
            }
            , new Object[] {
            T003752_A3CliCod, T003752_A26ConCodigo
            }
            , new Object[] {
            T003753_A3CliCod, T003753_A26ConCodigo
            }
            , new Object[] {
            T003754_A3CliCod, T003754_A26ConCodigo
            }
            , new Object[] {
            T003755_A3CliCod, T003755_A26ConCodigo
            }
            , new Object[] {
            T003756_A3CliCod, T003756_A26ConCodigo
            }
            , new Object[] {
            T003757_A3CliCod, T003757_A26ConCodigo
            }
            , new Object[] {
            T003758_A3CliCod, T003758_A26ConCodigo
            }
            , new Object[] {
            T003759_A3CliCod, T003759_A26ConCodigo
            }
            , new Object[] {
            T003760_A3CliCod, T003760_A26ConCodigo
            }
            , new Object[] {
            T003761_A3CliCod, T003761_A26ConCodigo
            }
            , new Object[] {
            T003762_A3CliCod, T003762_A26ConCodigo
            }
            , new Object[] {
            T003763_A3CliCod, T003763_A26ConCodigo
            }
            , new Object[] {
            T003764_A3CliCod, T003764_A26ConCodigo
            }
            , new Object[] {
            T003765_A3CliCod, T003765_A26ConCodigo
            }
            , new Object[] {
            T003766_A3CliCod, T003766_A26ConCodigo
            }
            , new Object[] {
            T003767_A3CliCod, T003767_A26ConCodigo
            }
            , new Object[] {
            T003768_A3CliCod, T003768_A26ConCodigo
            }
            , new Object[] {
            T003769_A3CliCod, T003769_A26ConCodigo
            }
            , new Object[] {
            T003770_A3CliCod, T003770_A26ConCodigo
            }
            , new Object[] {
            T003771_A3CliCod, T003771_A26ConCodigo
            }
            , new Object[] {
            T003772_A3CliCod, T003772_A26ConCodigo
            }
            , new Object[] {
            T003773_A3CliCod, T003773_A26ConCodigo
            }
            , new Object[] {
            T003774_A3CliCod, T003774_A26ConCodigo
            }
            , new Object[] {
            T003775_A3CliCod, T003775_A26ConCodigo
            }
            , new Object[] {
            T003776_A3CliCod, T003776_A26ConCodigo
            }
            , new Object[] {
            T003777_A3CliCod, T003777_A26ConCodigo
            }
            , new Object[] {
            T003778_A3CliCod, T003778_A26ConCodigo
            }
            , new Object[] {
            T003779_A3CliCod, T003779_A26ConCodigo
            }
            , new Object[] {
            T003780_A3CliCod, T003780_A26ConCodigo
            }
            , new Object[] {
            T003781_A3CliCod, T003781_A1112AplIIGG
            }
            , new Object[] {
            T003782_A3CliCod, T003782_A1105CondExenIIGG, T003782_A1108CondexenIIGGNom
            }
            , new Object[] {
            T003783_A3CliCod, T003783_A1885CliRelSec, T003783_A1880CliReDTChar
            }
            , new Object[] {
            T003784_A3CliCod
            }
            , new Object[] {
            T003785_A3CliCod
            }
            , new Object[] {
            T003786_A3CliCod
            }
            , new Object[] {
            T003787_A3CliCod
            }
            , new Object[] {
            T003788_A3CliCod
            }
            , new Object[] {
            T003789_A3CliCod
            }
         }
      );
      AV42Pgmname = "tipo_aplicacion_ganancias" ;
   }

   private byte Z1120AplIIGGTrat ;
   private byte Z1115AplIIGGTopeTip ;
   private byte O1115AplIIGGTopeTip ;
   private byte O1120AplIIGGTrat ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1120AplIIGGTrat ;
   private byte A1115AplIIGGTopeTip ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8AplIIGG ;
   private short Z1112AplIIGG ;
   private short Z2000AplIIGGPadre ;
   private short O1112AplIIGG ;
   private short AV8AplIIGG ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1112AplIIGG ;
   private short A2000AplIIGGPadre ;
   private short RcdFound126 ;
   private short nIsDirty_126 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1998AplIIGGgRelSec ;
   private int Z1999AplIIGGRelSecCli ;
   private int AV7CliCod ;
   private int A1998AplIIGGgRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtAplIIGG_Enabled ;
   private int edtAplIIGGNom_Enabled ;
   private int edtAplIIGGPropor_Enabled ;
   private int edtAplIIGGExenCon_Visible ;
   private int edtAplIIGGExenCon_Enabled ;
   private int edtAplIIGGTopeVar_Visible ;
   private int edtAplIIGGTopeVar_Enabled ;
   private int edtAplIIGGTopeCon_Visible ;
   private int edtAplIIGGTopeCon_Enabled ;
   private int edtAplIIGGTopeFij_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboapliiggexencon_Visible ;
   private int edtavComboapliiggexencon_Enabled ;
   private int edtavComboapliiggtopevar_Visible ;
   private int edtavComboapliiggtopevar_Enabled ;
   private int edtavComboapliiggtopecon_Visible ;
   private int edtavComboapliiggtopecon_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtApliIIGGExenOtr_Visible ;
   private int edtApliIIGGExenOtr_Enabled ;
   private int A1999AplIIGGRelSecCli ;
   private int Combo_apliiggexencon_Datalistupdateminimumcharacters ;
   private int Combo_apliiggexencon_Gxcontroltype ;
   private int Combo_apliiggtopevar_Datalistupdateminimumcharacters ;
   private int Combo_apliiggtopevar_Gxcontroltype ;
   private int Combo_apliiggtopecon_Datalistupdateminimumcharacters ;
   private int Combo_apliiggtopecon_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV43GXV1 ;
   private int AV40Insert_CliCod ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private java.math.BigDecimal Z1114AplIIGGPropor ;
   private java.math.BigDecimal Z1119AplIIGGTopeFij ;
   private java.math.BigDecimal O1119AplIIGGTopeFij ;
   private java.math.BigDecimal O1114AplIIGGPropor ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1121AplIIGGPrrtear ;
   private String Z1111AplIIGGTopeCon ;
   private String Z1117AplIIGGExenCon ;
   private String Z1118ApliIIGGExenOtr ;
   private String Z1109AplIIGGTopeVar ;
   private String Z1124AplIIGGCondicion ;
   private String O1124AplIIGGCondicion ;
   private String O1111AplIIGGTopeCon ;
   private String O1109AplIIGGTopeVar ;
   private String O1121AplIIGGPrrtear ;
   private String O1117AplIIGGExenCon ;
   private String N1109AplIIGGTopeVar ;
   private String N1111AplIIGGTopeCon ;
   private String N1117AplIIGGExenCon ;
   private String N1118ApliIIGGExenOtr ;
   private String N1124AplIIGGCondicion ;
   private String Combo_apliiggtopecon_Selectedvalue_get ;
   private String Combo_apliiggtopevar_Selectedvalue_get ;
   private String Combo_apliiggexencon_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1111AplIIGGTopeCon ;
   private String A1117AplIIGGExenCon ;
   private String A1118ApliIIGGExenOtr ;
   private String A1109AplIIGGTopeVar ;
   private String A1124AplIIGGCondicion ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtAplIIGG_Internalname ;
   private String A1121AplIIGGPrrtear ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtAplIIGG_Jsonclick ;
   private String edtAplIIGGNom_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtAplIIGGPropor_Internalname ;
   private String edtAplIIGGPropor_Jsonclick ;
   private String divTablesplittedapliiggexencon_Internalname ;
   private String lblTextblockapliiggexencon_Internalname ;
   private String lblTextblockapliiggexencon_Jsonclick ;
   private String Combo_apliiggexencon_Caption ;
   private String Combo_apliiggexencon_Cls ;
   private String Combo_apliiggexencon_Datalistproc ;
   private String Combo_apliiggexencon_Internalname ;
   private String edtAplIIGGExenCon_Internalname ;
   private String edtAplIIGGExenCon_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String grpUnnamedgroup3_Internalname ;
   private String tblUnnamedtable2_Internalname ;
   private String divTablesplittedapliiggtopevar_Internalname ;
   private String lblTextblockapliiggtopevar_Internalname ;
   private String lblTextblockapliiggtopevar_Jsonclick ;
   private String Combo_apliiggtopevar_Caption ;
   private String Combo_apliiggtopevar_Cls ;
   private String Combo_apliiggtopevar_Datalistproc ;
   private String Combo_apliiggtopevar_Internalname ;
   private String edtAplIIGGTopeVar_Internalname ;
   private String edtAplIIGGTopeVar_Jsonclick ;
   private String divTablesplittedapliiggtopecon_Internalname ;
   private String lblTextblockapliiggtopecon_Internalname ;
   private String lblTextblockapliiggtopecon_Jsonclick ;
   private String Combo_apliiggtopecon_Caption ;
   private String Combo_apliiggtopecon_Cls ;
   private String Combo_apliiggtopecon_Datalistproc ;
   private String Combo_apliiggtopecon_Internalname ;
   private String edtAplIIGGTopeCon_Internalname ;
   private String edtAplIIGGTopeCon_Jsonclick ;
   private String edtAplIIGGTopeFij_Internalname ;
   private String edtAplIIGGTopeFij_Jsonclick ;
   private String divApliigggrelsec_cell_Internalname ;
   private String divApliigggrelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_apliiggexencon_Internalname ;
   private String edtavComboapliiggexencon_Internalname ;
   private String AV31ComboAplIIGGExenCon ;
   private String edtavComboapliiggexencon_Jsonclick ;
   private String divSectionattribute_apliiggtopevar_Internalname ;
   private String edtavComboapliiggtopevar_Internalname ;
   private String AV27ComboAplIIGGTopeVar ;
   private String edtavComboapliiggtopevar_Jsonclick ;
   private String divSectionattribute_apliiggtopecon_Internalname ;
   private String edtavComboapliiggtopecon_Internalname ;
   private String AV39ComboAplIIGGTopeCon ;
   private String edtavComboapliiggtopecon_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtApliIIGGExenOtr_Internalname ;
   private String edtApliIIGGExenOtr_Jsonclick ;
   private String AV14Insert_AplIIGGTopeVar ;
   private String AV15Insert_AplIIGGTopeCon ;
   private String AV16Insert_AplIIGGExenCon ;
   private String AV17Insert_ApliIIGGExenOtr ;
   private String AV18Insert_AplIIGGCondicion ;
   private String AV42Pgmname ;
   private String Combo_apliiggexencon_Objectcall ;
   private String Combo_apliiggexencon_Class ;
   private String Combo_apliiggexencon_Icontype ;
   private String Combo_apliiggexencon_Icon ;
   private String Combo_apliiggexencon_Tooltip ;
   private String Combo_apliiggexencon_Selectedvalue_set ;
   private String Combo_apliiggexencon_Selectedtext_set ;
   private String Combo_apliiggexencon_Selectedtext_get ;
   private String Combo_apliiggexencon_Gamoauthtoken ;
   private String Combo_apliiggexencon_Ddointernalname ;
   private String Combo_apliiggexencon_Titlecontrolalign ;
   private String Combo_apliiggexencon_Dropdownoptionstype ;
   private String Combo_apliiggexencon_Titlecontrolidtoreplace ;
   private String Combo_apliiggexencon_Datalisttype ;
   private String Combo_apliiggexencon_Datalistfixedvalues ;
   private String Combo_apliiggexencon_Datalistprocparametersprefix ;
   private String Combo_apliiggexencon_Remoteservicesparameters ;
   private String Combo_apliiggexencon_Htmltemplate ;
   private String Combo_apliiggexencon_Multiplevaluestype ;
   private String Combo_apliiggexencon_Loadingdata ;
   private String Combo_apliiggexencon_Noresultsfound ;
   private String Combo_apliiggexencon_Emptyitemtext ;
   private String Combo_apliiggexencon_Onlyselectedvalues ;
   private String Combo_apliiggexencon_Selectalltext ;
   private String Combo_apliiggexencon_Multiplevaluesseparator ;
   private String Combo_apliiggexencon_Addnewoptiontext ;
   private String Combo_apliiggtopevar_Objectcall ;
   private String Combo_apliiggtopevar_Class ;
   private String Combo_apliiggtopevar_Icontype ;
   private String Combo_apliiggtopevar_Icon ;
   private String Combo_apliiggtopevar_Tooltip ;
   private String Combo_apliiggtopevar_Selectedvalue_set ;
   private String Combo_apliiggtopevar_Selectedtext_set ;
   private String Combo_apliiggtopevar_Selectedtext_get ;
   private String Combo_apliiggtopevar_Gamoauthtoken ;
   private String Combo_apliiggtopevar_Ddointernalname ;
   private String Combo_apliiggtopevar_Titlecontrolalign ;
   private String Combo_apliiggtopevar_Dropdownoptionstype ;
   private String Combo_apliiggtopevar_Titlecontrolidtoreplace ;
   private String Combo_apliiggtopevar_Datalisttype ;
   private String Combo_apliiggtopevar_Datalistfixedvalues ;
   private String Combo_apliiggtopevar_Datalistprocparametersprefix ;
   private String Combo_apliiggtopevar_Remoteservicesparameters ;
   private String Combo_apliiggtopevar_Htmltemplate ;
   private String Combo_apliiggtopevar_Multiplevaluestype ;
   private String Combo_apliiggtopevar_Loadingdata ;
   private String Combo_apliiggtopevar_Noresultsfound ;
   private String Combo_apliiggtopevar_Emptyitemtext ;
   private String Combo_apliiggtopevar_Onlyselectedvalues ;
   private String Combo_apliiggtopevar_Selectalltext ;
   private String Combo_apliiggtopevar_Multiplevaluesseparator ;
   private String Combo_apliiggtopevar_Addnewoptiontext ;
   private String Combo_apliiggtopecon_Objectcall ;
   private String Combo_apliiggtopecon_Class ;
   private String Combo_apliiggtopecon_Icontype ;
   private String Combo_apliiggtopecon_Icon ;
   private String Combo_apliiggtopecon_Tooltip ;
   private String Combo_apliiggtopecon_Selectedvalue_set ;
   private String Combo_apliiggtopecon_Selectedtext_set ;
   private String Combo_apliiggtopecon_Selectedtext_get ;
   private String Combo_apliiggtopecon_Gamoauthtoken ;
   private String Combo_apliiggtopecon_Ddointernalname ;
   private String Combo_apliiggtopecon_Titlecontrolalign ;
   private String Combo_apliiggtopecon_Dropdownoptionstype ;
   private String Combo_apliiggtopecon_Titlecontrolidtoreplace ;
   private String Combo_apliiggtopecon_Datalisttype ;
   private String Combo_apliiggtopecon_Datalistfixedvalues ;
   private String Combo_apliiggtopecon_Datalistprocparametersprefix ;
   private String Combo_apliiggtopecon_Remoteservicesparameters ;
   private String Combo_apliiggtopecon_Htmltemplate ;
   private String Combo_apliiggtopecon_Multiplevaluestype ;
   private String Combo_apliiggtopecon_Loadingdata ;
   private String Combo_apliiggtopecon_Noresultsfound ;
   private String Combo_apliiggtopecon_Emptyitemtext ;
   private String Combo_apliiggtopecon_Onlyselectedvalues ;
   private String Combo_apliiggtopecon_Selectalltext ;
   private String Combo_apliiggtopecon_Multiplevaluesseparator ;
   private String Combo_apliiggtopecon_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode126 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean n1117AplIIGGExenCon ;
   private boolean n1118ApliIIGGExenOtr ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean n1124AplIIGGCondicion ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV41aplicadoHay ;
   private boolean Combo_apliiggexencon_Enabled ;
   private boolean Combo_apliiggexencon_Visible ;
   private boolean Combo_apliiggexencon_Allowmultipleselection ;
   private boolean Combo_apliiggexencon_Isgriditem ;
   private boolean Combo_apliiggexencon_Hasdescription ;
   private boolean Combo_apliiggexencon_Includeonlyselectedoption ;
   private boolean Combo_apliiggexencon_Includeselectalloption ;
   private boolean Combo_apliiggexencon_Emptyitem ;
   private boolean Combo_apliiggexencon_Includeaddnewoption ;
   private boolean Combo_apliiggtopevar_Enabled ;
   private boolean Combo_apliiggtopevar_Visible ;
   private boolean Combo_apliiggtopevar_Allowmultipleselection ;
   private boolean Combo_apliiggtopevar_Isgriditem ;
   private boolean Combo_apliiggtopevar_Hasdescription ;
   private boolean Combo_apliiggtopevar_Includeonlyselectedoption ;
   private boolean Combo_apliiggtopevar_Includeselectalloption ;
   private boolean Combo_apliiggtopevar_Emptyitem ;
   private boolean Combo_apliiggtopevar_Includeaddnewoption ;
   private boolean Combo_apliiggtopecon_Enabled ;
   private boolean Combo_apliiggtopecon_Visible ;
   private boolean Combo_apliiggtopecon_Allowmultipleselection ;
   private boolean Combo_apliiggtopecon_Isgriditem ;
   private boolean Combo_apliiggtopecon_Hasdescription ;
   private boolean Combo_apliiggtopecon_Includeonlyselectedoption ;
   private boolean Combo_apliiggtopecon_Includeselectalloption ;
   private boolean Combo_apliiggtopecon_Emptyitem ;
   private boolean Combo_apliiggtopecon_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n1112AplIIGG ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean ZV41aplicadoHay ;
   private String A2028AplIIGGOld ;
   private String AV24Combo_DataJson ;
   private String Z2028AplIIGGOld ;
   private String Z1113AplIIGGNom ;
   private String Z2020AplIIGGRelRef ;
   private String O1113AplIIGGNom ;
   private String A1113AplIIGGNom ;
   private String A2020AplIIGGRelRef ;
   private String AV22ComboSelectedValue ;
   private String AV23ComboSelectedText ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_apliiggexencon ;
   private com.genexus.webpanels.GXUserControl ucCombo_apliiggtopevar ;
   private com.genexus.webpanels.GXUserControl ucCombo_apliiggtopecon ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbAplIIGGTrat ;
   private HTMLChoice cmbAplIIGGPrrtear ;
   private HTMLChoice dynAplIIGGCondicion ;
   private HTMLChoice cmbAplIIGGTopeTip ;
   private HTMLChoice dynAplIIGGgRelSec ;
   private IDataStoreProvider pr_default ;
   private short[] T003710_A1112AplIIGG ;
   private boolean[] T003710_n1112AplIIGG ;
   private String[] T003710_A1113AplIIGGNom ;
   private byte[] T003710_A1120AplIIGGTrat ;
   private java.math.BigDecimal[] T003710_A1114AplIIGGPropor ;
   private byte[] T003710_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] T003710_A1119AplIIGGTopeFij ;
   private String[] T003710_A1121AplIIGGPrrtear ;
   private int[] T003710_A1998AplIIGGgRelSec ;
   private int[] T003710_A1999AplIIGGRelSecCli ;
   private short[] T003710_A2000AplIIGGPadre ;
   private String[] T003710_A2020AplIIGGRelRef ;
   private String[] T003710_A2028AplIIGGOld ;
   private int[] T003710_A3CliCod ;
   private String[] T003710_A1111AplIIGGTopeCon ;
   private boolean[] T003710_n1111AplIIGGTopeCon ;
   private String[] T003710_A1117AplIIGGExenCon ;
   private boolean[] T003710_n1117AplIIGGExenCon ;
   private String[] T003710_A1118ApliIIGGExenOtr ;
   private boolean[] T003710_n1118ApliIIGGExenOtr ;
   private String[] T003710_A1109AplIIGGTopeVar ;
   private boolean[] T003710_n1109AplIIGGTopeVar ;
   private String[] T003710_A1124AplIIGGCondicion ;
   private boolean[] T003710_n1124AplIIGGCondicion ;
   private int[] T00374_A3CliCod ;
   private int[] T00375_A3CliCod ;
   private int[] T00376_A3CliCod ;
   private int[] T00377_A3CliCod ;
   private int[] T00378_A3CliCod ;
   private int[] T00379_A3CliCod ;
   private int[] T003711_A3CliCod ;
   private int[] T003712_A3CliCod ;
   private int[] T003713_A3CliCod ;
   private int[] T003714_A3CliCod ;
   private int[] T003715_A3CliCod ;
   private int[] T003716_A3CliCod ;
   private int[] T003717_A3CliCod ;
   private short[] T003717_A1112AplIIGG ;
   private boolean[] T003717_n1112AplIIGG ;
   private short[] T00373_A1112AplIIGG ;
   private boolean[] T00373_n1112AplIIGG ;
   private String[] T00373_A1113AplIIGGNom ;
   private byte[] T00373_A1120AplIIGGTrat ;
   private java.math.BigDecimal[] T00373_A1114AplIIGGPropor ;
   private byte[] T00373_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] T00373_A1119AplIIGGTopeFij ;
   private String[] T00373_A1121AplIIGGPrrtear ;
   private int[] T00373_A1998AplIIGGgRelSec ;
   private int[] T00373_A1999AplIIGGRelSecCli ;
   private short[] T00373_A2000AplIIGGPadre ;
   private String[] T00373_A2020AplIIGGRelRef ;
   private String[] T00373_A2028AplIIGGOld ;
   private int[] T00373_A3CliCod ;
   private String[] T00373_A1111AplIIGGTopeCon ;
   private boolean[] T00373_n1111AplIIGGTopeCon ;
   private String[] T00373_A1117AplIIGGExenCon ;
   private boolean[] T00373_n1117AplIIGGExenCon ;
   private String[] T00373_A1118ApliIIGGExenOtr ;
   private boolean[] T00373_n1118ApliIIGGExenOtr ;
   private String[] T00373_A1109AplIIGGTopeVar ;
   private boolean[] T00373_n1109AplIIGGTopeVar ;
   private String[] T00373_A1124AplIIGGCondicion ;
   private boolean[] T00373_n1124AplIIGGCondicion ;
   private int[] T003718_A3CliCod ;
   private short[] T003718_A1112AplIIGG ;
   private boolean[] T003718_n1112AplIIGG ;
   private int[] T003719_A3CliCod ;
   private short[] T003719_A1112AplIIGG ;
   private boolean[] T003719_n1112AplIIGG ;
   private short[] T00372_A1112AplIIGG ;
   private boolean[] T00372_n1112AplIIGG ;
   private String[] T00372_A1113AplIIGGNom ;
   private byte[] T00372_A1120AplIIGGTrat ;
   private java.math.BigDecimal[] T00372_A1114AplIIGGPropor ;
   private byte[] T00372_A1115AplIIGGTopeTip ;
   private java.math.BigDecimal[] T00372_A1119AplIIGGTopeFij ;
   private String[] T00372_A1121AplIIGGPrrtear ;
   private int[] T00372_A1998AplIIGGgRelSec ;
   private int[] T00372_A1999AplIIGGRelSecCli ;
   private short[] T00372_A2000AplIIGGPadre ;
   private String[] T00372_A2020AplIIGGRelRef ;
   private String[] T00372_A2028AplIIGGOld ;
   private int[] T00372_A3CliCod ;
   private String[] T00372_A1111AplIIGGTopeCon ;
   private boolean[] T00372_n1111AplIIGGTopeCon ;
   private String[] T00372_A1117AplIIGGExenCon ;
   private boolean[] T00372_n1117AplIIGGExenCon ;
   private String[] T00372_A1118ApliIIGGExenOtr ;
   private boolean[] T00372_n1118ApliIIGGExenOtr ;
   private String[] T00372_A1109AplIIGGTopeVar ;
   private boolean[] T00372_n1109AplIIGGTopeVar ;
   private String[] T00372_A1124AplIIGGCondicion ;
   private boolean[] T00372_n1124AplIIGGCondicion ;
   private int[] T003723_A3CliCod ;
   private short[] T003723_A1EmpCod ;
   private short[] T003723_A1129LiqExAnio ;
   private int[] T003723_A31LiqNro ;
   private int[] T003723_A6LegNumero ;
   private String[] T003723_A1127LiqExenConCodigo ;
   private short[] T003723_A1128LiqExAplIIGG ;
   private int[] T003724_A3CliCod ;
   private short[] T003724_A1EmpCod ;
   private short[] T003724_A869LiqLegConAnio ;
   private int[] T003724_A6LegNumero ;
   private String[] T003724_A26ConCodigo ;
   private int[] T003724_A1097LiqAltaNro ;
   private int[] T003724_A1098LiqNuevaNro ;
   private int[] T003725_A3CliCod ;
   private String[] T003725_A26ConCodigo ;
   private int[] T003726_A3CliCod ;
   private String[] T003726_A26ConCodigo ;
   private int[] T003727_A3CliCod ;
   private String[] T003727_A26ConCodigo ;
   private int[] T003728_A3CliCod ;
   private String[] T003728_A26ConCodigo ;
   private int[] T003729_A3CliCod ;
   private String[] T003729_A26ConCodigo ;
   private int[] T003730_A3CliCod ;
   private String[] T003730_A26ConCodigo ;
   private int[] T003731_A3CliCod ;
   private String[] T003731_A26ConCodigo ;
   private int[] T003732_A3CliCod ;
   private String[] T003732_A26ConCodigo ;
   private int[] T003733_A3CliCod ;
   private String[] T003733_A26ConCodigo ;
   private int[] T003734_A3CliCod ;
   private String[] T003734_A26ConCodigo ;
   private int[] T003735_A3CliCod ;
   private String[] T003735_A26ConCodigo ;
   private int[] T003736_A3CliCod ;
   private String[] T003736_A26ConCodigo ;
   private int[] T003737_A3CliCod ;
   private String[] T003737_A26ConCodigo ;
   private int[] T003738_A3CliCod ;
   private String[] T003738_A26ConCodigo ;
   private int[] T003739_A3CliCod ;
   private String[] T003739_A26ConCodigo ;
   private int[] T003740_A3CliCod ;
   private String[] T003740_A26ConCodigo ;
   private int[] T003741_A3CliCod ;
   private String[] T003741_A26ConCodigo ;
   private int[] T003742_A3CliCod ;
   private String[] T003742_A26ConCodigo ;
   private int[] T003743_A3CliCod ;
   private String[] T003743_A26ConCodigo ;
   private int[] T003744_A3CliCod ;
   private String[] T003744_A26ConCodigo ;
   private int[] T003745_A3CliCod ;
   private String[] T003745_A26ConCodigo ;
   private int[] T003746_A3CliCod ;
   private String[] T003746_A26ConCodigo ;
   private int[] T003747_A3CliCod ;
   private String[] T003747_A26ConCodigo ;
   private int[] T003748_A3CliCod ;
   private String[] T003748_A26ConCodigo ;
   private int[] T003749_A3CliCod ;
   private String[] T003749_A26ConCodigo ;
   private int[] T003750_A3CliCod ;
   private String[] T003750_A26ConCodigo ;
   private int[] T003751_A3CliCod ;
   private String[] T003751_A26ConCodigo ;
   private int[] T003752_A3CliCod ;
   private String[] T003752_A26ConCodigo ;
   private int[] T003753_A3CliCod ;
   private String[] T003753_A26ConCodigo ;
   private int[] T003754_A3CliCod ;
   private String[] T003754_A26ConCodigo ;
   private int[] T003755_A3CliCod ;
   private String[] T003755_A26ConCodigo ;
   private int[] T003756_A3CliCod ;
   private String[] T003756_A26ConCodigo ;
   private int[] T003757_A3CliCod ;
   private String[] T003757_A26ConCodigo ;
   private int[] T003758_A3CliCod ;
   private String[] T003758_A26ConCodigo ;
   private int[] T003759_A3CliCod ;
   private String[] T003759_A26ConCodigo ;
   private int[] T003760_A3CliCod ;
   private String[] T003760_A26ConCodigo ;
   private int[] T003761_A3CliCod ;
   private String[] T003761_A26ConCodigo ;
   private int[] T003762_A3CliCod ;
   private String[] T003762_A26ConCodigo ;
   private int[] T003763_A3CliCod ;
   private String[] T003763_A26ConCodigo ;
   private int[] T003764_A3CliCod ;
   private String[] T003764_A26ConCodigo ;
   private int[] T003765_A3CliCod ;
   private String[] T003765_A26ConCodigo ;
   private int[] T003766_A3CliCod ;
   private String[] T003766_A26ConCodigo ;
   private int[] T003767_A3CliCod ;
   private String[] T003767_A26ConCodigo ;
   private int[] T003768_A3CliCod ;
   private String[] T003768_A26ConCodigo ;
   private int[] T003769_A3CliCod ;
   private String[] T003769_A26ConCodigo ;
   private int[] T003770_A3CliCod ;
   private String[] T003770_A26ConCodigo ;
   private int[] T003771_A3CliCod ;
   private String[] T003771_A26ConCodigo ;
   private int[] T003772_A3CliCod ;
   private String[] T003772_A26ConCodigo ;
   private int[] T003773_A3CliCod ;
   private String[] T003773_A26ConCodigo ;
   private int[] T003774_A3CliCod ;
   private String[] T003774_A26ConCodigo ;
   private int[] T003775_A3CliCod ;
   private String[] T003775_A26ConCodigo ;
   private int[] T003776_A3CliCod ;
   private String[] T003776_A26ConCodigo ;
   private int[] T003777_A3CliCod ;
   private String[] T003777_A26ConCodigo ;
   private int[] T003778_A3CliCod ;
   private String[] T003778_A26ConCodigo ;
   private int[] T003779_A3CliCod ;
   private String[] T003779_A26ConCodigo ;
   private int[] T003780_A3CliCod ;
   private String[] T003780_A26ConCodigo ;
   private int[] T003781_A3CliCod ;
   private short[] T003781_A1112AplIIGG ;
   private boolean[] T003781_n1112AplIIGG ;
   private int[] T003782_A3CliCod ;
   private String[] T003782_A1105CondExenIIGG ;
   private String[] T003782_A1108CondexenIIGGNom ;
   private int[] T003783_A3CliCod ;
   private int[] T003783_A1885CliRelSec ;
   private String[] T003783_A1880CliReDTChar ;
   private int[] T003784_A3CliCod ;
   private int[] T003785_A3CliCod ;
   private int[] T003786_A3CliCod ;
   private int[] T003787_A3CliCod ;
   private int[] T003788_A3CliCod ;
   private int[] T003789_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV30AplIIGGExenCon_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV26AplIIGGTopeVar_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV38AplIIGGTopeCon_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV19TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class tipo_aplicacion_ganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00372", "SELECT AplIIGG, AplIIGGNom, AplIIGGTrat, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTopeFij, AplIIGGPrrtear, AplIIGGgRelSec, AplIIGGRelSecCli, AplIIGGPadre, AplIIGGRelRef, AplIIGGOld, CliCod, AplIIGGTopeCon, AplIIGGExenCon, ApliIIGGExenOtr, AplIIGGTopeVar, AplIIGGCondicion FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ?  FOR UPDATE OF tipo_aplicacion_ganancias NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00373", "SELECT AplIIGG, AplIIGGNom, AplIIGGTrat, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTopeFij, AplIIGGPrrtear, AplIIGGgRelSec, AplIIGGRelSecCli, AplIIGGPadre, AplIIGGRelRef, AplIIGGOld, CliCod, AplIIGGTopeCon, AplIIGGExenCon, ApliIIGGExenOtr, AplIIGGTopeVar, AplIIGGCondicion FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00374", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00375", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00376", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00377", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00378", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00379", "SELECT CliCod FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003710", "SELECT TM1.AplIIGG, TM1.AplIIGGNom, TM1.AplIIGGTrat, TM1.AplIIGGPropor, TM1.AplIIGGTopeTip, TM1.AplIIGGTopeFij, TM1.AplIIGGPrrtear, TM1.AplIIGGgRelSec, TM1.AplIIGGRelSecCli, TM1.AplIIGGPadre, TM1.AplIIGGRelRef, TM1.AplIIGGOld, TM1.CliCod, TM1.AplIIGGTopeCon AS AplIIGGTopeCon, TM1.AplIIGGExenCon AS AplIIGGExenCon, TM1.ApliIIGGExenOtr AS ApliIIGGExenOtr, TM1.AplIIGGTopeVar AS AplIIGGTopeVar, TM1.AplIIGGCondicion AS AplIIGGCondicion FROM tipo_aplicacion_ganancias TM1 WHERE TM1.CliCod = ? and TM1.AplIIGG = ? ORDER BY TM1.CliCod, TM1.AplIIGG ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003711", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003712", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003713", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003714", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003715", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003716", "SELECT CliCod FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003717", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE CliCod = ? AND AplIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003718", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE ( CliCod > ? or CliCod = ? and AplIIGG > ?) ORDER BY CliCod, AplIIGG  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003719", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias WHERE ( CliCod < ? or CliCod = ? and AplIIGG < ?) ORDER BY CliCod DESC, AplIIGG DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T003720", "SAVEPOINT gxupdate;INSERT INTO tipo_aplicacion_ganancias(AplIIGG, AplIIGGNom, AplIIGGTrat, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTopeFij, AplIIGGPrrtear, AplIIGGgRelSec, AplIIGGRelSecCli, AplIIGGPadre, AplIIGGRelRef, AplIIGGOld, CliCod, AplIIGGTopeCon, AplIIGGExenCon, ApliIIGGExenOtr, AplIIGGTopeVar, AplIIGGCondicion) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003721", "SAVEPOINT gxupdate;UPDATE tipo_aplicacion_ganancias SET AplIIGGNom=?, AplIIGGTrat=?, AplIIGGPropor=?, AplIIGGTopeTip=?, AplIIGGTopeFij=?, AplIIGGPrrtear=?, AplIIGGgRelSec=?, AplIIGGRelSecCli=?, AplIIGGPadre=?, AplIIGGRelRef=?, AplIIGGOld=?, AplIIGGTopeCon=?, AplIIGGExenCon=?, ApliIIGGExenOtr=?, AplIIGGTopeVar=?, AplIIGGCondicion=?  WHERE CliCod = ? AND AplIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T003722", "SAVEPOINT gxupdate;DELETE FROM tipo_aplicacion_ganancias  WHERE CliCod = ? AND AplIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T003723", "SELECT CliCod, EmpCod, LiqExAnio, LiqNro, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion WHERE CliCod = ? AND LiqExAplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003724", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND LiqLegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003725", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliPadre = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003726", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003727", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003728", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003729", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003730", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003731", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003732", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003733", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003734", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003735", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003736", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003737", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003738", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003739", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003740", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003741", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003742", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003743", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003744", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003745", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003746", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003747", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003748", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003749", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003750", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003751", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003752", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003753", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003754", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003755", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003756", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003757", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003758", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003759", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003760", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003761", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003762", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003763", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003764", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003765", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003766", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003767", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003768", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003769", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003770", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003771", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003772", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003773", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003774", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003775", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003776", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003777", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003778", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003779", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003780", "SELECT CliCod, ConCodigo FROM Concepto WHERE CliCod = ? AND AplIIGG = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T003781", "SELECT CliCod, AplIIGG FROM tipo_aplicacion_ganancias ORDER BY CliCod, AplIIGG ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003782", "SELECT CliCod, CondExenIIGG, CondexenIIGGNom FROM condicion_exencion_iigg WHERE CliCod = ? ORDER BY CondexenIIGGNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003783", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003784", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003785", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003786", "SELECT CliCod FROM condicion_exencion_iigg WHERE CliCod = ? AND CondExenIIGG = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003787", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003788", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T003789", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(16, 10);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(17, 40);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(16, 10);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(17, 40);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getString(15, 10);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(16, 10);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getString(17, 40);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(18, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 58 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 61 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
               }
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setByte(3, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 4);
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[6], 2);
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setShort(10, ((Number) parms[10]).shortValue());
               stmt.setVarchar(11, (String)parms[11], 40, false);
               stmt.setNLongVarchar(12, (String)parms[12], false);
               stmt.setInt(13, ((Number) parms[13]).intValue());
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 10);
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[17], 10);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[19], 10);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(17, (String)parms[21], 40);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[23], 20);
               }
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[12], 10);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[14], 10);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[16], 10);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[18], 40);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[20], 20);
               }
               stmt.setInt(17, ((Number) parms[21]).intValue());
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(18, ((Number) parms[23]).shortValue());
               }
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 40);
               }
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
      }
   }

}

