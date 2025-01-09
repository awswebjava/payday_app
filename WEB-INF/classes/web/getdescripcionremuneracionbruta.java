package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdescripcionremuneracionbruta extends GXProcedure
{
   public getdescripcionremuneracionbruta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdescripcionremuneracionbruta.class ), "" );
   }

   public getdescripcionremuneracionbruta( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getdescripcionremuneracionbruta.this.aP1 = new String[] {""};
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
      getdescripcionremuneracionbruta.this.AV9CliCod = aP0;
      getdescripcionremuneracionbruta.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ConDescrip = httpContext.getMessage( "SUELDO BRUTO", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getdescripcionremuneracionbruta.this.AV8ConDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConDescrip = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8ConDescrip ;
   private String[] aP1 ;
}

