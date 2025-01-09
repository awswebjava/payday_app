package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getzonalikedescrip extends GXProcedure
{
   public getzonalikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getzonalikedescrip.class ), "" );
   }

   public getzonalikedescrip( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getzonalikedescrip.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getzonalikedescrip.this.AV10ZonDescrip = aP0;
      getzonalikedescrip.this.aP1 = aP1;
      getzonalikedescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV10ZonDescrip = GXutil.concat( GXutil.rtrim( AV10ZonDescrip), "%", "") ;
      /* Using cursor P00MD2 */
      pr_default.execute(0, new Object[] {lV10ZonDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A678ZonDescripSinAc = P00MD2_A678ZonDescripSinAc[0] ;
         A20ZonCod = P00MD2_A20ZonCod[0] ;
         AV9ZonCod = A20ZonCod ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getzonalikedescrip.this.AV9ZonCod;
      this.aP2[0] = getzonalikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ZonCod = "" ;
      lV10ZonDescrip = "" ;
      scmdbuf = "" ;
      P00MD2_A678ZonDescripSinAc = new String[] {""} ;
      P00MD2_A20ZonCod = new String[] {""} ;
      A678ZonDescripSinAc = "" ;
      A20ZonCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getzonalikedescrip__default(),
         new Object[] {
             new Object[] {
            P00MD2_A678ZonDescripSinAc, P00MD2_A20ZonCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9ZonCod ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private boolean AV11existe ;
   private String AV10ZonDescrip ;
   private String lV10ZonDescrip ;
   private String A678ZonDescripSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MD2_A678ZonDescripSinAc ;
   private String[] P00MD2_A20ZonCod ;
}

final  class getzonalikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MD2", "SELECT ZonDescripSinAc, ZonCod FROM Zona WHERE ZonDescripSinAc like '%' || ? ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}
