package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem extends GxUserType
{
   public Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( )
   {
      this(  new ModelContext(Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem.class));
   }

   public Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( ModelContext context )
   {
      super( context, "Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem");
   }

   public Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem");
   }

   public Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem( StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CUIL") )
            {
               gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Apellido") )
            {
               gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nombre") )
            {
               gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre = oReader.getValue() ;
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
         sName = "sdt_AuxScrapeados.sdt_AuxScrapeadosItem" ;
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
      oWriter.writeElement("CUIL", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Apellido", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Nombre", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("CUIL", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil, false, false);
      AddObjectProperty("Apellido", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido, false, false);
      AddObjectProperty("Nombre", gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre, false, false);
   }

   public String getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil ;
   }

   public void setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil = value ;
   }

   public String getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido ;
   }

   public void setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido = value ;
   }

   public String getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre ;
   }

   public void setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre( String value )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil = "" ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido = "" ;
      gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N ;
   }

   public web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem Clone( )
   {
      return (web.Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem struct )
   {
      setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil(struct.getCuil());
      setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido(struct.getApellido());
      setgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre(struct.getNombre());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem getStruct( )
   {
      web.StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem struct = new web.StructSdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem ();
      struct.setCuil(getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil());
      struct.setApellido(getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido());
      struct.setNombre(getgxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Cuil ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Apellido ;
   protected String gxTv_Sdtsdt_AuxScrapeados_sdt_AuxScrapeadosItem_Nombre ;
}

