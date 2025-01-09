package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getadicionalreservado extends GXProcedure
{
   public getadicionalreservado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getadicionalreservado.class ), "" );
   }

   public getadicionalreservado( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      getadicionalreservado.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getadicionalreservado.this.AV8PaiCod = aP0;
      getadicionalreservado.this.AV9AdicionalReservado = aP1;
      getadicionalreservado.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MJ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9AdicionalReservado});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1784AdicionalReservado = P01MJ2_A1784AdicionalReservado[0] ;
         A46PaiCod = P01MJ2_A46PaiCod[0] ;
         A988AdicionalCod = P01MJ2_A988AdicionalCod[0] ;
         AV10AdicionalCod = A988AdicionalCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getadicionalreservado.this.AV10AdicionalCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10AdicionalCod = "" ;
      scmdbuf = "" ;
      P01MJ2_A1784AdicionalReservado = new String[] {""} ;
      P01MJ2_A46PaiCod = new short[1] ;
      P01MJ2_A988AdicionalCod = new String[] {""} ;
      A1784AdicionalReservado = "" ;
      A988AdicionalCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getadicionalreservado__default(),
         new Object[] {
             new Object[] {
            P01MJ2_A1784AdicionalReservado, P01MJ2_A46PaiCod, P01MJ2_A988AdicionalCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9AdicionalReservado ;
   private String AV10AdicionalCod ;
   private String scmdbuf ;
   private String A1784AdicionalReservado ;
   private String A988AdicionalCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MJ2_A1784AdicionalReservado ;
   private short[] P01MJ2_A46PaiCod ;
   private String[] P01MJ2_A988AdicionalCod ;
}

final  class getadicionalreservado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MJ2", "SELECT AdicionalReservado, PaiCod, AdicionalCod FROM Adicional WHERE (PaiCod = ?) AND (AdicionalReservado = ( ?)) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

