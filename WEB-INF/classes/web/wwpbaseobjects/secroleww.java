package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secroleww", "/web.wwpbaseobjects.secroleww"})
public final  class secroleww extends GXWebObjectStub
{
   public secroleww( )
   {
   }

   public secroleww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secroleww.class ));
   }

   public secroleww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secroleww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secroleww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Role";
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

}

