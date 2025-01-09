package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqbatcherror extends GXProcedure
{
   public getliqbatcherror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqbatcherror.class ), "" );
   }

   public getliqbatcherror( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      getliqbatcherror.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getliqbatcherror.this.AV11CliCod = aP0;
      getliqbatcherror.this.AV10EmpCod = aP1;
      getliqbatcherror.this.AV9LiqBatchLiqNro = aP2;
      getliqbatcherror.this.AV8LiqBatchSeccion = aP3;
      getliqbatcherror.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02K72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LiqBatchLiqNro), AV8LiqBatchSeccion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2K72 = false ;
         A3CliCod = P02K72_A3CliCod[0] ;
         A1EmpCod = P02K72_A1EmpCod[0] ;
         A2371LiqBatchLiqNro = P02K72_A2371LiqBatchLiqNro[0] ;
         A2373LiqBatchSeccion = P02K72_A2373LiqBatchSeccion[0] ;
         A2375LiqBatchError = P02K72_A2375LiqBatchError[0] ;
         A2372LiqBatchCod = P02K72_A2372LiqBatchCod[0] ;
         AV12LiqBatchError += A2375LiqBatchError + " ." ;
         while ( (pr_default.getStatus(0) != 101) && ( P02K72_A3CliCod[0] == A3CliCod ) && ( P02K72_A1EmpCod[0] == A1EmpCod ) && ( P02K72_A2371LiqBatchLiqNro[0] == A2371LiqBatchLiqNro ) && ( GXutil.strcmp(P02K72_A2373LiqBatchSeccion[0], A2373LiqBatchSeccion) == 0 ) )
         {
            if ( ! ( ( GXutil.strcmp(P02K72_A2375LiqBatchError[0], A2375LiqBatchError) == 0 ) ) )
            {
               if (true) break;
            }
            brk2K72 = false ;
            A2372LiqBatchCod = P02K72_A2372LiqBatchCod[0] ;
            brk2K72 = true ;
            pr_default.readNext(0);
         }
         if ( ! brk2K72 )
         {
            brk2K72 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getliqbatcherror.this.AV12LiqBatchError;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqBatchError = "" ;
      scmdbuf = "" ;
      P02K72_A3CliCod = new int[1] ;
      P02K72_A1EmpCod = new short[1] ;
      P02K72_A2371LiqBatchLiqNro = new int[1] ;
      P02K72_A2373LiqBatchSeccion = new String[] {""} ;
      P02K72_A2375LiqBatchError = new String[] {""} ;
      P02K72_A2372LiqBatchCod = new String[] {""} ;
      A2373LiqBatchSeccion = "" ;
      A2375LiqBatchError = "" ;
      A2372LiqBatchCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqbatcherror__default(),
         new Object[] {
             new Object[] {
            P02K72_A3CliCod, P02K72_A1EmpCod, P02K72_A2371LiqBatchLiqNro, P02K72_A2373LiqBatchSeccion, P02K72_A2375LiqBatchError, P02K72_A2372LiqBatchCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqBatchLiqNro ;
   private int A3CliCod ;
   private int A2371LiqBatchLiqNro ;
   private String AV8LiqBatchSeccion ;
   private String scmdbuf ;
   private String A2373LiqBatchSeccion ;
   private boolean brk2K72 ;
   private String AV12LiqBatchError ;
   private String A2375LiqBatchError ;
   private String A2372LiqBatchCod ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02K72_A3CliCod ;
   private short[] P02K72_A1EmpCod ;
   private int[] P02K72_A2371LiqBatchLiqNro ;
   private String[] P02K72_A2373LiqBatchSeccion ;
   private String[] P02K72_A2375LiqBatchError ;
   private String[] P02K72_A2372LiqBatchCod ;
}

final  class getliqbatcherror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02K72", "SELECT CliCod, EmpCod, LiqBatchLiqNro, LiqBatchSeccion, LiqBatchError, LiqBatchCod FROM LiquidacionLotes3 WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchSeccion = ( ?) ORDER BY CliCod, EmpCod, LiqBatchLiqNro, LiqBatchSeccion, LiqBatchError ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

