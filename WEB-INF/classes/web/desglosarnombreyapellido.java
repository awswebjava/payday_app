package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class desglosarnombreyapellido extends GXProcedure
{
   public desglosarnombreyapellido( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( desglosarnombreyapellido.class ), "" );
   }

   public desglosarnombreyapellido( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 )
   {
      desglosarnombreyapellido.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      desglosarnombreyapellido.this.AV11nombreYApellido = aP0;
      desglosarnombreyapellido.this.aP1 = aP1;
      desglosarnombreyapellido.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9LegNombre = "" ;
      AV10splitNombres = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV11nombreYApellido," ")) ;
      AV12i = (short)(1) ;
      while ( AV12i <= AV10splitNombres.size() )
      {
         if ( AV12i == 1 )
         {
            AV8LegApellido = (String)AV10splitNombres.elementAt(-1+AV12i) + " " ;
         }
         else
         {
            AV9LegNombre += (String)AV10splitNombres.elementAt(-1+AV12i) ;
            if ( AV12i != AV10splitNombres.size() )
            {
               AV9LegNombre += " " ;
            }
         }
         AV12i = (short)(AV12i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = desglosarnombreyapellido.this.AV9LegNombre;
      this.aP2[0] = desglosarnombreyapellido.this.AV8LegApellido;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9LegNombre = "" ;
      AV8LegApellido = "" ;
      AV10splitNombres = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12i ;
   private short Gx_err ;
   private String AV11nombreYApellido ;
   private String AV9LegNombre ;
   private String AV8LegApellido ;
   private String[] aP2 ;
   private String[] aP1 ;
   private GXSimpleCollection<String> AV10splitNombres ;
}

