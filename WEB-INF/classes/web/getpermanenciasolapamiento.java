package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpermanenciasolapamiento extends GXProcedure
{
   public getpermanenciasolapamiento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpermanenciasolapamiento.class ), "" );
   }

   public getpermanenciasolapamiento( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 )
   {
      getpermanenciasolapamiento.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             boolean[] aP6 )
   {
      getpermanenciasolapamiento.this.AV13CliCod = aP0;
      getpermanenciasolapamiento.this.AV12EmpCod = aP1;
      getpermanenciasolapamiento.this.AV8LegNumero = aP2;
      getpermanenciasolapamiento.this.AV9LegHisFecIng = aP3;
      getpermanenciasolapamiento.this.AV14parmLegHisFecEgr = aP4;
      getpermanenciasolapamiento.this.AV15propiaLegHisFecIng = aP5;
      getpermanenciasolapamiento.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14parmLegHisFecEgr)) )
      {
         AV10LegHisFecEgr = localUtil.ymdtod( 9999, 12, 31) ;
      }
      else
      {
         AV10LegHisFecEgr = AV14parmLegHisFecEgr ;
      }
      /* Using cursor P02922 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV8LegNumero), AV9LegHisFecIng, AV10LegHisFecEgr});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2254LegHisFecEgr = P02922_A2254LegHisFecEgr[0] ;
         A2253LegHisFecIng = P02922_A2253LegHisFecIng[0] ;
         A6LegNumero = P02922_A6LegNumero[0] ;
         A1EmpCod = P02922_A1EmpCod[0] ;
         A3CliCod = P02922_A3CliCod[0] ;
         AV16validar = false ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A2254LegHisFecEgr)) )
         {
            AV16validar = true ;
         }
         else
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(A2253LegHisFecIng), GXutil.resetTime(AV15propiaLegHisFecIng)) ) )
            {
               AV16validar = true ;
            }
         }
         if ( AV16validar )
         {
            AV11existe = true ;
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
      this.aP6[0] = getpermanenciasolapamiento.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LegHisFecEgr = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02922_A2254LegHisFecEgr = new java.util.Date[] {GXutil.nullDate()} ;
      P02922_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02922_A6LegNumero = new int[1] ;
      P02922_A1EmpCod = new short[1] ;
      P02922_A3CliCod = new int[1] ;
      A2254LegHisFecEgr = GXutil.nullDate() ;
      A2253LegHisFecIng = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpermanenciasolapamiento__default(),
         new Object[] {
             new Object[] {
            P02922_A2254LegHisFecEgr, P02922_A2253LegHisFecIng, P02922_A6LegNumero, P02922_A1EmpCod, P02922_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV9LegHisFecIng ;
   private java.util.Date AV14parmLegHisFecEgr ;
   private java.util.Date AV15propiaLegHisFecIng ;
   private java.util.Date AV10LegHisFecEgr ;
   private java.util.Date A2254LegHisFecEgr ;
   private java.util.Date A2253LegHisFecIng ;
   private boolean AV11existe ;
   private boolean AV16validar ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02922_A2254LegHisFecEgr ;
   private java.util.Date[] P02922_A2253LegHisFecIng ;
   private int[] P02922_A6LegNumero ;
   private short[] P02922_A1EmpCod ;
   private int[] P02922_A3CliCod ;
}

final  class getpermanenciasolapamiento__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02922", "SELECT LegHisFecEgr, LegHisFecIng, LegNumero, EmpCod, CliCod FROM legajo_permanencia WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegHisFecEgr >= ? or (LegHisFecEgr = DATE '00010101') or LegHisFecEgr IS NULL) AND (LegHisFecIng <= ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

