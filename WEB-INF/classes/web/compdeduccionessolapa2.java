package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.compdeduccionessolapa2", "/web.compdeduccionessolapa2"})
public final  class compdeduccionessolapa2 extends GXWebObjectStub
{
   public compdeduccionessolapa2( )
   {
   }

   public compdeduccionessolapa2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( compdeduccionessolapa2.class ));
   }

   public compdeduccionessolapa2( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new compdeduccionessolapa2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new compdeduccionessolapa2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Comp Deducciones Solapa2";
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

