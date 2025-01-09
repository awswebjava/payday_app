package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.secrolefunroleactionassociationww", "/web.wwpbaseobjects.secrolefunroleactionassociationww"})
public final  class secrolefunroleactionassociationww extends GXWebObjectStub
{
   public secrolefunroleactionassociationww( )
   {
   }

   public secrolefunroleactionassociationww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( secrolefunroleactionassociationww.class ));
   }

   public secrolefunroleactionassociationww( int remoteHandle ,
                                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new secrolefunroleactionassociationww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new secrolefunroleactionassociationww_impl(context).cleanup();
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

