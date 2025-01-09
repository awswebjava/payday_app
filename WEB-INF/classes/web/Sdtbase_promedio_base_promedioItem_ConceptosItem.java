package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbase_promedio_base_promedioItem_ConceptosItem extends GxUserType
{
   public Sdtbase_promedio_base_promedioItem_ConceptosItem( )
   {
      this(  new ModelContext(Sdtbase_promedio_base_promedioItem_ConceptosItem.class));
   }

   public Sdtbase_promedio_base_promedioItem_ConceptosItem( ModelContext context )
   {
      super( context, "Sdtbase_promedio_base_promedioItem_ConceptosItem");
   }

   public Sdtbase_promedio_base_promedioItem_ConceptosItem( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtbase_promedio_base_promedioItem_ConceptosItem");
   }

   public Sdtbase_promedio_base_promedioItem_ConceptosItem( StructSdtbase_promedio_base_promedioItem_ConceptosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo = oReader.getValue() ;
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
         sName = "base_promedio.base_promedioItem.ConceptosItem" ;
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
      oWriter.writeElement("ConCodigo", gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo);
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
      AddObjectProperty("ConCodigo", gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo, false, false);
   }

   public String getgxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo = "" ;
      gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N ;
   }

   public web.Sdtbase_promedio_base_promedioItem_ConceptosItem Clone( )
   {
      return (web.Sdtbase_promedio_base_promedioItem_ConceptosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtbase_promedio_base_promedioItem_ConceptosItem struct )
   {
      setgxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo(struct.getConcodigo());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbase_promedio_base_promedioItem_ConceptosItem getStruct( )
   {
      web.StructSdtbase_promedio_base_promedioItem_ConceptosItem struct = new web.StructSdtbase_promedio_base_promedioItem_ConceptosItem ();
      struct.setConcodigo(getgxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo());
      return struct ;
   }

   protected byte gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_ConceptosItem_Concodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

