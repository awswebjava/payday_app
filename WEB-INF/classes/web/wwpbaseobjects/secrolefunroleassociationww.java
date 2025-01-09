package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secrolefunroleassociationww", "/web.wwpbaseobjects.secrolefunroleassociationww"})
public final  class secrolefunroleassociationww extends GXWebObjectStub
{
   public secrolefunroleassociationww( )
   {
   }

   public secrolefunroleassociationww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secrolefunroleassociationww.class ));
   }

   public secrolefunroleassociationww( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secrolefunroleassociationww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secrolefunroleassociationww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Associated to Role";
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

