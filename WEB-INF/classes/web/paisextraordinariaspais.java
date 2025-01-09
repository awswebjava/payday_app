package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisextraordinariaspais", "/web.paisextraordinariaspais"})
public final  class paisextraordinariaspais extends GXWebObjectStub
{
   public paisextraordinariaspais( )
   {
   }

   public paisextraordinariaspais( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisextraordinariaspais.class ));
   }

   public paisextraordinariaspais( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisextraordinariaspais_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisextraordinariaspais_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais Extraordinarias Pais";
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

