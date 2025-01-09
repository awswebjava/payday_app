package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajemigrselvalida extends GXProcedure
{
   public mensajemigrselvalida( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajemigrselvalida.class ), "" );
   }

   public mensajemigrselvalida( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      mensajemigrselvalida.this.aP1 = new String[] {""};
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
      mensajemigrselvalida.this.AV9CliCod = aP0;
      mensajemigrselvalida.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "(Seleccione una opción válida)", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = mensajemigrselvalida.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8texto ;
   private String[] aP1 ;
}
