package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getactividadpordescrip extends GXProcedure
{
   public getactividadpordescrip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getactividadpordescrip.class ), "" );
   }

   public getactividadpordescrip( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getactividadpordescrip.this.aP2 = new boolean[] {false};
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
      getactividadpordescrip.this.AV9ActDescrip = aP0;
      getactividadpordescrip.this.aP1 = aP1;
      getactividadpordescrip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&ActDescrip ", "")+AV9ActDescrip) ;
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P002J2 */
      pr_default.execute(0, new Object[] {AV9ActDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A683ActDescripSinAc = P002J2_A683ActDescripSinAc[0] ;
         A43ActCodigo = P002J2_A43ActCodigo[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV8ActCodigo = A43ActCodigo ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getactividadpordescrip.this.AV8ActCodigo;
      this.aP2[0] = getactividadpordescrip.this.AV11existe;
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
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      P002J2_A683ActDescripSinAc = new String[] {""} ;
      P002J2_A43ActCodigo = new String[] {""} ;
      A683ActDescripSinAc = "" ;
      A43ActCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getactividadpordescrip__default(),
         new Object[] {
             new Object[] {
            P002J2_A683ActDescripSinAc, P002J2_A43ActCodigo
            }
         }
      );
      AV14Pgmname = "getActividadPorDescrip" ;
      /* GeneXus formulas. */
      AV14Pgmname = "getActividadPorDescrip" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private short Gx_err ;
   private String AV8ActCodigo ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private boolean AV11existe ;
   private String AV9ActDescrip ;
   private String A683ActDescripSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002J2_A683ActDescripSinAc ;
   private String[] P002J2_A43ActCodigo ;
}

final  class getactividadpordescrip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002J2", "SELECT ActDescripSinAc, ActCodigo FROM Actividad WHERE ActDescripSinAc = ( ?) ORDER BY ActCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

