package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajolicenciaswc", "/web.legajolicenciaswc"})
public final  class legajolicenciaswc extends GXWebObjectStub
{
   public legajolicenciaswc( )
   {
   }

   public legajolicenciaswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajolicenciaswc.class ));
   }

   public legajolicenciaswc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajolicenciaswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajolicenciaswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Licencias WC";
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

