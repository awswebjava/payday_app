package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class txterrorrelease extends GXProcedure
{
   public txterrorrelease( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( txterrorrelease.class ), "" );
   }

   public txterrorrelease( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      txterrorrelease.this.aP1 = new String[] {""};
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
      txterrorrelease.this.AV9CliCod = aP0;
      txterrorrelease.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8txt = httpContext.getMessage( "Debe ingresar una fecha de liberación superior porque al menos un cliente ya ha actualizado con esta versión", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = txterrorrelease.this.AV8txt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8txt = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8txt ;
   private String[] aP1 ;
}

