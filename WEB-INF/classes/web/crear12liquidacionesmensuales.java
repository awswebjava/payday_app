package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crear12liquidacionesmensuales extends GXProcedure
{
   public crear12liquidacionesmensuales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crear12liquidacionesmensuales.class ), "" );
   }

   public crear12liquidacionesmensuales( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        short aP4 ,
                        byte aP5 ,
                        short[] aP6 ,
                        boolean aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             short aP4 ,
                             byte aP5 ,
                             short[] aP6 ,
                             boolean aP7 )
   {
      crear12liquidacionesmensuales.this.AV11CliCod = aP0;
      crear12liquidacionesmensuales.this.AV8EmpCod = aP1;
      crear12liquidacionesmensuales.this.AV17LegNumero = aP2;
      crear12liquidacionesmensuales.this.AV25LiqPerAno = aP3;
      crear12liquidacionesmensuales.this.AV39cuantasParm = aP4;
      crear12liquidacionesmensuales.this.AV15LiqClase = aP5;
      crear12liquidacionesmensuales.this.AV44mesDesde = aP6[0];
      this.aP6 = aP6;
      crear12liquidacionesmensuales.this.AV50recalcularEnUltima = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = crear12liquidacionesmensuales.this.AV44mesDesde;
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

   private byte AV15LiqClase ;
   private short AV8EmpCod ;
   private short AV25LiqPerAno ;
   private short AV39cuantasParm ;
   private short AV44mesDesde ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV17LegNumero ;
   private boolean AV50recalcularEnUltima ;
   private short[] aP6 ;
}

