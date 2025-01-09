package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_autoConcepto_sdt_autoConceptoItem extends GxUserType
{
   public Sdtsdt_autoConcepto_sdt_autoConceptoItem( )
   {
      this(  new ModelContext(Sdtsdt_autoConcepto_sdt_autoConceptoItem.class));
   }

   public Sdtsdt_autoConcepto_sdt_autoConceptoItem( ModelContext context )
   {
      super( context, "Sdtsdt_autoConcepto_sdt_autoConceptoItem");
   }

   public Sdtsdt_autoConcepto_sdt_autoConceptoItem( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_autoConcepto_sdt_autoConceptoItem");
   }

   public Sdtsdt_autoConcepto_sdt_autoConceptoItem( StructSdtsdt_autoConcepto_sdt_autoConceptoItem struct )
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
               gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrdEjec") )
            {
               gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrden") )
            {
               gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdt_autoConcepto.sdt_autoConceptoItem" ;
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
      oWriter.writeElement("ConCodigo", gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrdEjec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrden", GXutil.trim( GXutil.str( gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden, 8, 0)));
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
      AddObjectProperty("ConCodigo", gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo, false, false);
      AddObjectProperty("ConOrdEjec", gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec, false, false);
      AddObjectProperty("ConOrden", gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden, false, false);
   }

   public String getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo ;
   }

   public void setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo( String value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo = value ;
   }

   public long getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec ;
   }

   public void setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec( long value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec = value ;
   }

   public int getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden ;
   }

   public void setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden( int value )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo = "" ;
      gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N ;
   }

   public web.Sdtsdt_autoConcepto_sdt_autoConceptoItem Clone( )
   {
      return (web.Sdtsdt_autoConcepto_sdt_autoConceptoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_autoConcepto_sdt_autoConceptoItem struct )
   {
      setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo(struct.getConcodigo());
      setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec(struct.getConordejec());
      setgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden(struct.getConorden());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_autoConcepto_sdt_autoConceptoItem getStruct( )
   {
      web.StructSdtsdt_autoConcepto_sdt_autoConceptoItem struct = new web.StructSdtsdt_autoConcepto_sdt_autoConceptoItem ();
      struct.setConcodigo(getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo());
      struct.setConordejec(getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec());
      struct.setConorden(getgxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conorden ;
   protected long gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Conordejec ;
   protected String gxTv_Sdtsdt_autoConcepto_sdt_autoConceptoItem_Concodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

