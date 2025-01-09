package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondsegpla extends GXProcedure
{
   public getcondsegpla( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondsegpla.class ), "" );
   }

   public getcondsegpla( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( String aP0 )
   {
      getcondsegpla.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             byte[] aP1 )
   {
      getcondsegpla.this.AV9ConCondicion = aP0;
      getcondsegpla.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MS2 */
      pr_default.execute(0, new Object[] {AV9ConCondicion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A953ConCondicion = P01MS2_A953ConCondicion[0] ;
         A1786CondSegPla = P01MS2_A1786CondSegPla[0] ;
         AV8CondSegPla = A1786CondSegPla ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcondsegpla.this.AV8CondSegPla;
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
      P01MS2_A953ConCondicion = new String[] {""} ;
      P01MS2_A1786CondSegPla = new byte[1] ;
      A953ConCondicion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondsegpla__default(),
         new Object[] {
             new Object[] {
            P01MS2_A953ConCondicion, P01MS2_A1786CondSegPla
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8CondSegPla ;
   private byte A1786CondSegPla ;
   private short Gx_err ;
   private String AV9ConCondicion ;
   private String scmdbuf ;
   private String A953ConCondicion ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MS2_A953ConCondicion ;
   private byte[] P01MS2_A1786CondSegPla ;
}

final  class getcondsegpla__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MS2", "SELECT ConCondicion, CondSegPla FROM Condiciones_concepto WHERE ConCondicion = ( ?) ORDER BY ConCondicion ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

