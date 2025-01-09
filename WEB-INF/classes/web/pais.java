package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.pais", "/web.pais"})
public final  class pais extends GXWebObjectStub
{
   public pais( )
   {
   }

   public pais( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( pais.class ));
   }

   public pais( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pais_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pais_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais";
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
      return "pais_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

