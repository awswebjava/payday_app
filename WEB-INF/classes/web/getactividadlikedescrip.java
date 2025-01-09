package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactividadlikedescrip extends GXProcedure
{
   public getactividadlikedescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactividadlikedescrip.class ), "" );
   }

   public getactividadlikedescrip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getactividadlikedescrip.this.aP2 = new boolean[] {false};
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
      getactividadlikedescrip.this.AV9ActDescrip = aP0;
      getactividadlikedescrip.this.aP1 = aP1;
      getactividadlikedescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      lV9ActDescrip = GXutil.concat( GXutil.rtrim( AV9ActDescrip), "%", "") ;
      /* Using cursor P00MB2 */
      pr_default.execute(0, new Object[] {lV9ActDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A683ActDescripSinAc = P00MB2_A683ActDescripSinAc[0] ;
         A43ActCodigo = P00MB2_A43ActCodigo[0] ;
         AV8ActCodigo = A43ActCodigo ;
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
      this.aP1[0] = getactividadlikedescrip.this.AV8ActCodigo;
      this.aP2[0] = getactividadlikedescrip.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ActCodigo = "" ;
      lV9ActDescrip = "" ;
      scmdbuf = "" ;
      P00MB2_A683ActDescripSinAc = new String[] {""} ;
      P00MB2_A43ActCodigo = new String[] {""} ;
      A683ActDescripSinAc = "" ;
      A43ActCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactividadlikedescrip__default(),
         new Object[] {
             new Object[] {
            P00MB2_A683ActDescripSinAc, P00MB2_A43ActCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ActCodigo ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private boolean AV11existe ;
   private String AV9ActDescrip ;
   private String lV9ActDescrip ;
   private String A683ActDescripSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00MB2_A683ActDescripSinAc ;
   private String[] P00MB2_A43ActCodigo ;
}

final  class getactividadlikedescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MB2", "SELECT ActDescripSinAc, ActCodigo FROM Actividad WHERE ActDescripSinAc like '%' || ? ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
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
               stmt.setVarchar(1, (String)parms[0], 150);
               return;
      }
   }

}

