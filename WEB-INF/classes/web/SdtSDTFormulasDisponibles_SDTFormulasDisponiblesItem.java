package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem extends GxUserType
{
   public SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( )
   {
      this(  new ModelContext(SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem.class));
   }

   public SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( ModelContext context )
   {
      super( context, "SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem");
   }

   public SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( int remoteHandle ,
                                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem");
   }

   public SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem( StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Formula") )
            {
               gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Titulo") )
            {
               gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TituloReducido") )
            {
               gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "simple") )
            {
               gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "entidad") )
            {
               gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad = oReader.getValue() ;
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
         sName = "SDTFormulasDisponibles.SDTFormulasDisponiblesItem" ;
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
      oWriter.writeElement("Formula", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Titulo", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TituloReducido", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("simple", GXutil.booltostr( gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("entidad", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad);
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
      AddObjectProperty("Formula", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula, false, false);
      AddObjectProperty("Titulo", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo, false, false);
      AddObjectProperty("TituloReducido", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido, false, false);
      AddObjectProperty("simple", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple, false, false);
      AddObjectProperty("entidad", gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad, false, false);
   }

   public String getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula ;
   }

   public void setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula = value ;
   }

   public String getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo ;
   }

   public void setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo = value ;
   }

   public String getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido ;
   }

   public void setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido = value ;
   }

   public boolean getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple ;
   }

   public void setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple( boolean value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple = value ;
   }

   public String getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad ;
   }

   public void setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad( String value )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(0) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N = (byte)(1) ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido = "" ;
      gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N ;
   }

   public web.SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem Clone( )
   {
      return (web.SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem struct )
   {
      setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula(struct.getFormula());
      setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo(struct.getTitulo());
      setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido(struct.getTituloreducido());
      setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple(struct.getSimple());
      setgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad(struct.getEntidad());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem getStruct( )
   {
      web.StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem struct = new web.StructSdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem ();
      struct.setFormula(getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula());
      struct.setTitulo(getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo());
      struct.setTituloreducido(getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido());
      struct.setSimple(getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple());
      struct.setEntidad(getgxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad());
      return struct ;
   }

   protected byte gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Entidad ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Simple ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Formula ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Titulo ;
   protected String gxTv_SdtSDTFormulasDisponibles_SDTFormulasDisponiblesItem_Tituloreducido ;
}

