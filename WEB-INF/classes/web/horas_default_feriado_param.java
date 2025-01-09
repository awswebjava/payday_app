package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horas_default_feriado_param extends GXProcedure
{
   public horas_default_feriado_param( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horas_default_feriado_param.class ), "" );
   }

   public horas_default_feriado_param( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      horas_default_feriado_param.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      horas_default_feriado_param.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8parmcod = httpContext.getMessage( "HOR_DEF_FER", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = horas_default_feriado_param.this.AV8parmcod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8parmcod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8parmcod ;
   private String[] aP0 ;
}

