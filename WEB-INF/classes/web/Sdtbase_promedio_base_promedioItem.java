package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbase_promedio_base_promedioItem extends GxUserType
{
   public Sdtbase_promedio_base_promedioItem( )
   {
      this(  new ModelContext(Sdtbase_promedio_base_promedioItem.class));
   }

   public Sdtbase_promedio_base_promedioItem( ModelContext context )
   {
      super( context, "Sdtbase_promedio_base_promedioItem");
   }

   public Sdtbase_promedio_base_promedioItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtbase_promedio_base_promedioItem");
   }

   public Sdtbase_promedio_base_promedioItem( StructSdtbase_promedio_base_promedioItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoTipo") )
            {
               gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fijo_variable") )
            {
               gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "chequearHabitual") )
            {
               gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Conceptos") )
            {
               if ( gxTv_Sdtbase_promedio_base_promedioItem_Conceptos == null )
               {
                  gxTv_Sdtbase_promedio_base_promedioItem_Conceptos = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem>(web.Sdtbase_promedio_base_promedioItem_ConceptosItem.class, "base_promedio.base_promedioItem.ConceptosItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtbase_promedio_base_promedioItem_Conceptos.readxmlcollection(oReader, "Conceptos", "ConceptosItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Conceptos") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "base_promedio.base_promedioItem" ;
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
      oWriter.writeElement("ConceptoTipo", gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("fijo_variable", gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("chequearHabitual", GXutil.booltostr( gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtbase_promedio_base_promedioItem_Conceptos != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtbase_promedio_base_promedioItem_Conceptos.writexmlcollection(oWriter, "Conceptos", sNameSpace1, "ConceptosItem", sNameSpace1);
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
      AddObjectProperty("ConceptoTipo", gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo, false, false);
      AddObjectProperty("fijo_variable", gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable, false, false);
      AddObjectProperty("chequearHabitual", gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual, false, false);
      if ( gxTv_Sdtbase_promedio_base_promedioItem_Conceptos != null )
      {
         AddObjectProperty("Conceptos", gxTv_Sdtbase_promedio_base_promedioItem_Conceptos, false, false);
      }
   }

   public String getgxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo = value ;
   }

   public String getgxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable( String value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable = value ;
   }

   public boolean getgxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual( boolean value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual = value ;
   }

   public GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem> getgxTv_Sdtbase_promedio_base_promedioItem_Conceptos( )
   {
      if ( gxTv_Sdtbase_promedio_base_promedioItem_Conceptos == null )
      {
         gxTv_Sdtbase_promedio_base_promedioItem_Conceptos = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem>(web.Sdtbase_promedio_base_promedioItem_ConceptosItem.class, "base_promedio.base_promedioItem.ConceptosItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      return gxTv_Sdtbase_promedio_base_promedioItem_Conceptos ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_Conceptos( GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem> value )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(0) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos = value ;
   }

   public void setgxTv_Sdtbase_promedio_base_promedioItem_Conceptos_SetNull( )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(1) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos = null ;
   }

   public boolean getgxTv_Sdtbase_promedio_base_promedioItem_Conceptos_IsNull( )
   {
      if ( gxTv_Sdtbase_promedio_base_promedioItem_Conceptos == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo = "" ;
      gxTv_Sdtbase_promedio_base_promedioItem_N = (byte)(1) ;
      gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable = "" ;
      gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbase_promedio_base_promedioItem_N ;
   }

   public web.Sdtbase_promedio_base_promedioItem Clone( )
   {
      return (web.Sdtbase_promedio_base_promedioItem)(clone()) ;
   }

   public void setStruct( web.StructSdtbase_promedio_base_promedioItem struct )
   {
      setgxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo(struct.getConceptotipo());
      setgxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable(struct.getFijo_variable());
      setgxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual(struct.getChequearhabitual());
      GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem> gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux = new GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem>(web.Sdtbase_promedio_base_promedioItem_ConceptosItem.class, "base_promedio.base_promedioItem.ConceptosItem", "PayDay", remoteHandle);
      Vector<web.StructSdtbase_promedio_base_promedioItem_ConceptosItem> gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux1 = struct.getConceptos();
      if (gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux1.size(); i++)
         {
            gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux.add(new web.Sdtbase_promedio_base_promedioItem_ConceptosItem(gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtbase_promedio_base_promedioItem_Conceptos(gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbase_promedio_base_promedioItem getStruct( )
   {
      web.StructSdtbase_promedio_base_promedioItem struct = new web.StructSdtbase_promedio_base_promedioItem ();
      struct.setConceptotipo(getgxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo());
      struct.setFijo_variable(getgxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable());
      struct.setChequearhabitual(getgxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual());
      struct.setConceptos(getgxTv_Sdtbase_promedio_base_promedioItem_Conceptos().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtbase_promedio_base_promedioItem_N ;
   protected byte gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_Conceptotipo ;
   protected String gxTv_Sdtbase_promedio_base_promedioItem_Fijo_variable ;
   protected String sTagName ;
   protected boolean gxTv_Sdtbase_promedio_base_promedioItem_Chequearhabitual ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem> gxTv_Sdtbase_promedio_base_promedioItem_Conceptos_aux ;
   protected GXBaseCollection<web.Sdtbase_promedio_base_promedioItem_ConceptosItem> gxTv_Sdtbase_promedio_base_promedioItem_Conceptos=null ;
}

