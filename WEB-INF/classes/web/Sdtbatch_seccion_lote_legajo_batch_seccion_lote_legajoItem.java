package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem extends GxUserType
{
   public Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( )
   {
      this(  new ModelContext(Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem.class));
   }

   public Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( ModelContext context )
   {
      super( context, "Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem");
   }

   public Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( int remoteHandle ,
                                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem");
   }

   public Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem( StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqBatchSeccion") )
            {
               gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqBatchCod") )
            {
               gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqBatchLegNro") )
            {
               gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "batch_seccion_lote_legajo.batch_seccion_lote_legajoItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("LiqBatchSeccion", gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqBatchCod", gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqBatchLegNro", GXutil.trim( GXutil.str( gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("LiqBatchSeccion", gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion, false, false);
      AddObjectProperty("LiqBatchCod", gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod, false, false);
      AddObjectProperty("LiqBatchLegNro", gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro, false, false);
   }

   public String getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion ;
   }

   public void setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion( String value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion = value ;
   }

   public String getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod ;
   }

   public void setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod( String value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod = value ;
   }

   public int getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro ;
   }

   public void setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro( int value )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(0) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion = "" ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N = (byte)(1) ;
      gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N ;
   }

   public web.Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem Clone( )
   {
      return (web.Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem struct )
   {
      setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion(struct.getLiqbatchseccion());
      setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod(struct.getLiqbatchcod());
      setgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro(struct.getLiqbatchlegnro());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem getStruct( )
   {
      web.StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem struct = new web.StructSdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem ();
      struct.setLiqbatchseccion(getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion());
      struct.setLiqbatchcod(getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod());
      struct.setLiqbatchlegnro(getgxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro());
      return struct ;
   }

   protected byte gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchlegnro ;
   protected String gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchseccion ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtbatch_seccion_lote_legajo_batch_seccion_lote_legajoItem_Liqbatchcod ;
}

