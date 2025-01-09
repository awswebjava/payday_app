package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class darerrormenorcero extends GXProcedure
{
   public darerrormenorcero( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( darerrormenorcero.class ), "" );
   }

   public darerrormenorcero( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( java.math.BigDecimal aP0 ,
                           String[] aP1 ,
                           String[] aP2 )
   {
      darerrormenorcero.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             byte[] aP3 )
   {
      darerrormenorcero.this.AV8Importes = aP0;
      darerrormenorcero.this.AV10error = aP1[0];
      this.aP1 = aP1;
      darerrormenorcero.this.AV11LiqDLog = aP2[0];
      this.aP2 = aP2;
      darerrormenorcero.this.AV9LiqDCalculado = aP3[0];
      this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8Importes.doubleValue() < 0 )
      {
         AV9LiqDCalculado = (byte)(0) ;
         AV10error = httpContext.getMessage( "Error en el cálculo. El importe no puede ser menor a cero", "") ;
         AV11LiqDLog += ". " + GXutil.trim( AV10error) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = darerrormenorcero.this.AV10error;
      this.aP2[0] = darerrormenorcero.this.AV11LiqDLog;
      this.aP3[0] = darerrormenorcero.this.AV9LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private short Gx_err ;
   private java.math.BigDecimal AV8Importes ;
   private String AV11LiqDLog ;
   private String AV10error ;
   private byte[] aP3 ;
   private String[] aP1 ;
   private String[] aP2 ;
}

