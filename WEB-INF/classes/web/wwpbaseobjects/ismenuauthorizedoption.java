package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ismenuauthorizedoption extends GXProcedure
{
   public ismenuauthorizedoption( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ismenuauthorizedoption.class ), "" );
   }

   public ismenuauthorizedoption( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( web.wwpbaseobjects.SdtDVelop_Menu_Item aP0 )
   {
      ismenuauthorizedoption.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( web.wwpbaseobjects.SdtDVelop_Menu_Item aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( web.wwpbaseobjects.SdtDVelop_Menu_Item aP0 ,
                             boolean[] aP1 )
   {
      ismenuauthorizedoption.this.AV9DVelop_Menu_Item = aP0;
      ismenuauthorizedoption.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(GXutil.lower( AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey()), "public") == 0 )
      {
         AV11IsAuthorized = true ;
      }
      else if ( ! (GXutil.strcmp("", AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey())==0) )
      {
         GXt_boolean1 = AV11IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Authorizationkey(), GXv_boolean2) ;
         ismenuauthorizedoption.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV11IsAuthorized = GXt_boolean1 ;
      }
      else
      {
         AV13Url = AV9DVelop_Menu_Item.getgxTv_SdtDVelop_Menu_Item_Link() ;
         if ( ! (GXutil.strcmp("", AV13Url)==0) )
         {
            /* Execute user subroutine: 'GET AUTHORIZATION KEY FROM URL' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXt_boolean1 = AV11IsAuthorized ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new web.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( AV8AuthorizationKey, GXv_boolean2) ;
            ismenuauthorizedoption.this.GXt_boolean1 = GXv_boolean2[0] ;
            AV11IsAuthorized = GXt_boolean1 ;
         }
         else
         {
            AV11IsAuthorized = true ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GET AUTHORIZATION KEY FROM URL' Routine */
      returnInSub = false ;
      AV8AuthorizationKey = "" ;
      AV16UrlResourceNameWithExtension = "" ;
      AV15UrlResourceName = "" ;
      if ( ! (GXutil.strcmp("", AV13Url)==0) )
      {
         AV10i = (short)(GXutil.strSearchRev( AV13Url, "/", -1)) ;
         if ( AV10i > 0 )
         {
            AV13Url = GXutil.substring( AV13Url, AV10i+1, GXutil.len( GXutil.trim( AV13Url))-AV10i) ;
         }
         else
         {
            AV13Url = GXutil.trim( AV13Url) ;
         }
         if ( GXutil.strSearchRev( AV13Url, "?", -1) > 0 )
         {
            AV13Url = GXutil.substring( AV13Url, 1, GXutil.strSearchRev( AV13Url, "?", -1)-1) ;
         }
         if ( GxRegex.IsMatch(AV13Url,httpContext.getMessage( ".aspx", "")) )
         {
            AV15UrlResourceName = GXutil.strReplace( AV13Url, httpContext.getMessage( ".aspx", ""), "") ;
         }
         else
         {
            AV10i = (short)(GXutil.strSearch( AV16UrlResourceNameWithExtension, ".", 1)) ;
            AV12j = (short)(GXutil.strSearchRev( AV16UrlResourceNameWithExtension, ".", -1)) ;
            if ( ( AV10i == 0 ) && ( AV12j == 0 ) )
            {
               AV15UrlResourceName = AV16UrlResourceNameWithExtension ;
            }
            else
            {
               if ( AV10i != AV12j )
               {
                  AV14UrlObjectName = GXutil.substring( AV16UrlResourceNameWithExtension, AV12j+1, GXutil.len( AV16UrlResourceNameWithExtension)-AV12j) ;
                  AV15UrlResourceName = GXutil.substring( AV16UrlResourceNameWithExtension, AV10i+1, AV12j-AV10i-1) ;
                  AV10i = (short)(GXutil.strSearch( AV15UrlResourceName, ".", 1)) ;
                  if ( AV10i > 0 )
                  {
                     AV15UrlResourceName = GXutil.substring( AV15UrlResourceName, AV10i+1, GXutil.len( AV15UrlResourceName)+AV10i) + "." ;
                  }
                  AV15UrlResourceName += AV14UrlObjectName ;
               }
               else
               {
                  AV15UrlResourceName = GXutil.substring( AV16UrlResourceNameWithExtension, AV10i+1, GXutil.len( GXutil.trim( AV16UrlResourceNameWithExtension))-AV10i) ;
               }
            }
         }
         AV8AuthorizationKey = GXutil.lower( GXutil.trim( AV15UrlResourceName)) ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = ismenuauthorizedoption.this.AV11IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Url = "" ;
      AV8AuthorizationKey = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV16UrlResourceNameWithExtension = "" ;
      AV15UrlResourceName = "" ;
      AV14UrlObjectName = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10i ;
   private short AV12j ;
   private short Gx_err ;
   private String AV16UrlResourceNameWithExtension ;
   private String AV15UrlResourceName ;
   private boolean AV11IsAuthorized ;
   private boolean returnInSub ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV13Url ;
   private String AV8AuthorizationKey ;
   private String AV14UrlObjectName ;
   private boolean[] aP1 ;
   private web.wwpbaseobjects.SdtDVelop_Menu_Item AV9DVelop_Menu_Item ;
}

