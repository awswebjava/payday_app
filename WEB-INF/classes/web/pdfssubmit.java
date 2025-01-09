package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pdfssubmit extends GXProcedure
{
   public pdfssubmit( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pdfssubmit.class ), "" );
   }

   public pdfssubmit( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 )
   {
      pdfssubmit.this.AV10CliCod = aP0;
      pdfssubmit.this.AV11EmpCod = aP1;
      pdfssubmit.this.AV13LiqNro = aP2;
      pdfssubmit.this.AV12LegNumero = aP3;
      pdfssubmit.this.AV16ClientId = aP4;
      pdfssubmit.this.AV17LiqLote = aP5;
      pdfssubmit.this.AV23forzar1Lote = aP6;
      pdfssubmit.this.AV36daemonUUID = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      callSubmit( 1 , new Object[]{ Integer.valueOf(AV10CliCod),Short.valueOf(AV11EmpCod),Integer.valueOf(AV13LiqNro),AV12LegNumero,AV16ClientId,AV17LiqLote,AV36daemonUUID });
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submit( int submitId ,
                       Object [] submitParms ,
                       ModelContext submitContext )
   {
      UserInformation submitUI = (UserInformation) GXObjectHelper.getUserInformation(context, -1);
      int remoteHandle = submitUI.getHandle();
      try
      {
         switch ( submitId )
         {
               case 1 :
                  new web.procesossegundoplanopdf(remoteHandle, submitContext).execute( ((Number) submitParms[0]).intValue(), ((Number) submitParms[1]).shortValue(), ((Number) submitParms[2]).intValue(), (GXSimpleCollection<Integer>)submitParms[3], (String)submitParms[4], (String)submitParms[5], (String)submitParms[6]) ;
                  try { Application.getConnectionManager().disconnect(remoteHandle); } catch(Exception submitExc) { ; }
                  break;
         }
      }
      catch ( Exception e )
      {
         Application.cleanupConnection(remoteHandle);
         e.printStackTrace();
      }
   }

   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13LiqNro ;
   private String AV36daemonUUID ;
   private boolean AV23forzar1Lote ;
   private String AV16ClientId ;
   private String AV17LiqLote ;
   private GXSimpleCollection<Integer> AV12LegNumero ;
}

