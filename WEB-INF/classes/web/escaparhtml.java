package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escaparhtml extends GXProcedure
{
   public escaparhtml( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escaparhtml.class ), "" );
   }

   public escaparhtml( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      escaparhtml.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      escaparhtml.this.AV8valor = aP0;
      escaparhtml.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9valorEscapado = AV8valor ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "&", httpContext.getMessage( "_y_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "<", httpContext.getMessage( "_l_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, ">", httpContext.getMessage( "_g_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "\"", httpContext.getMessage( "_q_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "'", httpContext.getMessage( "_k_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, ";", httpContext.getMessage( "_f_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "!", httpContext.getMessage( "_v_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "/", httpContext.getMessage( "_r_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "%", httpContext.getMessage( "_p_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "{", httpContext.getMessage( "_a_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "}", httpContext.getMessage( "_b_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, ":", httpContext.getMessage( "_c_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, "(", httpContext.getMessage( "_d_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, ")", httpContext.getMessage( "_e_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, GXutil.chr( (short)(10)), httpContext.getMessage( "_n_", "")) ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, GXutil.chr( (short)(13)), "_x_") ;
      AV9valorEscapado = GXutil.strReplace( AV9valorEscapado, GXutil.chr( (short)(9)), httpContext.getMessage( "_t_", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = escaparhtml.this.AV9valorEscapado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9valorEscapado = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8valor ;
   private String AV9valorEscapado ;
   private String[] aP1 ;
}

