package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnavulturl extends GXProcedure
{
   public getnavulturl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnavulturl.class ), "" );
   }

   public getnavulturl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getnavulturl.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getnavulturl.this.AV11CliCod = aP0;
      getnavulturl.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8sdt_nav.fromJSonString(AV9websession.getValue(httpContext.getMessage( "navegacion", "")), null);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV15Pgmname, httpContext.getMessage( "&sdt_nav ", "")+AV8sdt_nav.toJSonString(false)) ;
      if ( AV8sdt_nav.size() >= 2 )
      {
         AV12i = (short)(AV8sdt_nav.size()-1) ;
         AV10URL = ((web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem)AV8sdt_nav.elementAt(-1+AV12i)).getgxTv_Sdtsdt_nav_sdt_navItem_Url() ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV15Pgmname, httpContext.getMessage( "&&URL ", "")+AV10URL) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnavulturl.this.AV10URL;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10URL = "" ;
      AV8sdt_nav = new GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem>(web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem.class, "sdt_navItem", "PayDay", remoteHandle);
      AV9websession = httpContext.getWebSession();
      AV15Pgmname = "" ;
      AV15Pgmname = "getNavUltURL" ;
      /* GeneXus formulas. */
      AV15Pgmname = "getNavUltURL" ;
      Gx_err = (short)(0) ;
   }

   private short AV12i ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String AV15Pgmname ;
   private String AV10URL ;
   private com.genexus.webpanels.WebSession AV9websession ;
   private String[] aP1 ;
   private GXBaseCollection<web.wwpbaseobjects.Sdtsdt_nav_sdt_navItem> AV8sdt_nav ;
}

