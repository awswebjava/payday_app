package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descripcionerrordependencia extends GXProcedure
{
   public descripcionerrordependencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descripcionerrordependencia.class ), "" );
   }

   public descripcionerrordependencia( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      descripcionerrordependencia.this.aP1 = new String[] {""};
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
      descripcionerrordependencia.this.AV9CliCod = aP0;
      descripcionerrordependencia.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Error = httpContext.getMessage( "No se pudo calcular el concepto porque alguna dependencia no fué resuelta.", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = descripcionerrordependencia.this.AV8Error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Error = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8Error ;
   private String[] aP1 ;
}

