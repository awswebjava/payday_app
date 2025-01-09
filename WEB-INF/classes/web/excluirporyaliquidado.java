package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class excluirporyaliquidado extends GXProcedure
{
   public excluirporyaliquidado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( excluirporyaliquidado.class ), "" );
   }

   public excluirporyaliquidado( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              String aP5 ,
                              String aP6 )
   {
      excluirporyaliquidado.this.aP7 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean[] aP7 )
   {
      excluirporyaliquidado.this.AV8CliCod = aP0;
      excluirporyaliquidado.this.AV10EmpCod = aP1;
      excluirporyaliquidado.this.AV11LiqNro = aP2;
      excluirporyaliquidado.this.AV13LegNumero = aP3;
      excluirporyaliquidado.this.AV12LiqPeriodo = aP4;
      excluirporyaliquidado.this.AV14ProcesoLiquidacion = aP5;
      excluirporyaliquidado.this.AV9ConCondicion = aP6;
      excluirporyaliquidado.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P026S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCondicion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A150ConHabilitado = P026S2_A150ConHabilitado[0] ;
         A953ConCondicion = P026S2_A953ConCondicion[0] ;
         n953ConCondicion = P026S2_n953ConCondicion[0] ;
         A3CliCod = P026S2_A3CliCod[0] ;
         A26ConCodigo = P026S2_A26ConCodigo[0] ;
         GXv_boolean1[0] = AV15excluir ;
         new web.getliqdimpcalcu_periodoliqant2(remoteHandle, context).execute( AV8CliCod, AV10EmpCod, AV11LiqNro, AV13LegNumero, AV12LiqPeriodo, A26ConCodigo, GXv_boolean1) ;
         excluirporyaliquidado.this.AV15excluir = GXv_boolean1[0] ;
         if ( AV15excluir )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = excluirporyaliquidado.this.AV15excluir;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P026S2_A150ConHabilitado = new boolean[] {false} ;
      P026S2_A953ConCondicion = new String[] {""} ;
      P026S2_n953ConCondicion = new boolean[] {false} ;
      P026S2_A3CliCod = new int[1] ;
      P026S2_A26ConCodigo = new String[] {""} ;
      A953ConCondicion = "" ;
      A26ConCodigo = "" ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.excluirporyaliquidado__default(),
         new Object[] {
             new Object[] {
            P026S2_A150ConHabilitado, P026S2_A953ConCondicion, P026S2_n953ConCondicion, P026S2_A3CliCod, P026S2_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private String AV14ProcesoLiquidacion ;
   private String AV9ConCondicion ;
   private String scmdbuf ;
   private String A953ConCondicion ;
   private String A26ConCodigo ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV15excluir ;
   private boolean A150ConHabilitado ;
   private boolean n953ConCondicion ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P026S2_A150ConHabilitado ;
   private String[] P026S2_A953ConCondicion ;
   private boolean[] P026S2_n953ConCondicion ;
   private int[] P026S2_A3CliCod ;
   private String[] P026S2_A26ConCodigo ;
}

final  class excluirporyaliquidado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026S2", "SELECT ConHabilitado, ConCondicion, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConCondicion = ( ?)) AND (ConHabilitado = TRUE) ORDER BY CliCod, ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

