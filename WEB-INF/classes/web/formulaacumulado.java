package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulaacumulado extends GXProcedure
{
   public formulaacumulado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulaacumulado.class ), "" );
   }

   public formulaacumulado( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      formulaacumulado.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      formulaacumulado.this.AV11CliCod = aP0;
      formulaacumulado.this.AV10mesPeriodoPalabra = aP1;
      formulaacumulado.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8palabra = " / 12 *  " + GXutil.trim( AV10mesPeriodoPalabra) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = formulaacumulado.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV10mesPeriodoPalabra ;
   private String AV8palabra ;
   private String[] aP2 ;
}

