package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obligacionconceptos extends GXProcedure
{
   public obligacionconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacionconceptos.class ), "" );
   }

   public obligacionconceptos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 )
   {
      obligacionconceptos.this.aP2 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<String>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<String>[] aP2 )
   {
      obligacionconceptos.this.AV9CliCod = aP0;
      obligacionconceptos.this.AV8TipoOblSec = aP1;
      obligacionconceptos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02CH2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8TipoOblSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1163TipoOblSec = P02CH2_A1163TipoOblSec[0] ;
         A1164TipoOblCodigo = P02CH2_A1164TipoOblCodigo[0] ;
         GXv_objcol_char1[0] = AV10ConCodigo ;
         new web.devuelveconceptosdeformula(remoteHandle, context).execute( AV9CliCod, httpContext.getMessage( "{obligacion ", "")+GXutil.trim( A1164TipoOblCodigo)+"}", GXv_objcol_char1) ;
         AV10ConCodigo = GXv_objcol_char1[0] ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = obligacionconceptos.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P02CH2_A1163TipoOblSec = new short[1] ;
      P02CH2_A1164TipoOblCodigo = new String[] {""} ;
      A1164TipoOblCodigo = "" ;
      GXv_objcol_char1 = new GXSimpleCollection[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacionconceptos__default(),
         new Object[] {
             new Object[] {
            P02CH2_A1163TipoOblSec, P02CH2_A1164TipoOblCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8TipoOblSec ;
   private short A1163TipoOblSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private String scmdbuf ;
   private String A1164TipoOblCodigo ;
   private GXSimpleCollection<String>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02CH2_A1163TipoOblSec ;
   private String[] P02CH2_A1164TipoOblCodigo ;
   private GXSimpleCollection<String> AV10ConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char1[] ;
}

final  class obligacionconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CH2", "SELECT TipoOblSec, TipoOblCodigo FROM tipo_obligacion WHERE TipoOblSec = ? ORDER BY TipoOblSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

